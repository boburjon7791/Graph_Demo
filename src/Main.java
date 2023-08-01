public class Main {
    public static void main(String[] args) {
        Graph<String> stringGraph = new Graph<>();
        stringGraph.addNode("Boburjon");
        stringGraph.addNode("Ali");
        System.out.println(stringGraph);
        System.out.println("stringGraph.isAdjacent(\"Boburjon\",\"hp\") = " + stringGraph.isAdjacent("Boburjon", "hp"));
        stringGraph.addEdge("Boburjon","Ali");
        System.out.println("stringGraph.isAdjacent(\"Boburjon\",\"Ali\") = " + stringGraph.isAdjacent("Boburjon", "Ali"));
        System.out.println(stringGraph);
        stringGraph.addNode("hp");
        stringGraph.addEdge("Boburjon","hp");
        System.out.println(stringGraph);
        System.out.println("stringGraph.isAdjacent(\"Boburjon\",\"hp\") = " + stringGraph.isAdjacent("Boburjon", "hp"));
        stringGraph.addNode("acer");
        System.out.println(stringGraph);
    }
}