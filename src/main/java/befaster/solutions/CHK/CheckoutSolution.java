package befaster.solutions.CHK;

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
    Map<String, Integer> mapOfCountOfSkuInOrder = new HashMap<>();
    public Integer checkout(String skus) {
        mapOfCountOfSkuInOrder.put("A", 0);
        mapOfCountOfSkuInOrder.put("B", 0);
        mapOfCountOfSkuInOrder.put("C", 0);
        mapOfCountOfSkuInOrder.put("D", 0);
        mapOfCountOfSkuInOrder.put("E", 0);
        mapOfCountOfSkuInOrder.put("F", 0);

        AtomicReference<Integer> basketTotal = new AtomicReference<>(0);

        for (int i = 0; i < skus.length(); i++) {
            char currentSkus = skus.charAt(i);
            if(validateCharacter(currentSkus)){
               Integer countOfSkus = mapOfCountOfSkuInOrder.get(Character.toString(currentSkus)) + 1;
               mapOfCountOfSkuInOrder.put(Character.toString(currentSkus),countOfSkus);
            } else return -1;
        }
        mapOfCountOfSkuInOrder.keySet().forEach(key -> basketTotal.set(basketTotal.get() + calculateBasketTotal(key)));


        mapOfCountOfSkuInOrder.clear();
        return basketTotal.get();
    }

    public Boolean validateCharacter(char charToValidate){
        return mapOfCountOfSkuInOrder.containsKey(Character.toString(charToValidate));
    }

    public Integer calculateBasketTotal(String sku){
        Integer sum = 0;

        switch(sku) {

            case "A":
                sum = objectA.calculateBasketSum(mapOfCountOfSkuInOrder.get(sku));
               break;
            case "B":
                sum = objectB.calculateBasketSum(mapOfCountOfSkuInOrder.get(sku), mapOfCountOfSkuInOrder.get("E"));
                break;
            case "C":
                sum = objectC.calculateBasketSum(mapOfCountOfSkuInOrder.get(sku));
                break;
            case "D":
                sum = objectD.calculateBasketSum(mapOfCountOfSkuInOrder.get(sku));
                break;
            case "E":
                sum = objectE.calculateBasketSum(mapOfCountOfSkuInOrder.get(sku));
                break;
            case "F":
                sum = objectF.calculateBasketSum(mapOfCountOfSkuInOrder.get(sku));
                break;
        }
        return sum;
    }
}



