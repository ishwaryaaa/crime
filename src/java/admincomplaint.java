/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java .sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16060
 */
public class admincomplaint extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet students</title>");            
            out.println("</head>");
            out.println("<body style='background-color:#CEF6F5'>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root","");
                PreparedStatement ps = con.prepareStatement("select * from complaint");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>COMPLAINT DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>ID </th>"
                        + "<th>NAME</th>"
                        +"<th>ADDRESS</th>"
                        +"<th>PHONE NUMBER</th>"
                        +"<th>OCCUPATION</th>"
                        +"<th>DATE OF BIRTH</th>"
                        +"<th>DATE OF INCIDENT</th>"
                        +"<th>LOCATION</th>"
                        +"<th>DESCRIPTION</th>"
                        +"<th>WITNESS</th>"
                       +"<th>SELECT</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    int id = rs.getInt("cid");
                    String name = rs.getString("cname");
                    String add = rs.getString("caddress");
                    
                    int ph = rs.getInt("cphone");
                    String job = rs.getString("cjob");
                     int dob = rs.getInt("dob");
                   int date = rs.getInt("date_of_incident");
                    String loc = rs.getString("clocation");
                   String desc= rs.getString("cdescription");
                    String wit = rs.getString("witness");
                    
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +id+"<td width ='20%' >"+name+"<td > "+add+"<td > "+ ph+" <td> "+job+" <td> "+dob+"<td >  "+date+"  <td> "+loc+"<td> "+desc+"<td> "+wit+"<td>"+"<input type = \"radio\" name = \"Q1\" value=\"True\">"+"</tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                    
                   
                }
                 out.println("</table>");
                 out.println("<br>");
                   
                    out.println("<br>");
                    
                    
                 out.println ("<CENTER> <button type='submit' onclick='admin_inner_status.html' name='Submit'>UPDATE</button></CENTER> "); 
                con.close();
                
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

