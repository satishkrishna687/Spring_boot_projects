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
			dataIndex : 'optimizedEnergy',
			sortable:true,
			width    :258
		},
		 {
			header : 'E Centrality Algorithm',
			dataIndex : 'eCentralityEnergy',
			sortable:true,
			width    :258
		},
		 {
			header : 'Closeness Algorithm',
			dataIndex : 'closenessEnergy',
			sortable:true,
			width    :258
		},
		 {
			header : 'Between Algorithm',
			dataIndex : 'betweenEnergy',
			sortable:true,
			width    :258
		}
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'iterationNo', mapping:'iterationNo',type:'int'},
		           {name:'optimizedEnergy', mapping:'energyAlgo1',type:'double'},
		           {name:'eCentralityEnergy', mapping:'energyAlgo2',type:'double'},
		           {name:'closenessEnergy', mapping:'energyAlgo3',type:'double'},
		           {name:'betweenEnergy', mapping:'energyAlgo4',type:'double'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/compareenergy.do',
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
	              title: 'Energy Consumed(mJ)',
	              type: 'Numeric',
	              position: 'left',
	              fields: ['optimizedEnergy','eCentralityEnergy','closenessEnergy','betweenEnergy']
	            
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
	                   yField: 'optimizedEnergy',
	                   title:'Optimized Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'eCentralityEnergy',
	                   title:'E Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'closenessEnergy',
	                   title:'Closeness Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'betweenEnergy',
	                   title:'Between Centrality'
	               }
	           ]
	});
	
	

});    
           