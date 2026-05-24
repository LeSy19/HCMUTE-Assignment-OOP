package hcmute.model;

public class Reader {

    private String readerId;
    private String fullName;
    private String email;
    private String cardType;

    public Reader(String readerId, String fullName, String email, String cardType) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
        this.cardType = cardType;
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    // Đăng ký thẻ
    public void registerLibraryCard() {
        System.out.println(fullName + "registered library card ");
    }

    public int getMaxBorrowBooks() {
        if (cardType.equalsIgnoreCase("Sinh viên")) {
            return 3;
        } else {
            return 5;
        }
    }

    // Hiển thị thông tin
    public void displayInfo() {
        System.out.println("Reader ID: " + readerId);
        System.out.println("Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Card Type: " + cardType);
    }

}
