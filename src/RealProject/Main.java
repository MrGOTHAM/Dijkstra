package RealProject;

import RealProject.beans.Business;
import RealProject.beans.Node;
import RealProject.beans.Result;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author ancg
 * @Description:
 * @date 2021/12/2715:44
 */
public class Main {
    private static boolean mFind = false;

    public static void main(String[] args) throws FileNotFoundException {
        DataRetrieve dataRetrieve = new DataRetrieve();
        ArrayList<Node> nodes = dataRetrieve.getNodes();
        ArrayList<Business> businesses = dataRetrieve.getBusinesses();
        int[][] linkBandwidth = dataRetrieve.getLinkBandwidth();
        int[][] linkPrice = dataRetrieve.getLinkPrice();

        for (Business business : businesses) {
            int start = business.getSourceNodeId();
            int end = business.getBusinessSinkNodeId();
            boolean startTag = false;
            boolean endTag = false;

            // 判断源节点和宿节点是否存在于节点中。
            for (Node node : nodes) {
                if (start == node.getNodeId()) {
                    startTag = true;
                }
                if (end == node.getNodeId()) {
                    endTag = true;
                }
            }

            if (!startTag || !endTag){
                System.out.println("业务ID:" + business.getBusinessId() + " 部分点不存在！无法找到最短路径！");
                continue;
            }
            ArrayList<Result> results = dijkstra(linkBandwidth, linkPrice, nodes, start, end);
            if (mFind) {
                System.out.println("业务ID:" + business.getBusinessId() + " 已找到最短路径！");
                System.out.println("从 " + start + " 到 " + results.get(results.size() - 1).getNodeId() + " 的最短路径为" + results.get(results.size() - 1).getShortPath() + " 花费:" + results.get(results.size() - 1).getTotalPrice());
                mFind = false;
            } else {
                System.out.println("业务ID:" + business.getBusinessId() + " 未找到最短路径！");
            }
        }
    }

    public static ArrayList<Result> dijkstra(int[][] bandwidth, int[][] price, ArrayList<Node> nodes, int start, int end) {
        ArrayList<Result> results = new ArrayList<>();
        int[] visited = new int[nodes.size()];
        PriorityQueue<Result> pq = new PriorityQueue<>();

        // 初始化第一个节点 (如果不存在自己到自己的情况，可删除)
        results.add(new Result(start, nodes.get(start).getRegionId()
                , 0, 0, start + "---->" + start));
        visited[start] = 1;

        for (int count = 0; count < nodes.size(); count++) {
            int totalPrice = 0;
            int totalBandwidth = 0;
            String shortPath = start + "";
            int shortPointIndex = start;
            if (!pq.isEmpty()) {
                Result result = pq.peek();
                if (result.getTotalPrice() == Integer.MAX_VALUE){
                    break;
                }
                results.add(result);
                if (result.getNodeId() == end) {
                    mFind = true;
                    break;
                }

                shortPath = Objects.requireNonNull(result).getShortPath();
                totalPrice = result.getTotalPrice();
                totalBandwidth = result.getTotalBandwidth();
                // 默认nodeId是从0开始，而且无间隙
                int delIndex = result.getNodeId();
                shortPointIndex = result.getNodeId();
                visited[shortPointIndex] = 1;
                pq.removeIf(result1 -> Objects.equals(result1.getNodeId(), delIndex));
            }

            for (int j = 0; j < nodes.size(); j++) {
                if (visited[j] == 0) {
                    pq.add(new Result(nodes.get(j).getNodeId(), nodes.get(j).getRegionId()
                            , price[shortPointIndex][j] + totalPrice, totalBandwidth + bandwidth[shortPointIndex][j], shortPath + "----->" + nodes.get(j).getNodeId()));
                }
            }
        }
        return results;
    }
}
