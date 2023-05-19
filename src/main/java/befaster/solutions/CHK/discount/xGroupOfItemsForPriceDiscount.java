package befaster.solutions.CHK.discount;

import befaster.solutions.CHK.skuObject;

import java.util.ArrayList;
import java.util.List;

public class xGroupOfItemsForPriceDiscount extends discount implements DiscountCalculator{

    private List<skuObject> discountGroupItem;
    private int discountPrice;
    private int verifiedDiscountCount;
    private boolean calculatedDiscount;



    public xGroupOfItemsForPriceDiscount(List<skuObject> discountGroupItem, int itemCount, int discountPrice) {
        super(itemCount);
        this.discountGroupItem = discountGroupItem;
        this.discountPrice = discountPrice;
        this.calculatedDiscount = false;
    }

    public int calculateDiscount(int count, int countOfDependentItem) {
       boolean complete = false;
        List<skuObject> qualifyingGroup = new ArrayList<>();
        if(!calculatedDiscount){
            while(!complete){
                for(int i =0; i<discountGroupItem.size(); i++){
                    if(discountGroupItem.get(i).getCount() > 0){
                        qualifyingGroup.add(discountGroupItem.get(i));
                    }
                    if(qualifyingGroup.size() == getItemCount()){
                       for(skuObject item: qualifyingGroup){
                           item.setCount(item.getCount() - 1);
                       }
                       verifiedDiscountCount++;
                       qualifyingGroup.clear();
                    } else{
                        if (i == discountGroupItem.size()-1) complete = true;
                    }
                }
            }
            calculatedDiscount = true;
            return verifiedDiscountCount * discountPrice;
        } else{
            return 0;
        }
    }
}

