package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.DiscountCalculator;
import befaster.solutions.CHK.discount.discount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class skuObject {
    private String name;
    private int price;

    private List<DiscountCalculator> itemDiscounts;

    private int total;

    public skuObject(String name, int price) {
        this.name = name;
        this.price = price;
        this.total = 0;
        itemDiscounts = new ArrayList<>();
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

    public List<DiscountCalculator> getItemDiscounts() {
        return itemDiscounts;
    }

    public void setItemDiscounts(DiscountCalculator discountCalculator) {
        itemDiscounts.add(discountCalculator);
    }
}

