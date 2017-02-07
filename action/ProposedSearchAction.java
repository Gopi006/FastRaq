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

public class ProposedSearchAction extends HttpServlet {

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
			Vector v = new SearchDAOImpl().Psearch(rto);// server1
			Vector v12 = new SearchDAOImpl().Pcount1(rto);// server1

			Vector v11 = new SearchDAOImpl().Psearch12(rto);// server2
			Vector v22 = new SearchDAOImpl().Pcount2(rto);// server2

			Vector v111 = new SearchDAOImpl().Psearch123(rto);
			Vector v222 = new SearchDAOImpl().Pcount3(rto);

			Vector v1111 = new SearchDAOImpl().Psearch1234(rto);
			Vector v2222 = new SearchDAOImpl().Pcount4(rto);

			Vector v11111 = new SearchDAOImpl().Psearch12345(rto);
			Vector v22222 = new SearchDAOImpl().Pcount5(rto);

			Date date = new Date();
			long t1 = date.getTime();
			long t2 = System.currentTimeMillis();
			t2 = ((t2 / 1000 / 60 / 60 / 60) % 24);

			rto.setPtime(t2);
			System.out.println("Proposed  time is----->" + t2);

			if (v != null) {

				request.setAttribute("tsb", v);
				session.setAttribute("cal2", t2);
				path = "Pcount.jsp";
				System.out.println(" vector size prasad " + v.size());

			}
			if (v12 != null) {

				request.setAttribute("rto", v12);
				path = "Pcount.jsp";
				System.out.println("Vector count is-----?" + v12.size());
			}

			if (v11 != null) {

				request.setAttribute("data", v11);

				path = "Pcount.jsp";
				System.out.println(" vector size prasad " + v11.size());

			}
			if (v22 != null) {

				request.setAttribute("bto", v22);
				path = "Pcount.jsp";
				System.out.println("Vector count is-----?" + v22.size());
			}

			if (v111 != null) {

				request.setAttribute("mto", v111);

				path = "Pcount.jsp";
				System.out.println(" vector size prasad " + v111.size());

			}
			if (v222 != null) {

				request.setAttribute("xyz", v222);
				path = "Pcount.jsp";
				System.out.println("Vector count is-----?" + v222.size());
			}

			if (v1111 != null) {

				request.setAttribute("dp", v1111);

				path = "Pcount.jsp";
				System.out.println(" vector size prasad " + v1111.size());

			}
			if (v2222 != null) {

				request.setAttribute("hp", v2222);
				path = "Pcount.jsp";
				System.out.println("Vector count is-----?" + v2222.size());
			}
			if (v11111 != null) {

				request.setAttribute("dpo", v11111);

				path = "Pcount.jsp";
				System.out.println(" vector size prasad " + v11111.size());

			}
			if (v22222 != null) {

				request.setAttribute("hpo", v22222);
				path = "Pcount.jsp";
				System.out.println("Vector count is-----?" + v22222.size());
			} else {

				request.setAttribute("hello", v);

				path = "3";
			}

		} catch (Exception e) {

			path = "ViewERIQPrivacy.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
