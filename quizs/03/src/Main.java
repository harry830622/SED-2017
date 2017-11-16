import java.io.*;
import java.util.*;

public class Main {
  private static Map<String, Duck> duckByType;

  public static void main(String argv[]) {
    duckByType = new HashMap<String, Duck>();
    String path = argv[0];
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        List<String> tokens = Arrays.asList(line.split(" "));
        String firstWord = tokens.get(0);
        if (firstWord.equals("duck")) {
          String duckType = tokens.get(1);
          String flyMode = tokens.get(2);
          String quackMode = tokens.get(3);
          Duck duck = null;
          if (duckType.equals("MallardDuck")) {
            duck = new MallardDuck(duckType);
          } else if (duckType.equals("RedheadDuck")) {
            duck = new RedheadDuck(duckType);
          } else if (duckType.equals("RubberDuck")) {
            duck = new RubberDuck(duckType);
          } else if (duckType.equals("DecoyDuck")) {
            duck = new DecoyDuck(duckType);
          }
          if (flyMode.equals("CanFly")) {
            duck.setFly(new Flyable());
          } else if (flyMode.equals("CannotFly")) {
            duck.setFly(new Unflyable());
          }
          if (quackMode.equals("Quack")) {
            duck.setQuack(new Quack());
          } else if (quackMode.equals("Squeak")) {
            duck.setQuack(new Squeak());
          } else if (quackMode.equals("Silent")) {
            duck.setQuack(new Silent());
          }
          duckByType.put(duckType, duck);
        } else if (firstWord.equals("changeFly")) {
          String duckType = tokens.get(1);
          String flyMode = tokens.get(2);
          Duck duck = duckByType.get(duckType);
          if (flyMode.equals("CanFly")) {
            duck.setFly(new Flyable());
          } else if (flyMode.equals("CannotFly")) {
            duck.setFly(new Unflyable());
          }
        } else if (firstWord.equals("changeQuack")) {
          String duckType = tokens.get(1);
          String quackMode = tokens.get(2);
          Duck duck = duckByType.get(duckType);
          if (quackMode.equals("Quack")) {
            duck.setQuack(new Quack());
          } else if (quackMode.equals("Squeak")) {
            duck.setQuack(new Squeak());
          } else if (quackMode.equals("Silent")) {
            duck.setQuack(new Silent());
          }
        } else if (firstWord.equals("swim")) {
          String duckType = tokens.get(1);
          Duck duck = duckByType.get(duckType);
          duck.swim();
        } else if (firstWord.equals("fly")) {
          String duckType = tokens.get(1);
          Duck duck = duckByType.get(duckType);
          duck.fly();
        } else if (firstWord.equals("quack")) {
          String duckType = tokens.get(1);
          Duck duck = duckByType.get(duckType);
          duck.quack();
        }
      }
    } catch (IOException e) {
      System.out.println("[ERROR] Cannot open input file: " + e);
    }
  }
}
