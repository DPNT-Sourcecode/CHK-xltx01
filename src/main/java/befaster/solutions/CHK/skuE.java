package befaster.solutions.CHK;

public class skuE extends skuObject {
    public skuE(String name, int price) {
        super(name, price);
    }

    public int calculateBasketSum(int totalSkuAInBasket){
        Integer sum = 0;
        int quotientA = totalSkuAInBasket / 2;
        sum = sum + (quotientA * 30);
        sum = sum + (totalSkuAInBasket * 40);
        return sum;
    }
}

