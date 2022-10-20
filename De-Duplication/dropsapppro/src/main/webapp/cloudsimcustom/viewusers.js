      angular.module("viewUsersApp", ["kendo.directives"]).controller("viewUsersController", function ($scope, $http) {

    	  $http.get(register_end_point)
          .then(function(response) {
              $scope.usersData = response.data.content;
          	
              $scope.viewUsersOptions={
      				columns: [
      					 {
                          field: "userMaintainId.userName",
                          title: "User Name"
                          },				
						 {
                          field: "email",
                          title: "Email"
                          },{
                          field: "phoneNo",
                          title: "Phone No"
                          },{
                          field: "city",
                          title: "City"
                          },{
                          field: "state",
                          title: "State"
                          },{
                          field: "country",
                          title: "Country"
                          },{
                          field: "gender",
                          title: "Gender"
                          },{
                          field: "age",
                          title: "Age"
                          },{
                          field: "loginType",
                          title: "LoginType",
                          
                          }
						  
						  
						  ],
      					columnMenu:true,
      					 scrollable: true,
                           sortable: true,
                           dataSource: {
                               data:  $scope.usersData,
                               schema: {
                                   model: {
                                       fields: {
                                      	 email: { type: "string" },
										 phoneNo: { type: "string" },
										 city: { type: "string" },
										 state: { type: "string" },
										 country: { type: "string" },
										 gender: { type: "string" },
										 age: { type: "int" },
										 loginType: { type: "int" }
                                       }
                                   }
                               }
                             }
      					
      			};
              
          });


        });