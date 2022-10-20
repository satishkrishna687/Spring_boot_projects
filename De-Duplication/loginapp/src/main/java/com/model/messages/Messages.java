package com.model.messages;

public interface Messages {

	String INVALID_USER_PASSWORD_MSG = "Invalid Username/Password";
	String NO_USER_FOUND = "No User has been Found";
	String OLD_PASSWORD_CANNOT_BE_EMPTY = "Old Password Cannot be Empty";
	String NEW_PASSWORD_CANNOT_BE_EMPTY = "New Password Cannot be Empty";
	String CONFIRM_NEW_PASSWORD_CANNOT_BE_EMPTY = "Conform New Password cannot be Same";
	String NEW_PASSWORD_CONFIRM_PASSWORD_NOT_SAME = "New Password and Confirm Password cannot be Same";
	String OLD_PASSWORD_NOT_MATCHING_RECORDS = "Old Password does not match records";
	String SESSION_EXPIRED = "Session has Expired";
	String CRITICAL_ERROR = "Critical Error has Occured";
	String DEGREE_REQUIRED_ERROR = "Degree is Required";
	String SPECIFICATION_REQUIRED_ERROR = "Specification is Required";
	String ADDRESS_REQUIRED_ERROR = "Address is Required";
	String PINCODE_REQUIRED_ERROR = "Pin Code is Required";
	String PINCODE_NUMERIC_ERROR = "Pin Code must be Numeric";
	String FATHERNAME_REQUIRED_ERROR = "Father Name is Required";
	String FATHERNUMBER_REQUIRED_ERROR = "Father Number is Required";
	String FATHERNUMBER_NUMERIC_ERROR = "Father Number is Numeric";
	String FATHEREMAIL_REQUIRED_ERROR = "Father Email is Required";
	String MOTHERNAME_REQUIRED_ERROR = "Mother Name is Required";
	String MOTHERNUMBER_REQUIRED_ERROR = "Mother Number is Required";
	String MOTHERNUMBER_NUMERIC_ERROR = "Mother Number is Numeric";
	String MOTHEREMAIL_REQUIRED_ERROR = "Mother Email is Required";
	String GUARDIANNAME_REQUIRED_ERROR = "Guardian Name is Required";
	String GUARDIANEMAIL_REQUIRED_ERROR = "Guardian Email is Required";
	String GUARDIANNUMBER_REQUIRED_ERROR = "Guardian Number is Required";
	String GUARDNUMBER_NUMERIC_ERROR = "Guardian Number must be Numeric";
	String ADMISSIONTYPE_REQUIRED_ERROR = "Admission Type is Required";
	String CHALLANNUMBER_REQUIRED_ERROR = "Challan Number is Required";
	String FEEPAID_REQUIRED_ERROR = "Fees Paid is Required";
	String RESIDENCE_ADDRESS_REQUIRED_ERROR = "Residence Address is Required";
	String RESIDENCE_STATUS_REQUIRED_ERROR = "Residence Status is Required";
	String SEMESTER_MARKS_REQUIRED = "Semester Marks is Required";
	String SUBJECT_LIST_REQUIRED = "Subject List is Required";
	String ACTIVITY_LIST_REQUIRED = "Activity List is Required";
	String DEPT_REQUIRED = "Department is Required";
	String INSTANCE_GAMMA_WITH_AES = "AES/ECB/PKCS5PADDING";

	interface Keys {
		String OBJ = "OBJ";
		String LOGINID_SESSION = "LOGINID_SESSION";
		String LOGINTYPE_SESSION = "LOGINTYPE_SESSION";
		int ADMIN_TYPE = 1;
	}

	interface Page {
		String REGISTER_PAGE = "registeruser";
		String LOGIN_PAGE = "login";
		String CLIENT_PAGE = "client";
		String ADMIN_PAGE = "admin";
		String WELCOME_PAGE = "welcome";
	}
}
