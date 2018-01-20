package controller;

	import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.childDA;
import model.Child;

	
	@WebServlet("/ChildControllerAjax")
	public class ChildControllerAjax  extends HttpServlet {
	     	private static final long serialVersionUID = 1L;

	        public static final String LIST_CHILD="/childAjax.jsp";
	        public static final String FORM_CHILD="/form_childAjax.jsp";


	        //הפנייה ל
	        // DA
	        childDA myChildDA;


	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ChildControllerAjax() {
	        super();
	        // TODO Auto-generated constructor stub

	        myChildDA = new childDA();
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

	                if(action.equalsIgnoreCase("listChild"))
	                {
	                        forward=LIST_CHILD;
	                        List<Child> list=myChildDA.getAllChildren();
	                        request.setAttribute("Children", list);
	                      
	                }
	                
	                else if(action.equalsIgnoreCase("delete"))
	                {
	                	forward=LIST_CHILD;
	                	int childID=Integer.valueOf(request.getParameter("id"));
	                	myChildDA.deleteChild(childID);
	                	List<Child> list=myChildDA.getAllChildren();
	                	request.setAttribute("Children", list);
	                	response.setContentType("text/html");
	                }
	                
	                
	                else if(action.equalsIgnoreCase("update"))
	                {
	                	forward=FORM_CHILD;
	                	int childID=Integer.valueOf(request.getParameter("id"));
	                	Child child=myChildDA.getChildByID(childID);
	                	request.setAttribute("someChild", child); 
	                	response.setContentType("text/html");
	                }
	                
	                else if(action.equalsIgnoreCase("insert"))
	                {
	                	forward=FORM_CHILD;
	                	
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
	        	Child child=new Child();
	        	request.setCharacterEncoding("UTF-8");
	        	
	        	String name=request.getParameter("cn");
	        	child.setChildName(name);
        		
                String idString=request.getParameter("id");
                String action_type=request.getParameter("action_type");
                
	                
	                if(idString == null || idString.isEmpty())
	                {
	                	// 
	                }
	                else
	                {
	                	int id=Integer.valueOf(idString);
	                	child.setChildID(id);
	                	
	                	if(action_type.equals("Update"))
	                	{
	                	myChildDA.updateChild(child);
	                	}
	                	else
	                	{
	                	myChildDA.addChild(child);
	                	}
	                }
	                
	                // דומה למה שכבר עשינו ב doget                
	                List<Child> list=myChildDA.getAllChildren();
	                request.setAttribute("Children", list);
	                RequestDispatcher dispatcher=request.getRequestDispatcher(LIST_CHILD);
	                dispatcher.forward(request, response);
	                
	        }

	}
	
	
	