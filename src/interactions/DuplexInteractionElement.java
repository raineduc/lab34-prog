package interactions;


public abstract class DuplexInteractionElement<T extends Enum, R extends Enum>
        extends OutputInteractionElement<T>
        implements InputInteractionElement<R> {
}
