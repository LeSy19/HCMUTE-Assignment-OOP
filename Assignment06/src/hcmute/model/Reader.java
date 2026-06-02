package hcmute.model;

public abstract class Reader {

    protected String readerId;
    protected String fullName;
    protected String email;
    protected int currentBorrowCount;

    public Reader(String readerId, String fullName, String email) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
        this.currentBorrowCount = 0;
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

    public abstract int getMaxBorrowLimit();

    public abstract double calculateLateFee(int daysLate);

    public abstract String getInfo();

    // Template method: quy trình cho mượn chuẩn (4 bước)
    public final BorrowResult processBorrow(Book book) {
        // Bước 1: kiểm tra đọc giả có quyền mượn hay không
        if (!checkBorrowQuota()) {
            return new BorrowResult(false, "Đã đạt giới hạn mượn " + getMaxBorrowLimit() + " cuốn");
        }
        // Bước 2: kiểm tra điều kiện đặc thù của từng loại độc giả
        if (!checkSpecialCondition(book)) {
            return new BorrowResult(false, getSpecialConditionMessage());
        }

        // Bước 3: trừ tồn kho sách
        book.descreaseQuantity();
        currentBorrowCount++;

        // Bươc 4: ghi nhận và thông báo (có thể override - Hook method)
        onBorrowSuccess(book);
        return new BorrowResult(true, "Mượn thành công: " + book.getTitle());
    }

    // Bước 1 - cố định, dùng chung
    public boolean checkBorrowQuota() {
        return currentBorrowCount < getMaxBorrowLimit();
    }

    // Bước 2: abstract - mỗi loại độc giả tự định nghĩa điều kiện đặc thù
    protected abstract boolean checkSpecialCondition(Book book);

    protected abstract String getSpecialConditionMessage();

    // bước 4: hook - có thể override để thêm hành động sau khi mượn thành công
    protected void onBorrowSuccess(Book book) {
        System.out.println(getFullName() + " đã mượn: " + book.getTitle());
    }

    // Lớp hỗ trợ để trả về kết quả giao dịch (rõ ràng hơn dùng boolean thuần):
    public class BorrowResult {
        private boolean success;
        private String message;

        public BorrowResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
