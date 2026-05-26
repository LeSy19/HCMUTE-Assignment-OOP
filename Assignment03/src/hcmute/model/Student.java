package hcmute.model;

public class Student extends Reader {
    public Student(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    @Override
    public int getMaxBorrow() {
        return 3; // Sinh viên có thể mượn tối đa 3 sách
    }

    @Override
    public String toString() {
        return super.toString() + " |Type: Student";
    }
}
