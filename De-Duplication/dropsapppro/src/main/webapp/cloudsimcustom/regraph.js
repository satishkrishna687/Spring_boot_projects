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
		           {name:'noOfIterations', mapping:'iterationNo',type:'int'},
		           {name:'residualEnergyEEDR', mapping:'residualEnergy1',type:'int'},
		           {name:'residualEnergyAODV', mapping:'residualEnergy2',type:'int'},
		           {name:'residualEnergyDSDV', mapping:'residualEnergy3',type:'int'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/compareResidualEnergy.do',
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
		              title: 'Residual Energy (mJ)',
		              type: 'Numeric',
		              position: 'left',
		              fields: ['residualEnergyEEDR','residualEnergyAODV','residualEnergyDSDV']
		           
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
    					yField: 'residualEnergyEEDR',
    					title:'Residual Energy EEDR'
		               	},
		               {
		                   type: 'line',
		                   xField: 'noOfIterations',
		                   yField: 'residualEnergyAODV',
		                   title:'Residual Energy AODV'
		               },
		               {
		                   type: 'line',
		                   xField: 'noOfIterations',
		                   yField: 'residualEnergyDSDV',
		                   title:'Residual Energy DSDV'
		               }
		               
		           ]
		});
	
	

});    
           