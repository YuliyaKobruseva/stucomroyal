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
public class Spell extends Card{
    
    private int scope;
/**
 * Class constructor. Initialize object with class varibles
 * @param scope
 * @param name
 * @param attackLevel
 * @param defenseLevel
 * @param elixir
 * @param lifeLevel 
 */
    public Spell(int scope, String name, int attackLevel, int defenseLevel, int elixir, int lifeLevel) {
        super(name, attackLevel, defenseLevel, elixir, lifeLevel);
        this.scope = scope;
    }
    

    /**
     * Get the value of scope
     *
     * @return the value of scope
     */
    public double getScope() {
        return scope;
    }

    /**
     * Set the value of scope
     *
     * @param scope new value of scope
     */
    public void setScope(int scope) {
        this.scope = scope;
    }

    /**
     * Calculate the value of attack
     * 
     * @return value of attack
     */
    @Override
    public int attack(){
        return this.scope+super.attack();
    }
    
    /**
     * Calculate the value of defence
     * 
     * @return value of defence
     */
    @Override
    public int defense(){
        return this.scope+super.defense();
    }
 /**
     * Method that allows to represent any object as a string
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "name=" + super.getName() + ", attackLevel=" + super.getAttackLevel() + ", defenseLevel=" + super.getDefenseLevel() + ", elixir=" + super.getElixir() +
                ", lifeLevel=" + super.getLifeLevel() + ", scope=" + this.scope;
    }   
}
