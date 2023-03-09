package QuanLiSanPham;

public class Product {
    private String idListProduct;
    private String idSanPham;
    private String nameSanPham;
    private int priceSanPham;

    public Product() {}

    public Product(String idListProduct, String idSanPham, String nameSanPham, int priceSanPham) {
        this.idListProduct = idListProduct;
        this.idSanPham = idSanPham;
        this.nameSanPham = nameSanPham;
        this.priceSanPham = priceSanPham;
    }

    public String getIdListProduct() {
        return idListProduct;
    }

    public void setIdListProduct(String idListProduct) {
        this.idListProduct = idListProduct;
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
                "idProduct='" + idListProduct + '\'' +
                ", idSanPham='" + idSanPham + '\'' +
                ", nameSanPham='" + nameSanPham + '\'' +
                ", priceSanPham='" + priceSanPham + '\'' +
                '}' + "\n";
    }

}
