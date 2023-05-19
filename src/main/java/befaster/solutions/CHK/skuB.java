package befaster.solutions.CHK;

public class skuB extends skuObject {
    public skuB(String name, int price) {
        super(name, price);
    }

    public int calculateBasketSum(int totalSkuBInBasket, int totalSkuEInBasket ){
        Integer sum = 0;
        int quotientForSkulEToBDiscount = totalSkuEInBasket/2;
        if(quotientForSkulEToBDiscount != 0 && totalSkuBInBasket>0 ) totalSkuBInBasket = totalSkuBInBasket - quotientForSkulEToBDiscount;

        int quotient = totalSkuBInBasket / 2;
        int reminder = totalSkuBInBasket % 2;
        if (quotient == 0) sum = sum + (totalSkuBInBasket * 30);
        else{
            sum = sum + (quotient * 45);
            sum = sum + (reminder * 30);
        }
        return sum;
    }
}


