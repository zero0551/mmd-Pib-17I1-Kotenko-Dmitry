import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        if (ShopD.isFileExists()) {
            Shop shop = ShopD.readShop();
            for (Sales sale : shop.getSales()) {
                System.out.println("Продукт со скидкой: " + sale);
            }
            for (Order order : shop.getOrders()) {
                System.out.println("Заказ: " + order);
            }
        } else {
            System.out.println("!Магазин!");
            Shop shop = new Shop();
            Scanner in = new Scanner(System.in);
            System.out.println("1. Создать новый гастрономический продукт");
            System.out.println("2. Создать новый гросери продукт");
            System.out.println("3. Вывести все гастрономические продукты");
            System.out.print("Введите пункт меню: ");
            int num = in.nextInt();
            switch (num) {
                case(1):
                    String article;
                    System.out.println("Введите имя");
                    article = in.next();
                    String name;
                    System.out.println("Введите имя");
                    name = in.next();
                    String productionDate;
                    System.out.println("Введите имя");
                    productionDate = in.next();
                    int shelfLife;
                    System.out.println("Введите имя");
                    shelfLife = in.nextInt();
                    int storageTemperature;
                    System.out.println("Введите имя");
                    storageTemperature = in.nextInt();
                    double price;
                    System.out.println("Введите имя");
                    price = in.nextDouble();

                    int productModelI = 0;
                    for (ProductModel productModel : EnumSet.allOf(ProductModel.class)) {
                        System.out.println("[" + productModelI + "]" + productModelI);
                        productModelI++;
                    }
                    int productModelIndex = in.nextInt();

                    ProductModel productModel = ProductModel.values()[productModelIndex];

                    shop.addProductGastronomic(article, name, productionDate, shelfLife, storageTemperature, price, productModel);


                    break;
                case(2):

                    System.out.println("Введите имя");
                    article = in.next();

                    System.out.println("Введите имя");
                    name = in.next();

                    System.out.println("Введите имя");
                    productionDate = in.next();

                    System.out.println("Введите имя");
                    shelfLife = in.nextInt();

                    System.out.println("Введите имя");
                    storageTemperature = in.nextInt();

                    System.out.println("Введите имя");
                    price = in.nextDouble();

                    int productModelGI = 0;
                    for (ProductModel productModelGI : EnumSet.allOf(ProductModel.class)) {
                        System.out.println("[" + productModelGI + "]" + productModelGI);
                        productModelGI++;
                    }
                    int productModelIndex = in.nextInt();

                    ProductModel productModel = ProductModel.values()[productModelIndex];

                    shop.addProductGastronomic(article, name, productionDate, shelfLife, storageTemperature, price, productModel);




                    ProductGrocery product2 = new ProductGrocery("2", "Гречка", "2020.11.15", 180, 20, 30, ProductModel.GRAINS);
                    System.out.println(product2.toString());
                    break;
                case(3):

                    break;
                case(4):
                    shop.addSale(product1, 5, "2020.11.13", "2020.11.20");
                    shop.addSale(product2, 10, "2020.11.13", "2020.13.20");
                    break;
            }


            Consumer consumer1 = new Consumer("Дмитрий", "Котенко", "743487", "dkotenko37@gmail.com", 1200, 0);
            Consumer consumer2 = new Consumer("Павел", "Олейник", "543684", "pavel.oleinik@gmail.com", 12000, 5);
            System.out.println("Покупатели:");
            System.out.println(consumer1.toString());
            System.out.println(consumer2.toString());
            System.out.println("Продукты:");


            for (Sales sale : shop.getSales()) {
                System.out.println("Продукт со скидкой: " + sale);
            }
            List<Product> listOrderProduct = new ArrayList<>();
            listOrderProduct.add(product1);
            listOrderProduct.add(product1);
            listOrderProduct.add(product2);

            shop.sellOutOrder(consumer1, listOrderProduct);
            for (Order order : shop.getOrders()) {
                System.out.println("Заказ: " + order);
            }
            ShopD.writeShop(shop);
        }
    }
}
