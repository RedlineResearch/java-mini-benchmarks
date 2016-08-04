package net.veroy.minibench.simplelist;

/**
 * Simple LinkedList example
 *
 */
import java.util.LinkedList;
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
        if (arg.toUpperCase() == "SEQ") {
            return false;
        } else if (arg.toUpperCase() == "RANDOM") {
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
        if (arg.toUpperCase() == "SEQDEL") {
            return false;
        } else if (arg.toUpperCase() == "ATEND") {
            return true;
        } else {
            System.err.println( "Invalid option: " + arg );
            print_help();
            System.exit(1);
        }
        return false;
    }

    public static void main( String[] args )
    {
        // Check for positional arguments
        if (args.length != 5) {
            print_help();
            System.exit(1);
        }
        // First argument is number of elements in LinkedList
        int number = get_number_option(args[0]);
        // Second argument is how many times to create the linked list
        int reps = get_reps_option(args[1]);
        // Third argument selects between int and Integer
        boolean useInteger = get_integer_option(args[2]);
        // Fourth argument selects between seq/random
        boolean seqFlag = get_random_option(args[3]);
        // Fifth argument selects between  seqdel/atend
        boolean atEndFlag = get_at_end_option(args[4]);
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
        System.out.println( "    int/Integer        Use primitive type int (or class Integer) as value in nodes" );
        System.out.println( "    seq/random        Sequentially insert (or randomly insert) in list" );
        System.out.println( "    seqdel/atend       Sequentially delete nodes.(Or delete list all at once)" );
        return;
    }
}
