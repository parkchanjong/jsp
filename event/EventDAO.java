package jspbook.pevent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	// H2 이외 DB 연결정보는 별도 참고
	/* H2 DB 연결정보 */
	String jdbc_driver = "org.h2.Driver";				//라이브러리 확인  -> 없으면 build.gradle에 명시
	String jdbc_url = "jdbc:h2:tcp://localhost/~/test"; 			//h2디비 콘솔에 다 적혀있음

	// DB연결 메서드
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,"sa","");   //디폴트 관리계정 sa  비밀번호는 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Event> getAll() {			//리턴타입: List<Event>		 집합형 데이터 (이벤트 타입)
		connect();
		List<Event> eventlist = new ArrayList<>();
		String sql = "select * from event";
		ResultSet rs;		//ResultSet 객체 생성
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();				//리턴값 rs
			while(rs.next()) {
				Event event = new Event();			//이벤트 객체 만듬
				event.setName(rs.getString("name"));	//이벤트에 데이터 채우기
				event.setEmail(rs.getString("email"));
				eventlist.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return eventlist;
	}
	
	public boolean register(Event event) {
		connect();
		String sql = "insert into event values(?,?)";		//아래 2개를 집어 놓음
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, event.getName());			//
			pstmt.setString(2, event.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		} finally {				//성공하든 실패하든 디비 사용 종료
			disconnect();
		}
		return true;
	}
}
