package befaster.solutions.CHK;

public class skuE extends skuObject {
    public skuE(String name, int price) {
        super(name, price);
    }

    public int calculateBasketSum(int totalSkuEInBasket){
        Integer sum = 0;
        sum = sum + (totalSkuEInBasket * 40);
        return sum;
    }
}

