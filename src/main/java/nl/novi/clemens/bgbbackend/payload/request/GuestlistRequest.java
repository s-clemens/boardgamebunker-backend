package nl.novi.clemens.bgbbackend.payload.request;

import java.time.LocalDate;

public class GuestlistRequest {
    private LocalDate requestdate;


    public GuestlistRequest(){};

    public GuestlistRequest(LocalDate requestdate) {
        this.requestdate = requestdate;
    }

    public LocalDate getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(LocalDate requestdate) {
        this.requestdate = requestdate;
    }
}
