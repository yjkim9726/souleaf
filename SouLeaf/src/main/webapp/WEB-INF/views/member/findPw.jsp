<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 비밀번호 확인</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<style>
.top_line {
position: relative;
    top: -18px;
    background-color: #00bd56;
    width: 21%;
    height: 3px;
    }

.wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.account{
  color:#00bd56;
  font-size: 25px;
}

#msgarea {
	width : inherit;
	height : inherit;
	margin : 30px auto;
	
}
#msg {
 margin : 0;
}
#emailAuthenticate {
background-color:#00bd56
}
.btn-success {
    color: #fff;
    background-color: #28a745;
    border-color: #28a745;
}
</style>
</head>
<body>
	<div class="container bootstrap snippet">
		<br>
		<br>
		<br>
		<br>
		<div class="row">
			<div class="col-sm-12">
					<h4>
					비밀번호 찾기<span class="badge badge-secondary"
						style="background-color: #00bd56;"></span>
				</h4>
				<hr>
				<div class="top_line">
				</div>
				<br>
				<br>
				<br>
				<br>
				<div class="account">
					<center><div class="main">계정 확인</div></center>
				</div>
				<br>
				<br>
				<div class="container">
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<form action="findPwView.kh" method="get">
								<div class="form-floating">
									  <div class="form-group pb-3">   
   										 <input type="text" placeholder="아이디" name="memberId" 
   										 				class="form-control classId" id="id">
								      </div>

										 <div class="form-group pb-3">   
    										<input type="text" placeholder="이메일" name="memberMail" class="form-control" id="email">
										</div>
   										 	<input type="button" placeholder="인증하기" name="memberMailAuthenticate" class="form-control btn-success" id="emailAuthenticate" value="인증하기"  >
								</div>
							</form>
						</div>
						<div class="col-sm-6" id="msgarea">
						<center>
							<span id="msg"></span>
						</center>
						</div>
						<div class="btnarea" align="center"></div>
					</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<hr>
				<br>
				<br>
				<br>
				<br>
				<br>
		</div>
	</div>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
	$(function(){ // code insert
		$('#emailAuthConfirmbtn').on("click", function(){

			var authKeyData;
			if(document.cookie){
		        var array=document.cookie.split('authKeyValue=');
		        if(array.length >= 2){
		            var arraySub=array[1].split(';');
		            authKeyData=arraySub[0];
		        }
	    	}
			
			var inputKeyData = $('#emailAuthKey').val();
			if(authKeyData == null || authKeyData == '' || authKeyData == undefined){
				alert('인증 시간이 만료되었습니다. 다시 진행해주세요.');
				self.close();
			} else if(authKeyData == inputKeyData){
				alert('인증이 완료되었습니다!\n회원가입을 마저 진행해주세요');
				// 인증 확인 진행! >> 구분 값 추가해주기?
				$("#isEmailAuthSuccess", opener.document).val("success");
				self.close();
			} else if(authKeyData != inputKeyData){
				alert('인증번호가 잘못되었습니다.\n확인 후 다시 입력해주세요.');
			}
		});
	});
		$("#emailAuthenticate").on("click",function(){
	 		var memberId = $("#id").val();
			var memberMail = $("#email").val();
			 $.ajax({
				url:"findPw.kh",
				type : "POST",
				data : {"memberId" : memberId, "memberMail" : memberMail},
				dataType : "json",
				success : function(data){
				 console.log(data);
				if(data.memberId != null){
				 
				
					$.ajax({
							url :"emailAuthCheck.kh",
							type:"post",
							data: {"memberMail": $("#email").val()},
							success : function(data) {
							var date = new Date();
							date.setTime(date.getTime() + 3*60*1000); // 3분 뒤 만료.
							//$.cookie('authKeyValue', data, { expires: date });
							document.cookie = "authKeyValue=" + data + "; path=/; expires=" + date.toGMTString();
							window.open('http://localhost:8888/newPwEmail.kh?memberId='+memberId, '이메일인증창', 'width=700px,height=800px,scrollbars=yes');
						}  
						
					}); 
	
						
					}else if(data == "null"){
						$("#msg").html("일치하는 회원 정보가 없습니다. 다시 확인해주세요.");
					}
				}
			});
			
		});
		function confirmPwEmail(){
		/* alert('test'); */	
		}
	</script>
	<script src="resources/js/login/emailAuthenticatePwView.js"></script>
	<script src="resources/js/home/openweather.js"></script>
</body>
</html>