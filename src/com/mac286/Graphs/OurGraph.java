package com.mac286.Graphs;

import java.util.*;

public class OurGraph <T>{
    private Map<T, ArrayList<T>> G;
    private int size;
    public OurGraph() {
        G = new HashMap<T, ArrayList<T>>();
        size = 0;
    }
    public void addEdge(T src, T dst){
        ArrayList<T> list = G.get(src);
        if(list == null){
            //first time I see src, create a list for it and add dst to it
            list = new ArrayList<>();
            if(dst != null) {
                list.add(dst);
            }
            //add the list with src to the map
            G.put(src, list);
            size++;
        }else if(list.contains(dst)){
            //the destination is already there, trying to add twice
            // System.out.println(dst + " is already there, trying to add twice");
            return;
        } else {
            list.add(dst);
        }
        //check if the destination has never been see before.
        list = G.get(dst);
        if(list == null){
            //first time I've seen dest, create a list for it and add it
            list = new ArrayList<>();
            list.add(src);
            G.put(dst, list);
            size++;
        }else{
            if(!list.contains(src)){
                list.add(src);
            }
        }
    }
    public String toString(){
        if(size == 0){
            return "{}";
        }
        String result = "";
        //get the set of the keys
        Set<T> keys = G.keySet();
        for(T key : keys){
            ArrayList<T> list = G.get(key);
            result += key +": " + list + "\n";
        }
        return result;
    }
    //TODO: HW8? Complete delete edge. If the dst is null then delete all edges that
    //connect src to any other node. If dst not null then remove dst from adjacency
    //list of src and remove src from adjacency list of dst.
    public void deleteEdge(T src, T dst){
        //if nothing to delete
        if(!G.containsKey(src)){
            return;
        }
        // delete all edges connected to src
        if(dst == null){
            ArrayList<T> neighbors = G.get(src);

            for(T neighbor : neighbors){
                ArrayList<T> list = G.get(neighbor);
                if(list != null){
                    list.remove(src);
                }
            }

            G.get(src).clear();
        }
        // delete only edge between src and dst
        else{
            ArrayList<T> srcList = G.get(src);
            if(srcList != null){
                srcList.remove(dst);
            }

            ArrayList<T> dstList = G.get(dst);
            if(dstList != null){
                dstList.remove(src);
            }
        }
    }
    public String DepthFirstSearch(T src){
        //create a set of visited nodes.
        Set<T> visited = new HashSet<T>();
        //create a string to contain the sequence of visited nodes.
        String sequence = "";
        //create a stack of nodes
        Stack<T> stack = new Stack<>();
        //push src into the stack
        stack.push(src);
        //loop as long as the stack is not empty
        while(!stack.isEmpty()) {
            //pop from stack n
            T n = stack.pop();
            //if n is not visited
            if(!visited.contains(n)) {
                //visit n (add n to the set of visited ans add it to the string
                visited.add(n);
                sequence += n + "\t";
                //go through all neighbors of n,
                ArrayList<T> list = G.get(n);
                for(T t : list){
                    //if not visited push to stack.
                    if(!visited.contains(t)) {
                        stack.push(t);
                    }
                }
            }
        }
        //return the string.
        return sequence;
    }
    //TODO: HW
    public String BreadthFirstSearch(T src){
        //create a set of visited nodes
        Set<T> visited = new HashSet<T>();
        //create a queue of nodes
        Queue<T> queue = new LinkedList<>();
        //create a sequence of visited nodes add to it src
        String sequence = "";
        //add src to queue
        queue.add(src);

        //loop while queue not empty
        while(!queue.isEmpty()){
            //remove from queue into n
            T n = queue.remove();
            //go through neighbors of n, if not visited visit and add to queue
            if(!visited.contains(n)){
                visited.add(n);
                sequence += n + "\t";
                ArrayList<T> list = G.get(n);
                for(int i = 0; i < list.size(); i++){
                    T neighbor = list.get(i);
                    if(!visited.contains(neighbor)){
                        queue.add(neighbor);
                    }
                }
            }
        }

        //return sequence.
        return sequence;
    }
}
