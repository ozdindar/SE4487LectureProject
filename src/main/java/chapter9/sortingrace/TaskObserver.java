package chapter9.sortingrace;

interface TaskObserver<T>
{
    void taskCompleted(T t);
}
