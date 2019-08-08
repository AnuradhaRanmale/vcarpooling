package com.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DBConnection;
public class Search extends HttpServlet{

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
		{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			String origin=req.getParameter("origin");
			try
			{
				Connection con=DBConnection.getCon();
				PreparedStatement ps=con.prepareStatement("select * from search where origin=?");
				ps.setString(1,origin);
				ResultSet rs=ps.executeQuery();
				pw.print("<center><table border=2 bordercolor='blue'></center>");
				pw.print("<tr><td>origin</td><td>destination</td><td>Details</td><td>Type</td><td>Start Time</td><td>Return Time</td><td>Contact No.</td></tr>");
				
				while(rs.next())
				{
					pw.print("<tr><td>"+rs.getString(1)+"</td>"+" "+"<td>"+rs.getString(2)+" </td>"+"  "+"<td>"+rs.getString(3)+"</td>"+" "+"<td>"+rs.getString(4)+"</td>"+" "+"<td>"+rs.getString(5)+"</td>"+" "+"<td>"+rs.getString(6)+"</td>"+" "+"<td>"+rs.getString(7)+" </td>");
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

	}


