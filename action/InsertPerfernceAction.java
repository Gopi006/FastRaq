package com.securecloud.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.AutoMobile;
import com.securecloud.dao.UserdaoImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class InsertPerfernceAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AutoMobile rto = new AutoMobile();
		boolean flag = false;
		String path = "";
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();
		}

		String id[] = request.getParameterValues("check");
		for (int i = 0; i < id.length; i++) {
			rto.setSid(id[i]);
			System.out.println("value is----->" + id[i]);
			try {
				String login = (String) request.getSession().getAttribute(
						"username");
				System.out.println("username is----->" + login);
				flag = new UserdaoImpl().InsertData1(rto, login);

				System.out.println("in Action class vcb..........." + flag);
				if (flag) {
					request.setAttribute("status",
							"Data Inserted to DB Successfully");
					path = "./userhomepage.jsp";
				} else {
					request.setAttribute("status", "Data Inserting Fail");
					path = "./userhomepage.jsp";
				}

			} catch (Exception e) {
				request.setAttribute("status", "Some Technical Problems");
				path = "./userhomepage.jsp";
				e.printStackTrace();

			}
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

		}

	}
}
