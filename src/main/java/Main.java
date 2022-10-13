import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String flagOrSel;
        String errorString = "Invalid Input, try again";
        int across = 0;
        int down = 0;

        Grid game = new Grid();
        System.out.println(game.getTable());
        while (game.active) {
            System.out.println("Input \"F\" to flag and \"S\" to select: ");
            flagOrSel = in.next();
            switch (flagOrSel) {
                case ("F") -> {
                    while (true) {
                        System.out.println("Input which tile across (Left:1 -> Right: " + game.table.length + "): ");
                        across = in.nextInt();
                        if (across >= 0 && across < game.table.length) {
                            System.out.println("Input which tile down (Top:1 -> bottom:" + game.table.length + "): ");
                            down = in.nextInt();
                            if (down >= 0 && down < game.table.length) {
                                break;
                            } else {
                                System.out.println(errorString);
                            }
                        } else {
                            System.out.println(errorString);
                        }
                    }
                    game.setFlag(down -1, across -1);
                    game.setNames(game.table);
                    System.out.println(game.getTable());
                }
                case ("S") -> {
                    while (true) {
                        System.out.println("Input which tile across (Left:1 -> Right: " + game.table.length + "): ");
                        across = in.nextInt()-1;
                        if (across >= 0 && across < game.table.length) {
                            System.out.println("Input which tile down (Top:1 -> bottom:" + game.table.length + "): ");
                            down = in.nextInt() - 1;
                            if (down >= 0 && down < game.table.length) {
                                break;
                            } else {
                                System.out.println(errorString);
                            }
                        } else {
                            System.out.println(errorString);
                        }
                    }
                    game.showTiles(down, across);
                    game.setNames(game.table);
                    System.out.println(game.getTable());
                }
                default -> System.out.println(errorString);
            }
        }
        if (game.hiddenTiles == game.numbOfMines) {
            System.out.println("You Win");
        } else {
            System.out.println("Game Over");
        }
    }
}