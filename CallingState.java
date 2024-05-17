class CallingState implements PhoneState {
    public void call(Phone phone) {
        System.out.println("Already calling...");
    }

    public void answer(Phone phone) {
        phone.setState(new TalkingState());
        System.out.println("Call answered.");
    }

    public void endCall(Phone phone) {
        phone.setState(new WaitingState());
        System.out.println("Call ended.");
    }

    public void recharge(Phone phone, double amount) {
        phone.setBalance(phone.getBalance() + amount);
        System.out.println("Balance recharged: " + amount);
    }
}