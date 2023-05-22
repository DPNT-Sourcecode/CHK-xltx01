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

    public void calculateDiscount() {
        int quotient = discountItem.getCount() / getItemCount() ;
        if (quotient == 0) return;
        int reminder = discountItem.getCount() % getItemCount();
        discountItem.setTotal(discountItem.getTotal() + (quotient * discountPrice));
        discountItem.setCount(reminder);
    }
}
