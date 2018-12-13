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
public class Structure extends Card{
   
    private int shieldLevel;
/**
 * Class constructor. Initialize object with class varibles
 * @param shieldLevel
 * @param name
 * @param attackLevel
 * @param defenseLevel
 * @param elixir
 * @param lifeLevel 
 */
    public Structure(int shieldLevel, String name, int attackLevel, int defenseLevel, int elixir, int lifeLevel) {
        super(name, attackLevel, defenseLevel, elixir, lifeLevel);
        this.shieldLevel = shieldLevel;
    }
    

    /**
     * Get the value of shieldLevel
     *
     * @return the value of shieldLevel
     */
    public int getShieldLevel() {
        return shieldLevel;
    }

    /**
     * Set the value of shieldLevel
     *
     * @param shieldLevel new value of shieldLevel
     */
    public void setShieldLevel(int shieldLevel) {
        this.shieldLevel = shieldLevel;
    }
/**
 * Calculate the value of defence
 * 
 * @return value of defence
 */
    @Override
    public int defense(){
        return this.shieldLevel*super.defense();
    }
     /**
     * Method that allows to represent any object as a string
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "name=" + super.getName() + ", attackLevel=" + super.getAttackLevel() + ", defenseLevel=" + super.getDefenseLevel() + ", elixir=" + super.getElixir() +
                ", lifeLevel=" + super.getLifeLevel() + ", shieldLevel=" + this.shieldLevel;
    }
}
