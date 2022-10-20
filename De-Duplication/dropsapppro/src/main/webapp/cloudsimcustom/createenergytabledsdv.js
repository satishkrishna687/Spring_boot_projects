Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
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
		confMsgDiv.dom.innerHTML =  msg;
		confMsgDiv.dom.style.display = 'inline-block';		
	}
	
Ext.onReady(function () {
	
	
	var contentPanel = Ext.create('Ext.container.Container', {
		width: 500,
		height: 500, 
		autoScroll: true,	
		defaults: {
			//padding: '15 15 15 15',
			labelAlign: 'top'
			},
        layout: {
			type: 'table',
			columns: 3
		},
		items:[
				{
					xtype:'button',
				    text: 'Generate Energy Tables',
					id: 'Save',
					disabled: false,
			        handler: function (store,btn, args) {
							urlLink=contextPath+'/eedr/createEnergyTablesForDSDV.do';
							hideConfirmationMsg();
							doCreatePowerRequest(urlLink);
			            }
				}],
		renderTo:'contentDiv'
    });
    
	
	
	
	function doCreatePowerRequest(urlLink)
	{
			var loadMask = new Ext.LoadMask(Ext.getBody(), {msg:"Loading"});
			loadMask.show();
			Ext.Ajax.request({	
			method: 'POST',
			processData: false,
			contentType:'application/json',
			url:urlLink, 
			success: function(response) {
			var data;
			if (response){
						 
						var JsonData = Ext.decode(response.responseText);
							if(JsonData.ebErrors != null){
								var errorObj=JsonData.ebErrors;
								for(i=0;i<errorObj.length;i++)
								{
										var value=errorObj[i].errMessage;
										showConfirmationMsg(value);
								}
								loadMask.hide();
							}
							else
							{
								var value=JsonData.message;
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
   
		
});