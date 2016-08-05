package net.veroy.minibench.simplelist;

/**
 * Simple LinkedList example
 *
 */
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

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

    private static boolean get_integer_option(String arg)
    {
        if (arg.toUpperCase() == "INTEGER") {
            return true;
        } else if (arg.toUpperCase() == "INT") {
            return false;
        } else {
            System.err.println( "Invalid option: " + arg );
            print_help();
            System.exit(1);
        }
        return false;
    }

    private static boolean get_random_option(String arg)
    {
        if (arg.toUpperCase().equals("SEQ")) {
            return false;
        } else if (arg.toUpperCase().equals("RANDOM")) {
            return true;
        } else {
            System.err.println( "Invalid option: " + arg );
            print_help();
            System.exit(1);
        }
        return false;
    }

    private static boolean get_at_end_option(String arg)
    {
        if (arg.toUpperCase().equals("SEQDEL")) {
            return false;
        } else if (arg.toUpperCase().equals("ATEND")) {
            return true;
        } else {
            System.err.println( "Invalid option: " + arg );
            print_help();
            System.exit(1);
        }
        return false;
    }

    private static void create_list_sequential( LinkedList<Integer> mylist,
                                                int number )
    {
        for (int i = 0; i < number; i++) {
            mylist.add(new Integer(i));
        }
    }

    private static void add_to_list_order( Integer value,
                                           LinkedList<Integer> mylist )
    {
        // Check for easy empty list
        if (mylist.size() == 0) {
            // System.out.println( "Added: " + value );
            mylist.add(value);
            return;
        } // else
        // Find position
        Iterator<Integer> iter = mylist.iterator();
        int position = 0;
        Integer curvalue = 0;
        boolean done = false;
        while (!done && iter.hasNext()) {
            curvalue = iter.next();
            ++position;
            if (value < curvalue) {
                done = true;
                --position;
                assert(position >= 0);
            }
        }
        // System.out.println( "Added: " + value + " in position: " + position );
        // Add at that position
        mylist.add(position, value);
    }

    private static void create_list_random( LinkedList<Integer> mylist,
                                            int number )
    {
        Random rand = new Random();
        for (int i = 0; i < number; i++) {
            add_to_list_order( new Integer( rand.nextInt(number * 100) ),
                               mylist );
        }
    }

    public static void main( String[] args )
    {
        // Check for positional arguments
        if (args.length != 4) {
            print_help();
            System.exit(1);
        }
        // First argument is number of elements in LinkedList
        int number = get_number_option(args[0]);
        // Second argument is how many times to create the linked list
        int reps = get_reps_option(args[1]);
        // Third argument selects between seq/random
        boolean randomFlag = get_random_option(args[2]);
        // Fourth argument selects between  seqdel/atend
        boolean atEndFlag = get_at_end_option(args[3]);
        LinkedList<Integer> mylist = new LinkedList<Integer>();
        for (int iter = 0; iter < reps; iter++) {
            // Create the list
            if (randomFlag) {
                create_list_random( mylist,
                                    number );
            } else {
                create_list_sequential( mylist,
                                        number );
            }
            // Destroy it
            while (!mylist.isEmpty()) {
                Integer cur = mylist.remove();
                // System.out.println(cur);
                // TODO: Sequential or All at once at end delete?
            }
        }
    }

    private static void print_help()
    {
        System.out.println( "usage: number reps SEQ/RANDOM SEQDEL/ATEND\n" );
        System.out.println( "positional arguments:" );
        System.out.println( "    number             number of elements in LinkedList" );
        System.out.println( "    reps               number of repetitions of creating LinkedList" );
        System.out.println( "    seq/random         Sequentially insert (or randomly insert) in list" );
        System.out.println( "    seqdel/atend       Sequentially delete nodes.(Or delete list all at once)" );
        return;
    }
}
