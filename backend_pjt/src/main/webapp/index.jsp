<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/header.jsp" %>
</head>
<body>

  <%@ include file="/nav.jsp" %>


  <!-- ======= Hero Section ======= -->
  <section id="hero" class="hero">
    <div class="info d-flex align-items-center">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6 text-center">
            <h2 data-aos="fade-down">Welcome to <span>Enjoy Trip</span></h2>
            <p data-aos="fade-up">EnjoyTrip과 함께 우리나라 방방곡곡의 관광지를 알아보고<br> 나만의 여행 계획을 세워 보세요</p>
            <a data-aos="fade-up" data-aos-delay="200" href="#get-started" class="btn-get-started">관광지 보러가기</a>
          </div>
        </div>
      </div>
    </div>

    <div id="hero-carousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="5000">

      <div class="carousel-item active" style="background-image: url(assets/img/hero-carousel/travel1.png)"></div>
      <div class="carousel-item" style="background-image: url(assets/img/hero-carousel/travel2.jpeg)"></div>
      <div class="carousel-item" style="background-image: url(assets/img/hero-carousel/travel3.jpg)"></div>
      <div class="carousel-item" style="background-image: url(assets/img/hero-carousel/travel4.jpg)"></div>
      <div class="carousel-item" style="background-image: url(assets/img/hero-carousel/travel5.jpg)"></div>

      <a class="carousel-control-prev" href="#hero-carousel" role="button" data-bs-slide="prev">
        <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
      </a>

      <a class="carousel-control-next" href="#hero-carousel" role="button" data-bs-slide="next">
        <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
      </a>

    </div>

  </section><!-- End Hero Section -->

  <main id="main">
    <!-- ======= Constructions Section ======= -->
    <section id="constructions" class="constructions">
      <div class="container" data-aos="fade-up">

        <div class="section-header">
          <h2>지역별 관광지를 찾아보세요.</h2>
          <p>현재 인기 관광지를 살펴보세요.</p>
        </div>

        <div class="row gy-4">

          <div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
            <div class="card-item">
              <div class="row">
                <div class="col-xl-5">
                  <div class="card-bg" style="background-image: url(assets/img/main-travel/main-travel1.jfif);"></div>
                </div>
                <div class="col-xl-7 d-flex align-items-center">
                  <div class="card-body">
                    <h4 class="card-title">부산 감천문화마을</h4>
                    <p>
                      부산광역시 사하구 감천동에 있는 마을이자 부산 원도심의 대표적인 랜드마크로, 
                      한국의 마추픽추 혹은 산토리니라는 별명이 있습니다.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div><!-- End Card Item -->

          <div class="col-lg-6" data-aos="fade-up" data-aos-delay="200">
            <div class="card-item">
              <div class="row">
                <div class="col-xl-5">
                  <div class="card-bg" style="background-image: url(assets/img/main-travel/main-travel2.png);"></div>
                </div>
                <div class="col-xl-7 d-flex align-items-center">
                  <div class="card-body">
                    <h4 class="card-title">제주도 스누피가든</h4>
                    <p>
                      스누피 가든 하우스는 감정에 솔직하고 개성 있는 피너츠 친구들을 만나 그들의 상호 관계를 통한 공감과 위로의 메시지를 얻는 곳입니다.<br><br>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div><!-- End Card Item -->

          <div class="col-lg-6" data-aos="fade-up" data-aos-delay="300">
            <div class="card-item">
              <div class="row">
                <div class="col-xl-5">
                  <div class="card-bg" style="background-image: url(assets/img/main-travel/main-travel5.png);"></div>
                </div>
                <div class="col-xl-7 d-flex align-items-center">
                  <div class="card-body">
                    <h4 class="card-title">화성 수섬</h4>
                    <p>
                      작은 돌섬이었으나 시화방조제가 건설되면서 주변 일대가 간척되어 수섬은 육지가 되었습니다.
                      수섬 주변은 바닷물에 잠겨있던 습지의 바닥이 드러나면서 독특한 풍경을 보여주는 곳이랍니다.
                    </p>                  
                  </div>
                </div>
              </div>
            </div>
          </div><!-- End Card Item -->

          <div class="col-lg-6" data-aos="fade-up" data-aos-delay="400">
            <div class="card-item">
              <div class="row">
                <div class="col-xl-5">
                  <div class="card-bg" style="background-image: url(assets/img/main-travel/main-travel3.jfif);"></div>
                </div>http://localhost:8080/pjt_backend/index.jsp#hero-carousel
                <div class="col-xl-7 d-flex align-items-center">
                  <div class="card-body">
                    <h4 class="card-title">경주 동궁과 월지</h4>
                    <p>
                      남북국시대 통일신라의 별궁이 자리했던 궁궐터로 역사적인 곳으로, 경주의 야경명소로, 달이 비치는 연못이 인상적인 장소입니다.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div><!-- End Card Item -->

        </div>

      </div>
    </section><!-- End Constructions Section -->    
  </main><!-- End #main -->
  <%@ include file="/footer.jsp" %>
  
</body>

</html>