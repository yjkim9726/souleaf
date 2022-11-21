<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 반려식물</title>
<jsp:include page="../common/header.jsp"></jsp:include>

<style>
.single_what_we_do {
	width: 100%;
	height: 150px;
	border: 1px solid #E7E7E7;
	background-color: #ffffff;
	text-align: center;
	padding: 0 35px;
	border-radius: 10px;
	position: relative;
	margin-bottom: 30px;
	-webkit-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
	cursor: pointer;
}

.no-gutters {
	border: 1px solid #E7E7E7;
}

.writeStyle {
	border: 2px solid #00bd56;
}

/* .justify-content-center { */
/* 	margin-bottom: 30px; */
/* } */

.blockstyle {
	margin-bottom: 30px;
}

.top_line {
	position: absolute;
	top: 84px;
	left: 4.5%;
	background-color: #00bd56;
	width: 90%;
	height: 1px;
}

.backcolor {
	float: right;
	background-color: #ffffff;
	margin-left: 13px;
}

#registerForm {
	display:none;
}
/* 스타일 */
.bgLayer {
	display:none;
	position:absolute;
	top:0;
	left:0;
	width:100%; 
	height:100%; 
	background:#000; 
	opacity:.5; 
	filter:alpha(opacity=50); 
	z-index:10;
}

</style>
</head>
<body>
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">반려 식물</h2>
				</div>
			</div>
			<div class="row justify-content-center blockstyle">
				<div class="col-md-12">
<!-- 				<h2>나의 첫번째 반려식물을 등록해보세요!</h2> -->
				<c:if test="${listSize < 1 }">
				<h2 class="heading-section" align="center" style="margin-bottom: 50px">나의 첫번째 반려식물을 등록해보세요!</h2>
				</c:if>
					<c:if test="${listSize lt 3}">
					<button type="button" id="registerbutton" class="btn btn-outline-success backcolor" onclick="showRegister()">등록하기</button>
					</c:if>
				</div>
			</div>
			<!-- 반려 식물 등록폼 -->
			<div id="registerForm">
				<div class="row justify-content-center blockstyle">
					<div class="col-md-12">
						<div class="wrapper">
							<div class="row no-gutters writeStyle">
								<div class="col-md-7">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<form action="companionRegister.kh" method="POST" id="contactForm" name="contactForm" class="contactForm" enctype="multipart/form-data">
										<input type="hidden" value="${loginUser.memberNo}" name="memberNo" id="memberNo">
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">품종</label>
														<div class="col-auto my-1">
															<label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
															<select name="plantNo" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
																<option selected>식물을 선택하세요</option>
																<c:forEach items="${pList }" var="plant">
																	<option id="plantNo" value="${plant.plantNo }">${plant.plantName }</option>
																</c:forEach>
															</select>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">애칭</label>
														<input type="text" class="form-control" name="companionNick" id="companionNick" placeholder="애칭을 입력하세요" maxlength="6">
														<div class="countWord">
															<span id="counter">###</span>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">마지막 물 준날</label>
														<div class="form-group">
															<div class="input-group date" id="datetimepicker1" data-target-input="nearest">
																<input type="text" name="companionLastWater" id="lastWater" class="form-control datetimepicker-input" data-target="#datetimepicker1">
																<div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker"></div>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-12">
												<div class="row"style=" margin-left: 0px; margin-right: 0px;">
													<div class="form-group">
<!-- 														<input type="file" class="text-center center-block file-upload "> -->
														<div class="input-group">
														  <div class="custom-file" style="width:400px">
														    <input type="file" class="file-upload custom-file-input" id="uploadFile" name="uploadFile" aria-describedby="inputGroupFileAddon04">
														    <label class="custom-file-label" for="uploadFile">Choose file</label>
														  </div>
														<button id="companionSubmit" type="submit" class="btn btn-outline-success backcolor" style="margin-left:10px;padding-top: 8px;padding-bottom: 8px;height: 38px; " >등록</button>
														<input id="companionCancel" type="reset"  onclick="hideRegister()" class="btn btn-outline-success backcolor" style="padding-top: 8px;padding-bottom: 8px;height: 38px;"value="취소">
														</div>
													</div>
												</div>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="col-md-5 d-flex align-items-stretch">
									<img src="" class="avatar" alt="avatar" style="width: 100%; height: 470px; outline: none; border: none;">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 반려 식물 리스트 -->
			<c:forEach items="${cList }" var="cList" varStatus="status">
				<div class="row justify-content-center blockstyle">
					<div class="col-md-12">
						<div class="wrapper">
							<div class="row no-gutters">
								<div class="col-md-7">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<form id="contactForm" name="contactForm" class="contactForm">
											<div class="row">
												<div class="col-md-12">
													<div class="row">
														<input type="hidden" id="companionRepicName" name="companionRepicName" value="${cList.companionRepicName }">
														<input type="hidden" id="companionNick" name="companionNick" value="${cList.companionNick }">
														<h3 class="mb-4">${cList.companionNick }</h3>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="plantName">품종</label>
														<input type="text" class="form-control" name="plantName" id="plantName" value="${cList.plantName }" readonly>
														<div class="top_line"></div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="regist">등록일</label>
														<input type="text" class="form-control" name="regist" id="regist" value="${cList.companionDate }" readonly>
														<div class="top_line"></div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">마지막 물 준날</label>
															<input type="text" class="form-control" name="lastWater" id="lastWater" value="${cList.companionLastWater }" readonly>
															<div class="top_line"></div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">tip!</label> <input
															type="text" class="form-control" name="subject"
															id="subject" value="${cList.plantWater } 일 마다 물줘!"
															readonly>
														<div class="top_line"></div>
													</div>
												</div>
												<div class="col-md-12">
													<c:url var="cUpdate" value="companionUpdateForm.kh">
														<c:param name="companionNo" value="${cList.companionNo }"></c:param>
													</c:url>
													<a href="${cUpdate }"><button type="button"class="btn btn-outline-success backcolor" style="margin-left: 10px; padding-top: 8px; padding-bottom: 8px; height: 38px;">관리</button></a>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="col-md-5 d-flex align-items-stretch">
									<img src="${cList.companionRepicName }" class="" alt="" style="width: 100%; height: 403px; outline: none; border: none;">
<%-- 									<div class="info-wrap w-100 p-5 img" style="background-image: url(${cList.companionRepicName });"></div> --%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script>
	var readURL = function(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function (e) {
				$('.avatar').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	$(".file-upload").on('change', function(){
		readURL(this);
	});
	
	$("input[type='file']").on('change',function(event){
		$(this).next('.custom-file-label').html(event.target.files[0].name);
	});
	
	$("#lastWater").datepicker({
		format : "yyyy-mm-dd",
		language : "kr"
	}).datepicker("setDate", new Date());
		
	function showRegister(val){
	      if($('#registerForm').css('display') == 'none'){
	      $('#registerForm').show();
	      $('#registerbutton').hide();
	      $('.avatar').attr('src', 'resources/images/main_bg_4.jpg');
	      $("input[type='file']").next('.custom-file-label').html("파일을 선택하세요");
	    }
	}
	
	function hideRegister(){
	      if($('#registerForm').css('display') != 'none'){
	      $('#registerForm').hide();
	      $('#registerbutton').show();
	    }
	}

	$(function() {
			$('#companionNick').keyup(function(e) {
			var companionNick = $(this).val();
			$(this).height(((companionNick.split('\n').length + 1) * 1.5)+ 'em');
			$('#counter').html(companionNick.length + '/6 최대6자 입력');});
		$('#companionNick').keyup();
	});

	</script>
</body>
</html>