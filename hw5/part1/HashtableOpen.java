package part1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @param <K>
 * @param <V>
 */
public class HashtableOpen<K,V> implements Map<K,V> {

    private Entry < K, V > [] table;
    private static final int START_CAPACITY = 67;
    private double LOAD_THRESHOLD = 0.85;
    private int numKeys;
    private int numDeletes;
    private final Entry < K, V > DELETED =
            new Entry < K, V > (null, null);

    /**
     * Constructor
     */
    public HashtableOpen() {
        table = new Entry[START_CAPACITY];
    }

    /**
     * Driver method for HashtableOpen
     * @param args
     */
    public static void main(String[] args){

        HashtableOpen<String,Integer> hashtable = new HashtableOpen<>();

        hashtable.put("Adana",322);
        hashtable.put("Maras",344);
        hashtable.put("Kocaeli",262);
        hashtable.put("Konya",332);
        hashtable.put("Malatya",422);
        hashtable.put("Aksaray",382);
        hashtable.put("Manisa",236);
        hashtable.put("Antalya",242);
        hashtable.put("Mugla",252);
        hashtable.put("Artvin",466);
        hashtable.put("Aydin",256);
        hashtable.put("Batman",488);
        hashtable.put("Bayburt",458);
        hashtable.put("Bilecik",228);
        hashtable.put("Sakarya",264);
        hashtable.put("Sinop",368);

        System.out.println("size() => "+ hashtable.size());
        System.out.println("getting Sinop => " + hashtable.get("Sinop"));
        System.out.println("put Sinop 500 => " + hashtable.put("Sinop",500));
        System.out.println("getting Sinop => " + hashtable.get("Sinop"));

        System.out.println();
        System.out.println("isEmpty() => "+ hashtable.isEmpty());

        System.out.println("removing Adana => "+hashtable.remove("Adana"));
        System.out.println("getting Adana => " + hashtable.get("Adana"));
        System.out.println("removing Maras => "+hashtable.remove("Maras"));

        System.out.println("size() :  "+ hashtable.size());
    }


    /** Returns the number of entries in the map */
    @Override
    public int size() {
        return numKeys;
    }

    /** Returns true if empty */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    /**
     * calculate HashCode
     * @param key
     * @return
     */
    private int calculateHashCode(Object key) {
        int result=key.hashCode() %  table.length;
        if (result < 0){
            result += table.length;
        }
        return result;
    }

    /**
     * calculate StepSize
     * @param key
     * @return
     */
    private int calculateStepSize(Object key) {
        return 7 - key.hashCode() % 7; }


    /**
     *
     * @param key
     * @return
     */
    public V get(Object key) {

        int index = calculateHashCode(key);
        int step = calculateStepSize(key);

        while (table[index].getValue() != null) {
            if (table[index].getKey().equals(key)){
                return table[index].getValue();
            }
            else {
                index += step; //if there is collusion
                index %= table.length;
            }
        }
        return null;
    }
    /**
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {

        int index = calculateHashCode(key);
        int step = calculateStepSize(key);

        while (table[index] != null && (!key.equals(table[index].key))) {
            index += step;
            index %= table.length;
        }
        if (table[index] == null) {
            table[index] = new Entry < K, V > (key, value);
            numKeys++;
            // Check whether rehash is needed.
            double loadFactor =
                    (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD){
                rehash();
                return null;}
        }
        V oldVal = table[index].getValue();
        table[index].setValue(value);
        return oldVal;
    }

    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     post: The size of table is doubled and is an odd integer.
     Each nondeleted entry from the original table is
     reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {

        // Save a reference to oldTable.
        Entry < K, V > [] oldTable = table;
        // Double capacity of this table.
        table = new Entry[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
                // Insert entry in expanded table
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V remove(Object key) {

        int index = calculateHashCode(key);
        int step = calculateStepSize(key);

        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                V oldValue = table[index].getValue();
                table[index] = DELETED;
                numKeys--;
                return oldValue;
            }
            index += step;
            index %= table.length;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }


    /** Contains key-value pairs for a hash table. */
    private static class Entry < K, V > {

        /** The key */
        private K key;

        /** The value */
        private V value;

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }



}
