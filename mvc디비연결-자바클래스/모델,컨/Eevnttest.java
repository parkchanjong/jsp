package jspbook.ch08;

import java.util.Scanner;

public class Eevnttest {		//임시로 컨트롤러 아니고  자바 프로그램

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("이름:");
		String name = scan.next();
		System.out.println("이메일:");
		String email = scan.next();
		
		Event event = new Event();
		event.setName(name);
		event.setEmail(email);
		
		EventDAO dao = new EventDAO();
		dao.register(event);
		
		// TODO Auto-generated method stub

	}

}
