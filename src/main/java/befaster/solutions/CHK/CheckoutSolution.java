package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.xItemForPriceDiscount;
import befaster.solutions.CHK.discount.xItemGetXFreeDiscount;
import befaster.solutions.CHK.discount.xItemGetYFreeDiscount;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CheckoutSolution {
    private skuObject objectA = new skuObject("A", 50);
    private skuObject objectB = new skuObject("B", 30);
    private skuObject objectC = new skuObject("C", 20);
    private skuObject objectD = new skuObject("D", 15);
    private skuObject objectE = new skuObject("E", 40);
    private skuObject objectF = new skuObject("F", 10);


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
        mapOfCountOfSkuInOrder.keySet().forEach(key -> basketTotal.set(basketTotal.get() + calculateBasketTotal(key)));
        clear();
        return basketTotal.get();
    }

    public Boolean validateCharacter(char charToValidate){
        return mapOfCountOfSkuInOrder.containsKey(Character.toString(charToValidate));
    }

    public void initialize(){
        mapOfCountOfSkuInOrder.put("A", objectA);
        mapOfCountOfSkuInOrder.put("B", objectB);
        mapOfCountOfSkuInOrder.put("C", objectC);
        mapOfCountOfSkuInOrder.put("D", objectD);
        mapOfCountOfSkuInOrder.put("E", objectE);
        mapOfCountOfSkuInOrder.put("F", objectF);


        objectA.setItemDiscounts(new xItemForPriceDiscount(objectA, 5, 200));
        objectA.setItemDiscounts(new xItemForPriceDiscount(objectA, 3, 130));
        objectB.setItemDiscounts(new xItemGetYFreeDiscount(2, objectE));
        objectB.setItemDiscounts(new xItemForPriceDiscount(objectB, 2, 45));
        objectF.setItemDiscounts(new xItemGetXFreeDiscount(objectF, 3, 1));
    }

    public void clear(){
        mapOfCountOfSkuInOrder.values().forEach( item -> {
            item.setCount(0);
            item.setTotal(0);
        });
    }

    public Integer calculateBasketTotal(String sku){
        Integer sum = 0;

        switch(sku) {

            case "A":
                sum = objectA.calculateItemTotal();
               break;
            case "B":
                sum = objectB.calculateItemTotal();
                break;
            case "C":
                sum = objectC.calculateItemTotal();
                break;
            case "D":
                sum = objectD.calculateItemTotal();
                break;
            case "E":
                sum = objectE.calculateItemTotal();
                break;
            case "F":
                sum = objectF.calculateItemTotal();
                break;
        }
        return sum;
    }
}



