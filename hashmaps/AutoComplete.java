import java.io.*;
import java.util.*;

//Daily Coding Problem #11 [9.20.2020]
//Implement an autocomplete system.
//Given a prefix string, and a set of all possible query strings, 
//retun a set of all possible strings starting with the given prefix.

class AutoComplete {

  private static class Node{
    String data = "";
    HashMap<String, Node> children = new HashMap<String, Node>();
    
    Node(String s){
      this.data = s;
    }
    
    Node(){
    }
    
    public String getData(){
      return data;
    }    
  }
  
  private static void addToTrie(Node node, String str){
    if (str.length() == 0) return;
      String s = str.substring(0, 1);
      String substring = str.substring(1);
      Node child = new Node(s);
    if (node.children.get(s) != null ){
      addToTrie(node.children.get(s), substring);
    }
    else {
      node.children.put(s, child);
      addToTrie(node.children.get(s), substring);
    }
  }
  
  //helper method to set up the recursion
  public static HashSet<String> evaluateTrie(Node trie, String prefix){ 
    HashSet<String> querySet = new HashSet<String>();
    if (prefix.length() == 0) return querySet;
    if (trie.children.isEmpty()) return querySet;
    querySet = evaluatePrefix(trie, prefix, new String());
    return querySet;
  }
  
  //depth first traversal, given a prefix
  public static HashSet<String> evaluatePrefix(Node node, String prefix, String query){
    HashSet<String> querySet = new HashSet<String>();
    query = query + node.getData();
    //given a prefix, traverse to the child matching the next letter in the prefix
      //return an empty Set if there is no match
    if (!prefix.isEmpty()){
      String match = prefix.substring(0, 1);
      if (node.children.get(match) != null){
        HashSet<String> childSet = 
          evaluatePrefix(node.children.get(match), prefix.substring(1), query);
        Iterator<String> childIterator = childSet.iterator();
        while (childIterator.hasNext()){
          querySet.add(childIterator.next());
        }
      }
      else {
        System.out.println("trie does not contain user input match");
        return querySet;
      }
    }
    //if you have traversed past the prefix, traverse to each child
    //each child returns a Set
     //add the strings in that Set to the querySet
    else {
      Set<String> childrenSet = node.children.keySet();
      Iterator<String> nodeIterator = childrenSet.iterator();
      while (nodeIterator.hasNext()){
        Node child = node.children.get(nodeIterator.next());
        HashSet<String> childSet = evaluatePrefix(child, prefix, query);
        Iterator<String> childIterator = childSet.iterator();
        while (childIterator.hasNext()){
          querySet.add(childIterator.next());
        }
      }
    }
    //if there are no children, return a Set of Strings with one element,
      //where that element is the query string built up in the traversal
    if (node.children.isEmpty()){
      querySet.add(query);
    } 
    //return querySet
    return querySet;
  }
  
  public static void main(String[] args) {    
    //prefix for testing
    String prefix = "d";
    
    //create and populate a queries Set for testing
    Set<String> queries = new HashSet<String>();
    queries.add("deer");
    queries.add("deal");
    queries.add("dog");
    queries.add("detroit");
    queries.add("defenestrate");
    queries.add("dubai");
    queries.add("dublin");
    queries.add("forest"); 
    queries.add("apple"); 
    
    //create the trie from the queries Set
    Iterator<String> iterator = queries.iterator();
    Node trie = new Node();
    while(iterator.hasNext()){
      String s = iterator.next();
      addToTrie(trie, s);
    }
    
    //evaluate against the trie, given a prefix
    HashSet<String> querySet = evaluateTrie(trie, prefix);
    
    Iterator<String> querySetIterator = querySet.iterator();
    while(querySetIterator.hasNext()){
      String s = querySetIterator.next();
      System.out.println(s);
    }   
  }  
}