package stack;

//ArrayList을 이용한 Stack
public class Stack<T> {
   private int top;
   private int size;
   private Object[] stackArr;

   public Stack(int size)
   {
      top = -1;
      this.size = size;
      stackArr = new Object[size];
   }

   public void push(T data)
   {
      if(isFull())
         System.out.println("Stack is Full");
      else
      {
         stackArr[++top] = data;
         System.out.println("Data Pushed");
      }
   }

   public T Pop()
   {
      if(isEmpty())
      {
         System.out.println("Stack is Empty");
         return null;
      }
      else
      {
         System.out.println("Data Poped");            
         return (T)stackArr[top--];
      }
   }

   public T Peek()
   {
      if(isEmpty())
      {
         System.out.println("Stack is Empty");
         return null;
      }
      else
      {
         System.out.println("Data Peeked");            
         return (T)stackArr[top];
      }
   }

   public boolean isFull()
   {
      return (top == (this.size-1)) ? true:false;
   }

   public boolean isEmpty()
   {
      return (top == -1) ? true:false;
   }
   
}