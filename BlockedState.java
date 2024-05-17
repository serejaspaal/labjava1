class BlockedState implements PhoneState {
    public void call(Phone phone) {
        System.out.println("Cannot call, balance is negative!");
    }

    public void answer(Phone phone) {
        System.out.println("Cannot answer, balance is negative!");
    }

    public void endCall(Phone phone) {
        System.out.println("Cannot end call, balance is negative!");
    }

    public void recharge(Phone phone, double amount) {
        phone.setBalance(phone.getBalance() + amount);
        if (phone.getBalance() > 0) {
            phone.setState(new WaitingState());
            System.out.println("Balance positive, phone unblocked.");
        } else {
            System.out.println("Balance recharged, but still negative.");
        }
    }
}