package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.FileTo;
import com.securecloud.dao.DataDAO;
import com.securecloud.dao.UserdaoImpl;

public class ViewDataAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileTo rto = new FileTo();

		String path = "";
		boolean flag = false;

		try {
			ArrayList<FileTo> tsb = null;
			tsb = new DataDAO().viewdata();
			System.out.println(" array size  " + tsb.size());
			if (tsb != null) {
				request.setAttribute("tsb", tsb);

				path = "ViewQueryData.jsp";

			} else {

				path = "ViewQueryData.jsp";
			}
		} catch (Exception e) {

			path = "ViewQueryData.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
