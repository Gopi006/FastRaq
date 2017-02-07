package com.securecloud.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.securecloud.bean.AutoMobile;
import com.securecloud.dao.UserdaoImpl;

public class BehavioralAction extends HttpServlet {

	/**
	 * 
	 */

	Logger log = Logger.getLogger(BehavioralAction.class);

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AutoMobile rto = new AutoMobile();

		String path = "";
		boolean flag = false;
		String s1 = request.getParameter("s1");

		try {

			Vector v = new UserdaoImpl().Bdata(rto);
			System.out.println(" vector size prasad " + v.size());
			if (v != null) {

				request.setAttribute("tsb", v);
				log.info("V value is" + v);

				path = "ViewRankPrivacy.jsp";
			} else {

				request.setAttribute("tsb", v);

				path = "3";
			}

		} catch (Exception e) {

			path = "ViewRankPrivacy.jsp";
			log.warn("Exception", e);
			log.error("Exception" + e);

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
