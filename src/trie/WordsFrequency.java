package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.02. 单词频率
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 * 示例：
 *
 */
public class WordsFrequency {
    // ·················哈希表解法················
    //private Map<String, Integer> map;
    //
    //public WordsFrequency(String[] book) {
    //    map = new HashMap<>();
    //    for (int i = 0; i < book.length; i++) {
    //        if (map.get(book[i]) == null) {
    //            map.put(book[i], 1);
    //        }else {
    //            map.put(book[i], map.get(book[i]) + 1);
    //        }
    //    }
    //}
    //
    //public int get(String word) {
    //    if (map.get(word) == null) {
    //        return 0;
    //    }else {
    //        return map.get(word);
    //    }
    //}

    // `````````````````````字典树解法`````````````````````````````

    private Trie trie;

    public WordsFrequency(String[] book) {
        this.trie = new Trie();
        for (String b : book) {
            this.trie.insert(b);
        }
    }

    public int get(String word) {
        return trie.searchFrequency(word);
    }


}
