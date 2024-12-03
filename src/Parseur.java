public class Parseur {
    private TokenManager tm;
    private char tc; // current token

    public Parseur(TokenManager tm) {
        this.tm = tm;
        this.tc = tm.suivant();
    }

    public void consomer(char attendu) {
        if (tc == attendu)
            avance();
        else
            throw new RuntimeException("Expected token '" + attendu + "', but found '" + tc + "'");
    }

    private void avance() {
        tc = tm.suivant();
    }

    // S → bSb
    // S → cAc
    private void S() {
        if (tc == 'b') {
            consomer('b');
            S();
            consomer('b');
        } else if (tc == 'c') {
            consomer('c');
            A();
            consomer('c');
        } else {
            throw new RuntimeException("Unexpected token in S: " + tc);
        }
    }

    // A → bAA
    // A → cASAb
    // A → dcb
    private void A() {
        if (tc == 'b') {
            consomer('b');
            A();
            A();
        } else if (tc == 'c') {
            consomer('c');
            A();
            S();
            consomer('A');
            consomer('b');
        } else if (tc == 'd') {
            consomer('d');
            consomer('c');
            consomer('b');
        } else {
            throw new RuntimeException("Unexpected token in A: " + tc);
        }
    }

    public void parse() {
        S();
        if (tc != '#') {
            throw new RuntimeException("Unexpected trailing characters.");
        }
    }
}
