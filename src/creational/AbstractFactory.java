package creational;

//factory of factories for dependent or related objs
public class AbstractFactory {
    public static void main(String[] args) {
        var uiFactory = UIFactory.getFactory("mac");
        uiFactory.getButton().paint();
        uiFactory = UIFactory.getFactory("win");
        uiFactory.getButton().paint();
    }
}


class UIFactory{
    public static OSType getFactory(String type){
        if(type.equalsIgnoreCase("mac"))
            return new MacUIFactory();
        return new WinUIFactory();
    }
}
interface OSType{
    public Button getButton();
}

interface Button{
    public void paint();
}

class MacButton implements Button{

    @Override
    public void paint() {
        System.out.println("Inside MAcbutton paint");
    }
}


class WinButton implements Button{

    @Override
    public void paint() {
        System.out.println("Inside Winbutton paint");
    }
}

class MacUIFactory implements OSType{
    @Override
    public Button getButton() {
        return new MacButton();
    }
}

class WinUIFactory implements OSType{
    @Override
    public Button getButton() {
        return new MacButton();
    }
}