package stack;

public class LinkedStackTest {

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		stack.push(4);
		stack.push(9);
		stack.push(3);
		stack.push(8);
		
		System.out.println(stack.Peek());
		
		System.out.println(stack.Pop());
		System.out.println(stack.Pop());
		System.out.println(stack.Pop());
		System.out.println(stack.Pop());
		
		System.out.println(stack.Peek());
		stack.push(7);
		stack.push(1);
		System.out.println(stack.Peek());
		
	}

}
