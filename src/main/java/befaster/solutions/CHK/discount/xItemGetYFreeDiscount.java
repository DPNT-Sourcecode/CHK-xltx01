package befaster.solutions.CHK.discount;

import befaster.solutions.CHK.skuObject;

public class xItemGetYFreeDiscount extends discount implements DiscountCalculator{

    private skuObject dependentItem;

    private skuObject discountedItem;
    public xItemGetYFreeDiscount(int itemCount, skuObject dependentItem, skuObject discountedItem) {
       super(itemCount);
       this.dependentItem = dependentItem;
       this.discountedItem = discountedItem;
    }

    public void calculateDiscount() {
        int quotientForSkulEToBDiscount = dependentItem.getCount()/getItemCount();
        if(quotientForSkulEToBDiscount != 0 && discountedItem.getCount()>0 ) discountedItem.setCount( discountedItem.getCount() - quotientForSkulEToBDiscount);
    }

}

