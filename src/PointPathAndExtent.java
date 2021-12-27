import java.util.ArrayList;

/**
 * @author ancg
 * @Description: 点的路径和 最短长度
 * @date 2021/12/2615:49
 */
public class PointPathAndExtent {
    public StringBuffer[] mPath;
    public static ArrayList<GraphPoint> mExtent = new ArrayList<>();
    public static ArrayList point = new ArrayList();
    public static int[] visited = new int[5];

    public PointPathAndExtent() {
        initPath();
    }

    private void initPath() {
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        StringBuffer c = new StringBuffer();
        StringBuffer d = new StringBuffer();
        StringBuffer e = new StringBuffer();
        StringBuffer f = new StringBuffer();
        StringBuffer g = new StringBuffer();
        StringBuffer h = new StringBuffer();
        StringBuffer i = new StringBuffer();
        StringBuffer j = new StringBuffer();

        mPath = new StringBuffer[10];
        mPath[0] = a;
        mPath[1] = b;
        mPath[2] = c;
        mPath[3] = d;
        mPath[4] = e;
        mPath[5] = f;
        mPath[6] = g;
        mPath[7] = h;
        mPath[8] = i;
        mPath[9] = j;
    }}
