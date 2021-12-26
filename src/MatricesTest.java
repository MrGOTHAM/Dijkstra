import java.util.Scanner;

/**
 * @author ancg
 * @Description:
 * @date 2021/12/2616:30
 */
public class MatricesTest {
    public int[][] mMatrices;
    private int mPointNum;
    private final Scanner mScanner = new Scanner(System.in);

    public MatricesTest() {
        initMatrices();
    }

    public void inputEdge() {
        System.out.println("请输入边个数：");
        int edgeNum = mScanner.nextInt();
        // 输入各节点之间路径长度
        for (int i = 0; i < edgeNum; i++) {
            System.out.println("输入行坐标（箭头尾）：");
            int x = mScanner.nextInt();
            System.out.println("输入列坐标（箭头）：");
            int y = mScanner.nextInt();
            System.out.println("输入路径长度：");
            int value = mScanner.nextInt();
            mMatrices[x][y] = value;
        }
        System.out.println("边录入完成" + "*********************");
        printPoint();
    }

    private void printPoint() {
        for (int i = 0; i < mPointNum; i++) {
            for (int j = 0; j < mPointNum; j++) {
                System.out.print("   " + mMatrices[i][j]);
                if (j == 9) {
                    System.out.println();
                }
            }
        }
    }

    private void initMatrices() {
        System.out.println("请输入节点个数：");
        mPointNum = mScanner.nextInt();
        mMatrices = new int[mPointNum][mPointNum];
        // 初始化数组
        for (int i = 0; i < mPointNum; i++) {
            for (int j = 0; j < mPointNum; j++) {
                int MAX_VALUE = Integer.MAX_VALUE;
                mMatrices[i][j] = MAX_VALUE;
            }
        }
        printPoint();
    }



}
