/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioncartes;

/**
 *
 * @author fortj04
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();

        inventory.LoadPlayers();
        inventory.ShowApplication();
    }
}
