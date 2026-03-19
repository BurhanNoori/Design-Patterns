import com.burhan.design.pattern.creational.factory.PaymentProcessorFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        PaymentProcessorFactory.getProcessor("credit").doPayment(5043.89);
        PaymentProcessorFactory.getProcessor("upi").doPayment(597867.89);
    }
}