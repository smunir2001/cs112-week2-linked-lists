package linear;

public class StringNode {

    String data;
    StringNode next;

    public StringNode(String data, StringNode next) {

        this.data = data;
        this.next = next;

    }

    /*
    Return the String representation of a StringNode object.
     */
    @Override
    public String toString() {

        return data + "";

    }

}
