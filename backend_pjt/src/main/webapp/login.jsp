<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  	<%@ include file="/header.jsp" %>
</head>
<body>

  <%@ include file="/nav.jsp" %>


  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('${root}/assets/img/contact-page.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h3>로그인</h3>
      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up" data-aos-delay="100">
        <div class="row gy-4" style="justify-content: center;">
          <div class="col-lg-6">
            <div class="info-item  d-flex flex-column justify-content-center align-items-center">
              <i class="bi bi-map"></i>
              <h3>로그인</h3>
              <p>EnjoyTrip에 로그인 해보세요~</p>
            </div>
          </div><!-- End Info Item -->
        </div>

        <!-- 이름, 아이디, 비밀번호, 비밀번호확인, 이메일, 지역 -->
        <div class="row gy-4 mt-1" style="justify-content: center;">
          <div class="col-lg-6">
            <form action="${root}/user/login.do" method="post">
              <div class="row gy-4">
                <div class="form-group">
                    <div class = "inputGroup">
                        <p class = "inputElement">아이디 : </p>
                        <input type="text" class="form-control" name="userId" id="userId" placeholder="아이디를 입력하세요." required>
                    </div>
                    <br>
                    <div class = "inputGroup">
                        <p class = "inputElement">비밀번호 : </p>
                        <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호를 입력하세요" required>
                    </div>
                </div>
              <div class="text-center">
                <button type="submit" class="btn btn-warning">로그인하기</button>
              </div>
              </div>
            </form>
          </div><!-- End Contact Form -->

        </div>
        <br>
        <div class = "login" style="text-align: center;">
          <button class="btn btn-dark">
          	<a href="${root}/user/registerForm.do">회원가입하러가기</a>
          </button>
          <button class="btn btn-dark">
          	<a href="${root}/user/passwordForm.do">비밀번호 찾기</a>
          </button>
        </div>
      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

  <%@ include file="/footer.jsp" %>


</body>
</html>