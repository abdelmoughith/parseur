public class TokenManager {
    private String entreee;
    private int iCourant;

    public TokenManager(String entreee) {
        this.entreee = entreee;
    }
    char suivant() {
        if (iCourant < entreee.length()) {
            return entreee.charAt(iCourant++);
        } else {
            return '#';
        }
    }
}
