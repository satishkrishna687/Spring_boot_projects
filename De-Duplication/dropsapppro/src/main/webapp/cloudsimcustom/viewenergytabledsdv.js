Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
Ext.Loader.setConfig({
    enabled: true
});

var routingColumns=[
         			{
         				header : 'Energy',
         				dataIndex : 'power',
         				sortable:true,
         				width    :258
         			}];

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
	var routingViewStore;
Ext.onReady(function () {
	
	
	Ext.define('nodeIdModel', {
		extend : 'Ext.data.Model',
		fields : [ 
		           {name:'nodeId', mapping:'nodeId',type:'int'}
				 ],
		idProperty: 'nodeId'
	});
	
	var nodeIdStore = Ext.create('Ext.data.Store', {
		id : 'nodeIdStoreId',
		name : 'nodeIdStoreName',
		model : 'nodeIdModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/viewNodeIds.do',
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
	nodeIdStore.load();
	
		
	var nodeIdPanel = Ext.create('Ext.form.Panel', {
		title:'Select a Node whose Energy Has to be Viewed',
		id : 'criteriaContainer',
		width:400,
		height:100,
		defaults: {
		labelAlign:'top', 
		cellCls:'paddingLeft',
		width:50,
		height:50
		},
		name : 'wireCriteriaN',
		layout: {
		        type: 'table',
		        // The total column count must be specified here
		        columns: 3,
				tableAttrs:{
				style:{width:'100%'}
				}
		    },
		items : [ {
				xtype : 'combo',
				fieldLabel : 'Node Id',
				id : 'nodeId',
				name : 'nodeId',
				queryMode:'local',
				editable : false,
				displayField : 'nodeId',
				valueField : 'nodeId',
				value:1,
				triggerAction : 'all',
				store : nodeIdStore,
				listeners:{
					'select':function(combo,records)
					{
							var nodeIdSelected=Ext.getCmp('nodeId').getValue();
							sendRoutingTable(nodeIdSelected);		
					}
				}
				}],
				renderTo:'criteriaContainer',
				collapsible:true
	});
	
		
	Ext.define('routingViewModel', {
				extend : 'Ext.data.Model',
				fields : [ 
				             {name:'power', mapping:'power',type:'string'}
				        ],
				idProperty: 'power'
			});
	
	routingViewStore = Ext.create('Ext.data.Store', {
		id : 'routingViewStoreId',
		name : 'routingViewStoreName',
		model : 'routingViewModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/viewEnergyTableForDSDV.do',
			extraParams:{
		 	nodeId:1
			},
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
	
	function sendRoutingTable(nodeIdSelected)
	{
		var store=Ext.getCmp('routingTableGrid').getStore();
		store.load(
			{
				url :contextPath+'/eedr/viewEnergyTableForDSDV.do',
				params:{
						nodeId:nodeIdSelected
						}
			}
		);
			
	}
	
	
	
	var routingTableGrid = Ext.create('Ext.grid.Panel', {
		collapsible :true,
		forceFit:true,
		title:'Energy of the Selected Node in mJ',
		id : 'routingTableGrid',
		store : routingViewStore,
		columns : routingColumns,
		height :75,
		width :400,
		stripRows:true,
		renderTo : 'routingGridContainer'
	});

});
	
	
	
