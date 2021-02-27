package nl.novi.clemens.bgbbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "bookingline")
public class BookingLine {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long bookinglineid;

    private int numberofItems;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public BookingLine(){};

    public BookingLine(int numberofItems, Product product, Booking booking) {
        this.numberofItems = numberofItems;
        this.product = product;
        this.booking = booking;
    }

    public long getBookinglineid() {
        return bookinglineid;
    }

    public void setBookinglineid(long bookinglineid) {
        this.bookinglineid = bookinglineid;
    }

    public int getNumberofItems() {
        return numberofItems;
    }

    public void setNumberofItems(int numberofItems) {
        this.numberofItems = numberofItems;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}


