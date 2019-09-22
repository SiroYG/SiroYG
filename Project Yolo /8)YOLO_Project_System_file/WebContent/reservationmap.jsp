<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>



</head>
<body>

	<div id="static" style="width: 100%; height: 100%; display: inline-block;"></div>

	

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e6d73f0a12a6d1a4cc4a59f5fae7ed41"></script>
	<script>
	
	var markers = [ {
		position : new daum.maps.LatLng(locX,locY)
	}, {
		position : new daum.maps.LatLng(locX,locY),
		text : hotel_name
// text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다     
	} ];

	var staticMapContainer = document.getElementById('static'), // 이미지 지도를 표시할 div  
	staticMapOption = {
		center : new daum.maps.LatLng(locX,locY), // 이미지 지도의 중심좌표
		level : 3, // 이미지 지도의 확대 레벨

		marker : markers
	// 이미지 지도에 표시할 마커 
	};

	// 이미지 지도를 생성합니다
	var staticMap = new daum.maps.StaticMap(staticMapContainer,
			staticMapOption);

	</script>

</body>
</html>