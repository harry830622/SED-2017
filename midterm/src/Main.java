import java.io.*;
import java.util.*;

public class Main {
  private static List<Performance> performanceByDate;
  private static List<Order> orderByReservationNum;
  private static List<List<Order>> ordersByPerformanceDate;
  private static CustomerService customerService;
  private static BoxOffice boxOffice;

  public static void main(String argv[]) {
    performanceByDate = new ArrayList<Performance>();
    ordersByPerformanceDate = new ArrayList<List<Order>>();
    for (int i = 0; i < 365; ++i) {
      performanceByDate.add(new Performance());
      ordersByPerformanceDate.add(new ArrayList<Order>());
    }
    orderByReservationNum = new ArrayList<Order>();
    customerService =
        new CustomerService(performanceByDate, orderByReservationNum, ordersByPerformanceDate);
    boxOffice = new BoxOffice(performanceByDate, orderByReservationNum, ordersByPerformanceDate);

    String path = argv[0];
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        List<String> tokens = Arrays.asList(line.split(" "));
        String firstWord = tokens.get(0);
        if (firstWord.equals("performance")) {
          int performanceDate = Integer.parseInt(tokens.get(1));
          int performanceHour = Integer.parseInt(tokens.get(2));
          int performanceNumSeats = Integer.parseInt(tokens.get(3));
          Performance performance =
              new Performance(performanceDate, performanceHour, performanceNumSeats);
          performanceByDate.set(performanceDate - 1, performance);
        } else if (firstWord.equals("book")) {
          String timeStamp = tokens.get(1);
          List<String> timeStampTokens = Arrays.asList(timeStamp.split(","));
          int timeStampDate = Integer.parseInt(timeStampTokens.get(0));
          int timeStampHour = Integer.parseInt(timeStampTokens.get(1));

          check(timeStampDate, timeStampHour);

          int orderPerformanceDate = Integer.parseInt(tokens.get(2));
          String orderCustomerName = tokens.get(3);
          String orderCustomerPhone = tokens.get(4);
          int orderNumAttendees = Integer.parseInt(tokens.get(5));
          int orderReservationNum = orderByReservationNum.size() + 1;

          customerService.book(
              orderPerformanceDate,
              orderCustomerName,
              orderCustomerPhone,
              orderNumAttendees,
              orderReservationNum);
        } else if (firstWord.equals("cancel")) {
          String timeStamp = tokens.get(1);
          List<String> timeStampTokens = Arrays.asList(timeStamp.split(","));
          int timeStampDate = Integer.parseInt(timeStampTokens.get(0));
          int timeStampHour = Integer.parseInt(timeStampTokens.get(1));

          check(timeStampDate, timeStampHour);

          int reservationNum = Integer.parseInt(tokens.get(2));
          String orderCustomerName = tokens.get(3);
          String orderCustomerPhone = tokens.get(4);

          customerService.cancelBooking(reservationNum, orderCustomerName, orderCustomerPhone);
        } else if (firstWord.equals("pickup")) {
          String timeStamp = tokens.get(1);
          List<String> timeStampTokens = Arrays.asList(timeStamp.split(","));
          int timeStampDate = Integer.parseInt(timeStampTokens.get(0));
          int timeStampHour = Integer.parseInt(timeStampTokens.get(1));

          check(timeStampDate, timeStampHour);

          int reservationNum = Integer.parseInt(tokens.get(2));
          String orderCustomerName = tokens.get(3);
          String orderCustomerPhone = tokens.get(4);

          boxOffice.pickUpTicket(reservationNum, orderCustomerName, orderCustomerPhone);
        } else if (firstWord.equals("time")) {
          String timeStamp = tokens.get(1);
          List<String> timeStampTokens = Arrays.asList(timeStamp.split(","));
          int timeStampDate = Integer.parseInt(timeStampTokens.get(0));
          int timeStampHour = Integer.parseInt(timeStampTokens.get(1));

          check(timeStampDate, timeStampHour);
        }
      }
    } catch (IOException e) {
      System.out.println("[ERROR] Cannot open input file: " + e);
    }
  }

  public static void check(int timeStampDate, int timeStampHour) {
    Performance performance = performanceByDate.get(timeStampDate - 1);
    if (performance.getIsValid()) {
      List<Order> orders = ordersByPerformanceDate.get(timeStampDate - 1);
      if (performance.getHour() - timeStampHour <= 2) {
        for (Order order : orders) {
          if (!order.getIsCancelled() && !order.getIsPickedUp()) {
            order.setIsCancelled(true);
            System.out.printf(
                "Cancel #%d. name: %s, tickets: %d\n",
                order.getReservationNum(), order.getCustomerName(), order.getNumAttendees());
          }
        }
      }
      if (performance.getHour() == timeStampHour) {
        for (Order order : orders) {
          if (order.getIsCancelled() || !order.getIsPickedUp()) {
            System.out.printf(
                "Clear #%d. name: %s, tickets: %d\n",
                order.getReservationNum(), order.getCustomerName(), order.getNumAttendees());
          }
        }
      }
    }
  }
}
