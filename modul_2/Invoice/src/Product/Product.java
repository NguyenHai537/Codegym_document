package Product;
public class Product {
    private String idProduct;
    private String idSanPham;
    private String nameSanPham;
    private int priceSanPham;

    public Product() {}

    public Product(String idProduct,String idSanPham, String nameSanPham, int priceSanPham) {
        this.idProduct = idProduct;
        this.idSanPham = idSanPham;
        this.nameSanPham = nameSanPham;
        this.priceSanPham = priceSanPham;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getNameSanPham() {
        return nameSanPham;
    }

    public void setNameSanPham(String nameSanPham) {
        this.nameSanPham = nameSanPham;
    }

    public int getPriceSanPham() {
        return priceSanPham;
    }

    public void setPriceSanPham(int priceSanPham) {
        this.priceSanPham = priceSanPham;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", idSanPham='" + idSanPham + '\'' +
                ", nameSanPham='" + nameSanPham + '\'' +
                ", priceSanPham='" + priceSanPham + '\'' +
                '}' + "\n";
    }

}
