package addrbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddrBookH2DAO implements AddrBookDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	// H2 이외 DB 연결정보는 별도 참고
	/* H2 DB 연결정보 */
	String jdbc_driver = "org.h2.Driver";
	String jdbc_url = "jdbc:h2:tcp://localhost/~/test";

	// DB연결 메서드
	public void connect() {
			try {
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(jdbc_url,"sa","");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	public void disconnect() {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	@Override
	public boolean insertDB(AddrBook addrbook) {
		connect();
		String sql = "insert into addrbook(ab_name, ab_email, ab_comdept, ab_birth, ab_tel, ab_memo) values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addrbook.getAb_name());
			pstmt.setString(2, addrbook.getAb_email());
			pstmt.setString(3, addrbook.getAb_comdept());
			pstmt.setString(4, addrbook.getAb_birth());
			pstmt.setString(5, addrbook.getAb_tel());
			pstmt.setString(6, addrbook.getAb_memo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return true;
	}

	@Override
	public boolean updateDB(AddrBook addrbook) {
		connect();
		String sql = "update addrbook set ab_name=?, ab_email=?, ab_comdept=?, ab_birth=?, ab_tel=?, ab_memo=? where ab_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addrbook.getAb_name());
			pstmt.setString(2, addrbook.getAb_email());
			pstmt.setString(3, addrbook.getAb_comdept());
			pstmt.setString(4, addrbook.getAb_birth());
			pstmt.setString(5, addrbook.getAb_tel());
			pstmt.setString(6, addrbook.getAb_memo());
			pstmt.setInt(7, addrbook.getAb_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return true;
	}

	@Override
	public AddrBook getDB(int ab_id) {
		connect();
		String sql = "select * from addrbook where ab_id=?";
		ResultSet rs;
		AddrBook addrbook = new AddrBook();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab_id);

			rs = pstmt.executeQuery();
			rs.next();
			
			addrbook.setAb_id(ab_id);
			addrbook.setAb_name(rs.getString("ab_name"));
			addrbook.setAb_email(rs.getString("ab_email"));
			addrbook.setAb_tel(rs.getString("ab_tel"));
			addrbook.setAb_birth(rs.getString("ab_birth"));
			addrbook.setAb_comdept(rs.getString("ab_comdept"));
			addrbook.setAb_memo(rs.getString("ab_memo"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return addrbook;
	}

	@Override
	public boolean deleteDB(int ab_id) {
		connect();
		String sql = "delete from addrbook where ab_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return true;
	}

	@Override
	public List<AddrBook> getAll() {
		connect();
		String sql = "select * from addrbook";
		ResultSet rs;
		List<AddrBook> datas = new ArrayList<>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AddrBook addrbook = new AddrBook();
				addrbook.setAb_id(rs.getInt("ab_id"));
				addrbook.setAb_name(rs.getString("ab_name"));
				addrbook.setAb_email(rs.getString("ab_email"));
				addrbook.setAb_tel(rs.getString("ab_tel"));
				addrbook.setAb_birth(rs.getString("ab_birth"));
				addrbook.setAb_comdept(rs.getString("ab_comdept"));
				addrbook.setAb_memo(rs.getString("ab_memo"));
				
				datas.add(addrbook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return datas;
	}

}
