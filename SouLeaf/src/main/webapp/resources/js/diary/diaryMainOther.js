var calendar;
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
	
    calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'today',
        center: 'prev,title,next',
        right: null
      },
      //defaultDate : Date, // 달력 초기화면에서 날짜 값 (오늘날짜 불러오기)
      navLinks: false, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      selectable: true,
      locale: 'ko',
      fixedWeekCount : false,
      contentHeight: 750,
      dayMaxEventRows: true, // for all non-TimeGrid views
      // 일정 받아와서 달력에 데이터 뿌려주는 기능
      events: 
      function(info, successCallback, failureCallback){
        var memberNo = $("#memberDiary").val();
        $.ajax({
          url : "diaryList.kh",
          type : "get",
          dataType : "json",
          data : {
            "memberNo" : memberNo
          },
          success : function(response) {
            successCallback(response);
          }
        });
      },

      // 물방울 아이콘 생성 함수
      eventContent:function(arg){
        let arrayOfDomNodes = []
        // icon event
        let eventWrap = document.createElement('div');
        eventWrap.classList = "fc-event-wrap"
        if(arg.event.extendedProps.image_url) {
          let imgEvent = '<img src="'+arg.event.extendedProps.image_url+'" >';
          eventWrap.innerHTML = imgEvent;
        }
        // title event
        let titleEvent = document.createElement('div')
        if(arg.event._def.title) {
          titleEvent.classList = "fc-event-title fc-sticky"
          titleEvent.innerHTML = arg.event._def.title
          eventWrap.append(titleEvent);
        }
        arrayOfDomNodes = [eventWrap]
        return {domNodes: arrayOfDomNodes}
      },
      eventDidMount: function(info) {
        var content;
        if(info.event.extendedProps.diaryRepicname != null) {
          content = '<div class="cal-card"><div class="cal-title" style="background :'+info.event.backgroundColor+';"><span>'+info.event.title+'</span></div><div class="cal-text">&nbsp'+info.event.constraint+'<img src="resources/uploadFiles/diary/'+info.event.extendedProps.diaryRepicname+'" alt="No Images"></div></div>';
        }else if(info.event.extendedProps.image_url){
          content = '<div class="cal-card"><div class="cal-titleImg" style="background :'+info.event.backgroundColor+';"><span><img src="'+info.event.extendedProps.image_url+'" style="width : 18px; height:18px;">'+info.event.title+'</span></div></div>';
        } else{
          content = '<div class="cal-card"><div class="cal-title" style="background :'+info.event.backgroundColor+';"><span>'+info.event.title+'</span></div><div class="cal-text">&nbsp'+info.event.constraint+'</div></div>';
        }
        
        var tippyContent = {          
          theme: 'light',
          allowHTML :true,
          delay: [400,300],
          animation : 'scale',
          maxWidth: 500,
          arrow: '',
        };
        tippyContent.content = content;
        tippy(info.el,tippyContent);
      },
    });
    calendar.render();
  
    // 글자 수 세주는 카운팅 적용
    $('#comment-content').on('keyup',function() {
        getwordCount($(this), $('#wordCount1'));
    });

    $('#edit-desc').on('keyup',function() {
        getwordCount($(this), $("#wordCount3"));
    });
    // 카운팅 끝~!!!

    getGuestbookList();
    //방명록 등록 버튼클릭 시 DB에 데이터 저장
    $("#btnGuestbook").on("click",function() {
      var guestbookContent = $("#comment-content").val();
      var memberDiary = $("#memberDiary").val();
      $.ajax({
      url:"regiseterGuestbook.kh",
      type:"post",
      data:{"guestbookContent":guestbookContent,"memberDiary":memberDiary},
      success : function(data) {
        if(data == "success"){
          $("#comment-content").val("");
          $("#wordCount1").text("(0/최대 200자 작성가능)");
          getGuestbookList();
        } else {
          alert("방명록 등록 실패!");
        }
      },
      error : function() {
      
      }
    
      });
	  });
  

  getDiaryPicList();

  selectCompanionVideo();
  $("#selectVideo").on("change",function(){
    getMyCompanionPic();
  }); 
  // document 끝
});


// 글자수 카운팅 함수
function getwordCount(textarea, alertText){
  var content = textarea.val();
  alertText.html("("+content.length+"/최대 200자 작성가능)");

  if(content.length > 200) {
    alert("최대 200자까지 입력 가능합니다.");
    textarea.val(textarea.val().substring(0,200));
    alertText.html("(200/최대 200자 작성가능)");
  }
}
// this로 obj로 받아와서 제이쿼리 객체로 만든 다음에 객체탐색메소드를 이용해서 키업 적용
// 수정을 누를수있는 버튼이 많이 존재하기 때문에 특정 객체만 불러와준다.
function commentModify(obj) {
  $(obj).on("keyup", function() {
     var wordCount2 = $(obj).parent().next().find('#wordCount2');
     getwordCount($(obj),wordCount2);
  })
}

// 방명록 리스트를 불러오는 함수
function getGuestbookList() {
  var memberDiary = $('#memberDiary').val();
  var memberNo = $("#memberNo").val();
  console.log(memberNo);
  $.ajax({
    url:"guestbookList.kh",
    type:"get",
    data:{"memberDiary" : memberDiary},
    dataType : "json",
    success : function(data) {
     console.log(data);
     var $cacommentList = $(".comment-list");
     $cacommentList.html("");
     if(data == "null"){
      $cacommentList.html("<br><br><br><h3> 등록된 방명록이 없습니다. </h3><br><br><br>");
      $cardBody.html("");
     }

     if(data.length > 0) {
       for(var i in data){
         var $cardBody = $("<div class='card-body'>");
         var $colmd2 = $("<div class='col-md-2'>");
         var $colmd10 = $("<div class='col-md-10'>");
         var $row = $("<div class='row'>");

         if(data[i].memberFileRename == null ){
          $colmd2.append("<img src='resources/images/basicMemberImg.png' class='img rounded-circle img-fluid user-img' style='width: 50px';'/><p class='text-secondary text-center'>"+data[i].memberNick+"</p></div>");
        }else {
         $colmd2.append("<img src='resources/uploadFiles/member/"+data[i].memberFileRename+"' class='img rounded-circle img-fluid user-img' style='width: 50px';'/><p class='text-secondary text-center'>"+data[i].memberNick+"</p></div>");
        }
         var $clearfix = $("<div class='clearfix'>");
         $clearfix.append("<p>"+data[i].guestbookContent+"</p><span class='datetime'>"+data[i].guestbookDate+" </span>");

         if(data[i].memberNo == memberNo){
           $clearfix.append("<a href='#' onclick='modifyGuestbook(this,"+data[i].guestbookNo+",\""+data[i].guestbookContent+"\")'> 수정 </a> <a href='#' onclick='removeGuestbook("+data[i].guestbookNo+");return false'> 삭제</a>");
         }
         $colmd10.append($clearfix);
         $row.append($colmd2).append($colmd10);
         $cardBody.append($row);
         $cacommentList.append($cardBody);
       }
       }
     }, error :function(){
       console.log("fail");
     }
  });
};
// 방명록 수정 버튼 클릭시 수정창을 띄워주는 함수
function modifyGuestbook(obj,guestbookNo, modifyContent) {
  var $modifySection = $("<div class='modify-section'>");
  var $modifyForm = $("<div class='modifyform'>").append("<div class='comment-retext'><textarea id='comment-modify' onclick='commentModify(this);' rows='3'>"+ modifyContent +"</textarea></div>").append("<div class='comment-reEnroll'><span id='wordCount2'>(0/최대 200자 작성가능)</span><button type='button' class='btn btn-default btn-secondary' onclick='modifyGuestbookCommit("+guestbookNo+",\""+modifyContent+"\")'>수정</button></div>");
  $modifySection.append($modifyForm);
  $(obj).parent().parent().parent().parent().after($modifySection);
}

// 방명록 수정 commit 함수
function modifyGuestbookCommit(guestbookNo,modifyedContent) {
  var modifyedContent = $("#comment-modify").val();
  $.ajax({
    url :"modifyGuestbook.kh",
    type :"post",
    data : {"guestbookNo":guestbookNo,"guestbookContent":modifyedContent},
    success : function(data){
      if(data == "success"){
        alert("방명록이 수정되었습니다.");
        getGuestbookList();
      } else {
        alert("방명록 수정 실패");
      }
    }
  });
}

// 방명록 삭제함수
function removeGuestbook(guestbookNo) {
  $.ajax({
    url : "deleteGuestbook.kh",
    type : "get",
    data: {"guestbookNo" :guestbookNo},
    success : function(data){
      if(data == "success") {
        alert("방명록이 삭제되었습니다.");
        getGuestbookList();
      } else {
        alert("방명록 삭제 실패");
      }
    },
    error : function() {

    }
  });
}
  
// 사진첩 리스트 띄우기
function getDiaryPicList(){
  var memberNo = $("#memberDiary").val();
  $.ajax({
    url : "diaryPicList.kh",
    type : "get",
    data : {"memberNo": memberNo},
    dataType : "json",
    success : function(data){
      var $carouselInner = $('#carouselPicture');
      $carouselInner.html("");
      var $carouselItemActive;
      var $carouselItem;
      var $row;
      var $thumb;
      console.log(data);
      if(data.length > 0){     
          for(var i in data){ // i 값이 8의 배수가 되면 다음 것으로 넘어감...
            $thumb = $("<div class='col-lg-3 col-md-4 col-xs-6 thumb'>").append("<a href='resources/uploadFiles/diary/"+data[i].diaryRepicname+"' class='fancybox' rel='ligthbox'><img src='resources/uploadFiles/diary/"+data[i].diaryRepicname+"' class='zoom img-fluid'></a>");

            if(i == 0){
              $row = $("<div class='row'>");
              $carouselItemActive = $("<div class='carousel-item active'>");
              $carouselItemActive.append($row);
              $row.append($thumb);
              $carouselInner.append($carouselItemActive);           
            } else if(i % 8 != 0){
              $row.append($thumb);                  
              $carouselItemActive.append($row);
            }
            
            if(i > 7) {
              if(i % 8 == 0){ 
                $carouselItem = $("<div class='carousel-item'>");
                $row = $("<div class='row'>");
                $carouselItem.append($row);
                $row.append($thumb);
                $carouselInner.append($carouselItem); 
              }else if(i % 8 != 0){
                $row.append($thumb); 
                $carouselItem.append($row);
              }
            }  
          }
      }
 
    }
  })
}

/**
 *  yyyyMMdd 포맷으로 반환
 */
 function getFormatDate(date){
  var year = date.getFullYear();              //yyyy
  var month = (1 + date.getMonth());          //M
  month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
  var day = date.getDate();                   //d
  day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
  return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}

// 사진첩 동적으로 불러온 것을 다시 동적으로 입혀줌
$(document).on('click',function(){
  $('.fancybox').fancybox({
    openEffect: "none",
    closeEffect: "none",
  });
  $(".zoom").hover(function(){
    $(this).addClass('transition');
  }, function(){
    $(this).removeClass('transition');
  });
});
// getDiaryPicList();

 function selectCompanionVideo() {
  var memberNo = $("#memberDiary").val();
  $.ajax({
    url : "myCompanionList.kh",
    type : "get",
    dataType : "json",
    data : {"memberNo":memberNo},
    success : function(data) {
      var $select = $('#selectVideo');
      $select.html("");
      console.log(data);
      var $option;
      if(data.length > 0) {
        $select.append("<option value='0'>반려식물 선택</option>");
        for(var i in data){
            $option = $("<option value='"+data[i].companionNo +"' data-com-water='"+data[i].companionLastWater+"'>"+data[i].companionNick +"</option>");
            $select.append($option);        
        }      
      }
    }
  });
  
 }

// 반력식물 선택 시 해당 사진만 모아서 동영상처럼 보이게 효과를 줌
function getMyCompanionPic(){
  var companionNo = $("#selectVideo option:selected").val(); 
  var memberNo = $("#memberDiary").val();
  $.ajax({
    url : "diaryPicVideo.kh",
    type : "get",
    dataType : "json",
    data : {"memberNo":memberNo,"companionNo":companionNo},
    success : function(data){
      var $videoCarousel = $("#videoCarousel");
      $videoCarousel.html("");
      var $carouslInnerActive;
      var $carouslInner;
      if(data.length > 0){
        for(var i in data){
          if(i==0){
            $carouslInnerActive = $("<div class='carousel-item active'>");
            $carouslInnerActive.append("<img src='resources/uploadFiles/diary/"+data[i].diaryRepicname +"' class='d-block w-100' >");
            $videoCarousel.append($carouslInnerActive);
          }else {
            $carouslInner = $("<div class='carousel-item'>");
            $carouslInner.append("<img src='resources/uploadFiles/diary/"+data[i].diaryRepicname +"' class='d-block w-100' >");
            $videoCarousel.append($carouslInner);
          }
        }
        
      }
    }
  });
};

