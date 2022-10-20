      angular.module("processingApp", ["kendo.directives"]).controller("processingAppController", function ($scope, $http) {

            $scope.errorMsg = "";
            $scope.sucessMsg = "";
            $scope.showSucess = false;
            $scope.showError = false;

           
        $scope.perform_processing = function () {

            $scope.errorMsg = "";
            $scope.sucessMsg = "";
            $scope.showSucess = false;
            $scope.showError = false;
			$scope.data_submission=true;
		
            $http({
                method: 'GET',
                url: contextPath+'/performPreprocessing',
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
                    $scope.sucessMsg = JsonData.sucessMsg;
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