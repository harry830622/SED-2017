import java.util.*;

public class TexCompositor implements Compositor {
  public void compose(List<Component> components) {
    for (int i = 0; i < components.size(); ++i) {
      Component component = components.get(i);
      if (component.getContent().equals("<ParagraphEnd>")) {
        System.out.printf("[%d]%s\n", component.getSize(), component.getContent());
      } else {
        System.out.printf("[%d]%s ", component.getSize(), component.getContent());
      }
    }
  }
}
