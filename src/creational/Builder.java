package creational;

//build complex obj s step wise , removes need to pass values at once to create obj, destrcutured way to create obj for more readability. non mandatory params can be ignored while building
//to create custom response object

public class Builder {
    public static void main(String[] args) {
        PhoneBuilder phoneBuilder = new PhoneBuilder();
        Phone phone = phoneBuilder.companyName("Apple").memory(128).modelName("15 Pro").osType("ios").build();
        System.out.println(phone.toString());
    }
}


class Phone{
    private  final String osType;
    private final  int memory;
    private final String color;
    private final String companyName;
    private final String modelName;

    public Phone(PhoneBuilder phoneBuilder){
        this.osType = phoneBuilder.getOsType();
        this.memory = phoneBuilder.getMemory();
        this.color = phoneBuilder.getColor();
        this.modelName = phoneBuilder.getModelName();
        this.companyName = phoneBuilder.getCompanyName();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "osType='" + osType + '\'' +
                ", memory=" + memory +
                ", color='" + color + '\'' +
                ", companyName='" + companyName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}

class PhoneBuilder {
    private  String osType;
    private  int memory;
    private  String color;
    private  String companyName;
    private  String modelName;

    public String getOsType() {
        return osType;
    }

    public int getMemory() {
        return memory;
    }

    public String getColor() {
        return color;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public PhoneBuilder memory(int memory) {
        this.memory = memory;
        return this;
    }

    public PhoneBuilder osType(String osType) {
        this.osType = osType;
        return this;
    }

    public PhoneBuilder color(String color) {
        this.color = color;
        return this;
    }

    public PhoneBuilder companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public PhoneBuilder modelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Phone build() {
        return new Phone(this);
    }
}