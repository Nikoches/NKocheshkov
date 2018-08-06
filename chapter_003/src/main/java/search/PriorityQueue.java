package search;
import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        tasks.add(task);
        for (Task task1:tasks) {
           if (task.getPriority()<task1.getPriority()){
              tasks.set(tasks.indexOf(task1),task);
           }
        }
      //TODO добавить вставку в связанный список.
    }

    public Task take() {
        return this.tasks.poll();
    }
}
