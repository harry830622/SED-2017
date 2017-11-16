import java.util.*;

public class CustomerService {
  private List<Performance> performanceByDate;
  private List<Order> orderByReservationNum;
  private List<List<Order>> ordersByPerformanceDate;

  public CustomerService(
      List<Performance> performanceByDate,
      List<Order> orderByReservationNum,
      List<List<Order>> ordersByPerformanceDate) {
    this.performanceByDate = performanceByDate;
    this.orderByReservationNum = orderByReservationNum;
    this.ordersByPerformanceDate = ordersByPerformanceDate;
  }

  public void book(
      int orderPerformanceDate,
      String orderCustomerName,
      String orderCustomerPhone,
      int orderNumAttendees,
      int orderReservationNum) {
    Performance performance = performanceByDate.get(orderPerformanceDate - 1);
    if (orderNumAttendees <= performance.getNumSeats()) {
      Order order =
          new Order(
              orderReservationNum,
              orderPerformanceDate,
              orderCustomerName,
              orderCustomerPhone,
              orderNumAttendees);
      orderByReservationNum.add(order);
      ordersByPerformanceDate.get(orderPerformanceDate - 1).add(order);
      performance.decrementNumSeats(order.getNumAttendees());
      System.out.printf(
          "Reserve #%d. name: %s, tickets: %d\n",
          order.getReservationNum(), order.getCustomerName(), order.getNumAttendees());
    } else {
      System.out.println("Book fail. Not enough seats in requested performance.");
    }
  }

  public void cancelBooking(
      int reservationNum, String orderCustomerName, String orderCustomerPhone) {
    if (reservationNum - 1 < orderByReservationNum.size()) {
      Order order = orderByReservationNum.get(reservationNum - 1);
      if (order.getIsValid()) {
        if (order.getIsCancelled()) {
          System.out.println("Cancel fail. Reservation already cancelled.");
        } else if (order.getIsPickedUp()) {
          System.out.println("Cancel fail. Reservation already picked up.");
        } else {
          if (orderCustomerName.equals(order.getCustomerName())
              && orderCustomerPhone.equals(order.getCustomerPhone())) {
            order.setIsCancelled(true);
            System.out.printf(
                "Cancel #%d. name: %s, tickets: %d\n",
                order.getReservationNum(), order.getCustomerName(), order.getNumAttendees());
          } else {
            System.out.println("Cancel fail. Identification check fail.");
          }
        }
      } else {
        System.out.println("Cancel fail. No such reservation.");
      }
    } else {
      System.out.println("Cancel fail. No such reservation.");
    }
  }
}
