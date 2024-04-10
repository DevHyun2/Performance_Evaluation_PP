package perfornance_evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CheckDAO {

	Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	private CheckDTO makeCheck(ResultSet rs) throws SQLException {
		CheckDTO check = new CheckDTO();

		check.setCheck_id(rs.getInt("check_id"));
		check.setDepartment(rs.getString("department"));
		check.setRank(rs.getString("rank"));
		check.setCheck_name(rs.getString("check_name"));
		check.setDescription(rs.getString("description"));
		return check;
	}

	private CheckDTO makeCheck2(ResultSet rs) throws SQLException {
		CheckDTO check = new CheckDTO();

		check.setCheck_id(rs.getInt("check_id"));
		check.setDepartment(rs.getString("department"));
		//check.setRank(rs.getString("rank"));
		check.setCheck_name(rs.getString("check_name"));
		check.setDescription(rs.getString("description"));
		return check;
	}
	
	private CheckDTO makeCheck3(ResultSet rs) throws SQLException {
		CheckDTO check = new CheckDTO();

		check.setCheck_id(rs.getInt("check_id"));
		//check.setDepartment(rs.getString("department"));
		check.setRank(rs.getString("rank"));
		check.setCheck_name(rs.getString("check_name"));
		check.setDescription(rs.getString("description"));
		return check;
	}
	
	// 전체 항목 조회
	public List<CheckDTO> selectAll() {
		List<CheckDTO> checklist = new ArrayList<CheckDTO>();
		String sql = "select * from checklists";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				CheckDTO check = makeCheck(rs);
				checklist.add(check);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return checklist;
	}
	
	//직급별 항목 조회
	public List<CheckDTO> rankCheck(String rank) {
	    List<CheckDTO> checklist = new ArrayList<CheckDTO>();
	    String sql = "select check_id, "
	    		+ "rank, "
	    		+ "check_name, "
	    		+ "description "
	    		+ "from checklists where rank = ?";
	    conn = DBUtil.dbConnection();
	    try {
	        pst = conn.prepareStatement(sql);
	        pst.setString(1, rank);
	        rs = pst.executeQuery();
	        while (rs.next()) {
	        	CheckDTO check = makeCheck3(rs);
	        	checklist.add(check);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.dbDisconnect(conn, st, rs);
	    }
	    return checklist;
	}
	
	//부서별 항목 조회
	public List<CheckDTO> deptCheck(String dept) {
	    List<CheckDTO> checklist = new ArrayList<CheckDTO>();
	    String sql = "select check_id, "
	    		+ "department, "
	    		+ "check_name, "
	    		+ "description "
	    		+ "from checklists where department = ?";
	    conn = DBUtil.dbConnection();
	    try {
	        pst = conn.prepareStatement(sql);
	        pst.setString(1, dept);
	        rs = pst.executeQuery();
	        while (rs.next()) {
	        	CheckDTO check = makeCheck2(rs);
	        	checklist.add(check);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.dbDisconnect(conn, st, rs);
	    }
	    return checklist;
	}
	
	// 입력(Insert)
	public int insertCheck(CheckDTO check) {
		int result = 0;
		String sql = "INSERT INTO checkLists (check_id, department, rank, check_name, description)VALUES"
				+ "((SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists), "
				+ "?, ?, ?, ?)";
		conn = DBUtil.dbConnection(); 
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, check.getDepartment());
			pst.setString(2, check.getRank());
			pst.setString(3, check.getCheck_name());
			pst.setString(4, check.getDescription());
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//평가 항목 제거
	int deleteCheck(int checkid) {
		int result = 0;
		String sql = "delete from checklists "
					+ "where check_id = ? ";
		conn = DBUtil.dbConnection(); 
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, checkid);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
}