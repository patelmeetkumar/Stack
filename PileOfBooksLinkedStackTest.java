
public class PileOfBooksLinkedStackTest {
	
	public static void main(String[] args) 
	{
		PileOfBooksStackInterface<String> aStack = new PileOfBooksLinkedStack<>();
		
		/*
		 * Creates an empty stack.
		 * Tests isEmpty
		 */
		System.out.println("Creating an empty stack.");
		System.out.println();
		testIsEmpty(aStack, true);

		/*
		 * Creates a stack with elements. 
		 * Tests push, peek, isEmpty, pop
		 */
		String[] contentsOfStack = { "A", "D", "B", "A", "C", "A", "D" };
		testPush(aStack, contentsOfStack);
		System.out.print("Upon peek, the top element of the stack is: ");
		System.out.println(aStack.peek());
		System.out.println();
		testIsEmpty(aStack, false);
		testPop(aStack, contentsOfStack);
		System.out.println();
		
		/*
		 * Creates a stack with elements. 
		 * Tests push, clear, isEmpty
		 */
		String[] testStrings = { "A", "B" };
		testPush(aStack, testStrings);
		System.out.println("\nClearing the stack:");
		aStack.clear();
		System.out.println();
		testIsEmpty(aStack, true);
		
	} // end main

	// Tests the method push.
	private static void testPush(PileOfBooksStackInterface<String> aStack, String[] content) 
	{
		System.out.print("Adding to the stack: ");
		for (int index = 0; index < content.length; index++) 
		{
			aStack.push(content[index]);
			System.out.print(content[index] + " ");
		} // end for
		System.out.println();
		System.out.println("The last element added is the first element in the pile of books.");

	} // end testPush

	// Tests the pop method.
	private static void testPop(PileOfBooksStackInterface<String> aStack, String[] tests) 
	{
		for (int index = 0; index < tests.length; index++) 
		{
			System.out.println("\nPopping a string from the stack:");
			String removedString = aStack.pop();
			System.out.println("pop() returns " + removedString);
		} // end for
		
	} // end testPop

	// Tests the method isEmpty.
	// correctResult indicates what isEmpty should return.
	private static void testIsEmpty(PileOfBooksStackInterface<String> aStack, boolean correctResult) 
	{
		System.out.print("Testing isEmpty with ");
		if (correctResult)
			System.out.println("an empty stack:");
		else
			System.out.println("a stack that is not empty:");

		System.out.print("isEmpty finds the stack ");
		if (correctResult && aStack.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aStack.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");
		System.out.println();
		
	} // end testIsEmpty


	
}
