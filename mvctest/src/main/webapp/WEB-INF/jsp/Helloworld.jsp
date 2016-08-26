<%@include file="cookie.jsp"%>
<%@include file="bootstrap.jsp" %>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome</title>
</head>
<body>
	<h5 >${message},</h5>
	<li class="dropdown-toggle">
	<h5  style="padding-right: 30"><a class="dropdown-toggle" data-toggle="dropdown">${user.username}</a><b class="caret"></b> </h5>
	<ul class="dropdown-menu">
					<li><a href="#">My Center</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
			
				</ul>
	</li>
	<br/>
	
	${grade}
	
	<table class="table table-hover">
	<caption>12222</caption>
	<thead>
		<tr>
			<th>English</th>
			<th>Math</th>
			<th>Shengwu</th>
			<th>Wuli</th>
			<th>Huaxue</th>
			<th>Zhengzhi</th>
			<th>Total</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Tanmay</td>
			<td>Bangalore</td>
			<td>560001</td>
		</tr>
		<tr>
			<td>Sachin</td>
			<td>Mumbai</td>
			<td>400003</td>
		</tr>
		<tr>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
		</tr>
	</tbody>
</table>
</body>
<%
	Cookie[] cookies = request.getCookies();//从request中获得cookie对象的集合  
	username = ""; //Login username
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("textCookie")) {
				username = URLDecoder.decode(cookies[i].getValue());//获取用户名  

			}
		}

	}
%>
</html>
