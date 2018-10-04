package jspbook.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class NewsService {
	HashMap<String,News> newslist = new HashMap<>();
	
	public NewsService() {
		News s1 = new News();
		s1.setAid(1011);
		s1.setTitle("문재인 대통령 UN연설 성공적!!");
		s1.setImg("https://imgnews.pstatic.net/image/001/2018/09/27/PYH2018092701660001300_P2_20180927062326706.jpg?type=w647");
		s1.setDate("2018-9-27");
		s1.setContent("UN에서 연설중인 문재인 대통령의 당당한 모습");
		newslist.put("1011", s1);
		
		News s2 = new News();
		s2.setAid(1012);
		s2.setTitle("청약통장 전성 시대!!");
		s2.setImg("https://imgnews.pstatic.net/image/001/2018/09/27/AKR20180925029000003_04_i_20180927060231396.jpg?type=w647");
		s2.setDate("2018-9-25");
		s2.setContent("청약통장 가입자가 20만명이나 된다고 합니다.!!");
		newslist.put("1012",s2);
		
		News s3 = new News();
		s3.setAid(1013);
		s3.setTitle("10월 대풍 대란 오나");
		s3.setImg("https://imgnews.pstatic.net/image/469/2018/10/04/0000331546_001_20181004090509221.jpg?type=w647");
		s3.setDate("2018-10-3");
		s3.setContent("벌써 5번째 태풍이 오고 있습니다. 모두 주의 하세요..");
		newslist.put("1013",s3);
	}
	public List<News> getNewsList() {
		return new ArrayList<News>(newslist.values());
	}
	
    public Optional<News> getNews(String aid) {
        return Optional.of(newslist.get(aid));
    }
}
