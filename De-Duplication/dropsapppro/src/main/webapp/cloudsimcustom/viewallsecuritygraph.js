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
			 	   {name:'iterationNo', mapping:'id',type:'int'},
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
		proxy : {
			type : 'ajax',
			url :contextPath+'/retriveSecurityCompareAll',
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
	
Ext.create('Ext.chart.Chart', {
	   renderTo: 'keyContainer',
	   width: 400,
	   height: 300,
	   store: energyCompareStoreAlgo1Store,
	   legend: {
		    position: 'right'
		},
	   axes: [
	          {
	              title: 'Time(ms)',
	              type: 'Numeric',
	              position: 'left',
	              fields: ['optimizedTime','eCentralityTime','closenessCentralityTime','betweenCentralityTime']
	            
	          },
	          {
	              title: 'Iteration No',
	              type: 'Numeric',
	              position: 'bottom',
	              fields: ['iterationNo']
	          }
	      ],
	      series: [
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'optimizedTime',
	                   title:'Optimized Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'eCentralityTime',
	                   title:'E Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'closenessCentralityTime',
	                   title:'Closeness Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'betweenCentralityTime',
	                   title:'Between Centrality'
	               }
	           ]
	});



});    
           