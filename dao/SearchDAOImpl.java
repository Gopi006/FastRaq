package com.securecloud.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.securecloud.bean.AutoMobile;
import com.securecloud.bean.Example;
import com.securecloud.db.AbstractDataAccessObject;
import com.securecloud.exception.ConnectionException;

public class SearchDAOImpl extends AbstractDataAccessObject {

	Connection con;
	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3, pstmt4, pstmt5, pstmt6,
			pstmt11, pstmt12, pstmt13, pstmt14, pstmt7, pstmt8, pstmt9,
			pstmt10, pstmt100;
	Statement st, stmt;
	ResultSet rs, rs1, rs2, rs3, rs6, rs7, rs8, rs9, rs10, rs11;
	String q1 = null, q2 = null, q3 = null, q4 = null, q5 = null;

	public void closeConnection() throws ConnectionException {
		try {

			if (pstmt != null)
				pstmt.close();

			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ConnectionException(
					"Some Problem Occured during the closing connections");
		}
	}

	public Vector search(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select count(*) from server1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setTc1(rs.getString(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector search12(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select count(*) from server2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setTc2(rs.getString(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector search123(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select count(*) from server3";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setTc3(rs.getString(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector search1234(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select count(*) from server4";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setTc4(rs.getString(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector search1235(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select count(*) from server5";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setTc5(rs.getString(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector count1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select bikename,count(*) from server1 where bikeprice between "
					+ lbound
					+ " and "
					+ ubound
					+ " and bikename=? group by bikename";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname(rs.getString(1));
				rto.setAc1(rs.getString(2));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector count2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select bikename,count(*) from server2 where bikeprice between "
					+ lbound
					+ " and "
					+ ubound
					+ " and bikename=? group by bikename";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname1(rs.getString(1));
				rto.setAc2(rs.getString(2));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector count3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select bikename,count(*) from server3 where bikeprice between "
					+ lbound
					+ " and "
					+ ubound
					+ " and bikename=? group by bikename";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname2(rs.getString(1));
				rto.setAc3(rs.getString(2));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector count4(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select bname,count(*) from server4 where bprice between "
					+ lbound + " and " + ubound + " and bname=? group by bname";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname3(rs.getString(1));
				rto.setAc4(rs.getString(2));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector count5(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "select bname,count(*) from server5 where bprice between "
					+ lbound + " and " + ubound + " and bname=? group by bname";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname4(rs.getString(1));
				rto.setAc5(rs.getString(2));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector search1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v1 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server2 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bikename=?";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, bname);
			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname1(rs1.getString(2));
				rto.setBucket1(rs1.getString(4));
				rto.setColor1(rs1.getString(5));
				rto.setDistance1(rs1.getString(7));
				rto.setMake(rs1.getString(6));
				rto.setRating1(rs1.getInt(8));
				v1.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v1;

	}

	public Vector search2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v2 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql2 = "SELECT * FROM server3 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bikename=?";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, bname);
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname2(rs2.getString(2));
				rto.setBucket2(rs2.getString(4));
				rto.setColor2(rs2.getString(5));
				rto.setDistance2(rs2.getString(8));
				rto.setMake1(rs2.getString(6));
				rto.setStyle(rs2.getString(7));
				rto.setRating2(rs2.getInt(9));
				v2.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v2;

	}

	public Vector search3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v3 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql3 = "SELECT * FROM server4 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? ";

			pstmt3 = con.prepareStatement(sql3);
			pstmt3.setString(1, bname);
			rs3 = pstmt3.executeQuery();
			while (rs3.next()) {
				AutoMobile rto = new AutoMobile();
				rto.setBname3(rs3.getString(2));
				rto.setBucket3(rs3.getString(4));
				rto.setColor3(rs3.getString(5));
				rto.setDistance3(rs3.getString(8));
				rto.setModel3(rs3.getString(6));
				rto.setStyle3(rs3.getString(7));
				rto.setRating3(rs3.getInt(9));
				v3.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v3;

	}

	public Vector<AutoMobile> search4(AutoMobile cb)
			throws FileNotFoundException, ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector<AutoMobile> v4 = new Vector<AutoMobile>();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql4 = "SELECT * FROM server5 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? ";

			pstmt4 = con.prepareStatement(sql4);
			pstmt4.setString(1, bname);
			rs6 = pstmt4.executeQuery();
			while (rs6.next()) {
				AutoMobile rto = new AutoMobile();
				rto.setBname4(rs6.getString(2));
				rto.setBucket4(rs6.getString(4));
				rto.setColor4(rs6.getString(5));
				rto.setDistance4(rs6.getString(8));
				rto.setModel4(rs6.getString(7));
				rto.setQuality4(rs6.getString(6));
				rto.setRating4(rs6.getInt(9));
				v4.add(rto);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v4;

	}

	public Vector Psearch(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "SELECT COUNT(BIKENAME) FROM SERVER1 WHERE BIKENAME=? GROUP BY BIKENAME";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setP1(rs.getInt(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector Pcount1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server1 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bikename=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setId(rs.getInt(1));
				rto.setBname(rs.getString(2));
				rto.setBucket(rs.getString(4));
				rto.setColor(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Psearch12(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "SELECT COUNT(BIKENAME) FROM SERVER2 WHERE BIKENAME=? GROUP BY BIKENAME";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setP2(rs.getInt(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector Pcount2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server2 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bikename=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setSid2(rs.getInt(1));
				rto.setBname1(rs.getString(2));
				rto.setBucket1(rs.getString(4));
				rto.setColor1(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Psearch123(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "SELECT COUNT(BIKENAME) FROM SERVER3 WHERE BIKENAME=? GROUP BY BIKENAME";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setP3(rs.getInt(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector Pcount3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server3 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bikename=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setSid3(rs.getInt(1));
				rto.setBname2(rs.getString(2));
				rto.setBucket2(rs.getString(4));
				rto.setColor2(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Psearch1234(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "SELECT COUNT(BNAME) FROM SERVER4 WHERE BNAME=? GROUP BY BNAME";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setP4(rs.getInt(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector Pcount4(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server4 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setSid4(rs.getInt(1));
				rto.setBname3(rs.getString(2));
				rto.setBucket3(rs.getString(4));
				rto.setColor3(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Psearch12345(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "SELECT COUNT(BNAME) FROM SERVER5 WHERE BNAME=? GROUP BY BNAME";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setP5(rs.getInt(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector Pcount5(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server5 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setSid5(rs.getInt(1));
				rto.setBname4(rs.getString(2));
				rto.setBucket4(rs.getString(4));
				rto.setColor4(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Asearch(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating value is----->" + rating);
		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql = "SELECT COUNT(BIKENAME) FROM SERVER1 WHERE BIKENAME=? GROUP BY BIKENAME";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setP1(rs.getInt(1));
				v.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v;

	}

	public Vector Acount1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server1 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setId(rs.getInt(1));
				rto.setBname(rs.getString(2));
				rto.setBucket(rs.getString(4));
				rto.setColor(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Acount2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is-------->" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server2 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bikename=? rating =?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setSid2(rs.getInt(1));
				rto.setBname1(rs.getString(2));
				rto.setBucket1(rs.getString(4));
				rto.setColor1(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Acount3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server3 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating =?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setSid3(rs.getInt(1));
				rto.setBname2(rs.getString(2));
				rto.setBucket2(rs.getString(4));
				rto.setColor2(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Acount4(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is----->" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server4 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setSid4(rs.getInt(1));
				rto.setBname3(rs.getString(2));
				rto.setBucket3(rs.getString(4));
				rto.setColor3(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Acount5(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is----->" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server5 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setSid5(rs.getInt(1));
				rto.setBname4(rs.getString(2));
				rto.setBucket4(rs.getString(4));
				rto.setColor4(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Bcount1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "select bikecolor,count(bikecolor) from server1 group by bikecolor";
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setColor(rs.getString(1));
				rto.setC1(rs.getInt(2));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Bcount2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "select bikecolor,count(bikecolor) from server2 group by bikecolor";
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setColor1(rs.getString(1));
				rto.setC2(rs.getInt(2));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Bcount3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "select bcolor,count(bcolor) from server3 group by bcolor";
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setColor2(rs.getString(1));
				rto.setC3(rs.getInt(2));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Bcount4(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "select bcolor,count(bcolor) from server4 group by bcolor";
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setColor3(rs.getString(1));
				rto.setC4(rs.getInt(2));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector Bcount5(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "select color,count(color) from server5 group by color";
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setColor4(rs.getString(1));
				rto.setC5(rs.getInt(2));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tag1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server1 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname(rs.getString(2));
				rto.setBucket(rs.getString(4));
				rto.setColor(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tag2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server2 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname1(rs.getString(2));
				rto.setBucket1(rs.getString(4));
				rto.setColor1(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tag3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server3 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname2(rs.getString(2));
				rto.setBucket2(rs.getString(4));
				rto.setColor2(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tag4(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server4 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname3(rs.getString(2));
				rto.setBucket3(rs.getString(4));
				rto.setColor3(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tag5(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server5 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname4(rs.getString(2));
				rto.setBucket4(rs.getString(4));
				rto.setColor4(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tcount1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rate = cb.getRate();
		System.out.println("rating is---->" + rate);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT  count(*),count(*),count(*) FROM server1 WHERE bikeprice between ? and ? and rating=? and bikename=?  GROUP BY bikename ORDER BY bikename ";

			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, lbound);
			pstmt.setInt(2, ubound);
			pstmt.setInt(3, rate);
			pstmt.setString(4, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();

				rto.setTag1(rs.getString(1));
				rto.setTag2(rs.getString(2));
				rto.setTag3(rs.getString(3));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tcount2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rate = cb.getRate();
		System.out.println("rating is---->" + rate);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT  count(*),count(*),count(*) FROM server2 WHERE bikeprice between ? and ? and rating=? and bikename=?  GROUP BY bikename ORDER BY bikename ";

			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, lbound);
			pstmt.setInt(2, ubound);
			pstmt.setInt(3, rate);
			pstmt.setString(4, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();

				rto.setTag4(rs.getString(1));
				rto.setTag5(rs.getString(2));
				rto.setTag6(rs.getString(3));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tcount3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rate = cb.getRate();
		System.out.println("rating is---->" + rate);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT  count(*),count(*),count(*) FROM server3 WHERE bikeprice between ? and ? and rating=? and bikename=?  GROUP BY bikename ORDER BY bikename ";

			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, lbound);
			pstmt.setInt(2, ubound);
			pstmt.setInt(3, rate);
			pstmt.setString(4, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();

				rto.setTag7(rs.getString(1));
				rto.setTag8(rs.getString(2));
				rto.setTag9(rs.getString(3));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tcount4(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rate = cb.getRate();
		System.out.println("rating is---->" + rate);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT  count(*),count(*),count(*) FROM server4 WHERE bprice between ? and ? and rating=? and bname=?  GROUP BY bname ORDER BY bname ";

			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, lbound);
			pstmt.setInt(2, ubound);
			pstmt.setInt(3, rate);
			pstmt.setString(4, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();

				rto.setTag10(rs.getString(1));
				rto.setTag11(rs.getString(2));
				rto.setTag12(rs.getString(3));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector tcount5(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rate = cb.getRate();
		System.out.println("rating is---->" + rate);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT  count(*),count(*),count(*) FROM server5 WHERE bprice between ? and ? and rating=? and bname=?  GROUP BY bname ORDER BY bname ";

			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, lbound);
			pstmt.setInt(2, ubound);
			pstmt.setInt(3, rate);
			pstmt.setString(4, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();

				rto.setTag13(rs.getString(1));
				rto.setTag14(rs.getString(2));
				rto.setTag15(rs.getString(3));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server1 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname(rs.getString(2));
				rto.setBucket(rs.getString(4));
				rto.setColor(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server2 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname1(rs.getString(2));
				rto.setBucket1(rs.getString(4));
				rto.setColor1(rs.getString(5));
				rto.setEngine(rs.getString(9));
				rto.setPower(rs.getString(10));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server3 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname2(rs.getString(2));
				rto.setBucket2(rs.getString(4));
				rto.setColor2(rs.getString(5));
				rto.setMilage(rs.getInt(9));
				rto.setCapacity(rs.getInt(10));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster33(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server3 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname2(rs.getString(2));
				rto.setBucket2(rs.getString(4));
				rto.setColor2(rs.getString(5));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster4(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server4 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname3(rs.getString(2));
				rto.setBucket3(rs.getString(4));
				rto.setColor3(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster5(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server5 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname4(rs.getString(2));
				rto.setBucket4(rs.getString(4));
				rto.setColor4(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster22(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server2 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname1(rs.getString(2));
				rto.setBucket1(rs.getString(4));
				rto.setColor1(rs.getString(5));

				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster11(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server1 WHERE bikeprice BETWEEN "
					+ lbound + "  AND " + ubound
					+ " and bikename=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname(rs.getString(2));
				rto.setBucket(rs.getString(4));
				rto.setColor(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster44(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server4 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname3(rs.getString(2));
				rto.setBucket3(rs.getString(4));
				rto.setColor3(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}

	public Vector cluster55(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		Vector v12 = new Vector();

		String bname = cb.getSname();
		System.out.println("bike name is---->" + bname);

		int lbound = cb.getLbound();
		System.out.println("lower bound value is ---->" + lbound);

		int ubound = cb.getUbound();
		System.out.println("Upper bound value is------>" + ubound);

		int rating = cb.getRate();
		System.out.println("Rating is------>" + rating);

		try {

			con = new AbstractDataAccessObject().getConnection();

			String sql1 = "SELECT * FROM server5 WHERE bprice BETWEEN "
					+ lbound + "  AND " + ubound + " and bname=? and rating=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, bname);
			pstmt.setInt(2, rating);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname4(rs.getString(2));
				rto.setBucket4(rs.getString(4));
				rto.setColor4(rs.getString(5));
				v12.add(rto);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {

			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return v12;

	}
}