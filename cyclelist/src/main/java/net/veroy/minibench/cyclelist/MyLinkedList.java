package net.veroy.minibench.cyclelist;

/**
 * CycleList
 *
 */

import net.veroy.minibench.cyclelist.Node;

public class MyLinkedList
{
    public Node head;
    public Node end;
    public Node current;

    public MyLinkedList()
    {
        // Always a cycle
        this.head = new Node(0xdeadbeef);
        this.end= new Node(0xbeefdead);
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

    public boolean moveNext()
    {
        Node mynext = this.current.getNext();
        assert( mynext != this.head );
        if (mynext != this.end) {
            this.current = mynext;
            return true;
        } else {
            return false;
        }
    }

    public void resetCurrent()
    {
        this.current = this.head;
    }

    private boolean sanity_check()
    {
        return ( (this.end.getNext() == this.head) &&
                 (this.current != this.end) );
    }

    public void add( Node newnode )
    {
        // Add at current
        Node oldnext = this.current.getNext();
        current.setNext( newnode );
        newnode.setNext( oldnext );
    }

    public boolean isEmpty()
    {
        return (this.head.getNext() == this.end);
    }

    public boolean atEnd()
    {
        return (this.current.getNext() == this.end);
    }
}
