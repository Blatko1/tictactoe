package game.board;

import game.display.ConsoleColors;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Input(){
        throw new IllegalAccessError("Input class");
    }

    public static List<Integer> getInput(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.nextLine();
            if(input.length() == 2 && Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1))){
                int num1 = Integer.parseInt(input.substring(0, 1));
                int num2 = Integer.parseInt(input.substring(1, 2));
                if(num1 > 0 && num1 < 4 && num2 > 0 && num2 < 4){
                    return Arrays.asList(num1 ,num2);
                }
            }
            System.out.println(ConsoleColors.RED + "Invalid input!" + ConsoleColors.RESET);
        }
    }
}
