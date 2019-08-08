package com.Vcarpooling;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DBConnection;

public class UserRegistration extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String EmpID=req.getParameter("empid");
		String Name=req.getParameter("name");
		String EmailID=req.getParameter("email");
		String MobileNo=req.getParameter("mobileno");
		String Address=req.getParameter("address");
		String UserName=req.getParameter("username");
		String Password=req.getParameter("password");
		String Repassword=req.getParameter("repassword");
		String BirthDate=req.getParameter("bday");
		String Gender=req.getParameter("gender");
		try
	    {
	    	Connection con=DBConnection.getCon();
	    	PreparedStatement ps=con.prepareStatement("insert into UserDetails values(?,?,?,?,?,?,?,?,?,?)");
	    	ps.setString(1,EmpID);
	    	ps.setString(2,Name);
	    	ps.setString(3,EmailID);
	    	ps.setString(4,MobileNo);
	    	ps.setString(5,Address);
	    	ps.setString(6,UserName);
	    	ps.setString(7,Password);
	    	ps.setString(8,Repassword);
	    	ps.setString(9,BirthDate);
	    	ps.setString(10,Gender);
	    	
	    	int i=ps.executeUpdate();
	    	if(i>0)
	    	{
	    		System.out.println("Registered Successfully");
	    	}
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
		
	}

}
