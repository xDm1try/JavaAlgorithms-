package ru.nsu.fit.muraviev.yandexBackend;

import java.util.*;

import static java.lang.System.exit;

public class Task5 {
  public static ArrayList<Node> nodes = new ArrayList<>();
  public static ArrayList<Edge> edges = new ArrayList<>();

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();

    for (int i = 0; i < N; i++) {
      nodes.add(new Node(i, 'w', Integer.MAX_VALUE));
    }
    int M = input.nextInt();
    for (int i = 0; i < M; i++) {
      int U = input.nextInt();
      int V = input.nextInt();
      int T = input.nextInt();
      Edge edge = new Edge(U - 1, V - 1, T, 0, 0);
      edges.add(edge);
      edge = new Edge(V - 1, U - 1, T, 0, 0);
      edges.add(edge);
    }
    int K = input.nextInt();
    for (int i = 0; i < K; i++) {
      int U = input.nextInt();
      int V = input.nextInt();
      int T = input.nextInt();
      int C = input.nextInt();
      Edge edge = new Edge(U - 1, V - 1, T, C, i + 1);
      edges.add(edge);
      edge = new Edge(V - 1, U - 1, T, C, i + 1);
      edges.add(edge);
    }
    int P = input.nextInt();
    for (int i = 0; i < P; i++) {
      int A = input.nextInt();
      int B = input.nextInt();
      int T = input.nextInt();
      findPath2(A - 1, B - 1, T, 0, 0);
      answer.addAll(
          path.stream().filter(edge -> edge.number != 0 && !answer.contains(edge)).toList());
      nodes.stream()
          .forEach(
              node -> {
                node.state = 'w';
                node.currentPrice = Integer.MAX_VALUE;
              });
    }
    System.out.println(answer.size());
    for (int i = answer.size() - 1; i >= 0; i--) {
      System.out.print(answer.get(i).number + " ");
      System.out.println();
    }
  }

  public static ArrayList<Edge> path = new ArrayList<>();
  public static List<Edge> answer = new ArrayList<>();
  public static Edge edgeToNext;

  public static void findPath2(int A, int B, int T, int currentTiming, int currentPrice) {
    if (A == B) {
      return;
    }

    Node nodeA = nodes.get(A);
    nodeA.currentPrice = currentPrice;

    List<Edge> edgesToNeighbors =
        edges.stream()
            .filter(edge -> edge.from == A)
            .filter(edge -> nodes.get(edge.to).state == 'w')
            .peek(
                edge -> {
                  Node neighbor = nodes.get(edge.to);
                  neighbor.currentPrice =
                      Math.min(currentPrice + edge.price, neighbor.currentPrice);
                })
            .peek(
                edge -> {
                  if (edgeToNext == null || edgeToNext.to == A) {
                    edgeToNext = edge;
                  } else {
                    Node neighbor = nodes.get(edge.to);
                    Node nextNode = nodes.get(edgeToNext.to);
                    edgeToNext = neighbor.currentPrice < nextNode.currentPrice ? edge : edgeToNext;
                  }
                })
//            .filter(edge -> currentTiming + edge.time <= T)
            .sorted(Comparator.comparingInt(o -> o.time))
            .sorted(Comparator.comparingInt(o -> o.price))
            .toList();

    if (edgesToNeighbors.isEmpty()) {
      System.out.println(-1);
      exit(0);
    }

    nodeA.state = 'b';
    if (edgeToNext.number != 0) {
      path.add(edgeToNext);
    }
    findPath2(
        edgeToNext.to, B, T, currentTiming + edgeToNext.time, currentPrice + edgeToNext.price);
  }

  public static class Edge {
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

  public static class Node {
    public int number;
    public char state;
    public int currentPrice;

    public Node(int number, char state, int currentPrice) {
      this.number = number;
      this.state = state;
      this.currentPrice = currentPrice;
    }
  }
}
