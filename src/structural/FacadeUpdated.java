package structural;
// Y? Simplified unified interface to complex logic
public class FacadeUpdated {
    public static void main(String[] args) {
        Document document = new DocumentService().createDocument();
        System.out.println("Document created --"+document.type);
    }
}

class DocumentService{
    Document createDocument(){
        initiateWf();
         Document document = createDoc();
        updateAudit();
        return  document;
    }

    private void initiateWf() {
    }

    private void updateAudit() {
    }

    private Document createDoc() {
        return new Document("Colt");
    }

}

class Document{
    String type;
    public Document(String type){
        this.type = type;
    }
}