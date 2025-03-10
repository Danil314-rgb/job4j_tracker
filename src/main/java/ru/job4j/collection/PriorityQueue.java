package ru.job4j.collection;

import java.util.LinkedList;

/**
 * Класс описывает работу простейшей очереди по риоритету, которая работает
 * по принципу FIFO (first in - first out)
 * @author DANIL BODROV
 * @version 1.0
 */
public class PriorityQueue {
    /**
     * Хранение задания осуществляется в коллекии типа LinkedList
     */

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку и добавляет её в очередь.
     * Если встречаются 2 задания с одинаковым приоритетом, то в очереди
     * они распределяются по принципу FIFO.
     * @param task задача которая добавляется в очередь
     */
    public void put(Task task) {
        var index = 0;
        for (var element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод позволяет получить первую задачу в очереди
     * @return возвращает задачу из головы очереди или null если очередь пуста
     */

    public Task take() {
        return tasks.poll();
    }
}
