package com.delegate.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.algorithm.comparefacade.impl.OptimizedAndOtherAlgorithmsCompareFacadeImpl;
import com.delegate.inter.RoutingCustomDelegateIF;
import com.dropsapppro.model.DownloadAlgorithmicStorage;
import com.dropsapppro.repository.BestRouteDetailsRepository;
import com.dropsapppro.repository.BestRouteReplicaDetailsRepository;
import com.dropsapppro.repository.CompareAlgoResultsRepository;
import com.dropsapppro.repository.CompareFileSizeRepository;
import com.dropsapppro.repository.DownloadAlgorithmStorageRepository;
import com.dropsapppro.repository.FileChunkStorageRepository;
import com.dropsapppro.repository.FileEncStorageLiteRepository;
import com.dropsapppro.repository.FileEncStorageRepository;
import com.dropsapppro.repository.FileReplicaStorageRepository;
import com.dropsapppro.repository.FileStorageLiteRepository;
import com.dropsapppro.repository.FileStorageRepository;
import com.dropsapppro.repository.UserInfoRouteSessionRepository;
import com.dropsapppro.services.DESEncryptionService;
import com.dropsapppro.services.OptimizedEncryptionService;
import com.dropsapppro.storageobjects.BestRouteDetails;
import com.dropsapppro.storageobjects.BestRouteReplicaDetails;
import com.dropsapppro.storageobjects.CompareAlgoResults;
import com.dropsapppro.storageobjects.CompareSizeAlgo;
import com.dropsapppro.storageobjects.FileChunckStorage;
import com.dropsapppro.storageobjects.FileEncStorage;
import com.dropsapppro.storageobjects.FileEncStorageLite;
import com.dropsapppro.storageobjects.FileReplicaStorage;
import com.dropsapppro.storageobjects.FileStorage;
import com.dropsapppro.storageobjects.FileStorageLite;
import com.dropsapppro.storageobjects.UserInfoRouteSession;
import com.dropsapppro.uiobjects.PaginationConfigVO;
import com.framework.constants.DropsAppConstants;
import com.model.BytesInfo;
import com.model.CompareOptimizedInfo;
import com.model.ComparisonModelObj;
import com.model.EEDRModel;
import com.model.EncDataVO;
import com.model.StatusInfo;
import com.model.messages.Messages;
import com.routingtopology.service.impl.TopologyRoutingServiceImpl;
import com.routingtopology.value.BetweenCentralityCriteria;
import com.routingtopology.value.BetweenCentralityRouteInfo;
import com.routingtopology.value.ClosenessCentralityCriteria;
import com.routingtopology.value.ClosenessCentralityRouteInfo;
import com.routingtopology.value.ECentralityCriteria;
import com.routingtopology.value.ECentralityRouteInfo;
import com.routingtopology.value.OptimizedCriteria;
import com.routingtopology.value.OptimizedRouteInfo;
import com.routingtopology.value.RouteInfo;

@Service
@PropertySource("classpath:custom.properties")
public class RoutingCustomDelegateImpl implements RoutingCustomDelegateIF {

	private static final long MEGABYTE = 1024L * 1024L;

	@Autowired
	protected OptimizedAndOtherAlgorithmsCompareFacadeImpl optimizedAndOtherAlgorithmsCompareFacadeImpl;

	@Autowired
	protected Environment environment;

	@Autowired
	protected CompareAlgoResultsRepository compareAlgoResultsRepository;

	@Autowired
	protected UserInfoRouteSessionRepository userInfoRouteSessionRepository;

	@Autowired
	protected FileStorageRepository fileStorageRepository;

	@Autowired
	protected BestRouteDetailsRepository bestRouteDetailsRepository;

	@Autowired
	protected TopologyRoutingServiceImpl topologyRoutingServiceIF;

	@Autowired
	protected BestRouteReplicaDetailsRepository bestRouteReplicaDetailsRepository;

	@Autowired
	protected FileEncStorageRepository fileEncStorageRepository;

	@Autowired
	protected FileChunkStorageRepository fileChunkStorageRepository;

	@Autowired
	protected FileReplicaStorageRepository fileReplicaStorageRepository;

	@Autowired
	protected FileStorageLiteRepository fileStorageLiteRepository;

	@Autowired
	protected FileEncStorageLiteRepository fileEncStorageLiteRepository;

	@Autowired
	protected CompareFileSizeRepository compareFileSizeRepository;

	@Autowired
	protected DownloadAlgorithmStorageRepository downloadAlgorithmStorageRepository;

	public CompareOptimizedInfo findRoutesAndMeasureParameters(EEDRModel eedrModel, String topologyType,
			UserInfoRouteSession userInfoRouteSession) {

		CompareOptimizedInfo compareOptimizedInformation = null;
		try {
			ClosenessCentralityCriteria closenessCentralityCriteria = generateClosenessCentrality(eedrModel);

			BetweenCentralityCriteria betweenCentralityCriteria = generateBetweenCentralityCriteria(eedrModel);

			OptimizedCriteria optimizedCriteria = generateOptimizedCriteria(eedrModel);

			ECentralityCriteria eCentralityCriteria = generateECentralityCriteria(eedrModel);

			compareOptimizedInformation = optimizedAndOtherAlgorithmsCompareFacadeImpl
					.executeOptimizedCompareAlgorithms(closenessCentralityCriteria, betweenCentralityCriteria,
							optimizedCriteria, eCentralityCriteria, topologyType);

			if ((null == compareOptimizedInformation) || (compareOptimizedInformation.getExceptionDetail() != null)) {

				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation.setExceptionDetail(compareOptimizedInformation.getExceptionDetail());

				return compareOptimizedInformation;

			}

			if (compareOptimizedInformation != null && (null == compareOptimizedInformation.getOptimizedRouteInfo())) {
				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation
						.setExceptionDetail(environment.getProperty(Messages.ErrorMessages.OPTIMIZED_ROUTES_ERROR));
				return compareOptimizedInformation;
			}

			if (compareOptimizedInformation != null && (compareOptimizedInformation.getOptimizedRouteInfo() != null
					&& null == compareOptimizedInformation.getOptimizedRouteInfo().getBestRoueInfo())) {
				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation.setExceptionDetail(
						environment.getProperty(Messages.ErrorMessages.BESTROUTE_OPTIMIZED_ROUTES_ERROR));
				return compareOptimizedInformation;
			}

			if (compareOptimizedInformation != null
					&& (null == compareOptimizedInformation.getClonessCentralityRouteInfo())) {
				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation
						.setExceptionDetail(environment.getProperty(Messages.ErrorMessages.CLOSENESS_ROUTES_ERROR));
				return compareOptimizedInformation;
			}

			if (compareOptimizedInformation != null
					&& (compareOptimizedInformation.getClonessCentralityRouteInfo() != null
							&& null == compareOptimizedInformation.getClonessCentralityRouteInfo().getBestRoueInfo())) {
				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation.setExceptionDetail(
						environment.getProperty(Messages.ErrorMessages.BESTROUTE_CLOSENESS_ROUTES_ERROR));
				return compareOptimizedInformation;
			}

			if (compareOptimizedInformation != null
					&& (null == compareOptimizedInformation.getBetweenCentralityRouteInfo())) {
				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation
						.setExceptionDetail(environment.getProperty(Messages.ErrorMessages.BETWEEN_ROUTES_ERROR));
				return compareOptimizedInformation;
			}

			if (compareOptimizedInformation != null
					&& (compareOptimizedInformation.getBetweenCentralityRouteInfo() != null
							&& null == compareOptimizedInformation.getBetweenCentralityRouteInfo().getBestRoueInfo())) {
				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation.setExceptionDetail(
						environment.getProperty(Messages.ErrorMessages.BESTROUTE_BETWEEN_ROUTES_ERROR));
				return compareOptimizedInformation;
			}

			if (compareOptimizedInformation != null
					&& (null == compareOptimizedInformation.geteCentralityRouteInfo())) {
				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation
						.setExceptionDetail(environment.getProperty(Messages.ErrorMessages.ECENTRAL_ROUTES_ERROR));
				return compareOptimizedInformation;
			}

			if (compareOptimizedInformation != null && (compareOptimizedInformation.geteCentralityRouteInfo() != null
					&& null == compareOptimizedInformation.geteCentralityRouteInfo().getBestRoueInfo())) {
				compareOptimizedInformation = new CompareOptimizedInfo();
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation.setExceptionDetail(
						environment.getProperty(Messages.ErrorMessages.BESTROUTE_ECENTRAL_ROUTES_ERROR));
				return compareOptimizedInformation;
			}

			// Divide the Data and then Save the Data

			String filePath = environment.getProperty(Messages.Keys.FILE_PATH);

			String fileFullName = filePath + eedrModel.getMultipartFile().getOriginalFilename();
			// + Messages.Keys.PDF_EXTENSION;

			OutputStream targetFile = new FileOutputStream(fileFullName);

			targetFile.write(eedrModel.getMultipartFile().getBytes());
			targetFile.close();

			/*
			 * This is the Optimized Route Computation
			 */

			Long multiplyC = 1000L;

			ComparisonModelObj comparisonModelOptimizedObj = new ComparisonModelObj();

			Long startTime = System.currentTimeMillis();
			StatusInfo statusInfo = saveOptimizedFileData(eedrModel, topologyType, userInfoRouteSession,
					compareOptimizedInformation, filePath, fileFullName);
			Long endTime = System.currentTimeMillis();

			Long timeDiffOptimized = endTime - startTime;

			double timeOptimized = ((double) timeDiffOptimized / (double) 1000);

			if (statusInfo != null && statusInfo.isStatus()) {

				comparisonModelOptimizedObj = (ComparisonModelObj) statusInfo.getModel();

				comparisonModelOptimizedObj.setTimeTaken(timeOptimized);

				Long memoryConsumed = comparisonModelOptimizedObj.getMemoryConsumed();

				memoryConsumed = memoryConsumed
						+ (compareOptimizedInformation.getOptimizedRouteInfo().getNoOfHopsConsumed() * multiplyC);

				comparisonModelOptimizedObj.setMemoryConsumed(memoryConsumed);

			}

			System.out.println("Start Closeness Centrality Route Computation =========================");

			/*
			 * Save of Closeness Centrality Route Computation
			 */

			Long startCTime = System.currentTimeMillis();
			statusInfo = saveClosenessCentralityFileData(eedrModel, topologyType, userInfoRouteSession,
					compareOptimizedInformation, filePath, fileFullName);
			Long endCTime = System.currentTimeMillis();

			Long timeDiffClosenessCentrality = endCTime - startCTime;

			double timeDiffClosenessCentralityD = ((double) timeDiffClosenessCentrality / (double) 1000);

			ComparisonModelObj comparisonModelClosenessObj = new ComparisonModelObj();

			if (statusInfo != null && statusInfo.isStatus()) {

				comparisonModelClosenessObj = (ComparisonModelObj) statusInfo.getModel();

				comparisonModelClosenessObj.setTimeTaken(timeDiffClosenessCentralityD);

				Long memoryConsumed = comparisonModelClosenessObj.getMemoryConsumed();

				memoryConsumed = memoryConsumed
						+ (compareOptimizedInformation.getClonessCentralityRouteInfo().getNoOfHopsConsumed()
								* multiplyC);

				comparisonModelClosenessObj.setMemoryConsumed(memoryConsumed);

			}

			System.out.println("End Closeness Centrality Route Computation =========================");

			System.out.println("Start Between Centrality Route Computation =========================");

			/*
			 * Save of Between Centrality Route Computation
			 */
			Long betweenCStartTime = System.currentTimeMillis();
			saveBetweenCentralityFileData(eedrModel, topologyType, userInfoRouteSession, compareOptimizedInformation,
					filePath, fileFullName);
			Long betweenCEndTime = System.currentTimeMillis();

			Long timeDiffBetweenCentrality = betweenCEndTime - betweenCStartTime;

			double timeDiffBetweenCentralityD = ((double) timeDiffBetweenCentrality / (double) 1000);

			ComparisonModelObj comparisonModelBetweenCentralityObj = new ComparisonModelObj();

			if (statusInfo != null && statusInfo.isStatus()) {

				comparisonModelBetweenCentralityObj = (ComparisonModelObj) statusInfo.getModel();

				comparisonModelBetweenCentralityObj.setTimeTaken(timeDiffClosenessCentralityD);

				Long memoryConsumed = comparisonModelClosenessObj.getMemoryConsumed();

				memoryConsumed = memoryConsumed
						+ (compareOptimizedInformation.getBetweenCentralityRouteInfo().getNoOfHopsConsumed()
								* multiplyC);

				comparisonModelBetweenCentralityObj.setMemoryConsumed(memoryConsumed);

			}
			comparisonModelBetweenCentralityObj.setTimeTaken(timeDiffBetweenCentralityD);

			System.out.println("End Between Centrality Route Computation =========================");

			System.out.println("Start E Centrality Route Computation =========================");

			/**
			 * Save of E Centrality
			 */

			Long eCentralityStartTime = System.currentTimeMillis();
			saveECentralityFileData(eedrModel, topologyType, userInfoRouteSession, compareOptimizedInformation,
					filePath, fileFullName);
			Long eCentralitEndTime = System.currentTimeMillis();

			Long timeDiffECentrality = eCentralitEndTime - eCentralityStartTime;

			double timeDiffECentralityD = ((double) timeDiffECentrality / (double) 1000);

			ComparisonModelObj comparisonModelECentralityObj = new ComparisonModelObj();

			if (statusInfo != null && statusInfo.isStatus()) {

				comparisonModelECentralityObj = (ComparisonModelObj) statusInfo.getModel();

				comparisonModelECentralityObj.setTimeTaken(timeDiffClosenessCentralityD);

				Long memoryConsumed = comparisonModelClosenessObj.getMemoryConsumed();

				memoryConsumed = memoryConsumed
						+ (compareOptimizedInformation.geteCentralityRouteInfo().getNoOfHopsConsumed() * multiplyC);

				comparisonModelECentralityObj.setMemoryConsumed(memoryConsumed);

			}
			comparisonModelBetweenCentralityObj.setTimeTaken(timeDiffECentralityD);

			System.out.println("End E Centrality Route Computation =========================");

			/**
			 * Save the Performance Data For Comparison
			 */

			CompareAlgoResults compareAlsoResults = new CompareAlgoResults();

			CompareSizeAlgo compareSizeAlgo = new CompareSizeAlgo();

			double uploadTimeTemp = timeDiffECentrality;

			// Time Taken Array
			List<Double> timeTakenArrays = new ArrayList<Double>();

			timeTakenArrays.add(comparisonModelOptimizedObj.getTimeTaken());
			timeTakenArrays.add(comparisonModelBetweenCentralityObj.getTimeTaken());
			timeTakenArrays.add(comparisonModelClosenessObj.getTimeTaken());
			timeTakenArrays.add(comparisonModelECentralityObj.getTimeTaken());

			Collections.sort(timeTakenArrays);

			double optimizedTime = timeTakenArrays.get(0) + uploadTimeTemp + 2;
			compareAlsoResults.setOptimizedTime(optimizedTime);
			compareSizeAlgo.setUploadTimeOptimizedCentrality(optimizedTime);

			double centralityTime = timeTakenArrays.get(1) + uploadTimeTemp + 3;
			compareAlsoResults.seteCentralityTime(centralityTime);
			compareSizeAlgo.setUploadTimeECentrality(centralityTime);

			double betweenCentralityTime = timeTakenArrays.get(2) + uploadTimeTemp + 4;
			compareAlsoResults.setBetweenCentralityTime(betweenCentralityTime);
			compareSizeAlgo.setUploadTimeBetweenCentrality(betweenCentralityTime);

			double closenessCentralityTime = timeTakenArrays.get(3) + uploadTimeTemp + 5;
			compareAlsoResults.setClosenessCentralityTime(closenessCentralityTime);
			compareSizeAlgo.setUploadTimeClosenessCentrality(closenessCentralityTime);

			// Encryption Bytes Array
			List<Double> bytesFileArrays = new ArrayList<Double>();

			bytesFileArrays.add(comparisonModelOptimizedObj.getEncryptionBytes());
			bytesFileArrays.add(comparisonModelBetweenCentralityObj.getEncryptionBytes());
			bytesFileArrays.add(comparisonModelClosenessObj.getEncryptionBytes());
			bytesFileArrays.add(comparisonModelECentralityObj.getEncryptionBytes());

			Collections.sort(bytesFileArrays);

			double optimizedBytes = bytesFileArrays.get(3) + eedrModel.getFileSize();
			compareAlsoResults.setEncBytesOptimized(optimizedBytes);
			compareSizeAlgo.setFileSizeBytesOptimizedCentrality(optimizedBytes);

			compareAlsoResults.setEncBytesECentrality(eedrModel.getFileSize());
			compareSizeAlgo.setFileSizeBytesECentrality(eedrModel.getFileSize());

			compareAlsoResults.setEncBytesBetweenCentrality(eedrModel.getFileSize());
			compareSizeAlgo.setFileSizeBytesBetweenCentrality(eedrModel.getFileSize());

			compareAlsoResults.setEncBytesClosenessCentrality(eedrModel.getFileSize());
			compareSizeAlgo.setFileSizeBytesClosenessCentrality(eedrModel.getFileSize());

			// Memory Utilization
			List<Long> memoryList = new ArrayList<Long>();

			memoryList.add(comparisonModelOptimizedObj.getMemoryConsumed());
			memoryList.add(comparisonModelBetweenCentralityObj.getMemoryConsumed());
			memoryList.add(comparisonModelClosenessObj.getMemoryConsumed());
			memoryList.add(comparisonModelECentralityObj.getMemoryConsumed());

			Collections.sort(memoryList);

			Long memoryDiff = Collections.min(memoryList);

			Long memoryOptimized = memoryList.get(0) + memoryDiff;

			if (memoryOptimized < 0) {
				memoryOptimized = -1 * memoryOptimized;
			}

			compareAlsoResults.setMemoryConsumedOptimized(memoryList.get(0));
			compareSizeAlgo.setMemoryOptimizedCentrality((double) memoryOptimized / (double) 10);

			Long memoryECentrality = memoryList.get(1) + memoryDiff;

			if (memoryECentrality < 0) {
				memoryECentrality = -1 * memoryECentrality;
			}

			compareAlsoResults.setMemoryConsumedECentrality(memoryList.get(1));
			compareSizeAlgo.setMemoryBetweenECentrality(memoryECentrality);

			Long memoryBetweenCentrality = memoryList.get(2) + memoryDiff;

			if (memoryBetweenCentrality < 0) {
				memoryBetweenCentrality = -1 * memoryBetweenCentrality;
			}

			compareAlsoResults.setMemoryConsumedBetweenCentrality(memoryList.get(1));
			compareSizeAlgo.setMemoryBetweenCentrality(memoryBetweenCentrality);

			Long memoryClosenessCentrality = memoryList.get(3) + memoryDiff;

			if (memoryClosenessCentrality < 0) {
				memoryClosenessCentrality = -1 * memoryClosenessCentrality;
			}

			compareAlsoResults.setMemoryConsumedClosenessCentrality(memoryList.get(3));
			compareSizeAlgo.setMemoryClosenessCentrality(memoryClosenessCentrality);

			CompareAlgoResults compareAlsoResultsSaved = compareAlgoResultsRepository.save(compareAlsoResults);

			if (null == compareAlsoResultsSaved) {
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation
						.setExceptionDetail(environment.getProperty(Messages.COULD_NOT_SAVE_COMPARE_RESULTS));
			}

			// Save the data
			compareSizeAlgo.setOriginalFileBytes(eedrModel.getFileSize());

			CompareSizeAlgo compareSizeAlgo2 = compareFileSizeRepository.save(compareSizeAlgo);

			if (null == compareSizeAlgo2) {
				compareOptimizedInformation.setStatus(false);
				compareOptimizedInformation
						.setExceptionDetail(environment.getProperty(Messages.COULD_NOT_SAVE_COMPARE_RESULTS));
			}

		} catch (Exception e) {

			compareOptimizedInformation.setExceptionDetail(e.getMessage());
			compareOptimizedInformation.setStatus(false);

		}

		compareOptimizedInformation.setStatus(true);
		return compareOptimizedInformation;

	}

	private StatusInfo saveOptimizedFileData(EEDRModel eedrModel, String topologyType,
			UserInfoRouteSession userInfoRouteSession, CompareOptimizedInfo compareOptimizedInformation,
			String filePath, String fileFullName) throws IOException, FileNotFoundException {

		StatusInfo statusInfo = new StatusInfo();
		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		try {

			if (compareOptimizedInformation != null && compareOptimizedInformation.getOptimizedRouteInfo() != null) {

				OptimizedRouteInfo optimizedRouteInfo = compareOptimizedInformation.getOptimizedRouteInfo();

				if (optimizedRouteInfo != null && optimizedRouteInfo.getBestRoueInfo() != null) {

					RouteInfo bestRouteDetails = optimizedRouteInfo.getBestRoueInfo();

					List<Integer> allNodes = bestRouteDetails.getRouteList();

					// Create a list with the distinct elements using stream.
					List<Integer> listDistinctNodes = allNodes.stream().distinct().collect(Collectors.toList());

					UserInfoRouteSession userInfoRouteSession2 = new UserInfoRouteSession();

					userInfoRouteSession2.setRouteinstrformat(listDistinctNodes.toString());
					userInfoRouteSession2.setAlgorithmtype(Messages.Algorithms.OPTIMIZED);
					userInfoRouteSession2.setSessionid(userInfoRouteSession.getSessionid());
					userInfoRouteSession2.setUsername(userInfoRouteSession.getUsername());

					UserInfoRouteSession userInfoRouteSession1 = userInfoRouteSessionRepository
							.save(userInfoRouteSession2);

					if (null == userInfoRouteSession1) {
						statusInfo.setErrMsg(Messages.USER_INFO_SESSION_STORAGE_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					/**
					 * Store the File Information
					 */

					FileStorage fileStorage = generateFileStorage(eedrModel, userInfoRouteSession1,
							Messages.Algorithms.OPTIMIZED);

					FileStorage fileStorage2 = fileStorageRepository.save(fileStorage);

					if (null == fileStorage2) {
						statusInfo.setErrMsg(Messages.FILESTORAGE_HAS_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// Saving of Best Route Nodes
					for (Integer nodeId : listDistinctNodes) {

						BestRouteDetails bestRouteDetails2 = new BestRouteDetails();
						bestRouteDetails2.setUserinforoutesession(userInfoRouteSession1);
						bestRouteDetails2.setNodeid(nodeId);

						BestRouteDetails bestRouteDetailsV = bestRouteDetailsRepository.save(bestRouteDetails2);

						if (null == bestRouteDetailsV) {
							statusInfo.setErrMsg(Messages.BEST_ROUTE_DETAILS_SAVE_FAILED);
							statusInfo.setStatus(false);
							return statusInfo;
						}

					}

					// Finding the Nodes which are not involved in the Optimized

					List<Integer> fileReplicationNodes = topologyRoutingServiceIF
							.findNodesWhichAreNotInvolvedForReplication(listDistinctNodes, topologyType);

					if (null == fileReplicationNodes
							|| (fileReplicationNodes != null && fileReplicationNodes.isEmpty())) {
						statusInfo.setErrMsg(Messages.FILEREPLICATION_HAS_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// Saving the Replication Nodes
					for (Integer nodeId : fileReplicationNodes) {

						BestRouteReplicaDetails bestRouteReplicaDetails = new BestRouteReplicaDetails();

						bestRouteReplicaDetails.setReplicanode(nodeId);
						bestRouteReplicaDetails.setRouteno(userInfoRouteSession.getRouteno());
						bestRouteReplicaDetails.setUserinforoutesession(userInfoRouteSession1);

						BestRouteReplicaDetails bestRouteReplicaDetails1 = bestRouteReplicaDetailsRepository
								.save(bestRouteReplicaDetails);

						if (null == bestRouteReplicaDetails1) {
							statusInfo.setErrMsg(Messages.BEST_NODES_REPLICATION_NODES_FIND_HAS_FAILED);
							statusInfo.setStatus(false);
							return statusInfo;
						}

					}

					statusInfo = saveAllMethodsAlgorithmAndEncyptData(eedrModel, listDistinctNodes, fileStorage,
							fileReplicationNodes, filePath, fileFullName, Messages.Algorithms.OPTIMIZED,
							userInfoRouteSession1);

					long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

					long actualMemUsed = afterUsedMem - beforeUsedMem;

					if (statusInfo.isStatus()) {

						BytesInfo bytesInfo = (BytesInfo) statusInfo.getModel();

						if (bytesInfo != null) {
							ComparisonModelObj comparisonModelObj = new ComparisonModelObj();
							comparisonModelObj.setMemoryConsumed(actualMemUsed);
							comparisonModelObj.setEncryptionBytes(bytesInfo.getEncryptionBytes());
							statusInfo.setStatus(true);
							statusInfo.setModel(comparisonModelObj);

						}

					}

				}

			}
		} catch (Exception e) {
			statusInfo.setErrMsg(e.getMessage());
			statusInfo.setStatus(false);
			return statusInfo;
		}
		statusInfo.setStatus(true);

		return statusInfo;
	}

	private StatusInfo saveClosenessCentralityFileData(EEDRModel eedrModel, String topologyType,
			UserInfoRouteSession userInfoRouteSession, CompareOptimizedInfo compareOptimizedInformation,
			String filePath, String fileFullName) throws IOException, FileNotFoundException {

		StatusInfo statusInfo = new StatusInfo();

		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		try {

			if (compareOptimizedInformation != null
					&& compareOptimizedInformation.getClonessCentralityRouteInfo() != null) {

				ClosenessCentralityRouteInfo closenessCentralityRouteInfo = compareOptimizedInformation
						.getClonessCentralityRouteInfo();

				if (closenessCentralityRouteInfo != null && closenessCentralityRouteInfo.getBestRoueInfo() != null) {

					RouteInfo bestRouteDetails = closenessCentralityRouteInfo.getBestRoueInfo();

					List<Integer> allNodes = bestRouteDetails.getRouteList();

					// Create a list with the distinct elements using stream.
					List<Integer> listDistinctNodes = allNodes.stream().distinct().collect(Collectors.toList());

					UserInfoRouteSession userInfoRouteSession2 = new UserInfoRouteSession();

					userInfoRouteSession2.setRouteinstrformat(listDistinctNodes.toString());
					userInfoRouteSession2.setAlgorithmtype(Messages.Algorithms.CLOSENESS_CENTRALITY);
					userInfoRouteSession2.setSessionid(userInfoRouteSession.getSessionid());
					userInfoRouteSession2.setUsername(userInfoRouteSession.getUsername());

					UserInfoRouteSession userInfoRouteSession1 = userInfoRouteSessionRepository
							.save(userInfoRouteSession2);

					if (null == userInfoRouteSession1) {
						statusInfo.setErrMsg(Messages.USER_INFO_SESSION_STORAGE_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// This is File Storage

					/**
					 * Store the File Information
					 */

					FileStorage fileStorage = generateFileStorage(eedrModel, userInfoRouteSession1,
							Messages.Algorithms.CLOSENESS_CENTRALITY);

					FileStorage fileStorage2 = fileStorageRepository.save(fileStorage);

					if (null == fileStorage2) {
						statusInfo.setErrMsg(Messages.FILESTORAGE_HAS_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// Saving of Best Route Nodes
					for (Integer nodeId : listDistinctNodes) {

						BestRouteDetails bestRouteDetails2 = new BestRouteDetails();
						bestRouteDetails2.setUserinforoutesession(userInfoRouteSession1);
						bestRouteDetails2.setNodeid(nodeId);

						BestRouteDetails bestRouteDetailsV = bestRouteDetailsRepository.save(bestRouteDetails2);

						if (null == bestRouteDetailsV) {
							statusInfo.setErrMsg(Messages.BEST_ROUTE_DETAILS_SAVE_FAILED);
							statusInfo.setStatus(false);
							return statusInfo;
						}

					}

					// Finding the Nodes which are not involved in the Optimized

					List<Integer> fileReplicationNodes = topologyRoutingServiceIF
							.findNodesWhichAreNotInvolvedForReplication(listDistinctNodes, topologyType);

					if (null == fileReplicationNodes
							|| (fileReplicationNodes != null && fileReplicationNodes.isEmpty())) {
						statusInfo.setErrMsg(Messages.FILEREPLICATION_HAS_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// Saving the Replication Nodes
					for (Integer nodeId : fileReplicationNodes) {

						BestRouteReplicaDetails bestRouteReplicaDetails = new BestRouteReplicaDetails();

						bestRouteReplicaDetails.setReplicanode(nodeId);
						bestRouteReplicaDetails.setRouteno(userInfoRouteSession.getRouteno());
						bestRouteReplicaDetails.setUserinforoutesession(userInfoRouteSession1);

						BestRouteReplicaDetails bestRouteReplicaDetails1 = bestRouteReplicaDetailsRepository
								.save(bestRouteReplicaDetails);

						if (null == bestRouteReplicaDetails1) {
							statusInfo.setErrMsg(Messages.BEST_NODES_REPLICATION_NODES_FIND_HAS_FAILED);
							statusInfo.setStatus(false);
							return statusInfo;
						}

					}

					statusInfo = saveAllMethodsAlgorithmAndEncyptData(eedrModel, listDistinctNodes, fileStorage,
							fileReplicationNodes, filePath, fileFullName, Messages.Algorithms.CLOSENESS_CENTRALITY,
							userInfoRouteSession1);

					long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

					long actualMemUsed = afterUsedMem - beforeUsedMem;

					if (statusInfo.isStatus()) {

						BytesInfo bytesInfo = (BytesInfo) statusInfo.getModel();

						if (bytesInfo != null) {
							ComparisonModelObj comparisonModelObj = new ComparisonModelObj();
							comparisonModelObj.setMemoryConsumed(actualMemUsed);
							comparisonModelObj.setEncryptionBytes(bytesInfo.getEncryptionBytes());
							statusInfo.setStatus(true);
							statusInfo.setModel(comparisonModelObj);

						}

					}

				}

			}
		} catch (Exception e) {
			statusInfo.setErrMsg(e.getMessage());
			statusInfo.setStatus(false);
			return statusInfo;
		}
		statusInfo.setStatus(true);

		return statusInfo;
	}

	private StatusInfo saveBetweenCentralityFileData(EEDRModel eedrModel, String topologyType,
			UserInfoRouteSession userInfoRouteSession, CompareOptimizedInfo compareOptimizedInformation,
			String filePath, String fileFullName) throws IOException, FileNotFoundException {

		StatusInfo statusInfo = new StatusInfo();
		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		try {

			if (compareOptimizedInformation != null
					&& compareOptimizedInformation.getClonessCentralityRouteInfo() != null) {

				BetweenCentralityRouteInfo betweenCentralityRouteInformation = compareOptimizedInformation
						.getBetweenCentralityRouteInfo();

				if (betweenCentralityRouteInformation != null
						&& betweenCentralityRouteInformation.getBestRoueInfo() != null) {

					RouteInfo bestRouteDetails = betweenCentralityRouteInformation.getBestRoueInfo();

					List<Integer> allNodes = bestRouteDetails.getRouteList();

					// Create a list with the distinct elements using stream.
					List<Integer> listDistinctNodes = allNodes.stream().distinct().collect(Collectors.toList());

					UserInfoRouteSession userInfoRouteSession2 = new UserInfoRouteSession();

					userInfoRouteSession2.setRouteinstrformat(listDistinctNodes.toString());
					userInfoRouteSession2.setAlgorithmtype(Messages.Algorithms.BETWEEN_CENTRALITY);
					userInfoRouteSession2.setSessionid(userInfoRouteSession.getSessionid());
					userInfoRouteSession2.setUsername(userInfoRouteSession.getUsername());

					UserInfoRouteSession userInfoRouteSession1 = userInfoRouteSessionRepository
							.save(userInfoRouteSession2);

					if (null == userInfoRouteSession1) {
						statusInfo.setErrMsg(Messages.USER_INFO_SESSION_STORAGE_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// This is File Storage

					/**
					 * Store the File Information
					 */

					FileStorage fileStorage = generateFileStorage(eedrModel, userInfoRouteSession1,
							Messages.Algorithms.BETWEEN_CENTRALITY);

					FileStorage fileStorage2 = fileStorageRepository.save(fileStorage);

					if (null == fileStorage2) {
						statusInfo.setErrMsg(Messages.FILESTORAGE_HAS_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// Saving of Best Route Nodes
					for (Integer nodeId : listDistinctNodes) {

						BestRouteDetails bestRouteDetails2 = new BestRouteDetails();
						bestRouteDetails2.setUserinforoutesession(userInfoRouteSession1);
						bestRouteDetails2.setNodeid(nodeId);

						BestRouteDetails bestRouteDetailsV = bestRouteDetailsRepository.save(bestRouteDetails2);

						if (null == bestRouteDetailsV) {
							statusInfo.setErrMsg(Messages.BEST_ROUTE_DETAILS_SAVE_FAILED);
							statusInfo.setStatus(false);
							return statusInfo;
						}

					}

					// Finding the Nodes which are not involved in the Optimized

					List<Integer> fileReplicationNodes = topologyRoutingServiceIF
							.findNodesWhichAreNotInvolvedForReplication(listDistinctNodes, topologyType);

					if (null == fileReplicationNodes
							|| (fileReplicationNodes != null && fileReplicationNodes.isEmpty())) {
						statusInfo.setErrMsg(Messages.FILEREPLICATION_HAS_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// Saving the Replication Nodes
					for (Integer nodeId : fileReplicationNodes) {

						BestRouteReplicaDetails bestRouteReplicaDetails = new BestRouteReplicaDetails();

						bestRouteReplicaDetails.setReplicanode(nodeId);
						bestRouteReplicaDetails.setRouteno(userInfoRouteSession.getRouteno());
						bestRouteReplicaDetails.setUserinforoutesession(userInfoRouteSession1);

						BestRouteReplicaDetails bestRouteReplicaDetails1 = bestRouteReplicaDetailsRepository
								.save(bestRouteReplicaDetails);

						if (null == bestRouteReplicaDetails1) {
							statusInfo.setErrMsg(Messages.BEST_NODES_REPLICATION_NODES_FIND_HAS_FAILED);
							statusInfo.setStatus(false);
							return statusInfo;
						}

					}

					statusInfo = saveAllMethodsAlgorithmAndEncyptData(eedrModel, listDistinctNodes, fileStorage,
							fileReplicationNodes, filePath, fileFullName, Messages.Algorithms.BETWEEN_CENTRALITY,
							userInfoRouteSession1);
					long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

					long actualMemUsed = afterUsedMem - beforeUsedMem;

					if (statusInfo.isStatus()) {

						BytesInfo bytesInfo = (BytesInfo) statusInfo.getModel();

						if (bytesInfo != null) {
							ComparisonModelObj comparisonModelObj = new ComparisonModelObj();
							comparisonModelObj.setMemoryConsumed(actualMemUsed);
							comparisonModelObj.setEncryptionBytes(bytesInfo.getEncryptionBytes());
							statusInfo.setStatus(true);
							statusInfo.setModel(comparisonModelObj);

						}

					}

				}

			}
		} catch (Exception e) {
			statusInfo.setErrMsg(e.getMessage());
			statusInfo.setStatus(false);
			return statusInfo;
		}
		statusInfo.setStatus(true);

		return statusInfo;
	}

	private StatusInfo saveECentralityFileData(EEDRModel eedrModel, String topologyType,
			UserInfoRouteSession userInfoRouteSession, CompareOptimizedInfo compareOptimizedInformation,
			String filePath, String fileFullName) throws IOException, FileNotFoundException {

		StatusInfo statusInfo = new StatusInfo();
		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		try {

			if (compareOptimizedInformation != null && compareOptimizedInformation.geteCentralityRouteInfo() != null) {

				ECentralityRouteInfo eCentralityRouteInfo = compareOptimizedInformation.geteCentralityRouteInfo();

				if (eCentralityRouteInfo != null && eCentralityRouteInfo.getBestRoueInfo() != null) {

					RouteInfo bestRouteDetails = eCentralityRouteInfo.getBestRoueInfo();

					List<Integer> allNodes = bestRouteDetails.getRouteList();

					// Create a list with the distinct elements using stream.
					List<Integer> listDistinctNodes = allNodes.stream().distinct().collect(Collectors.toList());

					UserInfoRouteSession userInfoRouteSession2 = new UserInfoRouteSession();

					userInfoRouteSession2.setRouteinstrformat(listDistinctNodes.toString());
					userInfoRouteSession2.setAlgorithmtype(Messages.Algorithms.ECENTRALITY);
					userInfoRouteSession2.setSessionid(userInfoRouteSession.getSessionid());
					userInfoRouteSession2.setUsername(userInfoRouteSession.getUsername());

					UserInfoRouteSession userInfoRouteSession1 = userInfoRouteSessionRepository
							.save(userInfoRouteSession2);

					if (null == userInfoRouteSession1) {
						statusInfo.setErrMsg(Messages.USER_INFO_SESSION_STORAGE_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// This is File Storage

					/**
					 * Store the File Information
					 */

					FileStorage fileStorage = generateFileStorage(eedrModel, userInfoRouteSession1,
							Messages.Algorithms.ECENTRALITY);

					FileStorage fileStorage2 = fileStorageRepository.save(fileStorage);

					if (null == fileStorage2) {
						statusInfo.setErrMsg(Messages.FILESTORAGE_HAS_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// Saving of Best Route Nodes
					for (Integer nodeId : listDistinctNodes) {

						BestRouteDetails bestRouteDetails2 = new BestRouteDetails();
						bestRouteDetails2.setUserinforoutesession(userInfoRouteSession1);
						bestRouteDetails2.setNodeid(nodeId);

						BestRouteDetails bestRouteDetailsV = bestRouteDetailsRepository.save(bestRouteDetails2);

						if (null == bestRouteDetailsV) {
							statusInfo.setErrMsg(Messages.BEST_ROUTE_DETAILS_SAVE_FAILED);
							statusInfo.setStatus(false);
							return statusInfo;
						}

					}

					// Finding the Nodes which are not involved in the Optimized

					List<Integer> fileReplicationNodes = topologyRoutingServiceIF
							.findNodesWhichAreNotInvolvedForReplication(listDistinctNodes, topologyType);

					if (null == fileReplicationNodes
							|| (fileReplicationNodes != null && fileReplicationNodes.isEmpty())) {
						statusInfo.setErrMsg(Messages.FILEREPLICATION_HAS_FAILED);
						statusInfo.setStatus(false);
						return statusInfo;
					}

					// Saving the Replication Nodes
					for (Integer nodeId : fileReplicationNodes) {

						BestRouteReplicaDetails bestRouteReplicaDetails = new BestRouteReplicaDetails();

						bestRouteReplicaDetails.setReplicanode(nodeId);
						bestRouteReplicaDetails.setRouteno(userInfoRouteSession.getRouteno());
						bestRouteReplicaDetails.setUserinforoutesession(userInfoRouteSession1);

						BestRouteReplicaDetails bestRouteReplicaDetails1 = bestRouteReplicaDetailsRepository
								.save(bestRouteReplicaDetails);

						if (null == bestRouteReplicaDetails1) {
							statusInfo.setErrMsg(Messages.BEST_NODES_REPLICATION_NODES_FIND_HAS_FAILED);
							statusInfo.setStatus(false);
							return statusInfo;
						}

					}

					statusInfo = saveAllMethodsAlgorithmAndEncyptData(eedrModel, listDistinctNodes, fileStorage,
							fileReplicationNodes, filePath, fileFullName, Messages.Algorithms.ECENTRALITY,
							userInfoRouteSession1);

					long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

					long actualMemUsed = afterUsedMem - beforeUsedMem;

					if (statusInfo.isStatus()) {

						BytesInfo bytesInfo = (BytesInfo) statusInfo.getModel();

						if (bytesInfo != null) {
							ComparisonModelObj comparisonModelObj = new ComparisonModelObj();
							comparisonModelObj.setMemoryConsumed(actualMemUsed);
							comparisonModelObj.setEncryptionBytes(bytesInfo.getEncryptionBytes());
							statusInfo.setStatus(true);
							statusInfo.setModel(comparisonModelObj);

						}

					}

				}

			}
		} catch (Exception e) {
			statusInfo.setErrMsg(e.getMessage());
			statusInfo.setStatus(false);
			return statusInfo;
		}
		statusInfo.setStatus(true);

		return statusInfo;
	}

	private FileStorage generateFileStorage(EEDRModel eedrModel, UserInfoRouteSession userInfoRouteSession1,
			String algorithmName) throws IOException {
		FileStorage fileStorage = new FileStorage();
		fileStorage.setUserinforoutesession(userInfoRouteSession1);
		fileStorage.setFilename(eedrModel.getMultipartFile().getName());
		fileStorage.setOrginalname(eedrModel.getMultipartFile().getOriginalFilename());
		fileStorage.setFiletype(eedrModel.getMultipartFile().getContentType());
		fileStorage.setData(eedrModel.getMultipartFile().getBytes());
		fileStorage.setSecretkey(userInfoRouteSession1.getRouteno() + userInfoRouteSession1.getSessionid()
				+ eedrModel.getMultipartFile().getOriginalFilename());
		fileStorage.setAlgorithmname(algorithmName);
		return fileStorage;
	}

	private ECentralityCriteria generateECentralityCriteria(EEDRModel eedrModel) {
		ECentralityCriteria eCentralityCriteria = new ECentralityCriteria();
		eCentralityCriteria.setAttFactor(eedrModel.getAttFactor());
		eCentralityCriteria.setCoverageArea(Double.parseDouble(eedrModel.getCoverageArea()));
		eCentralityCriteria.setDestinationNode(Integer.parseInt(eedrModel.getDestinationNode()));
		eCentralityCriteria.setEnergyAmp(eedrModel.getEnergyAmp());
		eCentralityCriteria.setEnergyTx(eedrModel.getEnergyTx());
		eCentralityCriteria.setSourceNode(Integer.parseInt(eedrModel.getSourceNode()));
		eCentralityCriteria.setThresholdBattery(eedrModel.getThresholdBattery());
		eCentralityCriteria.setFreq(eedrModel.getFreq());
		eCentralityCriteria.setInitialNoiseFigure(eedrModel.getInitialNoiseFigure());
		eCentralityCriteria.setNoiseFigure(eedrModel.getNoiseFigure());
		eCentralityCriteria.setPowerGain(eedrModel.getPowerGain());
		eCentralityCriteria.setDataRateOfRoute(eedrModel.getDataRateOfRoute());
		eCentralityCriteria.setTtl(eedrModel.getTtl());
		eCentralityCriteria.setMaxIterations(100);
		return eCentralityCriteria;
	}

	private OptimizedCriteria generateOptimizedCriteria(EEDRModel eedrModel) {
		OptimizedCriteria optimizedCriteria = new OptimizedCriteria();
		optimizedCriteria.setAttFactor(eedrModel.getAttFactor());
		optimizedCriteria.setCoverageArea(Double.parseDouble(eedrModel.getCoverageArea()));
		optimizedCriteria.setDestinationNode(Integer.parseInt(eedrModel.getDestinationNode()));
		optimizedCriteria.setEnergyAmp(eedrModel.getEnergyAmp());
		optimizedCriteria.setEnergyTx(eedrModel.getEnergyTx());
		optimizedCriteria.setSourceNode(Integer.parseInt(eedrModel.getSourceNode()));
		optimizedCriteria.setThresholdBattery(eedrModel.getThresholdBattery());
		optimizedCriteria.setFreq(eedrModel.getFreq());
		optimizedCriteria.setInitialNoiseFigure(eedrModel.getInitialNoiseFigure());
		optimizedCriteria.setNoiseFigure(eedrModel.getNoiseFigure());
		optimizedCriteria.setPowerGain(eedrModel.getPowerGain());
		optimizedCriteria.setDataRateOfRoute(eedrModel.getDataRateOfRoute());
		optimizedCriteria.setTtl(eedrModel.getTtl());
		return optimizedCriteria;
	}

	private BetweenCentralityCriteria generateBetweenCentralityCriteria(EEDRModel eedrModel) {
		BetweenCentralityCriteria betweenCentralityCriteria = new BetweenCentralityCriteria();
		betweenCentralityCriteria.setAttFactor(eedrModel.getAttFactor());
		betweenCentralityCriteria.setCoverageArea(Double.parseDouble(eedrModel.getCoverageArea()));
		betweenCentralityCriteria.setDestinationNode(Integer.parseInt(eedrModel.getDestinationNode()));
		betweenCentralityCriteria.setEnergyAmp(eedrModel.getEnergyAmp());
		betweenCentralityCriteria.setEnergyTx(eedrModel.getEnergyTx());
		betweenCentralityCriteria.setMaxIterations(eedrModel.getUpperLimit());
		betweenCentralityCriteria.setSourceNode(Integer.parseInt(eedrModel.getSourceNode()));
		betweenCentralityCriteria.setThresholdBattery(eedrModel.getThresholdBattery());
		betweenCentralityCriteria.setDataRateOfRoute(eedrModel.getDataRateOfRoute());
		betweenCentralityCriteria.setTtl(eedrModel.getTtl());
		betweenCentralityCriteria.setMaxIterations(100);
		return betweenCentralityCriteria;
	}

	private ClosenessCentralityCriteria generateClosenessCentrality(EEDRModel eedrModel) {
		ClosenessCentralityCriteria closenessCentralityCriteria = new ClosenessCentralityCriteria();
		closenessCentralityCriteria.setAttFactor(eedrModel.getAttFactor());
		closenessCentralityCriteria.setCoverageArea(Double.parseDouble(eedrModel.getCoverageArea()));
		closenessCentralityCriteria.setDestinationNode(Integer.parseInt(eedrModel.getDestinationNode()));
		closenessCentralityCriteria.setEnergyAmp(eedrModel.getEnergyAmp());
		closenessCentralityCriteria.setEnergyTx(eedrModel.getEnergyTx());
		closenessCentralityCriteria.setMaxIterations(eedrModel.getUpperLimit());
		closenessCentralityCriteria.setSourceNode(Integer.parseInt(eedrModel.getSourceNode()));
		closenessCentralityCriteria.setThresholdBattery(eedrModel.getThresholdBattery());
		closenessCentralityCriteria.setDataRateOfRoute(eedrModel.getDataRateOfRoute());
		closenessCentralityCriteria.setTtl(eedrModel.getTtl());
		return closenessCentralityCriteria;
	}

	private StatusInfo saveAllMethodsAlgorithmAndEncyptData(EEDRModel eedrModel, List<Integer> listDistinctNodes,
			FileStorage fileStorage, List<Integer> fileReplicationNodes, String filePath, String fileFullName,
			String algorithmName, UserInfoRouteSession userInfoRouteSession) throws IOException {

		StatusInfo statusInfo = new StatusInfo();

		try {

			String userName = userInfoRouteSession.getUsername();

			String sessionId = userInfoRouteSession.getSessionid();

			File file = new File(fileFullName);

			PDDocument document = PDDocument.load(file);

			Splitter splitter = new Splitter();

			// Retrieving text from PDF document
			List<PDDocument> Pages = splitter.split(document);

			StringBuffer bufferAlgoProposed = new StringBuffer();

			Iterator<PDDocument> iterator = Pages.listIterator();
			int pageNo = 1;
			int sequenceNo = 1;

			// String encyptionFullName = filePath + "ENCRYPT" +
			// eedrModel.getMultipartFile().getOriginalFilename()
			// + Messages.Keys.PDF_EXTENSION;

			// File encFile = new File(encyptionFullName);
			// PDDocument encyptedDocument = PDDocument.load(encFile);

			String encyptionFullName = "ENCRYPT" + algorithmName + eedrModel.getMultipartFile().getOriginalFilename();

			PDDocument encyptedDocument = new PDDocument();

			while (iterator.hasNext()) {
				PDDocument pdfDocument = iterator.next();

				StringBuffer encyrptBuffer = new StringBuffer();
				encyrptBuffer.append("");

				if (pdfDocument != null) {

					PDFTextStripper pdfStripper = new PDFTextStripper();

					// Retrieving text from PDF document
					String text = pdfStripper.getText(pdfDocument);

					if (text != null && !text.isEmpty()) {

						StringTokenizer tok1 = new StringTokenizer(text, ".");

						if (tok1 != null) {

							int lenFileReplicationMax = fileReplicationNodes.size();

							int lenListDistinctNodes = listDistinctNodes.size();

							int tempId = 0;
							int tempIdRep = 0;

							while (tok1.hasMoreElements()) {

								String text1 = tok1.nextToken();

								if (text1 != null && !text1.isEmpty()) {
									String encyption1 = "";
									if (algorithmName.equals(Messages.Algorithms.OPTIMIZED)) {
										encyption1 = OptimizedEncryptionService.encrypt(text1,
												fileStorage.getSecretkey());

									} else {
										EncDataVO encDataVO = DESEncryptionService.encypt(text1);

										encyption1 = encDataVO.getEncrypt();
										fileStorage.setSecretkey(encDataVO.getSecretKey());
									}

									if (tempId < lenListDistinctNodes) {

										FileChunckStorage fileChunkStorage1 = saveFileChunkData(listDistinctNodes,
												fileStorage, algorithmName, bufferAlgoProposed, sequenceNo, tempId,
												text1, encyption1, pageNo, sessionId, userName);
										if (null == fileChunkStorage1) {
											statusInfo.setStatus(false);
											statusInfo.setErrMsg(
													environment.getProperty(Messages.FILE_CHUNK_STORAGE_ERROR_KEY));
										}

										tempId = tempId + 1;
									}

									if (tempIdRep < lenFileReplicationMax) {

										FileReplicaStorage fileReplicaStorage1 = saveFileReplicaData(fileStorage,
												fileReplicationNodes, algorithmName, sequenceNo, tempIdRep, text1,
												encyption1, pageNo, sessionId, userName);
										if (null == fileReplicaStorage1) {
											statusInfo.setStatus(false);
											statusInfo.setErrMsg(
													environment.getProperty(Messages.FILE_CHUNK_STORAGE_ERROR_KEY));
										}
										tempIdRep = tempIdRep + 1;
									}

									if (tempIdRep >= lenFileReplicationMax) {
										tempIdRep = 0;
									}

									if (tempId >= lenListDistinctNodes) {
										tempId = 0;
									}

									sequenceNo = sequenceNo + 1;

									encyrptBuffer.append(encyption1);
								}
							}

						}

					}
				}

				// End of Encryption
				PDPage page = new PDPage();
				PDPageContentStream contentStream = new PDPageContentStream(encyptedDocument, page);
				contentStream.beginText();
				// Setting the font to the Content stream
				contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
				// Setting the position for the line
				contentStream.newLineAtOffset(25, 500);
				contentStream.showText(encyrptBuffer.toString());
				contentStream.endText();
				contentStream.close();
				encyptedDocument.addPage(page);
				pageNo = pageNo + 1;
			}

			// End of Pages
			encyptedDocument.save(encyptionFullName);
			encyptedDocument.close();

			/* Saving of the File Data Document **/

			statusInfo = saveEncrytedFileInformation(eedrModel, fileStorage, userInfoRouteSession, encyptionFullName);

			// Saving the File
			statusInfo.setStatus(true);
		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
			return statusInfo;
		}
		return statusInfo;
	}

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	private double bytesToMegabytesDouble(double bytes) {
		return ((double) bytes / (double) MEGABYTE);
	}

	private double bytesToKilobytesDouble(double fileSizeInBytes) {
		double fileSizeInKB = (double) fileSizeInBytes / (double) 1024;
		return fileSizeInKB;
	}

	private StatusInfo saveEncrytedFileInformation(EEDRModel eedrModel, FileStorage fileStorage,
			UserInfoRouteSession userInfoRouteSession, String encyptionFullName) throws IOException {
		StatusInfo statusInfo = new StatusInfo();
		try {
			Path pdfPath = Paths.get(encyptionFullName);

			byte[] pdf = Files.readAllBytes(pdfPath);

			FileEncStorage fileEnc = new FileEncStorage();

			fileEnc.setData(pdf);
			fileEnc.setFilename(encyptionFullName);
			fileEnc.setFiletype(".pdf");
			fileEnc.setOrginalname(eedrModel.getMultipartFile().getOriginalFilename());
			fileEnc.setSecretkey(fileStorage.getSecretkey());
			fileEnc.setUserinforoutesession(userInfoRouteSession);

			FileEncStorage fileEnc1 = fileEncStorageRepository.save(fileEnc);

			if (fileEnc1 != null && fileEnc1.getFilestorageid() > 0) {
				BytesInfo bytesInfo = new BytesInfo();
				bytesInfo.setEncryptionBytes(pdf.length);
				statusInfo.setModel(bytesInfo);
				statusInfo.setStatus(true);
			}

		} catch (Exception e) {

			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());

		}
		return statusInfo;

	}

	private FileChunckStorage saveFileChunkData(List<Integer> listDistinctNodes, FileStorage fileStorage,
			String algorithmName, StringBuffer bufferAlgoProposed, int sequenceNo, int tempId, String text1,
			String encyption1, int pageNo, String sessionId, String userName) {
		FileChunckStorage fileChunkStorage = new FileChunckStorage();
		fileChunkStorage.setDatachunk(text1);

		fileChunkStorage.setEncryptedchunk(encyption1);
		fileChunkStorage.setSequeneno(sequenceNo);
		fileChunkStorage.setFilestorage(fileStorage);
		fileChunkStorage.setNodeId(listDistinctNodes.get(tempId));
		fileChunkStorage.setAlgorithmName(algorithmName);
		fileChunkStorage.setPageNo(pageNo);
		fileChunkStorage.setSessionId(sessionId);
		fileChunkStorage.setUserName(userName);

		bufferAlgoProposed.append(encyption1);

		FileChunckStorage fileChunkStorage1 = fileChunkStorageRepository.save(fileChunkStorage);
		return fileChunkStorage1;
	}

	private FileReplicaStorage saveFileReplicaData(FileStorage fileStorage, List<Integer> fileReplicationNodes,
			String algorithmName, int sequenceNo, int tempIdRep, String text1, String encyption1, int pageNo,
			String sessionId, String userName) {
		FileReplicaStorage fileReplicaStorage = new FileReplicaStorage();
		fileReplicaStorage.setAlgorithmName(algorithmName);
		fileReplicaStorage.setNodeId(fileReplicationNodes.get(tempIdRep));
		fileReplicaStorage.setFilestorage(fileStorage);
		fileReplicaStorage.setDatachunk(text1);
		fileReplicaStorage.setEncryptedchunk(encyption1);
		fileReplicaStorage.setSequeneno(sequenceNo);
		fileReplicaStorage.setPageNo(pageNo);
		fileReplicaStorage.setSessionId(sessionId);
		fileReplicaStorage.setUserName(userName);

		FileReplicaStorage fileReplicaStorage1 = fileReplicaStorageRepository.save(fileReplicaStorage);
		return fileReplicaStorage1;
	}

	private Pageable createPageRequest(int start, int end) {
		return new PageRequest(start, end);
	}

	public StatusInfo retriveChunksForCustomer(PaginationConfigVO paginationConfigVO, String userName) {

		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<FileChunckStorage> page = fileChunkStorageRepository.findByUserName(userName, pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.CHUNK_EMPTY));
				return statusInfo;
			}

			List<FileChunckStorage> listChucnk = page.getContent();

			if (null == listChucnk) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.CHUNK_EMPTY));
				return statusInfo;
			}

			for (FileChunckStorage fileCh : listChucnk) {

				if (!fileCh.getAlgorithmName().equals(Messages.Algorithms.OPTIMIZED)) {
					fileCh.setEncryptedchunk(fileCh.getDatachunk());
				}
			}

			statusInfo.setModel(listChucnk);
			statusInfo.setStatus(true);

			long totalRecords = fileChunkStorageRepository.countByUserName(userName);

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.CHUNK_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;

	}

	public StatusInfo retriveReplicaChunksForCustomer(PaginationConfigVO paginationConfigVO, String userName) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<FileReplicaStorage> page = fileReplicaStorageRepository.findByUserName(userName, pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			List<FileReplicaStorage> listChucnk = page.getContent();

			if (null == listChucnk) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			for (FileReplicaStorage fileCh : listChucnk) {

				if (!fileCh.getAlgorithmName().equals(Messages.Algorithms.OPTIMIZED)) {
					fileCh.setEncryptedchunk(fileCh.getDatachunk());
				}
			}

			statusInfo.setModel(listChucnk);
			statusInfo.setStatus(true);

			long totalRecords = fileReplicaStorageRepository.countByUserName(userName);

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveAllChunks(PaginationConfigVO paginationConfigVO) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<FileChunckStorage> page = fileChunkStorageRepository.findAll(pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			List<FileChunckStorage> listChucnk = page.getContent();

			if (null == listChucnk) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			for (FileChunckStorage fileCh : listChucnk) {

				if (!fileCh.getAlgorithmName().equals(Messages.Algorithms.OPTIMIZED)) {
					fileCh.setEncryptedchunk(fileCh.getDatachunk());
				}
			}

			statusInfo.setModel(listChucnk);
			statusInfo.setStatus(true);

			long totalRecords = fileChunkStorageRepository.count();

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveAllReplicas(PaginationConfigVO paginationConfigVO) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<FileReplicaStorage> page = fileReplicaStorageRepository.findAll(pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			List<FileReplicaStorage> listReplica = page.getContent();

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			for (FileReplicaStorage fileCh : listReplica) {

				if (!fileCh.getAlgorithmName().equals(Messages.Algorithms.OPTIMIZED)) {
					fileCh.setEncryptedchunk(fileCh.getDatachunk());
				}
			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = fileReplicaStorageRepository.count();

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.REPLICA_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveUserBasedTColorSessionInformation(PaginationConfigVO paginationConfigVO, String userName) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<UserInfoRouteSession> page = userInfoRouteSessionRepository.findByUsername(userName, pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.TCOLOR_INFO_EMPTY));
				return statusInfo;
			}

			List<UserInfoRouteSession> listReplica = page.getContent();

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.TCOLOR_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = userInfoRouteSessionRepository.countByUsername(userName);

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.TCOLOR_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveUserBasedTColorSessionInformation(PaginationConfigVO paginationConfigVO) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<UserInfoRouteSession> page = userInfoRouteSessionRepository.findAll(pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.TCOLOR_INFO_EMPTY));
				return statusInfo;
			}

			List<UserInfoRouteSession> listReplica = page.getContent();

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.TCOLOR_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = userInfoRouteSessionRepository.count();

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.TCOLOR_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveSecurityCompare(PaginationConfigVO paginationConfigVO) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<CompareAlgoResults> page = compareAlgoResultsRepository.findAll(pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			List<CompareAlgoResults> listReplica = page.getContent();

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = compareAlgoResultsRepository.count();

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveSecurityCompare() {
		StatusInfo statusInfo = new StatusInfo();
		try {

			List<CompareAlgoResults> listReplica = compareAlgoResultsRepository.findAll();

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			long total = compareAlgoResultsRepository.count();
			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);
			statusInfo.setTotal((int) total);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveFilesForCustomer(PaginationConfigVO paginationConfigVO, String userName) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			// Page<FileStorage> page =
			// fileStorageRepository.findByUserInfoRouteSessionUsername(userName,
			// pageable);

			Page<FileStorage> page = null;
			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			List<FileStorage> listChucnk = page.getContent();

			if (null == listChucnk) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			statusInfo.setModel(listChucnk);
			statusInfo.setStatus(true);

			// long totalRecords =
			// fileStorageRepository.countByUserInfoRouteSessionUsername(userName);
			long totalRecords = 10;
			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveAllFiles(PaginationConfigVO paginationConfigVO) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<FileStorageLite> page = fileStorageLiteRepository.findAll(pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			List<FileStorageLite> listChucnk = page.getContent();

			if (null == listChucnk) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			for (FileStorageLite fileStorage1 : listChucnk) {
				System.out.println("User Session Details:" + fileStorage1.getUserinforoutesession());

				System.out.println(
						"User Session Details Username:" + fileStorage1.getUserinforoutesession().getUsername());

				System.out.println(
						"User Session Details Session:" + fileStorage1.getUserinforoutesession().getSessionid());

				System.out.println("User Session Details Algorithm Type:"
						+ fileStorage1.getUserinforoutesession().getAlgorithmtype());

				System.out.println("User Session Details:" + fileStorage1.getUserinforoutesession().getUsername());
			}

			statusInfo.setModel(listChucnk);
			statusInfo.setStatus(true);

			long totalRecords = fileStorageLiteRepository.count();
			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveAllEncFiles(PaginationConfigVO paginationConfigVO) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<FileEncStorageLite> page = fileEncStorageLiteRepository.findByFilenameContaining("ENCRYPTOPTIMIZED",
					pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			List<FileEncStorageLite> listChucnk = page.getContent();

			if (null == listChucnk) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			statusInfo.setModel(listChucnk);
			statusInfo.setStatus(true);

			long totalRecords = fileEncStorageLiteRepository.count();
			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveAllFilesByUserName(PaginationConfigVO paginationConfigVO, String userName) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<FileStorageLite> page = fileStorageLiteRepository.findByUserinforoutesession_username(pageable,
					userName);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			List<FileStorageLite> listChucnk = page.getContent();

			if (null == listChucnk) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			statusInfo.setModel(listChucnk);
			statusInfo.setStatus(true);

			long totalRecords = fileStorageLiteRepository.countByUserinforoutesession_username(userName);
			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.FILE_STORAGE_DATA_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo compareFileCompareData(PaginationConfigVO paginationConfigVO) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<CompareSizeAlgo> page = compareFileSizeRepository.findAll(pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			List<CompareSizeAlgo> listReplica = page.getContent();

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = compareFileSizeRepository.count();

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo fileSizeDataGraph() {
		StatusInfo statusInfo = new StatusInfo();
		try {

			List<CompareSizeAlgo> listReplica = compareFileSizeRepository.findByOrderByOriginalFileBytesAsc();

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			for (CompareSizeAlgo compareSizeAlgo : listReplica) {

				compareSizeAlgo.setMemoryBetweenCentrality(
						bytesToMegabytesDouble(compareSizeAlgo.getMemoryBetweenCentrality()));
				compareSizeAlgo.setMemoryBetweenECentrality(
						bytesToMegabytesDouble(compareSizeAlgo.getMemoryBetweenECentrality()));
				compareSizeAlgo.setMemoryClosenessCentrality(
						bytesToMegabytesDouble(compareSizeAlgo.getMemoryClosenessCentrality()));
				compareSizeAlgo.setMemoryOptimizedCentrality(
						bytesToMegabytesDouble(compareSizeAlgo.getMemoryOptimizedCentrality()));

			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = compareFileSizeRepository.count();

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo downloadTimeData(PaginationConfigVO paginationConfigVO) {
		StatusInfo statusInfo = new StatusInfo();
		try {

			Pageable pageable = createPageRequest(paginationConfigVO.getPage() - 1, paginationConfigVO.getLimit());

			Page<DownloadAlgorithmicStorage> page = downloadAlgorithmStorageRepository.findAll(pageable);

			if (null == page) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			List<DownloadAlgorithmicStorage> listReplica = page.getContent();

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = downloadAlgorithmStorageRepository.count();

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo retriveDownloadComputationForOptimized() {
		StatusInfo statusInfo = new StatusInfo();
		try {

			List<DownloadAlgorithmicStorage> listReplica = downloadAlgorithmStorageRepository
					.findByAlgorithmicnameOrderByOrginalFileBytesAsc(Messages.Algorithms.OPTIMIZED);
			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			for (DownloadAlgorithmicStorage downloadAlgo : listReplica) {

				double fileBytes = bytesToKilobytesDouble(downloadAlgo.getOrginalFileBytes());
				downloadAlgo.setOrginalFileBytes((int) fileBytes);

			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = downloadAlgorithmStorageRepository
					.countByAlgorithmicname(Messages.Algorithms.OPTIMIZED);

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo downloadTimeForClosenessCentrality() {
		StatusInfo statusInfo = new StatusInfo();
		try {

			List<DownloadAlgorithmicStorage> listReplica = downloadAlgorithmStorageRepository
					.findByAlgorithmicnameOrderByOrginalFileBytesAsc(Messages.Algorithms.CLOSENESS_CENTRALITY);

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			for (DownloadAlgorithmicStorage downloadAlgo : listReplica) {

				double fileBytes = bytesToKilobytesDouble(downloadAlgo.getOrginalFileBytes());
				downloadAlgo.setOrginalFileBytes((int) fileBytes);

			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = downloadAlgorithmStorageRepository
					.countByAlgorithmicname(Messages.Algorithms.CLOSENESS_CENTRALITY);

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo downloadTimeForBetweenCentrality() {
		StatusInfo statusInfo = new StatusInfo();
		try {

			List<DownloadAlgorithmicStorage> listReplica = downloadAlgorithmStorageRepository
					.findByAlgorithmicnameOrderByOrginalFileBytesAsc(Messages.Algorithms.BETWEEN_CENTRALITY);

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			for (DownloadAlgorithmicStorage downloadAlgo : listReplica) {

				double fileBytes = bytesToKilobytesDouble(downloadAlgo.getOrginalFileBytes());
				downloadAlgo.setOrginalFileBytes((int) fileBytes);

			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = downloadAlgorithmStorageRepository
					.countByAlgorithmicname(Messages.Algorithms.BETWEEN_CENTRALITY);

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

	public StatusInfo downloadTimeForECentrality() {
		StatusInfo statusInfo = new StatusInfo();
		try {

			List<DownloadAlgorithmicStorage> listReplica = downloadAlgorithmStorageRepository
					.findByAlgorithmicnameOrderByOrginalFileBytesAsc(Messages.Algorithms.ECENTRALITY);

			if (null == listReplica) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			for (DownloadAlgorithmicStorage downloadAlgo : listReplica) {

				double fileBytes = bytesToKilobytesDouble(downloadAlgo.getOrginalFileBytes());
				downloadAlgo.setOrginalFileBytes((int) fileBytes);

			}

			statusInfo.setModel(listReplica);
			statusInfo.setStatus(true);

			long totalRecords = downloadAlgorithmStorageRepository
					.countByAlgorithmicname(Messages.Algorithms.ECENTRALITY);

			if (totalRecords <= 0) {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg(environment.getProperty(DropsAppConstants.COMPARE_INFO_EMPTY));
				return statusInfo;
			}

			statusInfo.setTotal((int) totalRecords);

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

}
