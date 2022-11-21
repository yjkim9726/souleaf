<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물도감</title>
<jsp:include page="../common/loginCheck.jsp"></jsp:include>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/curiosity/curiosity-style.css">
<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">

</head>
<body>

        <section class="ftco-section bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">궁금해요 글쓰기</h2>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
						
							<div class="row no-gutters">
							
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<!-- <h3 class="mb-4">Contact Us</h3> -->
										<form action="curiosityRegister.kh" method="post" enctype="multipart/form-data">
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">제목</label>
														<input type="text" class="form-control" name="curiosityContent" id="curiosityContent" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">내용</label>
														<textarea name="curiosityContents" class="form-control" id="summernote" cols="30" rows="1" placeholder="이 식물 이름이 뭔가요?"></textarea>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<input type="submit" value="등록" class="btn btn-primary">
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
  <script src="resources/js/curiosity/curiosity-detail.js"></script>
</body>
</html>