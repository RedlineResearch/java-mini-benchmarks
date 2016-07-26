package net.veroy.test;

/**
 * BadLinkedList test case
 *
 */
import java.util.BadLinkedList;
import java.util.LinkedList;
import net.veroy.test.Node;

public class ListExample
{
    public static void main( String[] args )
    {
        int number = 0;
        int reps = 0;
        // First argument is number of elements in BadLinkedList
        try {
            number = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println( "Argument " + args[0] + " not an integer." );
            System.exit(1);
        }
        // Second argument is how many times to create the linked list
        try {
            reps = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println( "Argument " + args[1] + " not an integer." );
            System.exit(1);
        }
        BadLinkedList mylist = new BadLinkedList();
        for (int iter = 0; iter < reps; iter++) {
            for (int i = 0; i < number; i++) {
                mylist.add(new Node(1024));
                if ((i % 100) == 1) {
                    mylist.remove();
                }
            }
            System.out.println("Run[ " + iter + " ] -->  length: " + mylist.size());
            while (!mylist.isEmpty()) {
                mylist.remove();
            }
        }
    }
}
