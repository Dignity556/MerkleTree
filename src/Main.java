import DataStructures.MerkleTree;
import DataStructures.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1","1698630724","50","1.2","A","B"));
        transactions.add(new Transaction("2","1698630724","75","1.6","A","C"));
        transactions.add(new Transaction("3","1698630724","30","1.1","C","D"));
        transactions.add(new Transaction("4","1698630724","40","1.5","D","B"));
        transactions.add(new Transaction("5","1698630724","43","1.23","D","A"));

        MerkleTree merkleTree = new MerkleTree(transactions);
        System.out.println("Merkle Tree: "+merkleTree.getMerkleTree().size());
    }
}
