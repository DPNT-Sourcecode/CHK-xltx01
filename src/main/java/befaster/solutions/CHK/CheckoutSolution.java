package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.*;

import java.util.HashMap;
import java.util.List;
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
        items.addNewItem("G", 20);
        items.addNewItem("H", 10);
        items.addNewItem("I", 35);
        items.addNewItem("J", 60);
        items.addNewItem("K", 80);
        items.addNewItem("L", 90);
        items.addNewItem("M", 15);
        items.addNewItem("N", 40);
        items.addNewItem("O", 10);
        items.addNewItem("P", 50);
        items.addNewItem("Q", 30);
        items.addNewItem("R", 50);
        items.addNewItem("S", 30);
        items.addNewItem("T", 20);
        items.addNewItem("U", 40);
        items.addNewItem("V", 50);
        items.addNewItem("W", 20);
        items.addNewItem("X", 90);
        items.addNewItem("Y", 10);
        items.addNewItem("Z", 50);

        for(skuObject item : items.getItemsInStock()){
            mapOfCountOfSkuInOrder.put(item.getName(), item);
        }

        mapOfCountOfSkuInOrder.get("A").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("A"), 5, 200));
        mapOfCountOfSkuInOrder.get("A").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("A"), 3, 130));
        mapOfCountOfSkuInOrder.get("B").setItemDiscounts(new xItemGetYFreeDiscount(2,mapOfCountOfSkuInOrder.get("E")));
        mapOfCountOfSkuInOrder.get("B").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("B"), 2, 45));
        mapOfCountOfSkuInOrder.get("F").setItemDiscounts(new xItemGetXFreeDiscount(mapOfCountOfSkuInOrder.get("F"), 3, 1));
        mapOfCountOfSkuInOrder.get("H").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("H"), 10, 80));
        mapOfCountOfSkuInOrder.get("H").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("H"), 5, 45));
        mapOfCountOfSkuInOrder.get("K").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("K"), 2, 150));
        mapOfCountOfSkuInOrder.get("M").setItemDiscounts(new xItemGetYFreeDiscount(3,mapOfCountOfSkuInOrder.get("N")));
        mapOfCountOfSkuInOrder.get("P").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("P"), 5, 200));
        mapOfCountOfSkuInOrder.get("Q").setItemDiscounts(new xItemGetYFreeDiscount(3,mapOfCountOfSkuInOrder.get("R")));
        mapOfCountOfSkuInOrder.get("Q").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("Q"), 3, 80));
        mapOfCountOfSkuInOrder.get("U").setItemDiscounts(new xItemGetXFreeDiscount(mapOfCountOfSkuInOrder.get("U"), 4, 1));
        mapOfCountOfSkuInOrder.get("V").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("V"), 3, 130));
        mapOfCountOfSkuInOrder.get("V").setItemDiscounts(new xItemForPriceDiscount(mapOfCountOfSkuInOrder.get("V"), 2, 90));
        DiscountCalculator groupDiscount1 = new xGroupOfItemsForPriceDiscount(List.of( mapOfCountOfSkuInOrder.get("S"), mapOfCountOfSkuInOrder.get("T"), mapOfCountOfSkuInOrder.get("X"), mapOfCountOfSkuInOrder.get("Y"), mapOfCountOfSkuInOrder.get("Z")), 3, 45);
        mapOfCountOfSkuInOrder.get("S").setItemDiscounts(groupDiscount1);
        mapOfCountOfSkuInOrder.get("T").setItemDiscounts(groupDiscount1);
        mapOfCountOfSkuInOrder.get("X").setItemDiscounts(groupDiscount1);
        mapOfCountOfSkuInOrder.get("Y").setItemDiscounts(groupDiscount1);
        mapOfCountOfSkuInOrder.get("Z").setItemDiscounts(groupDiscount1);
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




