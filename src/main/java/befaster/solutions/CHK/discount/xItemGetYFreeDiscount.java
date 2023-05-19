package befaster.solutions.CHK.discount;

import befaster.solutions.CHK.skuObject;

public class xItemGetYFreeDiscount extends discount implements DiscountCalculator{

    private skuObject dependentItem;
    public xItemGetYFreeDiscount(int itemCount, skuObject dependentItem) {
       super(itemCount);
       this.dependentItem = dependentItem;
    }

    public int calculateDiscount(int count, int countOfDependentItem) {
        int quotientForSkulEToBDiscount = dependentItem.getCount()/getItemCount();
        if(quotientForSkulEToBDiscount != 0 && count>0 ) count= count - quotientForSkulEToBDiscount;
        return count;
    }

}

