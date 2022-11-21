$(function(){
	window.emojioneVersion = "3.1.2";
//여기 아래 부분
$('#summernote').summernote({
	placeholder: '최대 500자 작성 가능합니다.',
			height: 300,
			lang: 'ko-KR',
			callbacks: {
				onImageUpload: function(files, editor, welEditable) {
					for(var i = files.length -1; i>=0; i--) {
						sendFile(files[i], this);
					}
				}
			}
	 });
	 getLikeCount();
	 if( $("#loginNo").val() != ""){
		 likeCheck();

	 }
		 getReplyList($("#boastNo").val());
		 
		 $("#emojionearea1").emojioneArea({
			pickerPosition: "top",
			filtersPosition: "bottom",
		  tones: false,
		  autocomplete: false,
		  inline: true,
		  hidePickerOnBlur: true
		});

	

		$("#emojionearea1").on("keypress",function(key){			
			if(key.keyCode==13) {
				
				replyRegister($("#boastyNo").val());
			}			
		});

		$("#submit-btn").on("click",function(){
			alert("a");
			return false;
			var check  = $("input[name='companionNo']:checked").val();

					
			console.log(check);
			if(check){
				alert('d');
				return false;
			}
		});
});

/**
	* 이미지 파일 업로드
	*/
	function sendFile(file, el) {
		var form_data = new FormData();
		form_data.append('file', file);
		$.ajax({
			data: form_data,
			type : "post",
			url: 'boast_summer_image.kh',
			cache :false,
			contentType : false,
			enctype : 'multipart/form-data',
			processData : false,
			success : function(img_name) {
				$(el).summernote('editor.insertImage', img_name);
			}
		});
	}

function readURL(input) {
  if (input.files && input.files[0]) {

    var reader = new FileReader();

    reader.onload = function(e) {
      $('.image-upload-wrap').hide();

      $('.file-upload-image').attr('src', e.target.result);
      $('.file-upload-content').show();

      $('.image-title').html(input.files[0].name);
    };

    reader.readAsDataURL(input.files[0]);

  } else {
    removeUpload();
  }
}

function removeUpload() {
  $('.file-upload-input').replaceWith($('.file-upload-input').clone());
  $('.file-upload-content').hide();
  $('.image-upload-wrap').show();
}
$('.image-upload-wrap').bind('dragover', function () {
        $('.image-upload-wrap').addClass('image-dropping');
    });
    $('.image-upload-wrap').bind('dragleave', function () {
        $('.image-upload-wrap').removeClass('image-dropping');
});

function replyRegister(boastNo){
	if($("#loginNo").val() ==  ""){
		alert('로그인 후 이용가능합니다.');
		return false;
	}	
	var content = $("#emojionearea1").val();
	if(content == ""){
		alert('내용을 입력해주세요.');
		return false;
	}
	$.ajax({
		url : "boastReplyRegister.kh",
		type:"post",
		data : {"boastNo":boastNo,"bocommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(boastNo);
			$("#emojionearea1").val("");
			$('.emojionearea-editor').text('');
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });

}

function replyModifyView(obj,boastNo,memberNo,replyNo,content){	
    $textarea = '<div class="row" style="position: relative;"><input type="text" style="width: 80%; margin-left:10%; height: 32px !important;" class="form-control" id="replyReContent" value="'+content+'"><button class="mt-4 p-2 btn btn-secondary reply-btn" style="right:6%;" onclick="replyUpdate('+boastNo+','+memberNo+','+replyNo+')">수정</button></div>';
	$(".boast-btn").hide();
  $(obj).hide();  
  $(obj).parent().parent().parent().after($textarea);
}

function replyUpdate(boastNo,memberNo,replyNo){	
	var content = $("#replyReContent").val();
	$.ajax({
		url : "boastReplyModify.kh",
		type:"post",
		data : {"boastNo":boastNo,"memberNo":memberNo,"bocommentNo":replyNo,"bocommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(boastNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
	
}

function getReplyList(boastNo){	
	var loginNo = $("#loginNo").val();
	$.ajax({
		url : "boastReplyList.kh",
		type:"get",
		data : {"boastNo":boastNo},	
		dataType:"json",	
		success : function(data){
				
			var str = "";
			if(data.length > 0){
				$("#comment-count").text(data.length);
				$("#replyCount").text(data.length);
		
		 for(var i in data){
				if(data[i].bocommentDepth <= 0){

				 str+='<div class="media p-3">';			
				 if(data[i].memberFileRename == null){
					 str+='<img src="resources/images/basicMemberImg.png" alt="John Doe" class="mr-3 mt-2 rounded-circle" style="width:60px; height: 60px">';	
				 }else{
					 str+='<img src="/resources/uploadFiles/member/'+data[i].memberFileRename+'" alt="John Doe" class="mr-3 mt-2 rounded-circle" style="width:60px; height: 60px">';
				 }	
				 str+='<div class="media-body">';
				 str+='<strong>'+data[i].memberNick+'</strong><br>';
				 str+='<span>'+data[i].bocommentContent+'</span><br>';
				 if(loginNo == data[i].memberNo){
					 str+='<small>'+data[i].bocommentDate+' <span onclick="replyReReView(this,'+data[i].boastNo+','+data[i].bocommentNo+',\''+data[i].memberNick+'\')" class="text-primary boast-btn">답글달기</span> <span onclick="replyModifyView(this,'+data[i].boastNo+','+data[i].memberNo+','+data[i].bocommentNo+',\''+data[i].bocommentContent+'\')" class="text-success boast-btn">수정</span> <span onclick="replyDelete('+data[i].bocommentNo+')" class="text-danger boast-btn">삭제</span></small><br>';	
	 
				 }else{
					 str+='<small>'+data[i].bocommentDate+' <span onclick="replyReReView(this,'+data[i].boastNo+','+data[i].bocommentNo+',\''+data[i].memberNick+'\')" class="text-primary boast-btn">답글달기</span></small><br>';
				 }
	 
				 str+='</div>';
				 str+='</div>';

				 $.ajax({
					url : "boastReplyList.kh",
					type:"get",
					data : {"boastNo":boastNo},	
					async : false,
					dataType:"json",	
					success : function(reData){
						
						for(var j in reData){
							if(data[i].bocommentNo == data[j].bocommentParentNo){
									str+='<div class="media p-3 ml-5">';			
								if(data[j].memberFileRename == null){
									str+='<img src="resources/images/basicMemberImg.png" alt="John Doe" class="mr-3 mt-2 rounded-circle" style="width:60px; height: 60px">';	
								}else{
									str+='<img src="/resources/uploadFiles/member/'+data[j].memberFileRename+'" alt="John Doe" class="mr-3 mt-2 rounded-circle" style="width:60px; height: 60px">';
								}	
								str+='<div class="media-body">';
								str+='<strong>'+data[j].memberNick+'</strong><br>';
								str+='<span>'+data[j].bocommentContent+'</span><br>';
								if(loginNo == data[j].memberNo){
									str+='<small>'+data[j].bocommentDate+' <span onclick="replyReView(this,\''+data[j].bocommentContent+'\','+data[j].bocommentNo+')" class="text-success boast-btn">수정</span> <span onclick="replyReDelete('+data[j].bocommentNo+')" class="text-danger boast-btn">삭제</span></small><br>';	
					
								}else{
									str+='<small>'+data[j].bocommentDate+' </small><br>';
								}
					
								str+='</div>';
								str+='</div>';	
							}
						}
					}
				 });
			 }
			

			}
		
		  $("#boast-comment").html(str);
		}
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}

function replyDelete(bocommentNo){
	if (!confirm("삭제시 대댓글도 삭제됩니다. 정말 삭제하시겠습니까?")) {
		// 취소(아니오) 버튼 클릭 시 이벤트
			return false;
		} else {
	var boastNo = $("#boastNo").val();
	$.ajax({
		url : "boastReplyDelete.kh",
		type:"post",
		data : {"boastNo":boastNo,"bocommentNo":bocommentNo},		
		success : function(data){
					
		if(data > 0){
			getReplyList(boastNo);			
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
	}
}

function replyReDelete(bocommentNo){
	if (!confirm("정말 삭제하시겠습니까?")) {
		// 취소(아니오) 버튼 클릭 시 이벤트
			return false;
		} else {
	var boastNo = $("#boastNo").val();
	$.ajax({
		url : "boastReReplyDelete.kh",
		type:"post",
		data : {"boastNo":boastNo,"bocommentNo":bocommentNo},		
		success : function(data){
			
		if(data > 0){
			getReplyList(boastNo);			
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
	}
}

function replyReView(obj,content,bocommentNo){
	
	$textarea = '<div class="row" style="position: relative;"><input type="text" style="width: 80%; margin-left:10%; height: 32px !important;" class="form-control" id="replyReReContent" value="'+content+'"><button class="mt-4 p-2 btn btn-secondary reply-btn" style="right:6%;" onclick="replyReUpdate('+bocommentNo+')">수정</button></div>';
	$(".boast-btn").hide();
  $(obj).hide();  
  $(obj).parent().parent().parent().after($textarea);
}

function replyReUpdate(bocommentNo){	
	var content = $("#replyReReContent").val();	
	$.ajax({
		url : "boastReplyModify.kh",
		type:"post",
		data : {"bocommentNo":bocommentNo,"bocommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList($("#boastNo").val());
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
	
}

function boastDelete(boastNo){	

	if (!confirm("정말 삭제하시겠습니까?")) {
		// 취소(아니오) 버튼 클릭 시 이벤트
			return false;
		} else {
		location.href="boastDelete.kh?boastNo="+boastNo;
		}
}

// 답글달기
function replyReReView(obj,boastNo,bocommentNo,memberNick){	
	if($("#loginNo").val() ==  ""){
		alert('로그인 후 이용가능합니다.');
		return false;
	}
	$textarea = '<div class="span6 row" style="position: relative;"><small class="text-primary" style="position:absolute; top:-65%; left:2%">@'+memberNick+'</small><textarea style="margin-left:10%;" id="emojionearea2" placeholder="답글을 남겨주세요"></textarea></div><div style="position:absolute; right:5.2%; width:100%"><button class="mt-4 p-2 btn btn-secondary reply-btn" style="position: absolute; right:1%;" onclick="replyReRegister('+boastNo+','+bocommentNo+')">답글</button></div>';
	$(".boast-btn").hide();
  $(obj).hide();  
  $(obj).parent().parent().parent().after($textarea);

  $("#emojionearea2").emojioneArea({
	pickerPosition: "top",
	filtersPosition: "bottom",
  tones: false,
  autocomplete: false,
  inline: true,
  hidePickerOnBlur: true
});
}

function replyReRegister(boastNo,bocommentNo){

	var content = $("#emojionearea2").val();
	if(content == ""){
		alert('내용을 입력해주세요.');
		return false;
	}	
	$.ajax({
		url : "boastReReplyRegister.kh",
		type:"post",
		data : {"boastNo":boastNo,"bocommentNo":bocommentNo,"bocommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(boastNo);
			$("#emojionearea2").val("");
			$('.emojionearea-editor').text('');
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}

function getLikeCount(){
	var count = 1;
	var boastNo = $("#boastNo").val();
	
	$.ajax({
		url : "getLikeCount.kh",
		type:"get",
		data : {"boastNo":boastNo},		
		success : function(data){			
			if(data > 0){
				$("#boast-like").html('<span class="fas fa-heart"> '+data+'</span>');

			}else{
				$("#boast-like").html('<span class="far fa-heart"> '+data+'</span>');
			}
		  
		},
		error : function(){
		  console.log('fail');
		}
	});
}

function clickLike(){

	var boastNo = $("#boastNo").val();
	var memberNo = $("#loginNo").val();
	
	$.ajax({
		url : "boastLike.kh",
		type:"get",
		data : {"boastNo":boastNo,"memberNo":memberNo},		
		success : function(data){					 			
			likeCheck();
			getLikeCount();
		},
		error : function(){
		  console.log('fail');
		}
	});
}

function likeCheck(){
	var boastNo = $("#boastNo").val();
	var memberNo = $("#loginNo").val();
	$.ajax({
		url : "getLikeCheck.kh",
		type:"get",
		data : {"boastNo":boastNo,"memberNo":memberNo},		
		success : function(data){
						 
			if(data > 0){
				$("#like-btn").html('<span onclick="clickLike()" class="p-3" style="margin-bottom: 0px">좋아요 취소<span>');
			}else{
				$("#like-btn").html('<span onclick="clickLike()" class="p-3" style="margin-bottom: 0px">좋아요</span>');
			}
		  
		},
		error : function(){
		  console.log('fail');
		}
	});
}
