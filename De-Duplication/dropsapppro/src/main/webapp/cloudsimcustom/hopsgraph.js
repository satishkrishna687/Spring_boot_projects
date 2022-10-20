Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'iterationNo', mapping:'iterationNo',type:'int'},
		           {name:'eedrHops', mapping:'hopsAlgo1',type:'int'},
		           {name:'aodvHops', mapping:'hopsAlgo2',type:'int'},
		           {name:'dsdvHops', mapping:'hopsAlgo3',type:'int'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/compareNoOfHops.do',
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
		   renderTo: 'content',
		   width: 400,
		   height: 300,
		   store: energyCompareStoreAlgo1Store,
		   legend: {
			    position: 'right'
			},
		   axes: [
		          {
		              title: 'No of Hops',
		              type: 'Numeric',
		              position: 'left',
		              fields: ['eedrHops','aodvHops','dsdvHops']
		           
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
		                   yField: 'eedrHops',
		                   title:'EEDR Hops'
		               },
		               {
		                   type: 'line',
		                   xField: 'iterationNo',
		                   yField: 'aodvHops',
		                   title:'AODV Hops'
		               },
		               {
		                   type: 'line',
		                   xField: 'iterationNo',
		                   yField: 'dsdvHops',
		                   title:'DSDV Hops'
		               }
		           ]
		});
	
	

});    
           