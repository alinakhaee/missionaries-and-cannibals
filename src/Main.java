import algorithms.AStar;
import algorithms.BFS;
import algorithms.DFS;
import algorithms.Greedy;
import model.State;

public class Main {
    public static void main(String[] args) {
        State initialState = new State(3, 3, 0, 0, false, 0, null);
        BFS.runBFS(initialState);
        DFS.runDFS(initialState);
        AStar.runAStar(initialState);
        Greedy.runGreedy(initialState);
    }
}