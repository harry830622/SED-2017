import java.util.*;

public class ChangeSizeCommandHandler implements CommandHandler {
  private Composition composition;

  public ChangeSizeCommandHandler(Composition composition) {
    this.composition = composition;
  }

  public void execute(List<String> tokens) {
    int componentId = Integer.parseInt(tokens.get(1));
    int newSize = Integer.parseInt(tokens.get(2));
    Component component = composition.getComponentById(componentId);
    if (newSize >= component.getShrinkability() && newSize <= component.getStretchability()) {
      component.setSize(newSize);
      System.out.printf("component %d size changed to %d\n", componentId, newSize);
    } else {
      System.out.printf("component %d failed to change size\n", componentId);
    }
  }
}
