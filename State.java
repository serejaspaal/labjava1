interface PhoneState {
    void call(Phone phone);
    void answer(Phone phone);
    void endCall(Phone phone);
    void recharge(Phone phone, double amount);
}
