package Greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffman_Encoding {
    private static void traverse(Node root, String code, ArrayList<String> ans){
        if (root.left == null && root.right==null){ ans.add(code); return; }
        if(root.left != null) traverse(root.left, code+"0", ans);
        if(root.right != null) traverse(root.right, code+"1", ans);
    }

    public static ArrayList<String> huffmanCodes(String S, int f[], int N){
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        for(int i=0; i<N; i++){ pq.add(new Node(f[i])); }
        while(pq.size()>1){
            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node(left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }
        Node root = pq.peek();
        ArrayList<String> ans = new ArrayList<>();
        traverse(root, "", ans);
        return ans;
    }
    public static void main(String[] args){
        String S = "abcdef";
        int f[] ={5,9,12,13,16,45};
        int N = S.length();
        ArrayList<String> codes = huffmanCodes(S,f,N);
        System.out.println(codes);
    }
}

class Node{
    int freq;
    Node left;
    Node right;
    Node(int freq){
        this.freq =freq;
        this.left=null;
        this.right = null;
    }
}
class NodeComparator implements Comparator<Node>{
    public int compare(Node a , Node b){
        return a.freq - b.freq;
    }
}