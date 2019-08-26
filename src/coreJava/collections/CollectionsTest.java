package coreJava.collections;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CollectionsTest{
    public static void main(String[] args) {
        Lists lists = new Lists();
        IteratorsShow iteratorsShow = new IteratorsShow();

        Collection collection = lists.createList();
        iteratorsShow.iteratorShow(collection);
        iteratorsShow.listIteratorShow((List) collection);

        AbstractQueue abstractQueue = lists.createConcurrentQueue();
        iteratorsShow.failSaveIteratorShow(abstractQueue);

        List<CustomObjectForList> objlist = lists.createObjectList();
        for (CustomObjectForList o: objlist) {
            System.out.println(o.toString());
        }

        Collections.sort(objlist);
        System.out.println("AFTER SORT");
        for (CustomObjectForList o: objlist) {
            System.out.println(o.toString());
        }

        System.out.println("-------------------------");
        Collections.sort(objlist, new StringComparatorForObjList());
        System.out.println("AFTER SORT");
        for (CustomObjectForList o: objlist) {
            System.out.println(o.toString());
        }
    }
}

class IteratorsShow{

    void iteratorShow(Collection collection){
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()){
            if(iterator.next().equals("3")){
                iterator.remove();
                break;
            }
        }

        printAll(collection);
    }

    void listIteratorShow(List list){
        ListIterator listIterator = list.listIterator();

        while (listIterator.hasNext()){
            listIterator.add("|");
            listIterator.next();
        }

        printAll(list);
    }

    void failSaveIteratorShow(AbstractQueue queue){
        Iterator iterator = queue.iterator();

        while (iterator.hasNext()){
            queue.add("|");
            iterator.next();
            iterator.next();
        }

        printAll(queue);
    }

    private void printAll(Collection collection){

        for (Object o : collection) {
            System.out.print(o.toString());
        }

        System.out.println("");
    }
}

class Lists{

    List<String> createList(){
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            stringList.add(String.valueOf(i));
        }

        return stringList;
    }

    List<CustomObjectForList> createObjectList(){
        List<CustomObjectForList> objectList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++){
            CustomObjectForList obj = new CustomObjectForList();
            obj.setNum(rand.nextInt(100));
            obj.setStr(String.valueOf(rand.nextInt(100)));

            objectList.add(obj);
        }

        return objectList;
    }

    public Queue<String> createQueue(){
        Queue<String> stringsQueue = new LinkedList<>();

        for (int i = 0; i < 10; i++){
            stringsQueue.add(String.valueOf(i));
        }

        return stringsQueue;
    }

    AbstractQueue<String> createConcurrentQueue(){
        ConcurrentLinkedQueue<String> stringsQueue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++){
            stringsQueue.add(String.valueOf(i));
        }

        return stringsQueue;
    }

}

class CustomObjectForList implements Comparable{

    private String str;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Object{" +
                "str='" + str + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return (this.getNum() < ((CustomObjectForList) o).getNum() ? -1 : (this.getNum() == ((CustomObjectForList) o).getNum() ? 0 : 1));
    }
}

class StringComparatorForObjList implements Comparator<CustomObjectForList> {

    @Override
    public int compare(CustomObjectForList a, CustomObjectForList b) {
        return a.getStr().compareToIgnoreCase(b.getStr());
    }

}




