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
import com.securecloud.bean.DataBean;
import com.securecloud.dao.AdminDAO;
import com.securecloud.dao.LoginDAO;
import com.securecloud.dao.UserdaoImpl;
import com.securecloud.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ViewSearchDataAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "";

		boolean flag = false;
		try {

			HttpSession session = request.getSession();
			DataBean db = new DataBean();
			String login = (String) request.getSession().getAttribute(
					"username");
			System.out.println("in action Class login is........." + login);
			String query = request.getParameter("query");
			session.setAttribute("query", query);
			if (session.getAttribute("v") == null) {
				Vector<DataBean> v = new Vector<DataBean>();
				db.setQuery(query);
				db.setUserName(login);
				v.add(db);
				session.setAttribute("v", v);
				System.out.println(v.size());
			} else {
				Vector<DataBean> v1 = (Vector) session.getAttribute("v");
				db.setQuery(query);
				db.setUserName(login);
				v1.add(db);
				System.out.println("size=====>" + v1.size());
			}

			flag = new UserdaoImpl().inserADLReq(login, query);

			if (flag) {

				path = "Search.jsp";
				request.setAttribute("status",
						"your request is submitted to ADL");

			} else {

				path = "Search.jsp";
				request.setAttribute("status", "No Users  Available ");

			}

		} catch (Exception e) {
			e.printStackTrace();
			path = "Search.jsp";
			request.setAttribute("status", "No Users Available");
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
