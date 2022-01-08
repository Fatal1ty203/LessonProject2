package hw.homework8.Comparable.RealEstate;


public class RealEstate implements Comparable<RealEstate> {
    private int price; // цена
    private int square; // площадь
    private int rooms; // комнаты

    public RealEstate(int price, int square, int rooms) {
        this.price = price;
        this.square = square;
        this.rooms = rooms;
    }


    @Override
    public int compareTo(RealEstate o) {
        int priceX = price - o.price;
        int squareX = o.square - square;
        int roomsX = o.rooms - rooms;
        if (priceX == 0 && squareX == 0){
            return roomsX;
        }else if (priceX == 0){
            return squareX;
        }
        return priceX;
    }

    @Override
    public String toString() {
        return "Цена: " + price +
                ", Площадь: " + square +
                ", Кол-во комнат: " + rooms + "\n";
    }
}
