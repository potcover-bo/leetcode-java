package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，
 * 用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，
 * 例如自动补完和拼写检查。
 *
 */
public class Trie {

    private class Node{
        public int count; //以当前节点结尾的次数
        public Map<Character, Node> next;

        public Node(int count){
            this.count = count;
            this.next = new HashMap<>();
        }

        public Node(){
            this(0);
        }

    }

    private Node root;


    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.count++;
    }

    public boolean search(String word) {
        if (word.length() == 0) {
            return false;
        }
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.count > 0;
    }

    public int searchFrequency(String word){
        if (word.length() == 0) {
            return 0;
        }
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return cur.count;
    }

    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return false;
        }
        Node cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return true;
    }
}
