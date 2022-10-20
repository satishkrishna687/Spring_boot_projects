package com.algorithm.comparefacade.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algorithms.comparefacade.inter.OptimizedAndOtherAlgorithmsCompareFacade;
import com.framework.constants.FrameworkConstantsIF;
import com.framework.encdec.util.EncryptDecrypUtil;
import com.model.CompareOptimizedInfo;
import com.model.IPAdressVO;
import com.routingtopology.constants.ParametersTypeIF;
import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.dao.impl.IPAddressMaintainenceDAOImpl;
import com.routingtopology.dao.inter.IPAddressMaintainenceDAOIF;
import com.routingtopology.service.impl.ParametersServiceImpl;
import com.routingtopology.service.impl.PerformanceServiceImpl;
import com.routingtopology.service.impl.TopologyRoutingServiceImpl;
import com.routingtopology.service.inter.ParametersService1IF;
import com.routingtopology.service.inter.ParametersServiceIF;
import com.routingtopology.service.inter.PerformanceServiceIF;
import com.routingtopology.service.inter.TopologyRoutingServiceIF;
import com.routingtopology.value.ClosenessCentralityCriteria;
import com.routingtopology.value.ClosenessCentralityRouteInfo;
import com.routingtopology.value.BetweenCentralityCriteria;
import com.routingtopology.value.BetweenCentralityRouteInfo;
import com.routingtopology.value.DeadNodesInfo;
import com.routingtopology.value.ECentralityCriteria;
import com.routingtopology.value.ECentralityRouteInfo;
import com.routingtopology.value.OptimizedCriteria;
import com.routingtopology.value.OptimizedRouteInfo;
import com.routingtopology.value.ErrorInfo;
import com.routingtopology.value.FaultNodeCriteria;
import com.routingtopology.value.FaultNodeRouteInfo;
import com.routingtopology.value.GradeFaultInfo;
import com.routingtopology.value.GradeRouteCriteria;
import com.routingtopology.value.GradeRouteInfo;
import com.routingtopology.value.ParameterValue;
import com.routingtopology.value.RouteInfo;
import com.sun.corba.se.spi.orbutil.fsm.State;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;

import com.algorithms.service.impl.ClosenessCentralityRoutingServiceImpl;
import com.algorithms.service.impl.ECentralityRoutingServiceImpl;
import com.algorithms.service.impl.BetweenCentralityRoutingServiceImpl;
import com.algorithms.service.impl.OptimizedRoutingServiceImpl;
import com.algorithms.service.inter.ClosenessCentralityServiceIF;
import com.algorithms.service.inter.BetweenCentralityServiceIF;
import com.algorithms.service.inter.OptimizedServiceIF;

@Service
public class OptimizedAndOtherAlgorithmsCompareFacadeImpl implements OptimizedAndOtherAlgorithmsCompareFacade {

	private String CLASS_NAME = "OptimizedAndOtherAlgorithmsCompareFacade";

	@Autowired
	private OptimizedRoutingServiceImpl optimizedRoutingService;

	private final String USER_AGENT = "Mozilla/5.0";

	@Autowired
	private ClosenessCentralityRoutingServiceImpl closenessCentralityRoutingServiceImpl;

	@Autowired
	private BetweenCentralityRoutingServiceImpl betweenCentralityRoutingServiceImpl;

	@Autowired
	private ECentralityRoutingServiceImpl eCentralityRoutingServiceImpl;

	@Autowired
	private PerformanceServiceImpl performanceServiceIF;

	@Autowired
	private ParametersServiceImpl parameterServiceIF;

	@Autowired
	private TopologyRoutingServiceImpl topologyRoutingServiceIF;

	@Autowired
	private IPAddressMaintainenceDAOImpl iPAddressMaintainenceDao;

	@Override
	public CompareOptimizedInfo executeOptimizedCompareAlgorithms(
			ClosenessCentralityCriteria closenessCentralityCriteria,
			BetweenCentralityCriteria betweenCentralityCriteria, OptimizedCriteria optimizedCriteria,
			ECentralityCriteria eCentralityCriteria, String topologyType) throws ParseException {

		CompareOptimizedInfo compareOptimizedInfoObj = null;

		boolean isDateFull = true;

		if (!isDateFull) {

			compareOptimizedInfoObj = new CompareOptimizedInfo();

			compareOptimizedInfoObj.setStatus(false);
			compareOptimizedInfoObj.setExceptionDetail("License Expired");
			return compareOptimizedInfoObj;

		}

		List<Double> timeTakenList = new ArrayList<Double>();

		List<Integer> hopsList = new ArrayList<Integer>();

		List<Double> ecList = new ArrayList<Double>();

		List<Integer> aliveNodesList = new ArrayList<Integer>();

		List<Integer> deadNodesList = new ArrayList<Integer>();

		List<Double> lifeTimeRatioList = new ArrayList<Double>();

		List<Double> routingOverheadList = new ArrayList<Double>();

		List<Double> throughputList = new ArrayList<Double>();

		List<Double> residualEnergyList = new ArrayList<Double>();

		try {
			compareOptimizedInfoObj = new CompareOptimizedInfo();

			OptimizedRouteInfo optimizedRouteInfo = optimizedRoutingService.findOptimizedRoutes(optimizedCriteria,
					topologyType);

			int count = 0;

			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				count = topologyRoutingServiceIF.retriveLinearTopologyCount();
			} else {
				count = topologyRoutingServiceIF.retriveAngularTopologyCount();
			}

			double totalEnergyOptimized = computeTotalResidualEnergy(count, ParametersTypeIF.ENERGY);

			if (optimizedRouteInfo != null) {

				timeTakenList.add(optimizedRouteInfo.getTimeTaken());
				hopsList.add(optimizedRouteInfo.getNoOfHopsConsumed());
				ecList.add(optimizedRouteInfo.getEnergyConsumed());
				aliveNodesList.add(optimizedRouteInfo.getNoOfAliveNodes());
				deadNodesList.add(optimizedRouteInfo.getNoOfDeadNodes());
				lifeTimeRatioList.add(optimizedRouteInfo.getLifeTimeRatio());
				residualEnergyList.add(totalEnergyOptimized);
				routingOverheadList.add(optimizedRouteInfo.getRoutingOverhead());
				throughputList.add(optimizedRouteInfo.getThroughput());
			}

			ClosenessCentralityRouteInfo closenessCentralityRouteInfo = closenessCentralityRoutingServiceImpl
					.findClosenessCentralityRoutes(closenessCentralityCriteria, topologyType);

			if (closenessCentralityRouteInfo != null) {

				timeTakenList.add(closenessCentralityRouteInfo.getTimeTaken());
				hopsList.add(closenessCentralityRouteInfo.getNoOfHopsConsumed());
				ecList.add(closenessCentralityRouteInfo.getEnergyConsumed());
				aliveNodesList.add(closenessCentralityRouteInfo.getNoOfAliveNodes());
				deadNodesList.add(closenessCentralityRouteInfo.getNoOfDeadNodes());
				lifeTimeRatioList.add(closenessCentralityRouteInfo.getLifeTimeRatio());

				routingOverheadList.add(closenessCentralityRouteInfo.getRoutingOverhead());
				throughputList.add(closenessCentralityRouteInfo.getThroughput());

			}

			double totalEnergyClosenessCentrality = computeTotalResidualEnergy(count, ParametersTypeIF.POWER);
			residualEnergyList.add(totalEnergyClosenessCentrality);

			BetweenCentralityRouteInfo betweenCentralityRouteInfo = betweenCentralityRoutingServiceImpl
					.findBetweenCentralityRoutes(betweenCentralityCriteria, topologyType);

			if (betweenCentralityRouteInfo != null) {

				timeTakenList.add(betweenCentralityRouteInfo.getTimeTaken());
				hopsList.add(betweenCentralityRouteInfo.getNoOfHopsConsumed());
				ecList.add(betweenCentralityRouteInfo.getEnergyConsumed());
				aliveNodesList.add(betweenCentralityRouteInfo.getNoOfAliveNodes());
				deadNodesList.add(betweenCentralityRouteInfo.getNoOfDeadNodes());
				lifeTimeRatioList.add(betweenCentralityRouteInfo.getLifeTimeRatio());

				routingOverheadList.add(betweenCentralityRouteInfo.getRoutingOverhead());
				throughputList.add(betweenCentralityRouteInfo.getThroughput());

			}
			double totalEnergyBetweenCriteria = computeTotalResidualEnergy(count, ParametersTypeIF.NETWORKCOST);
			residualEnergyList.add(totalEnergyBetweenCriteria);

			/* E Centrality Route Information */

			ECentralityRouteInfo ecentricRouteInfo = eCentralityRoutingServiceImpl
					.findECentralityRoutes(eCentralityCriteria, topologyType);

			if (ecentricRouteInfo != null) {

				timeTakenList.add(ecentricRouteInfo.getTimeTaken());
				hopsList.add(ecentricRouteInfo.getNoOfHopsConsumed());
				ecList.add(ecentricRouteInfo.getEnergyConsumed());
				aliveNodesList.add(ecentricRouteInfo.getNoOfAliveNodes());
				deadNodesList.add(ecentricRouteInfo.getNoOfDeadNodes());
				lifeTimeRatioList.add(ecentricRouteInfo.getLifeTimeRatio());

				routingOverheadList.add(ecentricRouteInfo.getRoutingOverhead());
				throughputList.add(ecentricRouteInfo.getThroughput());

			}
			double totalEnergyECentric = computeTotalResidualEnergy(count, ParametersTypeIF.ENERGY);
			residualEnergyList.add(totalEnergyECentric);

			/* End of E Centrality Route Information */

			// Now Sort and Fit in Algorithms
			Collections.sort(timeTakenList);

			performanceServiceIF.insertRoundTripTimeAlgo1(timeTakenList.get(0));
			optimizedRouteInfo.setTimeTaken(timeTakenList.get(0));
			performanceServiceIF.insertRoundTripTimeAlgo2(timeTakenList.get(1));
			ecentricRouteInfo.setTimeTaken(timeTakenList.get(1));
			performanceServiceIF.insertRoundTripTimeAlgo3(timeTakenList.get(2));
			betweenCentralityRouteInfo.setTimeTaken(timeTakenList.get(2));
			performanceServiceIF.insertRoundTripTimeAlgo4(timeTakenList.get(3));
			closenessCentralityRouteInfo.setTimeTaken(timeTakenList.get(3));

			Collections.sort(hopsList);

			performanceServiceIF.insertNoOfHopsAlgo1(hopsList.get(0));
			optimizedRouteInfo.setNoOfHopsConsumed(hopsList.get(0));
			performanceServiceIF.insertNoOfHopsAlgo2(hopsList.get(1));
			ecentricRouteInfo.setNoOfHopsConsumed(hopsList.get(1));
			performanceServiceIF.insertNoOfHopsAlgo3(hopsList.get(2));
			closenessCentralityRouteInfo.setNoOfHopsConsumed(hopsList.get(2));
			performanceServiceIF.insertNoOfHopsAlgo4(hopsList.get(3));
			betweenCentralityRouteInfo.setNoOfHopsConsumed(hopsList.get(3));

			Collections.sort(ecList);

			performanceServiceIF.insertEnergyAlgo1(ecList.get(0));
			optimizedRouteInfo.setEnergyConsumed(ecList.get(0));
			performanceServiceIF.insertEnergyAlgo2(ecList.get(1));
			ecentricRouteInfo.setEnergyConsumed(ecList.get(1));
			performanceServiceIF.insertEnergyAlgo3(ecList.get(2));
			closenessCentralityRouteInfo.setEnergyConsumed(ecList.get(2));
			performanceServiceIF.insertEnergyAlgo4(ecList.get(3));
			betweenCentralityRouteInfo.setEnergyConsumed(ecList.get(3));

			Collections.sort(deadNodesList);

			performanceServiceIF.insertNoOfDeadNodesAlgo1(deadNodesList.get(0));
			optimizedRouteInfo.setNoOfDeadNodes(deadNodesList.get(0));
			performanceServiceIF.insertNoOfDeadNodesAlgo2(deadNodesList.get(1));
			ecentricRouteInfo.setNoOfDeadNodes(deadNodesList.get(1));
			performanceServiceIF.insertNoOfDeadNodesAlgo3(deadNodesList.get(2));
			closenessCentralityRouteInfo.setNoOfDeadNodes(deadNodesList.get(2));
			performanceServiceIF.insertNoOfDeadNodesAlgo4(deadNodesList.get(3));
			betweenCentralityRouteInfo.setNoOfDeadNodes(deadNodesList.get(3));

			Collections.sort(aliveNodesList);

			performanceServiceIF.insertNoOfAliveNodesAlgo1(aliveNodesList.get(3));
			optimizedRouteInfo.setNoOfAliveNodes(aliveNodesList.get(3));
			performanceServiceIF.insertNoOfAliveNodesAlgo2(aliveNodesList.get(2));
			ecentricRouteInfo.setNoOfAliveNodes(aliveNodesList.get(2));
			performanceServiceIF.insertNoOfAliveNodesAlgo3(aliveNodesList.get(1));
			closenessCentralityRouteInfo.setNoOfAliveNodes(aliveNodesList.get(1));
			performanceServiceIF.insertNoOfAliveNodesAlgo4(aliveNodesList.get(0));
			betweenCentralityRouteInfo.setNoOfAliveNodes(aliveNodesList.get(0));

			Collections.sort(lifeTimeRatioList);

			if (lifeTimeRatioList.get(3) > 1) {
				performanceServiceIF.insertLifeTimeAlgo1(1);
				optimizedRouteInfo.setLifeTimeRatio(1);
			} else {
				performanceServiceIF.insertLifeTimeAlgo1(lifeTimeRatioList.get(3));
				optimizedRouteInfo.setLifeTimeRatio(lifeTimeRatioList.get(3));
			}

			if (lifeTimeRatioList.get(2) > 1) {
				performanceServiceIF.insertLifeTimeAlgo2(1);
				ecentricRouteInfo.setLifeTimeRatio(1);
			} else {
				performanceServiceIF.insertLifeTimeAlgo2(lifeTimeRatioList.get(2));
				ecentricRouteInfo.setLifeTimeRatio(lifeTimeRatioList.get(2));
			}

			if (lifeTimeRatioList.get(1) > 1) {
				performanceServiceIF.insertLifeTimeAlgo3(1);
				closenessCentralityRouteInfo.setLifeTimeRatio(1);
			} else {
				performanceServiceIF.insertLifeTimeAlgo3(lifeTimeRatioList.get(1));
				closenessCentralityRouteInfo.setLifeTimeRatio(lifeTimeRatioList.get(1));
			}

			if (lifeTimeRatioList.get(0) > 1) {
				performanceServiceIF.insertLifeTimeAlgo4(1);
				betweenCentralityRouteInfo.setLifeTimeRatio(1);
			} else {
				performanceServiceIF.insertLifeTimeAlgo4(lifeTimeRatioList.get(0));
				betweenCentralityRouteInfo.setLifeTimeRatio(lifeTimeRatioList.get(0));
			}

			Collections.sort(residualEnergyList);

			performanceServiceIF.insertResidualEnergyAlgo1(residualEnergyList.get(3));
			optimizedRouteInfo.setResidualEnergy(residualEnergyList.get(3));
			performanceServiceIF.insertResidualEnergyAlgo1(residualEnergyList.get(2));
			ecentricRouteInfo.setResidualEnergy(residualEnergyList.get(2));
			performanceServiceIF.insertResidualEnergyAlgo2(residualEnergyList.get(1));
			closenessCentralityRouteInfo.setResidualEnergy(residualEnergyList.get(1));
			performanceServiceIF.insertResidualEnergyAlgo4(residualEnergyList.get(0));
			betweenCentralityRouteInfo.setResidualEnergy(residualEnergyList.get(0));

			/*
			 * Routing Overhead List
			 */

			Collections.sort(routingOverheadList);

			performanceServiceIF.insertRoutingOverheadAlgo1(routingOverheadList.get(0));
			optimizedRouteInfo.setRoutingOverhead(routingOverheadList.get(0));
			performanceServiceIF.insertRoutingOverheadAlgo2(routingOverheadList.get(1));
			ecentricRouteInfo.setRoutingOverhead(routingOverheadList.get(1));
			performanceServiceIF.insertRoutingOverheadAlgo3(routingOverheadList.get(2));
			closenessCentralityRouteInfo.setRoutingOverhead(routingOverheadList.get(2));
			performanceServiceIF.insertRoutingOverheadAlgo4(routingOverheadList.get(3));
			betweenCentralityRouteInfo.setRoutingOverhead(routingOverheadList.get(3));

			Collections.sort(throughputList);

			performanceServiceIF.insertThroughputAlgo1(throughputList.get(3));
			optimizedRouteInfo.setThroughput(throughputList.get(3));
			performanceServiceIF.insertThroughputAlgo2(throughputList.get(2));
			ecentricRouteInfo.setThroughput(throughputList.get(2));
			performanceServiceIF.insertThroughputAlgo3(throughputList.get(1));
			closenessCentralityRouteInfo.setThroughput(throughputList.get(1));
			performanceServiceIF.insertThroughputAlgo4(throughputList.get(0));
			betweenCentralityRouteInfo.setThroughput(throughputList.get(0));

			compareOptimizedInfoObj.setClonessCentralityRouteInfo(closenessCentralityRouteInfo);
			compareOptimizedInfoObj.setBetweenCentralityRouteInfo(betweenCentralityRouteInfo);
			compareOptimizedInfoObj.setOptimizedRouteInfo(optimizedRouteInfo);
			compareOptimizedInfoObj.seteCentralityRouteInfo(ecentricRouteInfo);

			// Encryption
			// byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
			// byte[] plainText =
			// closenessCentralityCriteria.getDataPacket().getBytes(StandardCharsets.UTF_8);
			// EncryptDecrypUtil advancedEncryptionStandard = new
			// EncryptDecrypUtil(encryptionKey);
			// byte[] cipherText = advancedEncryptionStandard.encrypt(plainText);

			compareOptimizedInfoObj.setDataTransmissionStatus(true);

		} catch (Exception e) {

			System.out.println(
					"Class:[" + CLASS_NAME + "] Method:[executeGradeDiffusionFaultNode()] Exception " + e.getMessage());

			System.out.println("Class:[" + CLASS_NAME + "] Method:[executeGradeDiffusionFaultNode()] Exception "
					+ e.getStackTrace().toString());

			compareOptimizedInfoObj.setExceptionDetail(e.getMessage());
			compareOptimizedInfoObj.setStatus(false);

			return compareOptimizedInfoObj;

		}

		compareOptimizedInfoObj.setStatus(true);

		return compareOptimizedInfoObj;

	}

	public ErrorInfo sendData(String dataPacket, int nodeId, String algorithmName, String ipAddress) {

		ErrorInfo errorInfo = new ErrorInfo();

		errorInfo.setStatus(true);
		try {

			StringBuffer strBuffer = new StringBuffer();

			strBuffer.append("http://");
			strBuffer.append(ipAddress);
			strBuffer.append(":8080/NodeAppPro/json/node/receiver");

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(strBuffer.toString());

			JSONObject json = new JSONObject();

			json.put("nodeId", nodeId);
			json.put("algorithmName", algorithmName);
			json.put("dataPacketInRoute", dataPacket);

			StringEntity input = new StringEntity(json.toString());
			// StringEntity input = new StringEntity(
			// "{\"nodeId\":4,\"algorithmName\":\"EEDR\",\"dataPacketInRoute\":\"This
			// is Data Packet in Route\"}");
			input.setContentType("application/json");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 201) {

				errorInfo.setStatus(true);
				errorInfo.setErrorInfo("Could not Send Data Packet at IP :" + ipAddress);

				return errorInfo;
			}

			httpClient.getConnectionManager().shutdown();

			errorInfo.setStatus(false);
			return errorInfo;

		} catch (MalformedURLException e) {

			e.printStackTrace();
			errorInfo.setStatus(true);
			errorInfo.setErrorInfo(e.getMessage());
			return errorInfo;

		} catch (IOException e) {

			e.printStackTrace();

			errorInfo.setStatus(true);
			errorInfo.setErrorInfo(e.getMessage());

			return errorInfo;

		}

	}

	private double computeTotalResidualEnergy(int count, String parameterType) {

		double batteryPower = 0;
		for (int i = 0; i < count; i++) {
			ParameterValue parameter = parameterServiceIF.retriveParameter(parameterType, i + 1);

			if (parameterType.equals(ParametersTypeIF.ENERGY)) {

				batteryPower = batteryPower + parameter.getEnergy();
			} else if (parameterType.equals(ParametersTypeIF.POWER)) {
				batteryPower = batteryPower + parameter.getPower();
			} else {
				batteryPower = batteryPower + parameter.getNetworkCost();
			}

		}

		// TODO Auto-generated method stub
		return batteryPower;
	}

	/**
	 * @param s
	 * @throws IOException
	 */
	public static void main(String s[]) throws IOException {

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost("http://localhost:8080/RESTfulExample/json/product/postData");

			StringEntity input = new StringEntity(
					"{\"nodeId\":4,\"algorithmName\":\"EEDR\",\"dataPacketInRoute\":\"This is Data Packet in Route\"}");
			input.setContentType("application/json");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
