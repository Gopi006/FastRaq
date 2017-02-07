package com.securecloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.securecloud.bean.KeyServerBean;
import com.securecloud.bean.RegisterBean;
import com.securecloud.db.AbstractDataAccessObject;
import com.securecloud.db.SqlConstants;
import com.securecloud.exception.ConnectionException;
import com.securecloud.exception.DataNotFoundException;
import com.securecloud.util.DateWrapper;

public class LoginDAO extends AbstractDataAccessObject {

	public Connection con = null;
	public PreparedStatement ps = null, ps1 = null, ps2 = null;
	public ResultSet rs = null, rs1 = null, rs2 = null;

	public String loginCheck(String userName, String password) {
		String sql = SqlConstants._LOGIN_CHECK;
		String role = null;
		System.out.println("userName" + userName + "password" + password);
		try {
			con = new AbstractDataAccessObject().getConnection();
			System.out.println("con" + con);
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				role = rs.getString(1);
				System.out.println("role" + role);
			}
		} catch (SQLException e) {

		} catch (Exception e) {

		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return role;
	}

	public boolean getUserId(String userid) {
		boolean flag = false;
		try {
			con = new AbstractDataAccessObject().getConnection();
			System.out.println("Con..." + con);

			ps = con
					.prepareStatement("select username from userdata where username=?");
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println(".....");
			}
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			// throw new DataAcessException("Data base connection Failed");
		} catch (SQLException se) {
			se.printStackTrace();
			// throw new
			// DataNotFoundException("Sql exception riser/datanot found");
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean deleteUser(String userid) {
		boolean flag = false;
		try {
			con = new AbstractDataAccessObject().getConnection();
			System.out.println("Con..." + con);
			ps = con
					.prepareStatement("update logindetails set USERSTATUS='deActive' where userid=?");
			ps.setInt(1, Integer.parseInt(userid));
			int x = ps.executeUpdate();
			if (x > 0) {
				flag = true;
				System.out.println(".....");
			}
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			// throw new DataAcessException("Data base connection Failed");
		} catch (SQLException se) {
			se.printStackTrace();
			// throw new
			// DataNotFoundException("Sql exception riser/datanot found");
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean changePassword(String userid, String oldPass, String newPass) {
		boolean flag = false;
		try {
			con = new AbstractDataAccessObject().getConnection();
			System.out.println("Con..." + con + ".." + userid + ".." + oldPass
					+ ".." + newPass);
			String sql = SqlConstants._CHANGE_PASSWORD;
			ps = con.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setString(2, userid);
			ps.setString(3, oldPass);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				flag = true;
				System.out.println(".....");
			}
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			// throw new DataAcessException("Data base connection Failed");
		} catch (SQLException se) {
			se.printStackTrace();
			// throw new
			// DataNotFoundException("Sql exception riser/datanot found");
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean registerUser(RegisterBean rb) {
		boolean flag = false;
		String dob = DateWrapper.parseDate(rb.getDob());
		try {
			con = new AbstractDataAccessObject().getConnection();
			System.out.println("Con..." + con);
			String sql = SqlConstants._REGISTER_USER;
			ps = con.prepareStatement(sql);
			ps.setString(1, rb.getUserName());
			ps.setString(2, rb.getPassword());
			ps.setString(3, dob);
			ps.setString(4, rb.getEmail());
			ps.setString(5, rb.getPhoneNo());
			ps.setString(6, "user");
			int x = ps.executeUpdate();
			if (x > 0) {
				flag = true;
				System.out.println(".....");
			}
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			// throw new DataAcessException("Data base connection Failed");
		} catch (SQLException se) {
			se.printStackTrace();
			// throw new
			// DataNotFoundException("Sql exception riser/datanot found");
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public String registerUser1(RegisterBean rb) {
		boolean flag = false;
		String it = null;
		String doc = null;
		long signature = 0;
		long isignature = 0;
		int uid = 0;
		String lid = null;
		try {
			con = new AbstractDataAccessObject().getConnection();

			System.out.println("Con..." + con);

			int age = rb.getAge();

			Random random = new Random();

			isignature = (long) (Math.random() * 100000 + 5123400000L);

			int randage = random.nextInt(99);

			System.out.println(signature);
			System.out.println(randage);
			System.out.println(age * randage);

			ps1 = con.prepareStatement("select max(userid) from userdata");

			rs1 = ps1.executeQuery();
			if (rs1.next()) {
				uid = rs1.getInt(1);
				uid++;
			}

			ps2 = con
					.prepareStatement("select signature from usergroup where gname=?");
			ps2.setString(1, rb.getGroupName());
			rs2 = ps2.executeQuery();

			if (rs2.next()) {
				signature = rs2.getLong(1);
			}
			lid = "LID-" + uid;
			it = "[" + lid + "," + age + "," + age * randage + "," + signature
					+ "]";

			String dob = DateWrapper.parseDate(rb.getDob());

			String urole = rb.getUserrole();
			if (urole.equalsIgnoreCase("Doctor")) {
				doc = ".xml";
			}
			if (urole.equalsIgnoreCase("Patient")) {
				doc = ".docx";
			}
			if (urole.equalsIgnoreCase("Teacher")) {
				doc = ".pdf";
			}
			if (urole.equalsIgnoreCase("Student")) {
				doc = ".txt";
			}

			System.out.println(" in dao dob" + dob);

			String sql = SqlConstants._REGISTER_USER1;
			ps = con.prepareStatement(sql);
			ps.setString(1, rb.getUserName());
			ps.setString(2, rb.getPassword());
			ps.setString(3, rb.getFullName());
			ps.setString(4, rb.getLicence());
			ps.setString(5, dob);
			ps.setInt(6, rb.getAge());
			ps.setInt(7, rb.getYos());
			ps.setString(8, rb.getEmail());
			ps.setString(9, rb.getPhoneNo());
			ps.setString(10, rb.getUserrole());
			ps.setString(11, rb.getRole());
			ps.setString(12, lid);
			ps.setLong(13, signature);
			ps.setString(14, rb.getGroupName());
			ps.setLong(15, isignature);
			ps.setString(16, doc);
			int x = ps.executeUpdate();
			if (x > 0) {
				flag = true;
				System.out.println(".....");
			}
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			// throw new DataAcessException("Data base connection Failed");
		} catch (SQLException se) {
			se.printStackTrace();
			// throw new
			// DataNotFoundException("Sql exception riser/datanot found");
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return it;
	}

	public boolean updateUser(RegisterBean rb) {
		boolean flag = false;

		try {
			con = new AbstractDataAccessObject().getConnection();

			System.out.println("Con..." + con);
			String sql = SqlConstants._UPDATE_USER;
			ps = con.prepareStatement(sql);
			ps.setString(1, rb.getUserName());
			ps.setInt(2, rb.getAge());
			ps.setString(3, rb.getLicence());
			ps.setLong(4, rb.getIsignature());
			ps.setString(5, rb.getUserrole());
			ps.setString(6, rb.getDoc());
			ps.setInt(7, rb.getUserid());
			int x = ps.executeUpdate();
			if (x > 0) {
				flag = true;
				System.out.println(".....");
			}
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			// throw new DataAcessException("Data base connection Failed");
		} catch (SQLException se) {
			se.printStackTrace();
			// throw new
			// DataNotFoundException("Sql exception riser/datanot found");
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
}
