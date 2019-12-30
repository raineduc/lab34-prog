package lib.observer;

public interface EventListener<T> {
  public void update(T data);
}
