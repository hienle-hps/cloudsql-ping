package com.example.appengine.java8;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloAppEngine", value = "/*")
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
	// TODO Change INSTANCE_CONNECTION_NAME  
	try (Connection c = DriverManager.getConnection("jdbc:google:mysql://INSTANCE_CONNECTION_NAME/?user=root&password=root")){
		try (ResultSet rs = c.prepareStatement("SELECT 1").executeQuery()) {
			rs.next();
			response.setContentType("text/plain");
		    response.getWriter().println(rs.getString(1));
		}
	} catch (SQLException e) {
		throw new IOException(e);
	}
  }
}
