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
		           {name:'eedrHops', mapping:'hopsAlgo1',type:'int'},
		           {name:'aodvHops', mapping:'hopsAlgo2',type:'int'},
		           {name:'dsdvHops', mapping:'hopsAlgo3',type:'int'}
				  ],
		idProperty: 'iterationNo'
	});
	
	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url :contextPath+'/eedr/compareNoOfHops.do',
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
    	    renderTo: Ext.getBody(),
    	    id: 'chart',
    	    width: 580,
    	    height: 165,
    	    animate: true,
    	    store: energyCompareStoreAlgo1Store,
			minimum:-1000,
			maximum:1000,
    	    axes: [{
    	        type: 'numeric',
    	        position: 'bottom',
    	        fields: ['eedrHops', 'aodvHops','dsdvHops'],
    	        grid: true,
    	        processView: function () {
    	            var me = this;

    	            if (me.constrain) {
    	                me.doConstrain();
    	            }
    	        }
    	    }, {
    	        type: 'Category',
    	        position: 'left',
    	        fields: ['iterationNo']
    	    }],
    	    series: [{
    	        type: 'bar',
    	        axis: 'bottom',
    	        stacked: true,
    	        xField: 'iterationNo',
    	        yField: ['eedrHops', 'aodvHops','dsdvHops']
    	    }]
    	});
	

});    
           