import java.util.*;

class ThroneInheritance {

    private Person king;
    private final HashMap<String, Person> map;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        map = new HashMap<>();
        map.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person parent = map.get(parentName);
        Person person = new Person(childName);
        parent.addChild(person);
        map.put(childName, person);
    }

    public void death(String name) {
        Person person = map.get(name);
        person.alive = false;
        map.remove(name);
    }

    public List<String> getInheritanceOrder() {
        ArrayList<String> res = new ArrayList<>();
        getInheritanceOrder(res, king);
        return res;
    }

    private void getInheritanceOrder(List<String> res, Person curKing) {
        if (curKing.alive){
            res.add(curKing.name);
        }
        for (Person person : curKing.child) {
            getInheritanceOrder(res, person);
        }
    }

    static class Person{
        String name;
        List<Person> child;
        boolean alive;

        Person(String name){
            this.name = name;
            this.child = new ArrayList<>();
            this.alive = true;
        }

        void addChild(Person child){
            this.child.add(child);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
