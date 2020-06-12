// LUCY GARDNER GMB18183
import java.io.IOException;
import java.util.List;

public class GraphApp {

    private FileHandler fileHandler = new FileHandler();
    private List<RideData.Ride> rides;
    private static final int rideCount = 21;

    int[][] setUpGraph() throws IOException {

        fileHandler.getRidesFromFile();
        rides = fileHandler.getRides();

        int graph[][] = new int[][]{{0, 700, 0, 0, 0, 0, 1400, 0, 0, 0, 0, 1400, 0, 0, 0, 0, 700, 0, 0, 0, 0},
                {700, 0, 500, 500, 500, 500, 1000, 0, 0, 0, 0, 1000, 0, 0, 0, 0, 1000, 0, 0, 0, 0},
                {0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1400, 1000, 0, 0, 0, 0, 0, 500, 500, 500, 500, 1000, 0, 0, 0, 0, 1000, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1400, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 500, 500, 500, 1000, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {700,1000,0,0,0,0,1000,0,0,0,0,1000,0,0,0,0,0,500,500,500,500},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0}};

        dijkstra(graph);

        return graph;

        /*
        parkMap.addEdge(entrance,rideCount.get(0));
        parkMap.addEdge(entrance,rideCount.get(5));
        parkMap.addEdge(entrance,rideCount.get(10));
        parkMap.addEdge(entrance,rideCount.get(15));

        parkMap.addEdge(rideCount.get(0),rideCount.get(5));
        parkMap.addEdge(rideCount.get(0),rideCount.get(10));
        parkMap.addEdge(rideCount.get(0),rideCount.get(15));
        parkMap.addEdge(rideCount.get(0),rideCount.get(4));
        parkMap.addEdge(rideCount.get(0),rideCount.get(3));
        parkMap.addEdge(rideCount.get(0),rideCount.get(2));
        parkMap.addEdge(rideCount.get(0),rideCount.get(1));

        parkMap.addEdge(rideCount.get(5),rideCount.get(10));
        parkMap.addEdge(rideCount.get(5),rideCount.get(15));
        parkMap.addEdge(rideCount.get(5),rideCount.get(6));
        parkMap.addEdge(rideCount.get(5),rideCount.get(7));
        parkMap.addEdge(rideCount.get(5),rideCount.get(8));
        parkMap.addEdge(rideCount.get(5),rideCount.get(9));

        parkMap.addEdge(rideCount.get(10),rideCount.get(15));
        parkMap.addEdge(rideCount.get(10),rideCount.get(11));
        parkMap.addEdge(rideCount.get(10),rideCount.get(12));
        parkMap.addEdge(rideCount.get(10),rideCount.get(13));
        parkMap.addEdge(rideCount.get(10),rideCount.get(14));

        parkMap.addEdge(rideCount.get(15),rideCount.get(16));
        parkMap.addEdge(rideCount.get(15),rideCount.get(17));
        parkMap.addEdge(rideCount.get(15),rideCount.get(18));
        parkMap.addEdge(rideCount.get(15),rideCount.get(19));

        parkMap.printEdges();
        */
    }

    public static void main(String[] args) throws IOException {
        GraphApp graphapp = new GraphApp();
        graphapp.setUpGraph();
    }

    private int minDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int n = 0; n< rideCount; n++){
            if(!sptSet[n] && dist[n] <= min) {
                min = dist[n];
                minIndex = n;
            }
        }
        return minIndex;
    }

    private void printSolution(int[] dist){
        System.out.println("Ride                  Distance from entrance");
        System.out.println("\nMedieval Zone: ");
        for(int i =1; i < rides.size(); i ++){
            if(rides.get(i).getTheme().equals("Medieval")){
                System.out.println(String.format("%-30s %-5d", rides.get(i).getName(), dist[i]));
            }
        }

        System.out.println("\nFuturistic Zone: ");
        for (int i=1; i< rides.size(); i++){
            if(rides.get(i).getTheme().equals("Futuristic")){
                System.out.println(String.format("%-30s %-5d", rides.get(i).getName(), dist[i]));
            }
        }

        System.out.println("\nJurassic Zone: ");
        for (int i=1; i< rides.size(); i++){
            if(rides.get(i).getTheme().equals("Jurassic")){
                System.out.println(String.format("%-30s %-5d", rides.get(i).getName(), dist[i]));
            }
        }

        System.out.println("\nIndustrial Zone: ");
        for (int i=1; i< rides.size(); i++){
            if(rides.get(i).getTheme().equals("Industrial")){
                System.out.println(String.format("%-30s %-5d", rides.get(i).getName(), dist[i]));
            }
        }
    }

    void dijkstra(int[][] graph){
        int dist[] = new int[rideCount];
        Boolean sptSet[] = new Boolean[rideCount];

        for(int i = 0; i< rideCount; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[0] = 0;

        for(int count = 0; count< rideCount -1; count++){
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for(int v = 0; v< rideCount; v++){
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }
}
