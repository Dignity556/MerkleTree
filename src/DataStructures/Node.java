package DataStructures;

public class Node {
    private String start_node;
    private String end_node;
    private String attribute;

    public Node(String start_node, String end_node, String attribute) {
        this.start_node = start_node;
        this.end_node = end_node;
        this.attribute = attribute;
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

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
