package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.securecloud.bean.FileTo;
import com.securecloud.dao.DataDAO;

public class ViewUserSeachDataAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileTo rto = new FileTo();

		String path = "";
		boolean flag = false;

		HttpSession session = request.getSession();

		String login = (String) request.getSession().getAttribute("username");

		System.out.println("in action Class login is........." + login);
		try {
			ArrayList<FileTo> tsb = null;
			tsb = new DataDAO().viewuserdata(login);
			System.out.println(" array size  " + tsb.size());
			if (tsb != null) {
				request.setAttribute("tsb", tsb);

				path = "ViewUserQueryData.jsp";

			} else {

				path = "ViewUserQueryData.jsp";
			}
		} catch (Exception e) {

			path = "ViewUserQueryData.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
