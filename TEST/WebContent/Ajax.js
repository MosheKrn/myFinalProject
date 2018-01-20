/* Child */

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
										 
										$('#child_rows').html($(result).find('#table2'));  
									  },
									  
									  dataType: 'html'
										
									}
																				
							     );
							
							
							
	                       }
			               );
		}
		        );
		       
function addChild(){
	$.ajax({
		cache:false,
		url: "ChildControllerAjax?action=insert",
		data:{
			userName:'uuu'
		},		
		success: function (result)		
		{
			 $('html, body').animate({
			        scrollTop: $("#Children").offset().top
			    }, 1000); 
		
			$('#child_form').html($(result).find('#form2'));   
			$('#child_form').show();		
		},
		dataType: 'html'
		}
	);
}


function updateChildForm()
{	
	event.preventDefault();
	var $form = $('#form2');
	childID = $form.find('input[name="id_param"]').val();
	childName = $form.find('input[name="name_param"]').val();
	childGrade = $form.find('input[name="grade_param"]').val();
	a=$form.find('input[name="action_type"]').val();
	servlet= $form.attr('action');
	//alert(cityId+" "+cityName+" "+a+" "+servlet);
	
	$.ajax
	(
			{				
				cache:false,
				type: 'post',
				url:servlet,
				data: {
					id:childID,
					cn:childName,
					cn:childGrade,
					action_type:a
						},
					dataType: 'html',
						success: function(result)
						  {	
							$('html, body').animate({
						        scrollTop: $("#Children").offset().top
						    }, 1000);
							$('#child_rows').html($(result).find('#table2'));  
							$('#child_form').show();
						  }
				}	
		);
}


function deleteChild(x)
{
	$.ajax(
			{
				cache:false,
				url:'ChildControllerAjax?action=delete&id='+x,
				data: {xxx:'xxx'},
				success: function(result)
				  {
					  
					$('#child_rows').html($(result).find('#table2'));  
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
					
					$('html, body').animate({
				        scrollTop: $("#Children").offset().top
				    }, 1000);   
					$('#child_form').html($(result).find('#form2'));  
				  },
				  
				  dataType: 'html'
		
			}
	
	);
}





function addChildForm()
{
	event.preventDefault();		
	var $form = $('#form2');
	childID = $form.find('input[name="id_param"]').val();
	childName = $form.find('input[name="name_param"]').val();
	childGrade = $form.find('input[name="grade_param"]').val();
	child = $form.find('input[name="child"]').val(),
	a=$form.find('input[name="action_type"]').val();
	servlet= $form.attr('action');
	$.ajax
	({
		cache:false,
		type:'POST',
		url:servlet,
		data:{
			id:childID,
			cn:childName,
			cn:childGrade,
			ci:child,
			action_type:a				
			
			 },
		datatype:'html',
		success:function(result)
		{
			
			$("#child_rows").html($(result).find("#table2")); 
			$('#child_rows').show();
		}
	});
	}




function addCityForm()
	{
		event.preventDefault();		
		var $form = $('#form1');
		cityId = $form.find('input[name="id_param"]').val();
		cityName = $form.find('input[name="name_param"]').val();
		city = $form.find('input[name="city"]').val(),
		a=$form.find('input[name="action_type"]').val();
		servlet= $form.attr('action');
		$.ajax
		({
			cache:false,
			type:'POST',
			url:servlet,
			data:{
				id:cityId,
				cn:cityName,
				ci:city,
				action_type:a				
				
				 },
			datatype:'html',
			success:function(result)
			{
				
				$("#city_rows").html($(result).find("#table1")); 
				$('#city_rows').show();
			}
		});
		}



function updateCity(x)
{
	
	
	
	$.ajax(
			{
				cache:false,
				url:'CityControlerAjax?action=update&id='+x,
				data: {xxx:'xxx'},
				success: function(result)
				  {
					
					$('html, body').animate({
				        scrollTop: $("#citys").offset().top
				    }, 1000);   
					$('#city_form').html($(result).find('#form1'));  
				  },
				  
				  dataType: 'html'
		
			}
	
	);
}





function updateCityForm()
{	
	event.preventDefault();
	var $form = $('#form1');
	cityId = $form.find('input[name="id_param"]').val();
	cityName = $form.find('input[name="name_param"]').val();
	a=$form.find('input[name="action_type"]').val();
	servlet= $form.attr('action');
	//alert(cityId+" "+cityName+" "+a+" "+servlet);
	
	$.ajax
	(
			{				
				cache:false,
				type: 'post',
				url:servlet,
				data: {
					id:cityId,
					cn:cityName,
					action_type:a
						},
					dataType: 'html',
						success: function(result)
						  {	
							$('html, body').animate({
						        scrollTop: $("#citys").offset().top
						    }, 1000);
							$('#city_rows').html($(result).find('#table1'));  
							$('#city_form').show();
						  }
				}	
		);
}


function deleteCity(x)
{
	$.ajax(
			{
				cache:false,
				url:'CityControlerAjax?action=delete&id='+x,
				data: {xxx:'xxx'},
				success: function(result)
				  {
					  
					$('#city_rows').html($(result).find('#table1'));  
				  },
				  
				  dataType: 'html'
		
			}
	
	);
}



$(document).ready(function()
		{
	$('#city_button').click(function()
			               {
										
							$.ajax(									
									{
									  cache: false,
									  url: 'CityControlerAjax?action=listCity',
									  data: {xxx:'xxx'},
									  success: function(result)
									  {
										 
										$('#city_rows').html($(result).find('#table1'));  
									  },
									  
									  dataType: 'html'
										
									}
																				
							     );
							
							
							
	                       }
			               );
		}
		        );
		       

function addCity(){
	$.ajax({
		cache:false,
		url: "CityControlerAjax?action=insert",
		data:{
			userName:'uuu'
		},		
		success: function (result)		
		{
			 $('html, body').animate({
			        scrollTop: $("#citys").offset().top
			    }, 1000); 
		
			$('#city_form').html($(result).find('#form1'));   
			$('#city_form').show();		
		},
		dataType: 'html'
		}
	);
}



/* /* parents */





$(document).ready(function()
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
										 
										$('#parent_rows').html($(result).find('#table3'));  
									  },
									  
									  dataType: 'html'
										
									}
																				
							     );
							
							
							
	                       }
			               );
		}
		        );





function addParent(){
	$.ajax({
		cache:false,
		url: "ParentControllerAjax?action=insert",
		data:{
			userName:'uuu'
		},		
		success: function (result)		
		{
			 $('html, body').animate({
			        scrollTop: $("#Parents").offset().top
			    }, 1000); 
		
			$('#parent_form').html($(result).find('#form3'));   
			$('#parent_form').show();		
		},
		dataType: 'html'
		}
	);
}




function updateParent(x)
{	
	
	$.ajax(
			{
				cache:false,
				url:'ParentControllerAjax?action=update&id='+x,
				data: {xxx:'xxx'},
				success: function(result)
				  {
					
					$('html, body').animate({
				        scrollTop: $("#Parents").offset().top
				    }, 1000);   
					$('#parent_form').html($(result).find('#form3'));  
					$('#parent_form').show();
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
	  
	$('#parent_rows').html($(result).find('#table3'));  
	  },
	  
	  dataType: 'html'
	
	}
	
	);
}


function updateParentForm()
{	
	event.preventDefault();
	var $form = $('#form3');
	parentID = $form.find('input[name="id_param"]').val();
	parentName = $form.find('input[name="name_param"]').val();
	parentGrade = $form.find('input[name="grade_param"]').val();
	a=$form.find('input[name="action_type"]').val();
	servlet= $form.attr('action');
	
	
	$.ajax
	(
			{				
				cache:false,
				type: 'post',
				url:servlet,
				data: {
					id:parentID,
					cn:parentName,
					cn:parentGrade,
					action_type:a
						},
					dataType: 'html',
						success: function(result)
						  {	
							$('html, body').animate({
						        scrollTop: $("#Parents").offset().top
						    }, 1000);
							$('#parent_rows').html($(result).find('#table3'));  
							$('#parent_form').show();
						  }
				}	
		);
}
 


function addParentForm()
{
	event.preventDefault();		
	var $form = $('#form3');
	parentId = $form.find('input[name="id_param"]').val();
	parentName = $form.find('input[name="name_param"]').val();
	parentGrade = $form.find('input[name="grade_param"]').val();
	parent = $form.find('input[name="parent"]').val(),
	a=$form.find('input[name="action_type"]').val();
	servlet= $form.attr('action');
	$.ajax
	({
		cache:false,
		type:'POST',
		url:servlet,
		data:{
			id:parentId,
			cn:parentName,
			cn:parentGrade,
			ci:parent,
			action_type:a				
			
			 },
		datatype:'html',
		success:function(result)
		{
			
			$("#parent_rows").html($(result).find("#table3")); 
			$('#parent_rows').show();
		}
	});
	}








/*var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.scrollY >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
*/


