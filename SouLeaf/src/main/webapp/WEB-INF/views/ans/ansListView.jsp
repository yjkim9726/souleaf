<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/qna/qnalist.css">
<meta charset="UTF-8">
<title>답변하기</title>
</head>
<body>
 <jsp:include page="../common/header.jsp"></jsp:include> 
 

  <section class="ftco-section bg-light ftco-faqs">
    	<div class="container">
    		<div class="row">
    			
			
    			<div class="col-lg-12">
    				<div class="heading-section mb-5 mt-5 mt-lg-0">
	            <h2 class="mb-3">Frequently Asks Questions</h2>
	            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
    				</div>
    				<div id="accordion" class="myaccordion w-100" aria-multiselectable="true">
    				
    				<c:forEach items="${aList }" var="ans" varStatus="status">
			
			
			
						  <div class="card">
						    <div class="card-header p-0" id="heading${status.index }" role="tab">
						      <h2 class="mb-0">
						        <button href="#collapse${status.index }" class="d-flex py-3 px-4 align-items-center justify-content-between btn btn-link" data-parent="#accordion" data-toggle="collapse" aria-expanded="false" aria-controls="collapse${status.index }">
						        	<p class="mb-0">${qna.qnaTitle }</p>
						          <i class="fa" aria-hidden="true"></i>
						        </button>
						      </h2>
						    </div>
						    <div class="collapse" id="collapse${status.index }" role="tabpanel" aria-labelledby="heading${status.index }">
						      <div class="card-body py-3 px-4">${qna.qnaContent }
						      	<div id="btn_group">
						  
						      	<button id="listbtn1" onclick="location.href='qnaModifyView.kh?qnaNo=${qna.qnaNo}'">수정</button>
						      	<button id="listbtn2" onclick="location.href='qnaDelete.kh?qnaNo=${qna.qnaNo}'">삭제</button>
						      	</div>
						      </div>
						    </div>
						  </div>
                 </c:forEach>
                 <tr align="center" height="20">
					<td colspan="6">
                 	<c:url var="before" value="qnaListView.kh">
					<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
				</c:url>
				<c:if test="${pi.currentPage <= 1 }">
					[이전]&nbsp;
				</c:if>
				<c:if test="${pi.currentPage > 1 }">
					<a href="${before }">[이전]</a>&nbsp;
				</c:if>
				<!-- 페이지 -->
				<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:url var="pagination" value="qnaListView.kh">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<c:if test="${p eq pi.currentPage }">
						<font color="red" size="4">[${p }]</font>
					</c:if>
					<c:if test="${p ne pi.currentPage }">
						<a href="${pagination }">${p }</a>&nbsp;
					</c:if>
				</c:forEach>
				<!-- 다음 -->
				<c:url var="after" value="qnaListView.kh">
					<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
				</c:url>
				<c:if test="${pi.currentPage >= pi.maxPage }">
					[다음]&nbsp;
				</c:if>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<a href="${after }">[다음]</a>&nbsp;
				</c:if>
				</td>
			</tr>
			<button id="lastbtn" class="" onclick="location.href='qnaWriteView.kh?qnaNo=${qna.qnaNo}'">등록</button>
				</div>
	        </div>
        </div>
    	</div>
    </section>

 <jsp:include page="../common/footer.jsp"></jsp:include> 
</body>
</html>