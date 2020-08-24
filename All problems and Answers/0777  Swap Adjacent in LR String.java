class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;        // Add this one to make sure their length is same.
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        int p1 = 0;
        int p2 = 0;
        char[] ch1 = start.toCharArray();
        char[] ch2 = end.toCharArray();
        while (p1 < start.length()) {           
            while (p1 < ch1.length && ch1[p1] == 'X') p1++;
            while (p2 < ch2.length && ch2[p2] == 'X') p2++;
            if (p1 == ch1.length || p2 == ch2.length) return true;      // if one reach the end, the other one must reach the end too, since we have already check their order first.
            if (ch1[p1] == 'R' && p1 > p2) return false;
            if (ch1[p1] == 'L' && p1 < p2) return false;
            p1++;
            p2++;
        }

        return true;
    }
}
