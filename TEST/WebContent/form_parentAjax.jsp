<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Parent form</title>

<script>

function findGetParameter(parameterName) {
    var result = null,
        tmp = [];
    location.search
        .substr(1)
        .split("&")
        .forEach(function (item) {
          tmp = item.split("=");
          if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
        });
    return result;
}

function parentFunction(){
	var z = findGetParameter("action");
	if(z =="add"){
	document.getElementById("id").readOnly = false;
	document.getElementById("idlabel").innerHTML = "id reaquire";
	}
}

</script>

</head>

<body onload="parentFunction()">
<h1>הוספת הורים</h1>
<section>

<form id="form3" action="ParentControllerAjax" method="post" name="tofesParent" dir="rtl">

<!-- <fieldset> -->

<div>
<label for="id_param" id="idlabel" >id</label>
<input  type="text" name="id_param" id="id" value="<c:out  value="${someParent.parentID}"/>">
</div>

<div>
<label for="name_param" >parent</label>
<input type="text" name="name_param" value="<c:out  value="${someParent.parentName}"/>">
</div>

<div>
<label for="grade_param" >grade</label>
<input type="text" name="grade_param" value="<c:out  value="${someParent.parentGrade}"/>">
</div>

<input type="submit" value="Add" onclick="{document.tofesParent.action_type.value=this.value;addParentForm();}"/>
<input type="submit" value="Update" onclick="{document.tofesParent.action_type.value=this.value;updateParentForm();}"/>
<input type="hidden" name="action_type"/> 
</form>

<!-- </fieldset> -->

</section>
</body>
</html>


