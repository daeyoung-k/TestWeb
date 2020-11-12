<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                	<h3>${msg }</h3>
                    <h2>회원가입<small>(가운데정렬)</small></h2>

                    <form name="regform"action="joinFrom.user1" method="post">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 (영문포함 4~12자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" name="pw" id="password" placeholder="비밀번호 (영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" name="pwCheck" id="password-confrim" placeholder="비밀번호를 확인해주세요.">
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력하세요.">
                        </div>
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label><br>
                            
                            <input name="ph1" class="form-control sel" placeholder="010"> -
                            <input name="ph2" class="form-control sel" placeholder="xxxx"> -
                            <input name="ph3" class="form-control sel" placeholder="xxxx">
                        
                        </div>
                        <div class="form-group">
                             <label for="hp">이메일</label><br>
                            <input name="email" class="form-control sel">@
                            <select class="form-control sel">
                                <option>naver.com</option>
                                <option>gmail.com</option>
                                <option>daum.net</option>
                            </select>
                        </div>
                        
                        
                        
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <input type="text" class="form-control" name="address" id="addr-basic" placeholder="기본주소">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="address1" id="addr-detail" placeholder="상세주소">
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="check()">회원가입</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="location.href='login.user1'">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </section>
    
<script>

	function check(){
		
		var ids = /^(?=.*[A-Za-z]).{4,12}$/;
		var pws1 = /[A-Za-z]+/;
		var pws2 = /[0-9]+/;
		var pws3 = /[~!@#$%^&*()]+/;
		if(document.regform.id.value.length < 4){
			alert('아이디는 4자리 이상입니다.');
			return;
		}else if(!ids.test(document.regform.id.value)){
			alert('아이디를 정확히 입력하세요.');
			return;
		}else if(!pws1.test(document.regform.pw.value)){
			alert('비밀번호를 정확히 입력하세요.');
			return;
		}else if(!pws2.test(document.regform.pw.value)){
			alert('비밀번호를 정확히 입력하세요.');
			return;
		}else if(!pws3.test(document.regform.pw.value)){
			alert('비밀번호를 정확히 입력하세요.');
			return;		
		}else if(document.regform.pw.value.length < 8 && document.regform.pwCheck.value.length < 8){
			alert('비밀번호는 8자리 이상입니다.');
			return;
		}else if(document.regform.pw.value != document.regform.pwCheck.value){
			alert('비밀번호가 동일하지 않습니다.');
			return;
		}else if(document.regform.name.value == ''){
			alert('이름을 입력하세요.');
			return;
		}else{
			document.regform.submit();
		}
		
		
		
	}

</script>

</body>

</html>