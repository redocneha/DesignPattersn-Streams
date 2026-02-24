package creational;

public class Singleton {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("Are loggers equal"+ logger1.equals(logger2));

        Logger2 logger21 = Logger2.INSTANCE;
        Logger2 logger22 = Logger2.INSTANCE;
        System.out.println("Are loggers equal"+ logger22.equals(logger21));

    }
}

class Logger{
    public static Logger logger;

    public Logger(){

    }
    //synchronized for thread safety
    public static synchronized Logger getInstance(){
        if(logger==null) logger = new Logger();
        return logger;
    }

}

enum Logger2{
    //public static final field that represents instance of logger2
    INSTANCE;
    private Logger2(){
        System.out.println("logger 2 ");
    }
}