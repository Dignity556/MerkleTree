package DataStructures;

import Utils.UtilFuncs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MerkleGraphTree {
    private ArrayList<String> merklegraphtree;

    public HashMap<String,ArrayList<Edge>> start_node_merge(ArrayList<Transaction> transactions){
        Graph g=new Graph();
        ArrayList<Edge> edges=g.tx_to_graph(transactions);
        //按照起始节点分成子块，首先存入hashmap中
        HashMap<String,ArrayList<Edge>> maps=new HashMap<>();
        for (int i=0; i<edges.size();i++)
        {
            String start_node=edges.get(i).getStart_node().getNode_id();
            Boolean b=maps.containsKey(start_node);
            if (b){
                maps.get(start_node).add(edges.get(i));
            }else {
                ArrayList<Edge> eds=new ArrayList<>();
                eds.add(edges.get(i));
                maps.put(start_node,eds);
            }
        }
        return maps;
    }
    public void build_graph_tree(HashMap<String,ArrayList<Edge>> map)
    {
        ArrayList<ArrayList<String>> trees=new ArrayList();
        for (String key : map.keySet()){
            List<String> previousLayer = new ArrayList<>();
            for(int i=0;i<map.get(key).size();i++)
            {
                merklegraphtree.add(map.get(key).get(i).getId());
                previousLayer.add(UtilFuncs.calculateHash(map.get(key).get(i).getId()));
            }
            merklegraphtree.addAll(previousLayer);
            while (previousLayer.size() > 1) {
                List<String> currentLayer = new ArrayList<>();

                for (int i = 0; i < previousLayer.size(); i += 2) {
                    String left = previousLayer.get(i);
                    String right = (i + 1 < previousLayer.size()) ? previousLayer.get(i + 1) : left;

                    String parent = UtilFuncs.calculateHash(left + right);
                    currentLayer.add(parent);
                }
                previousLayer = currentLayer;
                System.out.println(previousLayer.size());
                merklegraphtree.addAll(previousLayer);
            }
            trees.add(merklegraphtree);
        }

    }

    public ArrayList<String> getMerklegraphtree() {
        return merklegraphtree;
    }

    public void setMerklegraphtree(ArrayList<String> merklegraphtree) {
        this.merklegraphtree = merklegraphtree;
    }
}
