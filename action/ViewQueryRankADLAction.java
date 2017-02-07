package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.FileTo;
import com.securecloud.dao.UserdaoImpl;

public class ViewQueryRankADLAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileTo rto = new FileTo();

		String path = "";
		boolean flag = false;

		try {

			Vector v = new UserdaoImpl().getQueryRankADL();
			System.out.println(" vector size sanjay " + v.size());
			if (v != null) {
				request.setAttribute("tsb", v);

				path = "ViewQueryRankADL.jsp";

			} else {

				path = "ViewQueryRankADL.jsp";
			}
		} catch (Exception e) {

			path = "ViewQueryRankADL.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
