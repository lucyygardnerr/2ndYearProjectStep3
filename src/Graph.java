// LUCY GARDNER GMB18183
import java.io.IOException;
import java.util.List;

// Graph class which creates and manipulates the graph
class Graph {

    private FileHandler fileHandler = new FileHandler();
    private List<Ride> rides;
    private static final int rideCount = 21;

    private void getRideInfo() throws IOException {
        fileHandler.getRidesFromFile();
        rides = fileHandler.getRides();
    }

    int[][] setUpGraph() throws IOException {
        /*This method receives the rides in from the fileHandler class
          and creates a graph to match the order of the list of rides
        */

        getRideInfo();

        int parkGraph[][] = new int[][]{{0, 700, 0, 0, 0, 0, 1400, 0, 0, 0, 0, 1400, 0, 0, 0, 0, 700, 0, 0, 0, 0},
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

        return parkGraph;
    }

    private int minWeight(int dist[], Boolean sptSet[]){
        // This method is used as part of Dijkstra's shortest path method to find the smallest weight
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
        /* This method prints the solution to the Dijkstra method
           It does so by splitting the rides in to their sections of the theme park
           and printing the ride name alongside the distance from the entrance / exit of the theme park
         */
        System.out.println("Ride                  Distance from Entrance/Exit");
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
        /* This method is used to find the shortest path between 2 nodes
           In this case 1 of those nodes is always Ride 0 - the entrance / exit of the park
           with the other being each ride of the theme park
         */
        int dist[] = new int[rideCount];
        Boolean sptSet[] = new Boolean[rideCount];

        for(int i = 0; i< rideCount; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[0] = 0;

        for(int count = 0; count< rideCount -1; count++){
            int u = minWeight(dist, sptSet);
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
