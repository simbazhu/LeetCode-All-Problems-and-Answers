class Solution {
	public int kthGrammar(int N, int K) {
        return kth(K - 1);
    }
    
    public int kth(int K){
        if(K == 0)      return 0;        
        if(K % 2 == 0)  return kth(K / 2);
        else            return reverse(kth(K / 2));
    }
    
    private int reverse(int val){
        return val == 0 ? 1 : 0;
    }
}
