import java.util.*;

public class GraphicalElementCommandHandler implements CommandHandler {
  private Composition composition;

  public GraphicalElementCommandHandler(Composition composition) {
    this.composition = composition;
  }

  public void execute(List<String> tokens) {
    int componentId = Integer.parseInt(tokens.get(1));
    int componentNaturalSize = Integer.parseInt(tokens.get(2));
    int componentShrinkability = Integer.parseInt(tokens.get(3));
    int componentStretchability = Integer.parseInt(tokens.get(4));
    String componentContent = tokens.get(5);
    composition.addComponent(
        new GraphicalElement(
            componentId,
            componentNaturalSize,
            componentShrinkability,
            componentStretchability,
            componentContent));
  }
}
