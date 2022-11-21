$(function(){
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
		 getReplyList($("#curiosityNo").val());
		 getHashtagLink();

		 $("#replyContent").on("keypress",function(key){
			
			if(key.keyCode==13) {
				replyRegister($("#curiosityNo").val());
			}
			if(key.keyCode==32) {
			
				$("#replyContent").focus();	
				setTimeout(function() { 
					$("#hashTagSearch").val("");	
					$("#hashTagResult").text("#");	
				},200);
				$("#hashTag").hide();
			}
		
		});

	
			
			Mousetrap.bind('shift+3', function(e) {				
				getHashTag();
			});
			// Mousetrap.bind('space', function(e) {				
			// 	$("#hashTag").hide();
			// 	$("#replyContent").focus();	
			// 	$("#hashTagSearch").val("");			
			// });
			// Mousetrap.bind('backspace', function(e) {				
			// 	$("#hashTag").hide();
			// });
	
	
});
function getHashTag(){
	var reply = $("#replyContent").val();
	//var text = $("#hashTagText").text();
	$("#hashTagText").text(reply);
	$("#hashTag").show();	
	$("#hashTagSearch").focus();
	
	$("#hashTagSearch").on("keyup",function(key){
		if(key.keyCode==8 && $("#hashTagSearch").val().length==0){
			$("#replyContent").focus();	
			$("#hashTag").hide();
		}
		if(key.keyCode==32) {
			
			$("#replyContent").focus();	
	    	setTimeout(function() { 
				$("#hashTagSearch").val("");	
				$("#hashTagResult").text("#");	
			},200);
			$("#hashTag").hide();
		}
		var search = $("#hashTagSearch").val();		
		$("#replyContent").val(function(){
			return $("#hashTagText").text() + search;
		});
		if(search.length > 0){

				$.ajax({
					url:"getHashTag.kh",
					tyle:"get",
					data:{"tagName":search},
					dataType:"json",
					success:function(data){
						
						var str = "";
						if(data.length > 0){
							
							for(var i in data){
								str+='<span class="hashTagPlant"onmouseover="chageColor(this)"onmouseout="chageDefaultColor(this)" onclick="insertText(\''+data[i].plantName+'\')">'+data[i].plantName+'<br></span>';
							}
						}else{
							str='검색결과가 없습니다';
						}
						$("#hashTagResult").html(str);
						}
						
				});
		}
	
	});

}
function insertText(plantName){
	$("#replyContent").val($("#hashTagText").text()+"#"+plantName+" ");
	$("#replyContent").focus();	
	$("#hashTagSearch").val("");
	$("#hashTag").hide();
}
function chageColor(obj){
	$(obj).css("color","#00bd56");
}
function chageDefaultColor(obj){
	$(obj).css("color","#808080");
}
/**
	* 이미지 파일 업로드
	*/
	function sendFile(file, el) {
		var form_data = new FormData();
		form_data.append('file', file);
		$.ajax({
			data: form_data,
			type : "post",
			url: 'summer_image.kh',
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

function replyRegister(curiosityNo){
	if($("#loginNo").val() == ""){
		alert("로그인 후 사용가능합니다.");
		return false;
	}	
	var content = $("#replyContent").val();
	if(content == ""){
		alert('내용을 입력해주세요.');
		return false;
	}
	$.ajax({
		url : "curiosityReplyRegister.kh",
		type:"post",
		data : {"curiosityNo":curiosityNo,"curicommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(curiosityNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}

function replyModifyView(obj,curiosityNo,memberNo,replyNo,content){	
    $textarea = '<div class="row" style="position: relative;"><input type="text" style="width: 80%; margin-left:10%; height: 32px !important;" class="form-control" id="replyReContent" value="'+content+'"><button class="mt-4 p-2 btn btn-secondary reply-btn" style="right:6%;" onclick="replyUpdate('+curiosityNo+','+memberNo+','+replyNo+')">수정</button></div>';
	$(".curiosity-btn").hide();
  $(obj).hide();  
  $(obj).parent().parent().parent().after($textarea);
}

function replyUpdate(curiosityNo,memberNo,replyNo){	
	var content = $("#replyReContent").val();
	$.ajax({
		url : "curiosityReplyModify.kh",
		type:"post",
		data : {"curiosityNo":curiosityNo,"memberNo":memberNo,"curicommentNo":replyNo,"curicommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(curiosityNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
	
}

function getReplyList(curiosityNo){	
	var loginNo = $("#loginNo").val();
	$.ajax({
		url : "curiosityReplyList.kh",
		type:"get",
		data : {"curiosityNo":curiosityNo},	
		dataType:"json",	
		success : function(data){
				
			var str = "";
			if(data.length > 0){
				$("#comment-count").text(data.length);
				$("#replyCount").text(data.length);
		
		 for(var i in data){
			str+='<div class="media p-3">';
			if(data[i].memberFileRename == null){
				str+='<img src="resources/images/basicMemberImg.png" alt="image" class="mr-3 mt-2 rounded-circle" style="width:60px; height: 60px">';	
			}else{
				str+='<img src="/resources/uploadFiles/member/'+data[i].memberFileRename+'" alt="img" onerror="this.src=\'resources/images/basicMemberImg.png\'" class="mr-3 mt-2 rounded-circle" style="width:60px; height: 60px">';
			}			
			str+='<div class="media-body">';
			str+='<strong>'+data[i].memberNick+'</strong><br>';
			str+='<span class="entry">'+data[i].curicommentContent+'</span><br>';
            if(loginNo == data[i].memberNo){
				str+='<small>'+data[i].curicommentDate+' <span onclick="replyModifyView(this,'+data[i].curiosityNo+','+data[i].memberNo+','+data[i].curicommentNo+',\''+data[i].curicommentContent+'\')" class="text-success curiosity-btn">수정</span> <span onclick="replyDelete('+data[i].curicommentNo+')" class="text-danger curiosity-btn">삭제</span></small><br>';

			}else{
				str+='<small>'+data[i].curicommentDate+'</small><br>';
			}

			str+='</div>';
			str+='</div>';
		 }
		
		  $("#curiosity-comment").html(str);
		}
		},
		error : function(){
		  console.log('fail');
		},
		complete: function(){
			getHashtagLink();
		}
	
	  });
}

function replyDelete(curicommentNo){
	if (!confirm("정말 삭제하시겠습니까?")) {
		// 취소(아니오) 버튼 클릭 시 이벤트
			return false;
		} else {
			$.ajax({
				url:"curiosityReplyDelete.kh",
				type:"get",
				data:{"curicommentNo":curicommentNo},
				success: function(result){
					console.log(result);
					if(result > 0){
						getReplyList($("#curiosityNo").val());
					}
				},
				error: function(){
					console.log('fail');
				}
			});
		}
	
}

function getHashtagLink(){

	var siteURL = 'plantDetailName.kh?plantName=';
	
	entries = $('.entry');
	var tag = $('.entry:contains(#)').text();	
	var tagText = tag.split("#");		
	
	if ( entries.length > 0 ) {
		
		entries.each(function(i){
	  
	  contents = $(this).text().replace(/#(\S+)/g,'<a href="'+siteURL+'$1" title="$1">#$1</a>');
	
	$(this).html(contents);
	
 	 });
  
	}
}

function curiosityDelete(curiosityNo,page,count){	
	console.log(page);
	console.log(count);
	if (!confirm("정말 삭제하시겠습니까?")) {
		// 취소(아니오) 버튼 클릭 시 이벤트
			return false;
		} else {
		location.href="curiosityDelete.kh?curiosityNo="+curiosityNo+"&page="+page+"&count="+count;
		}
}