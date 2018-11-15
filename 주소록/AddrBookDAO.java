package addrbook;

import java.util.List;

public interface AddrBookDAO {

	void connect();
	void disconnect();
	
	// 등록 메서드
	boolean insertDB(AddrBook addrbook);

	// 목록 가져오기
	List<AddrBook> getAll();

	// 수정 메서드
	boolean updateDB(AddrBook addrbook);
	
	// 수정내용 가져오기
	AddrBook getDB(int ab_id);
	
	// 삭제
	boolean deleteDB(int ab_id);
}
