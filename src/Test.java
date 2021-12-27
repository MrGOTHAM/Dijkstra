import javafx.scene.shape.Path;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author ancg
 * @Description:
 * @date 2021/12/2711:11
 */
public class Test {

    public static void main(String[] args) {
       Scanner inputStream = null;
       try {
           inputStream = new Scanner(new FileInputStream("D:\\csv\\节点.csv"), String.valueOf(StandardCharsets.UTF_8));
       } catch (FileNotFoundException e) {
           e.printStackTrace();
           System.out.println("File is not found");
       }
        for (int i = 0; i < 10; i++) {
            System.out.println(inputStream.nextLine());
        }

        inputStream.close();
    }
}
