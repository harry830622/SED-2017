import java.util.*;

public class BoxOffice {
  private List<Performance> performanceByDate;
  private List<Order> orderByReservationNum;
  private List<List<Order>> ordersByPerformanceDate;

  public BoxOffice(
      List<Performance> performanceByDate,
      List<Order> orderByReservationNum,
      List<List<Order>> ordersByPerformanceDate) {
    this.performanceByDate = performanceByDate;
    this.orderByReservationNum = orderByReservationNum;
    this.ordersByPerformanceDate = ordersByPerformanceDate;
  }

  public void pickUpTicket(
      int reservationNum, String orderCustomerName, String orderCustomerPhone) {
    if (reservationNum - 1 < orderByReservationNum.size()) {
      Order order = orderByReservationNum.get(reservationNum - 1);
      if (order.getIsValid()) {
        if (order.getIsCancelled()) {
          System.out.println("Pickup fail. Reservation already cancelled.");
        } else if (order.getIsPickedUp()) {
          System.out.println("Pickup fail. Reservation already picked up.");
        } else {
          if (orderCustomerName.equals(order.getCustomerName())
              && orderCustomerPhone.equals(order.getCustomerPhone())) {
            order.setIsPickedUp(true);
            System.out.printf(
                "Pickup #%d. name: %s, tickets: %d\n",
                order.getReservationNum(), order.getCustomerName(), order.getNumAttendees());
          } else {
            System.out.println("Pickup fail. Identification check fail.");
          }
        }
      } else {
        System.out.println("Pickup fail. No such reservation.");
      }
    } else {
      System.out.println("Pickup fail. No such reservation.");
    }
  }
}
