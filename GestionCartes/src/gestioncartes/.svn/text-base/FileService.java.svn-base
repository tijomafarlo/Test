/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioncartes;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author daudj00
 */
public class FileService implements IService
{
    /**
     * Read a txt file containing the players informations
     * @param filepath
     * @return
     */
    public Map<String, Player> Read(String filepath)
    {
        try
        {
            // Utiliser la variable passer en paramètre à la fonction.
            BufferedReader InputFile = new BufferedReader(new FileReader(filepath));
            String strInput;
            String[] strTemp;
            Map<String, Player> joueur = new HashMap<String, Player>();
            ArrayList<String[]> players = new ArrayList<String[]>();
            ArrayList<Card> cardList = new ArrayList<Card>();
            String titreCarte = "";
            String nomEquipe = "";
            int anneSortie = 0;

            while ((strInput = InputFile.readLine())!=null)
            {
                strTemp = strInput.split(";");
                for (int i=0; i<strTemp.length;i++)
                {
                    strTemp[i] = strTemp[i].replaceAll("\"", "");
                }
                String cle = strTemp[0];
                String nomJoueur = strTemp[1];
                int nombreCartes = Integer.parseInt(strTemp[2]);
                for (int i=3;i<nombreCartes*3;i++)
                {
                    int modulo = i%3;
                    switch(modulo)
                    {
                        case 0:
                            titreCarte = strTemp[i];
                            break;
                        case 1:
                            nomEquipe = strTemp[i];
                            break;
                        case 2:
                            anneSortie = Integer.parseInt(strTemp[i]);
                            Card carte = new Card(titreCarte, nomEquipe, anneSortie);
                            cardList.add(carte);
                            break;
                    }
                }
                players.add(strTemp);
                Player nouveau = new Player(cle, nomJoueur, cardList);
                joueur.put(cle,nouveau);
            }
            InputFile.close();
            return joueur;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        //si le fichier ne contient aucun joueur, retourne une liste vide
        Map<String, Player> listeVide = new HashMap<String, Player>();
        return listeVide;
    }

    /**
     * Write in a text file the players informations
     * @param fileName
     * @param playerList
     */
    public void Write(String fileName, Map<String, Player> playerList)
    {
        try
        {
            BufferedWriter output = new BufferedWriter (new FileWriter(fileName));
            String outputText = "";
            for (Map.Entry<String,Player> e : playerList.entrySet())
            {
                ArrayList<Card> cardList = new ArrayList<Card>();
                outputText = outputText + '"' + e.getValue().getId() + '"' + '\u003b';
                outputText = outputText + '"' + e.getValue().getName() + '"' + '\u003b';
                cardList = e.getValue().getCards();
                outputText = outputText + '"' + cardList.size()+ '"' + '\u003b';
                for (int i = 0; i < cardList.size(); i++)
                {
                    outputText = outputText + '"' + cardList.get(i).getTitle() + '"' + '\u003b';
                    outputText = outputText + '"' + cardList.get(i).getTeam() + '"' + '\u003b';
                    outputText = outputText + '"' + cardList.get(i).getYear() + '"' + '\u003b';
                }
                outputText = outputText + "\n";
            }
            output.write(outputText);
            output.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
