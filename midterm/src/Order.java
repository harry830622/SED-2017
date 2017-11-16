public class Order {
  private boolean isValid;
  private boolean isCancelled;
  private boolean isPickedUp;
  private int reservationNum;
  private int performanceDate;
  private String customerName;
  private String customerPhone;
  private int numAttendees;

  public Order() {
    this.isValid = false;
    this.isCancelled = false;
    this.isPickedUp = false;
    this.reservationNum = -1;
    this.performanceDate = -1;
    this.customerName = "";
    this.customerPhone = "";
    this.numAttendees = 0;
  }

  public Order(
      int reservationNum,
      int performanceDate,
      String customerName,
      String customerPhone,
      int numAttendees) {
    this.isValid = true;
    this.isCancelled = false;
    this.isPickedUp = false;
    this.reservationNum = reservationNum;
    this.performanceDate = performanceDate;
    this.customerName = customerName;
    this.customerPhone = customerPhone;
    this.numAttendees = numAttendees;
  }

  public boolean getIsValid() {
    return this.isValid;
  }

  public boolean getIsCancelled() {
    return this.isCancelled;
  }

  public boolean getIsPickedUp() {
    return this.isPickedUp;
  }

  public int getReservationNum() {
    return this.reservationNum;
  }

  public int getPerformanceDate() {
    return this.performanceDate;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public String getCustomerPhone() {
    return this.customerPhone;
  }

  public int getNumAttendees() {
    return this.numAttendees;
  }

  public void setIsValid(boolean isValid) {
    this.isValid = isValid;
  }

  public void setIsCancelled(boolean isCancelled) {
    this.isCancelled = isCancelled;
  }

  public void setIsPickedUp(boolean isPickedUp) {
    this.isPickedUp = isPickedUp;
  }
}
