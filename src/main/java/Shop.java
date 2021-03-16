import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Serializable {
    private List<Order> orders = new ArrayList<>();
    private List<Sales> sales = new ArrayList<>();
    private List<ProductGastronomic> productGastronomic = new ArrayList<>();
    private List<ProductGrocery> productGrocery = new ArrayList<>();

    public Order sellOutOrder(Consumer consumer, List<Product> listOrderProduct) {
        double sumOrder = 0;
        for (Product product : listOrderProduct) {
            sumOrder += product.getPrice();
        }
        Order order = new Order(consumer, listOrderProduct, sumOrder);
        orders.add(order);
        return order;
    }

    public void setProductGastronomic(List<ProductGastronomic> productGastronomic) {
        this.productGastronomic = productGastronomic;
    }

    public void setProductGrocery(List<ProductGrocery> productGrocery) {
        this.productGrocery = productGrocery;
    }

    public List<ProductGastronomic> getProductGastronomic() {
        return productGastronomic;
    }

    public List<ProductGrocery> getProductGrocery() {
        return productGrocery;
    }

    public Sales addSale(Product product, int discount, String dateStart, String dateEnd) {
        Sales sale = new Sales(product, discount, dateStart, dateEnd);
        sales.add(sale);
        return sale;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public ProductGastronomic addProductGastronomic(String article, String name, String productionDate, int shelfLife, int storageTemperature, double price, ProductModel model) {
        ProductGastronomic productGastronomic = new ProductGastronomic(article, name, productionDate,shelfLife,storageTemperature, price, model);
        this.productGastronomic.add(productGastronomic);
        return productGastronomic;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "orders=" + orders +
                ", sales=" + sales +
                '}';
    }
}
