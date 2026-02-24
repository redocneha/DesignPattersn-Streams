package behavioural;
// behavioural patterns are about how objects interact each others and loosely coupled

// helps to iterate objects of a particular ds without knowing its undelrying impl
// great example is Collection interface , where iterate func(returns iterator))of it is used by all impl ds
// Iterator is interface and impls include ListIterator, etc.. based on Datastructure thats impl collection
public class Iterator {
    public static void main(String[] args) {

    }
}

interface IteratorInt{
    public void iterate();
}