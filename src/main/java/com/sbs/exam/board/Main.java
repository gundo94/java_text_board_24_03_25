package com.sbs.exam.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("== 자바 텍스트 게시판 0.1v ==");
    System.out.println("== 자바 텍스트 게시판 시작 ==");

    Scanner sc = new Scanner(System.in);
    int articleLastId = 0;
    while (true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();
      if (cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 작성 ==");
        System.out.printf("제목 : " );
        String title = sc.nextLine();

        System.out.printf("내용 : ");
        String body = sc.nextLine();

        int id = ++articleLastId ;

        Article article = new Article();
        article.id = id;
        article.title = title;
        article.body = body;
        System.out.println("생성 된 게시물 객체 : " + article);
        System.out.printf("%d번 게시물이 생성되었습니다.\n", id);
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
  public String toString() {
    return String.format("{id : %d, title : \"%s\", body : \"%s\" }",id, title, body);
  }
}