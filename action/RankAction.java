package com.securecloud.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.securecloud.bean.Example;
import com.securecloud.db.AbstractDataAccessObject;

public class RankAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	RequestDispatcher rd = null;
	String k = null;
	int sc = 0;
	int sid = 0;
	String keyword = null;
	int count = 0;
	String key = null;
	int cnt = 0;
	int id = 0;
	String keyword1 = null;

	public RankAction() {
		con = new AbstractDataAccessObject().getConnection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// int scode = Integer.parseInt(request.getParameter("sc"));
		// System.out.println("security code:" + scode);
		key = request.getParameter("keyword");
		session.setAttribute("key", key);
		StringBuffer url = request.getRequestURL();
		session.setAttribute("url", url);
		StringBuffer j = request.getRequestURL();
		String str[] = new String[15];
		try {
			ps = con.prepareStatement("select file_id,file_data from data1");
			// ps.setInt(1, scode);
			// ps.setString(2, key);
			rs = ps.executeQuery();
			int i = 1;
			Example example;
			Vector<Example> vector = new Vector<Example>();
			StringBuffer fileIds = new StringBuffer();
			while (rs.next()) {
				example = new Example();
				int fileId = rs.getInt(1);
				System.out.println("FileId" + fileId);
				String fileCont = rs.getString(2);
				Scanner s = new Scanner(fileCont);
				System.out.println("Value of A:" + s);
				str[i] = fileCont;
				while (null != s.findWithinHorizon("(?i)\\b" + key + "\\b", 0)) {
					// session.setAttribute("sc", sc);
					// session.setAttribute("a", a);
					System.out.println("it is in while");

					// System.out.println("i=====" + i++ + "sc");
					str[i] = fileCont;
					System.out.println("a value is" + fileCont);
					System.out.println(str.toString());
					example.setString(fileCont);
					example.setFileid(fileId);
					vector.add(example);
					session.setAttribute("vector", vector);
					fileIds.append("" + fileId);
					fileIds.append(",");
					// int count =
					// org.apache.commons.lang.StringUtils.countMatches(fileCont,key);
					System.out.println("countcountcountcount=========" + count);
					break;
				}
				s.close();
			}
			String value = "";
			if (0 != fileIds.toString().length()) {
				value = fileIds.toString().substring(0,
						fileIds.toString().length() - 1);
			}

			ps = con
					.prepareStatement("select keyword,count from searchdata where  keyword=?");
			ps.setString(1, key);
			rs = ps.executeQuery();
			while (rs.next()) {
				keyword1 = rs.getString(1);
				cnt = rs.getInt(2);
			}
			if (key.equals(keyword1)) {
				System.out.println("in DAo title from user screen .........."
						+ keyword1);
				System.out.println("in DAo count is................" + count);
				System.out.println("in DAO same");
				count = cnt;
				ps = con
						.prepareStatement("update searchdata set  count=?,keyword=?, file_ids=? where keyword=? ");
				count++;
				ps.setInt(1, count);
				ps.setString(2, keyword1);
				ps.setString(3, value);
				ps.setString(4, keyword1);
				int update = ps.executeUpdate();
				System.out.println("in DAO no of rows updated is......... "
						+ update);

			} else {
				count = cnt;
				count++;
				System.out.println("in DAO  Not same");
				System.out.println("in DAO after vcb count is............"
						+ count);
				// int fd=Integer.parseInt(request.getParameter("fid"));
				ps = con
						.prepareStatement("insert into searchdata values((select nvl(max(sid),100)+1 from search),?,?,?)");
				ps.setString(1, key);
				ps.setInt(2, count);
				ps.setString(3, value);
				// ps.setInt(3, fd);
				int insert = ps.executeUpdate();
				System.out
						.println("in DAO  no of rows  inserted into searchinfo is........ "
								+ insert);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rd = request.getRequestDispatcher("./SearchResults1.jsp");
		rd.forward(request, response);
	}
}
