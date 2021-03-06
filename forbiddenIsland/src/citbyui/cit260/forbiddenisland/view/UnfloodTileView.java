/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.exceptions.MapControlException;
import citbyui.cit260.model.Location;
import citbyui.cit260.model.Map;
import forbiddenisland.ForbiddenIsland;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author DD
 */
public class UnfloodTileView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];
        this.console.println("Which tile would you like to unflood? ");
        inputs[0] = this.getInput("Row:");
        inputs[1] = this.getInput("Column:");
        

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        int row = parseInt(inputs[0]);
        int column = parseInt(inputs[1]);
        if (row < 1 || row > 5 || column < 1 || column > 5){
            ErrorView.display(this.getClass().getName(), "Error: invalid input.");
           return false;
        }
        //this.console.println("You have chosen Row - " + inputs[0] + ", and Column - " + inputs[1]);
        this.console.println("***********************************\n"
                + "You have unflooded " + row + "," + column + "\n"
                + "***********************************");
        //Map floodMap = ForbiddenIsland.getCurrentGame().getMap();
        Location[][] locations = ForbiddenIsland.getCurrentGame().getMap().getLocation();
        locations[row-1][column-1].setFlooded(0);
        return true;
    }

}
