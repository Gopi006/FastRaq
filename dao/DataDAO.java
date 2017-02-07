package com.securecloud.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.securecloud.bean.DataBean;
import com.securecloud.bean.FileTo;
import com.securecloud.db.AbstractDataAccessObject;
import com.securecloud.db.SqlConstants;
import com.securecloud.exception.ConnectionException;
import com.securecloud.exception.DataNotFoundException;

public class DataDAO {

	public Connection con = null;
	public PreparedStatement ps, ps1, pstmt, pstmt1 = null;
	public ResultSet rs, rs1 = null;

	public ArrayList<FileTo> viewdata() throws DataNotFoundException,
			ConnectionException {

		ArrayList<FileTo> al = new ArrayList<FileTo>();
		FileTo sb;
		String qr = null;
		try {
			con = new AbstractDataAccessObject().getConnection();

			pstmt1 = con.prepareStatement("truncate table querydata");
			int k = pstmt1.executeUpdate();

			ps = con.prepareStatement("select username ,query from ADL");
			rs = ps.executeQuery();

			while (rs.next()) {
				String username = rs.getString(1);
				String query = rs.getString(2);

				StringTokenizer st = new StringTokenizer(query, " ");

				while (st.hasMoreElements())

				{

					qr = (String) st.nextElement();

					sb = new FileTo();
					ps1 = con
							.prepareStatement("select filename,data1 from cloudserver1 where data1 like '%"
									+ qr + "%'");
					rs1 = ps1.executeQuery();
					while (rs1.next()) {

						String filename = rs1.getString(1);
						sb.setFilename(rs1.getString(1));
						String data = rs1.getString(2);
						sb.setData(rs1.getString(2));
						sb.setUsername(username);
						sb.setQuery(query);
						al.add(sb);
						System.out.println(al.size());

						pstmt = con
								.prepareStatement("insert into querydata values((select nvl(max(qid),9695)+7 from querydata),?,?,?,?)");

						pstmt.setString(1, username);
						pstmt.setString(2, query);
						pstmt.setString(3, filename);
						pstmt.setString(4, data);
						int owner = pstmt.executeUpdate();
						System.out.println(owner);

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataNotFoundException("Sorry no data .....");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new ConnectionException(
							"Sorry for Technical Problem .....");
				}
			}
		}
		System.out.println(al.size());

		return al;

	}

	public ArrayList<FileTo> viewuserdata(String user)
			throws DataNotFoundException, ConnectionException {

		ArrayList<FileTo> al = new ArrayList<FileTo>();
		FileTo sb;

		try {
			con = new AbstractDataAccessObject().getConnection();
			ps = con
					.prepareStatement("select query ,username,data,filename from querydata where username=?");
			ps.setString(1, user);
			rs = ps.executeQuery();

			while (rs.next()) {
				sb = new FileTo();
				String query = rs.getString(1);
				String username = rs.getString(2);
				String data = rs.getString(3);
				String filename = rs.getString(4);

				sb.setFilename(filename);
				sb.setData(data);
				sb.setUsername(username);
				sb.setQuery(query);
				al.add(sb);
				System.out.println(al.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataNotFoundException("Sorry no data .....");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new ConnectionException(
							"Sorry for Technical Problem .....");
				}
			}
		}
		System.out.println(al.size());

		return al;

	}

	public ArrayList<FileTo> viewfiledata(String file, String user,
			String query1) throws DataNotFoundException, ConnectionException {

		ArrayList<FileTo> al = new ArrayList<FileTo>();
		FileTo sb;

		try {
			con = new AbstractDataAccessObject().getConnection();
			ps = con
					.prepareStatement("select query ,username,data,filename from querydata where filename=? and username=? and query=?");
			ps.setString(1, file);
			ps.setString(2, user);
			ps.setString(3, query1);
			rs = ps.executeQuery();

			while (rs.next()) {
				sb = new FileTo();

				String username = rs.getString(2);
				String query = rs.getString(1);
				String data = rs.getString(3);
				String filename = rs.getString(4);
				sb.setFilename(filename);
				sb.setData(data);
				sb.setUsername(username);
				sb.setQuery(query);
				al.add(sb);
				System.out.println(al.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataNotFoundException("Sorry no data .....");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new ConnectionException(
							"Sorry for Technical Problem .....");
				}
			}
		}
		System.out.println(al.size());

		return al;

	}

	public boolean userselectdata(String filename, String data,
			String username, String query, int perc)
			throws DataNotFoundException, ConnectionException {

		boolean b = false;

		try {
			con = new AbstractDataAccessObject().getConnection();
			pstmt = con
					.prepareStatement("insert into userselectdata values((select nvl(max(sno),100)+1 from userselectdata),?,?,?,sysdate,?,?)");

			pstmt.setString(1, username);
			pstmt.setString(2, filename);
			pstmt.setString(3, data);
			pstmt.setString(4, query);
			pstmt.setInt(5, perc);

			int owner = pstmt.executeUpdate();
			System.out.println(owner);
			if (owner > 0) {
				b = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataNotFoundException("Sorry no data .....");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new ConnectionException(
							"Sorry for Technical Problem .....");
				}
			}
		}

		return b;

	}

}
