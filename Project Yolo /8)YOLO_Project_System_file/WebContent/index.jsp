<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	
	
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


</style>

  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<!-- Demo style -->
<link rel='stylesheet'
   href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>

<link rel="stylesheet" href="css_popup/style.css">
<link rel="stylesheet" href="css/style2.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style3.css">
<link rel="stylesheet" href="css/star.css">
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>YOLO &mdash; 너두 나두 YOLO YOLOWA</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />


  	<!-- Facebook and Twitter integration -->
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





</head>
<body>

<%  String name= (String) session.getAttribute("name");%>
<% String id = (String) session.getAttribute("id"); %>
	<div id="fh5co-wrapper">
	<div id="fh5co-page">
	<div id="fh5co-header">
		<header id="fh5co-header-section">
			<div class="container">
				<div class="nav-header">
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
					<h1 id="fh5co-logo"><a href="index.jsp">YOLO</a></h1>
					<nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
						
						<!-- 아이디 출력 -->
							<%
							if(name==null){%>
								<li><a class="button" href="#popup1">Login</a></li>
							<%}else{%>
								<li><a class="button" href="#popup2" style=" font-family: 'Nanum Gothic',sans-serif;
   font-style: normal;
   font-weight: 400;"><%=name %></a></li>
								<li><a class="button" href="Logout">Logout</a></li>
							<%} %>
							
								
								
								</ul>
								
					</nav>
				</div>
			</div>
			
			
			
			
		</header>
	

		
		
		
		<!--  정보 수정 창 -->
		
			<div id="popup2" class="overlay">
									<div class="popup">
										
										<div class="content">
											<div class="form">
      
      <ul class="tab-group">
      <a class="close" href="#">&times;</a>
        <li class="tab active"><a href="#modify" class="login_a">Modify</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="modify">   
        
          <form action="Member_Modify" method="post">
            <div class="field-wrap">
              <label>
                ID : <%=id %><span class="req"></span>
              </label>
              <input type="text" required autocomplete="off" value="" readonly="readonly" style="border:0;"/>
            </div>
         
          <div class="field-wrap">
            <label>
              Set Password<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" style="height:50px;" name="pw"/>
          </div>
           <div class="field-wrap">
            <label>
              Name<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" style="height:50px;" name="name"/>
          </div>
            <div class="field-wrap">
            <label>
              Phone<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" style="height:50px;" name="tel"/>
          </div>
          
          <button type="submit" class="button2 button2-block"/>Confirm Info</button>
          
          </form>

        </div>
        
        <div id="modify2">   
         
          <form action="Login" method="post">
          
            <div class="field-wrap">
            <label>
              ID<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" style="height:50px;" name="logid"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" style="height:50px;" name="logpw"/>
          </div>
          
          <p class="forgot"><a href="#" class="login_a">Forgot Password?</a></p>
          
          <button class="button2 button2-block"/>Log In</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>

										</div>
									</div>
								</div>
		
			<!-- 로그인 창  -->
		<div id="popup1" class="overlay">
									<div class="popup">
										
										<div class="content">
											<div class="form">
      
      <ul class="tab-group">
      <a class="close" href="#">&times;</a>
        <li class="tab active"><a href="#signup" class="login_a">Sign Up</a></li>
        <li class="tab"><a href="#login" class="login_a">Log In</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
        
          <form action="Join" method="post">
            <div class="field-wrap">
              <label>
                ID<span class="req">*</span>
              </label>
              <input type="text" required autocomplete="off" name="id" />
            </div>
         
          <div class="field-wrap">
            <label>
              Set Password<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" style="height:50px;" name="pw"/>
          </div>
           <div class="field-wrap">
            <label>
              Name<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" style="height:50px;" name="name"/>
          </div>
            <div class="field-wrap">
            <label>
              Phone<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" style="height:50px;" name="tel"/>
          </div>
          
          <button type="submit" class="button2 button2-block"/>Get Started</button>
          
          </form>

        </div>
        
        <div id="login">   
         
          <form action="Login" method="post">
          
            <div class="field-wrap">
            <label>
              ID<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" style="height:50px;" name="logid"/>
          </div>
          
          <div class="field-wrap">
          
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" style="height:50px;" name="logpw"/>
          </div>
          
          <p class="forgot"><a href="#" class="login_a">Forgot Password?</a></p>
          
          <button class="button2 button2-block"/>Log In</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>

										</div>
									</div>
								</div>
	</div>
	<!-- end:fh5co-header -->
	<aside id="fh5co-hero" class="js-fullheight">
		<div class="flexslider js-fullheight">
			<ul class="slides">
		   	<li style="background-image: url(images/slider1.jpg);">
		   		<div class="overlay-gradient"></div>
		   		<div class="container">
		   			<div class="col-md-12 col-md-offset-0 text-center slider-text">
		   				<div class="slider-text-inner js-fullheight">
		   					<div class="desc">
		   						<p><span>CHEDI IN NAMHAE</span></p>
		   						<h2 style="font-family: 'NanumSquareRound', sans-serif;font-style: normal;font-weight: 700;">가족여행을 위해 예약하세요!</h2>
			   					<p>
			   					</p>
		   					</div>
		   				</div>
		   			</div>
		   		</div>
		   	</li>
		   	<li style="background-image: url(images/slider2.jpg);">
		   		<div class="overlay-gradient"></div>
		   		<div class="container">
		   			<div class="col-md-12 col-md-offset-0 text-center slider-text">
		   				<div class="slider-text-inner js-fullheight">
		   					<div class="desc">
		   						<p><span>Hwanhnamgwan In JeonJu</span></p>
		   						<h2 style="font-family: 'NanumSquareRound', sans-serif;font-style: normal;font-weight: 700;">편안한 여행을 즐기세요!</h2>
			   					<p>
			   					</p>
		   					</div>
		   				</div>
		   			</div>
		   		</div>
		   	</li>
		   	<li style="background-image: url(images/slider3.jpg);">
		   		<div class="overlay-gradient"></div>
		   		<div class="container">
		   			<div class="col-md-12 col-md-offset-0 text-center slider-text">
		   				<div class="slider-text-inner js-fullheight">
		   					<div class="desc">
		   						<p><span>MVL Hotel YEOSU</span></p>
		   						<h2 style="font-family: 'NanumSquareRound', sans-serif;font-style: normal;font-weight: 700;">최고의 장소에서 즐기세요!</h2>
			   					<p>
			   					</p>
		   					</div>
		   				</div>
		   			</div>
		   		</div>
		   	</li>
		   	
		  	</ul>
	  	</div>
	</aside>
	

	<div class="wrap" style="margin : 0;">
		<div class="container">
			<div class="row">
				<div id="availability">
					<form action="Reservation" method="get">
						<div class="a-col">
							<section>
						
							</section>
						</div>
						<div class="a-col alternate">
							<div class="input-field">
								<label for="date-start">Check In</label>
								<input type="text" class="form-control" id="date-start"  name="checkin"/>
							</div>
						</div>
						<div class="a-col alternate">
							<div class="input-field">
								<label for="date-end">Check Out</label>
								<input type="text" class="form-control" id="date-end" name="checkout" />
							</div>
						</div>
						<div class="a-col action">
							<a href="#" style="padding:0;">
							<button type="submit" style="text-align:left; margin-left: 20px ;border:0; background-color: rgba(0,0,0,0); width:90%; height: 100%; "><span>Check</span>
								Availability</button>
								
							</a>
						</div>
					</form>
				</div>
			</div>
		</div>
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

</body>
</html>