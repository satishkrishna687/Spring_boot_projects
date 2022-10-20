Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});
Ext.tip.QuickTipManager.init();

var energyColumns1=[
		{
			header : 'Route No',
			dataIndex : 'routeno',
			sortable:false,
			width:150
		},
		 {
			header : 'Algorithm Type',
			dataIndex : 'algorithmtype',
			sortable:true,
			width    :150
		},{
			header : 'Session Id',
			dataIndex : 'sessionid',
			sortable:true,
			width    :150,
			renderer : function(value, metadata, record, rowIndex, colIndex, store) {
				metadata.tdAttr = 'data-qtip="' + value + '"';
				return value;
			}
		},{
			header : 'User Name',
			dataIndex : 'username',
			sortable:true,
			width    :150
		},
		 {
			header : 'Route',
			dataIndex : 'routeinstrformat',
			sortable:true,
			width    :400,
			renderer : function(value, metadata, record, rowIndex, colIndex, store) {
					metadata.tdAttr = 'data-qtip="' + value + '"';
					return value;
			}
		}];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'routeno', mapping:'routeno',type:'int'},
		           {name:'algorithmtype', mapping:'algorithmtype',type:'string'},
		           {name:'sessionid', mapping:'sessionid',type:'string'},
		           {name:'username', mapping:'username',type:'string'},
		           {name:'routeinstrformat', mapping:'routeinstrformat',type:'string'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		autoLoad: {start: 0, limit: 15},
		proxy : {
			type : 'ajax',
			url :contextPath+'/retriveRouteHistoryForAll',
			actionMethods:{
				read:'POST'
			},
			reader : {
				type :'json',
				root:'model',
				totalProperty:'total'
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
	title:'Customer File Chunks',
	forceFit : true,
	id : 'topologyGrid1',
	store : energyCompareStoreAlgo1Store,
	columns :energyColumns1,
	maxHeight : 500,
	width : 1200,
	autoFit : true,
	stripRows:true,
	renderTo : 'keyContainer',
	overflowY:'auto',
	bbar: Ext.create('Ext.PagingToolbar', {
        store: energyCompareStoreAlgo1Store,
        displayInfo: true,
        displayMsg: 'Displaying Customer Chunks {0} - {1} of {2}',
        emptyMsg: "No Customer Chunks to display",
        inputItemWidth: 35
 })
});

	
	

});    
           