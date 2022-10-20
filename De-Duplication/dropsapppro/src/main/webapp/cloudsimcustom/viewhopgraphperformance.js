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
			dataIndex : 'optimizedHops',
			sortable:true,
			width    :258
		},
		 {
			header : 'E Centrality Algorithm',
			dataIndex : 'eCentralityHops',
			sortable:true,
			width    :258
		},
		 {
			header : 'Closeness Algorithm',
			dataIndex : 'closenessHops',
			sortable:true,
			width    :258
		},
		 {
			header : 'Between Algorithm',
			dataIndex : 'betweenHop',
			sortable:true,
			width    :258
		}
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'iterationNo', mapping:'iterationNo',type:'int'},
		           {name:'optimizedHops', mapping:'hopsAlgo1',type:'double'},
		           {name:'eCentralityHops', mapping:'hopsAlgo2',type:'double'},
		           {name:'closenessHops', mapping:'hopsAlgo3',type:'double'},
		           {name:'betweenHop', mapping:'hopsAlgo4',type:'double'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/compareNoOfHops.do',
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
	              title: 'Number of Hops',
	              type: 'Numeric',
	              position: 'left',
	              fields: ['optimizedHops','eCentralityHops','closenessHops','betweenHop']
	            
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
	                   yField: 'optimizedHops',
	                   title:'Optimized Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'eCentralityHops',
	                   title:'E Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'closenessHops',
	                   title:'Closeness Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'betweenHop',
	                   title:'Between Centrality'
	               }
	           ]
	});
	

});    
           