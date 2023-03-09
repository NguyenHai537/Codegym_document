package QuanLiSanPham;

import java.util.Comparator;

public class ComparatorProduct implements Comparator<Product> {


    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getPriceSanPham(), o2.getPriceSanPham());
    }


}
