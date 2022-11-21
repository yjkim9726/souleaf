<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물자랑</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/boast/boast-style.css">
</head>
<body>

 
          
 <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_37.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">자랑하기</h1>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section bg-light">
      <div class="container">
        <h2 class="heading-section" align="center" style="margin-bottom:50px">반려식물을 자랑해봐요!</h2>
        <div class="row d-flex" id="boast-list" style="min-height: 450px;">
         <input type="hidden" id="currentPage" value="${page }">
         <input type="hidden" id="currentCount" value="${count }">
         <!--  <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a href="blog-single.html" class="block-20 rounded" style="background-image: url('images/image_1.jpg');">
              </a>
              <div class="text p-4">
              	<div class="meta mb-2">
                  <div><a href="#">April 07, 2020</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                </div>
                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a></h3>
              </div>
            </div>
          </div> -->
          
          <c:forEach items="${bList }" var="boast" varStatus="status">
	          <div class="col-md-3 d-flex ftco-animate">
	            <div class="blog-entry align-self-stretch">
	            	<c:if test="${boast.boastFileRename ne null }">
	              <a href="boastDetail.kh?boastNo=${boast.boastNo }" class="block-20 rounded" style="background-image: url('resources/uploadFiles/boast/${boast.boastFileRename}');"></a>
	              </c:if>
	               <c:if test="${boast.boastFileRename eq  null }">
	              <a href="boastDetail.kh?boastNo=${boast.boastNo }" class="block-20 rounded" style="background-image: url('resources/uploadFiles/boast/defaultplant.png');"></a>
	               </c:if>
	              <div class="text p-4">
	              	<div class="meta mb-2">
	              	  <div>${boast.memberNick}</div>
	                  <div>${boast.boastDate }</div><br>
	              	  <div class=""><span class="far fa-eye"></span> ${boast.boastCount }</div>
	                  <div class=""><span class="fa fa-comment"></span> ${boast.boastReplyCount } </div>
	                     <div class=""><span class="fas fa-heart"></span> ${boast.boastLike }</div>	                     
	                </div>
	                <h3 class="heading boast-title"><a href="boastDetail.kh?boastNo=${boast.boastNo }">${boast.boastTitle }</a></h3>
	              <%--   <div class="meta mb-2">
	                  <div>${boast.memberNick}</div>
	                  <div>${boast.boastDate }</div>
                  </div> --%>
	              	<h6 class="text-success" style="font-size: 12px"><a href="plantDetailName.kh?plantName=${boast.plantName}">#${boast.plantName }</a></h6>
	              </div>
	              
	            </div>
	          </div>
          </c:forEach>
        </div>
        	<c:if test="${loginUser ne null }">
            	<button class="btn btn-primary" style="float: right;" onclick="location.href='boastWrite.kh?userNo=${loginUser.memberNo}'">글쓰기</button>
        	</c:if>
        	<c:if test="${loginUser eq null }">
            <button class="btn btn-primary" style="float: right;" onclick="location.href='boastWrite.kh'">글쓰기</button>
        	</c:if>
       
       <!-- 페이징 처리 -->
        <div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
            
               <ul>
               <!--  <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&gt;</a></li>
               -->
        <!-- 이전 -->
        <c:url var="before" value="boastListView.kh">
					<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
				</c:url>
				<c:if test="${pi.currentPage <= 1 }">
					<li><a href="#">&lt;</a></li>
				</c:if>
				<c:if test="${pi.currentPage > 1 }">
					<li><a href="${before }">&lt;</a></li> 
				</c:if>
				<!-- 페이지 -->
        <c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:url var="pagination" value="boastListView.kh">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<c:if test="${p eq pi.currentPage }">
					<li class="active"><span>${p }</span></li>
						
					</c:if>
					<c:if test="${p ne pi.currentPage }">
					<li><a href="${pagination }">${p }</a></li>
					</c:if>
				</c:forEach>
				<!-- 다음 -->
				<c:url var="after" value="boastListView.kh">
					<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
				</c:url>
				<c:if test="${pi.currentPage >= pi.maxPage }">
					<li><a href="#">&gt;</a></li>
				</c:if>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<li><a href="${after }">&gt;</a></li>
				</c:if>
				</ul>
            </div>
          </div>
        </div>
      </div>
    </section>  
        
      
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>