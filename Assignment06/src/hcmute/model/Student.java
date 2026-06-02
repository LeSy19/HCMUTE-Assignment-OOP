package hcmute.model;

public class Student extends Reader {
    public Student(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    @Override
    public int getMaxBorrowLimit() {
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
                + "Email: " + getEmail() + " | Han muon: " + getMaxBorrowLimit() + " cuon";
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        // sinh viên không được mượn sách tham khảo hiếm
        return !book.isReferenceOnly();
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "Sách tham khảo chỉ đọc tại chỗ - sinh viên không được mang về!";
    }
}
