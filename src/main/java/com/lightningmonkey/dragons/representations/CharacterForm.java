package com.lightningmonkey.dragons.representations;

public class CharacterForm {
    private String id;
    private String characterFirstName;
    private String characterLastName;
    private String playerFirstName;
    private String playerLastName;

    private String raceId; //Should be an id to a premade races
    private String characterClass;
    private String alignment;
    private Integer level;
    private Integer XP;
    private Integer maxHP;
    private Integer currentHP;

    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;

    public CharacterForm() {
        this.id = null;
        this.characterFirstName = null;
        this.characterLastName = null;
        this.playerFirstName = null;
        this.playerLastName = null;
        this.raceId = null;
        this.characterClass = null;
        this.alignment = null;
        this.level = null;
        this.XP = null;
        this.maxHP = null;
        this.currentHP = null;
        this.strength = null;
        this.dexterity = null;
        this.constitution = null;
        this.intelligence = null;
        this.wisdom = null;
        this.charisma = null;
    }

    public CharacterForm(String id, String characterFirstName, String characterLastName, String playerFirstName, String playerLastName, String raceId, String characterClass, String alignment, Integer level, Integer XP, Integer maxHP, Integer currentHP, Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charisma) {
        this.id = id;
        this.characterFirstName = characterFirstName;
        this.characterLastName = characterLastName;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.raceId = raceId;
        this.characterClass = characterClass;
        this.alignment = alignment;
        this.level = level;
        this.XP = XP;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public String getId() {
        return id;
    }

    public String getCharacterFirstName() {
        return characterFirstName;
    }

    public String getCharacterLastName() {
        return characterLastName;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public String getAlignment() {
        return alignment;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getXP() {
        return XP;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public Integer getCurrentHP() {
        return currentHP;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public Integer getCharisma() {
        return charisma;
    }
}
