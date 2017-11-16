public abstract class Component {
  private int id;
  private int naturalSize;
  private int shrinkability;
  private int stretchability;
  private String content;
  private int size;

  public Component(int id, int naturalSize, int shrinkability, int stretchability, String content) {
    this.id = id;
    this.naturalSize = naturalSize;
    this.shrinkability = shrinkability;
    this.stretchability = stretchability;
    this.content = content;
    this.size = naturalSize;
  }

  public int getId() {
    return this.id;
  }

  public int getNaturalSize() {
    return this.naturalSize;
  }

  public int getShrinkability() {
    return this.shrinkability;
  }

  public int getStretchability() {
    return this.stretchability;
  }

  public String getContent() {
    return this.content;
  }

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
