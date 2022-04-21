package hw.homework11_set.HashSet;

import java.util.Objects;

public class UserAccount {
    private String login;
    private int password;

    public UserAccount(String login, int password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "login='" + login + '\'' +
                ", password=" + password +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
