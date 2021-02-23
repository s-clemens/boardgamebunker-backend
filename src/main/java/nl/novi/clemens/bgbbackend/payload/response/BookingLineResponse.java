package nl.novi.clemens.bgbbackend.payload.response;

public class BookingLineResponse {

    private String productname;

    private int productid;

    private String producttype;

    private int numberofitems;

    private String coverimage;

    private float price;

    public BookingLineResponse(String productname,
                               int productid,
                               String producttype,
                               int numberofitems,
                               String coverimage,
                               float price) {
        this.productname = productname;
        this.productid = productid;
        this.producttype = producttype;
        this.numberofitems = numberofitems;
        this.coverimage = coverimage;
        this.price = price;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public int getNumberofitems() {
        return numberofitems;
    }

    public void setNumberofitems(int numberofitems) {
        this.numberofitems = numberofitems;
    }

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
