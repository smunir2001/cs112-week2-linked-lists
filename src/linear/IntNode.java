package linear;

public class IntNode {

    int data;
    IntNode next;

    public IntNode(int data, IntNode next) {

        this.data = data;
        this.next = next;

    }

    /*
    Return the String representation of an IntNode object
     */
    @Override
    public String toString() {

        return data + "";

    }

}
