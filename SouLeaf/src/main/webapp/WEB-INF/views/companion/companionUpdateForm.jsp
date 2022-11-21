<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 반려식물 관리</title>
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

.blockstyle {
	margin-bottom: 30px;
}

.backcolor {
	float: right;
	background-color: #ffffff;
	margin-left: 13px;
}

</style>
</head>
<body>
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">반려 식물 관리</h2>
				</div>
			</div>
			<div class="row justify-content-center blockstyle">
				<div class="col-md-12">
					<button type="button" id="registerbutton" class="btn btn-outline-success backcolor" onclick="location.href='companionListView.kh'">뒤로가기</button>
				</div>
			</div>
			<div class="row justify-content-center blockstyle">
				<div class="col-md-12">
					<div class="wrapper">
						<div class="row no-gutters writeStyle">
							<div class="col-md-7">
								<div class="contact-wrap w-100 p-md-5 p-4"
									style="height: 470px;">
									<form action="companionUpdate.kh" method="POST"
										id="contactForm" name="contactForm" class="contactForm"
										enctype="multipart/form-data">
										<input type="hidden" value="${loginUser.memberNo}" name="memberNo" id="memberNo">
										<input type="hidden" id="companionNo" name="companionNo" value="${companion.companionNo }">
										<input type="hidden" id="plantNo" name="plantNo" value="${companion.plantNo }">
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<div class="form-group">
														<label class="label" for="plantName">품종</label> <input
															type="text" class="form-control" name="plantName"
															id="plantName" value="${companion.plantName }"
															style="background-color: gary" readonly>
														<div class="top_line"></div>
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="name">애칭</label> <input
														type="text" class="form-control" name="companionNick"
														id="companionNick" value="${companion.companionNick }"
														placeholder="애칭을 입력하세요" maxlength="6">
													<div class="countWord">
														<span id="counter">${nicksize }/6 최대6자 입력</span>
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="subject">마지막 물 준날</label>
													<div class="form-group">
														<div class="input-group date" id="datetimepicker1"
															data-target-input="nearest">
															<input type="text" name="companionLastWater"
																id="lastWater" class="form-control datetimepicker-input"
																data-target="#datetimepicker1"
																value="${companion.companionLastWater }">
															<div class="input-group-append"
																data-target="#datetimepicker1"
																data-toggle="datetimepicker"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="row"
													style="margin-left: 0px; margin-right: 0px;">
													<div class="form-group">
														<div class="input-group">
															<div class="custom-file" style="width: 400px">
																<input type="file" class="file-upload custom-file-input"
																	id="uploadFile" name="uploadFile"
																	aria-describedby="inputGroupFileAddon04"> <label
																	class="custom-file-label" for="uploadFile"> <c:if
																		test="${companion.companionPicName eq null}">
																			Choose file
																		</c:if> <c:if test="${companion.companionPicName ne null}">
																			${companion.companionPicName }
																		</c:if>
																</label>
															</div>
																<button id="companionUpdate" type="submit" class="btn btn-outline-success backcolor" style="margin-left:10px;padding-top: 8px;padding-bottom: 8px;height: 38px; " >수정</button>
																<c:url var="cDelete" value="companionDelete.kh">
																	<c:param name="companionNo" value="${companion.companionNo }"></c:param>
																	<c:param name="companionRepicName" value="${companion.companionRepicName }"></c:param>
																</c:url>
																<a href="${cDelete }"><button type="button"class="btn btn-outline-success backcolor" style="margin-left: 10px; padding-top: 8px; padding-bottom: 8px; height: 38px;">삭제</button></a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="col-md-5 d-flex align-items-stretch">
								<img src="${companion.companionRepicName }" class="avatar"
									alt="avatar"
									style="width: 100%; height: 470px; outline: none; border: none;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script>
		var readURL = function(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('.avatar').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}

		$(".file-upload").on('change', function() {
			readURL(this);
		});

		$("input[type='file']").on(
				'change',
				function(event) {
					$(this).next('.custom-file-label').html(
							event.target.files[0].name);
				});

		$("#lastWater").datepicker({
			format : "yyyy-mm-dd",
			language : "kr"
		});

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