<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물자랑</title>
<jsp:include page="../common/loginCheck.jsp"></jsp:include>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/boast/boast-style.css">
<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">

</head>
<body>
	<c:if test="${empty cList }">
	<script>
		var noList = confirm("등록된 반려식물이 없습니다. 반려식물을 등록하러가시겠습니까?");
	    if(noList == true){
	      location.href="companionListView.kh";
	    }
	</script>
	</c:if>
	
	<section class="ftco-section bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">자랑하기 글쓰기</h2>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
						
							<div class="row no-gutters">
							
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<!-- <h3 class="mb-4">Contact Us</h3> -->
										<form action="boastWrite.kh" method="post" enctype="multipart/form-data">
											<div class="row">
											
											<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">반려식물</label><br>
														<c:if test="${cList ne null }">
															<div class="btn-group btn-group-toggle" data-toggle="buttons">
														<c:forEach items="${cList }" var="companion" varStatus="status">
																<label class="btn btn-outline-success" for="">
																
																	<input type="radio" name="companionNo" id="jb-radio-${companion.companionNo }" value="${companion.companionNo }" required> ${companion.companionNick }
																</label>																
														</c:forEach>
															</div>
														</c:if>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">제목</label>
														<input type="text" class="form-control" name="boastTitle" id="boastTitle" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">내용</label>
														<textarea name="boastContents" class="form-control" id="summernote" cols="30" rows="1" placeholder="내 식물을 자랑해주세요"></textarea>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<input type="submit" value="등록" class="btn btn-primary" id="submit-btn">
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
  <script src="resources/js/boast/boast-detail.js"></script>

</body>
</html>