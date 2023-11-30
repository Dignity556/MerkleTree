package DataStructures;

import java.sql.Timestamp;

public class Transaction {
    private String id;
    private String timestamp;
    private String time_cost;
    private String reputation; //相当于权重
    private String start_node;
    private String end_node;

    public Transaction(String id, String timestamp, String time_cost, String reputation, String start_node, String end_node) {
        this.id = id;
        this.timestamp = timestamp;
        this.time_cost = time_cost;
        this.reputation = reputation;
        this.start_node = start_node;
        this.end_node = end_node;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTime_cost() {
        return time_cost;
    }

    public void setTime_cost(String time_cost) {
        this.time_cost = time_cost;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public String getStart_node() {
        return start_node;
    }

    public void setStart_node(String start_node) {
        this.start_node = start_node;
    }

    public String getEnd_node() {
        return end_node;
    }

    public void setEnd_node(String end_node) {
        this.end_node = end_node;
    }
}
