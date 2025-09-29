package Servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.sql.*;

/**
 *
 * @author DELL
 */
@WebServlet(name = "RememberMeServlet", urlPatterns = {"/RememberMeServlet"})
public class RememberMeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection con = null;
        Statement st;

        try {
            String username = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/dbemp?useSSL=false";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                out.println("<BR>Successfully connected to MySQL servler using TCP/IP...<BR>");
                st = con.createStatement();

                String query = "SELECT user FROM login WHERE user = '" + request.getParameter("txtusername").toString() + "' AND password ='" + request.getParameter("txtpassword").toString() + "'";
                ResultSet rs = st.executeQuery(query);

                if (rs.next() == false) {
                    out.println("<BR>Sorry. Invalid Login.Please try again.</BR>");
                } else {
                    out.println("<BR>Successful Login.Welcome to the world of Servlets.</BR>");
                    if (request.getParameter("chkrem") != null) {
                        Cookie returnLoginUser = new Cookie("ValidUser", request.getParameter("txtusername").toString());
                        returnLoginUser.setMaxAge(36000);
                        response.addCookie(returnLoginUser);
                        Cookie returnLoginPassword = new Cookie("ValidPassword", request.getParameter("txtpassword").toString());
                        returnLoginPassword.setMaxAge(36000);
                        response.addCookie(returnLoginPassword);
                    } else {
                        Cookie returnLoginUser = new Cookie("ValidUser", "");
                        returnLoginUser.setMaxAge(0);
                        response.addCookie(returnLoginUser);
                        Cookie returnLoginPassword = new Cookie("ValidPassword", "");
                        returnLoginPassword.setMaxAge(0);
                        response.addCookie(returnLoginPassword);
                        out.println("<BR><BR>You did not choose to remember the login information.Hence you will need to enter login details the next time you visit us.");
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet RememberMeServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet RememberMeServlet at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}

