package creational;

// Y? When we need to create objects without exposing the exact object creation logic to the client.
public class FactoryUpdated {
    // Lets say if client needs to create Captis Document initially then
    // Document doc = new CaptisDocument();
    // this violates OPen/close principle and loose coupling, instead it should be extensible
    // So we use factory class to deal with object creation and its centralised
    // if not this way, we end up adding if else condition checks within client code to create objects accordingly
    public static Document getDocument(DocumentType type){
        return switch (type){
            case CAPTIS:
                yield new CaptisDocument();
            case COLT:
                yield new ColtDocument();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        };
    }

}
enum DocumentType{
    CAPTIS,
    COLT;
}
class Solution2{
    public static void main(String[] args) {
        Document document = FactoryUpdated.getDocument(DocumentType.COLT);
        System.out.println("Document created ---"+document);
    }
}

interface Document{
    String getType();
}

class CaptisDocument implements  Document{

    @Override
    public String getType() {
        return "Captis";
    }
}

class ColtDocument implements  Document{

    @Override
    public String getType() {
        return "Colt";
    }
}