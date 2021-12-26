import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author ancg
 * @Description:
 * @date 2021/12/208:56
 */
public class Main {
    public static void main(String[] args) {
        PriorityQueue<GraphPoint> pq = new PriorityQueue<>();
//        pq.removeIf(graphPoint -> Objects.equals(graphPoint.getName(), "a"));
        // 邻接矩阵部分
        Matrices matrices = new Matrices();
        matrices.inputEdge();

        PointPathAndExtent pE = new PointPathAndExtent();
        // 源点从a开始 找
    }

}
