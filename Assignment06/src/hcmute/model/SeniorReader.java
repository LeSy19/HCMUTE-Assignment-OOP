package hcmute.model;

public class SeniorReader extends Reader {
    private String seniorCardNumber;

    public SeniorReader(String readerId, String fullName, String email, String seniorCardNumber) {
        super(readerId, fullName, email);
        this.seniorCardNumber = seniorCardNumber;
    }

    @Override
    public int getMaxBorrow() {
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

}
