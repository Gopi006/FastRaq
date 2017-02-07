package com.securecloud.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.securecloud.bean.AutoMobile;
import com.securecloud.bean.DataBean;
import com.securecloud.bean.FileTo;
import com.securecloud.bean.RegisterBean;
import com.securecloud.db.AbstractDataAccessObject;
import com.securecloud.exception.ConnectionException;

public class UserdaoImpl extends AbstractDataAccessObject {

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

	public boolean upload(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;

		;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into SERVER1 values((select nvl(max(id),20200)+7 from SERVER1),?,?,?,?,?,?)");

			pstmt.setString(1, cb.getBname());
			pstmt.setFloat(2, cb.getPrice());
			pstmt.setString(3, cb.getBucket());
			pstmt.setString(4, cb.getColor());
			pstmt.setString(5, cb.getDistance());
			pstmt.setInt(6, cb.getRating());
			int owner = pstmt.executeUpdate();

			if (owner > 0) {
				flag = true;
			} else {
				flag = false;

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
		return flag;
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

			String sql = "SELECT bikename,bucket,bikecolor,distance,rating from  server1 WHERE bikeprice BETWEEN "
					+ lbound
					+ "  AND "
					+ ubound
					+ " and bikename=? group by bikename,bucket,bikecolor,distance,rating "
					+ " having count(rating)>=1   ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				AutoMobile rto = new AutoMobile();
				rto.setBname(rs.getString(1));
				rto.setBucket(rs.getString(2));
				rto.setColor(rs.getString(3));
				rto.setDistance(rs.getString(4));
				rto.setRating(rs.getInt(5));
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

	public boolean upload1(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;

		;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into SERVER2 values((select nvl(max(id),40400)+7 from SERVER2),?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, cb.getBname1());
			pstmt.setFloat(2, cb.getPrice1());
			pstmt.setString(3, cb.getBucket1());
			pstmt.setString(4, cb.getColor1());
			pstmt.setString(5, cb.getMake());
			pstmt.setString(6, cb.getDistance1());
			pstmt.setInt(7, cb.getRating1());
			pstmt.setString(8, cb.getEngine());
			pstmt.setString(9, cb.getPower());
			int owner = pstmt.executeUpdate();

			if (owner > 0) {
				flag = true;
			} else {
				flag = false;

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
		return flag;
	}

	public boolean upload2(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;

		;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into SERVER3 values((select nvl(max(id),50505)+7 from SERVER4),?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, cb.getBname2());
			pstmt.setFloat(2, cb.getPrice2());
			pstmt.setString(3, cb.getBucket2());
			pstmt.setString(4, cb.getColor2());
			pstmt.setString(5, cb.getMake1());
			pstmt.setString(6, cb.getStyle());
			pstmt.setString(7, cb.getDistance2());
			pstmt.setInt(8, cb.getRating2());
			pstmt.setInt(9, cb.getMilage());
			pstmt.setInt(10, cb.getCapacity());
			int owner = pstmt.executeUpdate();

			if (owner > 0) {
				flag = true;
			} else {
				flag = false;

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
		return flag;
	}

	public boolean upload3(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;

		;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into SERVER4 values((select nvl(max(id),30303)+7 from SERVER4),?,?,?,?,?,?,?,?)");

			pstmt.setString(1, cb.getBname3());
			pstmt.setFloat(2, cb.getPrice3());
			pstmt.setString(3, cb.getBucket3());
			pstmt.setString(4, cb.getColor3());
			pstmt.setString(5, cb.getModel3());
			pstmt.setString(6, cb.getStyle3());
			pstmt.setString(7, cb.getDistance3());
			pstmt.setInt(8, cb.getRating3());
			int owner = pstmt.executeUpdate();

			if (owner > 0) {
				flag = true;
			} else {
				flag = false;

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
		return flag;
	}

	public boolean upload4(AutoMobile cb) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;

		;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into SERVER5 values((select nvl(max(id),60606)+7 from SERVER5),?,?,?,?,?,?,?,?)");

			pstmt.setString(1, cb.getBname4());
			pstmt.setFloat(2, cb.getPrice4());
			pstmt.setString(3, cb.getBucket4());
			pstmt.setString(4, cb.getColor4());
			pstmt.setString(5, cb.getQuality4());
			pstmt.setString(6, cb.getModel4());
			pstmt.setString(7, cb.getDistance4());
			pstmt.setInt(8, cb.getRating4());
			int owner = pstmt.executeUpdate();

			if (owner > 0) {
				flag = true;
			} else {
				flag = false;

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
		return flag;
	}

	public boolean uploadGroup(String gname) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		long signature = 0;

		try {
			Random random = new Random();

			signature = (long) (Math.random() * 100000 + 3333300000L);
			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into usergroup values((select nvl(max(gid),2001)+1 from usergroup),?,?)");
			pstmt.setString(1, gname);
			pstmt.setLong(2, signature);

			int owner = pstmt.executeUpdate();

			if (owner > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (SQLException e) {
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
		return flag;
	}

	public boolean inserADLReq(String username, String query)
			throws FileNotFoundException, ConnectionException {

		boolean flag = true;

		try {
			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into ADL values((select nvl(max(sno),100)+1 from ADL),?,?,sysdate)");
			pstmt.setString(1, username);
			pstmt.setString(2, query);

			int owner = pstmt.executeUpdate();

			if (owner > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (SQLException e) {
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
		return flag;
	}

	public Vector getuserquery() throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();

		pstmt = con.prepareStatement("select sno,username,query from ADL");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DataBean rto = new DataBean();
			rto.setBlock(rs.getInt(1));
			rto.setUserName(rs.getString(2));
			rto.setQuery(rs.getString(3));
			v.add(rto);
		}

		return v;
	}

	public ArrayList<DataBean> getuserquery1() throws ConnectionException,
			SQLException {
		con = new AbstractDataAccessObject().getConnection();

		ArrayList<DataBean> v1 = new ArrayList<DataBean>();
		Vector v = new Vector();
		int count = 0;
		int i = 1;

		pstmt = con
				.prepareStatement("select query,count(query) from adl group by query order by query");
		rs = pstmt.executeQuery();

		while (rs.next()) {

			String query = rs.getString(1);
			query = query.toUpperCase();
			System.out.println(query);

			pstmt1 = con
					.prepareStatement("select username,query from ADL where UPPER(query) like '"
							+ query + "%'");

			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				DataBean rto = new DataBean();
				String user = rs1.getString(1);
				System.out.println(user);
				rto.setUserName(user);

				if (v == null) {
					String qq = rs1.getString(2);
					System.out.println(qq);
					v.add(qq);
					rto.setQuery(qq);
					rto.setGroupName("ADL" + i);
					v1.add(rto);
				}
				if (v != null) {
					String qq = rs1.getString(2);
					System.out.println(qq);

					Iterator it = v.listIterator();
					while (it.hasNext()) {

						String qqq = (String) it.next();
						System.out.println("qqq=" + qqq);
						System.out.println("qq==" + qq);
						if (qq.equalsIgnoreCase(qqq)) {
							count = 1;
						}
						System.out.println("count=" + count);

					}

					if (count == 0) {
						v.add(qq);
						rto.setQuery(qq);
						rto.setGroupName("ADL" + i);
						v1.add(rto);
					}
				}

			}
			if (count == 0) {
				i++;
			}
			count = 0;
		}

		return v1;
	}

	public Vector getRank() throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();

		pstmt = con
				.prepareStatement("select filename, count(filename) from userselectdata group by filename order by count(filename) desc");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DataBean rto = new DataBean();

			rto.setFileName(rs.getString(1));
			rto.setBlock(rs.getInt(2));

			v.add(rto);
		}

		return v;
	}

	public Vector getQueryRank() throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();

		pstmt = con
				.prepareStatement("select distinct username ,filename,query,percentage from userselectdata order by percentage desc");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DataBean rto = new DataBean();
			rto.setUserName(rs.getString(1));
			rto.setFileName(rs.getString(2));
			rto.setQuery(rs.getString(3));
			rto.setBlock(rs.getInt(4));

			v.add(rto);
		}

		return v;
	}

	public Vector getQueryRankgraph() throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();

		pstmt = con
				.prepareStatement("select distinct filename,percentage from userselectdata order by percentage desc");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DataBean rto = new DataBean();

			rto.setFileName(rs.getString(1));

			rto.setBlock(rs.getInt(2));

			v.add(rto);
		}

		return v;
	}

	public Vector getQueryRankADL() throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();

		int i = 1;
		int j = 1;
		pstmt1 = con
				.prepareStatement("select query,count(query) from adl group by query order by count(query) desc");
		rs1 = pstmt1.executeQuery();

		while (rs1.next()) {

			String query = rs1.getString(1);
			System.out.println(query);

			pstmt = con
					.prepareStatement("select distinct username ,filename,query,percentage from userselectdata where query=? order by percentage desc");
			pstmt.setString(1, query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DataBean rto = new DataBean();
				rto.setUserName(rs.getString(1));
				rto.setFileName(rs.getString(2));
				rto.setQuery(rs.getString(3));
				rto.setBlock(rs.getInt(4));
				rto.setGroupName("ADL" + i);
				rto.setSender("Rank_" + j);
				v.add(rto);
				j++;
			}
			i++;
			j = 1;
		}

		return v;
	}

	public Vector getRankPrivacy() throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();

		pstmt = con
				.prepareStatement("select distinct filename,query,percentage from userselectdata order by percentage desc");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DataBean rto = new DataBean();

			rto.setFileName(rs.getString(1));
			rto.setQuery(rs.getString(2));
			rto.setBlock(rs.getInt(3));

			v.add(rto);
		}

		return v;
	}

	public Vector getEIRQSample() throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();

		pstmt = con
				.prepareStatement("select filename,query,percentage from userselectdata order by percentage desc");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DataBean rto = new DataBean();

			rto.setFileName(rs.getString(1));
			rto.setQuery(rs.getString(2));
			rto.setBlock(rs.getInt(3));

			v.add(rto);
		}

		return v;
	}

	public Vector getuserselectdata() throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();

		pstmt = con
				.prepareStatement("select username,filename,data from userselectdata");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DataBean rto = new DataBean();
			rto.setUserName(rs.getString(1));
			rto.setFileName(rs.getString(2));
			rto.setData(rs.getString(3));
			v.add(rto);
		}

		return v;
	}

	public boolean deleteMatrix() throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		long signature = 0;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con.prepareStatement("truncate table matrix");

			int m = pstmt.executeUpdate();
			if (m > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (SQLException e) {
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
		return flag;
	}

	public boolean deleteQuery(int qid) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;
		long signature = 0;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con.prepareStatement("delete from ADL where sno=? ");
			pstmt.setInt(1, qid);

			int m = pstmt.executeUpdate();
			if (m > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (SQLException e) {
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
		return flag;
	}

	public boolean insertMatrix(String user) throws FileNotFoundException,
			ConnectionException {

		boolean flag = true;
		int uid = 0;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into matrix values(?,?,?,?,?)");
			pstmt.setInt(1, 0);
			pstmt.setInt(2, 0);
			pstmt.setInt(3, 0);
			pstmt.setInt(4, 0);
			pstmt.setString(5, user);

			int m = pstmt.executeUpdate();

			if (m > 0) {
				flag = true;
			} else {
				flag = false;

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
		return flag;
	}

	public Vector<RegisterBean> viewMatrix(String user)
			throws FileNotFoundException, ConnectionException {

		Vector<RegisterBean> v = new Vector<RegisterBean>();

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("select lid,age,sign,role from matrix where username=?");

			pstmt.setString(1, user);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				RegisterBean rto = new RegisterBean();

				rto.setLid(rs.getInt(1));
				rto.setAge(rs.getInt(2));
				rto.setSign(rs.getInt(3));
				rto.setUrole(rs.getInt(4));

				v.add(rto);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return v;
	}

	public String viewRole(String user) throws FileNotFoundException,
			ConnectionException {

		String role = null;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("select role from userdata where username=?");

			pstmt.setString(1, user);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				role = rs.getString(1);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return role;
	}

	public FileTo getKey(FileTo b) throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();

		pstmt = con
				.prepareStatement("select fileid  from cloudserver1 where filename=?");
		pstmt.setString(1, b.getFilename());
		rs = pstmt.executeQuery();

		String filename = b.getFilename();
		int key = 0;
		while (rs.next()) {
			key = rs.getInt(1);
		}
		b.setKey(key);
		b.setFilename(filename);

		return b;
	}

	public String getLid(String user, String lid) throws ConnectionException,
			SQLException {
		con = new AbstractDataAccessObject().getConnection();

		String role = null;
		pstmt = con
				.prepareStatement("select logintype  from userdata where username=? and lid=?");
		pstmt.setString(1, user);
		pstmt.setString(2, lid);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			role = rs.getString(1);

			pstmt7 = con
					.prepareStatement("update  matrix set lid=? where username=? ");
			pstmt7.setInt(1, 1);
			pstmt7.setString(2, user);
			int k7 = pstmt7.executeUpdate();
			System.out.println(k7);
		}
		return role;
	}

	public String getAge(String user, int age) throws ConnectionException,
			SQLException {
		con = new AbstractDataAccessObject().getConnection();

		String role = null;
		pstmt = con
				.prepareStatement("select logintype  from userdata where username=? and age=?");
		pstmt.setString(1, user);
		pstmt.setInt(2, age);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			role = rs.getString(1);
			pstmt7 = con
					.prepareStatement("update  matrix set age=? where username=? ");
			pstmt7.setInt(1, 1);
			pstmt7.setString(2, user);
			int k7 = pstmt7.executeUpdate();
			System.out.println(k7);
		}
		return role;
	}

	public String getSignature(String user, String signature)
			throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();

		String role = null;
		pstmt = con
				.prepareStatement("select logintype  from userdata where username=? and signature=?");
		pstmt.setString(1, user);
		pstmt.setString(2, signature);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			role = rs.getString(1);
			pstmt7 = con
					.prepareStatement("update  matrix set sign=? where username=? ");
			pstmt7.setInt(1, 1);
			pstmt7.setString(2, user);
			int k7 = pstmt7.executeUpdate();
			System.out.println(k7);
		}
		return role;
	}

	public String getRole(String user, String userrole)
			throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();

		String role = null;
		pstmt = con
				.prepareStatement("select logintype  from userdata where username=? and role=?");
		pstmt.setString(1, user);
		pstmt.setString(2, userrole);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			role = rs.getString(1);
			pstmt7 = con
					.prepareStatement("update  matrix set role=? where username=? ");
			pstmt7.setInt(1, 1);
			pstmt7.setString(2, user);
			int k7 = pstmt7.executeUpdate();
			System.out.println(k7);
		}
		return role;
	}

	public FileTo getFile(FileTo b) throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		Vector v = null;
		String filename = "";
		int key = b.getKey();
		String data1 = "", data2 = "", data3 = "", tpadata = "", filepath = "";
		pstmt1 = con
				.prepareStatement("select filename from cloudserver1 where fileid=? ");
		System.out.println(" key value in daoimpl is " + b.getKey());
		pstmt1.setInt(1, b.getKey());
		rs1 = pstmt1.executeQuery();
		if (rs1.next()) {
			filename = rs1.getString(1);
			System.out.println(" file name in the dao impl class is "
					+ filename);

			pstmt = con
					.prepareStatement("select s1.data1,s1.filepath from cloudserver1 s1 where s1.filename=? ");
			pstmt.setString(1, filename);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				data1 = rs.getString(1);
				filepath = rs.getString(2);

			}
			b.setData1(data1);
			b.setFilepath(filepath);

			return b;

		} else {
			b = null;
		}
		return b;

	}

	public boolean insertRetreveDetails(FileTo b) throws ConnectionException,
			SQLException {

		boolean flag = true;
		con = new AbstractDataAccessObject().getConnection();
		Vector v = null;
		int key = b.getKey();
		String data1 = "", data2 = "", data3 = "", tpadata = "";

		pstmt = con
				.prepareStatement("insert into FileStatus values(?,?,?,?,?,?,?,?)");
		pstmt.setString(1, b.getFilename());
		pstmt.setInt(2, b.getKey());
		pstmt.setInt(3, b.getBlock());
		pstmt.setInt(4, b.getTransferblock());
		pstmt.setInt(5, b.getPendingblock());

		pstmt.setString(6, b.getRequestedserver());
		pstmt.setString(7, b.getHelpingserver());
		pstmt.setString(8, b.getBaddata());

		int i = pstmt.executeUpdate();

		if (i > 0) {
			flag = true;
		} else
			flag = false;

		return flag;
	}

	public boolean updateFile(FileTo b) throws ConnectionException,
			SQLException {

		boolean flag = true;
		con = new AbstractDataAccessObject().getConnection();
		Vector v = null;

		String data1 = "", data2 = "", data3 = "", tpadata = "";

		pstmt = con.prepareStatement("delete * from ");
		pstmt.setString(1, b.getFilename());
		pstmt.setInt(2, b.getKey());
		pstmt.setInt(3, b.getBlock());
		pstmt.setInt(4, b.getTransferblock());
		pstmt.setInt(5, b.getPendingblock());

		pstmt.setString(6, b.getRequestedserver());
		pstmt.setString(7, b.getHelpingserver());
		pstmt.setString(8, b.getBaddata());

		int i = pstmt.executeUpdate();

		if (i > 0) {
			flag = true;
		} else
			flag = false;

		return flag;
	}

	public Vector fileStatus(FileTo b) throws ConnectionException, SQLException {

		boolean flag = true;
		con = new AbstractDataAccessObject().getConnection();
		Vector v = new Vector();

		pstmt = con
				.prepareStatement("select unique filename,key,blocks,blockstransfered,pendingblocks,requestedserver,helpingserver,baddata from filestatus ");
		rs = pstmt.executeQuery();
		System.out.println(" hi sanjay");
		while (rs.next()) {
			FileTo rto = new FileTo();

			rto.setFilename(rs.getString(1));
			rto.setKey(rs.getInt(2));
			rto.setBlock(rs.getInt(3));
			rto.setTransferblock(rs.getInt(4));
			rto.setPendingblock(rs.getInt(5));
			rto.setRequestedserver(rs.getString(6));
			System.out.println(" next server value is in daoimpl is "
					+ rs.getString(7));
			rto.setHelpingserver(rs.getString(7));
			rto.setBaddata(rs.getString(8));

			v.add(rto);
		}

		return v;
	}

	public Vector serverDetails(FileTo b) throws ConnectionException,
			SQLException {

		boolean flag = true;
		con = new AbstractDataAccessObject().getConnection();
		Vector v = new Vector();

		pstmt = con.prepareStatement("select * from serverdetails ");
		rs = pstmt.executeQuery();
		System.out.println(" hi sanjay");
		while (rs.next()) {
			FileTo rto = new FileTo();

			rto.setServername(rs.getString(1));
			rto.setPort(rs.getInt(2));
			rto.setIp(rs.getString(3));
			rto.setRole(rs.getString(4));

			v.add(rto);
		}

		return v;
	}

	public String getWordData(FileTo b) throws ZipException, IOException,
			SAXException, ParserConfigurationException {

		System.out.println(" I AM IN DAOIMPL");
		String data = "";
		try {
			File myFile = new File(b.getUpfile());
			List<String> lines = new ArrayList<String>();

			ZipFile docxFile = new ZipFile(myFile);
			ZipEntry documentXML = docxFile.getEntry("word/document.xml");
			InputStream documentXMLIS = docxFile.getInputStream(documentXML);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			Document doc = dbf.newDocumentBuilder().parse(documentXMLIS);

			Element tElement = doc.getDocumentElement();
			NodeList n = (NodeList) tElement.getElementsByTagName("w:p");
			String s = "";
			for (int j = 0; j < n.getLength(); j++) {

				Node child = n.item(j);
				String line = child.getTextContent();
				data = data + line;

				if (line != null && !line.trim().isEmpty()) {

					lines.add(line.trim());

				}

			}
			System.out.println(" ---------->>> Woord document  in daoimpl"
					+ data);

		} catch (Exception e) {
			e.getStackTrace();
		}

		return data;
	}

	public Vector retreveFilesFromServer(AutoMobile b)
			throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();
		try {
			pstmt = con
					.prepareStatement("select * from server1 ORDER BY rating");
			rs = pstmt.executeQuery();
			System.out.println(" hi sanjay");
			while (rs.next()) {
				AutoMobile rto = new AutoMobile();

				rto.setId(rs.getInt(1));
				rto.setBname(rs.getString(2));
				rto.setPrice(rs.getInt(3));
				rto.setBucket(rs.getString(4));
				rto.setColor(rs.getString(5));
				rto.setDistance(rs.getString(6));
				rto.setRating(rs.getInt(7));

				v.add(rto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return v;
	}

	public Vector retreveFilesFromServer5(AutoMobile b)
			throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();
		try {
			pstmt = con
					.prepareStatement("select  * from server5 ORDER BY rating ");
			rs = pstmt.executeQuery();
			System.out.println(" hi sanjay");
			while (rs.next()) {
				AutoMobile rto = new AutoMobile();

				rto.setSid5(rs.getInt(1));
				rto.setBname4(rs.getString(2));
				rto.setPrice4(rs.getInt(3));
				rto.setBucket4(rs.getString(4));
				rto.setColor4(rs.getString(5));
				rto.setQuality4(rs.getString(6));
				rto.setModel4(rs.getString(7));
				rto.setDistance4(rs.getString(8));
				rto.setRating4(rs.getInt(9));

				v.add(rto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return v;
	}

	public Vector retreveFilesFromServer2(AutoMobile b)
			throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();
		try {
			pstmt = con
					.prepareStatement("select  * from server2 ORDER BY rating");
			rs = pstmt.executeQuery();
			System.out.println(" hi sanjay");
			while (rs.next()) {
				AutoMobile rto = new AutoMobile();

				rto.setSid2(rs.getInt(1));
				rto.setBname1(rs.getString(2));
				rto.setPrice1(rs.getInt(3));
				rto.setBucket1(rs.getString(4));
				rto.setColor1(rs.getString(5));
				rto.setMake(rs.getString(6));
				rto.setDistance1(rs.getString(7));
				rto.setRating1(rs.getInt(8));

				v.add(rto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return v;
	}

	public Vector retreveFilesFromServer3(AutoMobile b)
			throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();
		try {
			pstmt = con
					.prepareStatement("select  * from server3 ORDER BY rating ");
			rs = pstmt.executeQuery();
			System.out.println(" hi sanjay");
			while (rs.next()) {
				AutoMobile rto = new AutoMobile();

				rto.setSid3(rs.getInt(1));
				rto.setBname2(rs.getString(2));
				rto.setPrice2(rs.getInt(3));
				rto.setBucket2(rs.getString(4));
				rto.setColor2(rs.getString(5));
				rto.setMake1(rs.getString(6));
				rto.setStyle(rs.getString(7));
				rto.setDistance2(rs.getString(8));
				rto.setRating2(rs.getInt(9));

				v.add(rto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return v;
	}

	public Vector retreveFilesFromServer4(AutoMobile b)
			throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();
		try {
			pstmt = con
					.prepareStatement("select  * from server4 ORDER BY rating ");
			rs = pstmt.executeQuery();
			System.out.println(" hi sanjay");
			while (rs.next()) {
				AutoMobile rto = new AutoMobile();

				rto.setSid4(rs.getInt(1));
				rto.setBname3(rs.getString(2));
				rto.setPrice3(rs.getInt(3));
				rto.setBucket3(rs.getString(4));
				rto.setColor3(rs.getString(5));
				rto.setStyle3(rs.getString(6));
				rto.setModel3(rs.getString(7));
				rto.setDistance3(rs.getString(8));
				rto.setRating3(rs.getInt(9));

				v.add(rto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return v;
	}

	public boolean InsertData1(AutoMobile cb, String login)
			throws FileNotFoundException, ConnectionException {

		boolean flag = true;
		int uid = 0;

		try {

			con = new AbstractDataAccessObject().getConnection();

			pstmt = con
					.prepareStatement("insert into BEHAVIORALDATA values(?,?)");

			pstmt.setString(1, cb.getSid());

			pstmt.setString(2, login);
			int owner = pstmt.executeUpdate();

			if (owner > 0) {
				flag = true;
			} else {
				flag = false;

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
		return flag;
	}

	public Vector Bdata(AutoMobile b) throws ConnectionException, SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();
		try {
			pstmt = con.prepareStatement("select  * from BEHAVIORALDATA");
			rs = pstmt.executeQuery();
			System.out.println(" hi prasad");
			while (rs.next()) {
				AutoMobile rto = new AutoMobile();

				rto.setSid(rs.getString(1));
				rto.setUsername(rs.getString(2));

				v.add(rto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return v;
	}

	public Vector Recommendation(AutoMobile b) throws ConnectionException,
			SQLException {
		con = new AbstractDataAccessObject().getConnection();
		boolean flag = true;

		Vector v = new Vector();
		try {
			pstmt = con
					.prepareStatement("SELECT ID,COUNT(ID) FROM BEHAVIORALDATA GROUP BY ID");
			rs = pstmt.executeQuery();
			System.out.println(" hi prasad");
			while (rs.next()) {
				AutoMobile rto = new AutoMobile();

				rto.setRid(rs.getString(1));
				rto.setRcount(rs.getInt(2));

				v.add(rto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return v;
	}
}
