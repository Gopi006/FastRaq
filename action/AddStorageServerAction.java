package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.RegisterBean;
import com.securecloud.dao.AdminDAO;
import com.securecloud.dao.LoginDAO;
import com.securecloud.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddStorageServerAction extends HttpServlet {

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
		String path = "";
		String serverName = "";
		path = UtilConstants._VIEW_SERVERS;
		try {
			serverName = request.getParameter("serverName");
			flag = new AdminDAO().addServer(serverName);
			if (flag) {

				request.setAttribute("status",
						UtilConstants._ADDED_SUCCESSFULLY);
			} else {

				request.setAttribute("status", UtilConstants._FAILED_REASON);
			}
		} catch (Exception e) {
			path = UtilConstants._ADMIN_HOME;
			request.setAttribute("status", UtilConstants._FAILED);

		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
