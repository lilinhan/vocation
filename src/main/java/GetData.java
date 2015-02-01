import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by lewin on 2/1/15.
 */
public class GetData {
    public static void main(String[] args)throws IOException {
        Document doc = Jsoup.connect("http://news.163.com/domestic/").get();
        Elements allNewUrl = doc.select("h2");
        CreatDom4jAndSave creatDom4jAndSave = new CreatDom4jAndSave();
        for(Element s : allNewUrl)  {
            Elements oneNewUrl = s.select("a[href]");
            String link = oneNewUrl.attr("href");
            if (link.contains("news") && link.contains("#")) {
                creatDom4jAndSave.CreatDomAndSave(link);
            }
        }
    }

}
