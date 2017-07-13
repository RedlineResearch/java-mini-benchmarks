package net.veroy.minibench.cyclelist;

/**
 * Simple singly linked list example
 * We use our own implementation of a singly linked list
 *
 */
import net.veroy.minibench.cyclelist.Node;
import net.veroy.minibench.cyclelist.MyLinkedList;

public class CycleList
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

    // ----------------------------------------------------------------------
    // Helper functions
    // ----------------------------------------------------------------------
    private static void create_list_sequential_node( MyLinkedList mylist,
                                                     int number )
    {
        for (int i = 0; i < number; i++) {
            mylist.add(new Node(new Integer(i)));
        }
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
        // First argument is number of elements in MyLinkedList
        int number = get_number_option(args[0]);

        MyLinkedList mylist = new MyLinkedList();
        // Create the list
        create_list_sequential_node( mylist,
                                     number );
        Integer total = 0;
        while (!mylist.isEmpty()) {
            // System.out.println(cur);
            total += mylist.current.getValue();
            mylist.next();
        }
        // System.out.println( "Total: " + total );
    }

    private static void print_help()
    {
        System.out.println( "usage: number\n" );
        System.out.println( "positional arguments:" );
        System.out.println( "    number             number of elements in MyLinkedList" );
        return;
    }
}
