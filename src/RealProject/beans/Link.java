package RealProject.beans;

/**
 * @author ancg
 * @Description:链路
 * @date 2021/12/2716:30
 */
public class Link {
    private final int mSourceNodeId;
    private final int mSinkNodeId;
    private final int mBandwidth;
    private final int mPrice;

    public Link(int sourceNodeId , int sinkNodeId, int bandwidth, int price){
        mBandwidth = bandwidth;
        mPrice = price;
        mSinkNodeId =sinkNodeId;
        mSourceNodeId = sourceNodeId;
    }
}
