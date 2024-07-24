public class UniqueCharacters {
    public static boolean hasUniqueCharacters(String str) {
        if (str.length() > 128) {
            return false; // There are only 128 unique ASCII characters
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false; // Already found this char in string
            }
            charSet[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String testStr = "ABCD";
        System.out.println("Does \"" + testStr + "\" have all unique characters? " + hasUniqueCharacters(testStr));
    }
}
