package week7_first_classes.KnockOut;


public class Player {

    private String name;
    private boolean knockedOut;
    private int knockOutNumber;


    Player(String name) {
        this.name = name;
        this.knockedOut = false;
    }

    String playTurn(DiceCup cup) {

        int score = cup.rollAll();

        if (isKnockout(score)) {
            knockedOut = true;
        }

        String resultTemplate = "Player %s rolled a total of %d and %s knocked out. (Your knockout number is %d)";
        String result = String.format(resultTemplate, name, score, knockedOut ? "was" : "was not", knockOutNumber);

        return result;
    }



    private boolean isKnockout(int score) {
        return (score == knockOutNumber);
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
