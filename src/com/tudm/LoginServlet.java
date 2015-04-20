package com.tudm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class LoginServlet  extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		
		}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			doGet(request,response);
			String userName=request.getParameter("username");
			String password=request.getParameter("username");
			JSONObject json = new JSONObject();
			if(userName.equalsIgnoreCase("Sushil") && password.equalsIgnoreCase("Sushil"))
			{
				
				try {
					json.put("UserAuthenticated","User is Authenticated");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			response.getWriter().write(json.toString());
			
		}


}
