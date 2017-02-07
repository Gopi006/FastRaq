package com.securecloud.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.securecloud.bean.FileTo;
import com.securecloud.dao.UserdaoImpl;

public class InsertGroupAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int i = 0;
		FileTo cb = new FileTo();

		String path = "", token = "";
		boolean flag = false;

		String gname = request.getParameter("gname");

		try {

			flag = new UserdaoImpl().uploadGroup(gname);

			System.out.println("in Action class vcb..........." + flag);
			if (flag) {
				request.setAttribute("status", "Group Inserted  Successfully");
				path = "./Group.jsp";
			} else {
				request.setAttribute("status", "Data Inserting Fail");
				path = "./Group.jsp";
			}

		} catch (Exception e) {
			request.setAttribute("status", "Some Technical Problems");
			path = "./upload.jsp";
			e.printStackTrace();

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
