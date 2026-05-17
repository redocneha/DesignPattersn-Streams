package structural;

public class ProxyDecoratorExample {
    public static void main(String[] args) {
        IDocument document = new DocumentProxy();
        System.out.println("Doc type"+ document.getType());
    }

}
interface IDocument{
    String getType();
}

class ConfidentialDocument implements IDocument{

    @Override
    public String getType() {
        return "Confidential document";
    }
}

class DocumentProxy implements IDocument{
    ConfidentialDocument confidentialDocument;
    public DocumentProxy(){
    }
    @Override
    public String getType() {
        if(this.confidentialDocument == null){
            this.confidentialDocument = new ConfidentialDocument();
        }
        return confidentialDocument.getType();
    }
}