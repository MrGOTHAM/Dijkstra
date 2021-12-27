package RealProject;

import RealProject.beans.Business;
import RealProject.beans.Node;
import RealProject.constant.ConstantUrl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ancg
 * @Description: 录入节点信息, 链路信息， 业务信息
 * @date 2021/12/2715:44
 */
public class DataRetrieve {
    private Scanner mInputStream;
    private String mLine;
    private final String mRegex = "\t";

    /**
     * 路径带宽邻接矩阵， 路径花费邻接矩阵，
     * 节点，          业务
     */
    private int[][] mLinkBandwidth;
    private int[][] mLinkPrice;
    private ArrayList<Node> mNodes;
    private ArrayList<Business> mBusinesses;

    public DataRetrieve() throws FileNotFoundException {
        initNodeData();
        initMatrices();
        initLinkData();
        initBusinessData();

    }

    private void initMatrices() {
        int n = mNodes.size();
        int maxValue = Integer.MAX_VALUE;
        mLinkBandwidth = new int[n][n];
        mLinkPrice = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mLinkBandwidth[i][j] = maxValue;
                mLinkPrice[i][j] = maxValue;
            }
        }
    }

    private void initNodeData() throws FileNotFoundException {
        mNodes = new ArrayList<>();
        mInputStream = new Scanner(new FileInputStream(ConstantUrl.NODE_FILE_PATH), ConstantUrl.CHARSET);
        // 这一行是中文，不需要记录
        mInputStream.nextLine();
        while (mInputStream.hasNext()) {
            mLine = mInputStream.nextLine();
            // 切割字符串 便于存数据
            String[] s = mLine.split(mRegex);
            Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            mNodes.add(node);
            System.out.println();
        }
        mInputStream.close();
    }

    private void initLinkData() throws FileNotFoundException {
        mInputStream = new Scanner(new FileInputStream(ConstantUrl.LINK_FILE_PATH), ConstantUrl.CHARSET);
        mInputStream.nextLine();
        while (mInputStream.hasNext()) {
            mLine = mInputStream.nextLine();
            String[] s = mLine.split(mRegex);
            mLinkPrice[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Integer.parseInt(s[3]);
            mLinkBandwidth[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Integer.parseInt(s[2]);
        }
        mInputStream.close();
        for (int i = 0; i < mNodes.size(); i++) {
            for (int j = 0; j < mNodes.size(); j++) {
                System.out.print("    带宽：：" + mLinkBandwidth[i][j] + "  代价" + mLinkPrice[i][j]);
                if (j == mNodes.size() - 1) {
                    System.out.println();
                }
            }
        }
    }

    private void initBusinessData() throws FileNotFoundException {
        mBusinesses = new ArrayList<>();
        mInputStream = new Scanner(new FileInputStream(ConstantUrl.BUSINESS_FILE_PATH), ConstantUrl.CHARSET);
        mInputStream.nextLine();
        while (mInputStream.hasNext()) {
            mLine = mInputStream.nextLine();
            String[] s = mLine.split(mRegex);
            Business business = new Business(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
            mBusinesses.add(business);
        }
        mInputStream.close();
    }

    public int[][] getLinkBandwidth() {
        return mLinkBandwidth;
    }

    public int[][] getLinkPrice() {
        return mLinkPrice;
    }

    public ArrayList<Node> getNodes() {
        return mNodes;
    }

    public ArrayList<Business> getBusinesses() {
        return mBusinesses;
    }
}
