import java.util.EmptyStackException;
import java.util.Vector;

public class PileOfBooksVectorStack<T> implements PileOfBooksStackInterface<T> {

	private Vector<T> stack; // Last element is the top entry in stack
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	/*
	 * Creates an empty stack whose initial capacity is 50.
	 */
	public PileOfBooksVectorStack()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	/*
	 * Creates an empty stack given capacity.
	 * 
	 * @param initialCapacity The integer capacity wanted for stack.
	*/
	public PileOfBooksVectorStack(int initialCapacity)
	{
		integrityOK = false;
		checkCapacity(initialCapacity);
		stack = new Vector<>(initialCapacity); // Size doubles as needed
		integrityOK = true;
	} // end constructor
	
	/*
	 * Throws an exception if the object is not initialized.
	 */
	private void checkIntegrity() 
	{
		if (!integrityOK) 
		{
			throw new SecurityException("ArrayBag object is corrupt.");
		} // end if
		
	} // end checkIntegrity
	
	/*
	 * Checks if the stack has reached the maximum capacity
	 * 
	 * @param the desired capacity of the stack which is compared to max capacity
	 */
	private void checkCapacity(int capacity) 
	{
		if (capacity > MAX_CAPACITY) 
		{
			throw new IllegalStateException("Attempt to create a bag whose " + 
											"capacity exceeds allowed " + "maximum of " + 
											MAX_CAPACITY);
		} // end if
	} // end checkCapacity
	
	/**
	 * Adds a new entry to the top of this stack.
	 * 
	 * @param newEntry An object to be added to the stack.
	 */
	public void push(T newEntry)
	{
		checkIntegrity();
		stack.add(newEntry);
	} // end push

	/**
	 * Removes and returns this stack's top entry.
	 * 
	 * @return The object at the top of the stack.
	 * @throws EmptyStackException if the stack is empty before the operation.
	 */
	public T pop()
	{
		checkIntegrity();
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return stack.remove(stack.size() - 1);
		} // end if
		
	} // end pop
	
	/**
	 * Retrieves this stack's top entry.
	 * 
	 * @return The object at the top of the stack.
	 * @throws EmptyStackException if the stack is empty.
	 */
	public T peek()
	{
		checkIntegrity();
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return stack.lastElement();
		} // end if
		
	} // end peek

	/**
	 * Detects whether this stack is empty.
	 * 
	 * @return True if the stack is empty.
	 */
	public boolean isEmpty()
	{
		checkIntegrity();
		return stack.isEmpty();
	} // end isEmpty
	
	/** Removes all entries from this stack. */
	public void clear()
	{
		checkIntegrity();
		stack.clear();
	} // end clear
	
	
	
} // end PileOfBooksVectorStack
