package kata5.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Luzma
 * @version 25-11-2020
 * @since Práctica de Laboratorio
 */
public class Histogram<T> {
    private final Map<T, Integer> map = new HashMap<>();
    
    public Integer get(T key){
        return this.map.get(key);
    }
    
    public Set<T> keySet(){
        return map.keySet();
    }
    
    public void increment(T key){
        map.put(key, map.containsKey(key)? map.get(key) + 1: 1);
    }        
}
