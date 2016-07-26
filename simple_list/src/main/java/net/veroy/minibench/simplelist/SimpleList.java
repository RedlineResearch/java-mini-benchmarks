package net.veroy.minibench.simplelist;

/**
 * Simple LinkedList example
 *
 */
import java.util.LinkedList;
import net.veroy.minibench.simplelist.Node;

public class SimpleList
{
    public static void main( String[] args )
    {
        int number = 0;
        int reps = 0;
        int node_size = 0;
        // First argument is number of elements in LinkedList
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
        // Third argument is how big the Node array is.
        try {
            node_size = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println( "Argument " + args[2] + " not an integer." );
            System.exit(1);
        }
        LinkedList mylist = new LinkedList();
        for (int iter = 0; iter < reps; iter++) {
            for (int i = 0; i < number; i++) {
                mylist.add(new Node(node_size));
                if ((i % 10) == 1) {
                    mylist.remove();
                }
            }
            System.out.println("Run[ " + iter + " ] -->  length: " + mylist.size());
            while (!mylist.isEmpty()) {
                mylist.remove();
            }
        }
    }

    private static void print_help()
    {
        System.out.println( "usage: number reps size\n\n" );
        System.out.println( "positional arguments:\n" );
        System.out.println( "    number             number of elements in LinkedList\n" );
        System.out.println( "    reps               how many repetitions of creating LinkedList\n" );
        System.out.println( "    size               how big (in bytes) a Node of the LinkedList is\n" );
        return 0;
    }
}
