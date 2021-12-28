package RealProject.beans;

/**
 * @author ancg
 * @Description:
 * @date 2021/12/2810:26
 */
public class Result implements Comparable<Result>{
    private final int mNodeId;
    private final int mRegionId;
    private final int mTotalPrice;
    private final int mTotalBandwidth;
    private String mShortPath;

    public Result(int nodeId, int regionId, int totalPrice, int totalBandwidth, String shortPath){
        mNodeId = nodeId;
        mTotalBandwidth = totalBandwidth;
        mTotalPrice = totalPrice;
        mRegionId = regionId;
        mShortPath =shortPath;
    }

    public int getNodeId() {
        return mNodeId;
    }

    public int getRegionId() {
        return mRegionId;
    }

    public int getTotalPrice() {
        return mTotalPrice;
    }

    public int getTotalBandwidth() {
        return mTotalBandwidth;
    }

    public String getShortPath() {
        return mShortPath;
    }

    public void setShortPath(String shortPath) {
        this.mShortPath = shortPath;
    }

    @Override
    public int compareTo(Result o) {
        return this.mTotalPrice -o.getTotalPrice();
    }
}
