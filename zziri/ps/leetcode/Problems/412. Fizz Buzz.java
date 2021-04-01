// MEMO : Integer.toString(num) 방식으로도 호출 가능!

class Solution {
    public List<String> fizzBuzz(int n) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";

        List<String> ret = new ArrayList<>();
        for (Integer i=1; i<=n; i++) {
            if (i % 15 == 0) {
                ret.add(fizzBuzz);
            } else if (i % 3 == 0) {
                ret.add(fizz);
            } else if (i % 5 == 0) {
                ret.add(buzz);
            } else {
                ret.add(i.toString());
            }
        }
        
        return ret;
    }
}
