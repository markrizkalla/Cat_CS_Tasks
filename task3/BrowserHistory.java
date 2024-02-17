
import java.util.LinkedList;

public class BrowserHistory {


    public static void main(String[] args){
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedIn.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));

    }

    private class Node{
        String pageName;
        Node next;
        Node prev;

        public Node(String pageName) {
            this.pageName = pageName;
        }
    }


    Node head = null;
    Node tail = null;

    Node current;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        current = head;
        tail = head;

    }

    public void visit(String url) {
        current.next = new Node(url);
        current.next.prev = current;
        tail = current.next;
        current = current.next;
    }

    public String back(int steps) {

        int i = 0;
        while (current.prev != null){
            current = current.prev;
            i++;
            if (i == steps)
                break;


        }
        return current.pageName;

    }

    public String forward(int steps) {
        int x = 0;
        while (current.next != null){
            current = current.next;
            x++;
            if (x == steps)
                break;

        }

        return current.pageName;
    }

}
