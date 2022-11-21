var currentCount = $("#currentCount").val();
var currentPage = $("#currentPage").val();
$(function(){
    
  getClinicSearchList(currentPage);
  
});


function getPageInfo(page){
  var search =  getParameterByName('searchValue'); 
  $.ajax({
    url : "clinicSearchPage.kh",
    type: "get",
    data:{"page":page,"searchValue":search},
    dataType : "json",
    success : function(data){      
      str = "";
      if(data.startPage == 1){

      }else{
        str+='<li><a style="color:#00bd56; cursor:pointer" onclick="getPrevMove('+data.pageLimit+')">&lt;</a></li>';
      }

      for(var i = data.startPage; i <= data.endPage; i++){        
        if(page == i){
          str +='<li class="active"><a style="cursor:pointer" onclick="getClinicSearchList('+i+')">'+i+'</a></li>';
        }else{
          str +='<li><a style="color:#00bd56; cursor:pointer" onclick="getClinicSearchList('+i+')">'+i+'</a></li>';
        }
      }

      if(data.endPage == data.maxPage){

      }else{
        str+='<li><a style="color:#00bd56; cursor:pointer" onclick="getNextMove('+data.endPage+')">&gt;</a></li>';       
      }
      
     
      $("#clinic-page").html(str);
    },
    error: function(){
      console.log("nopage");
    },
    complete : function(){
      currentPage = page;
    }

  });

}



function getPrevMove(pageLimit){ 
  getClinicSearchList(pageLimit*currentCount);
 currentCount --;
}
function getNextMove(endPage){  
  getClinicSearchList(endPage+1);
  currentCount ++;
}
function getParameterByName(name) {
  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
          results = regex.exec(location.search);
  return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function getClinicSearchList(page){
  var search =  getParameterByName('searchValue'); 
  $("#clinic-list").html("");
  $.ajax({
    url : "clinicSearchList.kh",
    type:"get",
    data : {"page":page,"searchValue":search},
    dataType : "json",
    success : function(data){
      currentPage = page;            
      if(data.length > 0){
        var str = "";
        str+='         <div class="list-wrap">';
		str+='			<table class="table table-hover">';
		str+='			  <thead>';
		str+='			    <tr>';
		str+='			      <th scope="col">순번</th>';
		str+='			      <th scope="col">이미지</th>';
		str+='			      <th scope="col">제목</th>';
		str+='			      <th scope="col">작성자</th>';
		str+='			      <th scope="col">작성일</th>';
		str+='			      <th scope="col">조회수</th>';
		str+='			      <th scope="col">좋아요</th>';
		str+='			    </tr>';
		str+='			  </thead>';
		str+='			  <tbody>';
        for(var i in data){
			str+='			    <tr onClick="goPage('+data[i].clinicNo+', '+currentPage+', '+currentCount+')">';
			str+='			      <td>'+data[i].clinicNo+'</td>';
								if(data[i].clinicFileRename == null){
			str+='					<td><img src="resources/uploadFiles/clinic/defaultplant.png"></td>';
									}else{
			str+='					<td><img src="resources/uploadFiles/clinic/'+data[i].clinicFileRename+'"></td>';
									}
			str+='			      <td><p><a class="noColor" href="clinicDetail.kh?clinicNo='+data[i].clinicNo+'&page='+currentPage+'&count='+currentCount+'">'+data[i].clinicContent+'</a><p></td>';
			str+='			      <td>'+data[i].memberNick+'</td>';
			str+='			      <td>'+data[i].clinicDate+'</td>';
			str+='			      <td>'+data[i].clinicCount+'</td>';
			str+='			      <td>'+data[i].clinicLike+'</td>';
			str+='			    </tr>';
        }
        str+='			  </tbody>';
		str+='			</table>';
		str+='         </div>';
        
        $("#clinic-list").append(str);
      }
      
    },
    error : function(){
      console.log('fail');
    },
    complete : function(){     
      getPageInfo(page);     
    }

  });

}

function goPage(clinicNo, page, count) {
    location.href="clinicDetail.kh?clinicNo="+clinicNo+"&page="+page+"&count="+count+"";
}

