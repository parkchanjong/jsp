package jspbook.ch05;

import java.util.Optional;

public class StudentService {
    public Optional<Student> getStudent(int id) {		// Optional 데이터가 넘어오는 것을 확인
        switch (id) {
            case 1:
                return Optional.of(new Student(1, "홍길동", "컴퓨터공학과"));
            case 2:
                return Optional.of(new Student(2, "김사랑", "전자공학과"));
            case 3:
                return Optional.of(new Student(3, "강동명", "건축학과"));
            default:
                return Optional.empty();
        }
    }
}
