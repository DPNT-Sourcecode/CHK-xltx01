package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CheckoutSolution {
    private skuObject objectA = new skuObject("A", 50);
    private skuObject objectB = new skuObject("B", 30);
    private skuObject objectC = new skuObject("C", 20);
    private skuObject objectD = new skuObject("D", 15);

    private Map<String, Integer> mapOfSkuToPrice = new HashMap<>();
    Map<String, Integer> mapOfCountOfSkuInOrder = new HashMap<>();
    public Integer checkout(String skus) {
        mapOfSkuToPrice.put("A", 50);
        mapOfSkuToPrice.put("B", 30);
        mapOfSkuToPrice.put("C", 20);
        mapOfSkuToPrice.put("D", 15);
        mapOfCountOfSkuInOrder.put("A", 0);
        mapOfCountOfSkuInOrder.put("B", 0);
        mapOfCountOfSkuInOrder.put("C", 0);
        mapOfCountOfSkuInOrder.put("D", 0);

        AtomicReference<Integer> basketTotal = new AtomicReference<>(0);

        for (int i = 0; i < skus.length(); i++) {
            char currentSkus = skus.charAt(i);
            if(validateCharacter(currentSkus)){
               Integer countOfSkus = mapOfCountOfSkuInOrder.get(Character.toString(currentSkus)) + 1;
               mapOfCountOfSkuInOrder.put(Character.toString(currentSkus),countOfSkus);
            } else return -1;
        }
        mapOfCountOfSkuInOrder.keySet().stream().forEach(key -> basketTotal.set(basketTotal.get() + calculateBasketTotal(key)));
    }

    public Boolean validateCharacter(char charToValidate){
        return mapOfSkuToPrice.containsKey(Character.toString(charToValidate));
    }

    public Integer calculateBasketTotal(String sku){
        Integer sum = 0;

        switch(sku) {

            case "A":
                int totalA = mapOfCountOfSkuInOrder.get(sku);
                int quotientA = totalA / 3;
                int reminderA = totalA % 3;
                if (quotientA == 0) sum = sum + (totalA * 50);
                else{
                    sum = sum + (quotientA * 130);
                    sum = sum + (reminderA * 50);
                }
               break;
            case "B":
                int totalB = mapOfCountOfSkuInOrder.get(sku);
                int quotientB = totalB / 2;
                int reminderB = totalB % 2;
                if (quotientB == 0) sum = sum + (totalB * 30);
                else{
                    sum = sum + (quotientB * 45);
                    sum = sum + (reminderB * 30);
                }
                break;
            case "C":
                int totalC = mapOfCountOfSkuInOrder.get(sku);
                sum = totalC * 20;
                break;
            case "D":
                int totalD = mapOfCountOfSkuInOrder.get(sku);
                sum = totalD * 15;
                break;
        }
        return sum;
    }
}






