/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;//step1

/**
 *
 * @author parth
 */

public class InsertData extends HttpServlet {

    /**
     *
     * @param rq
     * @param rs
     */
    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rs)
    {
        try
        {
            rs.setContentType("text/html");
            PrintWriter out=rs.getWriter();
            Connection con=null;
            //client information
            String a=rq.getParameter("t1");
            String b=rq.getParameter("t2");
            String c=rq.getParameter("t3");
            try{
                Class.forName("com.mysql.jdbc.Driver");//step2 register the driver
                con=DriverManager.getConnection("jdbc:,mysql://localhost:3306/cse?autoReconnect=true&useSSL=false","root","root");
            }
            catch(Exception e)
            {
                out.print(e.getMessage());
            }
            Statement st=con.createStatement();
            String query="insert into registration values('"+a+"','"+b+"','"+c+"')";
            st.executeUpdate(query);
            out.print("Data Submitted");
            //rq.getRequestDispatcher("index.html").include(rq, rs);
        }
        catch(Exception e)
        {
        }
    }
}
            