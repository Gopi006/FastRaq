package com.securecloud.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.AutoMobile;
import com.securecloud.dao.UserdaoImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class SearchBoundsAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AutoMobile rto = new AutoMobile();

		String path = "";
		boolean flag = false;
		String s1 = request.getParameter("s1");
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();
		}

		try {

			Vector v = new UserdaoImpl().search(rto);
			Vector v1 = new UserdaoImpl().search1(rto);
			Vector v2 = new UserdaoImpl().search2(rto);
			Vector v3 = new UserdaoImpl().search3(rto);
			Vector v4 = new UserdaoImpl().search4(rto);

			System.out.println(" vector size prasad " + v.size());
			if (v != null) {

				request.setAttribute("tsb", v);

				path = "ViewERIQPrivacy.jsp";
			}
			if (v1 != null) {

				request.setAttribute("tsb1", v1);

				path = "ViewERIQPrivacy.jsp";
			}
			if (v2 != null) {

				request.setAttribute("tsb2", v2);

				path = "ViewERIQPrivacy.jsp";
			}
			if (v3 != null) {

				request.setAttribute("tsb3", v3);

				path = "ViewERIQPrivacy.jsp";
			}
			if (v4 != null) {

				request.setAttribute("tsb4", v4);

				path = "ViewERIQPrivacy.jsp";
			} else {

				request.setAttribute("tsb", v);

				path = "3";
			}

		} catch (Exception e) {

			path = "ViewERIQPrivacy.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
