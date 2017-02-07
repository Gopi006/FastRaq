package com.securecloud.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.securecloud.bean.AutoMobile;
import com.securecloud.dao.SearchDAOImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ThresholdAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long stime = System.currentTimeMillis();

		AutoMobile rto = new AutoMobile();

		String path = "";
		boolean flag = false;
		String s1 = request.getParameter("s1");
		Map map = request.getParameterMap();
		HttpSession session = request.getSession();
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

			Vector c1 = new SearchDAOImpl().Bcount1(rto);
			Vector c2 = new SearchDAOImpl().Bcount2(rto);
			Vector c3 = new SearchDAOImpl().Bcount3(rto);
			Vector c4 = new SearchDAOImpl().Bcount4(rto);
			Vector c5 = new SearchDAOImpl().Bcount5(rto);

			Date date = new Date();
			long t1 = date.getTime();
			long t2 = System.currentTimeMillis();
			t2 = ((t2 / 1000 / 60 / 60 / 60 / 60) % 12);

			rto.setAgtime(t2);
			System.out.println("Proposed  time is----->" + t2);

			if (c1 != null) {

				request.setAttribute("c1", c1);
				path = "Threshold.jsp";
				System.out.println("Vector count is-----?" + c1.size());
			}
			if (c2 != null) {

				request.setAttribute("c2", c2);
				path = "Threshold.jsp";
				System.out.println("Vector count is-----?" + c2.size());
			}
			if (c3 != null) {

				request.setAttribute("c3", c3);
				path = "Threshold.jsp";
				System.out.println("Vector count is-----?" + c3.size());
			}
			if (c4 != null) {

				request.setAttribute("c4", c4);
				path = "Threshold.jsp";
				System.out.println("Vector count is-----?" + c4.size());
			}
			if (c5 != null) {

				request.setAttribute("c5", c5);
				path = "Threshold.jsp";
				System.out.println("Vector count is-----?" + c5.size());
			} else {

				request.setAttribute("hello", c1);

				path = "3";
			}

		} catch (Exception e) {

			path = "ViewERIQPrivacy.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
