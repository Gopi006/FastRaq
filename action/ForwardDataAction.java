package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.DataBean;
import com.securecloud.dao.UserDAO;
import com.securecloud.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ForwardDataAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;
		String path = UtilConstants._USER_HOME;
		;
		DataBean db = new DataBean();
		try {
			Map map = request.getParameterMap();
			BeanUtils.populate(db, map);
			flag = new UserDAO().forwardData(db);
			if (flag) {

				request.setAttribute("status",
						UtilConstants._FORWARDED_SUCCESSFULLY);
			} else {

				request.setAttribute("status", UtilConstants._NO_KEYS);
			}
		} catch (Exception e) {
			path = UtilConstants._USER_HOME;
			request.setAttribute("status", UtilConstants._FAILED);

		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
