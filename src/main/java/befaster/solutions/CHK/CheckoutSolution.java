package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

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

        for (int i = 0; i < skus.length(); i++) {
            char currentSkus = skus.charAt(i);
            if(validateCharacter(currentSkus)){
               Integer countOfSkus = mapOfCountOfSkuInOrder.get(Character.toString(currentSkus)) + 1;
               mapOfCountOfSkuInOrder.put(Character.toString(currentSkus),countOfSkus);
            } else return -1;
        }


    }

    public Boolean validateCharacter(char charToValidate){
        return mapOfSkuToPrice.containsKey(Character.toString(charToValidate));
    }

    public Integer calculateBasketTotal(String sku){
        Integer sum = 0;

        switch(sku) {

            case "A":
                int total = mapOfCountOfSkuInOrder.get(sku);
                int quotient = total / 3;
                int reminder = total % 3;
        }

    }
}




