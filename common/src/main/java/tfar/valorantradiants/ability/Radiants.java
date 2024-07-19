package tfar.valorantradiants.ability;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Radiants {
    private static final Map<String,Radiant> MAP = new HashMap<>();
    public static final Radiant PHOENIX_FLAMES = register(new Radiant("phoenix_flames",Set.of(Abilities.WALL)));

    public static Radiant register(Radiant radiant) {
        MAP.put(radiant.name(),radiant);
        return radiant;
    }

    public static Radiant getRadiant(String s) {
        return MAP.get(s);
    }
}
