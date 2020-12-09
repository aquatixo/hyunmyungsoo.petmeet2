<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file= '../include/library.jsp' %>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<title>Pet & Meet</title>
</head>
<script>
$(() => {
	$('#animalType').click(function(){
		var choice = $('#animalType option:selected').val();
		if(choice == '강아지') {
			$('#dogType').removeAttr('hidden');
		}
		
		else if(choice == '고양이'){
			$('#dogType').attr('hidden', 'true');
		}
	});
});

$(function() {
	  $('input[name="daterange"]').daterangepicker({
	    opens: 'left'
	  }, function(start, end, label) {
	    console.log($('input[name="daterange"]').val());
	  });
	});
</script>
<%
	Object userId = session.getAttribute("userEmail");
	Object sitter = request.getAttribute("sitter");
%>
<body>
	<div class='container'>
		<%@ include file='../include/header.jsp'%>
		<%@ include file='../include/nav.jsp'%>
		<div>
			<h3 class='titleFont'>펫 시터 등록 관리</h3>
		</div>
		<hr class='color'>

		<form id='sitterInForm justify-content-center mt-3' method='post'
			enctype='multipart/form-data'>
			<div class='form-row'>
				<div class='form-group col-4'>
					<div class='custom-file'>
						<input name='attachFile' type='file' class='custom-file-input'
							id='attachFile'  /> <label class='custom-file-label'
							for='attachFile'>파일찾기</label>
					</div>
				</div>
			</div>

			<div class='form-group row' hidden>
				<input name='userId' type='text' class='form-control' id='userId'
					value='<%=userId%>' />
			</div>

			<input type='text' name='sitterTitle' class='form-control col-12 mt-3 font color'
				id='sitterTitle' value='${sitter.sitterTitle }' />
			<textarea class='form-control mt-2 col-12 font color' name='sitterContent' 
				id='sitterContent'>${sitter.sitterContent }</textarea>

			<div class='form-group row sitterOption mt-2 mb-0'>
				<select id='animalType' name='sitterPetType'
					class='form-control col-4 ml-3 font color'>
					<option value='${sitter.sitterPetType }' selected disabled hidden>${sitter.sitterPetType }</option>
					<option>강아지</option>
					<option>고양이</option>
				</select> <select id='dogType' name='sitterPetSize'
					class='form-control col-4 ml-1 font color'>
					<option value='${sitter.sitterPetSize }' selected disabled hidden>${sitter.sitterPetSize }</option>
					<option>대형견</option>
					<option>중형견</option>
					<option>소형견</option>
				</select>
			</div>

			<div class='form-group row sitterOption mt-2'>
				<label for='sitterLocation' class='col-2 font mt-1 mr-0 pr-0'>위치 입력</label>
				<input type='text' class='form-control col-2 font color' name='sitterLocSi'
						id='sitterLocation' value='${sitter.sitterLocSi }' maxlength='10' required /><label class='font mt-1'>시</label>
				<input type='text' class='form-control col-2 ml-3 font color' name='sitterLocGu'
						id='sitterLocation' value='${sitter.sitterLocGu }' maxlength='10' required /><label class='font mt-1'>구</label>
				<input type='text' class='form-control col-2 ml-3 font color' name='sitterLocDong'
						id='sitterLocation' value='${sitter.sitterLocDong }' maxlength='10' required /><label class='font mt-1'>동</label>
			</div>	
				
			<div class='row sitterOption mt-2'>
					<label for='sitterDate' class='col-2 font mt-1 mr-0 pr-0'>기간 선택</label>
					<input id='sitterDate' type="text" name="daterange" placeholder='기간을 입력하세요.' class='form-contrl col-5  font color' id='sitterDate' required />
			</div>
			<hr class='color'>

			<div class='form-group row justify-content-end mt-4'>
				<button type='button' class='btn btn-outline-info mr-2 font'
					data-toggle='modal' data-dismiss='modal'
					data-target='#sitterFixMod'>수정</button>
				<button type='button' class='btn btn-outline-danger mr-2 font'
					data-toggle='modal' data-dismiss='modal'
					data-target='#sitterDelMod'>삭제</button>
				<a href='../common/mypage.html'
					class='btn btn-outline-secondary font'>취소</a>
			</div>

			<div class='modal fade' id='sitterFixMod' tabindex='-1'>
				<div class='modal-dialog'>
					<div class='modal-content'>
						<div class='modal-body '>
							<p class='text-center'>게시물을 수정하겠습니까?</p>
							<div class='row justify-content-center'>
                  				<button type='submit' class='btn btn-primary submitBtn mr-2' >확인</button>
                  				<button type='button' class='btn btn-secondary' data-dismiss='modal'>취소</button>
              				</div>
						</div>
					</div>
				</div>
			</div>
		</form>

		<div class='modal fade' id='sitterDelMod' tabindex='-1'>
			<div class='modal-dialog'>
				<div class='modal-content'>
					<div class='modal-body '>
						<p class='text-center'>게시물을 삭제하겠습니까?</p>
						<div class='text-center'>
							<a href='../common/mypage.html' class='btn btn-primary'>확인</a> <a
								href='#' class='btn btn-secondary' data-dismiss='modal'>취소</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file='../include/footer.jsp'%>
	</div>
</body>