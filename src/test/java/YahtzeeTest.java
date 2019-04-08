import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YahtzeeTest {
    @Test
    public void appleSauce() {
        assertScoreEquals(2, "Ones", 1, 1, 2, 4, 4);
        assertScoreEquals(3, "Ones", 1, 1, 1, 4, 4);
        assertScoreEquals(2, "Twos", 1, 1, 2, 4, 4);
        assertScoreEquals(9, "Threes", 3, 3, 3, 4, 4);
        assertScoreEquals(8, "Fours", 1, 1, 2, 4, 4);
        assertScoreEquals(12, "Fours", 1, 1, 4, 4, 4);
        assertScoreEquals(5, "Fives", 1, 1, 4, 4, 5);
        assertScoreEquals(12, "Sixes", 1, 1, 4, 6, 6);

        assertScoreEquals(12, "Pair", 1, 1, 4, 6, 6);
        assertScoreEquals(0, "Pair", 1, 2, 4, 5, 6);

        assertScoreEquals(8, "TwoPairs", 1, 1, 2, 3, 3);

        assertScoreEquals(9, "ThreeOfAKind", 3, 3, 3, 4, 5);

        assertScoreEquals(8, "FourOfAKind", 2, 2, 2, 2, 5);

        assertScoreEquals(15, "SmallStraight", 5, 4, 3, 2, 1);

        assertScoreEquals(20, "LargeStraight", 5, 4, 3, 2, 6);

        assertScoreEquals(8, "FullHouse", 1, 1, 2, 2, 2);

        assertScoreEquals(50, "Yahtzee", 2, 2, 2, 2, 2);

        assertScoreEquals(8, "Chance", 1, 1, 2, 2, 2);



    }

    public void assertScoreEquals(int expected, String category, Integer... dice){
        Yahtzee yahtzee = new Yahtzee(dice);
        assertEquals(expected, yahtzee.check(category));
    }
}
