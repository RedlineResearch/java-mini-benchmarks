package net.veroy.minibench.stable_example;

/**
 * Node for SimpleList
 *
 */

public class Node
{
    public EndNode mynode;

    public Node( EndNode enode )
    {
        mynode = enode;
    }

    public Integer getValue()
    {
        return mynode.getValue();
    }

    public void removeEndNode()
    {
        mynode = null;
    }
}
