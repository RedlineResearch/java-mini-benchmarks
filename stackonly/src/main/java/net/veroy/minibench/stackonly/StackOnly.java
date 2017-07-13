package net.veroy.minibench.stackonly;

/**
 * Simple example to generate Died by StackOnly variables
 *
 */
import java.util.Iterator;
import java.util.Random;

import net.veroy.minibench.stackonly.Node;

public class StackOnly
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
        // // Third argument selects between  seqdel/atend
        // boolean atEndFlag = get_at_end_option(args[3]);

        Integer total = 0;

        for (int iter = 0; iter < number; iter++) {
            Node n = new Node(100 + iter); // It doesn't matter what the value is.
            total += n.getValue();
        }
        System.out.println( "Total: " + total );
    }

    private static void print_help()
    {
        System.out.println( "usage: number reps SEQ/RANDOM SEQDEL/ATEND\n" );
        System.out.println( "positional arguments:" );
        System.out.println( "    number             number of elements in LinkedList" );
        System.out.println( "    reps               number of repetitions of creating LinkedList" );
        // System.out.println( "    seqdel/atend       Sequentially delete nodes.(Or delete list all at once)" );
        return;
    }
}
