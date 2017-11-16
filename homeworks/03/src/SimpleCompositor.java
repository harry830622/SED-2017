import java.util.*;

public class SimpleCompositor implements Compositor {
  public void compose(List<Component> components) {
    for (int i = 0; i < components.size(); ++i) {
      Component component = components.get(i);
      System.out.printf("[%d]%s\n", component.getSize(), component.getContent());
    }
  }
}
