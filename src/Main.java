import DataStructures.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1","1698630724","50","1.2","A","B"));
        transactions.add(new Transaction("2","1698630724","75","1.6","A","C"));
        transactions.add(new Transaction("3","1698630724","30","1.1","C","D"));
        transactions.add(new Transaction("4","1698630724","40","1.5","D","B"));
        transactions.add(new Transaction("5","1698630724","43","1.23","D","A"));

        MerkleTree merkleTree = new MerkleTree(transactions);
        Graph g=new Graph();
        ArrayList<Edge> edges=g.tx_to_graph(transactions);
        System.out.println(edges.size());
        System.out.println("Merkle Tree: "+merkleTree.getMerkleTree().size());
        MerkleGraphTree mgt=new MerkleGraphTree();
        HashMap<String,ArrayList<Edge>> map=mgt.start_node_merge(transactions);
        for (String key: map.keySet()){
            int i=0;
            while (map.get(key).size() > i)
            {
                System.out.println("Key:"+key+" Value:"+map.get(key).get(i).getEnd_node().getNode_id());
                i+=1;
            }
        }
    }
}
