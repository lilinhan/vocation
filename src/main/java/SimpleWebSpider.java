import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.lang.model.element.Element;

/**
 * Created by lewin on 1/15/15.
 */
public class SimpleWebSpider {
    public static void main(String[] s) {
        try {
            Document doc = Jsoup.connect("http://news.163.com/smart/0/3/3014/1.html").get();
//            Elements str = doc.getElementsByClass("header-info");
//            String ss = str.text();
//            System.out.println(ss);
            Elements str = doc.getElementsByClass("header-digest");
            for(org.jsoup.nodes.Element tag : str)  {
                System.out.println(tag.text());
            }
//            String ss = str.text();
//            System.out.println(ss);
        }catch (Exception e)  {
            e.printStackTrace();
        }
    }
}
