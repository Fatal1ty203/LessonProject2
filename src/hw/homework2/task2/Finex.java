package hw.homework2.task2;

import java.util.List;

public class Finex extends Company {
    private int shares, sharePrice, found;

    public Finex(String lastNameDirector, int workers,int shares, int shareValue, int found) {
        super(lastNameDirector, workers);
        this.shares = shares;
        this.sharePrice = shareValue;
        this.found = found;
    }


    public static void saleInt(List<Company> companies, int n){
        for (Company f : companies){
            if (f.getClass() == Finex.class){
                ((Finex) f).saleN(n);
            }
        }
    }

    private int sale(){
        shares -=1;
        return found += sharePrice;
    }

    private void saleN(int n){
        for(int i = 0; i < n; i++) {
            sale();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Компания - Finex, " +
                "Акции = " + shares +
                ", Цена акции = " + sharePrice +
                ", Капитал = " + found;
    }
}
