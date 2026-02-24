package behavioural;

//avoids coupling between sender and receiver
//create responsbilities of tasks and pass it across to handle request conditionally
// if user s admin, no ened to cache, else, do caching and logging. etc.. here each task can be a responsbility
// which can be chained together to process a request, we can skip respon if needed
public class ChainOfResponsbility {
    public static void main(String[] args) {
        PaymentHandler bankPaymentHandler = new BankPaymentHandler();
        PaymentHandler cardPaymentHandler = new CardPaymentHandler();
        bankPaymentHandler.setNext(cardPaymentHandler);
        bankPaymentHandler.makePayment(1200);
    }
}

abstract class PaymentHandler{
    protected PaymentHandler next;
    public void setNext(PaymentHandler next){
        this.next = next;
    }
    abstract public void makePayment(int amount);
}

class BankPaymentHandler extends PaymentHandler{
    @Override
    public void makePayment(int amount) {
        System.out.println("Amount rece"+amount);
        if(amount<500)
            System.out.println("Bank payment done");
        else
            next.makePayment(amount);

    }
}

class CardPaymentHandler extends PaymentHandler{
    @Override
    public void makePayment(int amount) {
        if(amount>500)
            System.out.println("Card payment done");
        else
            next.makePayment(amount);

    }
}