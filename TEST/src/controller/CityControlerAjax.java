package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.CityDA;
import model.city;


@WebServlet("/CityControlerAjax")
public class CityControlerAjax extends HttpServlet {
     	private static final long serialVersionUID = 1L;

        public static final String LIST_CITY="/CityAjax.jsp";
        public static final String FORM_CITY="/form_CityAjax.jsp";


        //הפנייה ל
        // DA
        CityDA myCityDA;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityControlerAjax() {
        super();
        // TODO Auto-generated constructor stub

        myCityDA=new CityDA();
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

                if(action.equalsIgnoreCase("listCity"))
                {
                        forward=LIST_CITY;
                        List<city> list=myCityDA.getAllcitys();
                        request.setAttribute("cities", list);
                }
                
                else if(action.equalsIgnoreCase("delete"))
                {
                	forward=LIST_CITY;
                	int cityID=Integer.valueOf(request.getParameter("id"));
                	myCityDA.deleteCity(cityID);
                	List<city> list=myCityDA.getAllcitys();
                	request.setAttribute("cities", list);
                	response.setContentType("text/html");
                }
                
                
                else if(action.equalsIgnoreCase("update"))
                {
                	forward=FORM_CITY;
                	int cityID=Integer.valueOf(request.getParameter("id"));
                	city city=myCityDA.getCityByID(cityID);
                	request.setAttribute("sumcity", city);
                	response.setContentType("text/html");
                }
                
                else if(action.equalsIgnoreCase("insert"))
                {
                	forward=FORM_CITY;
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
        		city city=new city();
        		request.setCharacterEncoding("UTF-8");
        		
        		String name=request.getParameter("cn");
        		city.setCityName(name);
        		
                String idString=request.getParameter("id");
                String action_type=request.getParameter("action_type");
                
                if(idString == null || idString.isEmpty())
                {
                	// 
                }
                else
                {
                	int id=Integer.valueOf(idString);
                	city.setRid(id);
                	
                	if(action_type.equals("Update"))
                	{
                		myCityDA.updateCity(city);
                	}
                	else
                	{
                		myCityDA.addCity(city);
                	}
                }
                
                // דומה למה שכבר עשינו ב doget                
                List<city> list=myCityDA.getAllcitys();
                request.setAttribute("cities", list);
                RequestDispatcher dispatcher=request.getRequestDispatcher(LIST_CITY);
                dispatcher.forward(request, response);
                
        }

}