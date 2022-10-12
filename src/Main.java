import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String flagOrSel;
        int width = 0;
        int height = 0;
        int bombs = 0;
        int across = 0;
        int down = 0;

        System.out.println("Input width of board: ");
        width = in.nextInt();
        System.out.println("Input height of board: ");
        height = in.nextInt();
        System.out.println("Input number of bombs on the board: ");
        bombs = in.nextInt();

        Grid game = new Grid(width, height, bombs);
        System.out.println(game.getTable());
        while (game.active) {
            System.out.println("Input \"F\" to flag and \"S\" to select: ");
            flagOrSel = in.next();
            switch (flagOrSel) {
                case ("F") -> {
                    while (true) {
                        System.out.println("Input which tile across (Left:1 -> Right: " + game.table.length + "): ");
                        across = in.nextInt() - 1;
                        if (across >= 1 && across < game.table.length) {
                            System.out.println("Input which tile down (Top:1 -> bottom:" + game.table.length + "): ");
                            down = in.nextInt() - 1;
                            if (down >= 1 && down < game.table.length) {
                                break;
                            } else {
                                System.out.println("invalid input");
                            }
                        } else {
                            System.out.println("invalid input");
                        }
                    }
                    game.setFlag(down, across);
                    game.setNames(game.table);
                    System.out.println(game.getTable());
                }
                case ("S") -> {
                    while (true) {
                        System.out.println("Input which tile across (Left:1 -> Right: " + game.table.length + "): ");
                        across = in.nextInt() - 1;
                        if (across >= 1 && across < game.table.length) {
                            System.out.println("Input which tile down (Top:1 -> bottom:" + game.table.length + "): ");
                            down = in.nextInt() - 1;
                            if (down >= 1 && down < game.table.length) {
                                break;
                            } else {
                                System.out.println("invalid input");
                            }
                        } else {
                            System.out.println("invalid input");
                        }
                    }
                    game.showTiles(down, across);
                    game.setNames(game.table);
                    System.out.println(game.getTable());
                }
                default -> System.out.println("invalid input, try again");
            }
        }
        if (game.hiddenTiles == game.numbOfMines) {
            System.out.println("You Win");
        } else {
            System.out.println("Game Over");
        }
    }
}