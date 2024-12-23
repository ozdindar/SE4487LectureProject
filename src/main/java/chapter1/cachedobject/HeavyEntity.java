package chapter1.cachedobject;

import java.util.HashMap;
import java.util.List;

public class HeavyEntity {

    private static HashMap<Long,HeavyEntity> cache= new HashMap<>();

    long id;
    List<String> attributes;

    public HeavyEntity(long id)
    {
        _readFromDB(id);
    }

    private void _readFromDB(long id) {
        // The heavy object is queried from DB
        // and attributes are filled
        System.out.println("Entity-"+ id + " is retrieved from DB");
    }


    public static HeavyEntity fromID(long id)
    {
        if ( cache.containsKey(id)) {
            System.out.println("Object is retrieved form cache");
            return cache.get(id);
        }
        else {
            HeavyEntity entity = new HeavyEntity(id);
            cache.put(id,entity);
            System.out.println("New object created..");
            return cache.get(id);
        }
    }

    public static void main(String[] args) {
        HeavyEntity e1= new HeavyEntity(1);
        e1= new HeavyEntity(2);
        e1= new HeavyEntity(1);


        e1= HeavyEntity.fromID(3);
        e1= HeavyEntity.fromID(4);
        e1= HeavyEntity.fromID(3);
        e1= HeavyEntity.fromID(4);


    }
}
