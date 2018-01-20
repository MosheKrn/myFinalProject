<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>parents list</title>
<style type="text/css">
<style>
.card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    width: 40%;
     float: right;
}

.card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
    padding: 2px 16px;
}
S
.h2{
text-align: center;
}

</style> 


</head>
<body>
<h1>רשימת הורים</h1>
<section>
<div  id="table3">
  

 
   <c:forEach items="${Parents}" var= "parent">
   <class id="card">
    	 
   	   <p>ת"ז<c:out  value = "${parent.parentID }"    /></p>
     	<p> הורה <c:out  value = "${parent.parentName }" /></p>
     	<p> ציון <c:out  value = "${parent.parentGrade }" /></p>
      	 <td> <a onclick="deleteParent(<c:out  value='${parent.parentID}'/>)"   href="#">מחיקה</a> </td>	  
		 <td> <a onclick="updateParent(<c:out  value='${parent.parentID}'/>)"   href="#">עדכן</a> </td>		
   		     
   </c:forEach>
  		
		  <a onclick="addParent(<c:out  value='${parent.parentID}'/>)"   href="#">הוספה</a> 
		  </class>
</div>
</section>

</body>
</html>