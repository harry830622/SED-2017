import java.io.*;
import java.util.*;

public class Main {
  private static App app;
  private static Map<String, CommandHandler> commandHandlerByName;

  public static void main(String argv[]) {
    app = new App();

    commandHandlerByName = new HashMap<String, CommandHandler>();
    commandHandlerByName.put("data", new DataCommandHandler(app));
    commandHandlerByName.put("addChart", new AddChartCommandHandler(app));
    commandHandlerByName.put("change", new ChangeCommandHandler(app));

    String path = argv[0];
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        List<String> tokens = Arrays.asList(line.split(" "));
        String commandName = tokens.get(0);
        if (commandHandlerByName.containsKey(commandName)) {
          commandHandlerByName.get(commandName).execute(tokens);
        }
      }
    } catch (IOException e) {
      System.out.println("[ERROR] Cannot open input file: " + e);
    }
  }
}
