package Store;

public class Store {

    private String storeID;

    private String storeName;

    private String storeOwner;

    private double storeTotalMoney;

    public Store() {
    }

    public Store(String storeID, String storeName, String storeOwner, double storeTotalMoney) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.storeOwner = storeOwner;
        this.storeTotalMoney = storeTotalMoney;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    public double getStoreTotalMoney() {
        return storeTotalMoney;
    }

    public void setStoreTotalMoney(double storeTotalMoney) {
        this.storeTotalMoney = storeTotalMoney;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeID='" + storeID + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeOwner='" + storeOwner + '\'' +
                ", storeTotalMoney=" + storeTotalMoney +
                '}';
    }
}
