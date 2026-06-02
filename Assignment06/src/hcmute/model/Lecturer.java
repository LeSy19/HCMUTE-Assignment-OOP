package hcmute.model;

public class Lecturer extends Reader {
    public Lecturer(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5; // Giảng viên có thể mượn tối đa 5 sách
    }

    @Override
    public String toString() {
        return super.toString() + " |Type: Lecturer";
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1000; // Giảng viên trả chậm mỗi ngày phải trả 1000đ
    }

    @Override
    public String getInfo() {
        return "[GV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrowLimit() + " cuon";
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "Sách tham khảo chỉ đọc tại chỗ - giảng viên không được mang về!";
    }

}
