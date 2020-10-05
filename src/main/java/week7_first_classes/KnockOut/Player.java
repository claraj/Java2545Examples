package week7_first_classes.KnockOut;


public class Player {

    private String name;
    private boolean knockedOut;
    private int knockOutNumber;


    Player(String name) {
        this.name = name;
        this.knockedOut = false;
    }


    // Plays one turn for this player
    public String playTurn(DiceCup cup) {

        int score = cup.rollAll();

        if (playerKnockedOut(score)) {
            knockedOut = true;
        }

        String resultTemplate = "Player %s rolled a total of %d and %s knocked out. (Your knockout number is %d)";
        String result = String.format(resultTemplate, name, score, knockedOut ? "was" : "was not", knockOutNumber);

        return result;
    }


    // Identifies if the value on the dice is the same as the chosen knockout number
    private boolean playerKnockedOut(int score) {

        if (score == knockOutNumber) {
            return true;
        } else {
            return false;
        }
    }


    public int getKnockOutNumber() {
        return knockOutNumber;
    }

    public void setKnockOutNumber(int knockOutNumber) {
        this.knockOutNumber = knockOutNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKnockedOut() {
        return knockedOut;
    }
    
}
