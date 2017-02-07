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

public class AvgAction extends HttpServlet {

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

			Vector v12 = new SearchDAOImpl().Acount1(rto);// server1

			Vector v22 = new SearchDAOImpl().Pcount2(rto);// server2

			Vector v222 = new SearchDAOImpl().Acount3(rto);// server3

			Vector v2222 = new SearchDAOImpl().Acount4(rto);// server4

			Vector v22222 = new SearchDAOImpl().Pcount5(rto);// server5

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

			if (v12 != null) {

				request.setAttribute("rto", v12);
				session.setAttribute("cal3", t2);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + v12.size());
			}

			if (v22 != null) {

				request.setAttribute("bto", v22);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + v22.size());
			}

			if (v222 != null) {

				request.setAttribute("xyz", v222);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + v222.size());
			}

			if (v2222 != null) {

				request.setAttribute("hp", v2222);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + v2222.size());
			}

			if (v22222 != null) {

				request.setAttribute("hpo", v22222);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + v22222.size());
			}

			if (c1 != null) {

				request.setAttribute("c1", c1);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + c1.size());
			}
			if (c2 != null) {

				request.setAttribute("c2", c2);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + c2.size());
			}
			if (c3 != null) {

				request.setAttribute("c3", c3);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + c3.size());
			}
			if (c4 != null) {

				request.setAttribute("c4", c4);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + c4.size());
			}
			if (c5 != null) {

				request.setAttribute("c5", c5);
				path = "AAcount.jsp";
				System.out.println("Vector count is-----?" + c5.size());
			}

			int v1 = v12.size();
			int v2 = v22.size();
			int v3 = v222.size();
			int v4 = v2222.size();
			int v5 = v22222.size();
			int min[] = new int[] { v1, v2, v3, v4, v5 };
			int minv = min[0];
			for (int i = 0; i < min.length; i++) {
				if (min[i] < minv) {
					minv = min[i];

				}

			}
			System.out.println("minv  val is===>" + minv);
			float v = (v1 + v2 + v3 + v4 + v5) / 5;
			System.out.println("avg values is------>" + v);
			rto.setAvg(v);
			request.setAttribute("v", v);
			request.setAttribute("minv", minv);

			session.setAttribute("c1", v12);
			session.setAttribute("c2", v22);
			session.setAttribute("c3", v222);
			session.setAttribute("c4", v2222);
			session.setAttribute("c5", v22222);
			session.setAttribute("minv", minv);

		} catch (Exception e) {

			path = "AAcount.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
