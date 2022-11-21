<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물자랑</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/curiosity/emojionearea.min.css">
<link rel="stylesheet" href="resources/css/boast/boast-style.css">
</head>
<body>

      <section class="ftco-section bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
					
							<div class="row no-gutters">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
									<h2 class="heading-section p-1 ml-3">${boast.boastTitle }</h2>
									<div class="media p-1 ml-3">
									<c:if test="${boast.memberFileRename eq null }">
										<img src="resources/images/basicMemberImg.png" alt="John Doe"
											class="mr-1 rounded-circle" style="width: 60px; height: 60px">
									</c:if>
									<c:if test="${boast.memberFileRename ne null }">
										<img src="resources/uploadFiles/member/${boast.memberFileRename }" alt="John Doe"
											class="mr-1 rounded-circle" style="width: 60px; height: 60px">
									</c:if>
										<div class="media-body row">
											<div class="dropdown mt-2 col-md-6">
												<button class="btn dropdown-toggle" type="button"
													id="dropdownMenuButton" data-toggle="dropdown"
													aria-haspopup="true" aria-expanded="false"
													style="padding: 12px 10px; font-size: 15px; text-transform: none;">
													${boast.memberNick }</button>
												<div class="dropdown-menu"
													aria-labelledby="dropdownMenuButton">
													<a class="dropdown-item"
														href="diaryMainOtherView.kh?memberDiary=${boast.memberNo }">일기
														보러가기</a> <a class="dropdown-item" href="#">1:1 채팅</a>
												</div>
												${boast.boastDate } &nbsp;&nbsp;<span
													class="far fa-eye"></span> ${boast.boastCount }
												&nbsp;&nbsp;<span class="fa fa-comment"></span> <span
													id="replyCount">0</span>&nbsp;&nbsp;
													<span id="boast-like">0</span> 
											</div>


											<div class="col-md-6">
											<span style="float: right" class="mt-4"><a
												href="boastListView.kh?page=${page }&count=${count}">목록</a>&nbsp;&nbsp;
												<c:if test="${loginUser.memberNo eq boast.memberNo  }">
													<a
														href="boastUpdateView.kh?boastNo=${boast.boastNo }">수정</a>&nbsp;&nbsp;
									    <a href="#" onclick="boastDelete(${boast.boastNo})">삭제</a>
												</c:if> </span>

											</div>
										</div>
										
									</div>
									<hr>
											<div class="row">										
												<div class="col-md-12 contact-wrap w-100 p-md-5 p-3" style="min-height: 300px">
													${boast.boastContents }
												</div>
											</div>
										<hr>
										<input type="hidden" id="loginNo" value="${loginUser.memberNo }">
										<input type="hidden" id="boastNo" value="${boast.boastNo}">
										<span id="like-btn"></span>
									<p class="p-3" style="margin-bottom: 0px"><strong>댓글 <span id="comment-count">0</span>개</strong></p>
									<input type="hidden" id="boastNo" value="${boast.boastNo }">
									<span id="boast-comment"></span>
<!-- <div class="media p-3">
  <div>
  </div>
  <img src="resources/images/gallery-3.jpg" alt="John Doe" class="mr-3 mx-3 mt-2 rounded-circle" style="width:60px; height: 60px">
  <div class="media-body">
   <strong>댓글작성자</strong><br>
   <span>댓글남겨요...</span><br>
   <small>2020-05-27 11:12:12 <a href="" class="text-success">수정</a> <a href="" class="text-danger">삭제</a></small>
  </div>
</div> -->
									<br>
									<div class="row" style="position: relative;justify-content: center;">
									<!-- <input type="text" class="form-control mousetrap" id="replyContent" style="width: 95%; height: 32px !important; " placeholder="댓글을 남겨주세요"   autocomplete="off"> -->
									
									  
									</div>
									<div class="span6 row" style="position: relative;">
    								<textarea id="emojionearea1" placeholder="댓글을 남겨주세요"></textarea>
    								<button class="mt-4 p-2 btn reply-btn btn-success" onclick="replyRegister(${boast.boastNo})">등록</button>
									</div>
									<div id="hashTag" class="hashTagForm" style="display: none;">
									<input type="text" id="hashTagSearch" class="mousetrap"  style="color: #fff; border: 0px; position: absolute;" autocomplete="off"><br>
									<span id="hashTagText"  style="display: none"></span><br>
									<span id="hashTagResult" class="hashTagSearchForm" style="position: absolute; top:0">#</span> 
									</div>
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
  <script type="text/javascript" src="resources/js/curiosity/emojionearea.min.js"></script>
  <script src="resources/js/boast/boast-detail.js"></script>
</body>
</html>