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
		           {name:'lifeTimeRatioEEDR', mapping:'lifeTimeRatio1',type:'int'},
		           {name:'lifeTimeRatioAODV', mapping:'lifeTimeRatio2',type:'int'},
		           {name:'lifeTimeRatioDSDV', mapping:'lifeTimeRatio3',type:'int'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/compareLifeTimeRatio.do',
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
		              title: 'Life Time Ratio',
		              type: 'Numeric',
		              position: 'left',
		              fields: ['lifeTimeRatioEEDR','lifeTimeRatioAODV','lifeTimeRatioDSDV']
		           
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
    					yField: 'lifeTimeRatioEEDR',
    					title:'Lifetime Ratio EEDR'
		              
		               	},
		               {
		                   type: 'line',
		                   xField: 'iterationNo',
		                   yField: 'lifeTimeRatioAODV',
		                   title:'Lifetime Ratio AODV'
		               },
		               {
		                   type: 'line',
		                   xField: 'iterationNo',
		                   yField: 'lifeTimeRatioDSDV',
		                   title:'Lifetime Ratio DSDV'
		               }
		               
		           ]
		});
	
	

});    
           