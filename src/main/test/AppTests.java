import scala.tools.scalap.Classfile;
import sun.nio.cs.UTF_32;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by Kerven-HAN on 2019/10/23 10:31.
 * Talk is cheap , show me the code
 */
public class AppTests {
    public static void main(String[] args) {


        try {
            System.out.println(readFileAsString("C:\\Users\\Administrator\\Desktop\\spark.txt", null));
//            System.out.println(readFileAsString("C:\\Users\\Administrator\\Desktop\\spark.txt",null);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int toPositive(int number) {
        return number & 0x7fffffff;
    }

    public static int longHashcode(long value) {
        return (int) (value ^ (value >>> 32));
    }


    public static String readFileAsString(String path, Charset charset) throws IOException {
        if (charset == null) charset = Charset.defaultCharset();

        try (FileInputStream stream = new FileInputStream(new File(path))) {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            return charset.decode(bb).toString();
        }

    }



}
