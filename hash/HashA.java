

package hash;
/*
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class HashA<E extends Comparable<E>> {
    protected class Element {
        int mark;
        List<Register<E>> chain;
        public Element(int mark) {
            this.mark = mark;
            this.chain = new LinkedList<>();
        }
    }
    protected ArrayList<Element> table;
    protected int m;
    public HashA(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++)
            this.table.add(new Element(0));
    }
    private int functionHash(int key) {
        return key % m;
    }
    public void insert(int key, E value) {
        int hashIndex = functionHash(key);
        Element element = table.get(hashIndex);
        element.chain.add(new Register<>(key, value));
        element.mark = 1;
    } 
    public E search(int key) {
        int hashIndex = functionHash(key);
        Element element = table.get(hashIndex);
        for (Register<E> register : element.chain) {
            if (register.key == key) {
                return register.value;
            }
        }
        return null;
    }
    public String toString() {
        String s = "D.real\tD.Hash\tRegister\n";
        int i = 0;
        for (Element element : table) {
            s += (i++) + " -->\t";
            if (element.mark == 1) {
                for (Register<E> register : element.chain) {
                    s += functionHash(register.key) + "\t" + register + "\n";
                }
            } else {
                s += "empty\n";
            }
        }
        return s;
    }
  */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class HashA<E extends Comparable<E>> {
    protected class Element {
        int mark;
        List<Register<E>> chain;
        public Element(int mark) {
            this.mark = mark;
            this.chain = new LinkedList<>();
        }
    }    
    protected ArrayList<Element> table;
    protected int m;    
    public HashA(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++)
            this.table.add(new Element(0));
    }    
    private int squareHash(int key) {
        int square = key * key;
        String squareString = String.valueOf(square);
        int hash = Integer.parseInt(squareString.substring(squareString.length() - 2, squareString.length()));
        return hash;
    }         
    private int foldingHash(int key) {
        String keyString = String.valueOf(key);
        int sum = 0;
        for (int i = 0; i < keyString.length(); i += 2) {
            String chunk = keyString.substring(i, Math.min(i + 2, keyString.length()));
            sum += Integer.parseInt(chunk);
        }
        return sum % m;
    }    
    
    
    
    
    public void insert(int key, E value) {
        int hashIndex = squareHash(key); 
        Element element = table.get(hashIndex);
        element.chain.add(new Register<>(key, value));
        element.mark = 1;
    }    
    public E search(int key) {
        int hashIndex = squareHash(key);
        Element element = table.get(hashIndex);
        for (Register<E> register : element.chain) {
            if (register.key == key) {
                return register.value;
            }
        }
        return null;
    }    
    public String toString() {
        String s = "D.real\tD.Hash\tRegister\n";
        int i = 0;
        for (Element element : table) {
            s += (i++) + " -->\t";
            if (element.mark == 1) {
                for (Register<E> register : element.chain) {
                    s += squareHash(register.key) + "\t" + register + "\n"; 
                }
            } else {
                s += "empty\n";
            }
        }
        return s;
    }
}

