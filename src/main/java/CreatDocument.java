import java.io.File;

/**
 * Created by lewin on 1/14/15.
 */
public class CreatDocument {
    public static void main(String[] s)  {
        String FileName = "./" + File.separator + "hello";
        File f = new File(FileName);
        f.mkdir();
    }
}
