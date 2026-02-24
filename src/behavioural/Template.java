package behavioural;

public class Template {
    public static void main(String[] args) {
        GameTemplate cricketGame = new Cricket();
        cricketGame.play();
        GameTemplate baseBallGame = new Baseball();
        baseBallGame.play();
    }
}


abstract class GameTemplate{
    abstract void init();
    abstract void startPlay();
    abstract void endPlay();

    public void play(){
        init();
        startPlay();
        endPlay();
    }
}

class Cricket extends GameTemplate{

    @Override
    void init() {
        System.out.println("Cricket init");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket started");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket ended");
    }
}

class Baseball extends GameTemplate{

    @Override
    void init() {
        System.out.println("Baseball init");
    }

    @Override
    void startPlay() {
        System.out.println("Baseball started");
    }

    @Override
    void endPlay() {
        System.out.println("Baseball ended");
    }
}