class Solution {
    public String reformat(String s) {
        
        if(s == null || s.length() <= 1) {
            return s;
        }
        List<Character> digits = new ArrayList<>(s.length());
        List<Character> characters = new ArrayList<>(s.length());
        // Check if it is a digit or character
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.add(ch);
            } else  {
                characters.add(ch);
            }
        }
        // it is impossible to reformat the string.
        if(Math.abs(digits.size() - characters.size()) >= 2) return "";
        
        StringBuilder result = new StringBuilder();
        // boolean to decide if we should start with characters or digits
        boolean digitOrChar = (digits.size() >= characters.size()) ? true : false; 

        for (int i = 0; i < s.length(); i++) {
            if (digitOrChar) {
                result.append(digits.remove(0));
            } else {
                result.append(characters.remove(0));
            }
            digitOrChar = !digitOrChar;
        }
        return result.toString();
    }
}
