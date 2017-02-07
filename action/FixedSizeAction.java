package com.securecloud.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FixedSizeAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int i1 = 10, i2 = 20, i3 = 21, i4 = 22, i5 = 25;

		int fvalue = Integer.parseInt(request.getParameter("fix"));
		int l4 = Integer.parseInt(request.getParameter("l"));

		HttpSession session = request.getSession();

		if (i1 > l4) {
			session.setAttribute("rmsg", "msg");
			session.setAttribute("r", (i1 - l4));
			String path = "./ThresholdAction";

		} else {

		}

		System.out.print(fvalue - l4);
		session.setAttribute("r", (fvalue - l4));
		session.setAttribute("rmsg", "msg");

		String path = "./ThresholdAction";

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
