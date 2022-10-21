class Solution {
    public String intToRoman(int num) {
        if(num == 0) {
            return "0";
        }

        String s = "";

        String[] mapping = new String[] {
          "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] places = new int[] {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        for(int i = 0; i<places.length; i++) {
            int place = places[i];
            int digit = num / place;

            if(digit != 0) {
                String symbol = mapping[i];
                s+= getRomanSymbol(digit, symbol);
            }

            num = num % place;
        }

        return s;
    }

    private String getRomanSymbol(int n, String symbol) {
        StringBuilder sb = new StringBuilder("");
        while(n-- > 0) {
            sb.append(symbol);
        }

        return sb.toString();
    }
}
