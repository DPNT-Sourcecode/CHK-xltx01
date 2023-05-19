package befaster.solutions.CHK;

public class skuA extends skuObject {
    public skuA(String name, int price) {
        super(name, price);
    }

    public int calculateBasketSum(int totalSkuAInBasket){
        int sum = 0;
        int quotientA = totalSkuAInBasket / 5;
        if (quotientA == 0) {
             return sum = discountFor3(totalSkuAInBasket);
        }
        else{
            int reminder = totalSkuAInBasket % 5;
            sum = sum + (quotientA * 200);
            sum = sum + discountFor3(reminder);
        }
        return sum;
    }

    public int discountFor3(int count){
        int sum = 0;
        int quotientA = count / 3;
        if (quotientA == 0) {
            sum = sum + (count * 50);
            return sum;
        }
        int reminder = count % 3;
        sum = sum + (quotientA * 200);
        sum = sum + (reminder * 50);
        return sum;
    }
}


