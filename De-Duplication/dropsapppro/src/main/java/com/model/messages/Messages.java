package com.model.messages;

import java.net.URI;

import com.model.messages.Messages.Keys;

public interface Messages {

	String INVALID_USER_PASSWORD_MSG = "Invalid Username/Password";
	String NO_USER_FOUND = "No User has been Found";
	String OLD_PASSWORD_CANNOT_BE_EMPTY = "Old Password Cannot be Empty";
	String NEW_PASSWORD_CANNOT_BE_EMPTY = "New Password Cannot be Empty";
	String CONFIRM_NEW_PASSWORD_CANNOT_BE_EMPTY = "Conform New Password cannot be Same";
	String NEW_PASSWORD_CONFIRM_PASSWORD_NOT_SAME = "New Password and Confirm Password cannot be Same";
	String OLD_PASSWORD_NOT_MATCHING_RECORDS = "Old Password does not match records";
	String SESSION_EXPIRED = "Session has Expired";
	String REGISTER_SUCESSFUL = "User has Registered Sucessfully";
	// String LOGIN_VALIDATE_ENDPOINT =
	// "https://arcane-castle-84234.herokuapp.com/login";

	String LOGIN_VALIDATE_ENDPOINT = EndPoints.BASE_ENDPOINT + "login";

	String COULD_NOT_SAVE_ACCIDENT_DATASETS_BACKUP = "Could not save accident data sets back up";
	String PROCESSING_SUCESS = "Processing of Data Sets is Sucessfully";
	String COULD_NOT_SAVE_INFO = "Could not save information";
	String SAVE_INFORMATION_SUCESS = "Save of Information is Sucessful";
	String DUPLICATE_INSURANCE_NAME_EXISTS = "Duplicate Insurance Information exists";
	String GENERATE_DISTRIBUTION_CENTER_ERROR = "Key Could not be Retrived By Key Distribution Center";
	String KEY_DISTRIBUTION_CENTER_FAILED = "Distribution of Key generation has Failed";
	String COULD_NOT_RETRIVE_INFORMATION = "Could not Retrive Information from Key Distribution Center";
	String INSTANCE_GAMMA_WITH_AES = "AES/ECB/PKCS5PADDING";
	String ALGORITHM_COMPARE_SAVED_FAILED = "Comparison of Algorithm save has Failed";
	String SPHR_SUCESS = "SPHR Information retrival is Sucessful";
	String CRITICAL_ERROR_OCCURED = "Critical Error has Occured";
	String NO_USERS_HAVE_INSURANCE_INFO = "No Users have Insurance Information";
	String NOT_REMOVE_OLD_REQ = "Could not remove the Old Request";
	String COULD_NOT_REMOVE_PREVIOUS_INSURANCE_INFO = "Could not remove the Old Insurance Information";
	String COULD_NOT_SAVE_REQSUMMARY_INFO = "Could not Save the Request Information";
	String INSURANCE_INFORMATION_SAVED_SUCESS = "Insurance Information has been saved Sucessfully";
	String RET_VIEWINSURANCE_DETAILS_USER = "Retrival of Insurance Details is Fine";
	String NO_REQSUMMARY_FOUND = " No Request Summary Details have been Found";
	String COULD_NOT_REMOVE_OLD_INFORMATION_FOR_USER = "Could not Remove Old Information for User";
	String NO_INSURANCE_INFO_PROVIDED_BY_USER = "No Insurance Information provided by End User";
	String COULD_NOT_SAVE_APPROVE_LIST = "Could not save approved list";
	String UPDATE_STATUS_APPROVED_FAILED = "Update Status to Approved";
	String APPROVE_REQ_SUCESS = "Approval of Request is Sucessful";
	String INSURANCE_DETAILS_FETCH_SUCESSFUL = "Insurance Details Fetch is Sucessful";
	String SAVE_MEDICALINFORMATION_SUCESS = "Save of Medical Information is Sucessful";
	String DUPLICATE_MEDICALINFOID_EXISTS = "Duplicate Medical Information Id Exists";
	String SAVE_PRESCRIPTION_INFORMATION_SUCESS = "Save of Prescription Information is Sucessful";
	String DUPLICATE_PRES_INFOID_EXISTS = "Duplicate Prescription Information Id Exist";
	String SAVE_PRESCRIPTION_INFORMATION_FAILED = "Save of Prescription Information has Failed";
	String RET_VIEWPRESCRIPTION_DETAILS_USER = "Retrival of Prescription Details for User";
	String RET_VIEWMEDICAL_DETAILS_USER = "Retrival of Medical Details for User";
	String NO_USERS_HAVE_MEDICAL_INFO = "No Users have Medical Information";
	String MEDICAL_INFORMATION_SAVED_SUCESS = "Mediccal Information Saved Sucessfully";
	String COULD_NOT_REMOVE_PREVIOUS_MEDICAL_INFO = "Could not remove previous medical information";
	String NO_MEDICAL_INFO_PROVIDED_BY_USER = "No Medical Information Provided By User";
	String NO_PRES_INFO_PROVIDED_BY_USER = "No Prescription Information Provided By User";
	String NO_USERS_HAVE_PRESCRIPTION_INFO = "No Users have Prescription";
	String MEDICAL_DETAILS_FETCH_SUCESSFUL = "Medical Details fetching is Sucessful";
	String MEDICAL_INFORMATION_REQUEST_APPROVED_SUCESSFULLY = "Medical Information has been Approved Sucessfully";
	String MEDICAL_INFORMATION_REQUEST_CREATED_SUCESSFULLY = "Medical Information request has been created sucessfully";
	String PRESCRIPTION_INFORMATION_REQUEST_CREATED_SUCESSFULLY = "Prescription Information request has been created Sucessfully";
	String PRESCRIPTION_DETAILS_FETCH_SUCESSFUL = "Prescription Details Fetching Cannot be Done at this point of time";
	String RET_REQ_INSURANCE_STATUS = "Retrive of Request Insurance Status is Sucessful";
	String RET_REQ_MEDICAL_STATUS = "Retrive of Request Medical Satus is Sucessful";
	String RET_REQ_PRESCRIPTION_STATUS = "Retrive of Request for Prescription Status is Sucessful";
	String OPTIMIZED_ERROR = "Optimized Route Save Error has occured";
	String USER_INFO_SESSION_STORAGE_FAILED = "User Info Session Storage has Failed";
	String FILESTORAGE_HAS_FAILED = "Storage of File has Failed";
	String BEST_ROUTE_DETAILS_SAVE_FAILED = "Best Route saved has Failed";
	String FILEREPLICATION_HAS_FAILED = "File Replication of Nodes has Failed";
	String BEST_NODES_REPLICATION_HAS_FAILED = "Best Nodes Replication has Failed";
	String BEST_NODES_REPLICATION_NODES_FIND_HAS_FAILED = "Replicated Nodes could not be Found for Optimized Algorithm";
	String FILE_DATA_COULD_NOT_BE_FOUND = "File Data Could not be Found";
	String FILE_CHUNK_STORAGE_ERROR_KEY = "file_chunk_storage_error";
	String COULD_NOT_SAVE_COMPARE_RESULTS = "compare_results_save_failed";

	interface Keys {
		String OBJ = "OBJ";
		String LOGINID_SESSION = "LOGINID_SESSION";
		String LOGINTYPE_SESSION = "LOGINTYPE_SESSION";
		String APP_NAME = "APP+91-9880185386";
		int CUSTOMER_TYPE = 2;
		String FORMAT_DECIMAL = "##.##";
		int DOCTOR_TYPE = 3;
		int INSURANCE_TYPE = 4;
		String FORMAT_OF_DIGEST = "AES";
		String INSURANCE = "INSURANCE";
		String UNAPPROVED = "UNAPPROVED";
		int ADMIN_TYPE = 1;
		String PDF_EXTENSION = ".pdf";
		String FILE_PATH = "FILE_PATH";

	}

	interface Page {
		String REGISTER_PAGE = "registeruser";
		String LOGIN_PAGE = "login";
		String CLIENT_PAGE = "client";
		String ADMIN_PAGE = "admin";
		String WELCOME_PAGE = "welcome";
	}
	
	interface Algorithms{
		String OPTIMIZED="OPTIMIZED";
		String BETWEEN_CENTRALITY="BETWEENCENTRALITY";
		String CLOSENESS_CENTRALITY="CLOSENESSCENTRALITY";
		String ECENTRALITY="ECENTRALITY";
	}

	interface EndPoints {

		 String BASE_ENDPOINT = "http://localhost:8081/";

		//String BASE_ENDPOINT = "https://arcane-castle-84234.herokuapp.com/";
		// String
		// REGISTER_ENDPOINT="https://arcane-castle-84234.herokuapp.com/register";
		// String BASE_ENDPOINT = "https://arcane-castle-84234.herokuapp.com/";

		String REGISTER_ENDPOINT = BASE_ENDPOINT + "register";

		String USERS_FETCH_ENDPOINT_WITH_APPNAME = BASE_ENDPOINT + "register/" + Keys.APP_NAME;

		String GAMMA_ENCRYPTION_ENDPOINT = BASE_ENDPOINT + "gammaEncrypt";

		String GAMMA_DECRYPTION_ENDPOINT = BASE_ENDPOINT + "gammaDecrypt";

	}

	interface SQLS {

		String INSERT_KEY_DISTRIBUTION_SQL = "INSERT INTO KEYDISTRIBUTION(USERID,INFORMATIONMSGTOENCYPT,INFORMATIONTYPE,SECRETKEY,MESSAGEDIGEST,MESSAGEDIGESTBINARY) VALUES(:USERID,:INFORMATIONMSGTOENCYPT,:INFORMATIONTYPE,:SECRETKEY,:MESSAGEDIGEST,:MESSAGEDIGESTBINARY)";
		String DELETE_FROM_KEYDISTRIBUTIONREPO_WHERE_USERID_AND_INFORMATIONTYPE_INFORMATIONMSG = "DELETE FROM KEYDISTRIBUTION WHERE USERID=:USERID AND INFORMATIONTYPE=:INFORMATIONTYPE AND INFORMATIONMSGTOENCYPT=:INFORMATIONMSGTOENCYPT";
		String RETRIVE_DISTRIBUTION_FOR_USERID_AND_INFORMATIONTYPE_AND_INFORMATIONMSG_SQL = "SELECT USERID,INFORMATIONMSGTOENCYPT,INFORMATIONTYPE,SECRETKEY,MESSAGEDIGEST,MESSAGEDIGESTBINARY from KEYDISTRIBUTION WHERE USERID=:USERID AND INFORMATIONTYPE=:INFORMATIONTYPE AND INFORMATIONMSGTOENCYPT=:INFORMATIONMSGTOENCYPT";
		String RETRIVE_INSURANCEID_FOR_USERNAME_SQL = "SELECT DISTINCT insurance_id FROM insuranceinformation WHERE username=:username";
		String RETRIVE_INSURANCEIDALL_SQL = "SELECT DISTINCT insurance_id FROM insuranceinformation";
		String RETRIVE_USER_SPECIFIC_INSURANCE_INFORMATION_SQL = "SELECT id,app_name,company_details,company_name,employee_id,encrypt_company_details,encrypt_company_name,encrypt_employee_id,encrypt_end_date,encrypt_group_name,encrypt_insid,encrypt_insurance_id,encrypt_insured_amount,encrypt_insured_name,encrypt_start_date,end_date,group_name,insid,insurance_id,insured_amount,insured_name,start_date,th_level_encrypt_company_details,th_level_encrypt_company_name,th_level_encrypt_employee_id,th_level_encrypt_end_date,th_level_encrypt_group_name,th_level_encrypt_insid,th_level_encrypt_insurance_id,th_level_encrypt_insured_amount,th_level_encrypt_insured_name,th_level_encrypt_start_date,username from insuranceinformation WHERE username=:username limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_LOGINID_SQL = "SELECT COUNT(*) FROM insuranceinformation WHERE username=:username";
		String RETRIVE_DISTINCT_USERIDS_FROM_INSURANCE_DETAILS_SQL = "SELECT DISTINCT username FROM insuranceinformation";
		String DELETE_FROM_REQDETAILS_WHERE_USERID_AND_INFORMATIONTYPE_AND_USERIDDETAILS_REUESTED_SQL = "DELETE FROM REQUESTINFO WHERE USERIDMAKINGREQ=:USERIDMAKINGREQ AND INFORMATIONTYPE=:INFORMATIONTYPE AND USERID=:USERID";
		String DELETE_FROM_APPROVEINSURANCEINFO_WHERE_USERID_AND_USERIDAPPROVE_SQL = "DELETE FROM INSURANCEINFORMATIONAPPROVE WHERE username=:username AND usernameapproved=:usernameapproved";
		String INSERT_REQDETAILS_SUMMARY_SQL = "INSERT INTO REQUESTINFO(USERIDMAKINGREQ,INFORMATIONTYPE,STATUS,USERID,USERTYPE,REQDETAILS,DATEREQ)VALUES(:USERIDMAKINGREQ,:INFORMATIONTYPE,:STATUS,:USERID,:USERTYPE,:REQDETAILS,:DATEREQ)";
		String RETRIVE_USER_SPECIFIC_INS_REQ_INFORMATION_SQL = "SELECT REQID,USERIDMAKINGREQ,INFORMATIONTYPE,STATUS,USERID,USERTYPE,REQDETAILS,DATEREQ FROM REQUESTINFO WHERE USERID=:USERID AND INFORMATIONTYPE=:INFORMATIONTYPE limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_INSREQDETIALS_FOR_LOGINID_AND_INFORMATIONTYPE_SQL = "SELECT COUNT(*) FROM REQUESTINFO WHERE USERID=:USERID AND INFORMATIONTYPE=:INFORMATIONTYPE";
		String RETRIVE_USERDETAILS_FOR_REQID_SQL = "SELECT REQID,USERIDMAKINGREQ,INFORMATIONTYPE,STATUS,USERID,USERTYPE,REQDETAILS,DATEREQ FROM REQUESTINFO WHERE REQID=:REQID";
		String RETRIVE_INSURANCEINFORMATION_FOR_USERID_SQL = "SELECT id,app_name,company_details,company_name,employee_id,encrypt_company_details,encrypt_company_name,encrypt_employee_id,encrypt_end_date,encrypt_group_name,encrypt_insid,encrypt_insurance_id,encrypt_insured_amount,encrypt_insured_name,encrypt_start_date,end_date,group_name,insid,insurance_id,insured_amount,insured_name,start_date,th_level_encrypt_company_details,th_level_encrypt_company_name,th_level_encrypt_employee_id,th_level_encrypt_end_date,th_level_encrypt_group_name,th_level_encrypt_insid,th_level_encrypt_insurance_id,th_level_encrypt_insured_amount,th_level_encrypt_insured_name,th_level_encrypt_start_date,username from insuranceinformation WHERE username=:username";
		String UPDATE_STATUS_APPROVED_FOR_USERIDMAKINGREQ_INFORMATIONTYPE_AND_USERID_AND_REQID_SQL = "UPDATE REQUESTINFO SET STATUS=:STATUS WHERE USERID=:USERID AND USERIDMAKINGREQ=:USERIDMAKINGREQ AND INFORMATIONTYPE=:INFORMATIONTYPE AND REQID=:REQID";
		String RETRIVE_APPROVE_USER_FOR_USERNAMEAPPROVED_PAGINATED_SQL = "SELECT id,app_name,company_details,company_name,employee_id,encrypt_company_details,encrypt_company_name,encrypt_employee_id,encrypt_end_date,encrypt_group_name,encrypt_insid,encrypt_insurance_id,encrypt_insured_amount,encrypt_insured_name,encrypt_start_date,end_date,group_name,insid,insurance_id,insured_amount,insured_name,start_date,th_level_encrypt_company_details,th_level_encrypt_company_name,th_level_encrypt_employee_id,th_level_encrypt_end_date,th_level_encrypt_group_name,th_level_encrypt_insid,th_level_encrypt_insurance_id,th_level_encrypt_insured_amount,th_level_encrypt_insured_name,th_level_encrypt_start_date,username,usernameapproved from insuranceinformationapprove WHERE usernameapproved=:usernameapproved limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_USERNAMEAPPROVE_SQL = "SELECT COUNT(*) FROM insuranceinformationapprove WHERE usernameapproved=:usernameapproved";
		String RETRIVE_MEDICAL_ALL_SQL = "SELECT medical_info_id from medicalinformation";
		String RETRIVE_USER_SPECIFIC_MEDICAL_INFORMATION_SQL = "select id,clinic_hospital_name,doctor_name,encrypt_clinic_hospital_name,encrypt_doctor_name,encrypt_end_date,encrypt_medical_treatment_details,encrypt_start_date,encypt_medical_info_id,encypt_medical_info_summary,end_date,medical_info_id,medical_info_summary,medical_treatment_details,start_date,th_level_encrypt_clinic_hospital_name,th_level_encrypt_doctor_name,th_level_encrypt_end_date,th_level_encrypt_medical_info_id,th_level_encrypt_medical_info_summary,th_level_encrypt_medical_treatment_details,th_level_encrypt_start_date,user_id from  medicalinformation where user_id=:user_id limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_MEDICALINFORMATION_LOGINID_SQL = "SELECT COUNT(*) FROM medicalinformation where user_id=:user_id";
		String RETRIVE_PRESCRIPTIONIDALL_SQL = "SELECT prescription_info_id from prescriptioninformation";
		String RETRIVE_USER_SPECIFIC_PRESCRIPTION_INFORMATION_SQL = "SELECT id,clinic_hospital_name,doctor_name,enc_clinic_hospital_name,enc_doctor_name,enc_end_date,enc_prescription_info_id,enc_prescription_info_summary,enc_prescription_treatment_details,enc_start_date,end_date,prescription_info_id,prescription_info_summary,prescription_treatment_details,start_date,th_enc_clinic_hospital_name,th_enc_doctor_name,th_enc_end_date,th_enc_prescription_info_id,th_enc_prescription_info_summary,th_enc_prescription_treatment_details,th_enc_start_date,user_id FROM prescriptioninformation where user_id=:user_id  limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_PRESCRIPTION_INFORMATION_LOGINID_SQL = "SELECT COUNT(*) FROM prescriptioninformation where user_id=:user_id";
		String RETRIVE_DISTINCT_USERIDS_FROM_MEDICALINFORMATION_SQL = "select distinct user_id from medicalinformation";
		String DELETE_FROM_APPROVEMEDICALINFO_WHERE_USERID_AND_USERIDAPPROVE_SQL = "DELETE FROM MEDICALINFORMATIONAPPROVE WHERE user_id=:user_id AND usernameapproved=:usernameapproved";
		String RETRIVE_MEDICALINFORMATION_FOR_USERID_SQL = "select id,clinic_hospital_name,doctor_name,encrypt_clinic_hospital_name,encrypt_doctor_name,encrypt_end_date,encrypt_medical_treatment_details,encrypt_start_date,encypt_medical_info_id,encypt_medical_info_summary,end_date,medical_info_id,medical_info_summary,medical_treatment_details,start_date,th_level_encrypt_clinic_hospital_name,th_level_encrypt_doctor_name,th_level_encrypt_end_date,th_level_encrypt_medical_info_id,th_level_encrypt_medical_info_summary,th_level_encrypt_medical_treatment_details,th_level_encrypt_start_date,user_id from  medicalinformation where user_id=:user_id";
		String DELETE_FROM_APPROVEPRESCRIPTIONINFO_WHERE_USERID_AND_USERIDAPPROVE_SQL = "DELETE FROM prescriptioninformationapprove WHERE user_id=:user_id AND usernameapproved=:usernameapproved";
		String RETRIVE_PRESCRIPTIONINFORMATION_FOR_USERID_SQL = "select id,clinic_hospital_name,doctor_name,enc_clinic_hospital_name,enc_doctor_name,enc_end_date,enc_prescription_info_id,enc_prescription_info_summary,enc_prescription_treatment_details,enc_start_date,end_date,prescription_info_id,prescription_info_summary,prescription_treatment_details,start_date,th_enc_clinic_hospital_name,th_enc_doctor_name,th_enc_end_date,th_enc_prescription_info_id,th_enc_prescription_info_summary,th_enc_prescription_treatment_details,th_enc_start_date,user_id FROM prescriptioninformation where user_id=:user_id";
		String RETRIVE_DISTINCT_USERIDS_FROM_PRESCRIPTIONINFORMATION_SQL = "select distinct user_id from prescriptioninformation";
		String RETRIVE_APPROVE_MEDICAL_POLICIES_FOR_PAGINATED_SQL = "select id,clinic_hospital_name,doctor_name,encrypt_clinic_hospital_name,encrypt_doctor_name,encrypt_end_date,encrypt_medical_treatment_details,encrypt_start_date,encypt_medical_info_id,encypt_medical_info_summary,end_date,medical_info_id,medical_info_summary,medical_treatment_details,start_date,th_level_encrypt_clinic_hospital_name,th_level_encrypt_doctor_name,th_level_encrypt_end_date,th_level_encrypt_medical_info_id,th_level_encrypt_medical_info_summary,th_level_encrypt_medical_treatment_details,th_level_encrypt_start_date,user_id,usernameapproved from medicalinformationapprove WHERE usernameapproved=:usernameapproved limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_USERNAMEAPPROVE_FROM_MEDICALINFO_SQL = "select COUNT(*) from medicalinformationapprove WHERE usernameapproved=:usernameapproved";
		String RETRIVE_APPROVED_PRECRIPTION_INFORMATION_FOR_USERNAMEAPPROVED_PAGINATED_SQL = "select id,clinic_hospital_name,doctor_name,enc_clinic_hospital_name,enc_doctor_name,enc_end_date,enc_prescription_info_id,enc_prescription_info_summary,enc_prescription_treatment_details,enc_start_date,end_date,prescription_info_id,prescription_info_summary,prescription_treatment_details,start_date,th_enc_clinic_hospital_name,th_enc_doctor_name,th_enc_end_date,th_enc_prescription_info_id,th_enc_prescription_info_summary,th_enc_prescription_treatment_details,th_enc_start_date,user_id,usernameapproved FROM prescriptioninformationapprove WHERE usernameapproved=:usernameapproved limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_USERNAMEAPPROVE_FROM_APPROVED_PRESCRIPTIONINFO_SQL = "select COUNT(*) from prescriptioninformationapprove WHERE usernameapproved=:usernameapproved";
		String RETRIVE_USER_SPECIFIC_INS_REQ_INFORMATION_FOR_USERNAMEAPPROVED_SQL = "SELECT REQID,USERIDMAKINGREQ,INFORMATIONTYPE,STATUS,USERID,USERTYPE,REQDETAILS,DATEREQ FROM REQUESTINFO WHERE USERIDMAKINGREQ=:USERIDMAKINGREQ AND INFORMATIONTYPE=:INFORMATIONTYPE limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_INSREQDETIALS_FOR_USERIDMAKINGREQ_AND_INFORMATIONTYPE_SQL = "select COUNT(*) FROM REQUESTINFO WHERE USERIDMAKINGREQ=:USERIDMAKINGREQ AND INFORMATIONTYPE=:INFORMATIONTYPE";
		String RETRIVE_ALLUSERS_PRESCRIPTION_INFORMATION_SQL = "select id,clinic_hospital_name,doctor_name,enc_clinic_hospital_name,enc_doctor_name,enc_end_date,enc_prescription_info_id,enc_prescription_info_summary,enc_prescription_treatment_details,enc_start_date,end_date,prescription_info_id,prescription_info_summary,prescription_treatment_details,start_date,th_enc_clinic_hospital_name,th_enc_doctor_name,th_enc_end_date,th_enc_prescription_info_id,th_enc_prescription_info_summary,th_enc_prescription_treatment_details,th_enc_start_date,user_id FROM prescriptioninformation limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_PRESCRIPTION_INFORMATION_SQL = "select count(*) from prescriptioninformation";
		String RETRIVE_ALL_MEDICAL_INFORMATION_FOR_PAGINATEDCONFIG_SQL = "select id,clinic_hospital_name,doctor_name,encrypt_clinic_hospital_name,encrypt_doctor_name,encrypt_end_date,encrypt_medical_treatment_details,encrypt_start_date,encypt_medical_info_id,encypt_medical_info_summary,end_date,medical_info_id,medical_info_summary,medical_treatment_details,start_date,th_level_encrypt_clinic_hospital_name,th_level_encrypt_doctor_name,th_level_encrypt_end_date,th_level_encrypt_medical_info_id,th_level_encrypt_medical_info_summary,th_level_encrypt_medical_treatment_details,th_level_encrypt_start_date,user_id from  medicalinformation limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_MEDICALINFORMATION_SQL = "select count(*) from medicalinformation";
		String RETRIVE_ALL_INSURANCE_INFORMATION_FOR_PAGINATEDCONFIG_SQL = "SELECT id,app_name,company_details,company_name,employee_id,encrypt_company_details,encrypt_company_name,encrypt_employee_id,encrypt_end_date,encrypt_group_name,encrypt_insid,encrypt_insurance_id,encrypt_insured_amount,encrypt_insured_name,encrypt_start_date,end_date,group_name,insid,insurance_id,insured_amount,insured_name,start_date,th_level_encrypt_company_details,th_level_encrypt_company_name,th_level_encrypt_employee_id,th_level_encrypt_end_date,th_level_encrypt_group_name,th_level_encrypt_insid,th_level_encrypt_insurance_id,th_level_encrypt_insured_amount,th_level_encrypt_insured_name,th_level_encrypt_start_date,username from insuranceinformation limit :LIMIT offset :OFFSET";
		String RETRIVE_TOTAL_COUNT_FOR_INSURANCEINFORMATION_SQL = "select count(*) from insuranceinformation";

	}

	interface InformationType {

		String INSURANCE = "INSURANCE";

		String MEDICAL = "MEDICAL";

		String PRESCRIPTION = "PRESCRIPTION";

	}

	interface AppointmentStatus {

		String APPROVED = "APPROVED";

		String UNAPPROVED = "UNAPPROVED";
	}

	interface AdminCredentials {

		String USERNAME = "sphradmin";

		String PASSWORD = "pass@1234";

	}
	
	interface ErrorMessages{
		
		String CLOSENESS_ROUTES_ERROR="closeness_routes_error";
		String BESTROUTE_CLOSENESS_ROUTES_ERROR = "bestroute_closeness_routes_error";
		String BETWEEN_ROUTES_ERROR = "between_routes_error";
		String BESTROUTE_BETWEEN_ROUTES_ERROR="bestroute_between_routes_error";
		String ECENTRAL_ROUTES_ERROR = "ecentral_routes_error";
		String BESTROUTE_ECENTRAL_ROUTES_ERROR = "bestroute_ecentral_routes_error";
		String OPTIMIZED_ROUTES_ERROR = "optimized_routes_error";
		String BESTROUTE_OPTIMIZED_ROUTES_ERROR = "bestroute_optimized_routes_error";
	}

}
