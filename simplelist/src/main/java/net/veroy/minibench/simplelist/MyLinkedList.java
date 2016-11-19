package net.veroy.minibench.simplelist;

/**
 * SimpleList
 *
 */

import net.veroy.minibench.simplelist.Node;

public class MyLinkedList
{
    public Node current;

    public MyLinkedList()
    {
        this.current = null;
    }

    public void add( Node newnode )
    {
        // Search for end and add there.
        // This is basically an append
        if (this.current == null) {
            this.current = newnode;
        } else {
            Node iter = this.current.next;
            Node prev = this.current;
            while (iter != null) {
                prev = iter;
                iter = iter.next;
            }
            prev.next = newnode;
        }
    }

    public void next()
    {
        // Move the current reference to the next Node if it exists.
        this.current = this.current.next;
    }

    public boolean isEmpty()
    {
        return (this.current == null);
    }
}
