package jspbook.ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventDAO {
	Connection conn = null;  //임포트 할때 자바.sql
	PreparedStatement pstmt = null;
	//h2이외 디비 열결정보는 별도 참고
	
	//h2 디비 연결 정보
	String jdbc_driver = "org.h2.Dirver";
	String jdbc_url = "jdbc:h2:tcp://127.0.0.1/~/test";
	//디비 연결 메서드
	
	
	
	public boolean register(Event event) { // 등록 메서드
		connect();
		String sql = "insert into event values(?,?)";      //삭제하거나 다른걸 할때는 바꿔주면 됨
		try {
			pstmt = conn.prepareStatement(sql);   //만들고   트라이캐치 해주면됨
			pstmt.setString(1, event.getName());
			pstmt.setString(2, event.getEmail());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
	
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "sa", "");//비밀번호 비워둠
		} catch (Exception e) { //익셉션 처리 - 예외상황 처리
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		try {
			pstmt.close();
			conn.close();
		}  catch (SQLException e) { 
			e.printStackTrace();
		}
	}

}
