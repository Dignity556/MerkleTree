package DataStructures;

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
            previousLayer.add(calculateHash(transactions.get(i).getId()));
        }
        merkleTree.addAll(previousLayer);

        while (previousLayer.size() > 1) {
            List<String> currentLayer = new ArrayList<>();

            for (int i = 0; i < previousLayer.size(); i += 2) {
                String left = previousLayer.get(i);
                String right = (i + 1 < previousLayer.size()) ? previousLayer.get(i + 1) : left;

                String parent = calculateHash(left + right);
                currentLayer.add(parent);
            }
            previousLayer = currentLayer;
            System.out.println(previousLayer.size());
            merkleTree.addAll(previousLayer);
        }

    }

    private String calculateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
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