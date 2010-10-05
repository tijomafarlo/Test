/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioncartes;

import java.util.Map;

/**
 *
 * @author daudj00
 */
public interface IService
{
    /**
     * Read a all the players and cards in a formatted text file
     * @param file path
     * @return Map of players and card
     */
    public Map<String, Player> Read(String filepath);

    /**
     * Write in a text file the content of a Map of Players
     * @param file name
     * @param player list
     */
    public void Write(String fileName, Map<String, Player> playerList);
}
