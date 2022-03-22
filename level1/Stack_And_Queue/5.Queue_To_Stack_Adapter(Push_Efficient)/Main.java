public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      return mainQ.size();
    }

    void push(int val) {
      mainQ.add(val);
    }

    int pop() {
        if(mainQ.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
      while(mainQ.size() != 1){
          helperQ.add(mainQ.remove());
      }
      int popped = mainQ.remove();
      while(helperQ.size() != 0){
          mainQ.add(helperQ.remove());
      }
      return popped;
    }

    int top() {
      if(mainQ.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
      while(mainQ.size() != 1){
          helperQ.add(mainQ.remove());
      }
      int popped = mainQ.remove();
      while(helperQ.size() != 0){
          mainQ.add(helperQ.remove());
      }
      mainQ.add(popped);
      return popped;
    }
  }
}