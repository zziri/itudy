package stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(10);
		
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
