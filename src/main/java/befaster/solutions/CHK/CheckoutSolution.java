package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.DiscountCalculator;
import befaster.solutions.CHK.discount.xItemForPriceDiscount;
import befaster.solutions.CHK.discount.xItemGetXFreeDiscount;
import befaster.solutions.CHK.discount.xItemGetYFreeDiscount;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CheckoutSolution {
    private ItemsInStock items = new ItemsInStock();

    Map<String, skuObject> mapOfCountOfSkuInOrder = new HashMap<>();
    public Integer checkout(String skus) {
        initialize();

        AtomicReference<Integer> basketTotal = new AtomicReference<>(0);

        for (int i = 0; i < skus.length(); i++) {
            char skusChar = skus.charAt(i);
            if(validateCharacter(skusChar)){
               skuObject currentSkus = mapOfCountOfSkuInOrder.get(Character.toString(skusChar));
                currentSkus.setCount(currentSkus.getCount() + 1);
            } else return -1;
        }
        mapOfCountOfSkuInOrder.values().forEach(item -> basketTotal.set(basketTotal.get() + calculateBasketTotal(item)));
        clear();
        return basketTotal.get();
    }

    public Boolean validateCharacter(char charToValidate){
        return mapOfCountOfSkuInOrder.containsKey(Character.toString(charToValidate));
    }

    public void initialize(){

        items.addNewItem("A", 50);
        items.addNewItem("B", 30);
        items.addNewItem("C", 20);
        items.addNewItem("D", 15);
        items.addNewItem("E", 40);
        items.addNewItem("F", 10);

        for(skuObject item : items.getItemsInStock()){
            mapOfCountOfSkuInOrder.put(item.getName(), item);
        }

        mapOfCountOfSkuInOrder.get("A").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("A"), 5, 200));
        mapOfCountOfSkuInOrder.get("A").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("A"), 3, 130));
        mapOfCountOfSkuInOrder.get("B").setItemDiscounts(new xItemGetYFreeDiscount(2,mapOfCountOfSkuInOrder.get("E")));
        mapOfCountOfSkuInOrder.get("B").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("B"), 2, 45));
        mapOfCountOfSkuInOrder.get("F").setItemDiscounts(new xItemGetXFreeDiscount(mapOfCountOfSkuInOrder.get("F"), 3, 1));
    }

    public void clear(){
        mapOfCountOfSkuInOrder.values().forEach( item -> {
            item.setCount(0);
            item.setTotal(0);
        });
    }

    public Integer calculateBasketTotal(skuObject sku){
        Integer sum = 0;
        sum = sku.calculateItemTotal();
        return sum;
    }
}




