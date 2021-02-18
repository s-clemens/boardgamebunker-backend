package nl.novi.clemens.bgbbackend.domain;

import com.sun.istack.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Set;

import static java.lang.Boolean.TRUE;

@Entity
@Table(name = "store_product" )
public class Product {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long productid;

    @Column
    private String product_name;

    @Column
    private float product_price;

    @Column
    @Lob
    private byte[] image_cover;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "producttype_id")
    private ProductType producttype;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "consumable_id", referencedColumnName = "consumable_id")
    private Consumable consumable;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "boardgame_id", referencedColumnName = "boardgame_id")
    private Boardgame boardgame;

    @OneToMany(mappedBy = "product")
    private Set<BookingLine> bookinglines;

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public byte[] getImage_cover() {
        return image_cover;
    }

    public void setImage_cover(byte[] image_cover) {
        this.image_cover = image_cover;
    }

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }

    public Boardgame getBoardgame() {
        return boardgame;
    }

    public void setBoardgame(Boardgame boardgame) {
        this.boardgame = boardgame;
    }

    public Set<BookingLine> getBookinglines() {
        return bookinglines;
    }

    public void setBookinglines(Set<BookingLine> bookinglines) {
        this.bookinglines = bookinglines;
    }
}
