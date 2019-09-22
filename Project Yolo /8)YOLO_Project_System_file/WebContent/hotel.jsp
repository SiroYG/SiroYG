<!DOCTYPE html>
<%@page import="model.HotelVO"%>
<%@page import="model.ReservationDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
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

<style>
body {
	margin: 0;
	font-family: 'NanumSquareRound', sans-serif;
	font-style: normal;
	font-weight: 700;
}

#container {
	padding: 3% 15%;
}

#listcon {
	width: 600px;
	height: 1000px;
	float: left;
	border-style: none;
}

#infocon {
	width: 600px;
	height: 600px;
	float: right;
	border: solid;
	border-width: thin;
	border-color: #a1a1a1;
	margin-top: 20px;
	margin-right: 20%;
}

#fh5co-logo {
	font-size: 20px;
	text-transform: uppercase;
	font-weight: 300;
	float: left;
	margin-bottom: 0;
	margin-top: 1.4em;
}

.img {
	position: relative;
	background-size: cover;
}

.logo {
	position: relative;
	width: 100%;
	color: white;
	left: 10px;
	width: 100%;
	clear: left;
}

.img {
	height: 400px;
	background-image: url("images/slider1.jpg");
	background-position: 0 30px;
}

.content {
	text-align: center;
	color: white;
	height: 100%;
	vertical-align: middle;
}

.content h2 {
	margin: 0;
	padding: 170px;
	font-size: 40px;
}

.Calendar {
	margin: auto;
	width: 70%;
	height: 50px;
	border: solid;
	border-width: thin;
	border-color: #a1a1a1;
    background-color: white;
}

.form-control {
	display: inline-block;
	width: 200px;
	height: 10px;
	padding: 14px 12px;
	font-size: 14px;
	line-height: 1.42857;
	color: #555555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	-webkit-transition: border-color ease-in-out 0.15s, box-shadow
		ease-in-out 0.15s;
	-o-transition: border-color ease-in-out 0.15s, box-shadow ease-in-out
		0.15s;
	transition: border-color ease-in-out 0.15s, box-shadow ease-in-out 0.15s;
}

.form-control:focus {
	border-color: #FF5722;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px
		rgba(255, 87, 34, 0.6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px
		rgba(255, 87, 34, 0.6);
}

.calendar-image {
	width: 50px;
	height: auto;
}

#label-chk1:hover {
	background-position: -150px 0px;
}

#label-chk2:hover {
	background-position: -150px 0px;
}

#label-chk3:hover {
	background-position: -150px 0px;
}

#label-chk4:hover {
	background-position: -150px 0px;
}

#label-chk5:hover {
	background-position: -150px 0px;
}

#label-chk6:hover {
	background-position: -150px 0px;
}

#chk1:checked+#label-chk1 {
	background-position: -150px 0px;
}

#chk2:checked+#label-chk2 {
	background-position: -150px 0px;
}

#chk3:checked+#label-chk3 {
	background-position: -150px 0px;
}

#chk4:checked+#label-chk4 {
	background-position: -150px 0px;
}

#chk5:checked+#label-chk5 {
	background-position: -150px 0px;
}

#chk6:checked+#label-chk6 {
	background-position: -150px 0px;
}

.icon {
	width: 150px;
	height: 200px;
}

label {
	display: block;
	width: 150px;
	height: 200px;
	background-repeat: no-repeat;
}

#label-chk1 {
	background-image: url("images/mountain1.png");
}

#label-chk2 {
	background-image: url("images/sea1.png");
}

#label-chk3 {
	background-image: url("images/mt1.png");
}

#label-chk4 {
	background-image: url("images/spa1.png");
}

#label-chk5 {
	background-image: url("images/swimmingpool1.png");
}

#label-chk6 {
	background-image: url("images/valley1.png");
}

#icon>label {
	display: inline-block;
}

.list-container {
	display: inline-block;
	width: 97%;
	height: 300px;
	margin: 10px;
	border: solid;
	border-width: thin;
	border-color: #a1a1a1;
}

.img-box img {
	position: relative;
	object-fit: contain;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

.img-box {
	display: inline-block;
	width: 350px;
	height: 280px;
	float: left;
	padding: 0 10px 0 30px;
	line-height: 35.5;
}

.info-box {
	display: inline-block;
	height: 100%;
	float: left;
	width: 35%;
	margin-right: 10px;
}

.checkbox {
	display: none;
}

input[type="text"] {
	height: 40px;
	border-radius: 0px;
	margin-top: 4px;
	margin-left: 10px;
}

#check-availability {
	height: 49px;
	width: 20%;
	background-color: #a1a1a1;
	float: right;
	padding-top: 10px;
	padding-left: 10px;
}

#check-availability:hover {
	background-color: gray;
}

.info {
	height: 80px;
	width: 100%;
	font-weight: 400;
}

.click-button {
	margin: 10px;
}

.click-button-div {
	border-radius: 30px;
	background-color: #8ad5d8;
	color: white;
	width: 80px;
	text-align: center;
	display: inline-block;
	margin-top: 5px;
}

.jbFixed {
	position: fixed;
	top: 0px;
}

.infoconFixed {
	display: block;
	margin-left: 855px;
	/* margin-left: 36.5px; */
}

.listconFixed {
	padding-top: 280px;
}

#hotel-submit-button:hover {
	background-color: #8ad5d8;
}
</style>

<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {
		var jbOffset = $('#jbMenu').offset();
		$(window).scroll(function() {
			if ($(document).scrollTop() > jbOffset.top) {
				$('#jbMenu').addClass('jbFixed');
			} else {
				$('#jbMenu').removeClass('jbFixed');
			}
		});
	});
</script>
<script>
	$(document).ready(function() {
		var jbOffset = $('#jbMenu').offset();
		$(window).scroll(function() {
			if ($(document).scrollTop() > jbOffset.top) {
				$('#infocon').addClass('infoconFixed');
			} else {
				$('#infocon').removeClass('infoconFixed');
			}
		});
	});
</script>
<script>
	$(document).ready(function() {
		var jbOffset = $('#jbMenu').offset();
		$(window).scroll(function() {
			if ($(document).scrollTop() > jbOffset.top) {
				$('#listcon').addClass('listconFixed');
			} else {
				$('#listcon').removeClass('listconFixed');
			}
		});
	});
</script>
<script>

function sayHello(){
	
	    $('#infocon').load("infocon.jsp");

}

</script>

<script>

window.onload = function(){
	
	var checkedCategories = JSON.parse(sessionStorage.getItem( "checkedCategoryNum" ));
	var size = checkedCategories.length;
	
	for(var i = 0; i < size; i++){		
		var num = checkedCategories[i];
		 document.getElementsByName("category")[num].checked = true;
	}
    
}

</script>
<script>
 function checkedListener(){
	  var checkedArray = new Array();
      var size = document.getElementsByName("category").length;
       for(var i = 0; i < size; i++){
           if(document.getElementsByName("category")[i].checked == true){
               checkedArray.push(i);
           }
       }
       sessionStorage.setItem("checkedCategoryNum", JSON.stringify(checkedArray));
   }
 </script>
 
		<style>

.box {
  width: 40%;
  margin: 0 auto;
  background: rgba(255,255,255,0.2);
  padding: 35px;
  border: 2px solid #fff;
  border-radius: 20px/50px;
  background-clip: padding-box;
  text-align: center;
}



.overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.7);
  transition: opacity 500ms;
  visibility: hidden;
  opacity: 0;
}
.overlay:target {
  visibility: visible;
  opacity: 1;
}

.popup {
  z-index:110;
  margin: 75px auto;
  padding: 0;
  background: #fff;
  border-radius: 5px;
  width: 30%;
  position: relative;
  transition: all 5s ease-in-out;
}

.popup h2 {
  margin-top: 0;
  color: #333;
  font-family: Tahoma, Arial, sans-serif;
}
.popup .close {
  position: absolute;
  top: 10px;
  right: 15px;
  transition: all 200ms;
  font-size: 30px;
  font-weight: bold;
  text-decoration: none;
  color: white;
}
.popup .close:hover {
  color: #06D85F;
}
.popup .content {
  max-height: 30%;
  overflow: auto;
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

.checkbox-div{
	display: inline-block;
}

.category-name{
 	position: relative;
    top: -40px;
    font-family: 'NanumSquareRound', sans-serif;
	font-style: normal;
	font-size: 25px;
}

</style>


</head>


<body>

	<%
		String name = (String) session.getAttribute("name");
	%>
	<%
		String id = (String) session.getAttribute("id");
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
	

	
	<div id="fh5co-wrapper">
		<div id="fh5co-page">
			<div id="fh5co-header">
				<header id="fh5co-header-section">
					<div class="container" style="padding-top: 0;">
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



								</ul>

							</nav>
						</div>
					</div>
				</header>

			</div>
			<!-- end:fh5co-header -->
			
			
			
			<div class="fh5co-parallax"
				style="background-image: url(images/slider1.jpg);"
				data-stellar-background-ratio="0.5">
				<div class="overlay"></div>
				<div class="container">
					<div class="row">
						<div
							class="col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-center fh5co-table">
							<div class="fh5co-intro fh5co-table-cell">
								<h1 class="text-center" style="font-family: 'NanumSquareRound', sans-serif;font-style: normal;font-weight: 700;">원하는 호텔을 찾아보세요!</h1>
								<p style="color:#888888">
						
									 Find the best hotel that suits your style!
						
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<div id="jbMenu"
		style="width: 100%; background-color: white; z-index: 30; height: 320px; ">

				<%
					String checkin = (String) session.getAttribute("checkin");
					String checkout = (String) session.getAttribute("checkout");
				%>
				
			
		<form action="hotel_submit">
			<div>
				<div align="center" id="icon">
					<div class="checkbox-div"><input type="checkbox" id="chk1" class="checkbox" name="category" value="mountain"><label for="chk1" id="label-chk1"></label><span class="category-name">산</span></div>
					<div class="checkbox-div"><input type="checkbox" id="chk2" class="checkbox" name="category" value="beach"><label for="chk2" id="label-chk2"></label><span class="category-name">바다</span></div>
				    <div class="checkbox-div"><input type="checkbox" id="chk3" class="checkbox" name="category" value="mt"><label for="chk3" id="label-chk3"></label><span class="category-name">엠티</span></div>
					<div class="checkbox-div"><input type="checkbox" id="chk4" class="checkbox" name="category" value="spa"><label for="chk4" id="label-chk4"></label><span class="category-name">스파</span></div>
					<div class="checkbox-div"><input type="checkbox" id="chk5" class="checkbox" name="category" value="swimmingpool"><label for="chk5" id="label-chk5"></label><span class="category-name">수영장</span></div>
					<div class="checkbox-div"><input type="checkbox" id="chk6" class="checkbox" name="category" value="valley"><label for="chk6" id="label-chk6"></label><span class="category-name">계곡</span></div>
				</div>


				<div class="Calendar">
					<img class="calendar-image" src="images/calendar.png"
						style="float: left; margin-top: 5px;"> <input type="text"
						class="form-control" id="date-start" name="checkin"
						style="float: left" value=<%=checkin%>> <img
						class="calendar-image" src="images/arrow.png"
						style="float: left; margin-top: 5px;"> <input type="text"
						class="form-control" id="date-end" name="checkout"
						style="float: left;" value=<%=checkout%>> <input
						id="hotel-submit-button" type="submit" value="Check Availability"
						style="float: right; height: 100%; width: 200px; background-color: #ccc; border-style: unset; color: white;" onClick="checkedListener()">
					<!-- <div id="check-availability">
         <span style="color:white;"> Check Availability  <span style="color:#8ad5d8"> > </span></span>
         </div> -->
				</div>
			</div>
		</form>
		<div style="text-align: right;">
			<div id="infocon">
				
				<%@ include file="/infocon.jsp"%>
			</div>

		</div>

	</div>

	<div id="container" style="padding-top: 0; padding-bottom:0;">
		<div id="listcon">
		 
			<%@ include file="/listCon.jsp"%>
		</div>


	</div>




	<!-- END fh5co-page -->


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
<script src="js/side.js"></script>
	<script src="js/custom.js"></script>




</body>


</html>