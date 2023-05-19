package befaster.solutions.CHK.discount;

import befaster.solutions.CHK.skuObject;

public class xItemForPriceDiscount extends discount implements DiscountCalculator{

    private skuObject discountItem;

    private int discountPrice;

    public xItemForPriceDiscount(skuObject discountItem, int itemCount, int discountPrice) {
        super(itemCount);
        this.discountItem = discountItem;
        this.discountPrice = discountPrice;
    }

    public int calculateDiscount(int count, int countOfDependentItem) {
        int quotient = count / getItemCount() ;
        if (quotient == 0) return count;
        int reminder = count % getItemCount();
        discountItem.setTotal(discountItem.getTotal() + (quotient * discountPrice));
        return reminder;
    }
}


