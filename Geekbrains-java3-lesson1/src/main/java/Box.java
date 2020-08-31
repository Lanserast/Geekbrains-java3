import java.util.*;

public class Box<T extends Fruit> {
    private ArrayList<T> Item_List;

    public Box(T... items) {
        this.Item_List = new ArrayList<T>(Arrays.asList(items));
    }

    public float getWeight() {
        float weight = 0;
        for (T item: Item_List) weight += item.getWeight();
        return weight;
    }
    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }
    public void Transfer_To(Box<? super T> box) {
        box.Item_List.addAll(this.Item_List);
        Item_List.clear();
    }
    public void add(T... items) {
        this.Item_List.addAll(Arrays.asList(items));
    }
}