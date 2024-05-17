class CallService {
    private static CallService instance;

    private CallService() {}

    public static synchronized CallService getInstance() {
        if (instance == null) {
            instance = new CallService();
        }
        return instance;
    }

    public void initiateCall(Phone phone) {
        phone.call();
    }

    public void receiveCall(Phone phone) {
        phone.answer();
    }

    public void terminateCall(Phone phone) {
        phone.endCall();
    }
}