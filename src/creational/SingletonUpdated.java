package creational;

public class SingletonUpdated {
    private static SingletonUpdated instance;
    private static SingletonUpdated instance2 = new SingletonUpdated();

    private SingletonUpdated(){}

    // Lazy Initialisation + Not thread safe
    public static SingletonUpdated getInstance(){
        if(instance == null) {
            instance = new SingletonUpdated();
        }
        return instance;
    }
    // Lazy Initialisation + Thread safe
    public static synchronized SingletonUpdated getThreadSafeInstance(){
        System.out.println("Thread entered is ---"+Thread.currentThread().getName());
        if(instance == null) {
            System.out.println("Nehaa--- Only "+Thread.currentThread().getName()+"has entered");
            instance = new SingletonUpdated();
        }
        return instance;
    }
    // Lazy Initialisation + Thread safe +Double check
    public static SingletonUpdated getThreadSafeInstance2(){
        System.out.println("Thread entered is ---"+Thread.currentThread().getName());
        if(instance == null) {
            synchronized (SingletonUpdated.class) {
                if(instance == null) { // double check if instance was already created by other thread
                    instance = new SingletonUpdated();
                    System.out.println("Nehaa--- Only " + Thread.currentThread().getName() + "has entered and created" + instance);
                }
            }
        }
        return instance;
    }
    // Eager Initialisation + Thread safe
    public static SingletonUpdated getEagerInstance(){
        return instance2;
    }
    // Lazy + Static Inner Class + Thread safe
    public static SingletonUpdated getLazyStaticCLassInstance(){
        return SingletonInner.instance3;
    }

    static class SingletonInner{
        private static SingletonUpdated instance3 = new SingletonUpdated();
    }

}

class Solution{
    public static void main(String[] args) throws InterruptedException {
//        SingletonUpdated singletonUpdated = SingletonUpdated.getInstance();
//        SingletonUpdated singletonUpdated2 = SingletonUpdated.getInstance();
//        boolean isSame = singletonUpdated2 == singletonUpdated;
//        System.out.println("Is Singleton??" + isSame);
//
//        SingletonUpdated singletonUpdated3 = SingletonUpdated.getEagerInstance();
//        SingletonUpdated singletonUpdated4 = SingletonUpdated.getEagerInstance();
//        boolean isSame2 = singletonUpdated3 == singletonUpdated4;
//        System.out.println("Is Singleton??" + isSame2);
//
//        SingletonUpdated singletonUpdated5 = SingletonUpdated.getLazyStaticCLassInstance();
//        SingletonUpdated singletonUpdated6 = SingletonUpdated.getLazyStaticCLassInstance();
//        boolean isSame3 = singletonUpdated5 == singletonUpdated6;
//        System.out.println("Is Singleton??" + isSame3);

//        SingletonUpdated singletonUpdated7 = SingletonUpdated.getThreadSafeInstance();
//        SingletonUpdated singletonUpdated8 = SingletonUpdated.getThreadSafeInstance();
//        Runnable run1 = SingletonUpdated::getThreadSafeInstance;
        Runnable run1 = SingletonUpdated::getThreadSafeInstance2;

        Thread t1 = new Thread(run1, "Thread1");
        Thread t2 = new Thread(run1, "Thread2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        boolean isSame4 = singletonUpdated7 == singletonUpdated8;
//        System.out.println("Is Singleton??" + isSame4);
        SingletonEnum singletonUpdated9 = SingletonEnum.INSTANCE;
        SingletonEnum singletonUpdated10 = SingletonEnum.INSTANCE;
        boolean isSame5 = singletonUpdated9 == singletonUpdated10;
        System.out.println("Is Singleton??" + isSame5);
    }

    enum SingletonEnum{
        INSTANCE;
    }
}