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

public class UploadAction2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int i = 0;
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

		try {

			String login = (String) request.getSession().getAttribute(
					"username");
			flag = new UserdaoImpl().upload2(rto);

			System.out.println("in Action class vcb..........." + flag);
			if (flag) {
				request.setAttribute("status",
						"Data Inserted to DB Successfully");
				path = "./Upload3.jsp";
			} else {
				request.setAttribute("status", "Data Inserting Fail");
				path = "./Upload3.jsp";
			}

		} catch (Exception e) {
			request.setAttribute("status", "Some Technical Problems");
			path = "./Upload2.jsp";
			e.printStackTrace();

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
