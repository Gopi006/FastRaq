package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.RegisterBean;
import com.securecloud.dao.LoginDAO;
import com.securecloud.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class RegisteruserAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;
		String path = "";

		RegisterBean rb = new RegisterBean();
		try {
			Map map = request.getParameterMap();
			BeanUtils.populate(rb, map);

			flag = new LoginDAO().registerUser(rb);
			if (flag) {
				path = UtilConstants._SUCCESS_PAGE;
				request.setAttribute("status", " Registration Sucessfully....");

			} else {
				path = UtilConstants._LOGIN_PAGE;
				request.setAttribute("status", UtilConstants._ADDED_FAILED);
			}
		} catch (Exception e) {
			path = UtilConstants._LOGIN_PAGE;
			request.setAttribute("status", UtilConstants._ADDED_FAILED);

		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
