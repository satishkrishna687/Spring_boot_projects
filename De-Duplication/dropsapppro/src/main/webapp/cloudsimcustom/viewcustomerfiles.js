Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});


var energyColumns1=[
		{
			header : 'File Storage Id',
			dataIndex : 'filestorageid',
			sortable:false,
			width:265
		},
		 {
			header : 'File Name',
			dataIndex : 'filename',
			sortable:true,
			width    :258
		},
		 {
			header : 'Original File Name',
			dataIndex : 'orginalname',
			sortable:true,
			width    :258
		},
		 {
			header : 'Session Id',
			dataIndex : 'sessionid',
			sortable:true,
			width    :258
		},
		 {
			header : 'Username',
			dataIndex : 'username',
			sortable:true,
			width    :258
		},{
			header : 'Download Orginal Article',
				dataIndex : 'filestorageid',
				sortable : false,
				width : 200,
				renderer : function(value, metadata, record, rowIndex, colIndex,
						store) {

					return "<a  " + "href=" + contextPath
							+ "/download.do?fileId=" + value
							+ ">View Details </a>";
				}
			}
 		];



Ext.onReady(function () {
	
	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'filestorageid', mapping:'filestorageid',type:'int'},
		           {name:'filename', mapping:'filename',type:'string'},
		           {name:'filetype', mapping:'filetype',type:'string'},
		           {name:'orginalname', mapping:'orginalname',type:'string'},
		           {name:'routeno', mapping:'userinforoutesession.routeno',type:'double'},
		           {name:'sessionid', mapping:'userinforoutesession.sessionid',type:'string'},
		           {name:'username', mapping:'userinforoutesession.username',type:'string'},
		           {name:'username', mapping:'userinforoutesession.username',type:'string'}
		           
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
			url :contextPath+'/retriveCustomerSpecificFiles',
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
	title:'Customer Files across Algorithms',
	forceFit : true,
	id : 'topologyGrid1',
	store : energyCompareStoreAlgo1Store,
	columns :energyColumns1,
	maxHeight : 500,
	width : 800,
	autoFit : true,
	stripRows:true,
	renderTo : 'keyContainer',
	overflowY:'auto',
	bbar: Ext.create('Ext.PagingToolbar', {
        store: energyCompareStoreAlgo1Store,
        displayInfo: true,
        displayMsg: 'Displaying Files {0} - {1} of {2}',
        emptyMsg: "No Customer Files to display",
        inputItemWidth: 35
 })
 
});

	
	

});    
           