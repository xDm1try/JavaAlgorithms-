package ru.nsu.fit.muraviev.tinkoff.tinkoffBackend;

import java.util.*;

public class Task3 {

  public static class DirectoryWrapper{
    public String name;
    public List<DirectoryWrapper> subDirectories = new ArrayList<>();
    int offset;
    public DirectoryWrapper(String dirName, int offset) {
      this.name = dirName;
      this.offset = offset;
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();

    DirectoryWrapper root = null;
    for(int i = 0; i < N; i++){
      String path = input.next();
      String[] directories = path.split("/");
      if (root == null){
        root = new DirectoryWrapper(directories[0], 0);
      }
      DirectoryWrapper currentDir = root;
      for(int j = 1; j < directories.length; j++){
        String nextDir = directories[j];
        List<DirectoryWrapper> subDirs = currentDir.subDirectories.stream().filter(wrapper -> wrapper.name.equals(nextDir)).toList();
        if (subDirs.isEmpty()){
          DirectoryWrapper subDir = new DirectoryWrapper(nextDir, currentDir.offset + 1);
          currentDir.subDirectories.add(subDir);
          currentDir = subDir;
          continue;
        }else{
          currentDir = subDirs.get(0);
        }
      }
    }
    printDir(root);
  }

  public static void printDir(DirectoryWrapper root){
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < root.offset; i++) {
        stringBuilder.append("  ");
      }
      stringBuilder.append(root.name);
      System.out.println(stringBuilder);
    if (!root.subDirectories.isEmpty()){
      for (DirectoryWrapper subDir : root.subDirectories) {
        Task3.printDir(subDir);
      }
    }
  }
}
