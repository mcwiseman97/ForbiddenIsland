/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.view.MainMenuView;
import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.forbiddenisland.exceptions.GameControlException;
import citbyui.cit260.model.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
public class StartProgramView extends View {

    public StartProgramView() {
    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];

        //DISPLAYS BANNER PAGE
        this.console.println("***************************************************************************");
        this.console.println("*  You are stuck on an island and the only way off is to collect all      *\n"
                + "*  the treasure and fly away.  But it’s not as easy as it sounds.  As     *\n"
                + "*  you are collecting the treasure, the island is being flooded!  You     *\n"
                + "*  need to hurry! Collect all the treasure as fast as you can and leave   *\n"
                + "*  before you become stuck, with no escape.                               *");
        this.console.println("***************************************************************************");

        inputs[0] = this.getInput("What is your name?");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        try {
            String playerName = inputs[0];
            if (playerName.length() > 12) {
                ErrorView.display(this.getClass().getName(), "Error: Invalid Name.");
                return false;
            }
            Player player = GameControl.savePlayer(playerName);

            if (player == null) {
                ErrorView.display(this.getClass().getName(), "Error: Could not create the player. "
                        + "Enter a different name.");
                return false;
            }

            this.console.println("\n");
            this.console.println("Welcome to the game " + playerName + "! We hope you have a lot of fun!");
            this.console.println("\n");

            MainMenuView mainMenuView = new MainMenuView();
            mainMenuView.display();

        } catch (GameControlException ex) {
            Logger.getLogger(StartProgramView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
