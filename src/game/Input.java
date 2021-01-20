package game;

import game.assets.colors.ConsoleColors;

import java.util.Scanner;

public class Input {

    public static String getNextMove(){
        Scanner getIn;
        String in;
        char[] c;
        while(true){
            System.out.println("Enter a number for your next move: ");
            getIn = new Scanner(System.in);
            in = getIn.nextLine();
            c = in.toCharArray();
            if(in.equals("stop") || in.equals("exit") || in.equals("close")){
                return in;
            }
            if(c.length == 1){
                if(Character.isDigit(c[0])){
                    int num = Integer.parseInt(in);
                    if(num > 0 && num < 10){
                        return in;
                    }
                    System.out.println(ConsoleColors.RED_BOLD + "Number is too high or too low!" + ConsoleColors.RESET);
                    continue;
                }
                System.out.println(ConsoleColors.RED_BOLD + "Argument is not a number 1-9!" + ConsoleColors.RESET);
                continue;
            }
            System.out.println(ConsoleColors.RED_BOLD + "Invalid argument!" + ConsoleColors.RESET);
            continue;
        }
    }
}
