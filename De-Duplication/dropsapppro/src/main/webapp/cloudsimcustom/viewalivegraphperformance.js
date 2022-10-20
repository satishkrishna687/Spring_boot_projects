Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
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
			header : 'Optimized Algorithm',
			dataIndex : 'optimizedAliveNodes',
			sortable:true,
			width    :258
		},
		 {
			header : 'E Centrality Algorithm',
			dataIndex : 'eCentralityAliveNodes',
			sortable:true,
			width    :258
		},
		 {
			header : 'Closeness Algorithm',
			dataIndex : 'closenessAliveNodes',
			sortable:true,
			width    :258
		},
		 {
			header : 'Between Algorithm',
			dataIndex : 'betweenAliveNodes',
			sortable:true,
			width    :258
		}
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'iterationNo', mapping:'noOfIterations',type:'int'},
		           {name:'optimizedAliveNodes', mapping:'aliveNodes1',type:'double'},
		           {name:'eCentralityAliveNodes', mapping:'aliveNodes2',type:'double'},
		           {name:'closenessAliveNodes', mapping:'aliveNodes3',type:'double'},
		           {name:'betweenAliveNodes', mapping:'aliveNodes4',type:'double'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/compareNoOfAliveNodes.do',
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
	              title: 'Number of Alive Nodes',
	              type: 'Numeric',
	              position: 'left',
	              fields: ['optimizedAliveNodes','eCentralityAliveNodes','closenessAliveNodes','betweenAliveNodes']
	            
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
	                   yField: 'optimizedAliveNodes',
	                   title:'Optimized Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'eCentralityAliveNodes',
	                   title:'E Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'closenessAliveNodes',
	                   title:'Closeness Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'betweenAliveNodes',
	                   title:'Between Centrality'
	               }
	           ]
	});

	
	

});    
           