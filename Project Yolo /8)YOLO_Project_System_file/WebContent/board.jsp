<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>YOLO </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />

	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
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
<style>
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
<%
		String name = (String) session.getAttribute("name");
		String id = (String) session.getAttribute("id");
	%>
</head>
<body>
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
                     
                     <a href="http://pf.kakao.com/_FgeMj/chat" class="aside">
                        <div class="side" id="img4">
                        <li style="margin-top: 40px"></li></div>
                     </a>
                     
                     

                  </ul>
               </div>
               
               <!-- 사이드바  -->
	<div id="fh5co-wrapper">
	<div id="fh5co-page">
	<div id="fh5co-header">
		<header id="fh5co-header-section">
			<div class="container">
				<div class="nav-header">
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
					<h1 id="fh5co-logo"><a href="index.jsp" style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif;">YOLO</a></h1>
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
						</ul>
					</nav>
				</div>
			</div>
		</header>
		
	</div>
	<!-- end:fh5co-header -->
	<div class="fh5co-parallax" style="background-image: url(images/slider1.jpg);" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-center fh5co-table">
					<div class="fh5co-intro fh5co-table-cell">
						<h1 class="text-center">Review</h1>
						
					</div>
				</div>
			</div>
		</div>
	</div>

	<div>
	
	<%@ include file="/list.jsp"%>
	
	</div>

	
	</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->
	
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