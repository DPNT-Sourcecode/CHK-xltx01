package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.DiscountCalculator;
import befaster.solutions.CHK.discount.discount;

import java.util.List;

public class skuA extends skuObject {
    public skuA(String name, int price) {
        super(name, price);
    }

//    public int calculateBasketSum(int totalSkuAInBasket){
//        int sum = 0;
//        int quotientA = totalSkuAInBasket / 5;
//        if (quotientA == 0) {
//             return sum = discountFor3(totalSkuAInBasket);
//        }
//        else{
//            int reminder = totalSkuAInBasket % 5;
//            sum = sum + (quotientA * 200);
//            sum = sum + discountFor3(reminder);
//        }
//        return sum;
//    }

    public int calculateItemTotal(int totalSkuAInBasket){
        this.setTotal(totalSkuAInBasket);
        List<DiscountCalculator> itemDiscounts = this.getItemDiscounts();
        if(itemDiscounts.size() > 0){
            for (DiscountCalculator itemDiscount : itemDiscounts) {
               totalSkuAInBasket = itemDiscount.calculateDiscount(totalSkuAInBasket, 0);
            }
        }
        return this.getTotal() + (totalSkuAInBasket * this.getPrice());
    }

//    public int discountFor3(int count){
//        int sum = 0;
//        int quotientA = count / 3;
//        if (quotientA == 0) {
//            sum = sum + (count * 50);
//            return sum;
//        }
//        int reminder = count % 3;
//        sum = sum + (quotientA * 130);
//        sum = sum + (reminder * 50);
//        return sum;
//    }
}

