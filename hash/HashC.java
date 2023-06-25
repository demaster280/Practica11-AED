


package hash;
import java.util.ArrayList;
public class HashC<E extends Comparable<E>> {
    protected class Element {
        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }
    protected ArrayList<Element> table;
    protected int m;
    public HashC(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++)
            this.table.add(new Element(0, null));
    }
    private int functionHash(int key) {
        return key % m;
    }
    private int linearProbing(int hashIndex, int key) {
        int index = hashIndex;
        int i = 1;
        while (table.get(index).mark == 1 && table.get(index).reg.key != key) {
            index = (hashIndex + i) % m;
            i++;
        }
        return index;
    }  
    public void insert(int key, E reg) {
        int hashIndex = functionHash(key);
        int index = linearProbing(hashIndex, key);
        if (table.get(index).mark == 0) {
            table.set(index, new Element(1, new Register<>(key, reg)));
        } else {
            throw new DuplicateElementException("Element with key " + key + " already exists in the hash table.");
        }
    }
    public E search(int key) {
        int hashIndex = functionHash(key);
        int index = linearProbing(hashIndex, key);
        if (table.get(index).mark == 1 && table.get(index).reg.key == key) {
            return table.get(index).reg.value;
        } else {
            return null;
        }
    }
    public String toString() {
        String s = "D.real\tD.Hash\tRegister\n";
        int i = 0;
        for (Element item : table) {
            s += (i++) + " -->\t";
            if (item.mark == 1)
                s += functionHash(item.reg.key) + "\t" + item.reg + "\n";
            else
                s += "empty\n";
        }
        return s;
    }
}
