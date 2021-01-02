class StringIterator {
    String compressedString;
    Character cur;
    int count;
    int i;
  
    public StringIterator(String compressedString) {
        this.compressedString = compressedString;
        this.cur = null;
        this.i = 0;
        this.count = 0;
    }
    
    public char next() {
        if (count == 0) {
            if (i >= compressedString.length()) {return ' ';}
            cur = compressedString.charAt(i++);
            while (i < compressedString.length() && compressedString.charAt(i) >= '0' && compressedString.charAt(i) <= '9') {
                count = 10 * count + (compressedString.charAt(i)-'0');
                i++;
            }
        }
        count--;
        return cur;
    }
    
    public boolean hasNext() {
        return i < compressedString.length() || count != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
