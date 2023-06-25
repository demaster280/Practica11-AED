



package hash;
public class Test {
    public static void main(String[] args) {
        /* //PRUEBA UNO
        HashC<String> hashTable = new HashC<>(11);
        hashTable.insert(1, "John");
        hashTable.insert(2, "Alice");
        hashTable.insert(3, "Bob");
        hashTable.insert(4, "Jane");
        hashTable.insert(5, "Mike");
        hashTable.insert(6, "Emily");
        hashTable.insert(7, "Tom");
        hashTable.insert(8, "Sara");
        hashTable.insert(9, "David");
        hashTable.insert(10, "Linda");
        hashTable.insert(11, "Mark");
        System.out.println(hashTable);
        
        String value = hashTable.search(6);
        System.out.println("Valor Clave 6: " + value);         
        value = hashTable.search(11);
        System.out.println("Valor Clave 11: " + value);  
    }
    */
    /* //PRUEBA DOS
        HashC<String> hashTable = new HashC<>(11);

        hashTable.insert(34, "John");
        hashTable.insert(3, "Alice");
        hashTable.insert(30, "Jane");
        hashTable.insert(11, "Mike");
        hashTable.insert(8, "Emily");
        hashTable.insert(7, "Tom");
        hashTable.insert(23, "Sara");
        hashTable.insert(41, "David");
        hashTable.insert(16, "Linda");

        System.out.println(hashTable);
        
        String value = hashTable.search(7);
        System.out.println("Valor Clave 7: " + value);         
        value = hashTable.search(16);
        System.out.println("Valor Clave 16: " + value);  
    }
    */
    /* //PRUEBA TRES
    HashA<String> hashTable = new HashA<>(7);
        hashTable.insert(1, "John");
        hashTable.insert(2, "Alice");
        hashTable.insert(3, "Bob");
        hashTable.insert(4, "Jane");
        hashTable.insert(5, "Mike");
        hashTable.insert(6, "Emily");
        hashTable.insert(7, "Tom");

        System.out.println(hashTable);

        String value = hashTable.search(3);
        System.out.println("Valor Clave 3: " + value);
        value = hashTable.search(6);
        System.out.println("Valor Clave 6: " + value);
    }
    */
    HashA<String> hashTable = new HashA<>(7);

        hashTable.insert(34, "John");
        hashTable.insert(3, "Alice");
        hashTable.insert(7, "Bob");
        hashTable.insert(30, "Jane");
        hashTable.insert(11, "Mike");
        hashTable.insert(8, "Emily");
        hashTable.insert(23, "Sara");
        hashTable.insert(41, "David");
        hashTable.insert(16, "Linda");
        hashTable.insert(34, "Mark");

        System.out.println(hashTable);

        String value = hashTable.search(3);
        System.out.println("Valor Clave 3: " + value);
        value = hashTable.search(16);
        System.out.println("Valor Clave 16: " + value);
    }
}



