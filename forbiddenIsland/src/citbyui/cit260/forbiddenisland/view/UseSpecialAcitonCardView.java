/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Scanner;

/**
 *
 * @author DD
 */
class UseSpecialAcitonCardView {

    void displayUseSpecialAcitonCardView() {
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
        // test code
        int SpecialActionCardUnflood = (int)Math.round(Math.random() * 5);
        int SpecialActionCardHelicopter = (int)Math.round(Math.random() * 5);
        int total = SpecialActionCardUnflood + SpecialActionCardHelicopter;
        // end test code
        String[] inputs = new String[1];
        
        boolean valid = false;
        while (valid == false) {
        //CREATED SCANNER  
            Scanner inFile;
            inFile = new Scanner(System.in);
            if (total == 0) {
            System.out.println("You have no Special Action cards.\nWould you like to use a different player's Special Action card?\n"
                    + "Y - yes\n"
                    + "N - no\n");
            }
            else {
            System.out.println("You have " + SpecialActionCardUnflood + " Unflood Tile card(s) and " + SpecialActionCardHelicopter + " Helicopter card(s)\n"
                    + "Which Speical Action card would you like to use?\n");
                if(SpecialActionCardUnflood == 0){
                    System.out.println("H - Helicopter\n"
                            + "D - Use different players Special Action card\n");
                }
                else if(SpecialActionCardHelicopter == 0) {
                    System.out.println("U - Unflood Tile\n"
                            + "D - Use different players Special Action card\n");
                } 
                else {
                    System.out.println("U - Unflood Tile\n"
                            + "H - Helicopter\n"
                            + "D - Use different players Special Action card\n");
                }
            }
            String value = inFile.nextLine().trim().toUpperCase();

            if (value.length() < 1 || value.length() > 1) {
                System.out.println("Error: Please re-enter valid option: ");
                continue;
            }
            inputs[0] = value;
            valid = true;
        }
        return inputs;
    }

    private boolean doActions(String[] inputs) {
        switch(inputs[0]){
            case "U":
                System.out.println("use unflood tile card - call unfloodTilesView()");
                break;
            case "H":
                System.out.println("use helicopter card - call helicopterView()?");
                break;
            case "D":
            case "Y":
                System.out.println("use different player's Special Action card display other players cards");
                break;
            default:
                return true;
        }
        return true;
    }
    
}
