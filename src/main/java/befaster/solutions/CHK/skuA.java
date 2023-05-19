package befaster.solutions.CHK;

public class skuA extends skuObject {
    public skuA(String name, int price) {
        super(name, price);
    }

    public int calculateBasketSum(int totalSkuAInBasket){
        int sum = 0;
        int quotientA = totalSkuAInBasket / 5;
        if (quotientA == 0) {
            if(totalSkuAInBasket == 3)  sum = sum + 130;
            else sum = sum + (totalSkuAInBasket * 50);
        }
        else{
            int reminderA = totalSkuAInBasket % 5;
            sum = sum + (quotientA * 200);
            if(reminderA == 3)   sum = sum + 130;
            else sum = sum + (reminderA * 50);
        }
        return sum;
    }
}

