package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.parentDA;
import model.Parent;


@WebServlet("/ParentControllerAjax")
public class ParentControllerAjax  extends HttpServlet {
     	private static final long serialVersionUID = 1L;

        public static final String LIST_PARENT="/parentAjax.jsp";
        public static final String FORM_PARENT="/form_parentAjax.jsp";


        //הפנייה ל
        // DA
       parentDA myParentDA;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParentControllerAjax() {
        super();
        // TODO Auto-generated constructor stub

        myParentDA = new parentDA();
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

                if(action.equalsIgnoreCase("listParent"))
                {
                        forward=LIST_PARENT;
                        List<Parent> list=myParentDA.getAllParents();
                        request.setAttribute("Parents", list);
                     
                }
                
                else if(action.equalsIgnoreCase("delete"))
                {
                	forward=LIST_PARENT;
                	int parentID=Integer.valueOf(request.getParameter("id"));
                	myParentDA.deleteParent(parentID);
                	List<Parent> list=myParentDA.getAllParents();
                	request.setAttribute("Parents", list);
                	response.setContentType("text/html");
                }
                
                
                else if(action.equalsIgnoreCase("update"))
                {
                	forward=FORM_PARENT;
                	int parentID=Integer.valueOf(request.getParameter("id"));
                	Parent parent=myParentDA.getParentByID(parentID);
                	request.setAttribute("someParent", parent); 
                	response.setContentType("text/html");
                }
                
                else if(action.equalsIgnoreCase("insert"))
                {
                	forward=FORM_PARENT;
                	request.setAttribute("action", "add");
                	RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
            		dispatcher.forward(request, response);
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
        	Parent parent=new Parent();
        	request.setCharacterEncoding("UTF-8");
        	
        	String name=request.getParameter("cn");
        	parent.setParentName(name);
                String idString=request.getParameter("id");
                String action_type=request.getParameter("action_type");
                
                if(idString == null || idString.isEmpty())
                {
                	// 
                }
                else
                {
                	int id=Integer.valueOf(idString);
                	parent.setParentID(id);
                	
                	if(action_type.equals("update"))
                	{
                	myParentDA.updateParent(parent);
                	}
                	else
                	{
                	myParentDA.addParent(parent);
                	}
                }
                
                               
                List<Parent> list=myParentDA.getAllParents();
                request.setAttribute("Parents", list);
                RequestDispatcher dispatcher=request.getRequestDispatcher(LIST_PARENT);
                dispatcher.forward(request, response);
                
        }

}

