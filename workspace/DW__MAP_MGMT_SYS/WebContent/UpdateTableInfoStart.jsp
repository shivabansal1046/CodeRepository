<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="submitForm();">
<script type="text/javascript">
function submitForm()
{
	
	
	var frm= document.getElementById('updateInfo');
	frm.submit();
}


var i=1;

if(i==0){
	window.onLoad =alert("Success");
}

</script>
<form id="updateInfo" action="UpdateTableInfo" method="post">
<input type="Hidden" id="pagefrom" value="onloadpage"/>
</form>
</body>
</html>