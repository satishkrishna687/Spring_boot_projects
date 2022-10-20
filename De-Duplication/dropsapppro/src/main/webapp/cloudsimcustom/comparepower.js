Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});

var energyColumns1=[
         			{
         				header : 'Iteration Number',
         				dataIndex : 'iterationNo',
         				sortable:false,
         				width:265
         			},
         			 {
         				header : 'Power Algo1',
         				dataIndex : 'power',
         				sortable:true,
         				width    :258
         			}
         	    		];

var energyColumns2=[
        			{
        				header : 'Iteration Number',
        				dataIndex : 'iterationNo',
        				editable:false,
        				sortable:false,
        				width:265
        			},
        			 {
        				header : 'Power Algo2',
        				dataIndex : 'power',
        				sortable:true,
        				width    :258
        			}
        	    		];

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
   Ext.define('energyCompareModel', {
				extend : 'Ext.data.Model',
				fields : [ 
				           {name:'iterationNo', mapping:'iterationNo',type:'int'},
				           {name:'power', mapping:'powerConsumed',type:'double'}
						  ],
				idProperty: 'iterationNo'
			});

     
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
				id : 'energyCompareStoreId1',
				name : 'energyCompareStoreName1',
				model : 'energyCompareModel',
				proxy : {
					type : 'ajax',
					url :contextPath+'/edf/poweralgo1.do',
					actionMethods:{
						read:'POST'
					},
					reader : {
						type :'json',
						root:'model',
						totalProperty:'totalSize'
					}
				},
				listeners:
				{
					'load':function(store, records){
				}			
				},
				autoLoad : true
			});
	energyCompareStoreAlgo1Store.load();
	
	var energyGridPanelAlgo1 = Ext.create('Ext.grid.Panel', {
		collapsible:true,
		title:'Power Consumption in mw for Random Routing Algorithm',
		forceFit : true,
		id : 'topologyGrid1',
		store : energyCompareStoreAlgo1Store,
		columns :energyColumns1,
		maxHeight : 300,
		width : 800,
		autoFit : true,
		stripRows:true,
		renderTo : 'energyGridPanelAlgo1Container'
	});
	
	
	var energyCompareStoreAlgo2Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId2',
		name : 'energyCompareStoreName2',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/edf/poweralgo2.do',
			actionMethods:{
				read:'POST'
			},
			reader : {
				type :'json',
				root:'model',
				totalProperty:'totalSize'
			}
		},
		listeners:
		{
			'load':function(store, records){
		}			
		},
		autoLoad : true
	});
energyCompareStoreAlgo2Store.load();

var energyGridPanelAlgo2 = Ext.create('Ext.grid.Panel', {
collapsible:true,
title:'Power Consumption in mw for Effcient Data Forwarding Routing',
forceFit : true,
id : 'topologyGrid2',
store : energyCompareStoreAlgo2Store,
columns :energyColumns2,
maxHeight : 300,
width : 800,
autoFit : true,
stripRows:true,
renderTo : 'energyGridPanelAlgo2Container'
});

});
	
	
	
