package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    public void actionList(List<WiseSaying> wiseSayings) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

    public void actionDelete(List<WiseSaying> wiseSayings, String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);

        if (removed) System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
        else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
    }

    public void actionModify(Scanner scanner, List<WiseSaying> wiseSayings, String cmd){
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        WiseSaying foundWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                foundWiseSaying = wiseSaying;
                break;
            }
        }

        if (foundWiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("명언(기존) : %s".formatted(foundWiseSaying.getContent()));
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.println("작가(기존) : %s".formatted(foundWiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        foundWiseSaying.setContent(content);
        foundWiseSaying.setAuthor(author);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
    }
}