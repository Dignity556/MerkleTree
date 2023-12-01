package DataStructures;

import Utils.UtilFuncs;

import javax.rmi.CORBA.Util;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {

    private List<Transaction> transactions;
    private List<String> merkleTree;

    public MerkleTree(List<Transaction> transactions) {
        this.transactions = transactions;
        this.merkleTree=new ArrayList<>();
        buildMerkleTree();
    }

    private void buildMerkleTree() {
        List<String> previousLayer = new ArrayList<>();
        for(int i=0;i<transactions.size();i++)
        {
            merkleTree.add(transactions.get(i).getId());
            previousLayer.add(UtilFuncs.calculateHash(transactions.get(i).getId()));
        }
        merkleTree.addAll(previousLayer);

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
            merkleTree.addAll(previousLayer);
        }

    }



    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<String> getMerkleTree() {
        return merkleTree;
    }

    public void setMerkleTree(List<String> merkleTree) {
        this.merkleTree = merkleTree;
    }
}