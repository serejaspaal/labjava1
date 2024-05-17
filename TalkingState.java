class TalkingState implements PhoneState {
    public void call(Phone phone) {
        System.out.println("Already in a conversation.");
    }

    public void answer(Phone phone) {
        System.out.println("Already in a conversation.");
    }

    public void endCall(Phone phone) {
        phone.setState(new WaitingState());
        System.out.println("Conversation ended.");
    }

    public void recharge(Phone phone, double amount) {
        phone.setBalance(phone.getBalance() + amount);
        System.out.println("Balance recharged: " + amount);
    }
}