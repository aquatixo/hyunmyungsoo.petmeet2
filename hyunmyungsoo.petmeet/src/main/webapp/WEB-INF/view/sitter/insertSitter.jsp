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
function showImg(input) {
	   if(input.files[0]) { // 파일이 있는지 확인
	      let reader = new FileReader();
	                     // load이벤트가 발생하면 실행되는 리스너 callback
	      reader.addEventListener('load', () => {
	         $('#previewImg').attr('src', reader.result); // img미리보기가 나타남
	      }, false) // 자바스크립트가 제공하는 리스너
	      
	      reader.readAsDataURL(input.files[0]); // 선택한 파일을 읽어들인다.
	   }
	}	
$(() => {
	   $('input').change(function() {
	      showImg(this);
	   });
	});	
</script>
<%
	Object userId = session.getAttribute("userEmail");
%>
<body>
	<div class='container'>
		<%@ include file= '../include/header.jsp' %>
		<%@ include file= '../include/nav.jsp' %>
		<div>
			<h3 class='titleFont'>펫 시터 등록</h3>
		</div>
		<hr class='color'>

<!-- 		<div class='sitterInbox row form-inline justify-content-center ml-1'> -->
<!-- 			<div class='newImg mt-1 ml-1 mr-1'>집 이미지</div> -->
<!-- 			<div class='newImg mt-1 ml-1 mr-1'>집 이미지</div> -->
<!-- 		</div> -->
<!-- 		<div class='sitterInbox row form-inline justify-content-center ml-1'> -->
<!-- 			<div class='newImg mt-1 ml-1 mr-1'>집 이미지</div> -->
<!-- 			<div class='newImg mt-1 ml-1 mr-1'>집 이미지</div> -->
<!-- 		</div> -->
<!-- 		<div class='row justify-content-center'> -->
<!-- 			<input type='file' class='mt-2' id='upFile' value='이미지 등록' multiple/>			 -->
<!-- 		</div> -->
		<img id='previewImg'/>
		<form id='sitterInForm justify-content-center mt-3' method='post' enctype='multipart/form-data'>
				<div class='form-row'>
					<div class='form-group col-4'>
						<div class='custom-file'>
							<input name='attachFile' type='file' class='custom-file-input' id='attachFile'/>
							<label class='custom-file-label' for='attachFile'>파일찾기</label>
						</div>
					</div>
				</div>
				<div class='form-group row' hidden>			
				<input name='userId' type='text' class='form-control' id='userId'
						value='<%=userId%>'/>
				</div>
				
				<input type='text' class='form-control col-12 mt-3 font color' id='sitterTitle' name='sitterTitle'
					placeholder='제목을 입력하세요.'/>
				<textarea class='form-control mt-2 col-12 font color' id='sitterContent' name='sitterContent'
					placeholder='소개를 입력하세요.'></textarea>
					
				<div class='form-group row sitterOption mt-2 mb-0'>
					<select id='animalType' name='sitterPetType' class='form-control font color col-4 ml-3'>
						<option value='' selected disabled hidden>반려동물 종류</option>
						<option value='강아지' id='dog'>강아지</option>
						<option value='고양이' id='cat'>고양이</option>
					</select>
					<!-- 강아지 일때만 나오게 하고 싶어용 -->
					<select id='dogType' name='sitterPetSize' class='form-control col-4 ml-1 font color' hidden='true'>
						<option value='' selected disabled hidden>강아지 크기</option>
						<option value='대형견'>대형견</option>
						<option value='중형견'>중형견</option>
						<option value='소형견'>소형견</option>
					</select>
				</div>

				<div class='form-group row sitterOption mt-2'>
					<label for='sitterLocation' class='col-1 font mt-1 mr-0 pr-0'>위치 입력</label>
					<input type='text' class='form-control col-2 font color' name='sitterLocSi'
						id='sitterLocation' placeholder='서울' /><label class='font mt-1'>시</label>
					<input type='text' class='form-control col-2 ml-3 font color' name='sitterLocGu'
						id='sitterLocation' placeholder='강남' /><label class='font mt-1'>구</label>
					<input type='text' class='form-control col-2 ml-3 font color' name='sitterLocDong'
						id='sitterLocation' placeholder='논현' /><label class='font mt-1'>동</label>
								
					<!-- 기간 입력이 되게 하고 싶어용  -->
					<!-- <input type='date' class='form-control col-4 ml-1 font color' id='sitterDate' name='sitterStart'
						value='가능 기간 선택' /> -->
				</div>
				<div class='row sitterOption mt-2'>
					<label for='sitterDate' class='col-1 font mt-1 mr-0 pr-0'>기간 선택</label>
					<input id='sitterDate' type="text" name="daterange" placeholder='기간을 입력하세요.' class='form-contrl col-5  font color' id='sitterDate' />
				</div>
				
				<hr class='color'>

				<div class='form-group row justify-content-end mt-4'>
					<button type='button' class='btn btn-outline-primary mr-2 font' data-toggle='modal' data-dismiss='modal' data-target='#sitterMod'>등록</button>
					<a href='../common/mypage' class='btn btn-outline-danger font'>취소</a>
				</div>
			
		
		
				<div class='modal fade' id='sitterMod' tabindex='-1'>
					<div class='modal-dialog'>
						<div class='modal-content'>
							<div class='modal-body '>
								<p class='text-center'>게시물을 등록하겠습니까?</p>
								<div class='text-center'>
									<button type='submit' class='btn btn-primary'>확인</button>
									<button type='button' class='btn btn-secondary' data-dismiss='modal'>취소</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				</form>
		<%@ include file= '../include/footer.jsp' %>
	</div>
</body>
</html>