import java.math.BigInteger;
class Solution {
    public int numDifferentIntegers(String word) {
        Set<BigInteger> set = new HashSet<>();
        word = word.replaceAll("[abcdefghijklmnopqrstuvwxyz]", " ");
        String ip[] = word.split("\\s+");
        for(String s : ip)
            if(!s.equals(""))
                set.add(new BigInteger(s));
        
        return set.size();
    }
}
