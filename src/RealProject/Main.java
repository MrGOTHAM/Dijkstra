package RealProject;

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
    public static void main(String[] args) throws FileNotFoundException {
        DataRetrieve dataRetrieve = new DataRetrieve();
        ArrayList<Node> nodes = dataRetrieve.getNodes();
//        ArrayList<Business> businesses = dataRetrieve.getBusinesses();
        int[][] linkBandwidth = dataRetrieve.getLinkBandwidth();
        int[][] linkPrice = dataRetrieve.getLinkPrice();

        int start = 0;
        ArrayList<Result> results = dijkstra(linkBandwidth, linkPrice, nodes, start);
        for (Result result : results) {
            System.out.println("从 " + start + " 到 " + result.getNodeId() + " 的最短路径为" + result.getShortPath() + " 花费:" + result.getTotalPrice());
        }
    }

    public static ArrayList<Result> dijkstra(int[][] bandwidth, int[][] price, ArrayList<Node> nodes, int start) {
        ArrayList<Result> results = new ArrayList<>();
        int[] visited = new int[nodes.size()];
        PriorityQueue<Result> pq = new PriorityQueue<>();

        // 初始化第一个节点
        results.add(new Result(start, nodes.get(start).getRegionId()
                , 0, 0, start + "---->" + start));
        visited[start] = 1;

        for (int i = 0; i < nodes.size(); i++) {
            if (visited[i] == 0){
                pq.add(new Result(nodes.get(i).getNodeId(),nodes.get(i).getRegionId()
                        , price[start][i],bandwidth[start][i],start+"----->"+nodes.get(i).getNodeId()));
            }
        }
        for (int count = 0; count < nodes.size() - 1; count++) {
            Result result = pq.peek();
            String shortPath = Objects.requireNonNull(result).getShortPath();
            int totalPrice = result.getTotalPrice();
            int totalBandwidth = result.getTotalBandwidth();
            // 默认nodeId是从0开始，而且无间隙
            int shortPointIndex = result.getNodeId();
            results.add(result);
            visited[shortPointIndex] = 1;
            pq.removeIf(result1 ->Objects.equals(result1.getNodeId(), shortPointIndex) );

            for (int j = 0; j < nodes.size(); j++) {
                if (visited[j] == 0){
                    pq.add(new Result(nodes.get(j).getNodeId(),nodes.get(j).getRegionId()
                            ,price[shortPointIndex][j]+totalPrice,totalBandwidth+bandwidth[shortPointIndex][j],shortPath + "----->"+nodes.get(j).getNodeId()));
                }
            }
        }
        return results;
    }
}
