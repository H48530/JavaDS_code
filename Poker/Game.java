import java.util.ArrayList;
import java.util.Random;

/**
 * 游戏
 */
public class Game {

    public static void main(String[] args) {
        //1、初始化一副牌
        ArrayList<Card> cardlist = initCardList();

        //2、洗牌
        shuffle(cardlist);

        //3、进行发牌
        //准备3位玩家，
        ArrayList<Card> playerA = new ArrayList<>();
        ArrayList<Card> playerB = new ArrayList<>();
        ArrayList<Card> playerC = new ArrayList<>();
        //抓牌前 打印这副牌观察
        System.out.println("抓牌前");
        System.out.println(cardlist);
        //抓牌
        for (int i = 0; i <= 5; i++) {
            Card card = cardlist.remove(0);
            playerA.add(card);
            card = cardlist.remove(0);
            playerB.add(card);
            card = cardlist.remove(0);
            playerC.add(card);
        }
        //抓牌后
        System.out.println("抓牌后");
        System.out.println(cardlist);
        System.out.println(cardlist.size());    // 52 - 15 = 37
        System.out.println("A: " + playerA);
        System.out.println("B: " + playerB);
        System.out.println("C: " + playerC);

    }

    //洗牌算法
    private static void shuffle(ArrayList<Card> cardlist) {
        Random random = new Random();
        for (int i = cardlist.size() - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i);
            Card A = cardlist.get(i);
            Card B = cardlist.get(randomIndex);
            cardlist.set(i, B);
            cardlist.set(randomIndex, A);
        }
    }

    //初始化这副牌
    private static ArrayList<Card> initCardList() {
        ArrayList<Card> cardlist = new ArrayList<>();
        String[] suit = {"♥", "♠", "♣", "♦"};
        for (String s : suit) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(s, i);

                cardlist.add(card);
            }
        }
        return cardlist;
    }
}
