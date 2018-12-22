
var timer=[];
 function chartsYL(charsP){
	clearInterval(timer[charsP.index]);
	 var thiz = $('#'+charsP.id);
	 thiz.empty();
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
	                	var index1=0;
	                    var index2=0;
	                 
	                    	timer[charsP.index] =  setInterval(function(){   
	                    		 var da1,da2;  
	                    		 if(charsP.index == 0){
	                    			 da1 = y11[index1];
	                    			 da2 = y12[index2]; 
	                    		 }else{
	                    			 da1 = y21[index1];
	                    			 da2 = y22[index2];
	                    		 }
		 	                      
		 	                      if(da1){
			 	                	 series1.addPoint(da1);
			 	                	 index1++;
		 	                       }
		 	                     if(da2){
			 	                	  series2.addPoint(da2);
			 	                	 index2++;
		 	                       }
		 	                    },charsP.p); 
	                  
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
	        },{
	            name: charsP.name[1],
	            color:'blue',
	            data:[]
	        }],
	    });
}
 
 function chartsWY(charsP){
	 clearInterval(timer[charsP.index]);
	 var thiz = $('#'+charsP.id);
	thiz.empty();
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
	                	var series2 = this.series[1];
	                    var index1=0;
	                    var index2=0;
	                   timer[charsP.index] =  setInterval(function(){ 
	                    		var da1,da2;  
	                    		 if(charsP.index == 2){
	                    			 da1 = w11[index1];
	                    			 da2 = w12[index2]; 
	                    		 }else{
	                    			 da1 = w21[index1];
	                    			 da2 = w22[index2];
	                    		 }
		 	                      if(da1){
		 	                    	  series1.addPoint(da1);
			 	                	 index1++;
		 	                       }
		 	                      if(da2){
		 	                    	 series2.addPoint(da2);
		 	                    	 index2++;
		 	                      }
		 	                    },charsP.p); 
	                                                                   
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
	        },{
	        	color:'blue',
	            name: charsP.name[1],
	            data:[]
	        }],
	    });
}