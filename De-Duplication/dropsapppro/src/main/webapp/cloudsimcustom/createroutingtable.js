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
		width: 1000,
		height: 500, 
		defaults: {
			labelAlign: 'top'
		},
        layout: {
			type: 'table',
			columns: 3
		},
		items:[
				{
					xtype:'button',
				    text: 'Generate Routing Tables',
					id: 'Save',
					disabled: false,
			        handler: function (store,btn, args) {
							urlLink=contextPath+'/eedr/createroutingtables.do';
							hideConfirmationMsg();
							doCreateRoutingRequest(urlLink);
			            }
				}],
		renderTo:'contentDiv'
    });
    
	
	
	
	function doCreateRoutingRequest(urlLink)
	{
			var loadMask = new Ext.LoadMask(Ext.getBody(), {msg:"Loading"});
			loadMask.show();
			Ext.Ajax.timeout = 90000;
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