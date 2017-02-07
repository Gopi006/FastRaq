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

public class ClusterBasedAction extends HttpServlet {

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

			Vector t1 = new SearchDAOImpl().cluster1(rto);
			Vector t2 = new SearchDAOImpl().cluster2(rto);
			Vector t3 = new SearchDAOImpl().cluster3(rto);
			Vector t4 = new SearchDAOImpl().cluster4(rto);
			Vector t5 = new SearchDAOImpl().cluster5(rto);

			if (t1 != null) {

				request.setAttribute("rto", t1);
				path = "Cluster.jsp";
				System.out.println("Vector count is-----?" + t1.size());
			}
			if (t2 != null) {

				request.setAttribute("tsb", t2);
				path = "Cluster.jsp";
				System.out.println("Vector count is-----?" + t2.size());
			}
			if (t3 != null) {

				request.setAttribute("abc", t3);
				path = "Cluster.jsp";
				System.out.println("Vector count is-----?" + t3.size());
			}
			if (t4 != null) {

				request.setAttribute("xyz", t4);
				path = "Cluster.jsp";
				System.out.println("Vector count is-----?" + t4.size());
			}
			if (t5 != null) {

				request.setAttribute("dp", t5);
				path = "Cluster.jsp";
				System.out.println("Vector count is-----?" + t5.size());
			}

			int v1 = t1.size();
			int v2 = t2.size();
			int v3 = t3.size();
			int v4 = t4.size();
			int v5 = t5.size();

			int min[] = new int[] { v1, v2, v3, v4, v5 };
			int minv = min[0];
			for (int i = 0; i < min.length; i++) {
				if (min[i] < minv) {
					minv = min[i];

				}
			}
			session.setAttribute("c1", t1);
			session.setAttribute("c2", t2);
			session.setAttribute("c3", t3);
			session.setAttribute("c4", t4);
			session.setAttribute("c5", t5);
			session.setAttribute("minv1", minv);
			System.out.println(" M I N V =====>" + minv);
		} catch (Exception e) {

			path = "Cluster.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
