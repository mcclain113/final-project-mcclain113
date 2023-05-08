package edu.wctc.maze;


import java.util.ArrayList;
import java.util.List;

public enum PrintQueue {
    INSTANCE;
    private List<String> printList = new ArrayList<>();
    public void enqueue(String str){
        printList.add(str);
    }
    public String flush(){
        String joinedString = String.join("\n", printList);
        printList.clear();
        return  joinedString;
    }
}

