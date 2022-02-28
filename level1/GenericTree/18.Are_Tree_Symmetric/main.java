import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }

    public static boolean areTreeMirror(Node n1, Node n2) {

        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for (int i = 0; i < n1.children.size(); i++) {
            int j = n1.children.size() - 1 - i;

            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if (areTreeMirror(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }

    // Another way of doing same
    public static boolean IsSymmetric(Node node) {
        return areTreeMirror(node, node);
    }

    // This is one way to find if tree symmetric or not
    public static boolean IsSymmetric1(Node node) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        ArrayList<Node> al = new ArrayList<Node>();

        while (q.size() > 0) {
            node = q.remove();
            for (Node child : node.children) {
                al.add(child);
                q.add(child);
            }

            int i = 0;
            int j = al.size() - 1;
            while (i < j) {
                int lsize = al.get(i).children.size();
                int rsize = al.get(j).children.size();
                if (lsize != rsize) {
                    return false;
                }
                i++;
                j--;
            }
            al = new ArrayList<>();
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        boolean sym = IsSymmetric(root);
        System.out.println(sym);
        // display(root);
    }
}