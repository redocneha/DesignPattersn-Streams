package streams;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {
    private final SortedMap<Integer, String> hashRing = new TreeMap<>();

    public void addServer(String server) {
        int hash = server.hashCode(); // Simple hash function
        hashRing.put(hash, server);
    }

    public String getServer(String key) {
        int hash = key.hashCode();
        System.out.println("Hashcode"+hash);
        if (!hashRing.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = hashRing.tailMap(hash);
            System.out.println("tailmap"+tailMap);


            hash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
        }
        return hashRing.get(hash);
    }

    public static void main(String[] args) {
        ConsistentHashing ch = new ConsistentHashing();
        ch.addServer("Server1");
        ch.addServer("Server2");
        ch.addServer("Server3");

        System.out.println("Key1 assigned to: " + ch.getServer("Keyw1"));
        System.out.println("Key1 assigned to: " + ch.getServer("pomdks"));
        System.out.println("Key2 assigned to: " + ch.getServer("keueeee2"));
    }
}

