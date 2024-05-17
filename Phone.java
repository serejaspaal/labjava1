class Phone {
    private String number;
    private double balance;
    private double callProbability;
    private PhoneState state;

    public Phone(String number, double balance, double callProbability) {
        this.number = number;
        this.balance = balance;
        this.callProbability = callProbability;
        this.state = new WaitingState();
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCallProbability() {
        return callProbability;
    }

    public PhoneState getState() {
        return state;
    }

    public void setState(PhoneState state) {
        this.state = state;
    }

    // Operations
    public void call() {
        state.call(this);
    }

    public void answer() {
        state.answer(this);
    }

    public void endCall() {
        state.endCall(this);
    }

    public void recharge(double amount) {
        state.recharge(this, amount);
    }
}
