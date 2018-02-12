package com.lightningmonkey.dragons.representations;

//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import io.dropwizard.validation.OneOf;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@DynamoDBTable(tableName = "player_character")
public class CharacterDB {
    private String id;
    private String characterFirstName;
    private String characterLastName;
    private String playerFirstName;
    private String playerLastName;

    @NotEmpty
    private String raceId; //Should be an id to a premade races

    @NotEmpty
    private String characterClass;

    @NotEmpty
    @OneOf(value={"lawful_good", "lawful_neutral", "lawful_evil",
    "neutral_good", "true_neutral", "neutral_evil",
    "chaotic_good", "chaotic_neutral", "chaotic_evil",})
    private String alignment;

    @Min(1)
    @Max(20)
    private Integer level;

    @Min(1)
    private Integer XP;

    @Min(1)
    private Integer maxHP;
    private Integer currentHP;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer strength;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer dexterity;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer constitution;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer intelligence;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer wisdom;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer charisma;


    public CharacterDB(){
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

//    public CharacterDB(CharacterForm characterForm){
//        this.id = characterForm.getId();
//        this.characterFirstName = characterForm.getCharacterFirstName();
//        this.characterLastName = characterForm.getCharacterLastName();
//        this.playerFirstName = characterForm.getCharacterFirstName();
//        this.playerLastName = characterForm.getPlayerLastName();
//        this.playerFirstName = characterForm.getCharacterFirstName();
//        this.raceId = characterForm.getRaceId();
//        this.characterClass = characterForm.getCharacterClass();
//        this.alignment = characterForm.getAlignment();
//        this.level = characterForm.getLevel();
//        this.XP = characterForm.getXP();
//        this.strength = characterForm.getStrength();
//        this.dexterity = characterForm.getDexterity();
//        this.constitution = characterForm.getConstitution();
//        this.intelligence = characterForm.getIntelligence();
//        this.wisdom = characterForm.getWisdom();
//        this.charisma = characterForm.getCharisma();
//    }

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharacterFirstName() {
        return characterFirstName;
    }

    public void setCharacterFirstName(String characterFirstName) {
        this.characterFirstName = characterFirstName;
    }

    public String getCharacterLastName() {
        return characterLastName;
    }

    public void setCharacterLastName(String characterLastName) {
        this.characterLastName = characterLastName;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getXP() {
        return XP;
    }

    public void setXP(Integer XP) {
        this.XP = XP;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }

    public Integer getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(Integer currentHP) {
        this.currentHP = currentHP;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    @Override
    public String toString() {
        return "CharacterDB{" +
                "id='" + id + '\'' +
                ", characterFirstName='" + characterFirstName + '\'' +
                ", characterLastName='" + characterLastName + '\'' +
                ", playerFirstName='" + playerFirstName + '\'' +
                ", playerLastName='" + playerLastName + '\'' +
                ", raceId='" + raceId + '\'' +
                ", characterClass='" + characterClass + '\'' +
                ", alignment='" + alignment + '\'' +
                ", level=" + level +
                ", XP=" + XP +
                ", maxHP=" + maxHP +
                ", currentHP=" + currentHP +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                '}';
    }
}

