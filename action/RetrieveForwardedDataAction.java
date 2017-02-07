package com.securecloud.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.AutoMobile;
import com.securecloud.dao.UserdaoImpl;

public class RetrieveForwardedDataAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AutoMobile rto = new AutoMobile();

		String path = "";
		boolean flag = false;
		String s1 = request.getParameter("s1");

		try {

			Vector v = new UserdaoImpl().retreveFilesFromServer3(rto);
			System.out.println(" vector size sanjay " + v.size());
			if (v != null) {

				request.setAttribute("tsb", v);

				path = "ViewKeywordCount.jsp";
			} else {

				request.setAttribute("tsb", v);

				path = "3";
			}

		} catch (Exception e) {

			path = "ViewKeywordCount.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
