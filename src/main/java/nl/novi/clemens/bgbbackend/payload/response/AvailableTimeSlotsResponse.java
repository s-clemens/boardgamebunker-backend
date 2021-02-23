package nl.novi.clemens.bgbbackend.payload.response;

public class AvailableTimeSlotsResponse {
    private Boolean latemorning;

    private Boolean earlyafternoon;

    private  Boolean lateafternoon;

    private Boolean evening;

    private Boolean lateevening;

    public AvailableTimeSlotsResponse(){};

    public AvailableTimeSlotsResponse(Boolean latemorning, Boolean earlyafternoon, Boolean lateafternoon, Boolean evening, Boolean lateevening) {
        this.latemorning = latemorning;
        this.earlyafternoon = earlyafternoon;
        this.lateafternoon = lateafternoon;
        this.evening = evening;
        this.lateevening = lateevening;
    }

    public void setLatemorning(Boolean latemorning) {
        this.latemorning = latemorning;
    }

    public void setEarlyafternoon(Boolean earlyafternoon) {
        this.earlyafternoon = earlyafternoon;
    }

    public void setLateafternoon(Boolean lateafternoon) {
        this.lateafternoon = lateafternoon;
    }

    public void setEvening(Boolean evening) {
        this.evening = evening;
    }

    public void setLateevening(Boolean lateevening) {
        this.lateevening = lateevening;
    }

    public Boolean getLatemorning() {
        return latemorning;
    }

    public Boolean getEarlyafternoon() {
        return earlyafternoon;
    }

    public Boolean getLateafternoon() {
        return lateafternoon;
    }

    public Boolean getEvening() {
        return evening;
    }

    public Boolean getLateevening() {
        return lateevening;
    }
}
