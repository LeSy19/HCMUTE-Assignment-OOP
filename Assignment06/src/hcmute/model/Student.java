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
    public double calculateLateFee(int daysLate) {
        return daysLate * 2000; // Sinh viên trả chậm mỗi ngày phải trả 2000đ
    }

    @Override
    public String toString() {
        return super.toString() + " |Type: Student";
    }

    @Override
    public String getInfo() {
        return "[SV] " + getReaderId() + " | " + getFullName() + " | "
                + "Email: " + getEmail() + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
