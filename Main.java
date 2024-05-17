import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Создание телефона через фабрику
        PhoneFactory factory = PhoneFactory.getFactory();
        Phone phone = factory.createPhone("123-456-7890", 10.0, 0.5);

        Scanner scan = new Scanner(System.in);
        
        // Добавление наблюдателя
        PhoneObserver observer = new PhoneObserver("Observer1");
        PhoneSubject subject = new PhoneSubject();
        subject.attach(observer);
        int c = 0;
        while (c != 5){
            System.out.println("Меню:\n1)Позвонить\n2)Ответить\n3)Пополнить баланс\n4)Выйти в интернет\n5)Выключить телефон\n");
            c = scan.nextInt();
            switch (c){
                case 1:
                    phone.call();
                    subject.setState("Calling");
                    System.out.println("Нажмите любую кнопку чтобы закончить разговор");
                    scan.next();
                    phone.endCall();
                    subject.setState("Waiting");
                    break;
                case 2:
                    phone.answer();
                    subject.setState("Talking");
                    System.out.println("Нажмите любую кнопку чтобы закончить разговор");
                    scan.next();
                    phone.endCall();
                    subject.setState("Waiting");
                    break;
                case 3:
                    int money = 0;
                    System.out.println("Введите сумму на которую вы хотите пополнить баланс:");
                    money = scan.nextInt();
                    phone.recharge(money);
                    subject.setState("Balance Recharged");
                    break;
                case 4:
                    Phone smartPhone = new SmartPhoneDecorator(phone);
                    ((SmartPhoneDecorator) smartPhone).browseInternet();
                    // Использование адаптера для оплаты
                    ExternalPaymentSystem externalPaymentSystem = new ExternalPaymentSystem();
                    PaymentGateway paymentGateway = new PaymentAdapter(externalPaymentSystem);
                    paymentGateway.makePayment(10.0);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Выберите функцию от 1 до 5");
            }


        }
        // // Проверка перехода состояний
        // phone.call();
        // subject.setState("Calling");

        // phone.answer();
        // subject.setState("Talking");



        // Пополнение баланса
        // phone.recharge(15);
        // subject.setState("Balance Recharged");

        // // Проверка паттерна Decorator
        // Phone smartPhone = new SmartPhoneDecorator(phone);
        // ((SmartPhoneDecorator) smartPhone).browseInternet();

        // // Использование адаптера для оплаты
        // ExternalPaymentSystem externalPaymentSystem = new ExternalPaymentSystem();
        // PaymentGateway paymentGateway = new PaymentAdapter(externalPaymentSystem);
        // paymentGateway.makePayment(20.0);
    }
}