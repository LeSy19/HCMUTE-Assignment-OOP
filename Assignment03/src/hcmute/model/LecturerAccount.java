package hcmute.model;

public class LecturerAccount extends DigitalAccount {

    private String opt;
    private Lecturer lecturer;

    public LecturerAccount(String accountId, String displayName, String opt, Lecturer lecturer) {
        super(accountId, displayName);
        this.opt = opt;
        this.lecturer = lecturer;
    }

    @Override
    public boolean authenticate(String credential) {
        return opt.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return -1; // Không giới hạn
    }

}
