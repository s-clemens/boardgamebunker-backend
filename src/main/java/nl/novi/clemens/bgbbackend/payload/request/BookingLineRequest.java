package nl.novi.clemens.bgbbackend.payload.request;

public class BookingLineRequest {

    private int numberofitems;

    private Long productid;

    public BookingLineRequest(){};

    public BookingLineRequest(int numberofitems, Long productid) {
        this.numberofitems = numberofitems;
        this.productid = productid;
    }

    public int getNumberofitems() {
        return numberofitems;
    }

    public void setNumberofitems(int numberofitems) {
        this.numberofitems = numberofitems;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }
}