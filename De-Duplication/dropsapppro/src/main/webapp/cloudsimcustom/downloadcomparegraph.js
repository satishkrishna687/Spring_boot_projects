Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require([ 'Ext.grid.*', 'Ext.data.*', 'Ext.form.*',
		'Ext.layout.container.Column', 'Ext.tab.Panel' ]);
Ext.Loader.setConfig({
	enabled : true
});



Ext.onReady(function() {

	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'iterationno', mapping:'iterationno',type:'int'},
		           {name:'timeTaken', mapping:'timeTaken',type:'double'},
		           {name:'orginalFileBytes', mapping:'orginalFileBytes',type:'double'},
		           {name:'algorithmicName', mapping:'algorithmicName',type:'double'}
		           
				  ],
		idProperty: 'iterationNo'
	});
	
	var downloadTimeForOptimizedStore = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/downloadTimeForOptimized.do',
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
    downloadTimeForOptimizedStore.load();

	

	Ext.create('Ext.chart.Chart', {
		renderTo : 'keyContainer1',
		width : 400,
		height : 300,
		store : downloadTimeForOptimizedStore,
		legend : {
			position : 'right'
		},
		axes : [
				{
					title : 'Download Time(s)',
					type : 'Numeric',
					position : 'left',
					fields : [ 'timeTaken']

				}, {
					title : 'File Size',
					type : 'Numeric',
					position : 'bottom',
					fields : [ 'orginalFileBytes' ]
				} ],
		series : [ {
			type : 'line',
			xField : 'orginalFileBytes',
			yField : 'timeTaken',
			title : 'Optimized Algorithm'
		}
		]
	});
	
	

	var downloadTimeForClosenessCentralityStore = Ext.create('Ext.data.Store', {
		id : 'downloadTimeForClosenessCentralityStore',
		name : 'downloadTimeForClosenessCentralityStore',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/downloadTimeForClosenessCentrality.do',
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
	downloadTimeForClosenessCentralityStore.load();
	
	
	Ext.create('Ext.chart.Chart', {
		renderTo : 'keyContainer2',
		width : 400,
		height : 300,
		store : downloadTimeForClosenessCentralityStore,
		legend : {
			position : 'right'
		},
		axes : [
				{
					title : 'Download Time(s)',
					type : 'Numeric',
					position : 'left',
					fields : [ 'timeTaken']

				}, {
					title : 'File Size',
					type : 'Numeric',
					position : 'bottom',
					fields : [ 'orginalFileBytes' ]
				} ],
		series : [ {
			type : 'line',
			xField : 'orginalFileBytes',
			yField : 'timeTaken',
			title : 'Closeness Centrality Algorithm'
		}
		]
	});
	
	
	var downloadTimeForBetweenCentralityStore = Ext.create('Ext.data.Store', {
		id : 'downloadTimeForBetweenCentralityStore',
		name : 'downloadTimeForBetweenCentralityStore',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/downloadTimeForBetweenCentrality.do',
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
	downloadTimeForBetweenCentralityStore.load();
	
	
	Ext.create('Ext.chart.Chart', {
		renderTo : 'keyContainer3',
		width : 400,
		height : 300,
		store : downloadTimeForBetweenCentralityStore,
		legend : {
			position : 'right'
		},
		axes : [
				{
					title : 'Download Time(s)',
					type : 'Numeric',
					position : 'left',
					fields : [ 'timeTaken']

				}, {
					title : 'File Size (kB)',
					type : 'Numeric',
					position : 'bottom',
					fields : [ 'orginalFileBytes' ]
				} ],
		series : [ {
			type : 'line',
			xField : 'orginalFileBytes',
			yField : 'timeTaken',
			title : 'Between Centrality Algorithm'
		}
		]
	});
	
	
	var downloadTimeForECentralityStore = Ext.create('Ext.data.Store', {
		id : 'downloadTimeForECentralityStore',
		name : 'downloadTimeForECentralityStore',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/downloadTimeForECentrality.do',
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
	downloadTimeForECentralityStore.load();
	
	
	Ext.create('Ext.chart.Chart', {
		renderTo : 'keyContainer4',
		width : 400,
		height : 300,
		store : downloadTimeForECentralityStore,
		legend : {
			position : 'right'
		},
		axes : [
				{
					title : 'Download Time(s)',
					type : 'Numeric',
					position : 'left',
					fields : [ 'timeTaken']

				}, {
					title : 'File Size (kB)',
					type : 'Numeric',
					position : 'bottom',
					fields : [ 'orginalFileBytes' ]
				} ],
		series : [ {
			type : 'line',
			xField : 'orginalFileBytes',
			yField : 'timeTaken',
			title : 'E Centrality Algorithm'
		}
		]
	});


	

});
