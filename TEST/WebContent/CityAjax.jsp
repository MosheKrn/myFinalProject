<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .red { border: 2px solid red; width:250px; heights:250px; }
 .blue { border: 2px solid blue; width:50px; heights:50px; }
</style> 



</head>
<body>
<h1>רשימת ערים</h1>
<section>
<table border="4" id="table1" style="float:right;text-align: rigth;">
   <thead>
   <tr><th>ID</th><th>עיר</th><th colspan=2>פעולה</th></tr>
   </thead>

   <tbody>
   <c:forEach items="${cities}" var= "city">
    	 <tr>
   	     <td> <c:out  value = "${city.rid }"    /></td>
     	 <td> <c:out  value = "${city.cityName }" /></td>
      	 <td> <a onclick="deleteCity(<c:out  value='${city.rid}'/>)"   href="#">מחיקה</a> </td>	  
		 <td> <a onclick="updateCity(<c:out  value='${city.rid}'/>)"   href="#">עדכן</a> </td>		
   		 </tr>     
   </c:forEach>
   </tbody>		
		 <td> <a onclick="addCity(<c:out  value='${city.rid}'/>)"   href="#">הוספה</a> </td>
</table>
</section>

</body>
</html>