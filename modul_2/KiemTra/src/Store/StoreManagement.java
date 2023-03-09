package Store;

import Customer.Customer;
import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class StoreManagement {



    private List<Store> listStore;

    private static final StoreManagement storeManagement = new StoreManagement();

    private StoreManagement(){
        listStore = new ArrayList<>();
    }

    public static StoreManagement getStoreManagement() {
        return storeManagement;
    }

    public List<Store> getListCoach() {
        return listStore;
    }

    public void  addStore(Store store){
        listStore.add(store);
    }

    public Store searchById(String id){
        Store result =null;
        for (Store store: listStore
        ) {
            if ( store.getStoreID().equals(id)){
                result = store;
            }
        }
        return result;
    }




    @Override
    public String toString() {
        return "StoreManagement{" +
                "listStore=" + listStore +
                '}';
    }
}
