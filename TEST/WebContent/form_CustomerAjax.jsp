<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer form</title>
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
function CustomerFunction(){
	var z = findGetParameter("action");
	if(z =="insert"){
	document.getElementById("id").readOnly = false;
	document.getElementById("idlabel").innerHTML = "id reaquire";
	}
}
</script>
</head>
<body onload="CustomerFunction()">
<h1>הוספת ערים</h1>
<section>
<form id="form4" action="CustomerControlerAjax" method="post" name="tofes" dir="rtl">
<div>
<label for="id_param" id="idlabel" >id (קריאה בלבד)</label>
<input readonly type="text" name="id_param" id="id" value="<c:out  value="${someCustomer.Customerid}"/>">
</div>

<div>
<label for="name_param" >customer</label>
<input type="text" name="name_param" value="<c:out  value="${someCustomer.CustomerName}"/>">
</div>

<input type="submit" value="Update" onclick="{document.tofes.action_type.value=this.value;updateCustomerb();}"/>
<input type="hidden" name="action_type"/> 
</form>

<form id="form2" action="CustomerControlerAjax" method="post" name="tofes" dir="rtl">
<div>
<label for="id_param" id="idlabel" >id</label>
<input type="text" name="id_param" id="id" value="<c:out  value="${sumcustomer.Customerid}"/>">
</div>

<div>
<label for="name_param" >city</label>
<input type="text" name="name_param" value="<c:out  value="${sumcustomer.CustomerName}"/>">
</div>

<input type="submit" value="Add" onclick="{document.tofes.action_type.value=this.value;addCustomerb();}"/>
<input type="hidden" name="action_type"/>
</form>

</section>
</body>
</html>