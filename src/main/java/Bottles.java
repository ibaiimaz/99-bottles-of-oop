import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bottles {

    public String song() {
        return verses(99, 0);
    }

    public String verses(int starting, int ending) {
        return reverseIntRange(starting, ending).mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }

    public String verse(int number) {
        return capitalize(quantity(number)) + " " + container(number) + " of beer on the wall, " +
                quantity(number) + " " + container(number) + " of beer.\n" +
                action(number) + ", " +
                quantity(succesor(number)) + " " + container(succesor(number)) + " of beer on the wall.\n";
    }

    private String container(int number) {
        if (number == 1) {
            return "bottle";
        } else {
            return "bottles";
        }
    }

    private String quantity(int number) {
        if (number == 0) {
            return "no more";
        } else {
            return String.valueOf(number);
        }
    }

    private String pronoun(int number) {
        if (number == 1) {
            return "it";
        } else {
            return "one";
        }
    }

    private String action(int number) {
        if (number == 0) {
            return "Go to the store and buy some more";
        } else {
            return "Take " + pronoun(number) + " down and pass it around";
        }
    }

    private int succesor(int number) {
        if (number == 0) {
            return 99;
        } else {
            return number - 1;
        }
    }

    private IntStream reverseIntRange(int to, int from)
    {
        return IntStream.rangeClosed(from + 1, to + 1).map(i -> to - i + from +  1 );
    }

    private String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
