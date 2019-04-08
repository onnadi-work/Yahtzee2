import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Yahtzee {
    public static final int YAHTZEE = 50;
    public static final int SMALL_STRAIGHT = 15;
    public static final int LARGE_STRAIGHT = 20;
    ArrayList<Integer> dice;

    public Yahtzee(Integer... is) {
        this.dice = new ArrayList<>();
        Collections.addAll(dice, is);
    }

    public int check(String category) {
        switch (category) {
            case "Fours":
                return scoreSingles(4);
            case "Ones":
                return scoreSingles(1);
            case "Twos":
                return scoreSingles(2);
            case "Threes":
                return scoreSingles(3);
            case "Fives":
                return scoreSingles(5);
            case "Sixes":
                return scoreSingles(6);
            case "Pair":
                return dice.stream().filter(this::isPair).mapToInt(i -> i).max().orElse(0)*2;
            case "TwoPairs":
                return dice.stream().filter(this::isPair).mapToInt(i -> i).sum();
            case "ThreeOfAKind":
                return dice.stream().filter(this::isThreeOfAKind).mapToInt(i -> i).sum();
            case "FourOfAKind":
                return dice.stream().filter(i->Collections.frequency(dice, i) == 4).mapToInt(i->i).sum();
            case "SmallStraight":
                return dice.containsAll(list(1, 2, 3, 4, 5)) ? SMALL_STRAIGHT : 0;
            case "LargeStraight":
                return dice.containsAll(list(2, 3, 4, 5, 6)) ? LARGE_STRAIGHT : 0;
            case "FullHouse":
                return hasPair() && hasThreeOfAKind() ? dice.stream().mapToInt(i->i).sum() : 0;
            case "Yahtzee":
                return dice.stream().allMatch(i -> i == dice.get(0)) ? YAHTZEE : 0;
            case "Chance":
                return dice.stream().mapToInt(i->i).sum();
        }

        return 0;
    }



    private boolean hasThreeOfAKind() {
        return dice.stream().filter(this::isThreeOfAKind).count() == 3;
    }

    private boolean hasPair() {
        return dice.stream().filter(this::isPair).count() == 2;
    }

    private ArrayList<Integer> list(Integer...is){
        ArrayList<Integer> returnValue = new ArrayList<>();
        Collections.addAll(returnValue, is);
        return returnValue;
    }
    private boolean isThreeOfAKind(int d) {
        return Collections.frequency(dice, d) == 3;
    }


    private boolean isPair(int d) {
        return Collections.frequency(dice, d) == 2;
    }

    private int scoreSingles(int i) {
        return Collections.frequency(dice, i) * i;
    }


}
