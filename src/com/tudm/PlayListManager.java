package com.tudm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


public class PlayListManager extends HttpServlet {
		public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter out = res.getWriter();
		 String PLAYLIST_NAME=request.getParameter("PLAYLIST_NAME");
		res.setContentType("application/json");
	        res.setCharacterEncoding("UTF-8");
	        StringBuffer sb=new StringBuffer();
	        JSONObject json = new JSONObject();
	        File songFolder = new File(request.getSession().getServletContext().getRealPath("/"+PLAYLIST_NAME));
	        List<String> list = new ArrayList<String>();
	        int i=1;
	        for (File pdf : songFolder.listFiles()) { // Line 27
	            //out.println(pdf.getName());
	        	try {
					json.put("song"+i,pdf.getName());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	i++;
	        	//list.add(pdf.getName());
	        }
	        
	       
	        /*try {
				json.put("songslist",list);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	        //String json = new Gson().toJson(list);
	     
	        res.getWriter().write(json.toString());
	        out.println(sb.toString());
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
