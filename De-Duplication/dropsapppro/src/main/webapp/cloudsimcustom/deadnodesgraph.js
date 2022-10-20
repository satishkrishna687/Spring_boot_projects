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
		           {name:'noOfIterations', mapping:'noOfIterations',type:'int'},
		           {name:'deadNodesEEDR', mapping:'deadNodes1',type:'int'},
		           {name:'deadNodesAODV', mapping:'deadNodes2',type:'int'},
		           {name:'deadNodesDSDV', mapping:'deadNodes3',type:'int'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/compareNoOfDeadNodes.do',
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
		              title: 'No of Dead Nodes',
		              type: 'Numeric',
		              position: 'left',
		              fields: ['deadNodesEEDR','deadNodesAODV','deadNodesDSDV']
		           
		          },
		          {
		              title: 'Iteration No',
		              type: 'Numeric',
		              position: 'bottom',
		              fields: ['noOfIterations']
		          }
		      ],
		      series: [
		               	{
    					type: 'line',
    					xField: 'noOfIterations',
    					yField: 'deadNodesEEDR',
    					title:'No of Dead Nodes EEDR'
		               	},
		               {
		                   type: 'line',
		                   xField: 'noOfIterations',
		                   yField: 'deadNodesAODV',
	    					title:'No of Dead Nodes AODV'
	    			              
		               },
		               {
		                   type: 'line',
		                   xField: 'noOfIterations',
		                   yField: 'deadNodesDSDV',
		                   title:'No of Dead Nodes DSDV'
			              
		               }
		               
		           ]
		});
	
	

});    
           