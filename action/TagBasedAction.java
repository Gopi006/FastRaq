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

public class TagBasedAction extends HttpServlet {

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

			Vector t1 = new SearchDAOImpl().tag1(rto);
			Vector t2 = new SearchDAOImpl().tag2(rto);
			Vector t3 = new SearchDAOImpl().tag3(rto);
			Vector t4 = new SearchDAOImpl().tag4(rto);
			Vector t5 = new SearchDAOImpl().tag5(rto);
			Vector c1 = new SearchDAOImpl().tcount1(rto);
			Vector c2 = new SearchDAOImpl().tcount2(rto);
			Vector c3 = new SearchDAOImpl().tcount3(rto);
			Vector c4 = new SearchDAOImpl().tcount4(rto);
			Vector c5 = new SearchDAOImpl().tcount5(rto);

			if (t1 != null) {

				request.setAttribute("rto", t1);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + t1.size());
			}
			if (t2 != null) {

				request.setAttribute("tsb", t2);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + t2.size());
			}
			if (t3 != null) {

				request.setAttribute("abc", t3);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + t3.size());
			}
			if (t4 != null) {

				request.setAttribute("xyz", t4);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + t4.size());
			}
			if (t5 != null) {

				request.setAttribute("dp", t5);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + t5.size());
			}
			if (c1 != null) {

				request.setAttribute("bto", c1);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + c1.size());
			}
			if (c2 != null) {

				request.setAttribute("bsb", c2);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + c2.size());
			}
			if (c3 != null) {

				request.setAttribute("aoo", c3);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + c3.size());
			}
			if (c4 != null) {

				request.setAttribute("coo", c4);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + c4.size());
			}
			if (c5 != null) {

				request.setAttribute("boo", c5);
				path = "TagCount.jsp";
				System.out.println("Vector count is-----?" + c5.size());
			}

		} catch (Exception e) {

			path = "TagCount.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
