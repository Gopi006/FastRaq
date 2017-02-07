package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.securecloud.bean.FileTo;
import com.securecloud.dao.UserdaoImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class GettingKeyAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileTo rto = new FileTo();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();

		}
		String path = "";
		boolean flag = false;
		HttpSession s = request.getSession();
		String login = (String) s.getAttribute("username");

		System.out.println(" username from session is " + login);
		rto.setUsername(login);

		try {

			FileTo b = new UserdaoImpl().getKey(rto);
			if (b != null) {
				request.setAttribute("b", b);
				request.setAttribute("status", "your key related to file");

				path = "ShowKey.jsp";
			} else {
				request.setAttribute("status", " Please Enter Valid File");
				path = "ShowKey.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("status", " Please Enter Valid File");
			path = "ShowKey.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
