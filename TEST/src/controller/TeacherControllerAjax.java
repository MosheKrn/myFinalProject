package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.teacherDA;
import model.Teacher;


/**
 * Servlet implementation class StudentControler
 */
//@WebServlet("/TeacherControllerAjax")
public class TeacherControllerAjax  extends HttpServlet {
     	private static final long serialVersionUID = 1L;

        public static final String LIST_TEACHER="/teacherAjax.jsp";
        public static final String FORM_TEACHER="/form_teacherAjax.jsp";


        //הפנייה ל
        // DA
       teacherDA myTeacherDA;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherControllerAjax() {
        super();
        // TODO Auto-generated constructor stub

        myTeacherDA = new teacherDA();
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request,
	HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse
        	response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                //response.getWriter().append("Served at: ").append(request.getContextPath());

                String action=request.getParameter("action");
                String forward="";

                if(action.equalsIgnoreCase("listTeacher"))
                {
                        forward=LIST_TEACHER;
                        List<Teacher> list=myTeacherDA.getAllTeachers();
                        request.setAttribute("Teachers", list);
                        response.setContentType("text/html");
                }
                
                else if(action.equalsIgnoreCase("delete"))
                {
                	forward=LIST_TEACHER;
                	int teacherID=Integer.valueOf(request.getParameter("id"));
                	myTeacherDA.deleteTeacher(teacherID);
                	List<Teacher> list=myTeacherDA.getAllTeachers();
                	request.setAttribute("Teachers", list);
                	response.setContentType("text/html");
                }
                
                
                else if(action.equalsIgnoreCase("update"))
                {
                	forward=FORM_TEACHER;
                	int parentID=Integer.valueOf(request.getParameter("id"));
                	Teacher teacher=myTeacherDA.getTeacherByID(parentID);
                	request.setAttribute("someParent", teacher); 
                	response.setContentType("text/html");
                }
                
                else if(action.equalsIgnoreCase("insert"))
                {
                	forward=FORM_TEACHER;
                	request.setAttribute("action", "add");
                	
                }




        RequestDispatcher dispatcher=request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);

        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request,
	HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
        	Teacher teacher=new Teacher();
        	request.setCharacterEncoding("UTF-8");
        	
        	String name=request.getParameter("name");
        	teacher.setTeacherName(name);
                String idString=request.getParameter("id");
                String action_type=request.getParameter("a");
                
                if(idString == null || idString.isEmpty())
                {
                	// 
                }
                else
                {
                	int id=Integer.valueOf(idString);
                	teacher.setTeacherID(id);
                	
                	if(action_type.equals("Update"))
                	{
                	myTeacherDA.updateTeacher(teacher);
                	}
                	else
                	{
                	myTeacherDA.addTeacher(teacher);
                	}
                }
                
                // דומה למה שכבר עשינו ב doget                
                List<Teacher> list=myTeacherDA.getAllTeachers();
                request.setAttribute("Teachers", list);
                RequestDispatcher dispatcher=request.getRequestDispatcher(LIST_TEACHER);
                dispatcher.forward(request, response);
                
        }

}

