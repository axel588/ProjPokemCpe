package fr.cpe.pokemongoplagiat.models;

public enum POKEMON_TYPE {
    Acier(0),
    Combat(1),
    Dragon(2),
    Eau(3),
    Electrique(4),
    Fee(5),
    Feu(6),
    Glace(7),
    Insecte(8),
    Normal(9),
    Plante(10),
    Poison(11),
    Psy(12),
    Roche(13),
    Sol(14),
    Spectre(15),
    Tenebre(16),
    Vol(17);

    private int val;

    private POKEMON_TYPE(int val) {
        this.val = val;
    }

    public static POKEMON_TYPE valueOf(int value) {
        for (POKEMON_TYPE e : POKEMON_TYPE.values()) {
            if (e.val == value) {
                return e;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}