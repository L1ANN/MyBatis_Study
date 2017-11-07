package domain;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 23:01 2017/10/31
 * @Modified By:
 */
public class Order {
    /**
     CREATE TABLE orders(
     order_id INT PRIMARY KEY AUTO_INCREMENT,
     order_no VARCHAR(20),
     order_price FLOAT
     );
     */
    private int id;      //id->order_id
    private String orderNo;  //orderNo->order_no
    private float price;     //price->order_price

    public Order(){}

    public Order(int id, String orderNo, float price) {
        this.id = id;
        this.orderNo = orderNo;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String no) {
        this.orderNo = no;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", price=" + price +
                '}';
    }
}
