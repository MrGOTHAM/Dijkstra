/**
 * @author ancg
 * @Description: 算法实现之后再向里面加 其他属性
 * @date 2021/12/2614:36
 */
public class GraphPoint implements Comparable<GraphPoint>{
    private final String mName;
    private int mDistance;
    private String mPath;

    public String getPath() {
        return mPath;
    }

    public GraphPoint(String name, int distance, String path){
        mName = name;
        mDistance =distance;
        mPath = path;
    }

    public String getName() {
        return mName;
    }

    public int getDistance() {
        return mDistance;
    }

    public void setDistance(int mDistance) {
        this.mDistance = mDistance;
    }

    /**
     * 优先队列排序所需实现的接口
     * @param o
     * @return
     */
    @Override
    public int compareTo(GraphPoint o) {
        return this.mDistance - o.getDistance();
    }
}

