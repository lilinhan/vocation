import java.io.File;

/**
 * Created by lewin on 1/14/15.
 */
public class creatfile {
    public static void main(String[] s)  {
        String FileName = "./" + File.separator + "hello.txt";
        File f = new File(FileName);
        try  {
            f.createNewFile();
        }catch (Exception e)  {
            e.printStackTrace();
        }
    }
}
