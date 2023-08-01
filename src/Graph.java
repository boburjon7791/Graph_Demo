import java.util.*;

public class Graph<T> {
    // Har bir tugun uchun bog'liq tugunlar ro'yxatini saqlaydigan xarita
    private final Map<T, List<T>> adjacencyList;
    private final Queue<T> queue=new PriorityQueue<>();
    private final Set<T> checked=new HashSet<>();

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
            throw new RuntimeException(node1+" not exist");
        }

        if (!adjacencyList.containsKey(node2)) {
            this.addNode(node2);
        }
        if (adjacencyList.get(node1).contains(node2)) {
            throw new RuntimeException(node2 +" already exist");
        }
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }

    public boolean isAdjacent(T node1, T node2) {
        if (node1==null || node2==null) {
            throw new NullPointerException("node1 = "+node1+", "+"node2 = "+node2);
        }
        // node2 ning node1 ning bog'liq tugunlari ro'yxatida bo'lishini tekshirish
        // Faraz qilingki, ikkala tugun ham grafda mavjud
        return adjacencyList.get(node1).contains(node2);
    }

    public int search(T node1, T node2){
        if (!this.adjacencyList.containsKey(node1)) {
            throw new IllegalArgumentException(node1 +" is not exist");
        }
        if (!this.adjacencyList.containsKey(node2)) {
            throw new IllegalArgumentException(node1 +" is not exist");
        }
        this.queue.add(node1);
        this.queue.addAll(this.adjacencyList.get(node1));
        int i=1;
        while (!queue.isEmpty()){
            T poll = this.queue.poll();
            this.checked.add(poll);
            if (Objects.equals(poll,node2)) {
                return i;
            }else {
                this.queue.addAll(this.adjacencyList.keySet());
                i++;
            }
            this.queue.removeAll(this.checked);
        }
        return i;
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
