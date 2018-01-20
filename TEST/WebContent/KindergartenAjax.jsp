<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kindergarten Site</title>
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
	<script src="Ajax.js" type="text/javascript"></script>
<script type="text/javascript">





/* children */

function deleteChild(x)
{
	$.ajax(
	{
	cache:false,
	url:'ChildControllerAjax?action=delete&id='+x,
	data: {xxx:'xxx'},
	success: function(result)
	  {
	  
	$('#child_rows').html($(result).find('#table1'));  
	  },
	  
	  dataType: 'html'
	
	}
	
	);
}



function updateChild(x)
{
	
	$.ajax(
	{
	cache:false,
	url:'ChildControllerAjax?action=update&id='+x,
	data: {xxx:'xxx'},
	success: function(result)
	  {
	  
	$('#child_form').html($(result).find('#form1'));  
	  },
	  
	  dataType: 'html'
	
	}
	
	);
}



$(document).ready(function()
	{
	$('#child_button').click(function()
	               {
	
	$.ajax(	
	{
	  cache: false,
	  url: 'ChildControllerAjax?action=listChild',
	  data: {xxx:'xxx'},
	  success: function(result)
	  {
	 
	$('#child_rows').html($(result).find('#table1'));  
	
	  },
	  
	  dataType: 'html'
	
	}
	
	     );
	
	
	
	                       }
	               );
	}
	        );
	        
	        
	        

 
/* /* parents */
	   

function updateParent(x)
{
	
	$.ajax(
	{
	cache:false,
	url:'ParentControllerAjax?action=update&id='+x,
	data: {xxx:'xxx'},
	success: function(result)
	  {
	  
	$('#parent_form').html($(result).find('#form2'));  
	  },
	  
	  dataType: 'html'
	
	}
	
	);
}



function deleteParent(x)
{
	
	$.ajax(
	{
	cache:false,
	url:'ParentControllerAjax?action=delete&id='+x,
	data: {xxx:'xxx'},
	success: function(result)
	  {
	  
	$('#parent_rows').html($(result).find('#table2'));  
	  },
	  
	  dataType: 'html'
	
	}
	
	);
}


function update2()

{
	alert("update2");
	event.preventDefault();
	var $form = $('#form2');
	parentID = $form.find('input[name="id_param"]').val();
	parentName = $form.find('input[name="name_param"]').val();
	a=$form.find('input[name="action_type"]').val();
	servlet= $form.attr('action');
	alert(parentId+" "+parentName+" "+a+" "+servlet);
	
	$.ajax	
	(
	{
	cache:false,
	type:'POST',
	url:servlet,
	data:{
	id:parentID,
	        name:parentName,
	        a: action_type,
	},
	datatype:'html',
	success: function(result)
	{
	$('#parent_rows').html($(result).find('#table2'));  
	}
	}
	);
}
 





$(document).ready(
	
	function list()
	{
	$('#parent_button').click(function()
	               {
	
	$.ajax(	
	{
	  cache: false,
	  url: 'ParentControllerAjax?action=listParent',
	  data: {xxx:'xxx'},
	  success: function(result)
	  {
	 
	$('#parent_rows').html($(result).find('#table2'));  
	
	  },
	  
	  dataType: 'html'
	
	}
	
	     );
	
	
	
	                       }
	
        
    );
}
);





</script>
</head>
<body>
	<H1 align="center">רשימת ילדים</H1>
	<button id="child_button" align="center">הצג רשימת ילדים</button>
	<table>
		<div id="child_rows"></div>
	</table>
	<div id="child_form"></div>

	<H1 align="center">רשימת הורים</H1>
	<button id="parent_button" align="center">הצג רשימת הורים</button>
	<table>

		<div id="parent_rows"></div>




	</table>

	<!-- <div id="parent_form"></div> -->
</body>
</html>
