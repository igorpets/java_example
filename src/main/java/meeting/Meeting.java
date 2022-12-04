package meeting;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Meeting extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static String dataString = "[]";

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        ResourceBundle rb =
                ResourceBundle.getBundle("LocalStrings", request.getLocale());
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", "http://192.168.100.140:8080/myapp/servlets/servlet/HelloWorldExample");

        PrintWriter out = response.getWriter();
        out.println(dataString);
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String _dataString = request.getParameter("dataString");
        if (_dataString != null) dataString = _dataString;
        doGet(request, response);

    }

}


