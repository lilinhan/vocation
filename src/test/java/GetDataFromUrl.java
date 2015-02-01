import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by lewin on 1/31/15.
 */
public class GetDataFromUrl {
    public void GetKeep(String Tittle)  {
        try{
            Document doc = Jsoup.connect(Tittle).get();
            Elements str = doc.getElementsByClass("ep-time-soure");
            String newtemp = str.text();
            //String newData = newtemp.substring(0,newtemp.indexOf(" "));
            // String FileName = "./data" + File.separator + newData;
            String FileName = "./data" + File.separator + newtemp;
            File file = new File(FileName);
            file.createNewFile();
            OutputStream out = new FileOutputStream(file,true);
            Element title = doc.getElementById("h1title");
            String strInFile = title.text();
            byte [] bytes = strInFile.getBytes();

            try {
                out.write(bytes);
            }catch (Exception e)  {
                e.printStackTrace();
            }
            try {
                out.close();
            }catch (Exception e)  {
                e.printStackTrace();
            }
            out = new FileOutputStream(file,true);
            org.jsoup.nodes.Element Etext = doc.getElementById("endText");
            strInFile = Etext.text();
            bytes = strInFile.getBytes();

            try {
                out.write(bytes);
            }catch (Exception e)  {
                e.printStackTrace();
            }
            try {
                out.close();
            }catch (Exception e)  {
                e.printStackTrace();
            }
            out = new FileOutputStream(file,true);
            org.jsoup.nodes.Element Eimg = doc.getElementById("endText");
            Elements eles = Eimg.select("img[src]");
            String imgUrl = eles.attr("abs:src");
            if(imgUrl.contains("jpg"))  {
                bytes = imgUrl.getBytes();
                try {
                    out.write(bytes);
                }catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    out.close();
                }catch (Exception e)  {
                    e.printStackTrace();
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
