package hcmute.model;

public class SeniorReader extends Reader {
    private String seniorCardNumber;

    public SeniorReader(String readerId, String fullName, String email, String seniorCardNumber) {
        super(readerId, fullName, email);
        this.seniorCardNumber = seniorCardNumber;
    }

    @Override
    public int getMaxBorrowLimit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0;
    }

    @Override
    public String getInfo() {
        return "Reader ID: " + getReaderId()
                + " | Name: " + getFullName()
                + " | Email: " + getEmail()
                + " | Ma The: " + seniorCardNumber
                + " [NCT - Mien Phat]";
    }

    public String getSeniorCardNumber() {
        return seniorCardNumber;
    }

    public void setSeniorCardNumber(String seniorCardNumber) {
        this.seniorCardNumber = seniorCardNumber;
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }

    @Override
    protected void onBorrowSuccess(Book book) {
        super.onBorrowSuccess(book); // in thông báo thông thường
        System.out.println("-> Đã ghi nhận: Người cao tuổi - không thu phí phạt");
    }

}
