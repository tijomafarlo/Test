/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioncartes;

/**
 * Interface used to create an user interface to show and get informations.
 * @author Jimmy
 */
public interface IView
{
    /**
     * Wait that the user press enter to continue.
     */
    void waitEnter();

    /**
     * Show the main menu on user interface and return the operation 
     * selected by the user.
     * @return Selected operation.
     */
    Operations showMainMenu();

    /**
     * Show the operation selected by user in a text equivalent.
     * @param selected Selected operation.
     */
    void showSelectedOperations(Operations selected);
    /**
     * Show a message in user interface, without arguments.
     * @param message Message to be viewed.
     */
    void showMessage(Messages message);
    /**
     * Show a message in user interface, with arguments.
     * @param message Message to be viewed.
     * @param args Arguments to be added in message.
     */
    void showMessage(Messages message, Object args);
    /**
     * Show a question to user and return the answer.
     * @param question Question to be viewed.
     * @return Answer of question.
     */
    boolean showQuestion(Questions question);
    /**
     * Show a error message in user interface.
     * @param message Error message.
     */
    void showError(String message);
    /**
     * Show player informations in user interface except the id.
     * @param selected Player to be show his informations.
     */
    void showPlayerInformations(Player selected);

    /**
     * Ask to user the player id that he want.
     * @return Player id.
     */
    String getPlayerId();
    /**
     * Ask to user the player informations and return a fell player.
     * @param playerId Player to add informations.
     * @return Fell player.
     */
    Player getPlayerInformations(String playerId);
    /**
     * Ask to user the file path and return it.
     * @return File path.
     */
    String getFilePath();
}
