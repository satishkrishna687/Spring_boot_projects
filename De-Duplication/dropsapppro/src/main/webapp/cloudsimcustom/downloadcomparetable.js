Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});

var energyColumns1=[
		{
			header : 'Iteration Number',
			dataIndex : 'iterationno',
			sortable:false,
			width:265
		},
		 {
			header : 'File Size (Bytes)',
			dataIndex : 'orginalFileBytes',
			sortable:true,
			width    :258
		},
		 {
			header : 'Time Taken (s)',
			dataIndex : 'timeTaken',
			sortable:true,
			width    :258
		},
		 {
			header : 'Algorithm Name',
			dataIndex : 'algorithmicname',
			sortable:true,
			width    :258
		},
		
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'iterationno', mapping:'iterationno',type:'int'},
		           {name:'timeTaken', mapping:'timeTaken',type:'double'},
		           {name:'orginalFileBytes', mapping:'orginalFileBytes',type:'double'},
		           {name:'algorithmicname', mapping:'algorithmicname',type:'double'}
		           
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		autoLoad: {start: 0, limit: 15},
		proxy : {
			type : 'ajax',
			url :contextPath+'/downloadTimeTable.do',
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
	title:'Download Time Across Algorithms',
	forceFit : true,
	id : 'topologyGrid1',
	store : energyCompareStoreAlgo1Store,
	columns :energyColumns1,
	maxHeight : 500,
	width :1200,
	autoFit : true,
	stripRows:true,
	renderTo : 'keyContainer',
	bbar: Ext.create('Ext.PagingToolbar', {
        store: energyCompareStoreAlgo1Store,
        displayInfo: true,
        displayMsg: 'Displaying Download Time {0} - {1} of {2}',
        emptyMsg: "No Download Time to display",
        inputItemWidth: 35
 })
});

	
	

});    
           