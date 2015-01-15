import java.io.File;

/**
 * Created by lewin on 1/14/15.
 */
public class ListFiles {
    public static void main(String[] s)  {
        String FileName = "./" + File.separator;
        File f = new File(FileName);
        File[] str = f.listFiles();
        for(int i = 0 ; i < str.length ; i++ )  {
            System.out.println(str[i]);
        }
    }
}
