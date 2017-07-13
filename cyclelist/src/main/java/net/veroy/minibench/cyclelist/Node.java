package net.veroy.minibench.simplelist;

/**
 * Node for SimpleList
 *
 */

public class Node
{
    public Integer value;
    public Node next;

    public Node( Integer new_number,
                 Node next_node )
    {
        this.value = newNumber;
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

