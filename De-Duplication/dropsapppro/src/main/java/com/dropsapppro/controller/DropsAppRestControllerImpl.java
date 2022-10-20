package com.dropsapppro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.constants.EEDRServerMessages;
import com.controller.inter.RoutingControllerIF;
import com.dropsapppro.uiobjects.PaginationConfigVO;
import com.framework.constants.DropsAppConstants;
import com.model.AJAXResponse;
import com.model.Buffer;
import com.model.CompareEnergy;
import com.model.CompareHops;
import com.model.CompareLifeTimeRatio;
import com.model.CompareNoOfAliveNodes;
import com.model.CompareNoOfDeadNodes;
import com.model.ComparePower;
import com.model.CompareResidualEnergy;
import com.model.CompareRoutingOverhead;
import com.model.CompareThroughput;
import com.model.CompareTime;
import com.model.IPAdressVO;
import com.model.IPAdressVOFrontEnd;
import com.model.Message;
import com.model.NetworkCost;
import com.model.NodeId;
import com.model.NodeIdObj;
import com.model.FaultNodeTopologyModel;
import com.model.FaultNodeTopologyView;
import com.model.Power;
import com.model.StatusInfo;
import com.model.TypeObj;
import com.model.messages.Messages;
import com.model.EEDRModel;
import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.NormalRoutingTable;
import com.routingtopology.value.PerformanceAliveNodes;
import com.routingtopology.value.PerformanceDeadNodes;
import com.routingtopology.value.PerformanceEnergy;
import com.routingtopology.value.PerformanceHops;
import com.routingtopology.value.PerformancePower;
import com.routingtopology.value.PerformanceTimeTaken;
import com.routingtopology.value.TopologyCriteriaValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@RestController
@PropertySource("classpath:custom.properties")
public class DropsAppRestControllerImpl extends BaseController implements RoutingControllerIF {

	@Autowired
	private Environment environment;

	@RequestMapping(value = "/viewroutingtable.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse ViewRoutingTable(HttpServletRequest request, Integer nodeId) {
		AJAXResponse ajax = new AJAXResponse();
		List<NormalRoutingTable> normalRoutingTableList = null;

		try {

			normalRoutingTableList = routingDelegate.retriveNormalRoutingTables(nodeId, getTopologyType());

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(normalRoutingTableList);
		ajax.setTotalSize(normalRoutingTableList.size());
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/viewIPAddressList.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse viewIPAddressList(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<IPAdressVO> ipAddressVOList = null;

		try {

			ipAddressVOList = routingDelegate.retriveIPAddressList();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(ipAddressVOList);
		ajax.setTotalSize(ipAddressVOList.size());
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/viewNodeIds.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveNodeIds(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();

		List<NodeId> nodeIdList = null;

		try {
			nodeIdList = new ArrayList<NodeId>();
			nodeIdList = routingDelegate.retriveNodeIds(getTopologyType());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(nodeIdList);
		ajax.setTotalSize(nodeIdList.size());
		ajax.setStatus(Boolean.TRUE);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/insertroutingtables.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody ModelAndView insertRoutingTables(HttpServletRequest request) {

		boolean createRoutingTable = false;
		try {
			createRoutingTable = routingDelegate.insertRoutingTables(getTopologyType());

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView(EEDRServerMessages.FAILURE, EEDRServerMessages.MESSAGE, e.getMessage());
		}
		if (createRoutingTable) {
			return new ModelAndView(EEDRServerMessages.FAILURE, EEDRServerMessages.MESSAGE,
					EEDRServerMessages.ROUTINGTABLE_INSERT_SUCESS);
		}
		if (!createRoutingTable) {
			return new ModelAndView(EEDRServerMessages.FAILURE, EEDRServerMessages.MESSAGE,
					EEDRServerMessages.ROUTINGTABLE_INSERT_FAILURE);
		}
		return null;

	}

	@Override
	@RequestMapping(value = "/viewpowertable.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse viewPower(HttpServletRequest request, Integer nodeId) {
		AJAXResponse ajax = new AJAXResponse();
		Power power = null;

		try {
			if (nodeId > 0) {
				power = routingDelegate.retrivePowerTable(nodeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(power);
		ajax.setTotalSize(1);
		ajax.setStatus(true);
		return ajax;
	}

	@RequestMapping(value = "/viewbuffertable.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse viewbuffer(HttpServletRequest request, Integer nodeId) {
		AJAXResponse ajax = new AJAXResponse();
		Buffer power = null;

		try {
			if (nodeId > 0) {
				power = routingDelegate.retriveBufferTable(nodeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(power);
		ajax.setTotalSize(1);
		ajax.setStatus(true);
		return ajax;
	}

	@RequestMapping(value = "/viewnetworkcosttable.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse viewNetworkCost(HttpServletRequest request, Integer nodeId) {
		AJAXResponse ajax = new AJAXResponse();
		NetworkCost power = null;

		try {
			if (nodeId > 0) {
				power = routingDelegate.retriveNetworkCostTable(nodeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(power);
		ajax.setTotalSize(1);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/energyalgo1.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveEnergyAlgo1(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceEnergy> compareTrust = null;
		try {
			compareTrust = routingDelegate.retriveEnergyAlgo1();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(compareTrust);
		ajax.setTotalSize(compareTrust.size());
		ajax.setMessage("Energy Levels Obtained Algorithm1");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/energyalgo2.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveEnergyAlgo2(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceEnergy> compareTrust = null;
		try {
			compareTrust = routingDelegate.retriveEnergyAlgo2();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(compareTrust);
		ajax.setTotalSize(compareTrust.size());
		ajax.setMessage("Energy Levels Obtained Algorithm2");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/poweralgo1.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retrivePowerAlgo1(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformancePower> compareTrust = null;
		try {
			compareTrust = routingDelegate.retrivePowerAlgo1();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(compareTrust);
		ajax.setTotalSize(compareTrust.size());
		ajax.setMessage("Power Levels Obtained Algorithm1");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/poweralgo2.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retrivePowerAlgo2(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformancePower> compareTrust = null;
		try {
			compareTrust = routingDelegate.retrivePowerAlgo2();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(compareTrust);
		ajax.setTotalSize(compareTrust.size());
		ajax.setMessage("Power Levels Obtained Algorithm1");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/timealgo1.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveTimeAlgo1(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceTimeTaken> compareTrust = null;
		try {
			compareTrust = routingDelegate.retriveTimeAlgo1();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(compareTrust);
		ajax.setTotalSize(compareTrust.size());
		ajax.setMessage("Power Levels Obtained Algorithm1");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/timealgo2.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveTimeAlgo2(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceTimeTaken> compareTrust = null;
		try {
			compareTrust = routingDelegate.retriveTimeAlgo2();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(compareTrust);
		ajax.setTotalSize(compareTrust.size());
		ajax.setMessage("Power Levels Obtained Algorithm1");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/comparepower.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveComparisonPowerValues(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<ComparePower> comparePower = null;
		try {
			comparePower = routingDelegate.retrivePowerComparison();
			ajax.setTotalSize(comparePower.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(comparePower);
		ajax.setMessage("Power Levels Obtained Algorithm1");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/compareenergy.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveComparisonEnergyValues(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareEnergy> compareEnergy = null;
		try {
			compareEnergy = routingDelegate.retriveEnergyComparison();
			ajax.setTotalSize(compareEnergy.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareEnergy);
		ajax.setMessage("Energy Levels Obtained");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/comparetime.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveComparisonTimeValues(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareTime> compareRDT = null;
		try {
			compareRDT = routingDelegate.retriveTimeComparison();
			ajax.setTotalSize(compareRDT.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareRDT);
		ajax.setMessage("Time Levels Obtained ");
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/viewenergytableoptimized.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse viewEnergyTablesForEEDR(HttpServletRequest request, Integer nodeId) {
		AJAXResponse ajax = new AJAXResponse();
		Power power = null;

		try {
			if (nodeId > 0) {
				power = routingDelegate.retriveEnergyTableForEEDR(nodeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(power);
		ajax.setTotalSize(1);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/compareNoOfHops.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveComparisonNoOfHopsValues(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareHops> compareHops = null;
		try {
			compareHops = routingDelegate.retriveHopsComparison();
			ajax.setTotalSize(compareHops.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareHops);
		ajax.setMessage(EEDRServerMessages.COMPARE_NOOFHOPS);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/retriveNoOfHopsForRandom.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveNoOfHopsAlgo1(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceHops> noOfHopsListForGradeDiffusionAlgo = null;
		try {
			noOfHopsListForGradeDiffusionAlgo = routingDelegate.retriveNoOfHopsAlgo1();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(noOfHopsListForGradeDiffusionAlgo);
		ajax.setTotalSize(noOfHopsListForGradeDiffusionAlgo.size());
		ajax.setMessage(EEDRServerMessages.NOOFHOPS_ALGO1);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/retriveNoOfHopsForEDF.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveNoOfHopsAlgo2(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceHops> noOfHopsListForFaultNodeAlgo = null;
		try {
			noOfHopsListForFaultNodeAlgo = routingDelegate.retriveNoOfHopsAlgo2();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(noOfHopsListForFaultNodeAlgo);
		ajax.setTotalSize(noOfHopsListForFaultNodeAlgo.size());
		ajax.setMessage(EEDRServerMessages.NOOFHOPS_ALGO2);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/retriveDeadNodesGradeDiffusion.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveNoOfDeadNodesAlgo1(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceDeadNodes> noOfDeadNodesForGradeAlgoList = null;
		try {
			noOfDeadNodesForGradeAlgoList = routingDelegate.retriveDeadNodesAlgo1();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(noOfDeadNodesForGradeAlgoList);
		ajax.setTotalSize(noOfDeadNodesForGradeAlgoList.size());
		ajax.setMessage(EEDRServerMessages.DEADNODES_ALGO1);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/retriveDeadNodesFaultNode.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveNoOfDeadNodesAlgo2(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceDeadNodes> noOfDeadNodesForFaultNodeAlgoList = null;
		try {
			noOfDeadNodesForFaultNodeAlgoList = routingDelegate.retriveDeadNodesAlgo2();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(noOfDeadNodesForFaultNodeAlgoList);
		ajax.setTotalSize(noOfDeadNodesForFaultNodeAlgoList.size());
		ajax.setMessage(EEDRServerMessages.DEADNODES_ALGO2);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/retriveAliveNodesForGradeDiffusion.do", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveNoOfAliveNodesAlgo1(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceAliveNodes> noOfAliveNodesListForGradeDiffusion = null;
		try {
			noOfAliveNodesListForGradeDiffusion = routingDelegate.retriveAliveNodesAlgo1();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(noOfAliveNodesListForGradeDiffusion);
		ajax.setTotalSize(noOfAliveNodesListForGradeDiffusion.size());
		ajax.setMessage(EEDRServerMessages.ALIVENODES_ALGO1);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/retriveAliveNodesForFaultNode.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveNoOfAliveNodesAlgo2(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<PerformanceAliveNodes> noOfAliveNodesListForFaultNodeAlgo = null;
		try {
			noOfAliveNodesListForFaultNodeAlgo = routingDelegate.retriveAliveNodesAlgo2();

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(noOfAliveNodesListForFaultNodeAlgo);
		ajax.setTotalSize(noOfAliveNodesListForFaultNodeAlgo.size());
		ajax.setMessage(EEDRServerMessages.ALIVENODES_ALGO2);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/compareNoOfDeadNodes.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveComparisonNoOfDeadNodes(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareNoOfDeadNodes> compareDeadNodes = null;
		try {
			compareDeadNodes = routingDelegate.retriveDeadNodesComparison();
			ajax.setTotalSize(compareDeadNodes.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareDeadNodes);
		ajax.setMessage(EEDRServerMessages.COMPARE_DEADNODES);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/compareNoOfAliveNodes.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveComparisonNoOfAliveNodes(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareNoOfAliveNodes> compareAliveNodes = null;
		try {
			compareAliveNodes = routingDelegate.retriveAliveNodesComparison();
			ajax.setTotalSize(compareAliveNodes.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareAliveNodes);
		ajax.setMessage(EEDRServerMessages.COMPARE_ALIVENODES);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/viewEnergyTableForDSDV.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse viewEnergyTablesForDSDV(HttpServletRequest request, Integer nodeId) {
		AJAXResponse ajax = new AJAXResponse();
		Power power = null;

		try {
			if (nodeId > 0) {
				power = routingDelegate.viewEnergyTableForDSDV(nodeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(power);
		ajax.setTotalSize(1);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/viewEnergyTableForEcentric.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse viewEnergyTablesForECentric(HttpServletRequest request, Integer nodeId) {
		AJAXResponse ajax = new AJAXResponse();
		Power power = null;

		try {
			if (nodeId > 0) {
				power = routingDelegate.viewEnergyTablesForECentric(nodeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(power);
		ajax.setTotalSize(1);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/compareResidualEnergy.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveComparisonResidualEnergy(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareResidualEnergy> compareResidualEnergyList = null;
		try {
			compareResidualEnergyList = routingDelegate.retriveResidualEnergyComparison();
			ajax.setTotalSize(compareResidualEnergyList.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareResidualEnergyList);
		ajax.setMessage(EEDRServerMessages.COMPARE_RESIDUALENERGY);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/compareLifeTimeRatio.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveComparisonLifeTimeRatio(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareLifeTimeRatio> compareLifeTimeRatioList = null;
		try {
			compareLifeTimeRatioList = routingDelegate.retriveComparisonLifeTimeRatio();
			ajax.setTotalSize(compareLifeTimeRatioList.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareLifeTimeRatioList);
		ajax.setMessage(EEDRServerMessages.COMPARE_LIFETIMERATIO);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/compareRoutingOverhead.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveCompareRoutingOverhead(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareRoutingOverhead> compareRoutingOverheadList = null;
		try {
			compareRoutingOverheadList = routingDelegate.retriveCompareRoutingOverhead();
			ajax.setTotalSize(compareRoutingOverheadList.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareRoutingOverheadList);
		ajax.setMessage(EEDRServerMessages.COMPARE_ROUTINGOVERHEAD);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/compareThroughput.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveCompareThroughput(HttpServletRequest request) {
		AJAXResponse ajax = new AJAXResponse();
		List<CompareThroughput> compareThroughputList = null;
		try {
			compareThroughputList = routingDelegate.retriveCompareThroughput();
			ajax.setTotalSize(compareThroughputList.size());
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setModel(compareThroughputList);
		ajax.setMessage(EEDRServerMessages.COMPARE_ROUTINGOVERHEAD);
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	@RequestMapping(value = "/storeIPAddress.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse storeIpAddress(HttpServletRequest request,
			@RequestBody IPAdressVOFrontEnd ipAdressVO) {
		AJAXResponse ajax = new AJAXResponse();
		boolean storeIPAddressFlag = false;
		try {

			String nodeId = ipAdressVO.getNodeId();

			if (null == nodeId || (nodeId != null && nodeId.isEmpty())) {

				List<Message> ebErrors = new ArrayList<Message>();
				Message msg = new Message(EEDRServerMessages.NODEID_EMPTY);
				msg.setErrMessage(EEDRServerMessages.NODEID_EMPTY);
				ebErrors.add(msg);
				ajax.setEbErrors(ebErrors);
				ajax.setStatus(Boolean.FALSE);
				return ajax;

			}

			String ipAddress = ipAdressVO.getIpAddress();

			if (null == ipAddress || (ipAddress != null && ipAddress.isEmpty())) {

				List<Message> ebErrors = new ArrayList<Message>();
				Message msg = new Message(EEDRServerMessages.IPADRESS_EMPTY);
				msg.setErrMessage(EEDRServerMessages.IPADRESS_EMPTY);
				ebErrors.add(msg);
				ajax.setEbErrors(ebErrors);
				ajax.setStatus(Boolean.FALSE);
				return ajax;

			}

			IPAdressVO ipAdressVONew = new IPAdressVO();

			ipAdressVONew.setNodeId(Integer.parseInt(nodeId));
			ipAdressVONew.setIpAddress(ipAddress);

			storeIPAddressFlag = routingDelegate.storeIpAddress(ipAdressVONew);

		} catch (Exception e) {
			e.printStackTrace();
			List<Message> ebErrors = new ArrayList<Message>();
			Message msg = new Message(e.getMessage());
			msg.setErrMessage(e.getMessage());
			ebErrors.add(msg);
			ajax.setEbErrors(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		if (storeIPAddressFlag) {
			ajax.setMessage(EEDRServerMessages.IPADRESS_TABLECREATION_SUCESS);
			ajax.setStatus(true);
		}
		if (!storeIPAddressFlag) {
			List<Message> ebErrors = new ArrayList<Message>();
			Message msg = new Message(EEDRServerMessages.IPADRESS_TABLECREATION_FAILURE);
			msg.setErrMessage(EEDRServerMessages.IPADRESS_TABLECREATION_FAILURE);
			ebErrors.add(msg);
			ajax.setEbErrors(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			return ajax;

		}
		return ajax;
	}

	@Override
	@RequestMapping(value = "/removeIPAddress.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse removeIpAddress(HttpServletRequest request, @RequestBody NodeIdObj ipAdressVO) {
		AJAXResponse ajax = new AJAXResponse();
		boolean storeIPAddressFlag = false;
		try {

			String nodeId = ipAdressVO.getNodeId();

			if (null == nodeId || (nodeId != null && nodeId.isEmpty())) {

				List<Message> ebErrors = new ArrayList<Message>();
				Message msg = new Message(EEDRServerMessages.NODEID_EMPTY);
				msg.setErrMessage(EEDRServerMessages.NODEID_EMPTY);
				ebErrors.add(msg);
				ajax.setEbErrors(ebErrors);
				ajax.setStatus(Boolean.FALSE);
				return ajax;

			}

			IPAdressVO ipAdressVONew = new IPAdressVO();

			ipAdressVONew.setNodeId(Integer.parseInt(nodeId));

			StatusInfo statusInfo = routingDelegate.removeIpAddress(ipAdressVONew);

			if (!statusInfo.isStatus()) {

				List<Message> ebErrors = new ArrayList<Message>();
				Message msg = new Message(statusInfo.getErrMsg());
				msg.setErrMessage(statusInfo.getErrMsg());
				ebErrors.add(msg);
				ajax.setEbErrors(ebErrors);
				ajax.setStatus(Boolean.FALSE);
				return ajax;

			}

		} catch (Exception e) {
			e.printStackTrace();
			List<Message> ebErrors = new ArrayList<Message>();
			Message msg = new Message(e.getMessage());
			msg.setErrMessage(e.getMessage());
			ebErrors.add(msg);
			ajax.setEbErrors(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setMessage(EEDRServerMessages.IPADRESS_TABLEREMOVE_SUCESS);
		ajax.setStatus(true);

		return ajax;
	}

	@Override
	@RequestMapping(value = "/removePerformanceData.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse removePerformance(HttpServletRequest request, TypeObj typeObj) {
		AJAXResponse ajax = new AJAXResponse();
		try {

			String type = typeObj.getType();

			if (null == type || (type != null && type.isEmpty())) {

				List<Message> ebErrors = new ArrayList<Message>();
				Message msg = new Message(EEDRServerMessages.TYPE_EMPTY);
				msg.setErrMessage(EEDRServerMessages.TYPE_EMPTY);
				ebErrors.add(msg);
				ajax.setEbErrors(ebErrors);
				ajax.setStatus(Boolean.FALSE);
				return ajax;

			}

			StatusInfo statusInfo = routingDelegate.removeAllAlgorithmsData(type);

			if (!statusInfo.isStatus()) {

				List<Message> ebErrors = new ArrayList<Message>();
				Message msg = new Message(statusInfo.getErrMsg());
				msg.setErrMessage(statusInfo.getErrMsg());
				ebErrors.add(msg);
				ajax.setEbErrors(ebErrors);
				ajax.setStatus(Boolean.FALSE);
				return ajax;

			}

		} catch (Exception e) {
			e.printStackTrace();
			List<Message> ebErrors = new ArrayList<Message>();
			Message msg = new Message(e.getMessage());
			msg.setErrMessage(e.getMessage());
			ebErrors.add(msg);
			ajax.setEbErrors(ebErrors);
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}
		ajax.setMessage(EEDRServerMessages.PERF_TABLEREMOVE_SUCESS);
		ajax.setStatus(true);

		return ajax;
	}

	@Override
	@RequestMapping(value = "/deleteData.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cleanUpData(HttpServletRequest request, @RequestParam String type) {

		try {

			boolean statusInfo = routingDelegate.deleteData(type);

			if (statusInfo) {

				AJAXResponse ajax = new AJAXResponse();
				ajax.setStatus(Boolean.TRUE);
				ajax.setMessage(EEDRServerMessages.DELETE_DATA_SUCESS);
				return new ModelAndView(EEDRServerMessages.SUCESS_PAGE, EEDRServerMessages.Keys.OBJ, ajax);

			} else {

				AJAXResponse ajax = new AJAXResponse();
				ajax.setStatus(Boolean.FALSE);
				List<Message> ebErrors = new ArrayList<Message>();
				Message msg = new Message(EEDRServerMessages.FAILED_TO_DELETE_DATA);
				msg.setErrMessage(EEDRServerMessages.FAILED_TO_DELETE_DATA);
				ebErrors.add(msg);
				ajax.setEbErrors(ebErrors);

				return new ModelAndView(EEDRServerMessages.FAILURE, EEDRServerMessages.Keys.OBJ, ajax);
			}

		} catch (Exception e) {
			AJAXResponse ajax = new AJAXResponse();
			ajax.setStatus(Boolean.FALSE);
			List<Message> ebErrors = new ArrayList<Message>();
			Message msg = new Message(EEDRServerMessages.FAILED_TO_DELETE_CRITICAL_DATA);
			msg.setErrMessage(EEDRServerMessages.FAILED_TO_DELETE_CRITICAL_DATA);
			ebErrors.add(msg);
			ajax.setEbErrors(ebErrors);

			return new ModelAndView(EEDRServerMessages.FAILURE, EEDRServerMessages.Keys.OBJ, ajax);

		}

	}

	@PostMapping("/edftopologygen.do")
	public AJAXResponse generateTopology(HttpServletRequest request,
			@RequestBody FaultNodeTopologyModel eedrRoutingPro) {

		AJAXResponse ajaxResponse = new AJAXResponse();
		try {

			TopologyCriteriaValue value = mapToCriteriaValue(eedrRoutingPro);
			if (value != null) {
				ajaxResponse.setStatus(true);
				routingDelegate.createFaultNodeTopologyAndStore(value, getTopologyType());
				ajaxResponse.setMessage(EEDRServerMessages.TOPOLOGY_SUCESS);
			}

			System.out.println("Value=" + value);

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			List<Message> mesageList = new ArrayList<Message>();
			Message msg = new Message("Server Error");
			msg.setErrFieldName("serverError");
			msg.setErrMessage(e.getMessage());
			mesageList.add(msg);
			ajaxResponse.setEbErrors(mesageList);
			ajaxResponse.setStatus(false);

		}
		return ajaxResponse;

	}

	private TopologyCriteriaValue mapToCriteriaValue(FaultNodeTopologyModel topologyModel) {

		TopologyCriteriaValue topologyCriteriaValue = new TopologyCriteriaValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(topologyModel.getBuffer());
		nodeParameters.setAvailableBatteryPower(topologyModel.getPower());
		nodeParameters.setNetworkCost(topologyModel.getNetworkCost());
		nodeParameters.setEnergy(topologyModel.getEnergy());
		nodeParameters.setTrustLevel(topologyModel.getTrustLevel());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		topologyCriteriaValue.setMaxXCordinate(topologyModel.getMaxXCor());
		topologyCriteriaValue.setMinXCordinate(topologyModel.getMinXCor());
		topologyCriteriaValue.setMinYCordinate(topologyModel.getMinYCor());
		topologyCriteriaValue.setMaxYCordinate(topologyModel.getMaxYCor());
		topologyCriteriaValue.setNoOfNodes(topologyModel.getNoOfNodes());
		topologyCriteriaValue.setDistanceBetweenNodes(topologyModel.getDistanceBetweenNodes());
		return topologyCriteriaValue;
	}

	@PostMapping("/edftopologyview.do")
	public AJAXResponse viewTopology(HttpServletRequest request) {

		AJAXResponse ajax = new AJAXResponse();
		List<FaultNodeTopologyView> searchList = null;

		try {

			// searchList = getTopologyView();

			searchList = routingDelegate.retriveFaultNodeTopology(getTopologyType());

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setEbErrors(Collections.singletonList(new Message(e.getMessage())));
			ajax.setStatus(Boolean.FALSE);
			return ajax;
		}

		ajax.setModel(searchList);
		ajax.setTotalSize(searchList.size());
		ajax.setStatus(true);
		return ajax;
	}

	@Override
	public ModelAndView performSettings(HttpServletRequest request, String topologyType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/retriveChunksForCustomer", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveChunksForCustomer(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveChunksForCustomer(paginationConfigVO, userName);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveReplicaChunksForCustomer", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveReplicaChunksForCustomer(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveReplicaChunksForCustomer(paginationConfigVO, userName);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveAllReplicas", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveAllReplicas(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.REP_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.REP_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.REP_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.REP_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveAllReplicas(paginationConfigVO);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.REP_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.REP_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.REP_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveAllChunks", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveAllChunks(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveAllChunks(paginationConfigVO);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveRouteHistoryForCustomer", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveUserRouteForCustomer(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveUserBasedTColorSessionInformation(paginationConfigVO,
					userName);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveRouteHistoryForAll", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveRouteHistoryForAll(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveUserBasedTColorSessionInformation(paginationConfigVO);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveSecurityCompare", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveSecurityCompare(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveSecurityCompare(paginationConfigVO);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveSecurityCompareAll", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveSecurityCompareAll(HttpServletRequest request) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveSecurityCompare();
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotalSize(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveCustomerSpecificFiles", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveCustomerSpecificFiles(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.SESSION_EXPIRED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.SESSION_EXPIRED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.SESSION_EXPIRED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.SESSION_EXPIRED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveAllFilesByUserName(paginationConfigVO, userName);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(statusInfo.getErrMsg());
				msg.setErrMessage(statusInfo.getErrMsg());
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveAllSpecificFiles", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveAllSpecificFiles(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			StatusInfo statusInfo = routingCustomDelegate.retriveAllFiles(paginationConfigVO);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(statusInfo.getErrMsg());
				msg.setErrMessage(statusInfo.getErrMsg());
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/retriveAllSpecificEncFiles", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveEncAllFiles(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			StatusInfo statusInfo = routingCustomDelegate.retriveAllEncFiles(paginationConfigVO);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(statusInfo.getErrMsg());
				msg.setErrMessage(statusInfo.getErrMsg());
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotal(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.CHUNK_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/compareFileCompareData.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse compareFileCompareData(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.compareFileCompareData(paginationConfigVO);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotalSize(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/fileSizeDataGraph.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse fileSizeDataGraph(HttpServletRequest request) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.fileSizeDataGraph();
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotalSize(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/downloadTimeTable.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveDownloadComputation(HttpServletRequest request,
			@ModelAttribute PaginationConfigVO paginationConfigVO) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.downloadTimeData(paginationConfigVO);
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotalSize(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/downloadTimeForOptimized.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveDownloadComputationForOptimized(HttpServletRequest request) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.retriveDownloadComputationForOptimized();
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotalSize(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/downloadTimeForClosenessCentrality.do", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveDownloadComputationForClosenessCentrality(HttpServletRequest request) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.downloadTimeForClosenessCentrality();
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotalSize(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/downloadTimeForBetweenCentrality.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveDownloadComputationForBetweenCentrality(HttpServletRequest request) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.downloadTimeForBetweenCentrality();
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotalSize(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

	@Override
	@RequestMapping(value = "/downloadTimeForECentrality.do", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody AJAXResponse retriveDownloadComputationForECentrality(HttpServletRequest request) {
		AJAXResponse ajaxResponse = null;
		try {
			ajaxResponse = new AJAXResponse();

			HttpSession session = request.getSession(false);
			if (null == session.getAttribute(Messages.Keys.LOGINID_SESSION)) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			String userName = (String) session.getAttribute(Messages.Keys.LOGINID_SESSION);

			if (null == userName) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}

			StatusInfo statusInfo = routingCustomDelegate.downloadTimeForECentrality();
			if (!statusInfo.isStatus()) {
				ajaxResponse = new AJAXResponse();
				ajaxResponse.setStatus(false);
				Message msg = new Message(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				msg.setErrMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_FAILED));
				List<Message> ebErrors = new ArrayList<Message>();
				ebErrors.add(msg);
				ajaxResponse.setEbErrors(ebErrors);
				return ajaxResponse;
			}
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			ajaxResponse.setModel(statusInfo.getModel());
			ajaxResponse.setTotalSize(statusInfo.getTotal());
			ajaxResponse.setMessage(environment.getProperty(DropsAppConstants.HISTORY_RET_SUCESS));
			return ajaxResponse;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION" + e.getMessage());
			ajaxResponse = new AJAXResponse();
			ajaxResponse.setStatus(true);
			Message msg = new Message(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			msg.setErrMessage(environment.getProperty(DropsAppConstants.INTERNAL_ERROR));
			List<Message> ebErrors = new ArrayList<Message>();
			ebErrors.add(msg);
			ajaxResponse.setEbErrors(ebErrors);
			return ajaxResponse;
		}
	}

}
