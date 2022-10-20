Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');
Ext.require([ 'Ext.grid.*', 'Ext.data.*', 'Ext.form.*',
		'Ext.layout.container.Column', 'Ext.tab.Panel' ]);
Ext.Loader.setConfig({
	enabled : true
});

var energyColumns1 = [ {
	header : 'Iteration Number',
	dataIndex : 'id',
	sortable : false,
	width : 265
}, {
	header : 'File Size Closeness Centrality',
	dataIndex : 'fileSizeBytesClosenessCentrality',
	sortable : true,
	width : 258
}, {
	header : 'File Size Between Centrality',
	dataIndex : 'fileSizeBytesBetweenCentrality',
	sortable : true,
	width : 258
}, {
	header : 'File Size E Centrality',
	dataIndex : 'fileSizeBytesECentrality',
	sortable : true,
	width : 258
}, {
	header : 'File Size Optimized Centrality',
	dataIndex : 'fileSizeBytesOptimizedCentrality',
	sortable : true,
	width : 258
}, {
	header : 'Upload Time Closeness Centrality',
	dataIndex : 'uploadTimeClosenessCentrality',
	sortable : true,
	width : 258
}, {
	header : 'Upload Time Between Centrality',
	dataIndex : 'uploadTimeBetweenCentrality',
	sortable : true,
	width : 258
}, {
	header : 'Upload Time E Centrality',
	dataIndex : 'uploadTimeECentrality',
	sortable : true,
	width : 258
}, {
	header : 'Upload Time Optimized Centrality',
	dataIndex : 'uploadTimeOptimizedCentrality',
	sortable : true,
	width : 258
}, {
	header : 'Memory Closeness Centrality',
	dataIndex : 'memoryClosenessCentrality',
	sortable : true,
	width : 258
}, {
	header : 'Memory Between Centrality',
	dataIndex : 'memoryBetweenCentrality',
	sortable : true,
	width : 258
}, {
	header : 'Memory E Centrality',
	dataIndex : 'memoryBetweenECentrality',
	sortable : true,
	width : 258
}, {
	header : 'Memory Optimized Centrality',
	dataIndex : 'memoryOptimizedCentrality',
	sortable : true,
	width : 258
} ];

Ext.onReady(function() {

	Ext.define('energyCompareModel', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'iterationNo',
			mapping : 'id',
			type : 'int'
		}, {
			name : 'fileSizeBytesClosenessCentrality',
			mapping : 'fileSizeBytesClosenessCentrality',
			type : 'double'
		}, {
			name : 'fileSizeBytesClosenessCentrality',
			mapping : 'fileSizeBytesClosenessCentrality',
			type : 'double'
		}, {
			name : 'fileSizeBytesBetweenCentrality',
			mapping : 'fileSizeBytesBetweenCentrality',
			type : 'double'
		}, {
			name : 'fileSizeBytesECentrality',
			mapping : 'fileSizeBytesECentrality',
			type : 'double'
		}, {
			name : 'fileSizeBytesOptimizedCentrality',
			mapping : 'fileSizeBytesOptimizedCentrality',
			type : 'double'
		}, {
			name : 'uploadTimeClosenessCentrality',
			mapping : 'uploadTimeClosenessCentrality',
			type : 'double'
		}, {
			name : 'uploadTimeBetweenCentrality',
			mapping : 'uploadTimeBetweenCentrality',
			type : 'double'
		}, {
			name : 'uploadTimeECentrality',
			mapping : 'uploadTimeECentrality',
			type : 'double'
		}, {
			name : 'uploadTimeOptimizedCentrality',
			mapping : 'uploadTimeOptimizedCentrality',
			type : 'double'
		}, {
			name : 'memoryClosenessCentrality',
			mapping : 'memoryClosenessCentrality',
			type : 'double'
		}, {
			name : 'memoryBetweenCentrality',
			mapping : 'memoryBetweenCentrality',
			type : 'double'
		}, {
			name : 'memoryBetweenECentrality',
			mapping : 'memoryBetweenECentrality',
			type : 'double'
		}, {
			name : 'memoryOptimizedCentrality',
			mapping : 'memoryOptimizedCentrality',
			type : 'double'
		},{
			name:'originalFileBytes',
			mapping:'originalFileBytes',
			type:'double'
		}

		],
		idProperty : 'iterationNo'
	});

	var energyCompareStoreAlgo1Store = Ext.create('Ext.data.Store', {
		id : 'energyCompareStoreId1',
		name : 'energyCompareStoreName1',
		model : 'energyCompareModel',
		proxy : {
			type : 'ajax',
			url : contextPath + '/fileSizeDataGraph.do',
			actionMethods : {
				read : 'POST'
			},
			reader : {
				type : 'json',
				root : 'model',
				totalProperty : 'totalSize'
			}
		},
		listeners : {
			'load' : function(store, records) {
			}
		},
		autoLoad : true
	});
	energyCompareStoreAlgo1Store.load();

	Ext.create('Ext.chart.Chart', {
		renderTo : 'keyContainer1',
		width : 400,
		height : 300,
		store : energyCompareStoreAlgo1Store,
		legend : {
			position : 'right'
		},
		axes : [
				{
					title : 'Security Bytes',
					type : 'Numeric',
					position : 'left',
					fields : [ 'fileSizeBytesClosenessCentrality',
							'fileSizeBytesBetweenCentrality',
							'fileSizeBytesECentrality',
							'fileSizeBytesOptimizedCentrality' ]

				}, {
					title : 'File Size',
					type : 'Numeric',
					position : 'bottom',
					fields : [ 'originalFileBytes' ]
				} ],
		series : [ {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'fileSizeBytesClosenessCentrality',
			title : 'Closeness Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'fileSizeBytesBetweenCentrality',
			title : 'Between Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'fileSizeBytesECentrality',
			title : 'E Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'fileSizeBytesOptimizedCentrality',
			title : 'Optimized Centrality'
		}

		]
	});

	Ext.create('Ext.chart.Chart', {
		renderTo : 'allContainer',
		width : 400,
		height : 300,
		store : energyCompareStoreAlgo1Store,
		legend : {
			position : 'right'
		},
		axes : [
				{
					title : 'Upload Time',
					type : 'Numeric',
					position : 'left',
					fields : [ 'uploadTimeClosenessCentrality',
							'uploadTimeBetweenCentrality',
							'uploadTimeECentrality',
							'uploadTimeOptimizedCentrality' ]

				}, {
					title : 'File Size',
					type : 'Numeric',
					position : 'bottom',
					fields : [ 'originalFileBytes' ]
				} ],
		series : [ {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'uploadTimeClosenessCentrality',
			title : 'Closeness Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'uploadTimeBetweenCentrality',
			title : 'Between Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'uploadTimeECentrality',
			title : 'E Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'uploadTimeOptimizedCentrality',
			title : 'Optimized Centrality'
		}

		]
	});

	Ext.create('Ext.chart.Chart', {
		renderTo : 'allContainer1',
		width : 400,
		height : 300,
		store : energyCompareStoreAlgo1Store,
		legend : {
			position : 'right'
		},
		axes : [
				{
					title : 'Memory Consumed (Mb)',
					type : 'Numeric',
					position : 'left',
					fields : [ 'memoryClosenessCentrality',
							'memoryBetweenCentrality',
							'memoryBetweenECentrality',
							'memoryOptimizedCentrality' ]

				}, {
					title : 'File Size',
					type : 'Numeric',
					position : 'bottom',
					fields : [ 'originalFileBytes' ]
				} ],
		series : [ {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'memoryClosenessCentrality',
			title : 'Closeness Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'memoryBetweenCentrality',
			title : 'Between Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'memoryBetweenECentrality',
			title : 'E Centrality'
		}, {
			type : 'line',
			xField : 'originalFileBytes',
			yField : 'memoryOptimizedCentrality',
			title : 'Optimized Centrality'
		}

		]
	});
	
	/*var chart = Ext.create('Ext.chart.Chart', {
		
		renderTo:'allContainer2',
        animate: true,
        shadow: true,
        store: energyCompareStoreAlgo1Store,
        legend: {
            position: 'right'
        },
        axes: [{
            type: 'Numeric',
            position: 'bottom',
            fields: ['memoryClosenessCentrality', 'memoryBetweenCentrality', 'memoryBetweenECentrality', 'memoryOptimizedCentrality'],
            title: false,
            grid: true
        }, {
            type: 'Category',
            position: 'left',
            fields: ['originalFileBytes'],
            title: false
        }],
        series: [{
            type: 'bar',
            axis: 'bottom',
            gutter: 80,
            xField: 'originalFileBytes',
            yField: ['memoryClosenessCentrality', 'memoryBetweenCentrality', 'memoryBetweenECentrality', 'memoryOptimizedCentrality'],
            stacked: true
        }]
    });*/

});
