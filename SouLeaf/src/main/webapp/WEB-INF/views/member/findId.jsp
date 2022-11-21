<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>souLeaf - 비밀번호 확인</title>
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

.account {
	color: #00bd56;
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
</style>
</head>
<body>
	<div class="container bootstrap snippet">
		<br> <br> <br> <br>
		<div class="row">
			<div class="col-sm-12">
				<h4>
					아이디 찾기<span class="badge badge-secondary"
						style="background-color: #00bd56;"></span>
				</h4>
				<hr>
				<div class="top_line"></div>
				<br> <br> <br> <br>
				<div class="account">
				<center>
					<div class="main findForm">계정 확인</div>
				</center>
				</div>
				<br> <br>
				<div class="container">
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6 findForm">
							<div class="form-floating">
								<div class="form-group pb-3">
									<input type="text" placeholder="이름" name="memberName"
										class="form-control " id="name" >
								</div>
								<div class="form-group pb-3">
									<input type="text" placeholder="이메일" name="memberMail"
										class="form-control" id="email"> 
									<div class="container"></div>
								</div>
								<button type="submit" id="findIdCheck" class="btn btn-block btn-success">확인</button>
							</div>
						</div>
					</div>
						<div class="col-sm-6" id="msgarea">
						<center>
							<span id="msg"></span>
						</center>
						</div>
						<div class="btnarea" align="center"></div>
				</div>
				<br> <br> <br> <br> <br>
				<hr>
				<br> <br> <br> <br> <br>
			</div>
		</div>
		<script
			src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="resources/js/login/findPwView.js"></script>
		<script src="resources/js/login/main.js"></script>
		<script src="resources/js/home/openweather.js"></script>
		<script>
		$("#findIdCheck").on("click",function(){
	 		var memberName = $("#name").val();
			var memberMail = $("#email").val();
			$.ajax({
				url:"findId.kh",
				type : "POST",
				data : {"memberName" : memberName, "memberMail" : memberMail},
				dataType : "json",
				success : function(data){
				 console.log(data);
				 /* data에는 memberchk 혹은 "null" 이 들어왓어요  */
					if(data.memberId != null){
						var $btnarea = $(".btnarea");
						$(".findForm").hide();
						$("#msg").html("<h3>회원님의 아이디는 <span class='text-success'>"+data.memberId+"</span> 입니다.</h3>");
						$btnarea.append("<button type='button' onclick='findPw()'class='btn btn-success'>비밀번호 찾기</button>");
						
					}else if(data == "null"){
						$("#msg").html("일치하는 회원 정보가 없습니다. 다시 확인해주세요.");
					}
				}
			}) 
			
		});
		
		function findPw(){
			location.href='findPwView.kh';
		}
		</script>
</body>
</html>