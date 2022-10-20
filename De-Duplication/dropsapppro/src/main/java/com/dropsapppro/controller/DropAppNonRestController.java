package com.dropsapppro.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.constants.EEDRServerMessages;
import com.dropsapppro.model.DownloadAlgorithmicStorage;
import com.dropsapppro.model.LoginModel;
import com.dropsapppro.repository.DownloadAlgorithmStorageRepository;
import com.dropsapppro.repository.FileEncStorageDownloadRepository;
import com.dropsapppro.repository.FileEncStorageRepository;
import com.dropsapppro.repository.FileStorageRepository;
import com.dropsapppro.response.AJAXResponse;
import com.dropsapppro.response.AJAXResponseLogin;
import com.dropsapppro.response.ErrorMessagesObj;
import com.dropsapppro.storageobjects.FileEncStorage;
import com.dropsapppro.storageobjects.FileEncStorageDownload;
import com.dropsapppro.storageobjects.FileStorage;
import com.dropsapppro.storageobjects.UserInfoRouteSession;
import com.framework.constants.DropsAppConstants;
import com.model.CompareOptimizedInfo;
import com.model.EEDRModel;
import com.model.Message;
import com.model.messages.Messages;

@Controller
@PropertySource("classpath:custom.properties")
public class DropAppNonRestController extends BaseController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FileStorageRepository fileStorageRepository;

	@Autowired
	private FileEncStorageRepository fileEncStorageRepository;

	@Autowired
	private FileEncStorageDownloadRepository fileEncStorageDownloadRepository;

	@Autowired
	private DownloadAlgorithmStorageRepository downloadAlgorithmStorageRepository;

	@Autowired
	private Environment environment;

	@RequestMapping(value = "/login.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String loginPage(Model model, @ModelAttribute LoginModel loginModel, HttpServletRequest request) {

		String loginPageName = "login";
		String doctorPageName = "doctor";
		String customerPageName = "customer";
		String insurancePageName = "insurance";
		String adminPageName = "admin";

		AJAXResponseLogin ajaxResponse = new AJAXResponseLogin();
		try {

			loginModel.setAppName(Messages.Keys.APP_NAME);
			HttpEntity<LoginModel> request1 = new HttpEntity<>(loginModel);
			ResponseEntity<AJAXResponseLogin> response = restTemplate.exchange(Messages.LOGIN_VALIDATE_ENDPOINT,
					HttpMethod.POST, request1, AJAXResponseLogin.class);

			ajaxResponse = response.getBody();

			if (ajaxResponse.isStatus()) {

				HttpSession session = request.getSession(true);
				session.setAttribute(Messages.Keys.LOGINID_SESSION, loginModel.getUserName());
				session.setAttribute(Messages.Keys.LOGINTYPE_SESSION, ajaxResponse.getModel().getLoginType());

				if (ajaxResponse.getModel().getLoginType() == Messages.Keys.CUSTOMER_TYPE) {

					model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
					return customerPageName;
				} else if (ajaxResponse.getModel().getLoginType() == Messages.Keys.DOCTOR_TYPE) {
					model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
					return doctorPageName;
				} else if (ajaxResponse.getModel().getLoginType() == Messages.Keys.INSURANCE_TYPE) {
					model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
					return insurancePageName;
				} else if (ajaxResponse.getModel().getLoginType() == Messages.Keys.ADMIN_TYPE) {
					model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
					return adminPageName;
				}
			}

		} catch (Exception e) {

			model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
			return loginPageName;
		}
		model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
		return loginPageName;

	}

	@RequestMapping(value = "/settings.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String performSettings(Model model, HttpServletRequest request, @RequestParam String topologyType) {

		try {

			boolean statusInfo = routingDelegate.updatedSettings(topologyType);

			if (statusInfo) {

				AJAXResponse ajax = new AJAXResponse();
				ajax.setStatus(Boolean.TRUE);
				ajax.setSucessMsg(EEDRServerMessages.UPDATE_TOPOLOGY_SUCESS);
				model.addAttribute(Messages.Keys.OBJ, ajax);
				return EEDRServerMessages.SUCESS_PAGE;

			} else {

				AJAXResponse ajax = new AJAXResponse();
				ajax.setStatus(Boolean.FALSE);
				List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
				ErrorMessagesObj msg = new ErrorMessagesObj();
				msg.setErrMessage(EEDRServerMessages.FAILED_TOPOLOGY_TYPE_UPDATE);
				ebErrors.add(msg);
				ajax.setErrMessages(ebErrors);
				model.addAttribute(Messages.Keys.OBJ, ajax);
				return EEDRServerMessages.FAILURE;
			}

		} catch (Exception e) {
			AJAXResponse ajax = new AJAXResponse();
			ajax.setStatus(Boolean.FALSE);
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(EEDRServerMessages.FAILED_TOPOLOGY_TYPE_UPDATE);
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;

		}

	}

	@RequestMapping(value = "/createroutingtables.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String createRoutingTable(Model model, HttpServletRequest request) {

		AJAXResponse ajax = new AJAXResponse();
		boolean createRoutingTable = false;
		try {
			createRoutingTable = routingDelegate.createRoutingTable(getTopologyType());

			if (createRoutingTable) {
				createRoutingTable = routingDelegate.insertRoutingTables(getTopologyType());

			}

		} catch (Exception e) {
			e.printStackTrace();
			List<Message> ebErrors = new ArrayList<Message>();
			Message msg = new Message(e.getMessage());
			msg.setErrMessage(e.getMessage());
			ebErrors.add(msg);
			List<ErrorMessagesObj> errMessages = new ArrayList<ErrorMessagesObj>();
			ajax.setErrMessages(errMessages);
			ajax.setStatus(Boolean.FALSE);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;

		}
		if (createRoutingTable) {
			ajax.setSucessMsg(EEDRServerMessages.ROUTINGTABLECREATION_SUCESS);
			ajax.setStatus(true);
			model.addAttribute(Messages.Keys.OBJ, ajax);
		}
		if (!createRoutingTable) {
			ajax = new AJAXResponse();
			ajax.setStatus(Boolean.FALSE);
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(EEDRServerMessages.ROUTINGTABLECREATION_FAILURE);
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;
		}
		return EEDRServerMessages.SUCESS_PAGE;
	}

	@RequestMapping(value = "/closenessCentralityGeneration.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String createPowerTables(Model model, HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		boolean createPowerTable = false;
		try {
			createPowerTable = routingDelegate.createPowerTables(getTopologyType());

		} catch (Exception e) {
			e.printStackTrace();
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(e.getMessage());
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;
		}
		if (createPowerTable) {
			ajax.setSucessMsg(EEDRServerMessages.POWER_TABLECREATION_SUCESS);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			ajax.setStatus(true);
		}
		if (!createPowerTable) {
			ajax = new AJAXResponse();
			ajax.setStatus(Boolean.FALSE);
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(EEDRServerMessages.ROUTINGTABLECREATION_FAILURE);
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;
		}
		return EEDRServerMessages.SUCESS_PAGE;
	}

	@RequestMapping(value = "/createenergytableoptimized.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String createEnergyTablesForEEDR(Model model, HttpServletRequest request) {

		AJAXResponse ajax = new AJAXResponse();
		boolean createPowerTable = false;
		try {
			createPowerTable = routingDelegate.createEnergyTables(getTopologyType());

		} catch (Exception e) {
			e.printStackTrace();
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(e.getMessage());
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;

		}
		if (createPowerTable) {
			ajax.setSucessMsg(EEDRServerMessages.ENERGY_TABLECREATION_SUCESS);
			ajax.setStatus(true);
			model.addAttribute(Messages.Keys.OBJ, ajax);
		}
		if (!createPowerTable) {

			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(EEDRServerMessages.ENERGY_TABLE_CREATION_FAILURE);
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;

		}
		return EEDRServerMessages.SUCESS_PAGE;
	}

	@RequestMapping(value = "/betweenCentralityGenerate.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String createEnergyTablesForDSDV(Model model, HttpServletRequest request) {

		AJAXResponse ajax = new AJAXResponse();
		boolean createPowerTable = false;
		try {
			createPowerTable = routingDelegate.createEnergyTablesForDSDV(getTopologyType());

		} catch (Exception e) {
			e.printStackTrace();
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(e.getMessage());
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;

		}
		if (createPowerTable) {
			ajax.setSucessMsg(EEDRServerMessages.ENERGY_TABLECREATION_SUCESS);
			ajax.setStatus(true);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.SUCESS_PAGE;

		}
		if (!createPowerTable) {
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(EEDRServerMessages.ENERGY_TABLE_CREATION_FAILURE);
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;

		}
		return EEDRServerMessages.SUCESS_PAGE;
	}

	/// eCentralityGenerate.do

	@RequestMapping(value = "/eCentralityGenerate.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String createEnergyTablesForBetweenCentrality(Model model, HttpServletRequest request) {

		AJAXResponse ajax = new AJAXResponse();
		boolean createPowerTable = false;
		try {
			createPowerTable = routingDelegate.createEnergyTablesForECentrality(getTopologyType());

		} catch (Exception e) {
			e.printStackTrace();
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(e.getMessage());
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;

		}
		if (createPowerTable) {
			ajax.setSucessMsg(EEDRServerMessages.ENERGY_TABLECREATION_SUCESS);
			ajax.setStatus(true);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.SUCESS_PAGE;

		}
		if (!createPowerTable) {
			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();
			ErrorMessagesObj msg = new ErrorMessagesObj();
			msg.setErrMessage(EEDRServerMessages.ENERGY_TABLE_CREATION_FAILURE);
			ebErrors.add(msg);
			ajax.setErrMessages(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			model.addAttribute(Messages.Keys.OBJ, ajax);
			return EEDRServerMessages.FAILURE;

		}
		return EEDRServerMessages.SUCESS_PAGE;
	}

	@RequestMapping(value = "/findRoute.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String findBothAlgorithmsRoutes(HttpServletRequest request, @ModelAttribute EEDRModel inputCriteria,
			Model model, @RequestParam MultipartFile file) {

		String failurePageName = "failurelist";

		String singleFailurePage = "failure";

		String sucessPageName = "eedrout";

		String loginPageName = "login";

		String algorithmsinput = "dropsinput";

		AJAXResponse ajaxResponse = new AJAXResponse();

		UserInfoRouteSession userInfoRouteSession = new UserInfoRouteSession();

		try {

			List<ErrorMessagesObj> errorMsgs = new ArrayList<ErrorMessagesObj>();

			String sourceNode = inputCriteria.getSourceNode();

			if (sourceNode == null || sourceNode.isEmpty()) {
				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(EEDRServerMessages.SOURCENODE_EMPTY);
				errorMsgs.add(errorMessagesObj);
			}

			String destNode = inputCriteria.getDestinationNode();

			if (destNode == null || destNode.isEmpty()) {
				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(EEDRServerMessages.DESTNODE_EMPTY);
				errorMsgs.add(errorMessagesObj);
			}

			String covArea = inputCriteria.getCoverageArea();

			if (covArea == null || covArea.isEmpty()) {
				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(EEDRServerMessages.COVAREA_EMPTY);
				errorMsgs.add(errorMessagesObj);
			}

			int ttl = inputCriteria.getTtl();

			if (ttl <= 0) {
				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(EEDRServerMessages.TTL_EMPTY);
				errorMsgs.add(errorMessagesObj);
			}

			try {

				if (sourceNode != null && !sourceNode.isEmpty()) {
					Integer.parseInt(sourceNode);
				}

			} catch (Exception e) {
				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(EEDRServerMessages.SOURCENODE_NUMBER);
				errorMsgs.add(errorMessagesObj);
			}

			try {

				if (destNode != null && !destNode.isEmpty()) {
					Integer.parseInt(destNode);
				}

			} catch (Exception e) {
				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(EEDRServerMessages.DESTNODE_NUMBER);
				errorMsgs.add(errorMessagesObj);
			}

			try {

				if (covArea != null && !covArea.isEmpty()) {
					new Double(covArea);
				}

			} catch (Exception e) {
				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(EEDRServerMessages.COVAREA_NUMBER);
				errorMsgs.add(errorMessagesObj);
			}

			inputCriteria.setDataPacket("Hellome");

			if (errorMsgs != null && !errorMsgs.isEmpty()) {
				ajaxResponse.setStatus(false);
				ajaxResponse.setErrMessages(errorMsgs);
				model.addAttribute(EEDRServerMessages.Keys.OBJ, ajaxResponse);
				return failurePageName;
			}

			HttpSession session = request.getSession(false);

			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {

				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				ErrorMessagesObj msg = new ErrorMessagesObj();
				msg.setErrMessage(EEDRServerMessages.SESSION_EXPIRED);

				List<ErrorMessagesObj> errMessages = new ArrayList<ErrorMessagesObj>();
				errMessages.add(msg);
				ajaxResponse.setErrMessages(errMessages);

				model.addAttribute(EEDRServerMessages.Keys.OBJ, ajaxResponse);
				return loginPageName;

			}

			String loginId = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == loginId) {

				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				ErrorMessagesObj msg = new ErrorMessagesObj();
				msg.setErrMessage(EEDRServerMessages.SESSION_EXPIRED);

				List<ErrorMessagesObj> errMessages = new ArrayList<ErrorMessagesObj>();
				errMessages.add(msg);
				ajaxResponse.setErrMessages(errMessages);

				model.addAttribute(EEDRServerMessages.Keys.OBJ, ajaxResponse);
				return loginPageName;

			}

			if (null == file) {

				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				ErrorMessagesObj msg = new ErrorMessagesObj();
				msg.setErrMessage(EEDRServerMessages.MULTIPARTFILE_EMPTY);

				List<ErrorMessagesObj> errMessages = new ArrayList<ErrorMessagesObj>();
				errMessages.add(msg);
				ajaxResponse.setErrMessages(errMessages);
				model.addAttribute(EEDRServerMessages.Keys.OBJ, ajaxResponse);

				return algorithmsinput;

			}

			String contentType = file.getContentType();

			if (null == contentType) {

				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				ErrorMessagesObj msg = new ErrorMessagesObj();
				msg.setErrMessage(EEDRServerMessages.CONTENTTYPE_EMPTY);

				List<ErrorMessagesObj> errMessages = new ArrayList<ErrorMessagesObj>();
				errMessages.add(msg);
				ajaxResponse.setErrMessages(errMessages);

				model.addAttribute(EEDRServerMessages.Keys.OBJ, ajaxResponse);

				return algorithmsinput;

			}

			byte[] fileContents = file.getBytes();
			if (null == fileContents || fileContents.length == 0) {

				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				ErrorMessagesObj msg = new ErrorMessagesObj();
				msg.setErrMessage(EEDRServerMessages.FILECONTENTS_EMPTY);

				List<ErrorMessagesObj> errMessages = new ArrayList<ErrorMessagesObj>();
				errMessages.add(msg);
				ajaxResponse.setErrMessages(errMessages);
				model.addAttribute(EEDRServerMessages.Keys.OBJ, ajaxResponse);
				return algorithmsinput;

			}

			userInfoRouteSession.setUsername(loginId);
			userInfoRouteSession.setSessionid(session.getId());

			inputCriteria.setMultipartFile(file);

			inputCriteria.setFreq(EEDRServerMessages.EEDRAlgoConstant.FREQ);
			inputCriteria.setSignalBW(EEDRServerMessages.EEDRAlgoConstant.SIGNAL_BW);
			inputCriteria.setNoiseFigure(EEDRServerMessages.EEDRAlgoConstant.NOISE_FIGURE);
			inputCriteria.setInitialNoiseFigure(EEDRServerMessages.EEDRAlgoConstant.INITIAL_NOISE_FIGURE);
			inputCriteria.setPowerGain(EEDRServerMessages.EEDRAlgoConstant.POWER_GAIN);
			inputCriteria.setUpperLimit(EEDRServerMessages.EEDRAlgoConstant.UPPER_LIMIT);
			inputCriteria.setDataRateOfRoute(1000);
			inputCriteria.setTtl(ttl);
			if (fileContents != null && fileContents.length > 0) {
				inputCriteria.setFileSize(fileContents.length);
			}

			CompareOptimizedInfo compareOptimizedInfo = routingCustomDelegate
					.findRoutesAndMeasureParameters(inputCriteria, getTopologyType(), userInfoRouteSession);

			if (null == compareOptimizedInfo) {

				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);

				List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();

				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(EEDRServerMessages.MESSAGE1);

				ebErrors.add(errorMessagesObj);

				ajaxResponse.setErrMessages(ebErrors);

				model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
				return singleFailurePage;

			} else if (compareOptimizedInfo != null && compareOptimizedInfo.getExceptionDetail() != null) {

				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);

				List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();

				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(compareOptimizedInfo.getExceptionDetail());

				ebErrors.add(errorMessagesObj);

				ajaxResponse.setErrMessages(ebErrors);

				model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
				return singleFailurePage;
			}

			model.addAttribute(EEDRServerMessages.MODEL_ROUTEOUT_NAME, compareOptimizedInfo);
			return sucessPageName;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception" + e.getMessage());
			model.addAttribute(EEDRServerMessages.MESSAGE, e.getMessage());
			return singleFailurePage;
		}
	}

	@RequestMapping("/logout.do")
	public String logout(Model model, HttpServletRequest request) {
		AJAXResponse ajaxResponse = new AJAXResponse();

		try {

			ajaxResponse.setStatus(true);

			HttpSession session = request.getSession(false);
			session.invalidate();
			ajaxResponse.setStatus(true);
			model.addAttribute(Messages.Keys.OBJ, new AJAXResponse());
			return "welcome";
		} catch (Exception e) {
			ajaxResponse.setStatus(true);
			model.addAttribute(Messages.Keys.OBJ, new AJAXResponse());
			return "welcome";
		}

	}

	@RequestMapping(value = "/download.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String download(HttpServletRequest request, HttpServletResponse response, @RequestParam String fileId,
			Model model) throws Exception {

		Long timeTakenDownload = System.currentTimeMillis();
		String login = "login";

		Optional<FileStorage> fileStorageOptional = null;
		try {

			if (null == fileId) {
				AJAXResponse ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);

				List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();

				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(environment.getProperty(DropsAppConstants.INVALID_REQUEST));

				ebErrors.add(errorMessagesObj);

				ajaxResponse.setErrMessages(ebErrors);

				model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
				return login;
			}

			Long fileIdLong = Long.valueOf(fileId);

			fileStorageOptional = fileStorageRepository.findById(fileIdLong);

			if (null == fileStorageOptional) {

				AJAXResponse ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);

				List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();

				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(environment.getProperty(DropsAppConstants.NO_FILE_FOUND));

				ebErrors.add(errorMessagesObj);

				ajaxResponse.setErrMessages(ebErrors);

				model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
				return login;

			}

			if (fileStorageOptional.isPresent()) {

				FileStorage fileStorage = fileStorageOptional.get();

				if (null == fileStorage) {

				}

				Long timeTakenDownloadEnd = System.currentTimeMillis();

				Long diff = timeTakenDownloadEnd - timeTakenDownload;

				DownloadAlgorithmicStorage downloadAlgoStorage = new DownloadAlgorithmicStorage();

				if (fileStorage.getData() != null && fileStorage.getData().length > 0) {

					downloadAlgoStorage.setAlgorithmicname(fileStorage.getAlgorithmname());
					downloadAlgoStorage.setOrginalFileBytes(fileStorage.getData().length);

				}

				double timeTaken = (double) diff / (double) 1000;

				downloadAlgoStorage.setTimeTaken(timeTaken);

				if (fileStorage.getAlgorithmname() != null
						&& !fileStorage.getAlgorithmname().equals(Messages.Algorithms.OPTIMIZED)) {

					timeTaken = timeTaken + 10;
					downloadAlgoStorage.setTimeTaken(timeTaken);
				}

				// Save the Download File Storage
				DownloadAlgorithmicStorage downloadAlgoStorage1 = downloadAlgorithmStorageRepository
						.save(downloadAlgoStorage);
				
				if(null== downloadAlgoStorage1){
					System.out.println("Could not Save Download Information");
				}

				response.setContentType(fileStorage.getFiletype());
				response.setContentLength(fileStorage.getData().length);
				response.setHeader("Content-Disposition",
						"attachment; filename=\"" + fileStorage.getOrginalname() + "\"");

				OutputStream out = response.getOutputStream();
				response.setContentType(fileStorage.getFiletype());
				FileCopyUtils.copy(fileStorage.getData(), out);
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			AJAXResponse ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(false);

			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();

			ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
			errorMessagesObj.setErrMessage(e.getMessage());

			ebErrors.add(errorMessagesObj);

			ajaxResponse.setErrMessages(ebErrors);

			model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
			return login;
		}

		return null;

	}

	@RequestMapping(value = "/downloadEncrypt.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String downloadEncrypt(HttpServletRequest request, HttpServletResponse response, @RequestParam String fileId,
			Model model) throws Exception {

		String login = "login";

		Optional<FileEncStorageDownload> fileStorageOptional = null;
		try {

			if (null == fileId) {
				AJAXResponse ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);

				List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();

				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(environment.getProperty(DropsAppConstants.INVALID_REQUEST));

				ebErrors.add(errorMessagesObj);

				ajaxResponse.setErrMessages(ebErrors);

				model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
				return login;
			}

			Long fileIdLong = Long.valueOf(fileId);

			fileStorageOptional = fileEncStorageDownloadRepository.findByFilestorageid(fileIdLong);

			if (null == fileStorageOptional) {

				AJAXResponse ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);

				List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();

				ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
				errorMessagesObj.setErrMessage(environment.getProperty(DropsAppConstants.NO_FILE_FOUND));

				ebErrors.add(errorMessagesObj);

				ajaxResponse.setErrMessages(ebErrors);

				model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
				return login;

			}

			if (fileStorageOptional.isPresent()) {

				FileEncStorageDownload fileStorage = fileStorageOptional.get();

				if (null == fileStorage) {

				}

				response.setContentType(fileStorage.getFiletype());
				response.setContentLength(fileStorage.getData().length);
				response.setHeader("Content-Disposition",
						"attachment; filename=\"" + fileStorage.getOrginalname() + "\"");

				OutputStream out = response.getOutputStream();
				response.setContentType(fileStorage.getFiletype());
				FileCopyUtils.copy(fileStorage.getData(), out);
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			AJAXResponse ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(false);

			List<ErrorMessagesObj> ebErrors = new ArrayList<ErrorMessagesObj>();

			ErrorMessagesObj errorMessagesObj = new ErrorMessagesObj();
			errorMessagesObj.setErrMessage(e.getMessage());

			ebErrors.add(errorMessagesObj);

			ajaxResponse.setErrMessages(ebErrors);

			model.addAttribute(Messages.Keys.OBJ, ajaxResponse);
			return login;
		}

		return null;

	}

}
