$(function(){
    // 체크 박스 전체선택 및 전체 해제
    $(".chk_all").click(function(){
        if($(".chk_all").is(":checked")){
            $(".chk").prop("checked",true);
        }else {
            $(".chk").prop("checked",false);
        }
    });
    var memberNo = $("#memberNo").val();
    var pageInfo = $("#pageInfo").val();
    getMyCuriosityList(memberNo,pageInfo);
    getMyClincList(memberNo, pageInfo);
    getMyQnaList(memberNo, pageInfo);
    getMyBoastList(memberNo, pageInfo);

     // 마이페이지 궁금해요 검색 버튼 클릭
     var pageInfo = $("#pageInfo").val();
     $("#curiositySearchBtn").on("click",function(){
         var searchCondition =  $("#searchCondition").val();
         var searchValue = $("#searchValue").val();
 
         var $tr;
         var $check;
         var $num;
         var $title;
         var $writeDate;
         var $readCount;
         var $btnArea;
         var $chooseDelete;
         var $delTr;
 
         var $lt;
         var $gt;
         var $aActive;
         var $a;
 
         $.ajax({
             url : "curiositySearch.kh",
             type : "get",
             data : {"searchCondition" : searchCondition, "searchValue" : searchValue, "page":pageInfo},
             dataType : "json",
             success : function(data) {
                 $("#searchValue").val(searchValue);
                 $("#searchCondition").val(searchCondition).prop("selected",true);
 
                 var $tbody = $("#myPage-curiosity tbody");
                 var $paging = $("#curiosity-page");
 
                 var page = data.pi.currentPage;
                 var startPage = data.pi.startPage;
                 var endPage = data.pi.endPage;
                 var maxPage = data.pi.maxPage;
                 console.log(maxPage,endPage);
 
                 $tbody.html("");
                 $paging.html("");
                 if(data.searchList.length > 0){
                     for(var i in data.searchList){
                         $tr = $("<tr>");
                         $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.searchList[i].curiosityNo+"'>");
                         $num = $("<td scope='row'>").text(data.searchList[i].num);
                         if(data.searchList[i].curiosityContent.length > 18){
                             $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.searchList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].curiosityContent.substr(0,18)+"...</a>");
                         }else{
     
                             $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.searchList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].curiosityContent+"</a>");
                         }
                         $writeDate = $("<td>").text(data.searchList[i].curiosityDate);
                         $readCount = $("<td>").text(data.searchList[i].curiosityCount);
                         $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data.searchList[i].curiosityNo+")'>수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");
     
                         $chooseDelete = $("<td>").append("<button type='button' onclick='deleteCuriositySelectList("+data.searchList[i].memberNo+","+page+")' class='btn btn-outline-warning'>선택삭제</button>");
                         
                         $tr.append($check);
                         $tr.append($num);
                         $tr.append($title);
                         $tr.append($writeDate);
                         $tr.append($readCount);
                         $tr.append($btnArea);
                         if(i == (data.searchList.length-1)){
                             $delTr = $("<tr>");
                             $delTr.append($chooseDelete);
                             $delTr.append("<td colspan='5'></td>");
                         }
                         $tbody.append($tr);
                         $tbody.append($delTr);
                     }
                 }
                 if(page <= 1){
                     $lt = $("<li><a href='#'>&lt;</a></li>");
                     $paging.append($lt);
                 }else {
                     $lt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                     $paging.append($lt);
                 }
                 for(var j = startPage; j<=endPage; j++){
                     if(j == page){
                         $aActive = $('<li class="active"><span>'+j+'</span></li>');
                         $paging.append($aActive);
                     }else {
                         $a = $("<li><a name='page' href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+j+"); return false;'>"+j+"</a></li>");
                         $paging.append($a);
                     }
                 }
                 if(page >= maxPage){
                     $gt = $('<li><a href="#">&gt;</a></li>');
                     $paging.append($gt);
                 } else {
                     $gt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                     $paging.append($gt);
                 }
 
 
             },
             error : function(){
     
             }
         })
 
     });

     // 클리닉 검색 하기
     $("#clinicSearchBtn").on("click",function(){
        var searchCondition =  $("#clinicSearchCondition").val();
        var searchValue = $("#clinicSearchValue").val();

        var $tr;
        var $check;
        var $num;
        var $title;
        var $writeDate;
        var $readCount;
        var $btnArea;
        var $chooseDelete;
        var $delTr;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        $.ajax({
            url : "clinicSearch.kh",
            type : "get",
            data : {"searchCondition" : searchCondition, "searchValue" : searchValue, "page":pageInfo},
            dataType : "json",
            success : function(data) {
                $("#searchValue").val(searchValue);
                $("#searchCondition").val(searchCondition).prop("selected",true);

                var $tbody = $("#myPage-clinic tbody");
                var $paging = $("#clinic-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);

                $tbody.html("");
                $paging.html("");
                if(data.searchList.length > 0){
                    for(var i in data.searchList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.searchList[i].clinicNo+"'>");
                        $num = $("<td scope='row'>").text(data.searchList[i].num);
                        if(data.searchList[i].clinicContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='clinicDetail.kh?clinicNo="+data.searchList[i].clinicNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].clinicContent.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='clinicDetail.kh?clinicNo="+data.searchList[i].clinicNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].clinicContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.searchList[i].clinicDate);
                        $readCount = $("<td>").text(data.searchList[i].clinicCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyclinic("+data.searchList[i].clinicNo+")'>수정</button><button type='button' class='btn btn-outline-danger' onclick='deleteclinic("+data.searchList[i].clinicNo+")'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteClinicSelectList("+data.searchList[i].memberNo+","+page+")' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.searchList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }
                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }


            },
            error : function(){
    
            }
        })

    });

    // 자랑하기 검색 하기
    $("#boastSearchBtn").on("click",function(){
        var searchCondition =  $("#boastSearchCondition").val();
        var searchValue = $("#boastSearchValue").val();

        var $tr;
        var $check;
        var $num;
        var $title;
        var $writeDate;
        var $readCount;
        var $btnArea;
        var $chooseDelete;
        var $delTr;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        $.ajax({
            url : "boastSearch.kh",
            type : "get",
            data : {"searchCondition" : searchCondition, "searchValue" : searchValue, "page":pageInfo},
            dataType : "json",
            success : function(data) {
                $("#searchValue").val(searchValue);
                $("#searchCondition").val(searchCondition).prop("selected",true);

                var $tbody = $("#myPage-boast tbody");
                var $paging = $("#boast-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);

                $tbody.html("");
                $paging.html("");
                if(data.searchList.length > 0){
                    for(var i in data.searchList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.searchList[i].boastNo+"'>");
                        $num = $("<td scope='row'>").text(data.searchList[i].num);
                        if(data.searchList[i].boastTitle.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='clinicDetail.kh?clinicNo="+data.searchList[i].boastNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].boastTitle.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='clinicDetail.kh?clinicNo="+data.searchList[i].boastNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].boastTitle+"</a>");
                        }
                        $writeDate = $("<td>").text(data.searchList[i].boastDate);
                        $readCount = $("<td>").text(data.searchList[i].boastCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyBoast("+data.searchList[i].boastNo+")'>수정</button><button type='button' class='btn btn-outline-danger' onclick='deleteBoast("+data.searchList[i].boastNo+")'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteBoastSelectList("+data.searchList[i].memberNo+","+page+")' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.searchList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }
                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getSearchBoastList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getSearchBoastList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getSearchBoastList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }


            },
            error : function(){
    
            }
        })

    });

});



    function clickAns (e){
        var oStatus = $(e).next().css("display");
        if(oStatus == "none") { 
            $(e).next().css("display", "contents");
        }else{
            $(e).next().css("display", "none");
        }
    }

    // 내가 쓴 궁금해요 리스트 뿌려주기
    function getMyCuriosityList(memberNo, pageInfo) {
        var memberNo = $("#memberNo").val();
        //var pageInfo = $("#pageInfo").val();
        var $tr;
        var $check;
        var $num;
        var $title;
        var $writeDate;
        var $readCount;
        var $btnArea;
        var $chooseDelete;
        var $delTr;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        $.ajax({
            url : "myCuriosityList.kh",
            type : "get",
            data : {"page" : pageInfo,"memberNo" : memberNo},
            dataType : "json",
            success : function(data) {
                console.log(data);
                var $tbody = $("#myPage-curiosity tbody");
                var $paging = $("#curiosity-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);

                $tbody.html("");
                $paging.html("");
                if(data.curList.length > 0){
                    for(var i in data.curList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.curList[i].curiosityNo+"'>");
                        $num = $("<td scope='row'>").text(data.curList[i].num);
                        if(data.curList[i].curiosityContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.curList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.curList[i].curiosityContent.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.curList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.curList[i].curiosityContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.curList[i].curiosityDate);
                        $readCount = $("<td>").text(data.curList[i].curiosityCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data.curList[i].curiosityNo+")'>수정</button><button type='button' onclick='deleteCuriosity("+data.curList[i].curiosityNo+")' class='btn btn-outline-danger'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteCuriositySelectList("+data.curList[i].memberNo+","+page+");' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.curList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }
                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getMyCuriosityList("+data.curList[0].memberNo+","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getMyCuriosityList("+data.curList[0].memberNo+","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getMyCuriosityList("+data.curList[0].memberNo+","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }


            },
            error : function(){
                
            }
        });
    }
    
    // 마이페이지 궁금해요 수정버튼 클릭시 수정화면 이동
    function modifyCuriosity(curiosityNo){
        location.href ='curiosityModifyView.kh?curiosityNo='+curiosityNo+'';
    }  
   // 마이페지이 궁금해요 삭제버튼 클릭시 삭제
   function deleteCuriosity(curiosityNo){
    location.href='myCuriosityDelete.kh?curiosityNo='+curiosityNo+'';
}
    // 마이페이지 궁금해요 검색 함수
    function getSearchCuriosityList(searchCondition,searchValue,pageInfo){
        var $tr;
        var $check;
        var $num;
        var $title;
        var $writeDate;
        var $readCount;
        var $btnArea;
        var $chooseDelete;
        var $delTr;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        $.ajax({
            url : "curiositySearch.kh",
            type : "get",
            data : {"searchCondition" : searchCondition, "searchValue" : searchValue, "page":pageInfo},
            dataType : "json",
            success : function(data) {
                var $tbody = $("#myPage-curiosity tbody");
                var $paging = $("#curiosity-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);

                $tbody.html("");
                $paging.html("");
                if(data.searchList.length > 0){
                    for(var i in data.searchList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.searchList[i].curiosityNo+"'>");
                        $num = $("<td scope='row'>").text(data.searchList[i].num);
                        if(data.searchList[i].curiosityContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.searchList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].curiosityContent.substr(0,18)+"...</a>");
                        }else{

                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.searchList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].curiosityContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.searchList[i].curiosityDate);
                        $readCount = $("<td>").text(data.searchList[i].curiosityCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data.searchList[i].curiosityNo+")'>수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");

                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteCuriositySelectList("+data.searchList[i].memberNo+","+page+")' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.searchList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }else if(data.searchList.length == 0) {
                    $tbody.append("<span>검색결과가 없습니다.</span>"); // 안뜸!!! ㅗ애 안떠~!!!
                }

                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }
            },
            error : function(){

            }
        })
    }

    // 내가 쓴 궁금해요 선택 삭제
    function deleteCuriositySelectList(memberNo,page){
        if($(".chk").is(":checked") == false){
            alert("선택된 삭제 목록이 없습니다.");
            return false;
        }else {
            if(!confirm("정말 삭제하시겠습니까?")){
                return false;
            }else {
                var chkVal;
                $("input:checkbox[name='del-select']:checked").each(function(index){
                    if(index != 0){
                        chkVal += ',';
                    }
                    chkVal += $(this).val();
                });
                chkVal = chkVal.substr(9);
                console.log(chkVal);
                $.ajax({
                    url : 'curiositydelete.kh',
                    type : 'get',
                    data : {"chkNo" : chkVal },
                    success : function(data){
                        if(data == "success"){
                            getMyCuriosityList(memberNo, page);
                        }
                    },
                    error : function(){}
                });
            }
        }

    }


    // 내가 쓴 클리닉 리스트 뿌려주기
    function getMyClincList(memberNo, pageInfo) {
        var memberNo = $("#memberNo").val();
        //var pageInfo = $("#pageInfo").val();
        var $tr;
        var $check;
        var $num;
        var $title;
        var $writeDate;
        var $readCount;
        var $btnArea;
        var $chooseDelete;
        var $delTr;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        $.ajax({
            url : "myClinicList.kh",
            type : "get",
            data : {"page" : pageInfo,"memberNo" : memberNo},
            dataType : "json",
            success : function(data) {
                console.log(data);
                var $tbody = $("#myPage-clinic tbody");
                var $paging = $("#clinic-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);

                $tbody.html("");
                $paging.html("");
                if(data.cliList.length > 0){
                    for(var i in data.cliList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.cliList[i].clinicNo+"'>");
                        $num = $("<td scope='row'>").text(data.cliList[i].num);
                        if(data.cliList[i].clinicContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='clinicDetail.kh?clinicNo="+data.cliList[i].clinicNo+"&page=1&count=0'class='noColor'>"+data.cliList[i].clinicContent.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='clinicDetail.kh?clinicNo="+data.cliList[i].clinicNo+"&page=1&count=0'class='noColor'>"+data.cliList[i].clinicContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.cliList[i].clinicDate);
                        $readCount = $("<td>").text(data.cliList[i].clinicCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyClinic("+data.cliList[i].clinicNo+")'>수정</button><button type='button' onclick='deleteclinic("+data.cliList[i].clinicNo+")' class='btn btn-outline-danger'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteClinicSelectList("+data.cliList[i].memberNo+","+page+");' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.cliList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }
                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getMyClincList("+data.cliList[0].memberNo+","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getMyClincList("+data.cliList[0].memberNo+","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getMyClincList("+data.cliList[0].memberNo+","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }


            },
            error : function(){
                
            }
        });
    }

    // 마이페이지 클리닉 수정버튼 클릭시 수정화면 이동
    function modifyClinic(clinicNo){
        location.href ='clinicModifyView.kh?clinicNo='+clinicNo+'';
    }

    // 마이페지이 클리닉 삭제버튼 클릭시 삭제
    function deleteclinic(clinicNo){
        location.href='myClinicDelete.kh?clinicNo='+clinicNo+'';
    }

    // 마이페이지 클리닉 검색 함수
    function getSearchClinicList(searchCondition,searchValue,pageInfo){
        var $tr;
        var $check;
        var $num;
        var $title;
        var $writeDate;
        var $readCount;
        var $btnArea;
        var $chooseDelete;
        var $delTr;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        $.ajax({
            url : "clinicSearch.kh",
            type : "get",
            data : {"searchCondition" : searchCondition, "searchValue" : searchValue, "page":pageInfo},
            dataType : "json",
            success : function(data) {
                var $tbody = $("#myPage-clinic tbody");
                var $paging = $("#clinic-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);

                $tbody.html("");
                $paging.html("");
                if(data.searchList.length > 0){
                    for(var i in data.searchList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.searchList[i].clinicNo+"'>");
                        $num = $("<td scope='row'>").text(data.searchList[i].num);
                        if(data.searchList[i].clinicContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='clinicDetail.kh?clinicNo="+data.searchList[i].clinicNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].clinicContent.substr(0,18)+"...</a>");
                        }else{

                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='clinicDetail.kh?clinicNo="+data.searchList[i].clinicNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].clinicContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.searchList[i].clinicDate);
                        $readCount = $("<td>").text(data.searchList[i].clinicCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyClinic("+data.searchList[i].clinicNo+")'>수정</button><button type='button' onclick='deleteclinic("+data.cliList[i].clinicNo+")' class='btn btn-outline-danger'>삭제</button>");

                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteClinicSelectList("+data.searchList[i].memberNo+","+page+")' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.searchList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }else if(data.searchList.length == 0) {
                    $tbody.append("<span>검색결과가 없습니다.</span>"); // 안뜸!!! ㅗ애 안떠~!!!
                }

                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getSearchClinicList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getSearchClinicList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getSearchClinicList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }
            },
            error : function(){

            }
        })
    }

    function deleteClinicSelectList(memberNo,page){
        if($(".chk").is(":checked") == false){
            alert("선택된 삭제 목록이 없습니다.");
            return false;
        }else {
            if(!confirm("정말 삭제하시겠습니까?")){
                return false;
            }else {
                var chkVal;
                $("input:checkbox[name='del-select']:checked").each(function(index){
                    if(index != 0){
                        chkVal += ',';
                    }
                    chkVal += $(this).val();
                });
                chkVal = chkVal.substr(9);
                console.log(chkVal);
                $.ajax({
                    url : 'clinicdelete.kh',
                    type : 'get',
                    data : {"chkNo" : chkVal },
                    success : function(data){
                        if(data == "success"){
                            getMyClincList(memberNo, page);
                        }
                    },
                    error : function(){}
                });
            }
        }

    }


    // 내가 쓴 QNA 리스트 뿌려주기
    function getMyQnaList(memberNo, pageInfo) {
        var memberNo = $("#memberNo").val();
        //var pageInfo = $("#pageInfo").val();
        var $tr;
        var $num;
        var $title;
        var $writeDate;
        var $btnArea;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        var $ansTr;
        var $ansContent; 
        var $td1;
        var $td2;
        var $td3;
        $.ajax({
            url : "myQnaList.kh",
            type : "get",
            data : {"page" : pageInfo,"memberNo" : memberNo},
            dataType : "json",
            success : function(data) {
                console.log(data);
                var $tbody = $("#myPage-qna tbody");
                var $paging = $("#qna-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);


                $tbody.html("");
                $paging.html("");
                if(data.qnaList.length > 0){
                    for(var i in data.qnaList){
                        console.log(data.qnaList[i].ansNo);
                        if(data.qnaList[i].ansNo == null){
                            $tr = $("<tr>");
                            $num = $("<td scope='row'>").text(data.qnaList[i].num);
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='#' class='noColor'>"+data.qnaList[i].qnaContent+"</a>");
                            $writeDate = $("<td>").text(data.qnaList[i].qnaDate);
                            $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyQna("+data.qnaList[i].qnaNo+")'>수정</button><button type='button' onclick='deleteQna("+data.qnaList[i].qnaNo+")' class='btn btn-outline-danger'>삭제</button>");
                            $tr.append($num);
                            $tr.append($title);
                            $tr.append($writeDate);
                            $tr.append($btnArea);
                            $tbody.append($tr);
                        }else {
                            $tr = $("<tr onclick='clickAns(this)'>");
                            $num = $("<td scope='row'>").text(data.qnaList[i].num);
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='#' class='noColor'>"+data.qnaList[i].qnaContent+"</a>");
                            $writeDate = $("<td>").text(data.qnaList[i].qnaDate);
                            $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-warning btnGreen'>답변완료</button>");
                            $ansTr = $("<tr class='showAns' style='display:none;'>");
                            $td1 = $("<td>").text("");
                            $ansContent = $("<td stlye='width:524px; color :#666666; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'> 답변 : "+data.qnaList[i].ansContent+"</a>"); 
                            $td2 = $("<td>").text("");
                            $td3 = $("<td>").text("");
                            $tr.append($num);
                            $tr.append($title);
                            $tr.append($writeDate);
                            $tr.append($btnArea);
                            $ansTr.append($td1);
                            $ansTr.append($ansContent);
                            $ansTr.append($td2);
                            $ansTr.append($td3);
                            $tbody.append($tr);
                            $tbody.append($ansTr);
                        }
                        
                    }
                }
                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getMyClincList("+data.qnaList[0].memberNo+","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getMyClincList("+data.qnaList[0].memberNo+","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getMyClincList("+data.qnaList[0].memberNo+","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }


            },
            error : function(){
                
            }
        });
    }


    function deleteQna(qnaNo){
        location.href="qnaDelete.kh?qnaNo="+qnaNo+'';
    }

    function modifyQna(qnaNo){
        location.href="qnaModifyView.kh?qnaNo="+qnaNo+'';
    }

      // 내가 쓴 궁금해요 리스트 뿌려주기
    function getMyBoastList(memberNo, pageInfo) {
        var memberNo = $("#memberNo").val();
        //var pageInfo = $("#pageInfo").val();
        var $tr;
        var $check;
        var $num;
        var $title;
        var $writeDate;
        var $readCount;
        var $btnArea;
        var $chooseDelete;
        var $delTr;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        $.ajax({
            url : "myBoastList.kh",
            type : "get",
            data : {"page" : pageInfo,"memberNo" : memberNo},
            dataType : "json",
            success : function(data) {
                console.log(data);
                var $tbody = $("#myPage-boast tbody");
                var $paging = $("#boast-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);

                $tbody.html("");
                $paging.html("");
                if(data.bList.length > 0){
                    for(var i in data.bList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.bList[i].boastNo+"'>");
                        $num = $("<td scope='row'>").text(data.bList[i].num);
                        if(data.bList[i].boastTitle.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='boastDetail.kh?boastNo="+data.bList[i].boastNo+"'class='noColor'>"+data.bList[i].boastTitle.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='boastDetail.kh?boastNo="+data.bList[i].boastNo+"'class='noColor'>"+data.bList[i].boastTitle+"</a>");
                        }
                        $writeDate = $("<td>").text(data.bList[i].boastDate);
                        $readCount = $("<td>").text(data.bList[i].boastCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyBoast("+data.bList[i].boastNo+")'>수정</button><button type='button' onclick='deleteBoast("+data.bList[i].boastNo+")' class='btn btn-outline-danger'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteBoastSelectList("+data.bList[i].memberNo+","+page+");' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.bList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }
                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getMyBoastList("+data.bList[0].memberNo+","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getMyBoastList("+data.bList[0].memberNo+","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getMyBoastList("+data.bList[0].memberNo+","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }


            },
            error : function(){
                
            }
        });
    }


    function deleteBoast(boastNo){
        location.href="boastDelete.kh?boastNo="+boastNo+'';
    }

    function modifyBoast(boastNo){
        location.href="boastUpdateView.kh?boastNo="+boastNo+'';
    }

    // 내가 쓴 자랑하기 선택 삭제
    function deleteBoastSelectList(memberNo,page){
        if($(".chk").is(":checked") == false){
            alert("선택된 삭제 목록이 없습니다.");
            return false;
        }else {
            if(!confirm("정말 삭제하시겠습니까?")){
                return false;
            }else {
                var chkVal;
                $("input:checkbox[name='del-select']:checked").each(function(index){
                    if(index != 0){
                        chkVal += ',';
                    }
                    chkVal += $(this).val();
                });
                chkVal = chkVal.substr(9);
                console.log(chkVal);
                $.ajax({
                    url : 'boastdelete.kh',
                    type : 'get',
                    data : {"chkNo" : chkVal },
                    success : function(data){
                        if(data == "success"){
                            getMyBoastList(memberNo, page);
                        }
                    },
                    error : function(){}
                });
            }
        }

    }