package others;

import java.util.Map;

/**
 * implement a queue using a map
 * @param <E>
 */
public class QueueImpl<E> {
    private long size;
    private long removedSoFar;
    private Map<Long,E> map;


    public boolean add(E object){
        map.put(size,object);
        size++;
        return true;
    }

    public E peek(){
        if (map.isEmpty()) {
            return null;
        }
        return map.get(removedSoFar);
    }

    public E remove(){
        if(map.isEmpty()){
            throw new NullPointerException();
        }
        removedSoFar++;
        return map.get(removedSoFar-1);

    }
}
