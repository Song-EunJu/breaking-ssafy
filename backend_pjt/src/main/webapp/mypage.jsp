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
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('${root }/assets/img/mypage.png');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h3>마이페이지</h3>
      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Blog Details Section ======= -->
    <section id="blog" class="blog">
      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="row g-5">
          <div class="col-lg-8">
            <div class="post-author d-flex align-items-center">
 
              <img src="${root }/assets/img/blog/blog-author.jpg" class="rounded-circle flex-shrink-0" alt="">
 					<div>
		                <h4>${user.name }</h4>
		                <br>
		                <span>지역 : ${user.city } ${user.region }</span><br>
		                <span>이메일 : ${user.email }</span>
		            </div>
            	
        	</div>
        	 	<div class = "mypageOption">
	                <a href = "${root}/user/modifyForm.do">수정</a>
	                <a href = "${root}/user/resign.do?userId=${user.userId}">탈퇴</a>
            	</div>
        </div>

          <div class="col-lg-4">
            <div class="sidebar">
              <div class="sidebar-item recent-posts">
                <h3 class="sidebar-title">최근 본 게시물</h3>

                <div class="mt-3">

                  <div class="post-item mt-3">
                    <img src="${root }/assets/img/detail-image/detail1.jpg" alt="">
                    <div>
                      <h4><a href="blog-details.html">제주도 성산일출봉</a></h4>
                      <time datetime="2020-01-01">Jan 1, 2020</time>
                    </div>
                  </div><!-- End recent post item-->

                  <div class="post-item">
                    <img src="${root }/assets/img/detail-image/detail2.jpg" alt="">
                    <div>
                      <h4><a href="blog-details.html">대부도</a></h4>
                      <time datetime="2020-01-01">Jan 1, 2020</time>
                    </div>
                  </div><!-- End recent post item-->

                  <div class="post-item">
                    <img src="${root }/assets/img/detail-image/detail3.jpg" alt="">
                    <div>
                      <h4><a href="blog-details.html">강릉 안목해변</a></h4>
                      <time datetime="2020-01-01">Jan 1, 2020</time>
                    </div>
                  </div><!-- End recent post item-->

                  <div class="post-item">
                    <img src="${root }/assets/img/detail-image/detail4.jfif" alt="">
                    <div>
                      <h4><a href="blog-details.html">전주 한옥마을</a></h4>
                      <time datetime="2020-01-01">Jan 1, 2020</time>
                    </div>
                  </div><!-- End recent post item-->
                </div>

              </div><!-- End sidebar recent posts-->
            </div><!-- End Blog Sidebar -->
          </div>
        </div>

      </div>
    </section><!-- End Blog Details Section -->

  </main><!-- End #main -->

  <%@ include file="/footer.jsp" %>


</body>
</html>