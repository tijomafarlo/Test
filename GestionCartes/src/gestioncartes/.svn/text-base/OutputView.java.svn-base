/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioncartes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jimmy
 */
public class OutputView implements IView
{
    /**
     * Clean the interface to show new texts.
     */
    private void clean()
    {
        for(int i = 0; i < 100; i++)
        {
            showLine();
        }
    }

    /**
     * Show an empty line.
     */
    private void showLine()
    {
        System.out.println();
    }

    /**
     * Show a line with specific text.
     * @param text Text to be viewed.
     */
    private void showLine(String text)
    {
        System.out.println(text);
    }

    /**
     * Show a line with specific formated text.
     * @param format Text format.
     * @param args Text arguments.
     */
    private void showLine(String format, Object args)
    {
        System.out.printf(format, args);
        System.out.println();
    }

    /**
     * Show a line with specific text and return user inputs in string.
     * @param text Text to be viewed.
     * @return User inputs.
     */
    private String showLineAndGetString(String text)
    {
        Scanner in = new Scanner(System.in);

        System.out.print(text);
        return in.next();
    }

    /**
     * Show a line with specific formated text and return user inputs in string.
     * @param format Text format.
     * @param args Text arguments.
     * @return User inputs.
     */
    private String showLineAndGetString(String format, Object args)
    {
        Scanner in = new Scanner(System.in);

        System.out.printf(format, args);
        return in.next();
    }

    /**
     * Show a line with specific text and return user inputs in integer.
     * @param text Text to be viewed.
     * @return User inputs.
     */
    private int showLineAndGetInt(String text)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print(text);
        return in.nextInt();
    }

    /**
     * Show a line with specific formated text and return user inputs in interger.
     * @param format Text format.
     * @param args Text arguments.
     * @return User inputs.
     */
    private int showLineAndGetInt(String format, Object args)
    {
        Scanner in = new Scanner(System.in);

        System.out.printf(format, args);
        return in.nextInt();
    }

    /**
     * Wait that the user press enter to continue.
     */
    public void waitEnter()
    {
        showLineAndGetString("Appuyer sur Enter pour continuer...");
    }

    /**
     * Show the main menu on user interface and return the operation
     * selected by the user.
     * @return Selected operation.
     */
    public Operations showMainMenu()
    {
        int selection;

        clean();
        showLine("Application de gestion de cartes de baseball");
        showLine();
        showLine("Voici la liste d'opérations valides :");
        showLine();
        showLine("1. Ajouter un joueur");
        showLine("2. Afficher l'information d'un joueur");
        showLine("3. Mise à jour de l'information d'un joueur");
        showLine("4. Effacer l'information d'un joueur");
        showLine("5. Liste des joueurs");
        showLine("6. Sauvegarde");
        showLine("0. Sortir");
        showLine();
        selection = showLineAndGetInt("Votre sélection : ");

        if(selection < 0 || selection > 6)
            throw new UnsupportedOperationException( selection + " n'est pas une opération supportée.");

        switch(selection)
        {
            case 1:
                return Operations.AddPlayer;
            case 2:
                return Operations.ShowPlayer;
            case 3:
                return Operations.UpdatePlayer;
            case 4:
                return Operations.DeletePlayer;
            case 5:
                return Operations.ListPlayers;
            case 6:
                return Operations.Save;
            default:
                return Operations.Close;
        }
    }

    /**
     * Show the operation selected by user in a text equivalent.
     * @param selected Selected operation.
     */
    public void showSelectedOperations(Operations selected)
    {
        String operationName = "";

        clean();

        switch(selected)
        {
            case AddPlayer:
                operationName = "1. Ajouter un joueur";
                break;
            case ShowPlayer:
                operationName = "2. Afficher l'information d'un joueur";
                break;
            case UpdatePlayer:
                operationName = "3. Mise à jour de l'information d'un joueur";
                break;
            case DeletePlayer:
                operationName = "4. Effacer l'information d'un joueur";
                break;
            case ListPlayers:
                operationName = "5. Liste des joueurs";
                break;
            case Save:
                operationName = "6. Sauvegarde";
                break;
            case Close:
                operationName = "0. Sortir";
                break;
        }

        showLine("Option sélectionné : %1$s", operationName);
        showLine();
    }

    /**
     * Show a message in user interface, without arguments.
     * @param message Message to be viewed.
     */
    public void showMessage(Messages message)
    {
        showMessage(message, "");
    }

    /**
     * Show a message in user interface, with arguments.
     * @param message Message to be viewed.
     * @param args Arguments to be added in message.
     */
    public void showMessage(Messages message, Object args)
    {
        System.out.println();

        switch(message)
        {
            case PlayerSaved:
                showLine("L'enregistrement du joueur a réussi.");
                break;
            case EnterNewInformations:
                showLine("Maintenant entrez les données à modifier :");
                break;
            case PlayerInformations:
                showLine("Voici l'information sauvegardé de : %1$s", args);
                break;
            case PlayerDeleted:
                showLine("L'information du joueur %1$s a été efface du système.", args);
                break;
            case PlayerNotFound:
                showLine("Le joueur demandé n'a pas été trouvé.");
                break;
            case ReportSaved:
                showLine("Le rapport a été crée avec succès.");
                break;
            case FileCreated:
                showLine("Le fichier %1$s a été créé avec succès.", args);
                break;
            case Thanks:
                showLine("Merci d'avoir utilisé le système de gestion d'inventaire de cartes.");
                break;
        }

        System.out.println();
    }

    /**
     * Show a question to user and return the answer.
     * @param question Question to be viewed.
     * @return Answer of question.
     */
    public boolean showQuestion(Questions question)
    {
        System.out.println();

        String value;
        boolean predicat = false;

        switch(question)
        {
            case DeletePlayer:
                value = showLineAndGetString("Voulez vous effacer l'information de ce joueur ? (O/N) : ");

                if( !value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("N"))
                    throw new UnsupportedOperationException(value + " n'est pas une valeur supportée.");

                predicat = value.equalsIgnoreCase("O");
                break;
            case CreateListInFile:
                showLine("Voulez vous creer la liste des joueurs dans un fichier ou");
                value = showLineAndGetString("l'afficher sur l'ecran ? (F/E) : ");

                if( !value.equalsIgnoreCase("F") && !value.equalsIgnoreCase("E"))
                    throw new UnsupportedOperationException(value + " n'est pas une valeur supportée.");

                predicat = value.equalsIgnoreCase("F");
                break;
        }

        System.out.println();
        return predicat;
    }

    /**
     * Show a error message in user interface.
     * @param message Error message.
     */
    public void showError(String message)
    {
        System.err.println(message);
    }

    /**
     * Show player informations in user interface except the id.
     * @param selected Player to be show his informations.
     */
    public void showPlayerInformations(Player selected)
    {
        int cardCount = selected.getCards().size();

        showLine("Voici l'information sauvegardé de : %1$s", selected.getName());
        showLine();

        if(cardCount > 1)
            showLine("Le joueur a %1$s cartes enregistrées", cardCount);
        else
            showLine("Le joueur a 1 carte enregistrée");

        showLine();

        for(int i = 0; i < cardCount; i++)
        {
            int cardNumber = i + 1;
            
            showLine("Carte %1$s :", cardNumber);
            showLine("   Titre : %1$s", selected.getCards().get(i).getTitle());
            showLine("   Équipe : %1$s", selected.getCards().get(i).getTeam());
            showLine("   Année de parution : %1$s", selected.getCards().get(i).getYear());
        }
    }

    /**
     * Ask to user the player id that he want.
     * @return Player id.
     */
    public String getPlayerId()
    {
        return showLineAndGetString("Entrez la clé d'identification du joueur : ");
    }

    /**
     * Ask to user the player informations and return a fell player.
     * @param playerId Player to add informations.
     * @return Fell player.
     */
    public Player getPlayerInformations(String playerId)
    {
        String name = showLineAndGetString("Entrez le nom du joueur : ");
        int cardCount = showLineAndGetInt("Combien de cartes? : ");
        ArrayList<Card> cards = new ArrayList<Card>(cardCount);

        for(int i = 0; i < cardCount; i ++)
        {
            int cardNumber = i + 1;
            
            String title = showLineAndGetString("Entrez le titre de la carte %1$s : ", cardNumber);
            String team = showLineAndGetString("   Entrez l’équipe de la carte %1$s : ", cardNumber);
            int year = showLineAndGetInt("   Entrez l’année de parution de la carte %1$s : ", cardNumber);

            cards.add(new Card(title, team, year));
        }

        return new Player(playerId, name, cards);
    }

    /**
     * Ask to user the file path and return it.
     * @return File path.
     */
    public String getFilePath()
    {
        return showLineAndGetString("Entrez le nom du fichier : ");
    }
}
