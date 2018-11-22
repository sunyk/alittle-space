### CollectionUtil Tool Class

~~~java
import java.util.Collection;
import java.util.Map;

public class CollectionUtil {
    public CollectionUtil() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotNullOrEmpty(Collection<? extends Object> collection) {
        return !isNullOrEmpty(collection);
    }

    public static boolean isNotNullOrEmpty(Map<? extends Object, ? extends Object> map) {
        return !isNullOrEmpty(map);
    }

    public static boolean isNullOrEmpty(Collection<? extends Object> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<? extends Object, ? extends Object> map) {
        return map == null || map.isEmpty();
    }
}
~~~

