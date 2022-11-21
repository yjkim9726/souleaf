
$(function(){ // code insert
	$(".classId").keyup(function() {
		var idValue = $("#id").val();
		 var regExp = /^[a-z|A-z|0-9]{4,10}$/;
			if(!regExp.test(idValue)){
				$("#checkId").html("아이디는 영소문자,숫자 4~10자리입니다.").css("color" ,"red");
				return false;
			}
			else {
				$.ajax({
				   url :"/idCheck.kh",
				   type:"post",
				   data: {"memberId": idValue},
					success : function(data) {
						if(data != 0){
							$("#checkId").html("가입된 아이디 입니다").css("color" ,"green");
						}else if(data == 0){
							$("#checkId").html("존재하지 않는 아이디 입니다").css("color" ,"red");
						}

					}
			   });
			}
	});
		
	 $("#signbtn").on("click",function(){
	 	if($('#isEmailAuthSuccess').val() != 'success'){
	// 		alert('이메일 인증을 진행해주셔야 회원가입이 완료됩니다.');
	 		return;
	 	}
		
	 });

	 $('#emailAuthenticate').on("click", function(){
	
	 	$.ajax({
	 		url :"emailAuthCheck.kh",
	 		type:"post",
	 		data: {"memberMail": $("#email").val()},
	 		success : function(data) {
	 			var date = new Date();
	 			date.setTime(date.getTime() + 3*60*1000); // 3분 뒤 만료.
	 			//$.cookie('authKeyValue', data, { expires: date });
	 			document.cookie = "authKeyValue" + "=" + data + "; path=/; expires=" + date.toGMTString() + ";";
	 			window.open('http://localhost:8888/emailAuthenticateView.kh', '이메일인증창', 'width=700px,height=800px,scrollbars=yes');
	 		}  
			
	 	});
	
	 });

	// $("#password").on("keyup",function(){
	// 	var passwordVal = $("#password").val();
	// 	var regExp = /^[a-z|A-z|0-9]{4,10}$/;
	// 	if(!regExp.test(passwordVal)){
	// 		$("#passwordCheck").html("비밀번호는 영소문자,숫자 4~10자리입니다.").css("color" ,"red");
	// 		return false;
	// 	} 
	// });
	// $("#password1").on("keyup",function(){
	// 	if($("#password").val() != $("#password1").val() && $("#password").val()!= ""){
	// 		$("#passwordCheck").html("패스워드가 일치하지 않습니다").css("color" ,"red");
	// 	}else{
	// 		$("#passwordCheck").html("");
	// 	}		
	// });
         
	// $("#nick").keyup(function() {
	// 	var nickVal = $("#nick").val();
	// 	var regExp = /[a-z|A-z|0-9|가-힣]{2,6}/;
	// 	if(!regExp.test(nickVal)){
	// 		$("#checkNick").html("닉네임은 2~6자리만 가능합니다.").css("color" ,"red");
	// 		return false;
	// 	}else {
	// 		$.ajax({
	// 			url :"/nickCheck.kh",
	// 			type:"post",
	// 			data: {"memberNick": nickVal},
	// 			success : function(data) {
	// 				if(data != 0){
	// 				$("#checkNick").html("중복된 닉네임 입니다").css("color" ,"red");
	// 				}else {
	// 				$("#checkNick").html("사용 가능한 닉네임 입니다").css("color" ,"green");
	// 				}
	// 			}  
	
				
	// 		});

	// 	}
					
	// });
});
				
 
	       	
	        
	       
	     	
	
				
		
