package befaster.solutions.CHK.discount;

import befaster.solutions.CHK.skuObject;

public class xItemGetXFreeDiscount extends discount implements DiscountCalculator{

    private skuObject discountItem;

    private int discountPrice;

    public xItemGetXFreeDiscount(skuObject discountItem, int itemCount, int discountPrice) {
        super(itemCount);
        this.discountItem = discountItem;
        this.discountPrice = discountPrice;
    }

    public int calculateDiscount(int count, int countOfDependentItem) {
        int quotient = count/getItemCount();
        if(quotient > 0){
            discountItem.setTotal(discountItem.getTotal() + (quotient * (getItemCount() - discountPrice) * discountItem.getPrice()));
        }
        return count % getItemCount();
    }


}

