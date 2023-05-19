package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.DiscountCalculator;

import java.util.List;

public class skuE extends skuObject {
    public skuE(String name, int price) {
        super(name, price);
    }

    public int calculateItemTotal(){
        int totalSkuInBasket = this.getCount();
        List<DiscountCalculator> itemDiscounts = this.getItemDiscounts();
        if(itemDiscounts.size() > 0){
            for (DiscountCalculator itemDiscount : itemDiscounts) {
                totalSkuInBasket = itemDiscount.calculateDiscount(totalSkuInBasket, 0);
            }
        }
        return this.getTotal() + (totalSkuInBasket * this.getPrice());
    }
}
