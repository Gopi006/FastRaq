package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.DataBean;
import com.securecloud.bean.FileTo;
import com.securecloud.dao.UserdaoImpl;

public class ViewADLUserQueryAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileTo rto = new FileTo();

		String path = "";
		boolean flag = false;

		ArrayList<DataBean> v1 = null;
		try {

			v1 = new UserdaoImpl().getuserquery1();
			System.out.println(" vector size sanjay " + v1.size());
			if (v1 != null) {
				request.setAttribute("tsb1", v1);

				path = "ViewADLUserQuery.jsp";

			} else {

				path = "ViewADLUserQuery.jsp";
			}
		} catch (Exception e) {

			path = "ViewADLUserQuery.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
