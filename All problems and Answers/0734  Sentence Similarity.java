class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        HashSet<String> dictionary = new HashSet<String>();
		if(words1.length != words2.length) 
			return false;
		for(int i=0;i< pairs.size();i++)             
			dictionary.add(pairs.get(i).get(0) + "#" + pairs.get(i).get(1));
		for(int i = 0;i<words1.length;i++) {				
			if(words1[i].equals(words2[i])) continue;
			String s = words1[i] + "#" + words2[i];
            String s1 = words2[i] + "#" + words1[i];					
			if((!dictionary.contains(s) && !dictionary.contains(s1)))						
                return false;
			}
		return true;
    }
}
