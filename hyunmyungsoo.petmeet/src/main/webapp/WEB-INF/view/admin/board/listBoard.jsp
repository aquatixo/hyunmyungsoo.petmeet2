<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='utf-8' isELIgnored='false'%>
<%
	session.removeAttribute("main");
	Object userList = request.getAttribute("userList");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file= '../include/library.jsp' %>
<title>Pet & Meet</title>
</head>
<script>
</script>
<body>
	<div class='container'>
  		<%@ include file= '../include/header.jsp' %>
		<%@ include file= '../include/nav.jsp' %>
        
        
		<div>
			<h3 class='titleFont'>자유게시판</h3>
		</div>
		
		<form>
		
			<table class='table table-hover'>
				<thead class='thead text'>
					<tr class='font'>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody class='text'>
					<c:forEach var="list" items="${boardList}">
						<!--  <tr id="a${list.boardNum}" class="getBoard">-->
						<tr id="a${list.boardNum}" class="getBoard"
						onclick="location.href='/hyunmyungsoo.petmeet/admin/board/view?boardNum=${list.boardNum}'">
							<th><a>${list.boardNum}</a></th>
							<td>${list.boardTitle}</td>
							<td>
								<c:forEach var='user' items='${userList}'>
									<c:if test='${list.userId == user.userId}'>
										${user.userNickname}
									</c:if>
								</c:forEach>
							</td>
							<td>${list.regDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class='form-group row' hidden>
	           <input name='boardNum' type='text' class='form-control' id='${list.boardNum}'
	                  value='${list.boardNum}' />
	        </div>
			
		</form>

</div>
</body>
</html>