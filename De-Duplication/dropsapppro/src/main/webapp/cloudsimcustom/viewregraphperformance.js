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
			dataIndex : 'optimizedResidualEnergy',
			sortable:true,
			width    :258
		},
		 {
			header : 'E Centrality Algorithm',
			dataIndex : 'eCentralityResidualEnergy',
			sortable:true,
			width    :258
		},
		 {
			header : 'Closeness Algorithm',
			dataIndex : 'closenessResidualEnergy',
			sortable:true,
			width    :258
		},
		 {
			header : 'Between Algorithm',
			dataIndex : 'betweenResidualEnergy',
			sortable:true,
			width    :258
		}
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'iterationNo', mapping:'iterationNo',type:'int'},
		           {name:'optimizedResidualEnergy', mapping:'residualEnergy1',type:'double'},
		           {name:'eCentralityResidualEnergy', mapping:'residualEnergy2',type:'double'},
		           {name:'closenessResidualEnergy', mapping:'residualEnergy3',type:'double'},
		           {name:'betweenResidualEnergy', mapping:'residualEnergy4',type:'double'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/compareResidualEnergy.do',
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
	              title: 'Residual Energy(mJ)',
	              type: 'Numeric',
	              position: 'left',
	              fields: ['optimizedResidualEnergy','eCentralityResidualEnergy','closenessResidualEnergy','betweenResidualEnergy']
	            
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
	                   yField: 'optimizedResidualEnergy',
	                   title:'Optimized Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'eCentralityResidualEnergy',
	                   title:'E Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'closenessResidualEnergy',
	                   title:'Closeness Centrality'
	               },
	               {
	                   type: 'line',
	                   xField: 'iterationNo',
	                   yField: 'betweenResidualEnergy',
	                   title:'Between Centrality'
	               }
	           ]
	});

	
	

});    
           