package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.discount;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class skuObject {
    private String name;
    private int price;

    private List<discount> itemDiscounts;

    private int total;

    public skuObject(String name, int price) {
        this.name = name;
        this.price = price;
        this.total = 0;
        itemDiscounts = Collections.emptyList();
    }

    public int getPrice() {
        return price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<discount> getItemDiscounts() {
        return itemDiscounts;
    }

    public void setItemDiscounts(discount discount) {
        itemDiscounts.add(discount);
    }
}


