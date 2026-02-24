package structural;

// to restrict the access of actual object based on security check
// substitute obj is returned first and if pass is success, it will pass the exec to actual class
//caching requests in proxy exec
public class Proxy {
    public static void main(String[] args) {
        OfficeInternetAccess internetAccess = new ProxyInternetAccess();
        internetAccess.show();
    }
}

class OfficeInternetAccess{
    public void show(){
        System.out.println("Accessed the office internet");
    }
}
class ProxyInternetAccess extends OfficeInternetAccess{
    public void show(){
        System.out.println("Inside proxy internet");
        //if auth is fine,
        super.show();
    }
}