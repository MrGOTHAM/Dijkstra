import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author ancg
 * @Description:
 * @date 2021/12/208:56
 */
public class Main {
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] weight = {
                {0, 10, MAX_VALUE, 30, 100},
                {MAX_VALUE, 0, 50, MAX_VALUE, MAX_VALUE},
                {MAX_VALUE, MAX_VALUE, 0, MAX_VALUE, 10},
                {MAX_VALUE, MAX_VALUE, 20, 0, 60},
                {MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, 0}
        };
        PointPathAndExtent.point.add("a");
        PointPathAndExtent.point.add("b");
        PointPathAndExtent.point.add("c");
        PointPathAndExtent.point.add("d");
        PointPathAndExtent.point.add("e");

        dijkstra(weight, "a");
        for (int i = 0; i < PointPathAndExtent.mExtent.size(); i++) {
            System.out.println(PointPathAndExtent.mExtent.get(i).getName() + "  " + PointPathAndExtent.mExtent.get(i).getDistance());
        }
        for (int i = 0; i < PointPathAndExtent.mExtent.size(); i++) {
            System.out.println(PointPathAndExtent.mExtent.get(i).getPath());
        }

    }

    public static void dijkstra(int[][] weight, String startName) {
        int startIndex = PointPathAndExtent.point.indexOf(startName);
        PriorityQueue<GraphPoint> pq = new PriorityQueue<>();

        // 初始化第一个节点
        PointPathAndExtent.mExtent.add(new GraphPoint(startName, 0, "0--->0"));
        PointPathAndExtent.visited[startIndex] = 1;

        // 首次加路径
        for (int i = 0; i < weight.length; i++) {
            if (PointPathAndExtent.visited[i] == 0) {
                pq.add(new GraphPoint(PointPathAndExtent.point.get(i).toString(), weight[startIndex][i], "0--->" + i));
            }
        }
            for (int count = 0; count < weight.length - 1; count++) {
                // 选出了除源点以外最短的一个点

                GraphPoint shortest = pq.peek();
                String shortestName = Objects.requireNonNull(shortest).getName();
                int shortestDistance = shortest.getDistance();
                int shortestIndex = PointPathAndExtent.point.indexOf(shortestName);
                String shortestPath = shortest.getPath();
                // 将点加入最终结果 标记已求出 在优先队列中删除
                PointPathAndExtent.mExtent.add(shortest);
                PointPathAndExtent.visited[shortestIndex] = 1;
                pq.removeIf(graphPoint -> Objects.equals(graphPoint.getName(), shortestName));

                for (int j = 0; j < weight.length; j++) {
                    if (PointPathAndExtent.visited[j] == 0){
                     pq.add(new GraphPoint(PointPathAndExtent.point.get(j).toString()
                             ,weight[shortestIndex][j]+shortestDistance
                             ,shortestPath+"---->"+j));
                    }
                }
            }
    }
}
