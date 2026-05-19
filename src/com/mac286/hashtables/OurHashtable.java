package com.mac286.hashtables;

public class OurHashtable <K, T>{
    private class Node<KK, TT>{
        private KK key;
        private TT data;
        public Node(){
            key = null;
            data = null;
        }
        public Node(KK k, TT d){
            key = k;
            data = d;
        }
        public KK getKey() {
            return key;
        }
        public void setKey(KK key) {
            this.key = key;
        }
        public TT getData() {
            return data;
        }
        public void setData(TT data) {
            this.data = data;
        }
        @Override
        public String toString() {
            return key+ "=" + data;
        }
    }
    //Our hashtable will be implemented using an array of nodes
    private Node<K, T> [] H;
    private float loadFactor;
    private int size;
    public OurHashtable(){
        H = new Node[10];
        size = 0;
        loadFactor = 0.75f;
    }
    public OurHashtable(int cap){
        H = new Node[cap];
        size = 0;
        loadFactor = 0.75f;
    }
    public OurHashtable(int cap, float lf){
        H = new Node[cap];
        size = 0;
        loadFactor = lf;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    private int hashFunction(K k){
        //take the absolute value of java hashcode of k
        // and use modulo of the array length
        int index  = Math.abs(k.hashCode())%H.length;
        return index;
    }
    public void put(K k, T d){
        //find the index using the hash function
        int ind = hashFunction(k);
        //as long as H[index] is not null
        while(H[ind] != null) {
            //compare key to key of this elements if equal, replace
            //data and return
            if(k.equals(H[ind].key)){
                H[ind].setData(d);
                return;
            }
            //if not go to next element
            ind = ind + 1;
        }
        //If we get here at the end of the loop, means it does not exist
        //create a node.
        Node<K, T> n = new Node<>(k, d);
        //store the node in the current element.
        H[ind] = n;
        size++;
    }
    public T get(K k){
        int ind = hashFunction(k);
        //as long as H[index] is not null
        while(H[ind] != null) {
            //compare key to key of this elements if equal, replace
            //data and return
            if(k.equals(H[ind].key)){
                return H[ind].getData();
            }
            //if not go to next element
            ind = ind + 1;
        }
        return null;
    }
    public String toString(){
        if(this.isEmpty()){
            return "{}";
        }
        //start at 0, while empty move until we find the first
        //non empty element.
        int i = 0;
        while(H[i] == null)
            i++;
        String st = "{" + H[i];
        int s = 1;
        i++;
        for(int j = i+1; j < H.length && s < size; j++) {
            //continue the loop from that point on until the end
            //if current element is not null, add "," + element to it.
            if(H[j] != null){
                s++;
                st += ", " + H[j];
            }
        }
        return st + "}";
    }
    public T remove(){

        return null;
    }
}