### 重写equals方法，必须重写hashcode

~~~java
@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null){
            return false;
        }
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
~~~

根据id和name去掉重复的`Person`对象,完整代码：

~~~java

~~~

### 验证结果：

~~~java
/**
 * @author sunyang
 * @date 2018/10/17 11:41
 */
public class PersonEqualsDemo {

    public static void main(String[] args) {
        Person p1 = new Person(1L, "SunAd1001");
        Person p2 = new Person(2L, "SunAd1002");
        Person p3 = new Person(3L, "SunAd1003");
        Person p4 = new Person(4L, "SunAd1004");
        Person p5 = new Person(5L, "SunAd1005");

        List<Person> persons = Arrays.asList(p1,p1,p1,p2,p3,p4,p5,p5);

        List<Person> resultList = new ArrayList<>();

        System.out.println(persons);
        persons.stream().forEach(person -> {
            if (!resultList.contains(person)){
                resultList.add(person);
            }
        });
        System.out.println(resultList);

    }
}
~~~

