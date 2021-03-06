package linear;

public class LLApp {

    /*
    Three steps to add an element at the front:
        1. Create a new node.
        2. Make the new node point to the first node of the original list.
        3. Make front (the variable which points to the first node of the
            list) point to the new node, otherwise the newly added node
            cannot be accessed.
     Note 1: The third is essential!
     Since the first node of the linked list is no longer the original one,
        we need to let front point to the newly added node.
     Otherwise, the new node is added into the list, but we still cannot
        access it without knowing its address.
     Remember we can only access nodes starting from front.
     Note 2: The implementation works when the original list is empty, which
        means we build a new linked list by adding the first element.

     @param item
     @param front
     @return
     */
    public static IntNode addFront(int item, IntNode front) {

        // It works when the original list is empty, meaning front is null.
        return new IntNode(item, front);

        /*
        The following code has the same semantic:
            IntNode newNode = new IntNode(item, null);
            node.next = front;
            front = node;
            return front;
         */

    }

    /*
    Delete and return the first node of a linked list.
    Watch out for empty list!

    @param front
    @return
     */
    public static IntNode deleteFront(IntNode front) {

        if (front == null) {

            return null;

        }

        return front.next;

    }

    // While loop version, stylized single-line output
    public static void traverse(IntNode front) {

        if (front == null) {

            System.out.println("Empty list.");

            return;

        }

        // First item.
        System.out.print(front.data);
        // Prepare to loop starting with second item
        IntNode ptr = front.next;
        while (ptr != null) {

            System.out.print("->" + ptr.data);
            ptr = ptr.next;

        }

        System.out.println();

    }

    public static boolean search(IntNode front, int target) {

        for (IntNode ptr = front; ptr != null; ptr = ptr.next) {

            if (target == ptr.data) {

                return true;

            }

        }

        return false;

    }

    /*
    The method works when:
        1. There is only one node in the original list.
        2. The node to be deleted is the first node.
        3. The node to be deleted is the last one.
        4. The original list is empty.

    @param front
    @param item
    @return
     */
    public static IntNode delete(IntNode front, int item) {

        // For empty list.
        if (front == null) {

            return null;

        }

        /*
        Prev is to be used for pointing to the node before
            node-to-be-deleted
         */
        IntNode ptr = front, prev = null;
        while (ptr != null) {

            if (ptr.data == item) {

                break;

            }
            /*
            Prev moves to the next element in each iteration
                to point to the node before ptr
             */
            prev = ptr;
            ptr = ptr.next;

        }

        // Item is not in list.
        if (ptr == null) {

            return front;

        }

        // First node is to be deleted.
        if (prev == null) {

            return front.next;

        }

        /*
        Let the node before node-to-be-deleted
            point to the node after node-to-be-deleted to delete.
         */
        prev.next = ptr.next;

        return front;

    }

    // Add newItem after currItem
    public static void addAfter(IntNode front, int currItem, int newItem) {

        IntNode ptr = front;
        while (ptr != null) {

            if (ptr.data == currItem) {

                break;

            }

            ptr = ptr.next;

        }

        if (ptr == null) {

            // currItem not in list.
            return;

        }

        ptr.next = new IntNode(newItem, ptr.next);

    }

    public static void main(String[] args) {

        IntNode front = null;

        traverse(front);  // Test traverse on empty list
        System.out.println("\nadding 4 to front");
        front = addFront(4,front);
        traverse(front);
        System.out.println("\nadding 6 to front");
        front = addFront(6,front);
        traverse(front);
        System.out.println("\nadding 8 to front");
        front = addFront(8,front);
        traverse(front);

        boolean flag = search(front, 5);
        if (flag) {

            System.out.println("5 is in the list");

        } else {

            System.out.println("5 is not in the list");

        }
        boolean flag2 = search(front, 6);
        if (flag2) {

            System.out.println("6 is in the list");

        } else {

            System.out.println("6 is not in the list");

        }

        System.out.println("\ndeleting front");
        front = deleteFront(front);
        traverse(front);
        System.out.println("\ndeleting front");
        front = deleteFront(front);
        traverse(front);
        System.out.println("\ndeleting front");
        front = deleteFront(front);
        traverse(front);
        System.out.println("\ndeleting front");
        front = deleteFront(front);

    }

}
