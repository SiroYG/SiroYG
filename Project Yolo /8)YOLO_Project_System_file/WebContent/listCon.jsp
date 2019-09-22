<%@page import="model.HotelVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<style>


</style>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<script type="text/javascript">
 
    function callGPS(this_alt){
    
        $.ajax({
        	
            url : "map",
            data : "msg="+this_alt,
            success : function(data){
            	sessionStorage.setItem( "hotel_name", data.name );
            	sessionStorage.setItem( "locX", data.locX);
            	sessionStorage.setItem( "locY", data.locY);
            	parent.sayHello();
            }
             
        });
        
    }
    
</script>


</head>
<body>


	<%
		String hotelName;
		String hotelInfo;
		String location;
		String img4;
		String hotelID;
		int price;
		ArrayList<HotelVO> ar = (ArrayList) session.getAttribute("hotelinfo");
		for (int i = 0; i < ar.size(); i++) {
			hotelName = ar.get(i).getHotel_name();
			hotelInfo = ar.get(i).getInfo();
			price = ar.get(i).getPrice();
			location = ar.get(i).getLocation();
			img4 = ar.get(i).getImg3();
			hotelID = ar.get(i).getHotel_id();
	%>

	<div class="list-container">
		<div class="img-box">
			<img src=<%=img4%> alt=<%= hotelID %> style="display: block; object-fit:cover; left: -10px; top: 22px; height: 90%;" src="za" name="a" OnClick="callGPS(this.alt);" >
		</div>
		<div class="info-box">
			<div class="title">
				<h2 style="margin-top: 25px; margin-bottom: 10px; font-size:1.8em"><%=hotelName%></h2>
			</div>
			<div class="score">*****</div>
			<div class="price">
				<h3 style="margin-bottom: 10px; display: inline; font-weight: bold;"><%=price%></h3>
				<span style="color: black">원</span>
			</div>
			<div class="info"><%=hotelInfo%></div>
			<div style="text-align: right;">
				<a href="hotelinfo.jsp?hotelid=<%=hotelID %>" class="click-button" style="margin-right: 0"><div
						class="click-button-div">예약하기</div></a> <a href="board.jsp?hotelid=<%=hotelID %>"
					class="click-button"><div class="click-button-div">후기</div></a>
			</div>

		</div>
	</div>


	<%
		}
		
	%>
	
</body>
</html>