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
        for (int i = 1; i < (number+1); i++) {
            mylist.add(new Node(new Integer(i)));
        }
    }

    // ----------------------------------------------------------------------
    // MAIN
    public static void main( String[] args )
    {
        // Check for positional arguments
        if (args.length != 1) {
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
        Integer count = 0;
        mylist.resetCurrent();
        boolean flag = mylist.moveNext();
        while (flag) {
            // DEBUG: System.out.println(" XXX:" + count);
            total += mylist.current.getValue();
            flag = mylist.moveNext();
            count++;
        }
        System.out.println( "Total: " + total );
        System.out.println( "Count: " + count );
    }

    private static void print_help()
    {
        System.out.println( "usage: number\n" );
        System.out.println( "positional arguments:" );
        System.out.println( "    number             number of elements in MyLinkedList" );
        return;
    }
}
