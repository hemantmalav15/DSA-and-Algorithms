public class Main {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      return mainS.size();
    }

    void add(int val) {
      mainS.push(val);
    }

    int remove() {
      if(mainS.size() == 0){
          System.out.println("Queue underflow");
          return -1;
      }
      while(mainS.size() != 1){
          helperS.push(mainS.pop());
      }
      int popped = mainS.pop();
      while(helperS.size() != 0){
          mainS.push(helperS.pop());
      }
      return popped;
    }

    int peek() {
      if(mainS.size() == 0){
          System.out.println("Queue underflow");
          return -1;
      }
      while(mainS.size() != 1){
          helperS.push(mainS.pop());
      }
      int popped = mainS.pop();
      mainS.push(popped);
      while(helperS.size() != 0){
          mainS.push(helperS.pop());
      }
      return popped;
    }
  }
}