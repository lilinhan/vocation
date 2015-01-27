import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by lewin on 1/21/15.
 */
public class FirstStep {
    public static void main(String[] args)throws IOException{
            Document doc = Jsoup.connect("http://news.163.com/domestic/").get();
            getUrlAndKeeo Get = new getUrlAndKeeo();
            Elements str = doc.select("h2");
            for(Element s : str) {
                Elements a = s.select("a[href]");
                String link = a.attr("href");
                if (link.contains("news") && link.contains("#")) {
                    Get.GetKeep(link);
                }
            }
        System.out.println("Done");
    }
}
