package io.fww.ch1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by fengweiwei on 10/7/16.
 */
public class Q4{
    /*猫狗队列*/
    /*要求：
    * 用户可以调用add，将cat和dog instance放入q
    * 用户可以调用pollAll，将所有instance按照先后顺序弹出
    * 用户可以调用pollDog，将dog instance按照先后顺序弹出
    * 用户可以调用pollCat，将cat instance按照先后顺序弹出
    * 用户可以调用isEmpty，检查队列是否为空
    * 用户可以调用isDogEmpty,检查队列是否还有dog instance
    * 用户可以调用isCatEmpty,检查队列是否还有Cat instance*/
    private Queue<Item> qCat;
    private Queue<Item> qDog;
    private int number;

    public Q4(){
        this.qCat = new LinkedList<Item>();
        this.qDog = new LinkedList<Item>();
        this.number = 0;
    }

    public Pet pollAll() throws Exception {
        if(!qCat.isEmpty()&&!qDog.isEmpty()){
            if(qDog.peek().getNumber()>qCat.peek().getNumber()){
                return qCat.poll().getPet();
            }else
                return qDog.poll().getPet();
        }else if(this.qDog.isEmpty()){
            return qCat.poll().getPet();
        }else if(this.qCat.isEmpty()){
            return qDog.poll().getPet();
        }

        throw new Exception("queue is empty!");
    }

    public void add(Pet pet) throws Exception {
        if("Dog".equals(pet.getType())){
            qDog.add(new Item(new Dog(), this.number++));
        }else if("Cat".equals(pet.getType())){
            qCat.add(new Item(new Cat(), this.number++));
        }else{
            throw new Exception("unknow type!");
        }
    }

    public Dog pollDog() throws Exception {
        if(!qDog.isEmpty())
            return (Dog) qDog.poll().getPet();

        throw new Exception("queue is empty!");
    }

    public Cat pollCat() throws Exception {
        if(!qCat.isEmpty()){
            return (Cat) qCat.poll().getPet();
        }

        throw new Exception("queue is empty!");
    }

    public boolean isEmpty(){
        return qDog.isEmpty()&&qCat.isEmpty();
    }

    public boolean isCatEmpty(){
        return qCat.isEmpty();
    }

    public boolean isDogEmpty(){
        return qDog.isEmpty();
    }
}

class Item{
    private Pet pet;
    private int number;

    public Item(Pet pet, int number){
        this.pet = pet;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getType(){
        return this.pet.getType();
    }

    public Pet getPet(){
        return this.pet;
    }
}

class Pet{
    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}

class Dog extends Pet{

    public Dog() {
        super("Dog");
    }
}

class Cat extends Pet{

    public Cat() {
        super("Cat");
    }
}