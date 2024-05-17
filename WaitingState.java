class WaitingState implements PhoneState {
    public void call(Phone phone) {
        if (phone.getBalance() > 0) {
            phone.setState(new CallingState());
            System.out.println("Calling...");
        } else {
            phone.setState(new BlockedState());
            System.out.println("Cannot call, balance is low!");
        }
    }

    public void answer(Phone phone) {
        System.out.println("No incoming call to answer.");
    }

    public void endCall(Phone phone) {
        System.out.println("No ongoing call to end.");
    }

    public void recharge(Phone phone, double amount) {
        phone.setBalance(phone.getBalance() + amount);
        System.out.println("Balance recharged: " + amount);
    }
}