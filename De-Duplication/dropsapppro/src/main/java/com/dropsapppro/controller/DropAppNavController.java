package com.dropsapppro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dropsapppro.response.AJAXResponseLogin;
import com.model.messages.Messages;

@Controller
public class DropAppNavController {

	@RequestMapping("/")
	public String homePage(Model model) {
		return "welcome";
	}

	@RequestMapping("/navAllFiles")
	public String navAllFiles(Model model) {
		return "viewallfiles";
	}

	@RequestMapping("/navAllEncFiles")
	public String navAllEncFiles(Model model) {
		return "viewallencfiles";
	}

	@RequestMapping("/navViewCustomerFiles")
	public String navViewCustomerFiles(Model model) {
		return "viewcustomerfiles";
	}

	@RequestMapping("/navAllSecurityGraphMemory")
	public String navAllSecurityGraphMemory(Model model) {
		return "viewallsecuritymemgraph";
	}

	@RequestMapping("/navAllSecurityGraphBytes")
	public String navAllSecurityGraphBytes(Model model) {
		return "viewallsecuritybytesgraph";
	}

	@RequestMapping("/navAllSecurityGraphTime")
	public String navAllSecurityGraphTime(Model model) {
		return "viewallsecuritygraph";
	}

	@RequestMapping("/navAllRouteHistory")
	public String navAllRouteHistory(Model model) {
		return "viewallroutehistory";
	}

	@RequestMapping("/navAllSecurityCompare")
	public String navAllSecurityCompare(Model model) {
		return "viewallsecuritycompare";
	}

	@RequestMapping("/navCustRouteHistory")
	public String navCustRouteHistory(Model model) {
		return "viewcustroutehistory";
	}

	@RequestMapping("/adminPage")
	public String adminPage(Model model) {
		return "admin";
	}

	@RequestMapping("/navAllFileChunks")
	public String navAllFileChunks(Model model) {
		return "viewallfilechunks";
	}

	@RequestMapping("/navAllFileReplicas")
	public String navAllFileReplicas(Model model) {
		return "viewallfilereplicas";
	}

	@RequestMapping("/navViewCustomerFileReplica")
	public String navViewCustomerFileReplica(Model model) {
		return "viewcustomerfilereplica";
	}

	@RequestMapping("/navViewCustomerFileChunks")
	public String navViewCustomerFileChunks(Model model) {
		return "viewcustomerfilechunks";
	}

	@RequestMapping("/navRouting")
	public String navRouting(Model model) {
		return "dropsinput";
	}

	@RequestMapping("/viewUsersPage")
	public String navUsersPage(Model model) {
		return "viewusers";
	}

	@RequestMapping("/viewSecurityLevelsNav")
	public String navSecurityCompare(Model model) {
		return "viewsecuritylevels";
	}

	@RequestMapping("/viewTimeLevelsNav")
	public String navTimeCompare(Model model) {
		return "viewtimelevels";
	}

	@RequestMapping("/viewcomputation")
	public String viewcomputation(Model model) {
		return "viewcomputation";
	}

	@RequestMapping("/navPrescriptionEncAll3level")
	public String navAdminPresc3LevelPage(Model model) {
		return "viewadmin3levelprescriptionall";
	}

	@RequestMapping("/navMedicalEncAll3level")
	public String navAdminMedicalEncAll3level(Model model) {
		return "viewadmin3levelmedicalall";
	}

	@RequestMapping("/navInsuranceEncAll3level")
	public String navAdminInsurancec3LevelPage(Model model) {
		return "viewadmin3levelinsuranceall";
	}

	@RequestMapping("/navPrescriptionEncAllOnelevel")
	public String navAdminPrescOneLevelPage(Model model) {
		return "viewadminonelevelprescriptionall";
	}

	@RequestMapping("/navMedicalEncAllOnelevel")
	public String navAdminMedicalOneLevelPage(Model model) {
		return "viewadminonelevelmedicalall";
	}

	@RequestMapping("/navInsuranceEncAllOnelevel")
	public String navAdminInsuranceOneLevelPage(Model model) {
		return "viewadminonelevelinsuranceall";
	}

	@RequestMapping("/viewInsuranceNavInsurancePage")
	public String viewApprovedInsuranceDetails(Model model) {
		return "viewapprovedinsurancedetails";
	}

	@RequestMapping("/navViewRequests")
	public String navViewInsuranceRequests(Model model) {
		return "viewinsurancerequestsforuser";
	}

	@RequestMapping("/navViewInsuranceStatusRequests")
	public String navViewInsuranceStatusRequests(Model model) {
		return "viewinsurancerequestsstatusforuser";
	}

	@RequestMapping("/navViewRequestStatusForMedical")
	public String navViewMedicalStatusRequests(Model model) {
		return "viewmedicalrequestsstatusforuser";
	}

	@RequestMapping("/navViewRequestStatusForPrescription")
	public String navViewPrescriptionStatusRequests(Model model) {
		return "viewprescriptionrequestsstatusforuser";
	}

	@RequestMapping("/navViewMedicalRequests")
	public String navViewMedicalRequests(Model model) {
		return "viewmedicalrequestsforuser";
	}

	@RequestMapping("/navViewPrescriptionRequests")
	public String navViewPrescriptionRequests(Model model) {
		return "viewprescriptionrequestsforuser";
	}

	@RequestMapping("/loginUser")
	public String loginUser(Model model) {
		model.addAttribute(Messages.Keys.OBJ, new AJAXResponseLogin());
		return "login";
	}

	@RequestMapping("/registerCustomerPage")
	public String registerCustomer(Model model) {
		model.addAttribute(Messages.Keys.OBJ, new AJAXResponseLogin());
		return "registeruser";
	}

	// This is the Navigation of Customer Information

	@RequestMapping("/customerNavHomePage")
	public String viewcustomer(Model model) {
		return "customer";
	}

	@RequestMapping("/settingsNav")
	public String settingsNav(Model model) {
		return "settings";
	}

	@RequestMapping("/cleanUpNav")
	public String cleanUpNav(Model model) {
		return "cleanupdata";
	}

	@RequestMapping("/edfTopologyNav")
	public String edfTopologyNav(Model model) {
		return "edftopology";
	}

	@RequestMapping("/viewTopologyEdfNav")
	public String ViewEdfTopologyNav(Model model) {
		return "viewedftopology";
	}

	@RequestMapping("/navViewroutingtablepage")
	public String navViewroutingtablepage(Model model) {
		return "viewroutingtable";
	}

	@RequestMapping("/navViewpowertablepage")
	public String navViewpowertablepage(Model model) {
		return "viewpowertable";
	}

	@RequestMapping("/navClosenessCentralityEnergy")
	public String navClosenessCentralityEnergy(Model model) {
		return "viewclosenesscentralityenergy";
	}

	@RequestMapping("/navViewenergytablesbetweencentrality")
	public String navViewenergytablesbetweencentrality(Model model) {
		return "viewbetweencentralitytable";
	}

	@RequestMapping("/navViewenergytablesEcentrality")
	public String navViewenergytablesEcentrality(Model model) {
		return "viewecentricenergytable";
	}

	@RequestMapping("/navViewenergytablepage")
	public String navViewenergytablepage(Model model) {
		return "viewenergytableoptimized";
	}

	/* Performance Compare Tables */

	@RequestMapping("/navTimeTablePage")
	public String navTimeTablePage(Model model) {
		return "viewtimetableperformance";
	}

	@RequestMapping("/navHopTablePage")
	public String navHopTablePage(Model model) {
		return "viewhoptableperformance";
	}

	@RequestMapping("/navEnergyTablePage")
	public String navEnergyTablePage(Model model) {
		return "viewenergytableperformance";
	}

	@RequestMapping("/navAliveTablePage")
	public String navAliveTablePage(Model model) {
		return "viewalivetableperformance";
	}

	@RequestMapping("/navDeadTablePage")
	public String navDeadTablePage(Model model) {
		return "viewdeadtableperformance";
	}

	@RequestMapping("/navLifetimeTablePage")
	public String navLifetimeTablePage(Model model) {
		return "viewlifetimetableperformance";
	}

	@RequestMapping("/navRETablePage")
	public String navRETablePage(Model model) {
		return "viewretableperformance";
	}

	@RequestMapping("/navROTablePage")
	public String navROTablePage(Model model) {
		return "viewrotableperformance";
	}

	@RequestMapping("/navThroughputTablePage")
	public String navThroughputTablePage(Model model) {
		return "viewthroughputtableperformance";
	}

	/* Performance Compare Graphs */

	@RequestMapping("/navTimeTableGPage")
	public String navTimeTableGPage(Model model) {
		return "viewtimegraphperformance";
	}

	@RequestMapping("/navHopTableGPage")
	public String navHopTableGPage(Model model) {
		return "viewhopgraphperformance";
	}

	@RequestMapping("/navEnergyTableGPage")
	public String navEnergyTableGPage(Model model) {
		return "viewenergygraphperformance";
	}

	@RequestMapping("/navAliveTableGPage")
	public String navAliveTableGPage(Model model) {
		return "viewalivegraphperformance";
	}

	@RequestMapping("/navDeadTableGPage")
	public String navDeadTableGPage(Model model) {
		return "viewdeadgraphperformance";
	}

	@RequestMapping("/navLifetimeTableGPage")
	public String navLifetimeTableGPage(Model model) {
		return "viewlifetimegraphperformance";
	}

	@RequestMapping("/navRETableGPage")
	public String navRETableGPage(Model model) {
		return "viewregraphperformance";
	}

	@RequestMapping("/navROTableGPage")
	public String navROTableGPage(Model model) {
		return "viewrographperformance";
	}

	@RequestMapping("/navThroughputTableGPage")
	public String navThroughputTableGPage(Model model) {
		return "viewthroughputgraphperformance";
	}

	@RequestMapping("/navAllSecurityInfoTable")
	public String navAllSecurityInfoTable(Model model) {
		return "viewsecuritytableinfo";
	}

	@RequestMapping("/navAllSecurityInfo")
	public String navAllSecurityInfo(Model model) {
		return "viewsecuritygraphinfo";
	}

	@RequestMapping("/navAllDownloadTable")
	public String navAllDownloadTable(Model model) {
		return "downloadcomparetable";
	}

	@RequestMapping("/navAllDownloadGraph")
	public String navAllDownloadGraph(Model model) {
		return "downloadcomparegraph";
	}
}
