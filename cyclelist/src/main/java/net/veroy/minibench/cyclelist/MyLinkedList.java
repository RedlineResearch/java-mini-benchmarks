package net.veroy.minibench.simplelist;

/**
 * SimpleList
 *
 */

import net.veroy.minibench.simplelist.Node;

public class MyLinkedList
{
    public Node head;
    public Node end;
    public Node current;

    public MyLinkedList()
    {
        // Always a cycle
        this.head.setNext(end);
        this.end.setNext(head);
        this.current = head;
    }

    private boolean is_head( Node mynode )
    {
        return (this.head == mynode);
    }

    private boolean is_end( Node mynode )
    {
        return (this.end == mynode);
    }

    private boolean sanity_check()
    {
        return (this.end.getNext() == this.head);
    }

    public void add( Node newnode )
    {
        // Search for node that cycles back to head and add there.
        Node prev = this.end;
        Node current = this.head;
        while (current.getNext() != this.end) {
            prev = current;
            current = current.getNext();
        }
        assert( current.getNext() == this.end );
        prev = current;
        current.setNext( newnode );
        newnode.setNext( this.end );
    }

    public boolean isEmpty()
    {
        return (this.head.getNext() == this.end);
    }
}
