package http;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.quickconnectfamily.json.JSONInputStream;

/**
 *
 * @author Architect
 */
public class GetPokemonInfo {

    private HashMap readUrl(String urlString) throws Exception {

        JSONInputStream inFromURL = null;
        Object in;

        try {

            URL url = new URL(urlString);
            inFromURL = new JSONInputStream(url.openStream());
            in = inFromURL.readObject();
            HashMap pokeInfo = (HashMap) in;

            return pokeInfo;

        } finally {

            if (inFromURL != null) {

                inFromURL.close();

            }

        }

    }

    public void getPokemonInfo(Integer pokeNumber) {

        HashMap pokeType;
        ArrayList pokeList;
        Integer numTypes;

        try {

            HashMap pokeURL = readUrl("http://pokeapi.co/api/v1/pokemon/" + pokeNumber + "/");
            pokeList = (ArrayList) pokeURL.get("types");
            numTypes = pokeList.size();

            System.out.println("\nPokemon Number: " + " " + pokeURL.get("national_id"));
            System.out.println("Name: " + " " + pokeURL.get("name"));

            for (int i = 0; i < numTypes; i++) {

                pokeType = (HashMap) pokeList.get(i);

                System.out.println("Type " + (i + 1) + ": " + pokeType.get("name"));

            }

        } catch (Exception e) {

            if (pokeNumber > 718) {

                System.err.println("There are currently only 718 pokemon on record.  Please select a number between 1 and 718.");
                System.out.println("");

            } else if (pokeNumber < 1) {

                System.err.println("There are no negatively numbered pokemon (yet).  Please select a number between 1 and 718.");
                System.out.println("");

            }

        }

    }

}
