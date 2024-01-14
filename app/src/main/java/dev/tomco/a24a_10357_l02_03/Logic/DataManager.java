package dev.tomco.a24a_10357_l02_03.Logic;

import java.util.ArrayList;

import dev.tomco.a24a_10357_l02_03.Model.Country;
import dev.tomco.a24a_10357_l02_03.R;

public class DataManager {

    private static String[] names = new String[]{
            "Italy",
            "Lebanon",
            "Iraq",
            "Syria",
            "China",
            "Japan",
            "Kazakhstan",
            "Jordan",
            "Iran",
            "Czech Republic",
            "Swaziland",
            "Vietnam",
            "Singapore",
            "Libya",
            "Mexico"
    };
    private static int[] flagImages = new int[]{
            R.drawable._013_italy,
            R.drawable._018_lebanon,
            R.drawable._020_iraq,
            R.drawable._022_syria,
            R.drawable._034_china,
            R.drawable._063_japan,
            R.drawable._074_kazakhstan,
            R.drawable._077_jordan,
            R.drawable._136_iran,
            R.drawable._149_czech_republic,
            R.drawable._154_swaziland,
            R.drawable._220_vietnam,
            R.drawable._230_singapore,
            R.drawable._231_libya,
            R.drawable._252_mexico
    };
    private static boolean[] canEnter = new boolean[]{
            true,
            false,
            false,
            false,
            true,
            true,
            true,
            true,
            false,
            true,
            true,
            true,
            true,
            false,
            true
    };

    public static ArrayList<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            countries.add(new Country()
                    .setName(names[i])
                    .setFlagImage(flagImages[i])
                    .setCanEnter(canEnter[i]));
        }
        return countries;
    }
}
