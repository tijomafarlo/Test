/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioncartes;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Jonatan
 */
public class WriteTxtFile
{
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
