package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.DiscountCalculator;

import java.util.List;

public class skuF extends skuObject {
    public skuF(String name, int price) {
        super(name, price);
    }

//    public int calculateBasketSum(int totalSkuFInBasket){
//        Integer sum = 0;
//        int quotient = totalSkuFInBasket/3;
//        if(quotient > 0){
//            sum = sum + (quotient * 2 * 10);
//            sum = sum + ((totalSkuFInBasket % 3) * 10);
//            return sum;
//        }
//        sum = sum + (totalSkuFInBasket * 10);
//        return sum;
//    }

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

