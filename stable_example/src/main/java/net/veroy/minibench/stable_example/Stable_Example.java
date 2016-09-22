package net.veroy.minibench.stable_example;

/**
 * Stable edges - non stable edges example
 *
 */
import java.util.Random;

import net.veroy.minibench.stable_example.Node;
import net.veroy.minibench.stable_example.EndNode;

public class Stable_Example
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

        Integer total = 0;
        for (int index = 0; index < reps; index++) {
            node_g = new Node( new EndNode(index) );
            Node curnode = node_g;
            total += curnode.getValue();
            node_g = null;
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
