package com.qdw.interview.baidu;


import java.util.*;

/**
 * Created by baidu on 2020-07-14.
 */
public class FindLostPoke {
    enum Shape {
        SPADE("黑桃"),
        HEART("红桃"),
        CLUB("梅花"),
        DIAMOND("方块");

        Shape(String name) {
            this.name = name;
        }

        private String name;
    }

    static class Card {
        Shape shape;
        Integer num;

        public Card(Shape shape, Integer num) {
            this.shape = shape;
            this.num = num;
        }

        public Card() {
            this.shape = shape;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "shape=" + shape +
                    ", num=" + num +
                    '}';
        }
    }

    public Card findTheOneLack(List<Card> cards) {
        int[][] arr = new int[4][13];
        for (Card card : cards) {
            if (card.shape==Shape.CLUB){
                arr[0][card.num]++;
            }else if (card.shape==Shape.DIAMOND){
                arr[1][card.num]++;
            }else if (card.shape==Shape.HEART){
                arr[2][card.num]++;
            }else {
                arr[3][card.num]++;
            }
        }
        Card res;
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                if (arr[i][j]==0){
                    if(i==0){
                        res = new Card(Shape.CLUB,j);
                    }else if (i==1){
                        res = new Card(Shape.DIAMOND,j);
                    }else if (i==2){
                        res = new Card(Shape.HEART,j);
                    }else {
                        res = new Card(Shape.SPADE,j);
                    }
                    return res;
                }
            }
        }

        return null;
    }


    public List<Card> initCards() {
        List<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 13; i++) {
            for (Shape value : Shape.values()) {
                cards.add(new Card(value, i));
            }
        }
        Collections.shuffle(cards);
        Card removed = cards.remove(new Random().nextInt(52));
        System.out.println(removed);
        return cards;
    }

    public static void main(String[] args) {
        FindLostPoke t = new FindLostPoke();
        List<Card> cards = t.initCards();
        System.out.println(t.findTheOneLack(cards));
    }
}