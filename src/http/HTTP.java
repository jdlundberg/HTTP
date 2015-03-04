package http;

/**
 *
 * @author Architect
 */
public class HTTP {

    public static void main(String[] args) {

        GetPokemonInfo getInfo = new GetPokemonInfo();

        /**
         * Correct usage of the getPokemonInfo method. This will return the
         * information for pokemon 137, Porygon.
         */
        System.out.println("Test 1: Correct usage");
        getInfo.getPokemonInfo(137);

        /**
         * Incorrect usage of the getPokemonInfo method. There are only 718
         * pokemon, so attempting to view number 845 will throw an exception.
         */
        System.out.println("Test 2: Attempting to access a pokemon that doesn't exist (845)");
        getInfo.getPokemonInfo(845);

        /* Another example of incorrect usage of the getPokemonInfo method.  If
         * a user attempts to access a negative number (-32), the application
         * will throw an exception.
         */
        System.out.println("Test 3: Attempting to access a pokemon that doesn't exist (-32)");
        getInfo.getPokemonInfo(-32);

    }

}
