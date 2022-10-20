Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});

var topologyColumns=[
         			{
         				header : 'Node Id',
         				dataIndex : 'nodeId',
         				editable:false,
         				sortable:false,
         				width:265
         			},
         			 {
         				header : 'X Cordinate',
         				dataIndex : 'xCordinate',
         				sortable:true,
         				width    :258
         			},

         			 {
         				header : 'Y Cordinate',
         				dataIndex : 'yCordinate',
         				sortable:true,
         				width    :258
         			},
   
         			{
         				header : 'Optimized Algo Energy',
         				dataIndex : 'energy',
         				sortable:true,
         				width    :450
         			},
         			{
         				header : 'E Centrality Algo Energy',
         				dataIndex : 'buffer',
         				sortable:true,
         				width    :450
         			},
         			{
         				header : 'Between Centrality Algo Energy',
         				dataIndex : 'networkCost',
         				sortable:true,
         				width    :450
         			},
         			{
         				header : 'Closeness Centrality Algo Energy',
         				dataIndex : 'power',
         				sortable:true,
         				width    :450
         			}
         			
         		];

var hideConfirmationMsg;
var showConfirmationMsg;
/* Hide the Confirmation Message */
	hideConfirmationMsg = function() {
		var confMsgDiv = Ext.get('confirmationMessage');
		confMsgDiv.dom.innerHTML = "";
		confMsgDiv.dom.style.display = 'none';
	}
	/* Show Confirmation Message */
	showConfirmationMsg = function(msg) {
		var confMsgDiv = Ext.get('confirmationMessage');
		confMsgDiv.dom.innerHTML =  msg;
		confMsgDiv.dom.style.display = 'inline-block';		
	}
	
Ext.onReady(function () {
    
		
	
	Ext.define('topologyViewModel', {
				extend : 'Ext.data.Model',
				fields : [ 
				           {name:'nodeId', mapping:'nodeId',type:'int'},
						   {name:'xCordinate', mapping:'xCordinate',type:'int'},
				           {name :'yCordinate',mapping : 'yCordinate',type : 'int'}, 
				           {name :'energy',mapping : 'energy',type : 'int'},
				           {name :'power',mapping : 'powerConsumed',type : 'int'},
				           {name :'buffer',mapping : 'buffer',type : 'int'},
						   {name:'networkCost',mapping:'networkCost',type:'int'}
						 ],
				idProperty: 'nodeId'
			});
	
	var topologyViewStore = Ext.create('Ext.data.Store', {
				id : 'topologyViewStoreId',
				name : 'topologyViewStoreName',
				model : 'topologyViewModel',
				proxy : {
					type : 'ajax',
					url :contextPath+'/edftopologyview.do',
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
	topologyViewStore.load();
	
	var topologyGridPanel = Ext.create('Ext.grid.Panel', {
		collapsible :true,
		title:'Topology',
		forceFit : true,
		id : 'topologyGrid',
		store : topologyViewStore,
		columns : topologyColumns,
		height : 500,
		width : 1300,
		autoFit : true,
		stripRows:true,
		renderTo : 'formatsGridContainer'
	});

});
	
	
	
