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
		<div class="breadcrumbs d-flex align-items-center"
			style="background-image: url('${root}/assets/img/breadcrumbs-bg.jpg');position: relative;">
			<div
				class="container position-relative d-flex flex-column align-items-center"
				data-aos="fade">
				<h3>지역별 여행지</h3>

			</div>
		</div>
		<!-- End Breadcrumbs -->

		<!-- ======= About Section ======= -->
		<section id="about" class="about align-items-center">
			<div class="col-md-10" style="margin: 0 auto;">
				<div class="alert alert-primary mt-3 text-center fw-bold"
					role="alert">전국 관광지 정보</div>
				<!-- 관광지 검색 start -->
				<form class="d-flex my-3"
					method="post" action="${root}/map/about.do">
					<select id="search-area" class="form-select me-2"
						onchange="categoryChange(this)" name="sido_code">
						<option value="0" selected>검색 할 시/도 선택</option>
						<option value="1">서울</option>
						<option value="2">인천</option>
						<option value="3">대전</option>
						<option value="4">대구</option>
						<option value="5">광주</option>
						<option value="6">부산</option>
						<option value="7">울산</option>
						<option value="8">세종특별자치시</option>
						<option value="31">경기도</option>
						<option value="32">강원도</option>
						<option value="33">충청북도</option>
						<option value="34">충청남도</option>
						<option value="35">경상북도</option>
						<option value="36">경상남도</option>
						<option value="37">전라북도</option>
						<option value="38">전라남도</option>
						<option value="39">제주도</option>
					</select> <select id="search-area2" class="form-select me-2"
						name="gugun_code">
						<option value="0" selected>검색 할 구/군 선택</option>
					</select> <select id="search-content-id" class="form-select me-2"
						name="content_type_id">
						<option value="0" selected>관광지 유형</option>
						<option value="12">관광지</option>
						<option value="14">문화시설</option>
						<option value="15">축제공연행사</option>
						<option value="25">여행코스</option>
						<option value="28">레포츠</option>
						<option value="32">숙박</option>
						<option value="38">쇼핑</option>
						<option value="39">음식점</option>
					</select>
					<input id="btn-search" class="btn btn-outline-success"
						type="submit" value="검색"><!--  검색</input>-->
				</form>
				<!-- kakao map start -->
				<div id="map" class="mt-3" style="width: 100%; height: 600px;"></div>
				<!-- kakao map end -->
				
				<div class="row">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>대표이미지</th>
								<th>관광지명</th>
								<th>주소</th>
								<th>위도</th>
								<th>경도</th>
							</tr>
						</thead>
						<tbody id="trip-list"></tbody>
						<c:forEach items="${requestScope.mapInfos}" var="mapInfo"
							>
							<tr onclick="moveCenter(${mapInfo.latitude}, ${mapInfo.longitude});">
								<td><img src=" ${mapInfo.first_image}" style="width:100px; height:100px;"></td>
								<td>${mapInfo.title}</td>
								<td>${mapInfo.addr1}</td>
								<td>${mapInfo.latitude}</td>
								<td>${mapInfo.longitude}</td>
								<!-- <td><a href="${pageContext.request.contextPath}/dept/detail.do?deptno=${dept.deptno}">${dept.dname}</a></td> -->
							</tr>
						</c:forEach>
					</table>
				</div>
				
				<!-- 관광지 검색 end -->
			</div>
		</section>

		<!-- End Testimonials Section -->
	</main>

  	<%@ include file="/footer.jsp" %>
  	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script src="${root}/assets/js/main.js"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=686bb9a6129097c5545ba3d73cf86e6e&libraries=services,clusterer,drawing"></script>
	<script type="text/javascript">
		function categoryChange(e) {
			var area1 = [ "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구",
					"금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구",
					"성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구",
					"중구", "중랑구" ];
			var area2 = [ "계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "중구",
					"강화군", "옹진군" ];
			var area3 = [ "대덕구", "동구", "서구", "유성구", "중구" ];
			var area5 = [ "광산구", "남구", "동구", "북구", "서구" ];
			var area4 = [ "남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군" ];
			var area7 = [ "남구", "동구", "북구", "중구", "울주군" ];
			var area6 = [ "강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구",
					"사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군" ];
			var area8 =["세종특별자치시"];
			var area9 = [ "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시",
					"남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시",
					"안양시", "양주시", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시",
					"평택시", "포천시", "하남시", "화성시", "가평군", "양평군", "여주군", "연천군" ];
			var area10 = [ "강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시", "태백시",
					"고성군", "양구군", "양양군", "영월군", "인제군", "정선군", "철원군", "평창군",
					"홍천군", "화천군", "횡성군" ];
			var area11 = [ "제천시", "청주시", "충주시", "괴산군", "단양군", "보은군", "영동군",
					"옥천군", "음성군", "증평군", "진천군", "청원군" ];
			var area12 = [ "계룡시", "공주시", "논산시", "보령시", "서산시", "아산시", "천안시",
					"금산군", "당진군", "부여군", "서천군", "연기군", "예산군", "청양군", "태안군",
					"홍성군" ];
			var area13 = [ "군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군",
					"무주군", "부안군", "순창군", "완주군", "임실군", "장수군", "진안군" ];
			var area14 = [ "광양시", "나주시", "목포시", "순천시", "여수시", "강진군", "고흥군",
					"곡성군", "구례군", "담양군", "무안군", "보성군", "신안군", "영광군", "영암군",
					"완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군" ];
			var area15 = [ "경산시", "경주시", "구미시", "김천시", "문경시", "상주시", "안동시",
					"영주시", "영천시", "포항시", "고령군", "군위군", "봉화군", "성주군", "영덕군",
					"영양군", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군" ];
			var area16 = [ "거제시", "김해시", "마산시", "밀양시", "사천시", "양산시", "진주시",
					"진해시", "창원시", "통영시", "거창군", "고성군", "남해군", "산청군", "의령군",
					"창녕군", "하동군", "함안군", "함양군", "합천군" ];
			var area17 = [ "남제주군", "북제주군","서귀포시", "제주시", ];
			var target = document.getElementById("search-area2");

			if (e.value == "1")
				var d = area1;
			else if (e.value == "2")
				var d = area2;
			else if (e.value == "3")
				var d = area3;
			else if (e.value == "4")
				var d = area4;
			else if (e.value == "5")
				var d = area5;
			else if (e.value == "6")
				var d = area6;
			else if (e.value == "7")
				var d = area7;
			else if (e.value == "8")
				var d = area8;
			else if (e.value == "31")
				var d = area9;
			else if (e.value == "32")
				var d = area10;
			else if (e.value == "33")
				var d = area11;
			else if (e.value == "34")
				var d = area12;
			else if (e.value == "35")
				var d = area13;
			else if (e.value == "36")
				var d = area14;
			else if (e.value == "37")
				var d = area15;
			else if (e.value == "38")
				var d = area16;
			else if (e.value == "39")
				var d = area17;

			target.options.length = 0;

			for (x in d) {
				var opt = document.createElement("option");
				opt.value = ++x;
				opt.innerHTML = d[--x];
				target.appendChild(opt);
			}
		}
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		};
		var map = new kakao.maps.Map(container, options);
		var mapTypeControl = new kakao.maps.MapTypeControl();

		// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
		// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
		map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

		// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
		var positions = [];
		var zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
		<c:forEach items="${requestScope.mapInfos}" var="mapInfo">
		positions.push({content : '<div class="wrap">' + 
            '    <div class="info" style="width:200px;">' + 
            '        <div class="title">' + 
            '            ${mapInfo.title}' + 
            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div class="img">' +
            '                <img src="${mapInfo.first_image}" width="73" height="70">' +
            '           </div>' + 
            '            <div class="desc">' + 
            '                <div class="ellipsis">${mapInfo.addr1}</div>' + 
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>', latlng: new kakao.maps.LatLng(${mapInfo.latitude}, ${mapInfo.longitude})});
		</c:forEach>
		
		function moveCenter(lat, lng) {
	        map.setCenter(new kakao.maps.LatLng(lat, lng));
	        document.getElementById("map").scrollIntoView();
	        map.setLevel(3);
	    }
		map.setCenter(positions[0].latlng);
		
		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
  
		for (var i = 0; i < positions.length; i ++) {
		    
		    // 마커 이미지의 이미지 크기 입니다
		    var imageSize = new kakao.maps.Size(24, 35); 
		    
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		    
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng, // 마커를 표시할 위치
		        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image : markerImage // 마커 이미지 
		    });

		    var infowindow = new kakao.maps.InfoWindow({
		        content: positions[i].content // 인포윈도우에 표시할 내용
		    });

		    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
		    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
		    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		}
		function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		}
	</script>
</body>
</html>