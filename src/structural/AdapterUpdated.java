package structural;

// Y? To make incompatible interfaces/classes work together (eg: legacy to new)
public class AdapterUpdated {
    public static void main(String[] args) {
        DocumentCreator documentCreator = new AdvDocumentCreator();
        System.out.println("O/p--"+documentCreator.createDoc());
        documentCreator = new LegacyDocumentAdapter();
        System.out.println("O/p with legacy--"+documentCreator.createDoc());
    }
}

class AdvDocumentCreator implements DocumentCreator{

    @Override
    public String createDoc() {
        return "Advanced Document created";
    }
}

class LegacyDocumentAdapter implements  DocumentCreator{
    private LegacyDocumentCreator legacyDocumentCreator;
    public LegacyDocumentAdapter(){
        this.legacyDocumentCreator = new LegacyDocumentCreator();
    }
    @Override
    public String createDoc() {
        return legacyDocumentCreator.createLegacyDocument();
    }
}
interface DocumentCreator{
    String createDoc();
}

class LegacyDocumentCreator{
    public String createLegacyDocument(){
        return "Legacy document created";
    }
}
