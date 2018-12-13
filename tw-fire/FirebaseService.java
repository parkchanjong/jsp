package javaweb.twitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class FirebaseService implements TwitterService {
	Logger log = Logger.getGlobal();
	String baseurl="https://mytwitter-28c5b.firebaseio.com/twitter.json";
	
	public void write(String msg) {				//저장할 데이터 문자열 받아옴
		JSONObject bodyMsg = new JSONObject();			//JSONObject 객체 생성   josn형테 구조			
		bodyMsg.put("msg", msg);			//msg 키값으로 저장할 데이터를 만든다
		
		HttpResponse<String> jsonResponse;
		try {
			jsonResponse = Unirest.post(baseurl)		//unirestapi 
			        .header("Accept", "application/json")			//;; 없이 사용  -> 메서드 체이닝
			        .header("Content-Type", "application/json")
			        .body(bodyMsg)
					.asString();
			log.info(jsonResponse.getBody().toString());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}
	
public List<String> getList() {				//리스트타입  list로 넘겨줘야됨
		List<String> tweetlist = new ArrayList<String>();
		HttpResponse<com.mashape.unirest.http.JsonNode> retmsg;		//json노드 값으로 받는다
		try {
			retmsg = Unirest.get(baseurl).asJson();
			JSONObject msglist = retmsg.getBody().getObject();		//json 메시지로 받은 바디를  json 오브젝트로 바꾸어 줘야 핸들링 할수 있다
			Iterator<String> keys = msglist.keys();		//키의 목록을 만들고
			while(keys.hasNext()) {
				JSONObject msg = (JSONObject) msglist.get(keys.next());		//해당필드를 가져오고 
				tweetlist.add(msg.getString("msg"));
			}
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return tweetlist;
	}
}