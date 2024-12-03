public class Main {
    public static void main(String[] args) {
        String[] testCases = { "cdcbc", "bcdcbcb", "cbdcbdcbc", "ccdcbcdcbcdcbbcr", "cdcbbb", "cdcb", "" };

        for (String test : testCases) {
            TokenManager tm = new TokenManager(test);
            Parseur p = new Parseur(tm);
            try {
                p.parse();
                System.out.println(test + " is valid.");
            } catch (RuntimeException e) {
                System.out.println(test + " is not valid: " + e.getMessage());
            }
        }
    }
}
