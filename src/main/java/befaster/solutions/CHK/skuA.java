package befaster.solutions.CHK;

public class skuA extends skuObject {
    public skuA(String name, int price) {
        super(name, price);
    }

    public int calculateBasketSum(int totalSkuAInBasket){
        int sum = 0;
        int quotientA = totalSkuAInBasket / 3;
        int reminderA = totalSkuAInBasket % 3;
        if (quotientA == 0) sum = sum + (totalSkuAInBasket * 50);
        else{
            sum = sum + (quotientA * 130);
            sum = sum + (reminderA * 50);
        }
        return sum;
    }
}


