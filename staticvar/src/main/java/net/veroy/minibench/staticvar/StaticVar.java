package net.veroy.minibench.staticvar;

/**
 * Static Variable example
 *
 */
import java.util.Random;

import net.veroy.minibench.staticvar.Node;

public class StaticVar
{
    private static Node node_g;

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

    private static boolean get_use_option(String arg)
    {
        if (arg.toUpperCase().equals("USE")) {
            return true;
        } else if (arg.toUpperCase().equals("DONTUSE")) {
            return false;
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
        // First argument is how many times to create the linked list
        int reps = get_reps_option(args[0]);
        // Second argument selects UseNode vs Don't Use Node
        boolean useFlag = get_use_option(args[1]);

        Integer total = 0;
        for (int index = 0; index < reps; index++) {
            node_g = new Node(index);
            if (useFlag) {
                Node curnode = node_g;
                node_g = null;
                total += curnode.getValue();
            } else {
                node_g = null;
            }
        }
        System.out.println("Total: " + total);
    }

    private static void print_help()
    {
        System.out.println( "usage: number reps SEQ/RANDOM SEQDEL/ATEND\n" );
        System.out.println( "positional arguments:" );
        System.out.println( "    reps               number of repetitions of creating LinkedList" );
        return;
    }
}
