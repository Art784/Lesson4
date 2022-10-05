import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] map = initMap(3);
        print(map);

        while (true) {

            humanProgress(map);
            print(map);
            if (isWinner(map, "X")) {
                System.out.println("X win");
                break;

            }
            if (isDraw(map)) {

                break;
            }

            compTurn(map);
            print(map);
            if (isWinner(map, "0")) {
                System.out.println("0 win");
                break;
            }
            if (isDraw(map)) {
            
                break;
            }

        }
    }

    //Инициализация игрового поля
    public static String[][] initMap(int size) {
        String[][] map = new String[size][size];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = "*";
            }
        }
        return map;
    }

    //Печать игрового поля
    public static void print(String[][] map) {
        System.out.println("----------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    //ход человека
    public static void humanProgress(String[][] map) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if ((x >= 0 && x < map.length) && (y >= 0 && y < map.length)) {
                if (map[x][y].equals("*")) {
                    map[x][y] = "X";
                    break;

                } else {
                    System.out.println("Tut zanyato, hodite snova");
                }
            } else{
                    System.out.println("Pereigrivaite");
                }

            }
        }


    public static void compTurn(String[][] map) {
        Random random = new Random();
        while (true) {
            int x = random.nextInt(map.length);
            int y = random.nextInt(map.length);
            if ((x >= 0 && x < map.length) && (y >= 0 && y < map.length)) {
                if (map[x][y].equals("*")) {
                    map[x][y] = "0";
                    break;
                }
            }
        }
    }

    //проверка победы
    public static boolean isWinner(String[][] map, String turn) {
        if (
                (map[0][0].equals(turn) && map[0][1].equals(turn) && map[0][2].equals(turn)) ||
                        (map[1][0].equals(turn) && map[1][1].equals(turn) && map[1][2].equals(turn)) ||
                        (map[2][0].equals(turn) && map[2][1].equals(turn) && map[2][2].equals(turn))
        ) {
            return true;

        } else if (
                (map[0][0].equals(turn) && map[1][0].equals(turn) && map[2][0].equals(turn)) ||
                        (map[0][1].equals(turn) && map[1][1].equals(turn) && map[2][1].equals(turn)) ||
                        (map[0][2].equals(turn) && map[1][2].equals(turn) && map[2][2].equals(turn))
        ) {
            return true;
        } else if (
                (map[0][0].equals(turn) && map[1][1].equals(turn) && map[2][2].equals(turn)) ||
                        (map[0][2].equals(turn) && map[1][1].equals(turn) && map[2][0].equals(turn))
        ) {
            return true;

        } else {
            return false;


        }

    }
    public static boolean isDraw(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for ( int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals("*")) {
                    return false;
                }
            }
        }
        System.out.println("nichya");

         return true;
    }
}



