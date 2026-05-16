public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (balance < 0) {
            this.balance = 0;
            System.out.println("Số dư không hợp lệ");
        } else {
            this.balance = balance;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    /*
     * Không viết setter cho accountNumber
     * vì số tài khoản là duy nhất và không nên thay đổi
     * sau khi tài khoản đã được tạo.
     */

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.trim().isEmpty()) {
            this.ownerName = ownerName;
        } else {
            System.out.println("Tên tài khoản không được để trống!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nap tien thanh cong: " + amount);
        } else {
            System.out.println("Nap tien that bai");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rut tien thanh cong: " + amount);
        } else {
            System.out.println("Rut tien that bai");
        }
    }

    public void transfer(BankAccount other, double amount) {
        if (amount <= 0) {
            System.out.println("So tien chuyen phai lon hon 0");
            return;
        }

        if (amount > balance) {
            System.out.println("So du khong du");
            return;
        }

        this.balance -= amount;
        other.balance += amount;

        System.out.println("Chuyen " + amount + " den chu tai khoan " + other.ownerName + " thanh cong");
    }

    public void displayInfo() {
        // lay 4 so cuoi
        String hiddenAccountNumber = "****" + accountNumber.substring(accountNumber.length() - 4);

        System.out.println("Số tài khoản: " + hiddenAccountNumber);
        System.out.println("Chủ tài khoản: " + ownerName);
        System.out.println("Số dư: " + balance);
    }

    public static void main(String[] args) {

        BankAccount bc1 = new BankAccount("098832239", "Le Van Sy", 1000000);
        BankAccount bc2 = new BankAccount("08892298233", "Hiu Nghia", 1000000);

        bc1.deposit(20000);
        bc1.displayInfo();

        bc1.withdraw(1000000);
        bc1.displayInfo();

        bc1.transfer(bc2, 10000);
    }
}
