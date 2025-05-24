class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
            if (words[i].contains(String.valueOf(x)))
                indices.add(i);
        return indices;
    }
}