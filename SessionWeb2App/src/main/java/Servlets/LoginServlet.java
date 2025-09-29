/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 *
 * @author DELL
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = "";
        String password = "";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie thisCookie = cookies[i];

                if (thisCookie.getName().equals("ValidUser")) {
                    username = thisCookie.getValue();
                } else if (thisCookie.getName().equals("ValidPassword")) {
                    password = thisCookie.getValue();
                }
            }
        }

            out.println("<HTML><HEAD><TITLE>Login Form</TITLE></HEAD>");
            out.println("<BODY><FORM ACTION='/SessionWeb2App/RememberMeServlet' METHOD='post' NAME='formLogin'>");
//            out.println("<TABLE><TR><TD ALIGN='center'><IMG SRC='/images/login_security.jpeg' width='64' HEIGHT='64' BORDER='0'>");
            out.println("<TABLE WIDTH='25%' BORDER='1' ALIGN='center' CELLPADDING='3' CELLSPACING='1' BORDERCOLOR='#000000'>");
            out.println("<TR BORDERCOLOR='#92CAEB' BGCOLOR='white'><TD COLSPAN='2'>Member Login</TD></TR>");
            out.println("<TR BORDERCOLOR='#E6F3FB'><TD ALIGN='right'>Username:</TD><TD>");
            out.println("<INPUT NAME='txtusername' TYPE='text' TABINDEX='1' VALUE='" + username + "' SIZE='15' MAXLENGTH='15'></TD>");
            out.println("</TR><TR BORDERCOLOR='#E6F3FB'><TD ALIGN='right'>Password:</TD><TD>");
            out.println("<INPUT NAME='txtpassword' TYPE='password' TABINDEX='2' VALUE='" + password + "' SIZE='15' MAXLENGTH='15'></TD></TR>");
            out.println("<TR BORDERCOLOR='#E6F3FB'><TD COLSPAN='2' ALIGN='right'>");
            out.println("<INPUT NAME='chkrem' TYPE='checkbox' VALUE='REMEMBER' TABINDEX='3'>REMEMBER ME</TD></TR>");
            out.println("<TR BORDERCOLOR='#E0EEF7'><TD COLSPAN='2' ALIGN='right'>");
            out.println("<INPUT NAME='submit' TYPE='submit' VALUE='Sign In' TABINDEX='4'></TD></TR>");
            out.println("</TABLE></TD></TR></TABLE></FORM></BODY></HTML>");

            /* TODO output your page here. You may use following sample code. */
            out.close();
        }
    }   

