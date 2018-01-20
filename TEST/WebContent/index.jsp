<html lang="he" dir="rtl">

    <head>
     <%@ page language="java" contentType="text/html; charset=UTF-8"%>
        <title>כניסת משתמשים</title>
    </head>
    
 <style>
 @import url('https://fonts.googleapis.com/css?family=Secular+One');
 
body
{
    background: url("BOOKS.jpg") fixed;
    background-size: cover;
    font-family: 'Secular One', sans-serif;
}


.login{
    
    font-size: 80px;
    font-weight: 700;
    text-align: center;
    color: white;
    font-family: 'Secular One', sans-serif;
    margin-top: 100px;
    margin-bottom: 100px;
    margin-right: 350px;
    margin-left: 200px;
    background-color: #99ebff;
    width: 35%;
    
}


 </style>
 
    <body>
        <%
        String email=(String)session.getAttribute("email");
        
        //redirect user to home page if already logged in
        if(email!=null){
            response.sendRedirect("home.jsp");
        }
 
        String status=request.getParameter("status");
        
        if(status!=null){
            if(status.equals("false")){
                   out.print("פרטי משתמש שגויים!");                       
            }
            else{
                out.print("משהו לא תקין!");
            }
        }
        %>
    
        <form action="loginRequestHandler.jsp">
        <div class="login">
            <table cellpadding="20" align="center">
                <tr>
                    <td><b>דואר אלקטרוני:</b></td>
                    <td><input type="text" name="email" required/></td>
                </tr>
 
                <tr>
                    <td><b>סיסמא:</b></td>
                    <td><input type="password" name="password" required/></td>
                </tr>
 
                <tr>
                    <td colspan="8" align="center"><input type="submit" value="כניסה"/></td>
                </tr>
 
            </table>
             </div>
        </form>
       
    </body>
    
</html>


