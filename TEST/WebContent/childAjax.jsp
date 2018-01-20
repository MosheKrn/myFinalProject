<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Children list</title>
<style type="text/css">
 .red { border: 2px solid red; width:250px; heights:250px; }
 .blue { border: 2px solid blue; width:50px; heights:50px; }
</style>


</head>
<body>
<h1>רשימת ילדים</h1>
<section>
<table border="4" id="table2" style="float:right;text-align: rigth;">
   <thead>
   <tr><th>ID</th><th>ילד</th><th>ציון</th><th colspan=2>פעולה</th></tr>
   </thead>

   <tbody>
   <c:forEach items="${Children}" var= "child">
    	 <tr>
   	     <td> <c:out  value = "${child.childID }"    /></td>
     	 <td> <c:out  value = "${child.childName }" /></td>
     	  <td> <c:out  value = "${child.childGrade }"    /></td>
      	 <td> <a onclick="deleteChild(<c:out  value='${child.childID}'/>)"   href="#">מחיקה</a> </td>	  
		 <td> <a onclick="updateChild(<c:out  value='${child.childID}'/>)"   href="#">עדכן</a> </td>		
   		 </tr>     
   </c:forEach>
   </tbody>		
		 <td> <a onclick="addChild(<c:out  value='${child.childID}'/>)"   href="#">הוספה</a> </td>
</table>
</section>

</body>
</html>