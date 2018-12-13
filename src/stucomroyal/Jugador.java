/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;
import java.util.*;

/**
 *
 * @author Yuli
 */
public class Jugador implements Comparable<Jugador> {

    private String name;
    private String password;
    private int trophyNumber;
    private ArrayList<Card> cards;
/**
 * Class constructor. Initialize object with class varibles
 * @param name
 * @param password 
 */
    public Jugador(String name, String password) {
        this.name = name;
        this.password = password;
        this.trophyNumber = 0;
        this.cards = new ArrayList<>();
    }

    /**
     * Get the value of cards
     *
     * @return the value of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Set the value of cards
     *
     * @param card new value of cards
     */
    public void setCards(Card card) {
        this.cards.add(card);
    }

    /**
     * Get the value of trophyNumber
     *
     * @return the value of trophyNumber
     */
    public int getTrophyNumber() {
        return trophyNumber;
    }

    /**
     * Set the value of trophyNumber
     *
     * @param trophyNumber new value of trophyNumber
     */
    public void setTrophyNumber(int trophyNumber) {
        this.trophyNumber = trophyNumber;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Compares this object with the specified object for order.
     *
     * @param j the object to be compared
     * @return a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Jugador j) {
        return Integer.compare(j.trophyNumber, this.trophyNumber);
    }

}
