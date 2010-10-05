/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioncartes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Brainwasher
 */
public class Inventory
{
    private final static String FILE_PATH = "test2.txt";

    private IView _view = new OutputView();
    private Map<String, Player> _players = new HashMap<String, Player>();
    private IService _service = new FileService();

    /**
     * Read the players in a text file and put it in an HashMap
     */
    public void LoadPlayers()
    {
        _players = _service.Read(FILE_PATH);
    }

    /**
     * Run the application to manage inventory
     */
    public void ShowApplication()
    {
        Operations selection = Operations.ListPlayers;

        try
        {
            while (selection != Operations.Close)
            {
                selection = _view.showMainMenu();

                _view.showSelectedOperations(selection);

                switch(selection)
                {
                    case AddPlayer:
                        AddPlayer();
                        break;
                    case UpdatePlayer:
                        UpdatePlayer();
                        break;
                    case DeletePlayer:
                        DeletePlayer();
                        break;
                    case ShowPlayer:
                        ShowPlayer();
                        break;
                    case ListPlayers:
                        ListPlayers();
                        break;
                    case Save:
                        Save();
                        break;
                    case Close:
                        Close();
                        break;
                }
            }
        }
        catch(UnsupportedOperationException ex)
        {
            _view.showError(ex.getMessage());
        }
    }

    /**
     * Add a player
     */
    private void AddPlayer()
    {        
        Player selectedPlayer = _view.getPlayerInformations(_view.getPlayerId());
        _players.put(selectedPlayer.getId(), selectedPlayer);
        _view.showMessage(Messages.PlayerSaved);

        _view.waitEnter();
    }

    /**
     * Update a player with the user information
     */
    private void UpdatePlayer()
    {
        Player selectedPlayer = getPlayer();
        
        if(selectedPlayer != null)
        {
            _view.showPlayerInformations(selectedPlayer);
            _view.showMessage(Messages.EnterNewInformations);
            _players.put(selectedPlayer.getId(), _view.getPlayerInformations(selectedPlayer.getId()));
        }
        else
        {
            _view.showMessage(Messages.PlayerNotFound);
        }

        _view.waitEnter();
    }

    /**
     * Delete a player
     */
    private void DeletePlayer()
    {
        Player selectedPlayer = getPlayer();

        if(selectedPlayer != null)
        {
            _view.showQuestion(Questions.DeletePlayer);
            _players.remove(selectedPlayer.getId());
            _view.showMessage(Messages.PlayerDeleted, selectedPlayer.getName());
        }
        else
        {
            _view.showMessage(Messages.PlayerNotFound);
        }

        _view.waitEnter();
    }

    /**
     * Show player informations
     */
    private void ShowPlayer()
    {
        Player selectedPlayer = getPlayer();
        
        if(selectedPlayer != null)
        {
            _view.showPlayerInformations(selectedPlayer);
        }
        else
        {
            _view.showMessage(Messages.PlayerNotFound);
        }

        _view.waitEnter();
    }

    /**
     * Show all the players and can save it in a text file
     */
    private void ListPlayers()
    {
        if( _view.showQuestion(Questions.CreateListInFile) )
        {
            String filePath = _view.getFilePath();
            _service.Write(filePath, _players);
            _view.showMessage(Messages.ReportSaved);
        }
        else
        {
            for(Player player : _players.values())
            {
                _view.showPlayerInformations(player);
            }
        }

        _view.waitEnter();
    }

    /**
     * Save all the players in a text file
     */
    private void Save()
    {
        _view.showMessage(Messages.FileCreated, FILE_PATH);
        _service.Write(FILE_PATH, _players);
        _view.waitEnter();
    }

    /**
     * Close the text file
     */
    private void Close()
    {
        _view.showMessage(Messages.FileCreated, FILE_PATH);
        _view.showMessage(Messages.Thanks);

        _view.waitEnter();
    }

    /**
     * Return a player
     * @return
     */
    private Player getPlayer()
    {
        String playerId = _view.getPlayerId();

        if(_players.containsKey(playerId))
            return _players.get(playerId);
        else
            return null;
    }
}
