import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lewin on 2/1/15.
 */
public class CreatDom4jAndSave {
    public void CreatDomAndSave(String Link) throws IOException {
        //链接国内新闻并得到ep-h1的数据
        Document document = Jsoup.connect(Link).get();
        Elements Ele = document.getElementsByClass("ep-h1");
        Elements elements = document.getElementsByClass("ep-time-soure");
        //创建dom树以及根
        org.dom4j.Document dom4jDocument = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement("root");
        //在根下创建title标签并写入数据
        Element domtitle = root.addElement("title");
        String newTitle = Ele.text();
        domtitle.setText(newTitle);
        //在根下创建url标签并写入数据
        Element domUrl = root.addElement("url");
        domUrl.setText(Link);
        //在根下创建date标签并写入数据
        Element domDate = root.addElement("date");
        String newtemp = elements.text();
        String newDate = newtemp.substring(0,20);
        domDate.setText(newDate);
        //获取新闻来源 在根下创建forward标签 并写入数据
        Element domForward = root.addElement("forward");
        org.jsoup.nodes.Element jsoupnewForward = document.getElementById("ne_article_source");
        String newForward = jsoupnewForward.text();
        domForward.setText(newDate);
        //获取新闻  在根下创建forward标签  并写入数据
        Element domContent = root.addElement("content");
        org.jsoup.nodes.Element jsoupnew = document.getElementById("endText");
        String newContent = jsoupnew.text();
        domContent.setText(newContent);
        //获取新闻图片 有则在content下创建img src标签 赋值
        Elements newimg = jsoupnew.select("img[src]");
        String newContentImg = newimg.attr("abs:src");
        if (newContentImg.contains("jpg"))  {
            Element contentImg = domContent.addElement("img src");
            contentImg.addAttribute("img src",newContentImg);
        }
        //将dom写入到控制台
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.write(dom4jDocument);
        //将dom写入文件中
        OutputFormat format = new OutputFormat("    ",true);
        XMLWriter xmlWriter12 = new XMLWriter(new FileOutputStream(newDate),format);
        xmlWriter12.write(dom4jDocument);

    }
}
