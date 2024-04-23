package ru.nsu.fit.muraviev.yandexBackend;

import java.util.*;

import static java.lang.System.exit;

public class Task5 {
  public static ArrayList<Node> nodes = new ArrayList<>();
  public static ArrayList<Edge> edges = new ArrayList<>();
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();

    for(int i = 0; i < N; i++){
      nodes.add(new Node(i, 'w', Integer.MAX_VALUE));
    }
    int M = input.nextInt();
    for(int i = 0; i < M; i++){
      int U = input.nextInt();
      int V = input.nextInt();
      int T = input.nextInt();
      Edge edge = new Edge(U-1,V-1,T, 0, 0);
      edges.add(edge);
      edge = new Edge(V-1,U-1,T,0, 0);
      edges.add(edge);
    }
    int K = input.nextInt();
    for(int i = 0; i < K; i++){
      int U = input.nextInt();
      int V = input.nextInt();
      int T = input.nextInt();
      int C = input.nextInt();
      Edge edge = new Edge(U-1,V-1,T,C, i+1);
      edges.add(edge);
      edge = new Edge(V-1,U-1,T,C, i+1);
      edges.add(edge);
    }
    int P = input.nextInt();
    for(int i = 0; i< P; i++){
      int A = input.nextInt();
      int B = input.nextInt();
      int T = input.nextInt();
      findPath(A-1,B-1,T, 0, 0);
      answer.addAll(prevPath.stream().filter(edge -> edge.number != 0 && !answer.contains(edge)).toList());
      nodes.stream().forEach(node -> {
        node.state = 'w';
        node.currentPrice = Integer.MAX_VALUE;
      });
    }
    System.out.println(answer.size());
    for(int i = answer.size()-1; i>=0; i--){
      System.out.print(answer.get(i).number + " ");
    }
  }
  public static ArrayList<Edge> path = new ArrayList<>();
  public static List<Edge> answer = new ArrayList<>();
  public static ArrayList<Edge> prevPath = null;
  public static void findPath(int A, int B, int T, int currentTiming, int currentPrice){
    if (currentTiming > T){
      return;
    }
    if (A == B){
      if(prevPath == null){
        prevPath = new ArrayList<Edge>(path);
        return;
      }else{
        int prevPrice = prevPath.stream().filter(edge -> edge.number != 0 && !answer.contains(edge)).map(edge -> edge.price).reduce(0, Integer::sum);
        int newPrice = path.stream().filter(edge -> edge.number != 0 && !answer.contains(edge)).map(edge -> edge.price).reduce(0, Integer::sum);
        if (newPrice < prevPrice){
          prevPath = new ArrayList<Edge>(path);
        }
      }
      return;
    }
    Node node = nodes.get(A);
    node.state = 'g';
    node.currentPrice = currentTiming;
    List<Edge> nextEdges = new ArrayList<>(edges.stream().filter(edg -> nodes.get(edg.from).state == 'g').toList());
    if (nextEdges.isEmpty()){
      System.out.println(-1);
      exit(0);
    }
    Collections.sort(nextEdges, (o1, o2) -> o1.price - o2.price);
    for(Edge edg : nextEdges){
      if(nodes.get(edg.to).currentPrice > currentPrice + edg.price){
        path.add(edg);
        findPath(edg.to, B, T, currentTiming + edg.time, currentPrice + edg.price);
        path.remove(path.size()-1);
      }
    }
  }
  public static class Edge{
    int from;
    int to;
    int time;
    int price;
    int number;

    public Edge(int from, int to, int time, int price, int number) {
      this.from = from;
      this.to = to;
      this.time = time;
      this.price = price;
      this.number = number;
    }
  }
  public static class Node{
    public int name;
    public char state;
    public int currentPrice;

    public Node(int name, char state, int currentPrice) {
      this.name = name;
      this.state = state;
      this.currentPrice = currentPrice;
    }
  }

}
