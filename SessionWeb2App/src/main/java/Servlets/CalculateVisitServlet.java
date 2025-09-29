/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CalculateVisitServlet", urlPatterns = {"/CalculateVisitServlet"})
public class CalculateVisitServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int Counter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        boolean newVisitor = true;
        Cookie[] visitCookie = request.getCookies();

        if (visitCookie != null) {
            for (int i = 0; i < visitCookie.length; i++) {
                if ((visitCookie[i].getName().equals("oldVisitor")) && (visitCookie[i].getValue().equals("1"))) {
                    newVisitor = false;
                    break;
                }
            }
        }
        if (newVisitor) {
            Cookie returnVisitorCookie = new Cookie("oldVisitor", "1");
            Cookie visitorCounter = new Cookie("cnt", "1");
            returnVisitorCookie.setMaxAge(3600);
            response.addCookie(returnVisitorCookie);
            visitorCounter.setMaxAge(3600);
            response.addCookie(visitorCounter);
            out.println("This is the first time you have visited this page");
        } else {
            out.println("Welcome back to this page");
            Cookie[] c = request.getCookies();
            if (c != null) {
                Cookie tc = null;
                for (int i = 0; i < c.length; i++) {
                    if (c[i].getName().equals("cnt")) {
                        tc = c[i];
                        Counter = Integer.parseInt(c[i].getValue());
                        break;
                    }
                }
                Counter++;
                tc.setValue(Integer.toString(Counter));
                tc.setMaxAge(3600);
                response.addCookie(tc);
                out.println("<BR><B>You have visited this page " + Counter + "time(s)</B>");

            }
        }
    }
}
