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
        <h3>비밀번호 찾기</h3>
      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up" data-aos-delay="100">
        <div class="row gy-4" style="justify-content: center;">
          <div class="col-lg-6">
            <div class="info-item  d-flex flex-column justify-content-center align-items-center">
              <i class="bi bi-map"></i>
              <h3>비밀번호 찾기</h3>
              <p>비밀번호를 찾아보세요~</p>
            </div>
          </div><!-- End Info Item -->
        </div>

        <div class="row gy-4 mt-1" style="justify-content: center;">
          <div class="col-lg-6">
            <form action="${root}/user/password.do" method="post">
              <div class="row gy-4">
                <div class="form-group">
                    <div class = "inputGroup">
                        <p class = "inputElement">이름 : </p>
                        <input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력하세요." required>
                    </div>
                    <br>
                    <div class = "inputGroup">
                        <p class = "inputElement">아이디 : </p>
                        <input type="text" class="form-control" name="userId" id="userId" placeholder="아이디를 입력하세요" required>
                    </div>
                </div>
              <div class="text-center">
                <button type="submit" class="btn btn-warning">비밀번호 찾기</button>
              </div>
              </div>
            </form>
          </div><!-- End Contact Form -->

        </div>
        <br>
      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

  <%@ include file="/footer.jsp" %>

</body>
</html>