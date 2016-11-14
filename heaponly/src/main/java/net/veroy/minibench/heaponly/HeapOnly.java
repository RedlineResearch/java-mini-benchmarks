package net.veroy.minibench.heaponly;

/**
 * Simple example to generate Died by Heap Only variables
 *
 */
// import java.util.Iterator;

import net.veroy.minibench.heaponly.Node;

public class HeapOnly
{
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

    private static Node gtmp;
    private static Node[] nodeArray;

    private static Node createNode( int val )
    {
        gtmp = new Node(val);
        return gtmp;
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
        // First argument is number of repetitions
        int reps = get_reps_option(args[0]);

        Integer total = 0;
        nodeArray = new Node[reps];

        // Create
        for (int iter = 0; iter < reps; iter++) {
            nodeArray[iter] = createNode(100); // It doesn't matter what the value is.
        }
        // Then null out
        for (int iter = 0; iter < reps; iter++) {
            nodeArray[iter] = null;
        }
    }

    private static void print_help()
    {
        System.out.println( "usage: reps\n" );
        System.out.println( "positional arguments:" );
        System.out.println( "    reps               number of repetitions" );
        return;
    }

}
