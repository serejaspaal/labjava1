abstract class PhoneDecorator extends Phone {
    protected Phone decoratedPhone;

    public PhoneDecorator(Phone phone) {
        super(phone.getNumber(), phone.getBalance(), phone.getCallProbability());
        this.decoratedPhone = phone;
    }

    @Override
    public void call() {
        decoratedPhone.call();
    }

    @Override
    public void answer() {
        decoratedPhone.answer();
    }

    @Override
    public void endCall() {
        decoratedPhone.endCall();
    }

    @Override
    public void recharge(double amount) {
        decoratedPhone.recharge(amount);
    }
}

class SmartPhoneDecorator extends PhoneDecorator {
    public SmartPhoneDecorator(Phone phone) {
        super(phone);
    }

    public void browseInternet() {
        System.out.println("Browsing the internet...");
    }
}