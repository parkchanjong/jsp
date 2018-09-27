package jspbook.ch05;

public class Student {
	private int id;
    private String name;
    private String dept;
    
    public Student(int id, String name, String dept) {  //생성자에 파라미터가 전달될때 디폴스 파라미터를 하나 만들어 주는것이 좋음
    	this.id = id;
    	this.name = name;
    	this.dept = dept;
    }
    public Student() {
		super();
		// TODO Auto-generated constructor stub  
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}
