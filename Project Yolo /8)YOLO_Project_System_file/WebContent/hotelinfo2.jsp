<%@page import="model.RoomVO"%>
<%@page import="model.HotelVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<style>
body {
	margin: 0;
	font-family: 'NanumSquareRound', sans-serif;
	font-style: normal;
	font-weight: 700;
}

#fh5co-logo1 {
	font-size: 20px;
	text-transform: uppercase;
	font-weight: 300;
	float: left;
	margin-bottom: 0;
	margin-top: 1.4em;
}

.box {
	position: relative;
	background-size: cover;
	height: 400px;
	background-position: 0 30px;
}

.logo1 {
	position: relative;
	width: 100%;
	color: white;
	left: 10px;
	width: 100%;
	clear: left;
}

.content1 {
	text-align: center;
	color: white;
	height: 100%;
	vertical-align: middle;
}

.content1 h2 {
	margin: 0;
	padding: 170px;
	font-size: 40px;
}

.box1 {
	border: 3px solid;
	border-color: #eaeaea;
	width: 700px;
	padding: 20px;
	font-size: 18px;
}

#checkinout {
	border: 3px solid;
	border-color: #eaeaea;
	width: 300px;
	height: 250px;
	padding: 20px;
	position: absolute;
	text-align: center;
	display: inline;
	margin-left: 10px;
}

#rebutton {
	border-radius: 10px 10px 10px 10px;
	width: 230px;
	height: 35px;
	border-color: #ffffff;
	background-color: rgb(138, 213, 216);
}

.roominfor {
	margin-left: 20%;

}

.iconinfor {
	width: 325px;
	height: 95px;
	margin-top: -20px;
	margin-left: 20px;
}

.bookingimg {
	height: 40px;
	width: 40px;
	margin-left: -100px;
}

span {
	display: inline-block;
	vertical-align: top;
}

.star {
	margin-left: 5px;
}

.title {
	margin-left: 25px;
	font-family: 'NanumSquareRound', sans-serif;
	font-weight: bold;
	color: #535252;
}

#date {
	font-family: 'NanumSquareRound', sans-serif;
	font-weight: bold;
	color: #535252;
}

#hotelinfo-box{
	background-color:red;
	width: 635px;
}


/* 사이드바 */
#floatMenu {
   position: absolute;
   width: 135px;
   height: 470px;
   right: 10px;
   top: 150px;
   background-color: #606060;
   color: #fff;
   border-radius: 10px 10px 10px 10px;
   text-align: center;
   font-size: 21px;
   opacity: 0.8;
}

#sidecon {
   list-style-type: none;
   padding: 0;
   font-size: 18px;
   width: 100px;
   height: 70px;
}

.side {
   text-align: center;
   padding: 6px 10px 10px 10px;
   margin-left: 10px;
   margin-right: 10px;
   height: 100px;
   
}

.aside {
   text-align: center;
}

.side:hover {
   color: #606060 !important;
   background-position: -150px 0px;
}

.aside #img1 {
   background-image: url("images/search5.png");
   background-repeat: no-repeat;
   margin-left: -18px;
}

.aside #img2 {
   background-image: url("images/booking1.png");
   background-repeat: no-repeat;
      margin-left: -20px;
   
}

.aside #img3 {
   background-image: url("images/board5.png");
   background-repeat: no-repeat;
      margin-left: -20px;

}
.aside #img4 {
   background-image: url("images/kakao.png");
   background-repeat: no-repeat;
      margin-left: -20px;

}


</style>
<meta charset="utf-8">
<meta charset="EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>YOLO &mdash; 너두 나두 YOLO YOLOWA</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

<!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FREEHTML5.CO
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">
<!-- <link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700italic,900,700,900italic' rel='stylesheet' type='text/css'> -->

<!-- Stylesheets -->
<!-- Dropdown Menu -->
<link rel="stylesheet" href="css/superfish.css">
<!-- Owl Slider -->
<!-- <link rel="stylesheet" href="css/owl.carousel.css"> -->
<!-- <link rel="stylesheet" href="css/owl.theme.default.min.css"> -->
<!-- Date Picker -->
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">
<!-- CS Select -->
<link rel="stylesheet" href="css/cs-select.css">
<link rel="stylesheet" href="css/cs-skin-border.css">

<!-- Themify Icons -->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Flat Icon -->
<link rel="stylesheet" href="css/flaticon.css">
<!-- Icomoon -->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Flexslider  -->
<link rel="stylesheet" href="css/flexslider.css">

<!-- Style -->
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
</head>
<body>
	<%
		String name = (String) session.getAttribute("name");
	%>
	<%
		String id = (String) session.getAttribute("id");
		String hotelid = request.getParameter("hotelid");
		session.setAttribute("HotelID", hotelid); //hotelid를 세션에 저장
		String hotelTitle = null;
		String img1 = null;
		String img2 = null;
		String img3 = null;
		String addr = null;
		String cal = null;
		String hotelName = null;
		String hotelID = null;
		ArrayList<HotelVO> ar = (ArrayList) session.getAttribute("hotelinfo");
		
		for (int i = 0; i < 1; i++) {
		
				hotelTitle = ar.get(i).getHotel_title();
				hotelID = ar.get(i).getHotel_id();
				img1 = ar.get(i).getImg1();
				img2 = ar.get(i).getImg2();
				img3 = ar.get(i).getImg3();
				addr = ar.get(i).getAddr();
				cal = ar.get(i).getCal();
				hotelName = ar.get(i).getHotel_name();
				
				
		
		}
	%>
	
	<!--                SideBar -->
               <div id="floatMenu" style="padding: 15px 7px 5px 13px; z-index:999">
                  YOLO
                  <ul id="sidecon">

                     <a href="hotel.jsp" class="aside">
                        <div class="side" id="img1">
                        <li style="margin-top: 40px"></li></div>
                     </a>
                     <a href="ReservationList" class="aside">
                        <div class="side" id="img2">
                           <li style="margin-top: 40px"></li>

                        </div>
                     </a>

                     <a href="#" class="aside">
                        <div class="side" id="img3">
                           <li style="margin-top: 40px"></li>
                        </div>
                     </a>
                     
                     <a href="#" class="aside">
                        <div class="side" id="img4">
                        <li style="margin-top: 40px"></li></div>
                     </a>
                     
                     

                  </ul>
               </div>
               
               <!-- 사이드바  -->
	<div id="fh5co-wrapper" style="overflow: hidden;">
		<div id="fh5co-page">
			<div id="fh5co-header">
				<header id="fh5co-header-section">
					<div class="container">
						<div class="nav-header">
							<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
							<h1 id="fh5co-logo">
								<a href="index.jsp" style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif;">YOLO</a>
							</h1>
							<nav id="fh5co-menu-wrap" role="navigation">
								<ul class="sf-menu" id="fh5co-primary-menu">
									
									<!-- 아이디 출력 -->
									<%
										if (name == null) {
									%>
									<li><a class="button" href="#popup1">Login</a></li>
									<%
										} else {
									%>
									<li><a class="button" href="#popup2"
										style="font-family: 'Nanum Gothic', sans-serif; font-style: normal; font-weight: 400;"><%=name%></a></li>
									<li><a class="button" href="Logout">Logout</a></li>
									<%
										}
									%>


							</nav>
						</div>
					</div>
				</header>

			</div>
			<!-- end:fh5co-header -->
			<div class="fh5co-parallax"
				style="background-image: url(<%=img3 %>); overflow: hidden;"
				data-stellar-background-ratio="0.5">
				<div class="overlay"></div>
				<div class="container">
					<div class="row">
						<div
							class="col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-center fh5co-table">
							<div class="fh5co-intro fh5co-table-cell">
								<h1 class="text-center"><%=hotelTitle %></h1>
							</div>
						</div>
					</div>
				</div>
			</div>



		</div>
		<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->
	<div class="box" style="width: 0px; height: 0px; margin-top: 50px;">
		<div class="logo1">
			<h1 id="fh5co-logo1">
			</h1>
		</div>

	</div>

	<div class="roominfor">
		<table style="display: inline;">
			<tr>
				<td>
					<div class="box1">
						<div class=title>
							<div style="font-size: 45px; margin-bottom: -30px;"><%=hotelName %></div>
							<br> <%=addr %><br><%=cal %><br>
						</div>

						<img class="star" src="images/star.jpg"> <br>
						<img class="iconinfor" src="images/iconpng1.png"> <br>
						<img class ="roominfo" src = "images/roominfo.png" style="width: 650px;"><br>
			<%
				
				ArrayList<RoomVO> roomarr = new ArrayList<RoomVO>();
				for(int i = 0; i <ar.size(); i++){
					String comparedHotelName = ar.get(i).getHotel_name();
					String comparedHotelid = ar.get(i).getHotel_id();
					String comparedImg1 = ar.get(i).getImg1();
					String comparedImg2 = ar.get(i).getImg2();
					RoomVO rm = new RoomVO(comparedHotelid,comparedImg1,comparedImg2);
					
						
						roomarr.add(rm);
				
					
				}
			
			%>
			
			<%
				for(int i = 0; i <roomarr.size();i++){
					
					String hotel_id = roomarr.get(i).getHotel_id();
					String hotel_img = roomarr.get(i).getImg1();
					String info_img = roomarr.get(i).getImg2();
				
			%>
						<!-- 데이터베이스에서 방 정보 불러오기 -->
						
						 <div>
						<div class = "roompic" style="display : inline-block; float : left;" >
						<img src=<%=hotel_img %> style = "width : 330px; height : 224px;">
						</div>
						<div style="display : inline-block; margin-left: 24px;">
						<img src=<%=info_img %>><br>
						<a href="pay?hotelid=<%=hotel_id%>">
						<input type="submit" style="font-family: 'NanumSquareRound', sans-serif; margin-left: 30px; margin-top : 10px; font-weight: bold; color: #535252;" value="예약하기" id="rebutton">
						</a>
						</div>
						
						</div>
						<img src="images/hr.jpg" style="width: 650px;">
						
					    <!-- 데이터베이스에서 방 정보 불러오기  -->
				<%
				}
				%>
					</div>
				</td>
			</tr>
		</table>
		
		<div id="checkinout">
			<div style="margin-left: 75px; height: 50px; margin: auto;" id="date">
				<img src="images/claender.png" class="bookingimg"
					style="display: inline; margin-left: 0px;">
				<p
					style="display: inline; font-family: 'NanumSquareRound', sans-serif; font-weight: bold; color: #535252; font-size: 22px;">DATE</p>
				<br>
			</div>
			<%
				String checkIn = (String)session.getAttribute("checkin");
				String checkOut = (String)session.getAttribute("checkout");
			%>
			<form action="hotelinfo_submit">
			<input name = "checkin" style = "border-color: #ccc; height : 35px; margin-bottom: 20px;" class="form-control" id="date-start" type="text" value=<%=checkIn %> style="height: 35.97728px; margin-bottom: 20px;"> 
			<input name = "checkout" style = "border-color: #ccc; height : 35px; margin-bottom: 20px;" class="form-control" id="date-end" type="text" value=<%=checkOut %> style="height: 35.9778px; margin-bottom: 20px;">
			<input type="submit" style="font-family: 'NanumSquareRound', sans-serif; font-weight: bold; color: #535252;" value="검색하기" id="rebutton">
				</form>
			
		</div>
	


	</div>
	<!-- Javascripts -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<!-- Dropdown Menu -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Counters -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Owl Slider -->
	<!-- // <script src="js/owl.carousel.min.js"></script> -->
	<!-- Date Picker -->
	<script src="js/bootstrap-datepicker.min.js"></script>
	<!-- CS Select -->
	<script src="js/classie.js"></script>
	<script src="js/selectFx.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>

	<script src="js/custom.js"></script>
<script src="js/side.js"></script>
</body>
</html>