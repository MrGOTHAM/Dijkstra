package RealProject.beans;

/**
 * @author ancg
 * @Description: 业务
 * @date 2021/12/2716:34
 */
public class Business {
    private final int mBusinessId;
    private final int mSourceNodeId;
    private final int mBusinessSinkNodeId;
    private final int mBandwidthNeeded;

    public Business(int businessId, int sourceNodeId, int businessSinkNodeId, int bandwidthNeeded){
        mBandwidthNeeded = bandwidthNeeded;
        mBusinessId = businessId;
        mSourceNodeId = sourceNodeId;
        mBusinessSinkNodeId = businessSinkNodeId;
    }


}
