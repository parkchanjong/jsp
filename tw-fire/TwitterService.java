package javaweb.twitter;

import java.util.List;

public interface TwitterService {

	void write(String msg);

	List<String> getList();

}