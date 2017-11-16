public class Performance {
  private boolean isValid;
  private int date;
  private int hour;
  private int numSeats;

  public Performance() {
    this.isValid = false;
    this.date = -1;
    this.hour = -1;
    this.numSeats = 0;
  }

  public Performance(int date, int hour, int numSeats) {
    this.isValid = true;
    this.date = date;
    this.hour = hour;
    this.numSeats = numSeats;
  }

  public boolean getIsValid() {
    return this.isValid;
  }

  public int getDate() {
    return this.date;
  }

  public int getHour() {
    return this.hour;
  }

  public int getNumSeats() {
    return this.numSeats;
  }

  public void incrementNumSeats(int n) {
    this.numSeats += n;
  }

  public void decrementNumSeats(int n) {
    this.numSeats -= n;
  }
}
