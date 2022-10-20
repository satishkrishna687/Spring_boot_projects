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
			dataIndex : 'optimizedLifetimeRatio',
			sortable:true,
			width    :258
		},
		 {
			header : 'E Centrality Algorithm',
			dataIndex : 'eCentralityLifetimeRatio',
			sortable:true,
			width    :258
		},
		 {
			header : 'Closeness Algorithm',
			dataIndex : 'closenessLifetimeRatio',
			sortable:true,
			width    :258
		},
		 {
			header : 'Between Algorithm',
			dataIndex : 'betweenLifetimeRatio',
			sortable:true,
			width    :258
		}
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'iterationNo', mapping:'iterationNo',type:'int'},
		           {name:'optimizedLifetimeRatio', mapping:'lifeTimeRatio1',type:'double'},
		           {name:'eCentralityLifetimeRatio', mapping:'lifeTimeRatio2',type:'double'},
		           {name:'closenessLifetimeRatio', mapping:'lifeTimeRatio3',type:'double'},
		           {name:'betweenLifetimeRatio', mapping:'lifeTimeRatio4',type:'double'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/compareLifeTimeRatio.do',
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
	

var energyGridPanelAlgo1 = Ext.create('Ext.grid.Panel', {
	collapsible:true,
	title:'Lifetime across Algorithms',
	forceFit : true,
	id : 'topologyGrid1',
	store : energyCompareStoreAlgo1Store,
	columns :energyColumns1,
	maxHeight : 500,
	width : 800,
	autoFit : true,
	stripRows:true,
	renderTo : 'keyContainer'
});

	
	

});    
           