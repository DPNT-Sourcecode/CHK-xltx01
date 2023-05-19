package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class ItemsInStock {
    private List<skuObject> items;


    public ItemsInStock() {
        this.items = new ArrayList<>();
    }

    public void addNewItem(String name, int price){
        items.add(new skuObject(name, price));
    }

    public List<skuObject> getItemsInStock (){
        return items;
    }
}

