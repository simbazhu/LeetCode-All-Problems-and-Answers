class Solution {
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		
		int start = 0, res = 0;
		
		Map<Character, Integer> m = new HashMap<>(); //Stores count of letters in the window.
		Map<String, Integer> m2 = new HashMap<>(); //Stores count of occurence of that string.
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			m.put(c, m.getOrDefault(c, 0) + 1);
			if(i - start + 1 > minSize) {
				char c2 = s.charAt(start);
				m.put(c2, m.get(c2) - 1);
				if(m.get(c2) == 0) {
					m.remove(c2);
				}
				start++;
			}
			
			if(i - start + 1 == minSize && m.size() <= maxLetters) { //When the substring in the window matches the constraints.
				String str = s.substring(start, i + 1);
			    m2.put(str, m2.getOrDefault(str, 0) + 1);
				res = Math.max(res, m2.get(str));
			}
		}
		
		return res;			
	}
}
