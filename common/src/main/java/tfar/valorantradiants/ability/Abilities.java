package tfar.valorantradiants.ability;

import java.util.HashMap;
import java.util.Map;

public class Abilities {

    private static final Map<String,Ability> MAP = new HashMap<>();
    public static final Ability WALL = register(new WallAbility());

    public static <A extends Ability> A register(A ability) {
        MAP.put(ability.name(),ability);
        return ability;
    }

    public static Ability getAbility(String s) {
        return MAP.get(s);
    }
}
