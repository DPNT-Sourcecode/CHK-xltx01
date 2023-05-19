package befaster.solutions.CHK;

import befaster.solutions.CHK.discount.xItemForPriceDiscount;
import befaster.solutions.CHK.discount.xItemGetYFreeDiscount;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CheckoutSolution {
    private skuA objectA = new skuA("A", 50);
    private skuB objectB = new skuB("B", 30);
    private skuC objectC = new skuC("C", 20);
    private skuD objectD = new skuD("D", 15);
    private skuE objectE = new skuE("E", 40);
    private skuF objectF = new skuF("F", 10);
    Map<String, skuObject> mapOfCountOfSkuInOrder = new HashMap<>();
    public Integer checkout(String skus) {
        initialize();
        mapOfCountOfSkuInOrder.put("A", objectA);
        mapOfCountOfSkuInOrder.put("B", objectB);
        mapOfCountOfSkuInOrder.put("C", objectC);
        mapOfCountOfSkuInOrder.put("D", objectD);
        mapOfCountOfSkuInOrder.put("E", objectE);
        mapOfCountOfSkuInOrder.put("F", objectF);

        AtomicReference<Integer> basketTotal = new AtomicReference<>(0);

        for (int i = 0; i < skus.length(); i++) {
            char skusChar = skus.charAt(i);
            if(validateCharacter(skusChar)){
               skuObject currentSkus = mapOfCountOfSkuInOrder.get(Character.toString(skusChar));
                currentSkus.setCount(currentSkus.getCount() + 1);
            } else return -1;
        }
        mapOfCountOfSkuInOrder.keySet().forEach(key -> basketTotal.set(basketTotal.get() + calculateBasketTotal(key)));


        mapOfCountOfSkuInOrder.clear();
        return basketTotal.get();
    }

    public Boolean validateCharacter(char charToValidate){
        return mapOfCountOfSkuInOrder.containsKey(Character.toString(charToValidate));
    }

    public void initialize(){
        objectA.setItemDiscounts(new xItemForPriceDiscount(objectA, 5, 200));
        objectA.setItemDiscounts(new xItemForPriceDiscount(objectA, 3, 130));
        objectB.setItemDiscounts(new xItemGetYFreeDiscount(2, objectE));
        objectB.setItemDiscounts(new xItemForPriceDiscount(objectB, 2, 45));
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





