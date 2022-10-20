Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});

var energyColumns1=[
		{
			header : 'Iteration Number',
			dataIndex : 'id',
			sortable:false,
			width:265
		},
		 {
			header : 'File Size Closeness Centrality',
			dataIndex : 'fileSizeBytesClosenessCentrality',
			sortable:true,
			width    :258
		},
		 {
			header : 'File Size Between Centrality',
			dataIndex : 'fileSizeBytesBetweenCentrality',
			sortable:true,
			width    :258
		},
		 {
			header : 'File Size E Centrality',
			dataIndex : 'fileSizeBytesECentrality',
			sortable:true,
			width    :258
		},
		 {
			header : 'File Size Optimized Centrality',
			dataIndex : 'fileSizeBytesOptimizedCentrality',
			sortable:true,
			width    :258
		},{
			header : 'Upload Time Closeness Centrality',
			dataIndex : 'uploadTimeClosenessCentrality',
			sortable:true,
			width    :258
		},
		 {
			header : 'Upload Time Between Centrality',
			dataIndex : 'uploadTimeBetweenCentrality',
			sortable:true,
			width    :258
		},
		 {
			header : 'Upload Time E Centrality',
			dataIndex : 'uploadTimeECentrality',
			sortable:true,
			width    :258
		},
		 {
			header : 'Upload Time Optimized Centrality',
			dataIndex : 'uploadTimeOptimizedCentrality',
			sortable:true,
			width    :258
		},{
			header : 'Memory Closeness Centrality',
			dataIndex : 'memoryClosenessCentrality',
			sortable:true,
			width    :258,
			hidden:true
		},
		 {
			header : 'Memory Between Centrality',
			dataIndex : 'memoryBetweenCentrality',
			sortable:true,
			width    :258,
			hidden:true
		},
		 {
			header : 'Memory E Centrality',
			dataIndex : 'memoryBetweenECentrality',
			sortable:true,
			width    :258,
			hidden:true
		},
		 {
			header : 'Memory Optimized Centrality',
			dataIndex : 'memoryOptimizedCentrality',
			sortable:true,
			width    :258,
			hidden:true
		}
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'id', mapping:'id',type:'int'},
		           {name:'fileSizeBytesClosenessCentrality', mapping:'fileSizeBytesClosenessCentrality',type:'double'},
		           {name:'fileSizeBytesBetweenCentrality', mapping:'fileSizeBytesBetweenCentrality',type:'double'},
		           {name:'fileSizeBytesECentrality', mapping:'fileSizeBytesECentrality',type:'double'},
		           {name:'fileSizeBytesOptimizedCentrality', mapping:'fileSizeBytesOptimizedCentrality',type:'double'},
		           {name:'uploadTimeClosenessCentrality', mapping:'uploadTimeClosenessCentrality',type:'double'},
		           {name:'uploadTimeBetweenCentrality', mapping:'uploadTimeBetweenCentrality',type:'double'},
		           {name:'uploadTimeECentrality', mapping:'uploadTimeECentrality',type:'double'},
		           {name:'uploadTimeOptimizedCentrality', mapping:'uploadTimeOptimizedCentrality',type:'double'},
		           {name:'memoryClosenessCentrality', mapping:'memoryClosenessCentrality',type:'double'},
		           {name:'memoryBetweenCentrality', mapping:'memoryBetweenCentrality',type:'double'},
		           {name:'memoryBetweenECentrality', mapping:'memoryBetweenECentrality',type:'double'},
		           {name:'memoryOptimizedCentrality', mapping:'memoryOptimizedCentrality',type:'double'}
		           
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
			url :contextPath+'/compareFileCompareData.do',
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
	title:'File Size based across Algorithms',
	forceFit : true,
	id : 'topologyGrid1',
	store : energyCompareStoreAlgo1Store,
	columns :energyColumns1,
	maxHeight : 500,
	width :1200,
	autoFit : true,
	stripRows:true,
	renderTo : 'keyContainer',
	bbar: Ext.create('Ext.PagingToolbar', {
        store: energyCompareStoreAlgo1Store,
        displayInfo: true,
        displayMsg: 'Displaying File Size {0} - {1} of {2}',
        emptyMsg: "No File Size to display",
        inputItemWidth: 35
 })
});

	
	

});    
           