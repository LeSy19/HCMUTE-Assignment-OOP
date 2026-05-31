package hcmute.model;

public abstract class DigitalAccount {
    private String accountId;
    private String displayName;

    public DigitalAccount(String accountId, String displayName) {
        this.accountId = accountId;
        this.displayName = displayName;
    }

    public abstract boolean authenticate(String credential);

    public abstract int getDownloadLimit();

    // Phương thức chung: kiểm tra giới hạn và thực hiện tải
    public boolean requestDownload(int downloadsToday) {
        int limit = getDownloadLimit();

        if (limit == -1 || downloadsToday < limit) { // -1 nghĩa là không giới hạn
            System.out.println("Tai xuong thanh cong: " + (downloadsToday + 1) + "/" + (limit == -1 ? "∞" : limit));
            return true;
        }
        System.out.println("Da dat gioi han tai xuong hom nay!");
        return false;

    }
}
