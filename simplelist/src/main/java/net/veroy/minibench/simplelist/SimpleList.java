package net.veroy.minibench.simplelist;

/**
 * Simple LinkedList example
 *
 */
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

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
        if (arg.toUpperCase().equals("INTEGER")) {
            return true;
        } else if (arg.toUpperCase().equals("NODE")) {
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

    // private static boolean get_at_end_option(String arg)
    // {
    //     if (arg.toUpperCase().equals("SEQDEL")) {
    //         return false;
    //     } else if (arg.toUpperCase().equals("ATEND")) {
    //         return true;
    //     } else {
    //         System.err.println( "Invalid option: " + arg );
    //         print_help();
    //         System.exit(1);
    //     }
    //     return false;
    // }

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
    // Integer helper functions
    // ----------------------------------------------------------------------
    private static void create_list_sequential_integer( LinkedList<Integer> mylist,
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

    private static void create_list_random_integer( LinkedList<Integer> mylist,
                                                    int number )
    {
        Random rand = new Random();
        for (int i = 0; i < number; i++) {
            add_to_list_order( new Integer( rand.nextInt(number * 100) ),
                               mylist );
        }
    }

    // ----------------------------------------------------------------------
    // Node helper functions
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

    private static void create_list_random_node( LinkedList<Node> mylist,
                                                 int number )
    {
        Random rand = new Random();
        for (int i = 0; i < number; i++) {
            add_to_list_order( new Node( new Integer( rand.nextInt(number * 100) ) ),
                               mylist );
        }
    }

    // ----------------------------------------------------------------------
    // MAIN
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
        // Third argument selects between seq/random
        boolean randomFlag = get_random_option(args[2]);
        // Fourth argument selects UseNode vs Don't Use Node
        boolean useFlag = get_use_option(args[3]);
        // Fifth argument selects Integer vs Node
        boolean integerFlag = get_integer_option(args[4]);
        // ????? argument selects between  seqdel/atend
        // TODO boolean atEndFlag = get_at_end_option(args[3]);

        if (integerFlag) {
            LinkedList<Integer> mylist = new LinkedList<Integer>();
            for (int iter = 0; iter < reps; iter++) {
                // Create the list
                if (randomFlag) {
                    create_list_random_integer( mylist,
                                                number );
                } else {
                    create_list_sequential_integer( mylist,
                                                    number );
                }
                Integer total = 0;
                while (!mylist.isEmpty()) {
                    // System.out.println(cur);
                    if (useFlag) {
                        Integer cur = mylist.remove();
                        total += cur;
                    } else {
                        mylist.remove();
                    }
                }
                // ATEND Option  Destroy it
                // if (atEndFlag) {
                //     mylist = null;
                // } else {
                //     Integer total = 0;
                //     while (!mylist.isEmpty()) {
                //         Integer cur = mylist.remove();
                //         // System.out.println(cur);
                //         total += cur;
                //     }
                // }
            }
        } else {
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
                // ATEND Option  Destroy it
                // if (atEndFlag) {
                //     mylist = null;
                // } else {
                //     Integer total = 0;
                //     while (!mylist.isEmpty()) {
                //         Integer cur = mylist.remove();
                //         // System.out.println(cur);
                //         total += cur;
                //     }
                // }
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
        System.out.println( "    integer/node       Use Integer or Node as the element in the list." );
        // TODO TODO TODO 
        // The documentation of the print_help is incorrect.
        // TODO TODO TODO 
        return;
    }
}
