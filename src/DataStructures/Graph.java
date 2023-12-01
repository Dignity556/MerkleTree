package DataStructures;

import java.util.ArrayList;

public class Graph {

    private ArrayList<String> edges;

    public Graph(ArrayList<String> edges) {
        this.edges = edges;
    }
    public Graph(){

    }
    public ArrayList<Edge> tx_to_graph(ArrayList<Transaction> txs){
        ArrayList<Edge> edges=new ArrayList<>();
        for(int i=0;i<txs.size();i++)
        {
            String start_node=txs.get(i).getStart_node();
            Node n1=new Node(start_node);
            String end_node=txs.get(i).getEnd_node();
            Node n2=new Node(end_node);
            String id=txs.get(i).getId();
            String timestamp=txs.get(i).getTimestamp();
            String time_cost=txs.get(i).getTime_cost();
            String rp=txs.get(i).getReputation();
            edges.add(new Edge(n1,n2,id,timestamp,time_cost,rp));
        }
        return edges;
    }
}
