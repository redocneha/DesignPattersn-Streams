package creational;

//hide the object creation logic from the client by delegating this to factory class which would return object accordingly and refer the created object using interface

// ask cust to choose mortgage product on ui, based on it, backend will have factory to create required object and accordingly send the complex calculated value back to Ui

public class FactoryDP {
    public static void main(String[] args) {
        Subscription subscription = SubscriptionFactory.getSubscription("Corporate",1000);
        System.out.println("Personal bill for user 1 is "+subscription.calculateBill());
    }
}

class SubscriptionFactory {
    public static Subscription getSubscription(String type,int usage){
        if(type.equals("Personal"))
            return new PersonalSubscription(usage);
        return new CorporateSubscription(usage);
    }
}

interface Subscription{
    public int calculateBill();
}
class PersonalSubscription implements Subscription{
    private static final int billRate = 1200;
    private int usage;

    public PersonalSubscription(int usage) {
        this.usage = usage;
    }
    @Override
    public int calculateBill() {
        return usage*billRate;
    }
}

class CorporateSubscription implements Subscription{

    private static final int billRate = 2000;
    private int usage;

    public CorporateSubscription(int usage) {
        this.usage = usage;
    }

    @Override
    public int calculateBill() {
        return usage*billRate;
    }
}
