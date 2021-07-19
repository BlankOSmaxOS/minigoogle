package searchengine;


public class Hyperlink{
    private String link;
    private String title;
    private String text;


    public Hyperlink(String link, String title, String text) {
        this.link = link;
        this.title = title;
        this.text = text;
    }

    //public void TEST(String test, double v, boolean b) {}

    public String getLink() {
        return link;
    }
    public  String getTitle() {
        return title;
    }
    public String isText() {
        return text;
    }

}