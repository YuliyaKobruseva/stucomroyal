/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

/**
 *
 * @author Yuli
 */
public abstract class Card implements Cloneable {

    private String name;
    private int attackLevel;
    private int defenseLevel;
    private int elixir;
    private int lifeLevel;

    /**
     * Class constructor. Initialize object with class varibles
     *
     * @param name (string) name of card
     * @param attackLevel (int) attack level of card
     * @param defenseLevel (int) defence level of card
     * @param elixir (int) elixir value of card
     * @param lifeLevel (int) life level of card
     */
    public Card(String name, int attackLevel, int defenseLevel, int elixir, int lifeLevel) {
        this.name = name;
        this.attackLevel = attackLevel;
        this.defenseLevel = defenseLevel;
        this.elixir = elixir;
        this.lifeLevel = lifeLevel;
    }

    /**
     * Get the value of lifeLevel
     *
     * @return the value of lifeLevel
     */
    public int getLifeLevel() {
        return lifeLevel;
    }

    /**
     * Set the value of lifeLevel
     *
     * @param lifeLevel new value of lifeLevel
     */
    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }

    /**
     * Get the value of elixir
     *
     * @return the value of elixir
     */
    public int getElixir() {
        return elixir;
    }

    /**
     * Set the value of elixir
     *
     * @param elixir new value of elixir
     */
    public void setElixir(int elixir) {
        this.elixir = elixir;
    }

    /**
     * Get the value of defenseLevel
     *
     * @return the value of defenseLevel
     */
    public int getDefenseLevel() {
        return defenseLevel;
    }

    /**
     * Set the value of defenseLevel
     *
     * @param defenseLevel new value of defenseLevel
     */
    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    /**
     * Get the value of attackLevel
     *
     * @return the value of attackLevel
     */
    public int getAttackLevel() {
        return attackLevel;
    }

    /**
     * Set the value of attackLevel
     *
     * @param attackLevel new value of attackLevel
     */
    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that calculate and return force of attack
     *
     * @return (int) force of attack
     */
    public int attack() {
        return this.attackLevel;
    }

    /**
     * Method that calculate and return defence level of card
     *
     * @return (int) defence level of card
     */
    public int defense() {
        return this.defenseLevel;
    }

    /**
     * Method that allows to clone object
     *
     * @return Object clone
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Method that allows to represent any object as a string
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "name=" + name + ", attackLevel=" + attackLevel + ", defenseLevel=" + defenseLevel + ", elixir=" + elixir + ", lifeLevel=" + lifeLevel;
    }

}
