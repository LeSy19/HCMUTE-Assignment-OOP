package hcmute.model;

public class LibraryCard extends DigitalAccount {
    private String rfid;

    public LibraryCard(String accountId, String displayName, String rfid) {
        super(accountId, displayName);
        this.rfid = rfid;
    }

    @Override
    public boolean authenticate(String credential) {
        return rfid.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 2; // giới hạn tải xuống là 2 tài liệu
    }

}
