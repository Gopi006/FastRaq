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

public class GeetingSignatureAction extends HttpServlet {

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
		String login = (String) s.getAttribute("UserName");

		System.out.println(" username from session is " + login);
		rto.setUsername(login);
		String signature = request.getParameter("signature");

		try {
			String role = null;
			role = new UserdaoImpl().getSignature(login, signature);
			if (role != null) {

				request.setAttribute("status",
						"Your Signature Code is Correct. Access the File Data");

				path = "./verifyrole.jsp";
			} else {
				request.setAttribute("status1", " ");
				path = "./verifyrole.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("status", " Please Enter Valid File");
			path = "GetFile.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
