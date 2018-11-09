import java.util.HashMap;
class WordPatternII {

        HashMap<Character, String> map = new HashMap<>();

        public boolean wordPatternMatch(String pattern, String str) {
            return helper(pattern, 0, str, 0);
        }

        public boolean helper(String pattern, int pindex, String str, int sindex) {
            //base
            if (pindex == pattern.length() && sindex == str.length()) return true;
            if (pindex == pattern.length() || sindex == str.length()) return false;

            //get the pattern character
            Character p = pattern.charAt(pindex);

            //if pattern value exists
            if (map.containsKey(p)) {
                //check
                String s = map.get(p);
                if (!str.startsWith(s, sindex)) {
                    return false;
                }
                return helper(pattern, pindex + 1, str, sindex + s.length());
            }

            //the pattern character shows up first time
            for (int k = sindex; k < str.length(); k++) {
                String ss = str.substring(sindex, k + 1);


                //duplicates check?
                if (map.containsValue(ss)) {
                    continue;
                }

                map.put(p, ss);

                if (helper(pattern, pindex + 1, str, k + 1)) {
                    return true;
                }

                //really needed?
                map.remove(p);
            }

            return false;
        }


    public static void main(String[] args) {
            WordPatternII w = new WordPatternII();
            System.out.println(w.wordPatternMatch("abba","dogcatcatdog"));
    }

}

