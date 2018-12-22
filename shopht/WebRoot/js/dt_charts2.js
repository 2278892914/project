
var timerT1=[];
 function chartsYL2(charsP){
	 clearInterval(timerT1[charsP.index]);
	 var thiz = $('#'+charsP.id);
	 thiz.parent().removeAttr('style');
	 thiz.highcharts({
	        title: {
	            text: charsP.title,
	            x: -20 
	        },
	        credits: {
	            enabled:false
	         },
	        chart : {
	        	type: 'spline',
	        	events: {                                                           
	                load: function(){                                              
	                	var series1 = this.series[0];
	                	var series2 = this.series[1];
	                    var index2=0;
	                   if(charsP.status == 'YZL'){
	                    	series1.setData(charsP.data[0]);
	                    }else{
	                    	timerT1[charsP.index] =  setInterval(function(){   
	                    			var da1 = charsP.data[0][index2];
		 	                      if(da1 && da2){
		 	                    	  series1.addPoint(da1);
		 	                    	  index2++;
		 	                       }
		 	                    },50); 
	                    }
	                }                                                               
	            }
	        },plotOptions: {  
	            spline: {  
	                lineWidth: 3,  
	                fillOpacity: 0.2,  
	                 marker: {  
	                    enabled: false,  
	                    states: {  
	                        hover: {  
	                            enabled: true,  
	                            radius: 2  
	                        }  
	                    }  
	                },  
	                shadow: false  
	            }  
	        },
	        xAxis: {
	        	title: {
	                text: '时间(S)'
	            },
	        	max: 900,
	        	min : 0,
	        	tickInterval:100,
	        	lineColor: '#FF0000'
	        },
	        yAxis: {
	            title: {
	                text: "压力(MPa)"
	            },
	            lineColor: '#FF0000',
	            lineWidth: 1,
	            max: 50,
	        	min : 0,
	        	tickInterval:10
	        },
	       	tooltip:{
	            valueSuffix: 'MPa'
	        },
	        series: [{
	            name: charsP.name[0],
	            color : 'red',
	            data:[]
	        }],
	    });
}
 
 function chartsWY2(charsP){
	 clearInterval(timerT1[charsP.index]);
	 var thiz = $('#'+charsP.id);
	 thiz.parent().removeAttr('style');
	 thiz.highcharts({
	        title: {
	            text: charsP.title,
	            x: -20 //center
	        },
	        credits: {
	            enabled:false
	         },
	        chart : {
	        	type: 'spline',
	        	events: {                                                           
	                load: function() { 
	                	var series1 = this.series[0];
	                	var index2=0;
	                   if(charsP.status == 'YZL'){
	                    	series1.setData(charsP.data[2]);
		                }else{
	                    	timerT1[charsP.index] =  setInterval(function(){ 
	                    		  var da1 = charsP.data[2][index2];
		 	                      if(da1 && da2){
		 	                    	  series1.addPoint(da1);
			 	                	 index2++;
		 	                       }
		 	                    }, 50); 
	                    }                                                
	                }                                                               
	            }
	        },plotOptions: {  
	            spline: {  
	                lineWidth: 3,  
	                fillOpacity: 0.2,  
	                 marker: {  
	                    enabled: false,  
	                    states: {  
	                        hover: {  
	                            enabled: true,  
	                            radius: 2  
	                        }  
	                    }  
	                },  
	                shadow: false  
	            }  
	        },
	        xAxis: {
	        	title: {
	                text: '时间(S)'
	            },
	        	max: 900,
	        	min : 0,
	        	tickInterval:100,
	        	lineColor: '#FF0000'
	        },
	        yAxis: {
	            title: {
	                text: "位移(mm)"
	            },
	            lineColor: '#FF0000',
	            lineWidth: 1,
	            max: 260,
	        	min : 0,
	        	tickInterval:20
	        },
	       	tooltip: {
	            valueSuffix: 'mm'
	        },
	        series: [{
	        	color:'red',
	            name: charsP.name[0],
	            data:[]
	        }],
	    });
}