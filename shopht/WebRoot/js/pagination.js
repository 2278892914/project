function Pagination(){
	this.s = {
		'totalPage' : 10,
		'min' : 1,
		'max' : 5
	};
}
/**/
Pagination.prototype.pagin = function(){
	var thiz = this;
	var d_page = document.getElementById('page');
	liClick(1);
	function liClick(page){
		if(page >= (thiz.s.max+thiz.s.min)/2+1){
			thiz.s.max +=1;
			if(thiz.s.max > thiz.s.totalPage){
				thiz.s.max = thiz.s.totalPage;
			}
			thiz.s.min = thiz.s.max - 4;
		}else if(page <= (thiz.s.max+thiz.s.min)/2-1){
			thiz.s.min -=1;
			if(thiz.s.min < 1){
				thiz.s.min = 1;
			}
			thiz.s.max = thiz.s.min + 4;
		}
		d_page.innerHTML="";
		var html ="<ul><li><a><span class='arrow_left'></span></a></li>";
		for(var i=thiz.s.min;i<=thiz.s.max;i++){
			html +="<li	page='"+i+"'>"
			+"<a>"+i+"</a>"
			+"</li>";
		}
		html +="<li><a><span class='arrow_right'></span></a>"
				+"</li></ul>";
		d_page.innerHTML = html;
		var liList = d_page.getElementsByTagName("li");
		for(var i = 0;i < liList.length;i++){
			liList[i].onclick = function(){
				var page = this.getAttribute('page');
				
				$.ajax({
					url : "user.action",
					type : "post",
					dataType:'json',
					success : function(data){
						console.log(data);
					}
					
				});
				
				
				
				liClick(page);
			}
		}
	}
	
	
	
	
	
	
}

var pa = new Pagination();
