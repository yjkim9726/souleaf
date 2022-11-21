




$(function(){ // code insert
	$(".classId").focusout(function() {
	 $.ajax({
	        url :"/idCheck.kh",
	        type:"post",
	        data: {"memberId": $("#id").val()},
	      success : function(data) {
	          
	           if(data != 0){
	        	$("#checkId").html("중복된 아이디 입니다");
	          }else {
	           $("#checkId").html("사용 가능한 아이디 입니다");
	           }
	      }  

		  
	      });
		  		  
		});

		$("#password").on("keyup",function(){
			passwordCheck();
		  });
		$("#modifybtn").on("click",function(){
			var test = alert("정보수정이 완료되었습니다.");
			
		});
});


		$(".passwordCheck").keyup(function() {
			if($("#password").val() == $("#password1").val()){
			$("#passwordCheck").html("패스워드가 일치합니다");
			}else {
			$("#passwordCheck").html("패스워드가 일치하지 않습니다");
			}
						
		});
		
		$("input[type='file']").on('change',function(event){
		$(this).next('.custom-file-label').html(event.target.files[0].name);
	});

		function passwordCheck(){

		var pw = $("#password").val();
		var num = pw.search(/[0-9]/g);
		var eng = pw.search(/[a-z]/ig);
		var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		var msg = $("#pwMsg");
		if(pw.length < 8 || pw.length > 20){

			msg.text("8자리 ~ 20자리 이내로 입력해주세요.");
			
		}else if(pw.search(/\s/) != -1){
			msg.text("비밀번호는 공백 없이 입력해주세요.");
			
		}else if(num < 0 || eng < 0 || spe < 0 ){
			msg.text("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
			
		}else {
			console.log("통과"); 
			msg.text("");
		}

	}    



 
	       	
	        
	       
	     	
	
	        

