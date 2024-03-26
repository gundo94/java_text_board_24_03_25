package com.sbs.exam.board;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static void makeTestData(List<Article> articles){
    articles.add(new Article(1, "제목1", "내용1"));
    articles.add(new Article(2, "제목2", "내용2"));
    articles.add(new Article(3, "제목3", "내용3"));

  }
  public static void main(String[] args) {
    System.out.println("== 자바 텍스트 게시판 0.1v ==");
    System.out.println("== 자바 텍스트 게시판 시작 ==");

    Scanner sc = new Scanner(System.in);
    int articleLastId = 0;

    List<Article> articles = new ArrayList<>();
    makeTestData(articles);

    if(articles.size()>0){
      articleLastId = articles.get(articles.size()-1).id;
    }

    while (true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();
      if (cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 작성 ==");
        System.out.printf("제목 : ");
        String title = sc.nextLine();

        System.out.printf("내용 : ");
        String body = sc.nextLine();

        int id = ++articleLastId;

        Article article = new Article(id, title, body);


        articles.add(article);
        System.out.printf("%d번 게시물이 생성되었습니다.\n", id);
      }
      else if (cmd.equals("/usr/article/list")) {
        System.out.println("== 게시물 리스트 ==");
        System.out.println("=================");
        System.out.println("번호 / 제목");
        System.out.println("=================");

        for (int i = articles.size()-1 ; i >=0 ;i--) {
          Article article = articles.get(i);
          System.out.printf("%d / %s\n", article.id, article.title);
        }
      }

      else if (cmd.equals("/usr/article/detail")) {

        Article article = articles.get(articles.size()-1);

        if(articles.isEmpty()) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        System.out.println("== 게시물 상세내용 ==");
        System.out.printf("번호 : %d\n", article.id);
        System.out.printf("제목 : %s\n", article.title);
        System.out.printf("내용 : %s\n", article.body);
      }

      else if (cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      System.out.printf("입력받은 명령어 : %s\n", cmd);
    }
    System.out.println("== 자바 텍스트 게시판 종료 ==");

    sc.close();
  }
}

class Article {
  int id;
  String title;
  String body;
  Article(int id, String title, String body){
    this.id = id;
    this.title = title;
    this.body = body;

  }
  public String toString() {
    return String.format("{id : %d, title : \"%s\", body : \"%s\" }",id, title, body);
  }
}