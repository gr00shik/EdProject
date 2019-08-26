package coreJava.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InheritanceInCollection {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        HomeCat homeCat = new HomeCat();

        List<Animal> animalList = new ArrayList<>();
        animal.setLocalAnimalInt(100);
        animalList.add(animal);
        animal = new Animal();
        animal.setLocalAnimalInt(1000);
        animalList.add(animal);

        List<Cat> catList = new ArrayList<>();
        cat.setLocalCatInt(200);
        catList.add(cat);
        cat = new Cat();
        cat.setLocalCatInt(2000);
        catList.add(cat);

        List<HomeCat> homeCatList = new ArrayList<>();
        homeCat.setLocalHomeCatInt(300);
        homeCatList.add(homeCat);
        homeCat = new HomeCat();
        homeCat.setLocalHomeCatInt(3000);
        homeCatList.add(homeCat);

        CollectionCopy<HomeCat> homeCC = new CollectionCopy();
        homeCC.copyInheritors(homeCatList, catList);
        homeCC.copyInheritors(homeCatList, animalList);
        homeCC.listPrint(homeCatList);
    }

}

class CollectionCopy <T extends Animal>{

    public void copyInheritors(List <? super HomeCat> a, List <? extends Animal> b){

        Iterator iterator = b.iterator();
        List<HomeCat> homeCats = new ArrayList<>();
        while (iterator.hasNext()){
            Object iteratorObject = iterator.next();

            HomeCat homeCat = new HomeCat();
            homeCat.semiInt = ((T) iteratorObject).getSemiInt();

            homeCats.add(homeCat);

        }

        a.addAll(homeCats);
    }

    public void listPrint(List<? extends Animal> list){
        for (Animal a: list) {
            a.print();
        }
        System.out.println("------------------------");
    }
}

class Animal implements Comparable{
    int localAnimalInt = 10;
    int semiInt = 1;

    @Override
    public int compareTo(Object o) {
        return (this.semiInt < ((Animal) o).semiInt ? -1 : (this.semiInt == ((Animal) o).semiInt ? 0 : 1));
    }

    public void setLocalAnimalInt(int semiInt) {
        this.semiInt = semiInt;
    }

    public int getSemiInt() {
        return this.semiInt;
    }

    void print(){
        System.out.println("localAnimalInt " + localAnimalInt + ": semiInt " + semiInt);
    }
}

class Cat extends Animal {
    int localCatInt = 20;
    int semiInt = 2;

    public void setLocalCatInt(int semiInt) {
        this.semiInt = semiInt;
    }

    public int getSemiInt() {
        return this.semiInt;
    }

    void print(){
        System.out.println("localCatInt " + localCatInt + ": semiInt " + semiInt);
    }
}

class HomeCat extends Cat {
    int localHomeCatInt = 30;
    int semiInt = 3;

    public int getSemiInt() {
        return this.semiInt;
    }

    public void setLocalHomeCatInt(int semiInt) {
        this.semiInt = semiInt;
    }

    void print(){
        System.out.println("localHomeCatInt " + localHomeCatInt + ": semiInt " + semiInt);
    }
}