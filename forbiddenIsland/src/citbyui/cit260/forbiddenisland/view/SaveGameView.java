/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.forbiddenisland.exceptions.GameControlException;
import citbyui.cit260.model.Game;
import forbiddenisland.ForbiddenIsland;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
class SaveGameView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        inputs[0] = this.getInput("Name this file with after");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String filePath = inputs[0];
        Game game = ForbiddenIsland.getCurrentGame();
                this.console.println("Inputs = Y");
                try {
                    //GameControl.saveGame(game);
                    GameControl.saveGame(game, filePath);
                } catch (GameControlException ex) {
                    Logger.getLogger(SaveGameView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SaveGameView.class.getName()).log(Level.SEVERE, null, ex);
                }

        this.console.println("Success: File Saved!"); 
        return true;
    }

}
