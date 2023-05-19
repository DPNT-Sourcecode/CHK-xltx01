package befaster.solutions.CHK.discount;

import befaster.solutions.CHK.skuObject;

public class xItemForPriceDiscount implements discount {

    private skuObject discountItem;
    private int itemCount;

    private int discountPrice;

    public xItemForPriceDiscount(skuObject discountItem, int itemCount, int discountPrice) {
        this.discountItem = discountItem;
        this.itemCount = itemCount;
        this.discountPrice = discountPrice;
    }

    public int calculateDiscount(int count) {
        int quotient = count / itemCount ;
        if (quotient == 0) return 0;
        int reminder = count % 2;
        discountItem.setTotal(discountItem.getTotal() + (quotient * discountPrice));
        return reminder;
    }
}
