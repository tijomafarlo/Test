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
 * @author Jonatan
 */
public class ReadTxtFile
{
    public Map<String, Player> Read()
    {
        try
        {
            // Utiliser la variable passer en paramètre à la fonction.
            BufferedReader InputFile = new BufferedReader(new FileReader("test1.txt"));
            BufferedWriter OutputTest = new BufferedWriter (new FileWriter("testOut.txt"));
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
                    OutputTest.write(strTemp[i]);
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
            OutputTest.close();
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
}
