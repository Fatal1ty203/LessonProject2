package hw.homework_wildcards.taskTwo;

abstract class Account {
    private String login;
    private String password;
    private int warnings;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void makeWarning() {
        warnings++;
    }

    public int getWarnings() {
        return warnings;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{ " +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", warnings=" + warnings + "}";
    }
}
