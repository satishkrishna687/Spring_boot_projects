Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});
Ext.tip.QuickTipManager.init();

var energyColumns1=[{
	header : 'ID',
	dataIndex : 'id',
	sortable:false,
	width:150
},
		{
			header : 'Between Centrality Time',
			dataIndex : 'betweenCentralityTime',
			sortable:false,
			width:150
		},
		 {
			header : 'E Centrality Time',
			dataIndex : 'eCentralityTime',
			sortable:true,
			width    :150
		},{
			header : 'Closeness Centrality Time',
			dataIndex : 'closenessCentralityTime',
			sortable:true,
			width    :150
		},{
			header : 'Optimized Time',
			dataIndex : 'optimizedTime',
			sortable:true,
			width    :150
		},{
			header : 'Memory Consumed Closeness Centrality',
			dataIndex : 'memoryConsumedClosenessCentrality',
			sortable:true,
			width    :150
		},
		 {
			header : 'Memory Consumed Between Centrality',
			dataIndex : 'memoryConsumedBetweenCentrality',
			sortable:true,
			width    :150
		},
		 {
			header : 'Memory Consumed E Centrality',
			dataIndex : 'memoryConsumedECentrality',
			sortable:true,
			width    :150
		},
		 {
			header : 'Memory Consumed Optimized',
			dataIndex : 'memoryConsumedOptimized',
			sortable:true,
			width    :150
		},
		 {
			header : 'Encryption Bytes Centrality',
			dataIndex : 'encBytesClosenessCentrality',
			sortable:true,
			width    :150
		},
		 {
			header : 'Encryption Bytes Centrality',
			dataIndex : 'encBytesBetweenCentrality',
			sortable:true,
			width    :150
		},
		 {
			header : 'Encryption Bytes E Centrality',
			dataIndex : 'encBytesECentrality',
			sortable:true,
			width    :150
		},
		 {
			header : 'Encryption Bytes Optimized',
			dataIndex : 'encBytesOptimized',
			sortable:true,
			width    :150
		}];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
			 	   {name:'id', mapping:'id',type:'double'},
			 
		           {name:'betweenCentralityTime', mapping:'betweenCentralityTime',type:'double'},
		           {name:'eCentralityTime', mapping:'eCentralityTime',type:'double'},
		           {name:'optimizedTime', mapping:'optimizedTime',type:'double'},
		           {name:'closenessCentralityTime', mapping:'closenessCentralityTime',type:'double'},
		           
		           {name:'memoryConsumedClosenessCentrality', mapping:'memoryConsumedClosenessCentrality',type:'double'},
		           {name:'memoryConsumedECentrality', mapping:'memoryConsumedECentrality',type:'double'},
		           {name:'memoryConsumedBetweenCentrality', mapping:'memoryConsumedBetweenCentrality',type:'double'},
		           {name:'memoryConsumedOptimized', mapping:'memoryConsumedOptimized',type:'double'},
		           
		           {name:'encBytesClosenessCentrality', mapping:'encBytesClosenessCentrality',type:'double'},
		           {name:'encBytesBetweenCentrality', mapping:'encBytesBetweenCentrality',type:'double'},
		           {name:'encBytesECentrality', mapping:'encBytesECentrality',type:'double'},
		           {name:'encBytesOptimized', mapping:'encBytesOptimized',type:'double'}
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
			url :contextPath+'/retriveSecurityCompare',
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
	title:'Security Comparison',
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
        displayMsg: 'Displaying Security Comparision {0} - {1} of {2}',
        emptyMsg: "No Security Comparision to display",
        inputItemWidth: 35
 })
});

	
	

});    
           