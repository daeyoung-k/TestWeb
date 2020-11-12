<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

   <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2>로그인<small>(가운데정렬)</small></h2>
                    
                    
                    <form action="loginFrom.user1">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="id" id="id" placeholder="아이디" required>
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" name="pw" id="password" placeholder="비밀번호 " required>
                        </div>                    

                        <div class="form-group">
                            <button type="submit" class="btn btn-lg btn-info btn-block">로그인</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="location.href='join.user1'">회원가입</button>
                            <p>${msg}</p>                             
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </section>

</body>

</html>