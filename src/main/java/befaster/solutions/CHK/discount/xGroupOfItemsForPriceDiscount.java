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

    public void calculateDiscount() {
       boolean complete = false;
        List<skuObject> qualifyingGroup = new ArrayList<>();
        if(!calculatedDiscount){
            while(!complete){
                for(int i =0; i<discountGroupItem.size(); i++){
                    if(discountGroupItem.get(i).getCount() > 0){
                        for(int z =0; z<discountGroupItem.get(i).getCount(); z++) {
                            if(qualifyingGroup.size() == 3)
                            {
                                i = i-1;
                                break;}
                            qualifyingGroup.add(discountGroupItem.get(i));
                        }
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
            discountGroupItem.get(0).setTotal(verifiedDiscountCount * discountPrice);
        }
    }
}
