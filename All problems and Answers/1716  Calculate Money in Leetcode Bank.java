class Solution {
    public int totalMoney(int n) {
        int monday = 1, cur = 1, bank = 0;
        for(int i = 1; i <= n; i++) {
                bank += cur;
                cur++;
            if (i % 7 == 0) {
                monday+=1;
                cur = monday;
            }
            
        }
        return bank;
    }
}
