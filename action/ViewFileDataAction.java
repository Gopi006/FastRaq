package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.securecloud.bean.FileTo;
import com.securecloud.dao.DataDAO;
import com.securecloud.dao.UserdaoImpl;

public class ViewFileDataAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileTo rto = new FileTo();

		String path = "";
		boolean flag = false;
		HttpSession session = request.getSession();

		String login = (String) request.getSession().getAttribute("username");

		System.out.println("in action Class login is........." + login);

		String filename = request.getParameter("filename");
		String query = request.getParameter("query");
		System.out.println("in filename is........." + filename);
		try {
			ArrayList<FileTo> tsb = null;
			tsb = new DataDAO().viewfiledata(filename, login, query);
			System.out.println(" array size  " + tsb.size());
			if (tsb != null) {
				request.setAttribute("tsb", tsb);

				path = "ViewFileData.jsp";

			} else {

				path = "ViewFileData.jsp";
			}
		} catch (Exception e) {

			path = "ViewFileData.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
