import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setName("Молоко");
        product1.setPrice(90);
        Product product2 = new Product();
        product2.setName("Кефір");
        product2.setPrice(140);
        Product product3 = new Product();
        product3.setName("Цукор");
        product3.setPrice(210);
        List<Product> productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        System.out.println(Main.secondMostExpensive(productList).toString());
    }
    public static Optional<Product> secondMostExpensive(List<Product> list){
        return list.stream()
                .sorted((x,y)-> y.getPrice() - x.getPrice())
                .skip(1)
                .findFirst();
    }
}