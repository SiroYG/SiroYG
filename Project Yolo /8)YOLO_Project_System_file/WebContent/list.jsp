<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="board.*" %>
<%@ page import="java.util.*" %>

<jsp:useBean id="dao" class="board.DAO"/>

<%	
	String hotelid = request.getParameter("hotelid");
	int total = dao.count();
	ArrayList<VO> alist = dao.getMemberList(hotelid);
	int size = alist.size();
	int size2 = size;
	
	final int ROWSIZE = 4;
	final int BLOCK = 5;
	int indent = 0;

	int pg = 1;
	
	if(request.getParameter("pg")!=null) {
		pg = Integer.parseInt(request.getParameter("pg"));
	}
	
	int end = (pg*ROWSIZE);
	
	int allPage = 0;

	int startPage = ((pg-1)/BLOCK*BLOCK)+1;
	int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK;
	
	allPage = (int)Math.ceil(total/(double)ROWSIZE);
	
	if(endPage > allPage) {
		endPage = allPage;
	}
	
	size2 -=end;
	if(size2 < 0) {
		end = size;
	}
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <title>게시판</title>
 
 <style>
 
 #boardbody{
     width: 1000px;
    margin: 10px auto;
    font-family: 'NanumSquareRound', sans-serif;
    font-weight: 600;
 }
 </style>
 </head>
 <body>
 
<div id=boardbody>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr height="5"><td width="5"></td></tr>
 <tr style="background:url('img/table_mid.gif') repeat-x; text-align:center;">
   <td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
   <td width="73">번호</td>
   <td width="379">제목</td>
   <td width="73">작성자</td>
   <td width="164">작성일</td>
   <td width="7"><img src="img/table_right.gif" width="5" height="30" /></td>
  </tr>
<%
	if(total==0) {
%>
	 		<tr align="center" bgcolor="#FFFFFF" height="30">
	 	   <td colspan="6">등록된 글이 없습니다.</td>
	 	  </tr>
	 <%
	 	} else {
	 		for(int i=ROWSIZE*(pg-1); i<end;i++){
				VO vo = alist.get(i);
				indent = vo.getIndent();
				int idx = vo.getNum();
%>
	<tr height="25" align="center">
	<td align="center">&nbsp;</td>
	<td align="center"><%=idx%></td>
	<td align="left"><% 
		
		for(int j=0;j<indent;j++){
		%> &nbsp;&nbsp;&nbsp;<%
		}
		if(indent!=0){
			%><img src='images/reply_icon.png' /><%
		}
	%>
	<a href="view.jsp?idx=<%=idx%>&pg=<%=pg%>&hotelid=<%=hotelid%>"><%=vo.getTitle() %></a><%
		if(vo.isDayNew()){
			%>
			<img src='images/new.png' style= "width:20px; position: relative;
    top: -5px;"/>
			<%
		}
	%></td>
   <td align="center"><%=vo.getName()%></td>
   <td align="center"><%=vo.getTime() %></td>
   <td align="center">&nbsp;</td>
  <tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
<% }} %>
 <tr height="1" bgcolor="#82B5DF"><td colspan="6" width="752"></td></tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr><td colspan="4" height="5"></td></tr>
  <tr>
	<td align="center">
		<%
			if(pg>BLOCK) {
		%>
			[<a href="board.jsp?pg=1">◀◀</a>]
			[<a href="board.jsp?pg=<%=startPage-1%>">◀</a>]
		<%
			}
		%>
		
		<%
			for(int i=startPage; i<= endPage; i++){
				if(i==pg){
		%>
					<u><b>[<%=i %>]</b></u>
		<%
				}else{
		%>
					[<a href="board.jsp?pg=<%=i %>"><%=i %></a>]
		<%
				}
			}
		%>
		
		<%
			if(endPage<allPage){
		%>
			[<a href="board.jsp?pg=<%=endPage+1%>">▶</a>]
			[<a href="board.jsp?pg=<%=allPage%>">▶▶</a>]
		<%
			}
		%>
		</td>
		</tr>
	<tr align="center">
   <td><input type=button value="글쓰기" OnClick="window.location='write.jsp?hotelid=<%=hotelid%>'"></td>
  </tr>
 </table>
 </div>
 </body>
</html>
