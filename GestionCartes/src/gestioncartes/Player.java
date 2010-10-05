/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioncartes;

import java.util.ArrayList;

/**
 *
 * @author fortj04
 */
public class Player
{
    private String _id;
    private String _name;
    private ArrayList<Card> _cards;
    /**
     * Player constructor
     * @param id
     * @param name
     * @param ArrayList of cards
     */
    Player(String id, String name, ArrayList<Card> cards)
    {
        _id = id;
        _name = name;
        _cards = cards;
    }
    /**
     * Return the player id
     * @return
     */
    String getId()
    {
        return _id;
    }
    /**
     * Return the player name
     * @return
     */
    String getName()
    {
        return _name;
    }
    /**
     * Return an ArrayList of the player cards
     * @return
     */
    ArrayList<Card> getCards()
    {
        return _cards;
    }
}
