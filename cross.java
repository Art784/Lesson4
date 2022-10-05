public class cross {
    public static void main(String[] args) {
        String[][] map = initMap(3);
        print(map)
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
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}