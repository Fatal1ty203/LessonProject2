package lessons.lesson21_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main2_find_shortest_way {

    public static void main(String[] args) {
        Cell[][] cells = new Cell[3][3];
        /*

        |A|_|_|
        |_|_|_|
        |_|_|X|
         */

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j, " "); //заполняем весь массив пустыми ячейками
            }
        }
        //Вставляет клетку отсчета
        cells[0][0].value = "A";
        //Вставляет клетку финиша
        cells[2][2].value = "X";
        System.out.println("shortest way length = "+findShortestWayLength(cells, 0,0));
    }

    public static int findShortestWayLength(Cell[][] cells, int startRow, int startCol){
        Queue<Cell> queue = new ArrayDeque<>();
        int[][] directions = {
                {0, -1}, {-1, 0}, {0, 1}, {1,0} //влево, вверх, вправо, вниз
        };
        //добавляем в очередь клетку старта
        queue.add(cells[startRow][startCol]);
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            //смотрим соседей клетки во всех четырех направлениях
            for(int[] direction : directions){
                int row = cell.row + direction[0];
                int col = cell.col + direction[1];
                //проверяем, что ячейка существует и еще не посещена
                if(isCellSafety(row, col, cells)){
                    //проверяем, что ячейка не является финишной клеткой
                    if(!cells[row][col].value.equals("X")){
                        //добавялем в очередь ячейку
                        queue.add(cells[row][col]);
                        //делаем ее посещенной
                        cells[row][col].visited = true;
                        cells[row][col].stepNumber = cell.stepNumber+1;
                        queue.add(cells[row][col]); //добаляем посещенную клетку в очередь, чтобы потом посмотреть ее соседей
                    }else{
                        return cell.stepNumber+1;
                    }
                }
            }

        }
        return -1;
    }

    //проверяем, что ячейка существует и она еще не посещена
    public static boolean isCellSafety(int row, int col, Cell[][] arr){
        return row >=0 && row < 3 && col >=0 && col < 3 && !arr[row][col].visited ;
    }
}


class Cell{
    int row, col;
    String value;
    boolean visited; //true, если ячейка уже была посещена
    int stepNumber; //порядковый номер клетки, начиная от стартовой

    public Cell(int row, int col, String value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}