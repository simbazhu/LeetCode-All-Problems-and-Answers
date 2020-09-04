class Solution {
    public class Transaction {
        String name;
        int time;
        String city;
        String trans;
        
        public Transaction(String name, int time, String city, String trans) {
            this.name = name;
            this.time = time;
            this.city = city;
            this.trans = trans;
        }
    }
    
    public List<String> invalidTransactions(String[] transactions) {
        Set<String> out = new HashSet<>();
        
        Map<String, List<Transaction>> perPerson = new HashMap<>();
        
        for(String trans : transactions) {
            String[] split = trans.split(",");
            
            String name = split[0];
            int time = Integer.valueOf(split[1]);
            int amount = Integer.valueOf(split[2]);
            String city = split[3];
            
            if(amount > 1000) {
                out.add(trans);
            }
            
            List<Transaction> otherTransactions = perPerson.get(name);
            
            if(otherTransactions == null) {
                otherTransactions = new ArrayList<>();
                otherTransactions.add(new Transaction(name, time, city, trans));
                perPerson.put(name, otherTransactions);
            } else {
                for(Transaction transa : otherTransactions) {
                    if(!transa.city.equals(city) && Math.abs(transa.time - time) <= 60) {
                        out.add(transa.trans);
                        out.add(trans);
                    }
                }
                
                otherTransactions.add(new Transaction(name, time, city, trans));
            }
        }
        
        return new ArrayList<String>(out);
    }
}
