/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;

/**
 *
 * @author DELL
 */
@WebServlet(name = "DisplaySessionServlet", urlPatterns = {"/DisplaySessionServlet"})
public class DisplaySessionServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession mySession = request.getSession(true);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String heading;
        Integer counter = new Integer(0);
        if (mySession.isNew()) {
            heading = "This is the first time you are visiting this page";
        } else {
            heading = "Welcome back to this page";
            Integer oldCounter = (Integer) mySession.getAttribute("counter");
            if (oldCounter != null) {
                counter = new Integer(oldCounter.intValue() + 1);
            }
        }
        
        mySession.setAttribute("counter", counter);
        out.println("<HTML><HEAD><TITLE>Welcome To the World of Session</TITLE></HEAD>");
        out.println("<H3>" + heading + "</H3><BR>");
        out.println("<B>Session ID: </B>" + mySession.getId() + "<BR>");
        out.println("<B>Creation Time of the Session: </B>" + new Date(mySession.getCreationTime()) + "<BR>");
        out.println("<B>Time of Last Access: </B>" + new Date(mySession.getLastAccessedTime()) + "<BR><BR>");
        out.println("You have visited this page " + (++counter));
        out.println((counter == 1) ? " time " : " times ");
        out.println("</BODY></HTML>");
        
        mySession.setMaxInactiveInterval(2);
    }
    
}
