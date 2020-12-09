<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='utf-8' isELIgnored='false'%>
<%
	session.removeAttribute("main");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= '../include/library.jsp' %>
<title>Pet & Meet</title>
<script>
$(() => {
   
   $('.backBtn').click(() => {
	   location.href='../message/messageList';
   });
   
   $('#delete').click(() =>{
	   location.href='../message/messageList';
 });
   
   $('.msgBtn').on("click", function() {
       $(".right").append("하고 싶은 말 있으면 해봐");//하고 싶은 말 안에 데이터 베이스 상의 그게 와야댐
   });
   
});
</script>
</head>
<body>
<div class='container'>
  	<%@ include file= '../include/header.jsp' %>
	<%@ include file= '../include/nav.jsp' %>
	
		<div class='container msgMain'>
		   <div class=' row msgInHeader'>
		      <div class='col-7'>
		         <button class='btn backBtn'>
		            <span> <svg width='1em' height='1em' viewBox='0 0 16 16'
		                  class='bi bi-arrow-left-square' fill='currentColor'
		                  xmlns='http://www.w3.org/2000/svg'>
		                 <path fill-rule='evenodd'
		                     d='M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z' />
		                 <path fill-rule='evenodd'
		                     d='M12 8a.5.5 0 0 1-.5.5H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5a.5.5 0 0 1 .5.5z' />
		               </svg>
		            </span>
		         </button>
		         <span>${param.nickName }</span>
		      </div>
		      <div class='offset-3 justify-content-end'>
		         <button class='btn deleteBtn' data-toggle='modal' data-target='#delMsg'>
		         <svg width='1em' height='1em' viewBox='0 0 16 16'
		               class='bi bi-trash' fill='currentColor'
		               xmlns='http://www.w3.org/2000/svg'>
		              <path
		                  d='M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z' />
		              <path fill-rule='evenodd'
		                  d='M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z' />
		            </svg>
		         </button>
		      </div>
		   </div>
   
         <div id='delMsg' class='modal fade' tabindex='-1'>
         <div class='modal-dialog'>
            <div class='modal-content'>
               <div class='modal-body'>
                  <div class='row justify-content-center'>
                     <p>메시지를 삭제 하겠습니까?</p>
                  </div>
                  <div class='row justify-content-center'>
                     <button type='button' class='btn btn-primary' data-dismiss='modal' id='delete'>확인</button>
                     <button type='submit' class='btn btn-secondary ml-2' data-dismiss='modal' id='cancle'>취소</button>
                  </div>
               </div>
            </div>
         </div>
      </div>
   
   <!-- msg head -->
   <div class='msgContent scroll2'>
      <div>
         <div class='msg receive font'>강아지 데리러 5시쯤 갈게요!</div>
      </div>
      
      <div class='right'>
         <div class='msg send font'>
         	하고 싶은 말 있으면 해봐
         </div>
      </div>
      
      </div>
   
   
   <div class='row msgIn'>
      <div class='col-10 msgInBlock'>
         <input class='form-control InMsgCon' type='text' placeholder='내용을 입력하세요'>
      </div>

      <div class='col-2'>
         <button class='btn msgBtn'>send</button>
      </div>
   </div>
   
 </div>
   	<%@ include file= '../include/footer.jsp' %>
</div>
</body>
</html>