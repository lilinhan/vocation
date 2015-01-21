import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * Created by lewin on 1/15/15.
 */
public class SimpleWebSpider {
    public static void main(String[] s) {
        try {
            Document doc = Jsoup.connect("http://news.163.com/15/0121/08/AGFJIEVV00014JB6.html").get();
//            Elements str = doc.getElementsByClass("header-info");
//            String ss = str.text();
//            System.out.println(ss);
//            Elements str = doc.getElementsByClass("item-digest");
//            for(org.jsoup.nodes.Element tag : str)  {
//                System.out.println(tag.text());
//            }
//            String ss = str.text();
//            System.out.println(ss);
//            org.jsoup.nodes.Element ele = doc.getElementById("endText");
//            String str = ele.text();
//            System.out.println(str);
            //图片网址
//            org.jsoup.nodes.Element ele = doc.getElementById("endText");
//            Elements eles = ele.select("img[src]");
//            String imgUrl = eles.attr("abs:src");
//            if(imgUrl.contains("jpg"))
//                System.out.println(imgUrl);
//
//            Elements str = doc.getElementsByClass("ep-time-soure");
//            String ss = str.text();
//            String newData = ss.substring(0,ss.indexOf(" "));
//            System.out.print(newData);
//            System.out.println("aaaa");
//              标题
//            Element str = doc.getElementById("h1title");
//            String ss = str.text();
//            System.out.println(ss);
            //文本
            org.jsoup.nodes.Element E = doc.getElementById("endText");
            String st = E.text();
            System.out.println(st);
        }catch (Exception e)  {
            e.printStackTrace();
        }
    }
}
