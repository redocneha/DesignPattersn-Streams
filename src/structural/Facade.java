package structural;

//provides simplified interface to a set of complex interfaces/classes or system by hiding complexities from client
public class Facade {
    public static void main(String[] args) {
        Zomato zomato = new Zomato();
        zomato.deliverOrder();
    }
}

class Restaurant{
    public void prepare(){
        System.out.println("Food prepared");
    }
}

class Zomato{
    public void deliverOrder(){
        Restaurant restaurant = new Restaurant();
        restaurant.prepare();
        Deliveryteam deliveryteam = new Deliveryteam();
        DeliveryAgent agent = deliveryteam.assignDeliveryBoy();
        agent.deliver();
        agent.pickup();
        System.out.println("Food delivered");
    }

}
class Deliveryteam{
    public DeliveryAgent assignDeliveryBoy(){
        DeliveryAgent agent = new DeliveryAgent();
        return agent;
    }
}

class DeliveryAgent{
    public void pickup(){
        System.out.println("Delivery agent picked up");
    }
    public void deliver(){
        System.out.println("Delivery agent delivered food");
    }

}