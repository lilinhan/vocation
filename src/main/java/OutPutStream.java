import java.io.*;
import java.io.IOException;

/**
 * Created by lewin on 1/14/15.
 */
public class OutPutStream {
    public static void main(String[] s) throws IOException  {
        String filename = "./" + File.separator + "hello.txt";
        File f = new File(filename);
        OutPutStream out = new FileOutPutStream(f);

    }
}
