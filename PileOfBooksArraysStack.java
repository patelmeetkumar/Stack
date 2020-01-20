import java.util.Arrays;
import java.util.EmptyStackException;

public class PileOfBooksArraysStack<T> implements PileOfBooksStackInterface<T> {

	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	/*
	 * Creates an empty stack whose initial capacity is 50.
	 */
	public PileOfBooksArraysStack()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/*
	 * Creates an empty stack given capacity.
	 * 
	 * @param initialCapacity The integer capacity wanted for stack.
	*/
	public PileOfBooksArraysStack(int initialCapacity)
	{
		integrityOK = false;
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
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
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
		
	} // end push

	/**
	 * Always ensures there is space for more entries.
	 * Exception if capacity desired is more than max.
	 */
	private void ensureCapacity()
	{
		if (topIndex >= stack.length - 1) // If array is full, double its size
		{
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		} // end if
		
	} // end ensureCapacity
	
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
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
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
			return stack[topIndex];
		} // end if
		
	} // end peek
	
	/**
	 * Detects whether this stack is empty.
	 * 
	 * @return True if the stack is empty.
	 */
	public boolean isEmpty()
	{
		return topIndex < 0;
	} // end isEmpty
	
	/** Removes all entries from this stack. */
	public void clear()
	{
		checkIntegrity();
		// Remove references to the objects in the stack,
		// but do not deallocate the array
		while (topIndex > -1)
		{
			stack[topIndex] = null;
			topIndex--;
		} // end while
		//Assertion: topIndex is -1
	} // end clear
	
	
	
} // end PileOfBooksArraysStack
