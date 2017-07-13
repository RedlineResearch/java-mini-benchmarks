package net.veroy.minibench.cyclelist;

/**
 * Node for CycleList
 *
 */

public class Node
{
    public Integer value;
    public Node next;

    public Node( Integer new_number,
                 Node next_node )
    {
        this.value = new_number;
        this.next = next_node;
    }

    public void setNext( Node next_node )
    {
        this.next = next_node;
    }

    public Node getNext()
    {
        return this.next;
    }

    public Integer getValue()
    {
        return value;
    }
}

