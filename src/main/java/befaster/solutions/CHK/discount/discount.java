package befaster.solutions.CHK.discount;

public abstract class discount {
    private int itemCount;

    public discount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getItemCount() {
        return itemCount;
    }
}
