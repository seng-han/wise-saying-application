package com.ll.domain.wiseSaying.entity;


public class WiseSaying {
    private final int id;
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {//private로 설정해서 게터 메서드를 만들어 읽기만 허용 가능하게 함
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }
}