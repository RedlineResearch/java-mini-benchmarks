package net.veroy.minibench.simplelistint;

/**
 * Simple LinkedList example but using Integers instead of primitive
 * ints for the Node value.
 *
 */
import java.util.LinkedList;
import net.veroy.minibench.simplelistint.Node;

public class SimpleListInt
{
    public static void main( String[] args )
    {
        int number = 0;
        int reps = 0;
        // First argument is number of elements in LinkedList
        if (args.length != 2) {
            print_help();
            System.exit(1);
        }
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
        LinkedList mylist = new LinkedList();
        for (int iter = 0; iter < reps; iter++) {
            for (int i = 0; i < number; i++) {
                mylist.add(new Node(i));
            }
            while (!mylist.isEmpty()) {
                mylist.remove();
            }
        }
    }

    private static void print_help()
    {
        System.out.println( "usage: number reps\n" );
        System.out.println( "positional arguments:" );
        System.out.println( "    number             number of elements in LinkedList" );
        System.out.println( "    reps               number of repetitions of creating LinkedList" );
        return;
    }
}
