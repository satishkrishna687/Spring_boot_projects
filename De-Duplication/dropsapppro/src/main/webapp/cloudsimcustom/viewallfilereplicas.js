Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});
Ext.tip.QuickTipManager.init();

var energyColumns1=[
		{
			header : 'File Chunk Id',
			dataIndex : 'filechunkid',
			sortable:false,
			width:150
		},
		 {
			header : 'Sequence No',
			dataIndex : 'sequeneno',
			sortable:true,
			width    :150
		},
		 {
			header : 'Node Id',
			dataIndex : 'nodeId',
			sortable:true,
			width    :150
		},
		//pageNo
		 {
				header : 'Page No',
				dataIndex : 'pageNo',
				sortable:true,
				width    :150
			}
		
		,{
			header : 'Algorithm Name',
			dataIndex : 'algorithmName',
			sortable:true,
			width    :150
		},{
			header : 'Session Id',
			dataIndex : 'sessionId',
			sortable:true,
			width    :150,
			renderer : function(value, metadata, record, rowIndex, colIndex, store) {
				metadata.tdAttr = 'data-qtip="' + value + '"';
				return value;
			}
		},{
			header : 'User Name',
			dataIndex : 'userName',
			sortable:true,
			width    :150
		},
		 {
			header : 'Encyption Chunk',
			dataIndex : 'encryptedchunk',
			sortable:true,
			width    :400,
			renderer : function(value, metadata, record, rowIndex, colIndex, store) {
 					metadata.tdAttr = 'data-qtip="' + value + '"';
 					return value;
 			}
		}
		
		
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'filechunkid', mapping:'filechunkid',type:'int'},
		           {name:'datachunk', mapping:'datachunk',type:'string'},
		           {name:'encryptedchunk', mapping:'encryptedchunk',type:'string'},
		           {name:'sequeneno', mapping:'sequeneno',type:'int'},
		           {name:'nodeId', mapping:'nodeId',type:'int'},
		           {name:'pageNo', mapping:'pageNo',type:'int'},
		           {name:'sessionId', mapping:'sessionId',type:'string'},
		           {name:'userName', mapping:'userName',type:'string'},
		           {name:'algorithmName', mapping:'algorithmName',type:'string'}
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
			url :contextPath+'/retriveAllReplicas',
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
           