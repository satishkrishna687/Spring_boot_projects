Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});



Ext.onReady(function () {
	
	
	var reviewColumns=[{
		header : 'ID',
		dataIndex : 'id',
		sortable:false,
		width:200
		},
			{
				header : 'Algo1 Level Bytes',   
				dataIndex : 'levelAlgo1',
				sortable:false,
				width:200
			},
			{
				header : 'Algorithm2 Level Bytes',
				dataIndex : 'levelAlgo2',
				sortable:false,
				width:300
			},
			{
				header : 'Time Taken Algo1',
				dataIndex : 'algo1Time',
				sortable:false,
				width:300
			},
			
			{
				header : 'Time Taken Algo2',
				dataIndex : 'algo2Time',
				sortable:false,
				width:300
			}
			
			];
	
	Ext.define('securityModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'id', mapping:'id',type:'int'},
		           {name:'levelAlgo1', mapping:'levelAlgo1',type:'double'},
		           {name:'levelAlgo2', mapping:'levelAlgo2',type:'double'},
		           {name:'algo1Time', mapping:'algo1Time',type:'double'},
		           {name:'algo2Time', mapping:'algo2Time',type:'double'}
				  ],
		idProperty: 'id'
	});
	
	var securityLevelStore = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'securityModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/comparesecuritylevels',
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
securityLevelStore.load();


var reviewGrid = Ext.create('Ext.grid.Panel', {
	collapsible:true,
	title:'File Uploads',
	forceFit : true,
	id : 'reviewGrid',
	store : securityLevelStore,
	columns :reviewColumns,
	height : 400,
	width : 1200,
	autoFit : true,
	stripRows:true,
	renderTo : 'reviewGridContainer'
	
});
	


});    
           