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
public class Troop extends Card {

    private int strength;
/**
 * Class constructor. Initialize object with class varibles
 * @param strength
 * @param name
 * @param attackLevel
 * @param defenseLevel
 * @param elixir
 * @param lifeLevel 
 */
    public Troop(int strength, String name, int attackLevel, int defenseLevel, int elixir, int lifeLevel) {
        super(name, attackLevel, defenseLevel, elixir, lifeLevel);
        this.strength = strength;
    }

    /**
     * Get the value of strength
     *
     * @return the value of strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Set the value of strength
     *
     * @param strength new value of strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
      * Calculate the value of attack
     *
     * @return value of attac
     */   
    
    @Override
    public int attack() {
        return this.strength * super.attack();
    }
     /**
     * Method that allows to represent any object as a string
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "name=" + super.getName() + ", attackLevel=" + super.getAttackLevel() + ", defenseLevel=" + super.getDefenseLevel() + ", elixir=" + super.getElixir() +
                ", lifeLevel=" + super.getLifeLevel() + ", strength=" + this.strength;
    }
}
