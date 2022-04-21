package lessons.lesson45_account.ex2_toMap;


class Payment {
    String login;
    int sum;

    public Payment(String login, int sum) {
        this.login = login;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "login='" + login + '\'' +
                ", sum=" + sum +
                '}';
    }
}
