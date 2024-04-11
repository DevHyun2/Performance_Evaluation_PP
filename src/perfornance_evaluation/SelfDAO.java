package perfornance_evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelfDAO {
	Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	//평가 점수 조회
	List<JoinCheckPerfDTO> scoreSearch(int empid) {
		List<JoinCheckPerfDTO> scorelist = new ArrayList<JoinCheckPerfDTO>();
		String sql = "SELECT p.review_id, c.rank, c.department, p.employee_id, c.description, p.review_year, p.score "
					+ "FROM performances p "
					+ "INNER JOIN checkLists c ON p.check_id = c.check_id "
					+ "WHERE p.employee_id = ?";
		
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				scorelist.add(makeCheck(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        DBUtil.dbDisconnect(conn, pst, rs);
	    }
		return scorelist;
	}
	
	//평균 점수
	public List<ScoreCheckDTO> scoreAvg(int employee_id) {
		List<ScoreCheckDTO> scoreavg = new ArrayList<ScoreCheckDTO>();
		String sql = "SELECT * FROM avg_scores WHERE employee_id = ?";
		
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, employee_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				ScoreCheckDTO score = makecheck2(rs);
				scoreavg.add(score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return scoreavg;
	}
	
	 private JoinCheckPerfDTO makeCheck(ResultSet rs) throws SQLException {
			JoinCheckPerfDTO check = new JoinCheckPerfDTO();
			
			check.setReview_id(rs.getInt("review_id"));
		    check.setRank(rs.getString("rank"));
		    check.setDepartment(rs.getString("department"));
		    check.setEmployee_id(rs.getInt("employee_id"));
		    check.setDescription(rs.getString("description"));
		    check.setReview_year(rs.getInt("review_year"));
		    check.setScore(rs.getInt("score"));
			
		    
			return check;
		}
	 private ScoreCheckDTO makecheck2(ResultSet rs) throws SQLException {
		 ScoreCheckDTO score = new ScoreCheckDTO();
		 
		 score.setEmployee_id(rs.getInt("employee_id"));
		 score.setReview_year(rs.getInt("review_year"));
		 score.setAverage_score(rs.getInt("average_score"));
		 
		 return score;
		 
	 }
}
