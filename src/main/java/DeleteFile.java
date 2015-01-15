import java.io.File;

/**
 * Created by lewin on 1/14/15.
 */
public class DeleteFile {
    public static void main(String[] s)  {
        String FileName = "./" + File.separator + "hello.txt";
        File f = new File(FileName);
        if(f.exists())  {
            f.delete();
        }
        else   {
            System.out.println("文件不存在");
        }
    }
}
