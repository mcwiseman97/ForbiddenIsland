/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Scanner;

/**
 *
 * @author mcwis
 */
class GameMenuView {

    void displayGameMenuView() {
        boolean endOfView = false;

        do {
            String[] inputs = getInputs();

            if (inputs == null || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endOfView = doActions(inputs);

        } while (endOfView != true);

    }

    private String[] getInputs() {
        String[] inputs = new String[1];

        System.out.println("Game Menu\n"
                + "M – Move\n"
                + "U – Unflood a tile\n"
                + "T – Give Treasure Card\n"
                + "C – Capture Treasure\n"
                + "A – Use Special Action Card\n"
                + "V – View Cards\n"
                + "E – End Turn\n"
                + "I – View Instructions\n"
                + "S – Save Game\n"
                + "Q – Quit");

        boolean valid = false;
        while (valid == false) {
            //CREATED SCANNER  
            Scanner inFile;
            inFile = new Scanner(System.in);

            System.out.println("Please choose a main menu item: ");
            String value = inFile.nextLine().trim().toUpperCase();

            if (value.length() < 1 || value.length() > 1) {
                System.out.println("Error: Please re-enter menu item: ");
                continue;
            }
            inputs[0] = value;
            valid = true;
        }
        return inputs;
    }

    private boolean doActions(String[] inputs) {
        switch (inputs[0]) {
            case "M":
                MoveMenuView moveMenuView = new MoveMenuView();
                moveMenuView.displayMoveMenuView();
                break;
            case "U":
                UnfloodTileView unfloodTileView = new UnfloodTileView();
                unfloodTileView.displayUnfloodTileView();
                break;
            case "G":
                GiveTreasureCardView giveTreasureCardView = new GiveTreasureCardView();
                giveTreasureCardView.displayGiveTreasureCardView();
                break;
            case "C":
                CaptureTreasureView captureTreasureView = new CaptureTreasureView();
                captureTreasureView.displayCaptureTreasureView();
                break;
            case "A":
                UseSpecialAcitonCardView useSpecialAcitonCardView = new UseSpecialAcitonCardView();
                useSpecialAcitonCardView.displayUseSpecialAcitonCardView();
                break;
            case "V":
                viewCards();
                break;
            case "E":

                break;
            case "I":
                HelpMenuView helpMenuView = new HelpMenuView();
                helpMenuView.displayHelpMenuView();
                break;
            case "S":
                
                break;
        }
        return true;
    }
}