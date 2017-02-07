package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.securecloud.bean.FileTo;
import com.securecloud.dao.DataDAO;

public class UserSelectDataAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileTo rto = new FileTo();

		String path = "";
		boolean flag = false;
		HttpSession session = request.getSession();

		String login = (String) request.getSession().getAttribute("username");

		System.out.println("in action Class login is........." + login);

		String filename = request.getParameter("filename");
		String data = request.getParameter("data");
		String query = request.getParameter("query");
		System.out.println("in filename is........." + filename);
		String data1 = null;
		int count = 0;
		int percentage = 10;
		StringTokenizer st = new StringTokenizer(data);
		while (st.hasMoreTokens()) {
			data1 = st.nextToken();
			System.out.println(data1);
			if (query.equalsIgnoreCase(data1))

			{
				count++;
			}
		}
		System.out.println("in count." + count);
		if (count == 1) {
			percentage = 10;
		}
		if (count == 2) {
			percentage = 20;
		}
		if (count == 3) {
			percentage = 40;
		}
		if (count == 4) {
			percentage = 50;
		}
		if (count == 5) {
			percentage = 75;
		}
		if (count == 6) {
			percentage = 85;
		}
		if (count > 6) {
			percentage = 100;
		}

		System.out.println("in count." + percentage);
		try {
			boolean tsb = false;
			tsb = new DataDAO().userselectdata(filename, data, login, query,
					percentage);

			if (tsb) {

				path = "./ViewUserSeachDataAction";

			} else {

				path = "./ViewUserSeachDataAction";
			}
		} catch (Exception e) {

			path = "ViewFileData.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
