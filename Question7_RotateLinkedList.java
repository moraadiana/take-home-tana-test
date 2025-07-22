import java.util.*;

public class Question7_RotateLinkedList{

    public static void main(String[] args) {
        // Create a LinkedList and add some items
        LinkedList<String> InitialList = new LinkedList<>();
        InitialList.add("ID_A01");
        InitialList.add("ID_A02");
        InitialList.add("ID_A03");
        InitialList.add("ID_A04");
        InitialList.add("ID_A05");
        InitialList.add("ID_A06");

        System.out.println("Initial Linked List: " + InitialList);

        int rotateBy = 2; // Number of times to rotate right
        rotateRight(InitialList, rotateBy);

        System.out.println("Rotated Linked List: " + InitialList);
    }

    // Rotate linked list to the right by 'n' positions
    public static void rotateRight(LinkedList<String> list, int n) {
        if (list == null || list.size() <= 1 || n <= 0) {
            return;
        }

        int actualRotations = n % list.size(); // Handle rotations greater than size
        for (int i = 0; i < actualRotations; i++) {
            // Remove the last Item and insert it infront
            String lastItem = list.removeLast();
            list.addFirst(lastItem);
        }
    }
}
