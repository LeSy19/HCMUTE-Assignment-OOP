package hcmute.model;

public abstract class Reader {

    private String readerId;
    private String fullName;
    private String email;

    public Reader(String readerId, String fullName, String email) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Đăng ký thẻ
    public void registerLibraryCard() {
        System.out.println(fullName + "registered library card ");
    }

    public abstract int getMaxBorrow();

    public abstract double calculateLateFee(int daysLate);

    public abstract String getInfo();

    // @Override
    // public String toString() {
    // return "Reader ID: " + readerId + "| Name: " + fullName + "| Email: " +
    // email;
    // }

    // // Hiển thị thông tin
    // public void displayInfo() {
    // System.out.println("Reader ID: " + readerId);
    // System.out.println("Name: " + fullName);
    // System.out.println("Email: " + email);

    // }

}
