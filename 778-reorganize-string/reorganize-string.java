class CharacterFrequency {
    char ch;
    int freq;

    CharacterFrequency(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String reorganizeString(String s){
		int[] freq = new int[26];
		
		for(char ch: s.toCharArray()){
			freq[ch - 'a']++;
		}
		
		int maxFreq = Arrays.stream(freq).max().getAsInt();
		if(maxFreq > (s.length() + 1 / 2)) return "";
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freq[b - 'a'] - freq[a - 'a']);
		
		for(char ch = 'a'; ch <= 'z'; ch++){
			if(freq[ch - 'a'] > 0){
				maxHeap.add(ch);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(maxHeap.size() >= 2){
			char first = maxHeap.poll();
			char second = maxHeap.poll();
			
			sb.append(first);
			sb.append(second);
			
			freq[first - 'a']--;
			freq[second - 'a']--;
			
			if(freq[first - 'a'] > 0){
				maxHeap.add(first);
			}
			
			if(freq[second - 'a'] > 0){
				maxHeap.add(second);
			}
		}
		
		if(!maxHeap.isEmpty()){
			char last = maxHeap.poll();
			if(freq[last - 'a'] > 1) return "";
			sb.append(last);
		}
		
		return sb.toString();
	}
}