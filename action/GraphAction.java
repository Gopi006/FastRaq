package com.securecloud.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.securecloud.bean.AutoMobile;
import com.securecloud.bean.RegisterBean;
import com.securecloud.dao.UserdaoImpl;

public class GraphAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "";
		double d = 0, c = 0;
		try {
			HttpSession session = request.getSession();
			RegisterBean rto = new RegisterBean();

			AutoMobile r = new AutoMobile();
			long l1 = r.getEtime();
			long l2 = r.getPtime();
			long l3 = r.getAtime();

			request.setAttribute("d", l1);
			request.setAttribute("c", l2);
			request.setAttribute("e", l3);

			path = "Graph.jsp";

		} catch (Exception e) {
			e.printStackTrace();

		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
