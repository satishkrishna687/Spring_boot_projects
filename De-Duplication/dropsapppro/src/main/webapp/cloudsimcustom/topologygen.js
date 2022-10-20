Ext.require( [ 'Ext.grid.*', 'Ext.data.*', 'Ext.form.*',
		'Ext.layout.container.Column', 'Ext.tab.Panel' ]);
Ext.Loader.setConfig( {
	enabled : true
});

var hideConfirmationMsg;
var showConfirmationMsg;
/* Hide the Confirmation Message */
hideConfirmationMsg = function() {
	var confMsgDiv = Ext.get('confirmationMessage');
	confMsgDiv.dom.innerHTML = "";
	confMsgDiv.dom.style.display = 'none';
}
/* Show Confirmation Message */
showConfirmationMsg = function(msg) {
	var confMsgDiv = Ext.get('confirmationMessage');
	confMsgDiv.dom.innerHTML = msg;
	confMsgDiv.dom.style.display = 'inline-block';
}

Ext.onReady(function() {

			var contentPanel = Ext.create('Ext.form.Panel',
							{
								width : 1000,
								height : 400,
								defaults : {
								padding : '15 50 15 50',
									labelAlign : 'top'
								},
								layout : {
									type : 'table',
									columns : 3
								},
								items : [
										{
											xtype : 'textfield',
											fieldLabel : 'Enter Number of  Nodes:',
											allowBlank : true,
											id : 'noOfNodes',
											name : 'noOfNodes',
											allowBlank : false,
											maxLength : 2,
											minLength : 1,
											msgTarget : 'under',
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Number of nodes must have minimum of 1 character',
											blankText : 'Please enter Number of nodes'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the minimum x cordinate:',
											id : 'minXCor',
											name : 'minXCor',
											msgTarget : 'under',
											hidden : false,
											value : 1,
											allowBlank : false,
											maxLength : 2,
											minLength : 1,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Minimum x cordinate must have minimum of 1 character',
											blankText : 'Please enter Minimum x Cordinate'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the maximum x cordinate:',
											allowBlank : true,
											hidden : false,
											id : 'maxXCor',
											msgTarget : 'under',
											name : 'maxXCor',
											allowBlank : false,
											value : 99,
											maxLength : 2,
											minLength : 1,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Maximum x cordinate must have minimum of 1 character',
											blankText : 'Please enter Maximum x Cordinate'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the minimum y cordinate:',
											id : 'minYCor',
											name : 'minYCor',
											msgTarget : 'under',
											hidden :false,
											value : 1,
											allowBlank : false,
											maxLength : 2,
											minLength : 1,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Minimum y cordinate must have minimum of 1 character',
											blankText : 'Please enter Minimum y Cordinate'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the maximum y cordinate:',
											hidden : false,
											id : 'maxYCor',
											value : 99,
											name : 'maxYCor',
											msgTarget : 'under',
											allowBlank : false,
											maxLength : 2,
											minLength : 1,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Maximum y cordinate must have minimum of 1 character',
											blankText : 'Please enter Maximum y Cordinate'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the energy of node Optimized:',
											allowBlank : true,
											msgTarget : 'under',
											id : 'energy',
											name : 'energy',
											allowBlank : false,
											maxLength : 6,
											hidden : false,
											value : 9999,
											minLength : 1,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Minimum Energy must have minimum of 1 character',
											blankText : 'Please enter Energy of the node'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the Enery of Closeness Centrality:',
											msgTarget : 'under',
											id : 'power',
											name : 'power',
											allowBlank : false,
											maxLength : 6,
											minLength : 1,
											value:9999,
											hidden:false,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Minimum value of Enery must have minimum of 1 character',
											blankText : 'Please enter Power of the node'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the Energy of E Centrality:',
											allowBlank : true,
											hidden : false,
											value : 9999,
											id : 'buffer',
											name : 'buffer',
											msgTarget : 'under',
											allowBlank : false,
											maxLength : 4,
											minLength : 1,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Minimum value of Energy of Optimized method must have minimum of 1 character',
											blankText : 'Please enter Energy of Optimized method of the node'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the Energy of Between Centrality:',
											allowBlank : true,
											id : 'networkCost',
											name : 'networkCost',
											allowBlank : false,
											hidden : false,
											value : 9999,
											msgTarget : 'under',
											maxLength : 4,
											minLength : 1,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Energy of Between Centrality must have minimum of 1 character',
											blankText : 'Please enter Energy of Between Centrality of the node'
										},
										{
											xtype : 'textfield',
											fieldLabel : 'Enter the  Distance between the nodes:',
											allowBlank : false,
											id : 'distanceBetweenNodes',
											name : 'distanceBetweenNodes',
											msgTarget : 'under',
											maxLength : 2,
											minLength : 1,
											value:20,
											width : 150,
											enforceMaxLength : true,
											minLengthText : 'Minimum Distance Between Nodes have minimum of 1 character',
											blankText : 'Please enter Distance between  the nodes'
										},
										{
											xtype : 'button',
											text : 'Generate Topology',
											width:220,
											id : 'Save',
											disabled : false,
											handler : function(store, btn, args) {

												var topologyGenFormat = generateJSONRequestForTopologyGen();
												urlLink = contextPath + '/edftopologygen.do';
												hideConfirmationMsg();
												doTopologyGenerationRequest(
														topologyGenFormat,
														urlLink);
											}
										}, {
											xtype : 'button',
											text : 'Reset',
											width:150,
											id : 'Reset',
											disabled : false,
											handler : function() {
												contentPanel.getForm().reset();
											}
										} ],
								renderTo : 'contentDiv',
								collapsible:true,
								title:'Enter the Topology Information Input'
									
							});

			function doTopologyGenerationRequest(topologyGenFormat, urlLink) {
				var loadMask = new Ext.LoadMask(Ext.getBody(), {
					msg : "Loading"
				});
				loadMask.show();
				Ext.Ajax.timeout = 90000;
				Ext.Ajax.request( {
					method : 'POST',
					processData : false,
					contentType : 'application/json',
					jsonData : Ext.encode(topologyGenFormat),
					url : urlLink,
					success : function(response) {
						var data;
						if (response) {

							var JsonData = Ext.decode(response.responseText);
							if (JsonData.ebErrors != null) {
								var errorObj = JsonData.ebErrors;
								for (i = 0; i < errorObj.length; i++) {
									var value = errorObj[i].errMessage;
									showConfirmationMsg(value);
								}
								loadMask.hide();
							} else {
								var value = JsonData.message;
								showConfirmationMsg(value);
								contentPanel.hide();
								loadMask.hide();
							}
						}
					},
					failure : function(data) {
						loadMask.hide();
					}
				});
			}

			function generateJSONRequestForTopologyGen() {
				var topologyGenFormat = {};
				var noOfNodes = Ext.getCmp('noOfNodes').getValue();
				if (noOfNodes != null) {
					topologyGenFormat.noOfNodes = noOfNodes;
				}
				var minXCor = Ext.getCmp('minXCor').getValue();
				if (minXCor != null) {
					topologyGenFormat.minXCor = minXCor;
				}
				var maxXCor = Ext.getCmp('maxXCor').getValue();
				if (maxXCor != null) {
					topologyGenFormat.maxXCor = maxXCor;
				}
				var minYCor = Ext.getCmp('minYCor').getValue();
				if (minYCor != null) {
					topologyGenFormat.minYCor = minYCor;
				}
				var maxYCor = Ext.getCmp('maxYCor').getValue();
				if (maxYCor != null) {
					topologyGenFormat.maxYCor = maxYCor;
				}
				var energy = Ext.getCmp('energy').getValue();
				if (energy != null) {
					topologyGenFormat.energy = energy;
				}
				var power = Ext.getCmp('power').getValue();
				if (power != null) {
					topologyGenFormat.power = power;
				}
				var buffer = Ext.getCmp('buffer').getValue();
				if (buffer != null) {
					topologyGenFormat.buffer = buffer;
				}
				var networkCost = Ext.getCmp('networkCost').getValue();
				if (networkCost != null) {
					topologyGenFormat.networkCost = networkCost;
				}
				var distanceBetweenNodes = Ext.getCmp('distanceBetweenNodes')
						.getValue();
				if (distanceBetweenNodes != null) {
					topologyGenFormat.distanceBetweenNodes = distanceBetweenNodes;
				}
				return topologyGenFormat;
			}

		});