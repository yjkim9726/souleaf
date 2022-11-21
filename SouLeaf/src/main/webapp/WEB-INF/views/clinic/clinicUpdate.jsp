<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물도감</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/clinic/clinic-style.css">
<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">

</head>
<body>

        <section class="ftco-section bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">궁금해요 글수정</h2>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
						
							<div class="row no-gutters">
							
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<!-- <h3 class="mb-4">Contact Us</h3> -->
										<form action="clinicModify.kh" method="post" enctype="multipart/form-data">
											<div class="row">
										
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">제목</label>
														<input type="text" class="form-control" name="clinicContent" id="clinicContent" value="${clinic.clinicContent }">
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">키우는 장소</label>
														<input type="text" class="form-control" name="clinicPlace" id="clinicPlace" maxlength="10" value="${clinic.clinicPlace }" required>
														<label class="label" for="subject">물 주는 방식</label>
														<input type="text" class="form-control" name="clinicHowWater" id="clinicHowWater" maxlength="20" value="${clinic.clinicHowWater }" required>
														<label class="label" for="subject">마지막 분갈이</label>
														<input type="text" class="form-control" name="clinicLastPot" id="clinicLastPot" maxlength="20" value="${clinic.clinicLastPot }" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">내용</label>
														<textarea name="clinicContents" class="form-control" id="summernote" cols="30" rows="1" placeholder="이 식물 이름이 뭔가요?">${clinic.clinicContents }</textarea>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<input type="hidden" name="page" value="${page }"> 
														<input type="hidden" name="count" value="${count }"> 
														<input type="hidden" name="clinicNo" value="${clinic.clinicNo }">
														<input type="reset" value="취소" class="btn btn-primary" onClick="location.href='clinicDetail.kh?clinicNo=${clinic.clinicNo }&page=${page }&count=${count }'" style="float:right; margin-left: 15px;">
														<input type="submit" value="수정" class="btn btn-primary" style="float:right">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

<jsp:include page="../common/footer.jsp"></jsp:include>
  <script src="resources/js/summernote/summernote-lite.js"></script>
  <script src="resources/js/clinic/clinic-detail.js"></script>
</body>
</html>