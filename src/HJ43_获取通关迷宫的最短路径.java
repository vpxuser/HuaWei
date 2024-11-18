import java.util.*;

/**
 * BFS 广度优先搜索算法
 */
public class HJ43_获取通关迷宫的最短路径 {

    public static boolean bfs(int[][] graph,int x,int y,boolean[][] visited,ArrayList<String> result){
        visited[x][y] = true;
        if (x==graph.length-1 && y==graph[x].length-1){
            result.add(String.format("(%d,%d)",x,y));
            return true;
        }
        if (x>0 && graph[x-1][y]==0 && !visited[x-1][y]){
            if (bfs(graph,x-1,y,visited,result)) {
                result.add(String.format("(%d,%d)",x,y));
                return true;
            }
        }
        if (x<graph.length-1 && graph[x+1][y]==0 && !visited[x+1][y]){
            if (bfs(graph,x+1,y,visited,result)) {
                result.add(String.format("(%d,%d)",x,y));
                return true;
            }
        }
        if (y>0 && graph[x][y-1]==0 && !visited[x][y-1]){
            if (bfs(graph,x,y-1,visited,result)) {
                result.add(String.format("(%d,%d)",x,y));
                return true;
            }
        }
        if (y<graph[x].length-1 && graph[x][y+1]==0 && !visited[x][y+1]){
            if (bfs(graph,x,y+1,visited,result)) {
                result.add(String.format("(%d,%d)",x,y));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String size = sc.nextLine();
            int length = Integer.parseInt(size.split(" ")[0]);
            int width = Integer.parseInt(size.split(" ")[1]);
            int[][] graph = new int[length][width];
            for (int x = 0; x < length; x++) {
                String input = sc.nextLine();
                for (int y = 0; y < width; y++) {
                    graph[x][y] = Integer.parseInt(input.split(" ")[y]);
                }
            }
            ArrayList<String> result = new ArrayList<>();
            bfs(graph,0,0,new boolean[length][width],result);
            for (int i = result.size()-1; i >=0; i--) {
                System.out.println(result.get(i));
            }
        }
    }
}