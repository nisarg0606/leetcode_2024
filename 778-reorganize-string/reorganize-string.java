class Pair {
    int freq;
    char ch;

    Pair(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
    }
}

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        Pair pr;
        for (char ch : map.keySet()) {
            pr = new Pair(-map.get(ch), ch);
            pq.add(pr);
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = null;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            sb.append(current.ch);
            current.freq += 1;
            if (prev != null && prev.freq < 0) {
                pq.add(prev);
            }
            prev = (current.freq < 0) ? current : null;
        }

        if (sb.length() != s.length()) {
            return "";
        } else {
            return sb.toString();
        }
    }
}