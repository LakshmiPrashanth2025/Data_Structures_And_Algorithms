
import java.util.*;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        boolean[] visitedRoomsFlags = new boolean[rooms.size()];

        // Start Depth First Search starting from room 0
        dfs(0, rooms, visitedRoomsFlags);

        // Now find out if any room has not been visited/ not opened by key
        for (boolean isVisited : visitedRoomsFlags) 
        {
            if (!isVisited){
                return false;
            }
        }
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room])
            return;

        visited[room] = true;
        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                new ArrayList<>());

        KeysAndRooms keysAndRooms = new KeysAndRooms();
        System.out.println(keysAndRooms.canVisitAllRooms(rooms));

    }
}
