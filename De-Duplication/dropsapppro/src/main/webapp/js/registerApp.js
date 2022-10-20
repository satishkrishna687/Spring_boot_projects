      angular.module("registerUserApp", []).controller("registerUserController", function ($scope, $http) {

            $scope.errorMsg = "";
            $scope.sucessMsg = "";
            $scope.showSucess = false;
            $scope.showError = false;

            $scope.register = {

               
                password: "",
                email: "",
                phoneNo: "",
                country: "",
                state: "",
                city: "",
                age: 0,
                loginType: 2,
                additionalConfig: {
                	
                	isStateRequired:1,
                	isCountryRequired:1,
                	isCityRequired:1,
                	isGenderRequired:1,
                	isAgeRequired:1

                	
                }

            };
            
            
            $scope.genders=[
            	
            	  {name: "Male"},
                  {name: "FeMale"},
                  {name: "Other"}
            	
            ];
            
            $scope.gender_options={
           		 data:  $scope.genders,
                    schema: {
                        model: {
                            fields: {
                           	 name: { type: "string" }
                            }
                        }
                    }
           	};


        _isEmpty = function (val) {
            return (val === undefined || val == null || val.length <= 0) ? true : false;
        }

        _checkEmail = function (email) {
            var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

            if (!filter.test(email.value)) {
                return false;
            } else {
                return true;
            }
        }
        $scope.register_user = function () {

            $scope.errorMsg = "";
            $scope.sucessMsg = "";
            $scope.showSucess = false;
            $scope.showError = false;
			$scope.data_submission=true;

			
			
            if (_isEmpty($scope.userName)) {
                $scope.showError = true;
                $scope.errorMsg = "User Name is mandatory";
                $scope.data_submission=false;
                return;
            }

            if (_isEmpty($scope.register.password)) {
                $scope.showError = true;
                $scope.errorMsg = "Password is mandatory";
                $scope.data_submission=false;
                return;
            }



            if (_isEmpty($scope.register.email)) {
                $scope.showError = true;
                $scope.errorMsg = "Email is mandatory or Email Address is invalid";
                $scope.data_submission=false;
                return;
            }
            

            if (_isEmpty($scope.register.phoneNo)) {
                $scope.showError = true;
                $scope.errorMsg = "Phone No is mandatory";
                $scope.data_submission=false;
                return;
            }
            
        	if (_isEmpty($scope.register.gender)) {
                $scope.showError = true;
                $scope.errorMsg = "Please Select the Gender";
                $scope.data_submission=false;
                return;
            }

            if (_isEmpty($scope.register.country)) {
                $scope.showError = true;
                $scope.errorMsg = "Country is Mandatory";
                $scope.data_submission=false;
                return;
            }

            if (_isEmpty($scope.register.state)) {
                $scope.showError = true;
                $scope.errorMsg = "State is Mandatory";
                $scope.data_submission=false;
                return;
            }

            if (_isEmpty($scope.register.city)) {
                $scope.showError = true;
                $scope.errorMsg = "City is Mandatory";
                $scope.data_submission=false;
                return;
            }

            if (_isEmpty($scope.register.age)) {
                $scope.showError = true;
                $scope.errorMsg = "Age is Mandatory";
                $scope.data_submission=false;
                return;
            }
			
			if($scope.register.age<=12){
				 $scope.showError = true;
                $scope.errorMsg = "Please enter age of atleast 13";
                $scope.data_submission=false;
                return;
			}
			
		
			
			$scope.register.userMaintainId={};
			
			$scope.register.userMaintainId.appName=app_name_registered;
			$scope.register.userMaintainId.userName=$scope.userName;


            $http({
                method: 'POST',
                url: register_end_point,
                data: $scope.register,
                headers: {'Content-Type': 'application/json'}
            }).then(function (response) {
                console.log('Response');
                console.log(response);
                var JsonData = response.data;

                if (JsonData.status == false) {
                    $scope.showError = true;
                     $scope.showSucess = false;
                    $scope.errorMsg = JsonData.errMessages[0].errMessage;
                    $scope.data_submission=false;
                    return;
                } else {

                    $scope.showSucess = true;
                    $scope.showError = false;
                    $scope.sucessMsg = "User has Registered Successfully Please Login";
                    $scope.data_submission=false;
                    return;
                }
				
					$scope.data_submission=false;


            }, function (response) {

			   $scope.data_submission=false;

                $scope.showError = true;
                $scope.showSucess = false;
                $scope.errorMsg = "An Internal error. Please Contact System Admin";
                
                return;

            });

        };


        });