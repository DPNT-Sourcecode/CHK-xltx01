package befaster.solutions.CHK.discount;

import befaster.solutions.CHK.skuObject;

public class xItemGetYFreeDiscount extends discount{
    public xItemGetYFreeDiscount(int itemCount) {
       super(itemCount);
    }

    public int calculateDiscount(int count, int countOfDependentItem) {
        int quotientForSkulEToBDiscount = countOfDependentItem/getItemCount();
        if(quotientForSkulEToBDiscount != 0 && count>0 ) count= count - quotientForSkulEToBDiscount;
        return count;
    }
}
