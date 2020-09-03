class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        for (int n = 0, i = 0, j = 0; n < target.length(); ++n) {
            int pos = target.charAt(n) - 'a', row = pos / 5, col = pos % 5;
            while (j > col) { // while loop of left (L) move before that of downward (D) move.
                sb.append('L');
                --j;
            }
            while (i > row) { // while loop of upward (U) move before that of right (R) move.
                sb.append('U');
                --i;
            }
            while (i < row) { // while loop of downward (D) move.
                sb.append('D');
                ++i;
            }
            while (j < col) { // while loop of right (R) move.
                sb.append('R');
                ++j;
            }
            sb.append('!');   
        }
        return sb.toString();
    }
}
