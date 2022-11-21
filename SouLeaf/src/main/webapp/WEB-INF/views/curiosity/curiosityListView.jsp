<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 궁금해요</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/curiosity/curiosity-style.css">
</head>
<body>

  <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_38.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">궁금해요</h1>
          </div>
        </div>
      </div>
    </section>
    
    <section class="ftco-section ftco-degree-bg">
      <div class="container">
              <h2 class="heading-section" align="center" style="margin-bottom:50px">식물이름이 궁금해요!</h2>
        <div class="row" id="curiosity-list" style="min-height: 450px;">
        <input type="hidden" id="currentPage" value="${page }">
         <input type="hidden" id="currentCount" value="${count }">
       <!--    <div class="col-lg-6 sidebar pl-lg-5 ftco-animate">        
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4" style="background-image: url(resources/images/image_1.jpg);"></a>
                <div class="text">
                  <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a></h3>
                  <div class="meta">
                    <div><span class="icon-calendar"></span> April 7, 2020</div>
                    <div><span class="icon-person"></span> Admin</div>
                    <div><span class="icon-chat"></span> 19</div>
                  </div>
                </div>
              </div>      
         </div>
         -->
         
           </div>
           <button class="btn btn-primary" style="float: right;" onclick="location.href='curiosityWrite.kh'">글쓰기</button>
           				 <div class="row mt-5">
				          <div class="col text-center">
				            <div class="block-27">
				              <ul id="curiosity-page">
				                <li><a href="#">&lt;</a></li>
				                <li class="active"><span>1</span></li>
				                <li><a href="#">2</a></li>
				                <li><a href="#">3</a></li>
				                <li><a href="#">4</a></li>
				                <li><a href="#">5</a></li>
				                <li><a href="#">&gt;</a></li>
				              </ul>
				            </div>
				          </div>
				        </div>
           
          </div>
         </section>
   

<jsp:include page="../common/footer.jsp"></jsp:include>
 <script src="resources/js/curiosity/curiosity-list.js"></script>
</body>
</html>