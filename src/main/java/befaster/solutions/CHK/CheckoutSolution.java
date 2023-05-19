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
    public Integer checkout(String skus) {
        mapOfSkuToPrice.put("A", 50);
        mapOfSkuToPrice.put("B", 30);
        mapOfSkuToPrice.put("C", 20);
        mapOfSkuToPrice.put("D", 15);

        for (int i = 0; i < skus.length(); i++) {


        }
    }

    public Boolean validateCharacter(char charToValidate){
        
    }
}





