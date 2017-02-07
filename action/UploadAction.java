package com.securecloud.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.securecloud.bean.AutoMobile;
import com.securecloud.bean.FileTo;
import com.securecloud.dao.UserdaoImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class UploadAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int i = 0;
		AutoMobile rto = new AutoMobile();
		boolean flag = false;
		String path = "";
		Map map = request.getParameterMap();
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
			flag = new UserdaoImpl().upload(rto);

			System.out.println("in Action class vcb..........." + flag);
			if (flag) {
				request.setAttribute("status",
						"Data Inserted to DB Successfully");
				path = "./upload.jsp";
			} else {
				request.setAttribute("status", "Data Inserting Fail");
				path = "./upload.jsp";
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
