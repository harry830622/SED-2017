import java.io.*;
import java.util.*;

public class Main {
  private static Composition composition;
  private static Map<String, CommandHandler> commandHandlerByName;

  public static void main(String argv[]) {
    composition = new Composition();

    commandHandlerByName = new HashMap<String, CommandHandler>();
    commandHandlerByName.put("Text", new TextCommandHandler(composition));
    commandHandlerByName.put("GraphicalElement", new GraphicalElementCommandHandler(composition));
    commandHandlerByName.put("ChangeSize", new ChangeSizeCommandHandler(composition));
    commandHandlerByName.put("Require", new RequireCommandHandler(composition));

    String path = argv[0];
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        List<String> tokens = Arrays.asList(line.split(" "));
        commandHandlerByName.get(tokens.get(0)).execute(tokens);
      }
    } catch (IOException e) {
      System.out.println("[ERROR] Cannot open input file: " + e);
    }
  }
}
