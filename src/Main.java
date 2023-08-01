public class Main {
    public static void main(String[] args) {
        Graph<String> stringGraph = new Graph<>();
        stringGraph.addNode("siz");
        stringGraph.addEdge("siz","ali");
        stringGraph.addEdge("siz","vali");
        stringGraph.addEdge("siz","tohir");

        stringGraph.addEdge("ali","aziza");
        stringGraph.addEdge("ali","olim");

        stringGraph.addEdge("vali","botir");
        stringGraph.addEdge("vali","ziyoda");

        stringGraph.addEdge("tohir","elon musk");
        stringGraph.addEdge("tohir","mohir");
        System.out.println(stringGraph);
        System.out.println("stringGraph.search(\"siz\",\"ali\") = " + stringGraph.search("siz", "ali"));
    }
}