package perfornance_evaluation;

import java.sql.*;
import java.util.*;

public class EmpDAO {
	
	Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	//사원 로그인
	public int selectEmpLog(int empid, int emppw) {
		int result = 0;
		String sql = "select count(employee_id) " 
					+ "from employees " 
					+ "where employee_id = ? "
					+ "and employee_pw = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			pst.setInt(2, emppw);
			rs = pst.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return result;
	}
	
	//관리자 로그인
	public int selectAdminLog(int adminid, int emppw) {
		int result = 0;
		String sql =  "select count(admin_id) " 
					+ "from employees " 
					+ "where admin_id = ? "
					+ "and employee_pw = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, adminid);
			pst.setInt(2, emppw);
			rs = pst.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return result;
	}
	
	// 특정 직원 1명 조회
	public EmpDTO empidCheck(int empid) {
	    EmpDTO emp = null;
	    String sql = "select employee_id, "
	                + " name, "
	                + " birthdate, "
	                + " department, "
	                + " rank, "
	                + " join_date " 
	                + " from employees where employee_id = " + empid; //동명이인 제거
	    conn = DBUtil.dbConnection();
	    try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}
	
	//직급별 사원 조회
	public List<EmpDTO> rankCheck(String rank) {
	    List<EmpDTO> emplist = new ArrayList<EmpDTO>();
	    String sql = "select employee_id, "
	                + " name, "
	                + " birthdate, "
	                + " department, "
	                + " rank, "
	                + " join_date " 
	                + " from employees where rank = ?";
	    conn = DBUtil.dbConnection();
	    try {
	        pst = conn.prepareStatement(sql);
	        pst.setString(1, rank);
	        rs = pst.executeQuery();
	        while (rs.next()) {
	            EmpDTO emp = makeEmp(rs);
	            emplist.add(emp);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.dbDisconnect(conn, st, rs);
	    }
	    return emplist;
	}
	
	//부서별 사원 조회
	public List<EmpDTO> deptCheck(String dept) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select employee_id, "
					+ " name, "
					+ " birthdate, "
					+ " department, "
					+ " rank, "
					+ " join_date "
					+ " from employees where department = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, dept);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}
	
	
	
	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();
		
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setName(rs.getString("name"));
		emp.setBirthdate(rs.getString("birthdate"));
		//emp.setEmployee_pw(rs.getInt("employee_pw"));
		emp.setDepartment(rs.getString("department"));
		emp.setRank(rs.getString("rank"));
		emp.setJoin_date(rs.getDate("join_date"));
		//emp.setAdmin_id(rs.getInt("admin_id"));
		
		
		return emp;
	}
	
}
