package creational;

public class CreationalUpdated {
    public static void main(String[] args) {
        WorkflowRequest workflowRequest = new WorkflowRequest.WorkflowRequestBuilder("abc","axb")
                .setWfTaskType("Bus").build();
        System.out.println("Wf request---"+workflowRequest);
    }
}
// Y? When object include many fields with optional fields as well
class WorkflowRequest{
    private String wfType;
    private String wfBusiness;
    private String wfTasktype;
    private float wfVersion;

    public String toString(){
        return this.wfType + " " +this.wfVersion + " "+this.wfBusiness +" "+this.wfTasktype;
    }
    private WorkflowRequest(WorkflowRequestBuilder builder){
        this.wfTasktype = builder.wfTasktype;
        this.wfType = builder.wfType;
        this.wfBusiness = builder.wfBusiness;
        this.wfVersion = builder.wfVersion;
    }

    static class WorkflowRequestBuilder{
        private String wfType;
        private String wfBusiness;
        private String wfTasktype;
        private float wfVersion;

        public WorkflowRequestBuilder(String wfBusiness, String wfType){
            this.wfBusiness = wfBusiness;
            this.wfType = wfType;
        }
        public WorkflowRequestBuilder setWfTaskType(String taskType){
            this.wfTasktype = taskType;
            return this;
        }
        public WorkflowRequestBuilder setWfVersion(float wfVersion){
            this.wfVersion = wfVersion;
            return this;
        }

        public WorkflowRequest build(){
            return new WorkflowRequest(this);
        }

    }
}

