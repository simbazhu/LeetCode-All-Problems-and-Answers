class Solution {
    public static String COLON = ":";
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> rslt = new ArrayList<>();
        
        Set<String> qset = new HashSet<>();
        for(int[] qpos:queens){
            String str = qpos[0] + COLON + qpos[1];
            qset.add(str);
        }
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                for(int k = 1; k <= 8; k++){
                    int xpos = king[0] + i*k;
                    int ypos = king[1] + j*k;
                    String ts = xpos + COLON + ypos;
                    if (qset.contains(ts)){
                        rslt.add(Arrays.asList(xpos,ypos));
                        break;
                    }
                }
            }
        }
        return rslt;
    }
}
