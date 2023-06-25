


package hash;
public class Register<E> implements Comparable<Register<E>> {
    protected int key;
    protected E value;
    public Register(int key, E value){
        this.key = key;
        this.value = value;
    }
    public int compareTo(Register<E> r){
        return this.key = r.key;
    }
    public boolean equials(Object o){
        if(o instanceof Register){
            Register<E> r = (Register<E>)o;
            return r.key == this.key;
        }
        return false;
    }
    public int getkey(){
        return this.key;
    }
    public String toString(){
        return this.key+";"+this.value.toString();
    }
}
