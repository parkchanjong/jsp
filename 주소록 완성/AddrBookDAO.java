package javaweb.addrbook;

import java.util.ArrayList;

public interface AddrBookDAO {

	// 수정된 주소록 내용 갱신을 위한 메서드
	boolean updateDB(AddrBook addrbook);

	// 특정 주소록 게시글 삭제 메서드
	boolean deleteDB(int gb_id);

	// 신규 주소록 메시지 추가 메서드
	boolean insertDB(AddrBook addrbook);

	// 특정 주소록 게시글 가져오는 메서드
	AddrBook getDB(int gb_id);

	// 전체 주소록 목록을 가져오는 메서드
	ArrayList<AddrBook> getDBList();

}