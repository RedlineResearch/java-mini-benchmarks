package net.veroy.minibench.simplelist;

/**
 * Simple singly linked list example
 * We use our own implementation of a singly linked list
 *
 */
import net.veroy.minibench.simplelist.Node;

public class SimpleList
{
    private static int get_number_option(String arg)
    {
        int number = 0;
        try {
            number = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.err.println( "Argument " + arg + " not an integer." );
            System.exit(1);
        }
        return number;
    }

    private static int get_reps_option(String arg)
    {
        int reps = 0;
        try {
            reps = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.err.println( "Argument " + arg + " not an integer." );
            System.exit(1);
        }
        return reps;
    }

    // ----------------------------------------------------------------------
    // Helper functions
    // ----------------------------------------------------------------------
    private static void create_list_sequential_node( LinkedList<Node> mylist,
                                                     int number )
    {
        for (int i = 0; i < number; i++) {
            mylist.add(new Node(new Integer(i)));
        }
    }

    private static void add_to_list_order( Node newnode,
                                           LinkedList<Node> mylist )
    {
        // Check for easy empty list
        if (mylist.size() == 0) {
            mylist.add(newnode);
            return;
        } // else
        // Find position
        Iterator<Node> iter = mylist.iterator();
        int position = 0;
        Integer curvalue = 0;
        Node curnode;
        Integer value = newnode.getValue();
        boolean done = false;
        while (!done && iter.hasNext()) {
            curnode = iter.next();
            curvalue = curnode.getValue();
            ++position;
            if (value < curvalue) {
                done = true;
                --position;
                assert(position >= 0);
            }
        }
        // Add at that position
        mylist.add(position, newnode);
    }

    // ----------------------------------------------------------------------
    // MAIN
    public static void main( String[] args )
    {
        // Check for positional arguments
        if (args.length != 2) {
            print_help();
            System.exit(1);
        }
        // First argument is number of elements in LinkedList
        int number = get_number_option(args[0]);
        // Second argument is how many times to create the linked list
        int reps = get_reps_option(args[1]);

        LinkedList<Node> mylist = new LinkedList<Node>();
        for (int iter = 0; iter < reps; iter++) {
            // Create the list
            if (randomFlag) {
                create_list_random_node( mylist,
                                         number );
            } else {
                create_list_sequential_node( mylist,
                                             number );
            }
            Integer total = 0;
            while (!mylist.isEmpty()) {
                // System.out.println(cur);
                if (useFlag) {
                    Node curnode = mylist.remove();
                    total += curnode.getValue();
                } else {
                    mylist.remove();
                }
            }
        }
    }

    private static void print_help()
    {
        System.out.println( "usage: number reps\n" );
        System.out.println( "positional arguments:" );
        System.out.println( "    number             number of elements in MyLinkedList" );
        System.out.println( "    reps               number of repetitions of creating MyLinkedList" );
        return;
    }
}
