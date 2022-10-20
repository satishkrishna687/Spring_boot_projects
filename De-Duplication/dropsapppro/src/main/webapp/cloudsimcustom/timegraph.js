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
		           {name:'eedrTime', mapping:'timeAlgo1',type:'double'},
		           {name:'aodvTime', mapping:'timeAlgo2',type:'double'},
		           {name:'dsdvTime', mapping:'timeAlgo3',type:'double'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/comparetime.do',
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
		              title: 'Time Taken (ms)',
		              type: 'Numeric',
		              position: 'left',
		              fields: ['eedrTime','aodvTime','dsdvTime']
		           
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
		                   yField: 'eedrTime',
		                   title:'EEDR Time'
		               },
		               {
		                   type: 'line',
		                   xField: 'iterationNo',
		                   yField: 'aodvTime',
		                   title:'AODV Time'
		               },
		               {
		                   type: 'line',
		                   xField: 'iterationNo',
		                   yField: 'dsdvTime',
		                   title:'DSDV Time'
		               }
		           ]
			});
	
	

});    
           