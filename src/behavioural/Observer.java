package behavioural;

import java.util.ArrayList;
import java.util.List;

//enables subscriber to register with provider and also receive notifications when provider updates
//2 entities Publisher/Observable and Subscriber/Observer
// publisher maintains observer's list and notifies them when its statte changes
public class Observer {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        newsAgency.addChannel(new Channel1());
        newsAgency.addChannel(new Channel2());
        newsAgency.updateChannels("Hey we got updated news!!");
    }
}

interface Channel{
    public void update(String newData);
}

class NewsAgency{
    List<Channel> channelList = new ArrayList<>();
    public void addChannel(Channel channel){
        channelList.add(channel);
    }
    public void updateChannels(String newsUpdated){
        channelList.forEach((channel)->channel.update(newsUpdated));
    }
}
class Channel1 implements Channel{
    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void update(String newData) {
        this.setNews(newData);
        show();
    }

    public void show(){
        System.out.println("News updated"+news);
    }
}

class Channel2 implements Channel{
    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void update(String newData) {
        this.setNews(newData);
        show();
    }

    public void show(){
        System.out.println("News updated by neha"+news);
    }
}