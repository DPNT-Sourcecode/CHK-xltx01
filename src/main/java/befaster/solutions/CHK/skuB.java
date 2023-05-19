package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.DiscountCalculator;

import java.util.List;

public class skuB extends skuObject {
    public skuB(String name, int price) {
        super(name, price);
    }

    public int calculateItemTotal(){
        int totalSkuAInBasket = this.getCount();
        List<DiscountCalculator> itemDiscounts = this.getItemDiscounts();
        if(itemDiscounts.size() > 0){
            for (DiscountCalculator itemDiscount : itemDiscounts) {
                totalSkuAInBasket = itemDiscount.calculateDiscount(totalSkuAInBasket, 2);
            }
        }
        return this.getTotal() + (totalSkuAInBasket * this.getPrice());
    }
}

