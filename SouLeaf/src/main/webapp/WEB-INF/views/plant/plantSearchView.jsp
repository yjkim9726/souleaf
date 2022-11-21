<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물도감</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/plant/plant-style.css">
</head>
<body>

  <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">식물도감 </h1>
          </div>
        </div>
      </div>
    </section>
    
    
    
   <section class="ftco-section bg-light">
			<div class="container">
				<c:if test="${pList eq null }"><div class="mb-3" style="font-size: 30px">찾으시는 식물이 <span class="text-success"><strong>${search }</strong></span> 맞나요?</div></c:if>
			 <form action="plantSearch.kh" method="get" class="search-form">
                <div class="form-group">
                  <span class="fa fa-search"></span>
                  <input type="text" class="form-control plant-search" name="search" placeholder="식물 이름을 검색해 주세요." autocomplete="OFF">
                </div>
              </form>
              <c:if test="${pList eq null }">
              식물데이터 <span id="plant-count">0</span> 건
              </c:if>
              <c:if test="${pList ne null}">
               식물데이터 <span id="plant-count">${pList.size() }</span> 건
               </c:if>
              <br><br>
				<div class="row" id="plant-list">
						<c:if test="${pList eq null }">
						<div style="margin: 0 auto;">검색 결과가 없습니다.</div>
						</c:if>
						<c:forEach items="${pList }" var="pi" varStatus="status">
					<div class="col-md-6 col-lg-3 ftco-animate" onclick="location.href='plantDetail.kh?plantNo=${pi.plantNo}'">
						<div class="staff">
						
							<div class="img-wrap d-flex align-items-stretch">
								<div class="img align-self-stretch" style="background-image: url(resources/uploadFiles/plant/${pi.plantFileRename});"></div>
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<span class="position mb-2">${pi.plantEngname }</span>
								<h3>${pi.plantName }</h3>
								<div class="faded">
	             				 </div>
							</div>
							
						</div>
					</div>
						</c:forEach>
					
				</div>
			</div>
		</section>

<jsp:include page="../common/footer.jsp"></jsp:include>
<!-- <script src="resources/js/plant/plant-list.js"></script> -->
</body>
</html>