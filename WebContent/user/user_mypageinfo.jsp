<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>

<section>
        <div class="container">
            <div class="row join-wrap">
                <!--join-form을 적용한다 float해제 margin:0 auto-->
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    <h3>${msg }</h3>
                    <p>*표시는 필수 입력 표시입니다</p>
                    <form name="regform" action="update.user1" method="post">
                    <table class="table">
                        <tbody class="m-control">
                            <tr>
                                <td class="m-title">*ID</td>
                                <td><input class="form-control input-sm" placeholder="${user.id }" disabled></td>
                            </tr>
                            <tr>
                                <td class="m-title">*이름</td>
                                <td><input class="form-control input-sm" name="name" placeholder="${user.name }" type="text" required></td>
                            </tr>                            
                            <%System.out.println(request.getParameter("name")); %>
                            <tr>
                                <td class="m-title">*비밀번호</td>
                                <td><input name="pw" type="password"class="form-control input-sm" ></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호확인</td>
                                <td><input name="pwCheck" type="password" class="form-control input-sm" ></td>
                            </tr>
                            <tr>
                                <td class="m-title">*E-mail</td>
                                <td>
                                    <input name="email" type="text" class="form-control input-sm">@
                                    <select class="form-control input-sm sel">
                                        <option>naver.com</option>
                                        <option>gmail.com</option>
                                        <option>daum.net</option>
                                    </select>
                                    <button class="btn btn-info">중복확인</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*휴대폰</td>
                                <td>
                                    <input name="ph1" type="text" class="form-control input-sm sel" placeholder="${phone1[0] }"> -
                                    <input name="ph2" type="text" class="form-control input-sm sel" placeholder="${phone1[1] }"> -
                                    <input name="ph3" type="text" class="form-control input-sm sel" placeholder="${phone1[2] }">
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*주소</td>
                                <td><input name="address" type="text" class="form-control input-sm add"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*상세주소</td>
                                <td><input name="address1" type="text" class="form-control input-sm add"></td>
                            </tr>
                        </tbody>
                    </table>
                   
                    <div class="titlefoot">
                        <button type="button" class="btn" onclick="check()">수정</button>
                        <button class="btn">목록</button>
                    </div>
                    </form>
                </div>


            </div>

        </div>

    </section>
<script>

	function check(){			
			
			var pws1 = /[A-Za-z]+/;
			var pws2 = /[0-9]+/;
			var pws3 = /[~!@#$%^&*()]+/;
			
			if(!pws1.test(document.regform.pw.value)){
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
				alert('이름을 입력하세요.')
			}else{
				document.regform.submit();
			}
	}
</script>		

<%@ include file="/include/footer.jsp" %>
    