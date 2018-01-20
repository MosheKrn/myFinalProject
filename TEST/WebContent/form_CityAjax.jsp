<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>City form</title>

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

function cityFunction(){
	var z = findGetParameter("action");
	if(z =="add"){
	document.getElementById("id").readOnly = false;
	document.getElementById("idlabel").innerHTML = "id reaquire";
	}
}

</script>

</head>

<body onload="cityFunction()">
<h1>הוספת ערים</h1>
<section>

<form id="form1" action="CityControlerAjax" method="post" name="tofes" dir="rtl">

<!-- <fieldset> -->

<div>
<label for="id_param" id="idlabel" >id</label>
<input  type="text" name="id_param" id="id" value="<c:out  value="${sumcity.rid}"/>">
</div>

<div>
<label for="name_param" >city</label>
<input type="text" name="name_param" value="<c:out  value="${sumcity.cityName}"/>">
</div>

<input type="submit" value="Add" onclick="{document.tofes.action_type.value=this.value;addCityForm();}"/>
<input type="submit" value="Update" onclick="{document.tofes.action_type.value=this.value;updateCityForm();}"/>
<input type="hidden" name="action_type"/> 
</form>

<!-- </fieldset> -->

</section>
</body>
</html>


