package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.dao.AdminDAO;
import com.securecloud.dao.LoginDAO;
import com.securecloud.util.UtilConstants;

public class ChangePasswordAction extends HttpServlet {

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
		String userid = "", oldPass = "", newPass = "";
		path = UtilConstants._CHANGE_PASSWORD;
		try {
			userid = request.getParameter("userName");
			oldPass = request.getParameter("oldPassword");
			newPass = request.getParameter("newPassword");
			flag = new LoginDAO().changePassword(userid, oldPass, newPass);
			if (flag) {

				request.setAttribute("status",
						UtilConstants._CHANGED_SUCCESSFULLY);
			} else {

				request.setAttribute("status", UtilConstants._FAILED);
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
