package hkhr.neural.network;

import java.util.Stack;

/**
 * Created by sandeepmishra on 09/04/18.
 */

class Item<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

public class Queue {

    Stack<Item> push;
    Stack<Item> pop;

    public Queue(){
        this.push = new Stack<Item>();
        this.pop = new Stack<Item>();
    }


    private void enqueue(Item item) {

        if(pop.size() != 0) {
            for (int i = 0; i < pop.size(); i++) {
                Item popItem = pop.pop();
                push.push(popItem);
            }
        }
        push.push(item);
    }

    private Item  dequeue() {
        if(push.size() == 0) {
            Item item = pop.pop();
            return item;
        } else {
            for (int i = 0 ; i < push.size(); i++) {
                Item popItem = push.pop();
                pop.push(popItem);
            }

            Item popItem = push.pop();
            return popItem;
        }

    }
}
