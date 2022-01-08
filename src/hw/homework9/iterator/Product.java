package hw.homework9.iterator;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    static class ProductService implements Iterable<Product> {
        private Iterator<Product> iterator;
        private List<Product> productList = new ArrayList<>();

        public void print() {
            productList.forEach(System.out::println);
        }

        public void setIterator(Iterator<Product> iterator) {
            this.iterator = iterator;
        }


        @Override
        public Iterator<Product> iterator() {
            return iterator;
        }

        static class IteratorPrice implements Iterator<Product> {
            private List<Product> productList = new ArrayList<>();
            private int index = 0;

            public IteratorPrice(List<Product> productList, int price) {
                for (Product product : productList) {
                    if (product.price <= price) {
                        this.productList.add(product);
                    }
                }
                System.out.println(this.productList);
            }

            @Override
            public boolean hasNext() {
                return index < productList.size();
            }

            @Override
            public Product next() {
                return productList.get(index++);
            }
        }

        static class AscendingPrice implements Comparator<Product> {

            @Override
            public int compare(Product o1, Product o2) {
                return o1.price - o2.price;
            }
        }

        static class DescendingPrice implements Comparator<Product> {

            @Override
            public int compare(Product o1, Product o2) {
                return o2.price - o1.price;
            }
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
