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
        String filePathPoint = "D:\\csv\\节点.csv";
        String filePathRoad = "D:\\csv\\链路.csv";
        String filePathBusiness = "D:\\csv\\业务.csv";
        Scanner inputStreamRoad, inputStreamPoint, inputStreamBusiness;

        try {
            inputStreamRoad = new Scanner(new FileInputStream(filePathRoad), "GBK");
            inputStreamBusiness = new Scanner(new FileInputStream(filePathBusiness), "GBK");
            inputStreamPoint = new Scanner(new FileInputStream(filePathPoint), "GBK");
            String line;
            while (inputStreamRoad.hasNext()) {
                line = inputStreamRoad.nextLine();
                System.out.println(line);
            }
            inputStreamRoad.close();
            while (inputStreamBusiness.hasNext()){
                line = inputStreamBusiness.nextLine();
                System.out.println(line);
            }
            inputStreamBusiness.close();
            while (inputStreamPoint.hasNext()){
                line = inputStreamPoint.nextLine();
                System.out.println(line);
            }
            inputStreamPoint.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File is not found");
        }
    }
}
