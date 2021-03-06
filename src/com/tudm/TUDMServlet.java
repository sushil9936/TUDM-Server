package com.tudm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TUDMServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		try {
			String fileName=request.getParameter("song_name");
			String PlayListName=request.getParameter("PlayListName");
		  stream = response.getOutputStream();
		  File mp3 = new File(request.getSession().getServletContext().getRealPath("/"+PlayListName+"/"+fileName));

		  //set response headers
		  response.setContentType("audio/mpeg"); 

		  response.addHeader("Content-Disposition", "attachment; filename=" +fileName );

		  response.setContentLength((int) mp3.length());

		  FileInputStream input = new FileInputStream(mp3);
		  buf = new BufferedInputStream(input);
		  int readBytes = 0;
		  //read from the file; write to the ServletOutputStream
		  while ((readBytes = buf.read()) != -1)
		    stream.write(readBytes);
		} catch (IOException ioe) {
		  throw new ServletException(ioe.getMessage());
		} finally {
		  if (stream != null)
		    stream.close();
		  if (buf != null)
		    buf.close();
		}
	}
}
