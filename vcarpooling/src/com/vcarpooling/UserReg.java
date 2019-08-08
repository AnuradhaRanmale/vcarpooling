package com.vcarpooling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserReg  extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String Name=req.getParameter("name");
		String EmailID=req.getParameter("email");
		String MobileNo=req.getParameter("mobileno");
		String Pass=req.getParameter("password");
		
	}
}
