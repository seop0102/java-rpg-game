package MyCafe;


import java.util.Random;

import java.util.Scanner;


public class CafeGame {

        static int score, money, random_num, income, day, coffeenum, interiorcount, putoutcount, gamblecount, lottocount,

                        cafetotal;

        static String cafe_name;

        static int[] cafescore = { 100, 200, 300, 400, 500 }; // 카페 default score 설정

        static String[] battle_cafe = { "컴포즈커피", "메가커피", "이디야", "공차", "스타벅스" }; // default name 설정


        public static void main(String[] args) {

                System.out.println("\n<현재 카페 목록>");

                System.out.println("내 카페 score : " + score);

                for (int i = 1; i <= battle_cafe.length; i++) { // 시작할 때 카페목록 리스트

                        System.out.println(i + " : " + battle_cafe[i - 1] + "의 score : " + cafescore[i - 1]);

                }

                Scanner sc = new Scanner(System.in);


                System.out.println("     _______.    .__________.        ___           ______        .__________.          ");

                System.out.println(

                                "    /       |    |          |       /   \\         |   _  \\       |          |               ");

                System.out.println("   |   (----'    `---|  |---`      /  ^  \\        |  |_)  |      `---|  |---`      ");

                System.out.println("    \\   \\            |  |         /  /_\\  \\       |      /           |  |       ");

                System.out.println(".----)   |           |  |        /  _____  \\      |  |\\  \\           |  |     ");

                System.out.println("|_______/            |__|       /__/     \\__\\     |__| \\__`.         |__|    ");


                ConsoleOutPut.showCafe(cafe_name); // 카페 그림출력 showCafe();

                for (day = 1; day <= 10; day++) {

                        if (Activity.cafetotal == 5) {

                                break;

                        }

                        for (int i = 0; i < cafescore.length; i++) { // 프렌차이즈 카페 score 증가

                                int cafedayscore = 100; // 카페 업그레이드 금액

                                cafescore[i] += cafedayscore + cafedayscore * i; // 5번 카페 = 100+500

                        }

                        money = Activity.sell(money, day);

                        System.out.println("\n!" + day + "일차 밤!");

                        System.out.println("밤에 할 활동을 선택하세요!");

                        if (day % 2 == 1) {

                                gamblecount = 0;

                                lottocount = 0;

                                putoutcount = 0;

                                while (true) {

                                        if (CafeGame.day == 0) {

                                                break;

                                        }

                                        if (Activity.cafetotal == 5) {

                                                break;

                                        }

                                        System.out.print("\n");

                                        System.out.println("현재 money : " + CafeGame.money);

                                        System.out.println("현재 score : " + CafeGame.score);

                                        System.out.println("\n<<<밤에 할 수 있는 활동>>>");

                                        System.out.println("1. 폐업시키기");

                                        System.out.println("2. 도박");

                                        System.out.println("3. 인테리어 상점");

                                        System.out.println("4. 다음날으로 넘어가기");

                                        System.out.print("번호를 입력하세요! : ");

                                        int num = sc.nextInt();

                                        if (num == 1) { // 폐업시키기

                                                if (putoutcount < 1) {

                                                        putoutcount++;

                                                        Activity.putOut(score, cafescore); // 폐업시키기

                                                } else {

                                                        System.out.println("폐업시키기는 하루에 한 번만 가능합니다!");

                                                }

                                        }

                                        if (num == 2) { // 도박 (가위바위보)

                                                if (gamblecount < 2) {

                                                        gamblecount++;

                                                        Activity.gamble(money);

                                                } else {

                                                        System.out.println("도박은 하루에 두번만 가능합니다!");

                                                }

                                        }

                                        if (num == 3) {

                                                Interior.buyStuff(cafe_name, money, score); // 인테리어 상점 가기

                                        }

                                        if (num == 4) { // 다음날로 넘어갈 때 카페 목록 출력

                                                System.out.println("\n<현재 카페 목록>");

                                                System.out.println("내 카페 score : " + score);

                                                for (int i = 1; i <= battle_cafe.length; i++) {

                                                        System.out.println(i + " : " + battle_cafe[i - 1] + "의 score : " + cafescore[i - 1]);

                                                }

                                                break; // 다음날로 넘어가기

                                        }

                                } // while 문 종료

                        } else if (day % 2 == 0 && day != 10) {

                                gamblecount = 0;

                                lottocount = 0;

                                putoutcount = 0;

                                int interiorcount = 0;

                                while (true) {

                                        if (CafeGame.day == 0) {

                                                break;

                                        }

                                        if (Activity.cafetotal == 5) {

                                                break;

                                        }

                                        System.out.println("현재 money : " + CafeGame.money);

                                        System.out.println("현재 score : " + CafeGame.score);

                                        System.out.println("\n<<<밤에 할 수 있는 활동>>>");

                                        System.out.println("1. 폐업시키기");

                                        System.out.println("2. 도박");

                                        System.out.println("3. 로또");

                                        System.out.println("4. 인테리어 상점");

                                        System.out.println("5. 다음날으로 넘어가기");

                                        System.out.print("활동 번호를 입력하세요! : ");

                                        int num = sc.nextInt();

                                        if (num == 1) { // 폐업시키기

                                                if (putoutcount < 1) {

                                                        putoutcount++;

                                                        Activity.putOut(score, cafescore); // 폐업시키기

                                                } else {

                                                        System.out.println("폐업시키기는 하루에 한 번만 가능합니다!");

                                                }

                                        }

                                        if (num == 2) {

                                                if (gamblecount < 2) {

                                                        Activity.gamble(money); // 도박 (가위바위보)

                                                        gamblecount++;

                                                } else {

                                                        System.out.println("도박은 하루에 두 번만 가능합니다!");

                                                }

                                        }

                                        if (num == 3) {

                                                if (lottocount < 1) {

                                                        Activity.lotto(money); // 로또 (번호 맞추기 게임)

                                                        lottocount++;

                                                } else {

                                                        System.out.println("로또는 짝수날 한 번만 가능합니다!");

                                                }

                                        }

                                        if (num == 4) {

                                                Interior.buyStuff(cafe_name, money, score); // 인테리어 상점 넘어가기

                                                interiorcount++;


                                        }

                                        if (num == 5) {

                                                System.out.println("\n<현재 카페 목록>");

                                                System.out.println("내 카페 score : " + score);

                                                for (int i = 1; i <= battle_cafe.length; i++) {

                                                        System.out.println(i + " : " + battle_cafe[i - 1] + "의 score : " + cafescore[i - 1]);

                                                }

                                                break; // 다음날 넘어가기

                                        }

                                } // while문 종료

                        } else { // day == 10

                                System.out.println("1. 폐업시키기 (1회) ");

                                System.out.println("2. 결과 보기");

                                System.out.println("10일차 활동을 선택해주세요!  :  ");

                                int number = sc.nextInt();

                                if (number == 1) {

                                        int last = 0;

                                        if (last < 1) {

                                                Activity.putOut(score, cafescore); // 폐업만 가능

                                                last++;

                                        } else {

                                                System.out.println("폐업시킬 기회를 소진하셨습니다.");

                                        }

                                }

                                if (number == 2) {

                                        if (Activity.cafenum1 > 0 && Activity.cafenum2 > 0 && Activity.cafenum3 > 0 && Activity.cafenum4 > 0

                                                        && Activity.cafenum5 > 0) {

                                                ConsoleOutPut.showSuccess();

                                        } else {

                                                ConsoleOutPut.showFailed();

                                        }


                                } else {

                                        System.out.println("1과 2 중에 선택해 주세요! ");

                                }


                        }

                } // for 문 종료

        } // 메인메서드

} // 클래스 종료


class Activity {

        static int cafenum1 = 0, cafenum2 = 0, cafenum3 = 0, cafenum4 = 0, cafenum5 = 0, cafetotal = 0;

        static int putoutcount;


        static int sell(int money, int day) {

                Scanner sc = new Scanner(System.in);

                System.out.println("\n\n*******************");

                System.out.println("!" + day + "일차 낮!");

                System.out.println(day + "일차 커피 판매를 시작합니다!");

                System.out.println("<<<메뉴판>>>");

                System.out.println("1. 아메리카노 300원 (손님 수 1~3)");

                System.out.println("2. 카페라떼 500원 (손님 수 0~5)");

                System.out.print(" 판매할 커피의 번호를 입력해 주세요! ");

                int coffeenum = sc.nextInt();

                if (coffeenum == 1) {

                        Random random = new Random();

                        int random_num1 = random.nextInt(3) + 1;

                        int income = 300 * random_num1;

                        System.out.println(" /\\_/\\");

                        System.out.println("( o.o ) ----- 커피를 팔고 있습니다! ");

                        System.out.println(" > ^ <");

                        System.out.println(day + "일차 손님은 " + random_num1 + "명으로 수입이 " + income + "입니다!");

                        money += income;

                        System.out.println("현재 보유 자산은 " + money + "원 입니다!");

                        return money;

                } else if (coffeenum == 2) {

                        Random random = new Random();

                        int random_num2 = random.nextInt(6);

                        int income = 500 * random_num2;

                        System.out.println(" /\\_/\\");

                        System.out.println("( o.o ) ----- 커피를 팔고 있습니다! ");

                        System.out.println(" > ^ <");

                        if (random_num2 == 0) {

                                System.out.println(" 손님이 0명이므로 내 카페가 폐업됩니다! ");

                                ConsoleOutPut.showFailed();

                        }

                        if (random_num2 != 0) {

                                System.out.println(day + "일차 손님은 " + random_num2 + "명으로 수입이 " + income + "입니다!");

                                money += income;

                                System.out.println("현재 보유 자산은 " + money + "원 입니다!");

                        }

                        return money;

                } else {

                        System.out.println("번호를 다시 입력하세요!");

                        sell(money, day);

                        return money;

                }

        }


        static void gamble(int money) { // 도박 가위바위보

                Scanner sc = new Scanner(System.in);

                Random random = new Random();

                System.out.println("\nnpc와 가위바위보를 시작합니다!");

                String what_npc;

                while (true) {

                        System.out.print("가위(1), 바위(2), 보(3) 중에 숫자를 고르세요! : ");

                        int myPick = sc.nextInt(); // 자신이 낸 것

                        if (myPick < 1 || myPick > 3) {

                                System.out.println("다시 고르세요!");

                                continue;

                        }

                        int npcPick = random.nextInt(3) + 1; // npc가 무작위로 낼 것

                        if (npcPick == 1) {

                                what_npc = "가위";

                        } else if (npcPick == 2) {

                                what_npc = "바위";

                        } else {

                                what_npc = "보";

                        }

                        if (myPick == npcPick) { // 같으면 비김

                                System.out.println("컴퓨터도 '" + what_npc + "’ 를 냈습니다!");

                                System.out.println("비겨서 상금은 없습니다!");

                                break;

                        } else if ((myPick == 1 && npcPick == 3) || (myPick == 2 && npcPick == 1)

                                        || (myPick == 3 && npcPick == 2)) {

                                System.out.println("컴퓨터는 '" + what_npc + "' 를 냈습니다!");

                                System.out.println("컴퓨터를 상대로 이기셨네요! 1000원을 획득하습니다!");

                                CafeGame.money += 1000;

                                break;

                        } else {

                                System.out.println("컴퓨터는 '" + what_npc + "' 를 냈습니다!");

                                System.out.println("졌습니다!");

                                break;

                        }

                }

        }


        static void lotto(int money) {

                Random random = new Random();

                int lotto_Number = random.nextInt(90) + 10; // 무작위 로또 번호

                int trynum = 0;

                int maxnum = 5;

                Scanner sc = new Scanner(System.in);

                while (trynum < maxnum) {

                        System.out.println("\n로또 번호 두자리를 다섯번만에 맞춰보세요 ! : ");

                        int guessnum = sc.nextInt();

                        if (guessnum == lotto_Number) {

                                System.out.println("정답입니다! money 3000원을 획득하셨습니다!");

                                CafeGame.money += 3000;

                                break;

                        } else if (guessnum < lotto_Number) {

                                System.out.println("Up!");

                        } else {

                                System.out.println("Down!");

                        }

                        trynum++;

                        if (trynum < maxnum) {

                                System.out.println("틀렸습니다!");

                        }

                }

                if (trynum == maxnum) {

                        System.out.println("틀렸습니다. 정답은 " + lotto_Number + "이었습니다.");

                }

                System.out.println("lotto를 종료합니다 ! ");

        }


        static void putOut(int score, int[] cafescore) {

                System.out.println("\n<현재 카페 목록>");

                System.out.println("내 카페 score : " + score);

                for (int i = 1; i <= CafeGame.battle_cafe.length; i++) {

                        System.out.println(i + " : " + CafeGame.battle_cafe[i - 1] + "의 score : " + cafescore[i - 1]);

                }

                System.out.println();

                Scanner sc = new Scanner(System.in);

                System.out.print("폐업시킬 카페의 번호를 입력하세요! : ");

                int pickBattleCafe = sc.nextInt();

                int cafe_index = pickBattleCafe - 1;


                System.out.println("\n!폐업시키기 결과!");

                if (pickBattleCafe == 1) {

                        if (score >= CafeGame.cafescore[cafe_index]) {

                                if (cafenum1 < 1) {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "가 폐업 되었습니다!");

                                        score += CafeGame.cafescore[cafe_index]; // 스코어를 더한다.

                                        CafeGame.battle_cafe[cafe_index] = "폐업된 카페"; // 폐업되면 이름을 폐업된 카페로 변경한다.

                                        cafenum1++;

                                        cafetotal++; // 폐업시킨 카페 카운트

                                } else {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "는 이미 폐업된 카페입니다.");

                                        CafeGame.putoutcount--; // 이미 폐업된 카페 선택시 기회 다시 부여

                                }

                        } else {

                                System.out.println("내 score가 " + CafeGame.battle_cafe[cafe_index] + " score 보다 낮습니다.");

                                System.out.println("따라서 내 카페가 폐업됩니다!");

                                ConsoleOutPut.showFailed();

                        }

                }

                if (pickBattleCafe == 2) {

                        if (score >= CafeGame.cafescore[cafe_index]) {

                                if (cafenum2 < 1) {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "가 폐업 되었습니다!");

                                        score += CafeGame.cafescore[cafe_index];

                                        CafeGame.battle_cafe[cafe_index] = "폐업된 카페";

                                        cafenum2++;

                                        cafetotal++; // 폐업시킨 카페 카운트

                                } else {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "는 이미 폐업된 카페입니다.");

                                        CafeGame.putoutcount--;

                                }

                        } else {

                                System.out.println("내 score가 " + CafeGame.battle_cafe[cafe_index] + " score 보다 낮습니다.");

                                System.out.println("따라서 내 카페가 폐업됩니다!");

                                ConsoleOutPut.showFailed();

                        }

                }

                if (pickBattleCafe == 3) {

                        if (score >= CafeGame.cafescore[cafe_index]) {

                                if (cafenum3 < 1) {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "가 폐업 되었습니다!");

                                        score += CafeGame.cafescore[cafe_index];

                                        CafeGame.battle_cafe[cafe_index] = "폐업된 카페";

                                        cafenum3++;

                                        cafetotal++; // 폐업시킨 카페 카운트

                                } else {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "는 이미 폐업된 카페입니다.");

                                        CafeGame.putoutcount--;

                                }

                        } else {

                                System.out.println("내 score가 " + CafeGame.battle_cafe[cafe_index] + " score 보다 낮습니다.");

                                System.out.println("따라서 내 카페가 폐업됩니다!");

                                ConsoleOutPut.showFailed();

                        }

                }

                if (pickBattleCafe == 4) {

                        if (score >= CafeGame.cafescore[cafe_index]) {

                                if (cafenum4 < 1) {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "가 폐업 되었습니다!");

                                        score += CafeGame.cafescore[cafe_index];

                                        CafeGame.battle_cafe[cafe_index] = "폐업된 카페";

                                        cafenum4++;

                                        cafetotal++; // 폐업시킨 카페 카운트

                                } else {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "는 이미 폐업된 카페입니다.");

                                        CafeGame.putoutcount--;

                                }

                        } else {

                                System.out.println("내 score가 " + CafeGame.battle_cafe[cafe_index] + " score 보다 낮습니다.");

                                System.out.println("따라서 내 카페가 폐업됩니다!");

                                ConsoleOutPut.showFailed();

                        }

                } else if (pickBattleCafe == 5) {

                        if (score >= CafeGame.cafescore[cafe_index]) {

                                if (cafenum5 < 1) {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "가 폐업 되었습니다!");

                                        score += CafeGame.cafescore[cafe_index];

                                        CafeGame.battle_cafe[cafe_index] = "폐점된 카페";

                                        cafenum5++;

                                        cafetotal++; // 폐업시킨 카페 카운트

                                } else {

                                        System.out.println(CafeGame.battle_cafe[cafe_index] + "는 이미 폐업된 카페입니다.");

                                        CafeGame.putoutcount--;

                                }

                        } else {

                                System.out.println("내 score가 " + CafeGame.battle_cafe[cafe_index] + " score 보다 낮습니다.");

                                System.out.println("따라서 내 카페가 폐업됩니다!");

                                ConsoleOutPut.showFailed();

                        }

                }

                if (cafetotal == 5) {

                        ConsoleOutPut.showSuccess();

                }

                CafeGame.score = score;

        } // putout메서드

} // Activity class


class Interior {

        static int interiorCount1, interiorCount2, interiorCount3, interiorCount4, interiorCount5 = 0;


        static void buyStuff(String cafe_name, int money, int score) {

                Scanner sc = new Scanner(System.in);

                String[] interiors = { "간판", "조명", "창문", "문", "지붕" };

                int[] prices = { 500, 1000, 1500, 2000, 2500 };

                int[] scores = { 200, 300, 400, 500, 600 };

                System.out.println("\n<인테리어 상점입니다>\n");

                System.out.println("0. 메뉴로 넘어가기");

                for (int i = 0; i < interiors.length; i++) {

                        System.out.println((i + 1) + ". " + interiors[i] + " (" + scores[i] + "점, " + prices[i] + "원)");

                }

                System.out.println();

                System.out.println("현재 money : " + money);

                System.out.println("현재 score : " + score);

                System.out.print("구매하실 인테리어를 선택해주세요! : ");

                int interior_num = sc.nextInt();

                System.out.println("<<<현재 내 카페 모습>>>\n");

                int index = interior_num - 1;

                if (index == 0) {// 간판 구입

                        if (money >= prices[index]) {

                                if (interiorCount1 < 1) {

                                        ConsoleOutPut.cafe[13] = "         |                    MY CAFE                     |                         ";

                                        score += scores[index];

                                        money -= prices[index];

                                        interiorCount1++;

                                } else {

                                        System.out.println("이미 구입했습니다!");

                                        buyStuff(cafe_name, money, score);

                                }

                        } else {

                                System.out.println("돈이 부족해서 구입할 수 없습니다!");

                                buyStuff(cafe_name, money, score);

                        }

                }

                if (index == 1) {// 조명 구입

                        if (money >= prices[index]) {

                                if (interiorCount2 < 1) {

                                        ConsoleOutPut.cafe[0] = "                              _________ ";

                                        ConsoleOutPut.cafe[1] = "                              | .   . | ";

                                        ConsoleOutPut.cafe[2] = "                              |   v   | ";

                                        ConsoleOutPut.cafe[3] = "                              |_______| ";

                                        ConsoleOutPut.cafe[4] = "                                  |     ";

                                        score += scores[index];

                                        money -= prices[index];

                                        interiorCount2++;

                                } else {

                                        System.out.println("이미 구입했습니다!");

                                        buyStuff(cafe_name, money, score);

                                }

                        } else {

                                System.out.println("돈이 부족해서 구입할 수 없습니다!");

                                buyStuff(cafe_name, money, score);

                        }

                }

                if (index == 2) {// 창문 구입

                        if (money >= prices[index]) {

                                if (interiorCount3 < 1) {

                                        ConsoleOutPut.cafe[16] = "            |     .------------.                       |                            "; // 16

                                        ConsoleOutPut.cafe[17] = "            |     |     |      |                       |                            "; // 17

                                        ConsoleOutPut.cafe[18] = "            |     |-----|------|                       |                            "; // 18

                                        ConsoleOutPut.cafe[19] = "            |     |     |      |                       |                            "; // 19

                                        ConsoleOutPut.cafe[20] = "            |     .------------.                       |                            ";

                                        score += scores[index];

                                        money -= prices[index];

                                        interiorCount3++;

                                } else {

                                        System.out.println("이미 구입했습니다!");

                                        buyStuff(cafe_name, money, score);

                                }

                        } else {

                                System.out.println("돈이 부족해서 구입할 수 업습니다!");

                                buyStuff(cafe_name, money, score);

                        }

                }

                if (index == 3) {// 문 구입

                        if (money >= prices[index]) {

                                if (interiorCount4 < 1) {

                                        ConsoleOutPut.cafe[22] = "            |                          |=========|     |                            "; // 22

                                        ConsoleOutPut.cafe[23] = "            |                          |         |     |                            "; // 23

                                        ConsoleOutPut.cafe[24] = "            |                          |         |     |                            "; // 24

                                        ConsoleOutPut.cafe[25] = "            |                          |         |     |                            "; // 25

                                        ConsoleOutPut.cafe[26] = "            |                          | #       |     |                            "; // 26

                                        ConsoleOutPut.cafe[27] = "            |                          |         |     |                            "; // 27

                                        ConsoleOutPut.cafe[28] = "            |                          |         |     |                            "; // 28

                                        ConsoleOutPut.cafe[29] = "            |                          |=========|     |                            ";

                                        score += scores[index];

                                        money -= prices[index];

                                        interiorCount4++;

                                } else {

                                        System.out.println("이미 구입했습니다!");

                                        buyStuff(cafe_name, money, score);

                                }

                        } else {

                                System.out.println("돈이 부족해서 구입할 수 업습니다!");

                                buyStuff(cafe_name, money, score);

                        }

                }

                if (index == 4) {// 지붕 구입

                        if (money >= prices[index]) {

                                if (interiorCount5 < 1) {

                                        ConsoleOutPut.cafe[6] = "                  /     * * * * * * * * * *      \\                                  ";

                                        ConsoleOutPut.cafe[7] = "                 /     * * * * * * * * * * * *    \\                                 ";

                                        ConsoleOutPut.cafe[8] = "                /    * * * * * * * * * * * * * *   \\                                ";

                                        ConsoleOutPut.cafe[9] = "               /   * * * * * * * * * * * * * * * *  \\                               ";

                                        ConsoleOutPut.cafe[10] = "              /  * * * * * * * * * * * * * * * * * * \\                              ";

                                        score += scores[index];

                                        money -= prices[index];

                                        interiorCount5++;

                                } else {

                                        System.out.println("이미 구입했습니다!");

                                        buyStuff(cafe_name, money, score);

                                }

                        } else {

                                System.out.println("돈이 부족해서 구입할 수 업습니다!");

                                buyStuff(cafe_name, money, score);

                        }

                }

                if (index == -1) {

                        System.out.println("아무 행동도 하지 않습니다.");

                }

                ConsoleOutPut.showCafe(cafe_name);

                CafeGame.money = money;

                CafeGame.score = score;

        }

}


class ConsoleOutPut {

        static String[] cafe = { "", // 0

                        "", // 1

                        "", // 2

                        "", // 3

                        "", // 4

                        "                   =============================                                    ", // 5

                        "                  /                             \\                                  ", // 6

                        "                 /                               \\                                 ", // 7

                        "                /                                 \\                                ", // 8

                        "               /                                   \\                               ", // 9

                        "              /                                     \\                              ", // 10

                        "         ==================================================                         ", // 11

                        "         |                                                |                         ", // 12

                        "         |                                                |                         ", // 13

                        "         |                                                |                         ", // 14

                        "         ==================================================                         ", // 15

                        "            |                                          |                            ", // 16

                        "            |                                          |                            ", // 17

                        "            |                                          |                            ", // 18

                        "            |                                          |                            ", // 19

                        "            |                                          |                            ", // 20

                        "            |                                          |                            ", // 21

                        "            |                                          |                            ", // 22

                        "            |                                          |                            ", // 23

                        "            |                                          |                            ", // 24

                        "            |                                          |                            ", // 25

                        "            |                                          |                            ", // 26

                        "            |                                          |                            ", // 27

                        "            |                                          |                            ", // 28

                        "            |                                          |                            ", // 29

                        "            |                                          |                            ", // 30

                        "          ================================================                          ", // 31

                        "          ================================================                          ", // 32

                        "*********************************************************************               ", // 33

                        "*********************************************************************               " };


        static void showCafe(String cafe_name) { // 카페 그림 출력 메서드

                for (String line : cafe) {

                        System.out.println(line);

                }

        }


        static void showSuccess() {

                System.out.println(

                                "     _______.    __    __       ______       ______       _______        _______.      _______.       ___   ___       ");

                System.out.println(

                                "    /       |   |  |  |  |     /      |     /      |     |  _____|      /       |     /       |      |  |  |  |       ");

                System.out.println(

                                "   |   (----'   |  |  |  |    |  ,----'    |  ,----'     |  |___       |   (----`    |   (----`      |  |  |  |  ");

                System.out.println(

                                "    \\   \\       |  |  |  |    |  |         |  |          |   ___|       \\   \\         \\   \\          |__|  |__|     ");

                System.out.println(

                                ".----)   |      |  `--'  |    |  `----.    |  `----.     |  |____   .----)   |    .----)   |          __    __ ");

                System.out.println(

                                "|_______/        \\______/      \\______|     \\______|     |_______|  |_______/     |_______/          |__|  |__|");

        }


        static void showFailed() {

                CafeGame.day = 0; // 종료시 날짜 초기화

                CafeGame.score = 0; // 종료시 user 스코어 초기화

                CafeGame.money = 0; // 종료시 user money 초기화

                int[] newCafeScores = { 100, 200, 300, 400, 500 }; // 종료시 카페 스코어 초기화 배열 선언

                CafeGame.cafescore = newCafeScores; // 종료시 카페 스코어 초기화 배열 입력

                System.out.println("            _______      ___        __     __                   ");

                System.out.println("           |   ____|    /   \\      |  |   |  |                  ");

                System.out.println("           |  |__      /  ^  \\     |  |   |  |                   ");

                System.out.println("           |   __|    /  /_\\  \\    |  |   |  |                   ");

                System.out.println("           |  |      /  _____  \\   |  |   |  `----.    __  __  __ ");

                System.out.println("           |__|     /__/     \\__\\  |__|   |_______|   (__)(__)(__)");

                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

                System.out.println("* * * * * * * * * * * * * 게임 초기화 * * * * * * * * * * * * *");

                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        }

}

