import java.util.EmptyStackException;

public class PileOfBooksLinkedStack<T> implements PileOfBooksStackInterface<T> {

	private Node topNode;
	
	/*
	 * Creates an empty stack.
	 */
	public PileOfBooksLinkedStack() 
	{
		topNode = null;
	}
	
	private class Node 
	{
		private T data;
		private Node next;
		
		private Node(T dataPortion)
		{
			this(dataPortion, null);
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor
		
		private T getData()
		{
			return data;
		} // end getData
		
		private void setData(T newData)
		{
			data = newData;
		} // end setData
		
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode

	} // end Node class
	
	/**
	 * Adds a new entry to the top of this stack.
	 * 
	 * @param newEntry An object to be added to the stack.
	 */
	public void push(T newEntry) 
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		
//		Alternate Code:
//		topNode = new Node(newEntry, topNode);
	} // end push
	
	/**
	 * Removes and returns this stack's top entry.
	 * 
	 * @return The object at the top of the stack.
	 * @throws EmptyStackException if the stack is empty before the operation.
	 */
	public T pop() 
	{
		T top = peek(); // Might throw EmptyStackException
		// Assertion: topNode != null
		topNode = topNode.getNextNode();
		
		return top;
	} // end pop
	
	/**
	 * Retrieves this stack's top entry.
	 * 
	 * @return The object at the top of the stack.
	 * @throws EmptyStackException if the stack is empty.
	 */
	public T peek() 
	{
		if (isEmpty()) 
		{
			throw new EmptyStackException();
		}
		else 
		{
			return topNode.getData();
		} // end if
		
	} // end peek
	
	/**
	 * Detects whether this stack is empty.
	 * 
	 * @return True if the stack is empty.
	 */
	public boolean isEmpty() 
	{
		return topNode == null;
	} // end isEmpty
	
	/** Removes all entries from this stack. */
	public void clear() 
	{
		topNode = null;
	} // end clear
	
	
	
} // end PileOfBookLinkedStack
