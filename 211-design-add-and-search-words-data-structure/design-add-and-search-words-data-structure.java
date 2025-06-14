class TrieNode {
    TrieNode[] childen = new TrieNode[26];
    boolean isEndOfWord = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.childen[idx] == null) {
                node.childen[idx] = new TrieNode();
            }
            node = node.childen[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word.toCharArray(), 0, root);
    }

    private boolean searchHelper(char[] word, int index, TrieNode node) {
        if (node == null)
            return false;
        if (index == word.length)
            return node.isEndOfWord;

        char ch = word[index];
        if (ch == '.') {
            for (TrieNode child : node.childen) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return searchHelper(word, index + 1, node.childen[ch - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */