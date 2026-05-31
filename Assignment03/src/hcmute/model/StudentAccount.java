package hcmute.model;

public class StudentAccount extends DigitalAccount {

    private String password;
    private Student student;

    public StudentAccount(String accountId, String displayName, String password, Student student) {
        super(accountId, displayName);
        this.password = password;
        this.student = student;
    }

    @Override
    public boolean authenticate(String credential) {
        return password.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 3;
    }

}
