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
		           {name:'routingOverheadEEDR', mapping:'routingOverhead1',type:'double'},
		           {name:'routingOverheadAODV', mapping:'routingOverhead2',type:'double'},
		           {name:'routingOverheadDSDV', mapping:'routingOverhead3',type:'double'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/compareRoutingOverhead.do',
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
		              title: 'Routing Overhead',
		              type: 'Numeric',
		              position: 'left',
		              fields: ['routingOverheadEEDR','routingOverheadAODV','routingOverheadDSDV']
		           
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
 					yField: 'routingOverheadEEDR',
 				       title:'Routing Overhead EEDR'
		               	},
		               {
		                   type: 'line',
		                   xField: 'iterationNo',
		                   yField: 'routingOverheadAODV',
		                   title:'Routing Overhead AODV'
		               },
		               {
		                   type: 'line',
		                   xField: 'iterationNo',
		                   yField: 'routingOverheadDSDV',
		                   title:'Routing Overhead DSDV'
		               }
		               
		           ]
		});
	

});    
           