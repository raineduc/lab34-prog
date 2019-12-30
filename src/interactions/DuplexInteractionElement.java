package interactions;


public abstract class DuplexInteractionElement<T extends Enum, R extends Enum>
        extends OutputInteractionElement<T>
        implements InputInteractionElement<R> {
  public DuplexInteractionElement(T currentState) {
    super(currentState);
  }
}
