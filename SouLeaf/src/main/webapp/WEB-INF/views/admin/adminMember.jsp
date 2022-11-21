<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/loginCheck.jsp"></jsp:include>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">
<link href='resources/css/admin/admin-style.css' rel='stylesheet' />
</head>
<body>

    <section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
         <div class="col-lg-3 sidebar pl-lg-5 ftco-animate">
            <div class="sidebar-box">
            <div class="x1 x2"><h3><a href="adminHome.kh">SOULEAF ADMIN</a></h3></div>
            </div>
            <div class="sidebar-box ftco-animate">
              <div class="categories">
                <li><a href="adminPlant.kh" >도감 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminMember.kh" style=" color: #00bd56;">회원 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminBoard.kh">게시글 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminQna.kh">Q&A 관리 <span class="fa fa-chevron-right"></span></a></li>
              </div>
            </div>

          </div>
          
          <div class="col-lg-9 ftco-animate">
          
    
          
           <section class="mt-3" style="position: relative;" >
    	<div class="container">    	  
    	<div align="right" class="custom-search">
    	 <span class="fa fa-search"></span>
	    	<input id="custom-filter" class="plant-search" placeholder="" type="text"/>
    	</div>
        <form action="adminMemberState.kh" method="get">
    		 <table id="dataTable" class="row-border hover" style="width:100%">
        <thead>
            <tr>
                <!-- <th style="text-align: center"><small><input type="checkbox" id="check_all_y" class="checkbox_y"> <input type="checkbox" id="check_all_n" class="checkbox_n"></small></th> -->
                <th>선택</th>
                <th style="text-align: center">이미지</th>
                <th>아이디</th>
                <th>닉네임</th>
                <th>이름</th>
                <th>이메일</th>
                <th>가입일</th>
            </tr>
        </thead>
        <tbody>
                
          <c:forEach items="${mList }" var="mi" varStatus="status">
          <c:if test="${mi.memberStatus eq 'Y' }">
            <tr>
                <td align="center"><input type="checkbox" value="${mi.memberNo }" name="member-check" class="checkbox_group checkbox_y"></td>
                <c:if test="${mi.memberFileRename eq null }">
                <td align="center"><img src="resources/images/basicMemberImg.png" height="30px"></td>                
                </c:if>
                <c:if test="${mi.memberFileRename ne null }">
                <td align="center"><img src="resources/uploadFiles/member/${mi.memberFileRename }" onerror="this.src='resources/images/basicMemberImg.png'" class="member-img"></td>                
                </c:if>
                <td>${mi.memberId }</td>
                <td>${mi.memberNick }</td>
                <td>${mi.memberName }</td>
                <td><small>${mi.memberMail }</small></td>
                <td><small>${mi.memberJoin }</small></td>
            </tr>
          </c:if>
          <c:if test="${mi.memberStatus eq 'N' }">
            <tr style="background: #ff4b4b17">
                <td align="center"><input type="checkbox" value="${mi.memberNo }" name="member-check" class="checkbox_group checkbox_n"></td>
                <c:if test="${mi.memberFileRename eq null }">
                <td align="center"><img src="resources/images/basicMemberImg.png" height="30px"></td>                
                </c:if>
                <c:if test="${mi.memberFileRename ne null }">
                <td align="center"><img src="resources/uploadFiles/member/${mi.memberFileRename }" onerror="this.src='resources/images/basicMemberImg.png'" class="member-img"></td>                
                </c:if>
                <td>${mi.memberId }</td>
                <td>${mi.memberNick }</td>
                <td>${mi.memberName }</td>
                <td><small>${mi.memberMail }</small></td>
                <td><small>${mi.memberJoin }</small></td>
            </tr>
          </c:if>
          </c:forEach>
        </tbody>
        
    </table>
    <div class="custom-btn-form">
	    <input type="submit" class="btn btn-danger checkbox_y" name="status" value="statusN">	    
	    <input type="submit" class="btn btn-success checkbox_n" name="status" value="statusY">	    
    </div>
         <div class="custom-form">회원데이터 ${mList.size()} 건 &nbsp;&nbsp;<small><span class="text-success">활성 : ${mStatus.statusY}</span> <span class="text-danger">&nbsp; 비활성 : ${mStatus.statusN}</span></small> </div> 
        </form>      
         
    	</div>
    </section>

          </div> <!-- .col-md-9 -->
        

        </div>
      </div>
    </section> <!-- .section -->

<jsp:include page="../common/footer.jsp"></jsp:include>  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
<script src="resources/js/admin/admin-member.js"></script>

</body>
</html>