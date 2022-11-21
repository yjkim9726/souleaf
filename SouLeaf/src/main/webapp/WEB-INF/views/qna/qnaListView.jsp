<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A</title>
 <jsp:include page="../common/header.jsp"></jsp:include> 
<link rel="stylesheet" href="resources/css/qna/qnalist.css">
</head>
<body>
   <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_40.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">Q&A 게시판</h1>
          </div>
        </div>
      </div>
    </section>

  <section class="ftco-section bg-light ftco-faqs">
    	<div class="container">
    		<div class="row">
    			
			
    			<div class="col-lg-12">
    				<div class="heading-section mb-5 mt-5 mt-lg-0">
	            <h2 class="heading-section" align="center" style="margin-bottom:50px">사이트에 궁금한게 있으신가요?</h2>
	            <p></p>
    				</div>
    				<div id="accordion" class="myaccordion w-100" aria-multiselectable="true">
    				
    				<c:forEach items="${qList }" var="qna" varStatus="status">
			
			
			
						  <div class="card">
						    <div class="card-header p-0" id="heading${status.index }" role="tab">
						      <h2 class="mb-0">
						        <button href="#collapse${status.index }" class="d-flex py-3 px-4 align-items-center justify-content-between btn btn-link" data-parent="#accordion" data-toggle="collapse" aria-expanded="false" aria-controls="collapse${status.index }" <c:if test="${qna.ansNo eq null }">disabled</c:if>>
						        	<p class="mb-0">Q : ${qna.qnaContent } <c:if test="${qna.ansNo eq null }"> &nbsp;<span class="badge badge-secondary">답변대기</span></c:if></p>
						        	
						          <i class="fa" aria-hidden="true"></i>
						        </button>
						      </h2>
						    </div>
						    <div class="collapse" id="collapse${status.index }" role="tabpanel" aria-labelledby="heading${status.index }">
						      <c:forEach items="${aList }" var="ans" varStatus="status">
						       <c:if test="${qna.qnaNo eq ans.qnaNo}">
						      <div class="card-body py-3 px-4">A : ${ans.ansContent }
						      </div>
						       </c:if>
						      </c:forEach>
						      	<div id="btn_group">
						  		<%-- <c:if test="${loginUser.memberId eq 'admin' }">
						  				<button id="ansbtn" onclick="location.href='qnaDelete.kh?qnaNo=${qna.qnaNo}'">삭제</button>
								</c:if>
								<c:if test="${loginUser.memberId eq 'admin' }">
										<button class="" id="ansbtn" onclick="location.href='ansWriteView.kh?qnaNo=${qna.qnaNo}'">답변하기</button>
								</c:if>
								<c:if test="${loginUser.memberId ne 'admin' }">
								</c:if> --%>
						      	</div>
						    </div>
						  </div>
						  
                 </c:forEach>
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
        <c:url var="before" value="qnaListView.kh">
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
               <c:url var="pagination" value="qnaListView.kh">
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
            <c:url var="after" value="qnaListView.kh">
               <c:param name="page" value="${pi.currentPage + 1 }"></c:param>
            </c:url>
            <c:if test="${pi.currentPage >= pi.maxPage }">
               <li><a href="#">&gt;</a></li>
            </c:if>
            <c:if test="${pi.currentPage < pi.maxPage }">
               <li><a href="${after }">&gt;</a></li>
            </c:if>
            </ul>

				</td>
			</tr>
				</div>
	        </div>
	         </div>
			<button id="lastbtn" class="" onclick="location.href='qnaWriteView.kh?qnaNo=${qna.qnaNo}'">등록</button>
        </div>
    	</div>
    </section>

 <jsp:include page="../common/footer.jsp"></jsp:include> 
</body>
</html>