import java.util.*;

public class Graph<T> {
    // Har bir tugun uchun bog'liq tugunlar ro'yxatini saqlaydigan xarita
    private final Map<T, List<T>> adjacencyList;

    public Graph() {
        // Xaritani HashMap sifatida boshlang'ichlashtirish
        adjacencyList = new HashMap<>();
    }

    public void addNode(T node) {
        if (node==null) {
            throw new NullPointerException();
        }
        // Agar xaritada tugun mavjud bo'lmasa, uni xaritaga qo'shish
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new ArrayList<>());
        }
    }

    public void addEdge(T node1, T node2) {
        if (node1==null || node2==null) {
            throw new NullPointerException();
        }
        // node1 va node2 orasidagi yo'lni ikkala tomondan qo'shish
        // Faraz qilingki, ikkala tugun ham grafda mavjud
        if (!adjacencyList.containsKey(node1)) {
            throw new RuntimeException("node1 not exist");
        }
        if (!adjacencyList.containsKey(node2)) {
            throw new RuntimeException("node2 not exist");
        }
        if (adjacencyList.get(node1).contains(node2)) {
            throw new RuntimeException("node2 already exist");
        }
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }

    public boolean isAdjacent(T node1, T node2) {
        if (node1==null || node2==null) {
            throw new NullPointerException();
        }
        // node2 ning node1 ning bog'liq tugunlari ro'yxatida bo'lishini tekshirish
        // Faraz qilingki, ikkala tugun ham grafda mavjud
        return adjacencyList.get(node1).contains(node2);
    }

    @Override
    public String toString() {
        // StringBuilder dan foydalanib grafning matnli ko'rinishini yaratish
        StringBuilder sb = new StringBuilder();
        sb.append("Graph{\n");
        for (T node : adjacencyList.keySet()) {
            sb.append(node).append(" -> ").append(adjacencyList.get(node)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
