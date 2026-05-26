package hcmute.model;

public class Lecturer extends Reader {
    public Lecturer(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    @Override
    public int getMaxBorrow() {
        return 5; // Giảng viên có thể mượn tối đa 5 sách
    }

    @Override
    public String toString() {
        return super.toString() + " |Type: Lecturer";
    }

}
