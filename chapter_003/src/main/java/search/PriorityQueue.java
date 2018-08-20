package search;
import java.util.LinkedList;
public class PriorityQueue {
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
private LinkedList<Task> tasks = new LinkedList<>();
    public void put(Task task) {
        int index = 0;
        while (index < tasks.size()) {
            if (task.getPriority() < tasks.get(index).getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    public Task take() {
        for (Task task1:tasks) {
            System.out.println(task1.getDesc() + ' ' +  task1.getPriority());
        }
        return this.tasks.poll();
    }
}
