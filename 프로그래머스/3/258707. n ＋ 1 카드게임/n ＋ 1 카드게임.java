import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int life = 0;
        int moreCoin = 0;
        
        List<Integer> save = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < cards.length / 3; i++) {
            save.add(cards[i]);
            for (int j = 0; j < save.size() - 1; j++) {
                if (save.get(j) == cards.length + 1 - save.get(save.size() - 1)) {
                    save.remove(save.size() - 1);
                    save.remove(j);
                    life++;
                    break;
                }
            }
        }
        
        // 카드를 2장 뽑고 
        // y, y: save에 있으면 숫자를 뽑음 (2번 반복)
        // y, n: save에 있으면 숫자를 뽑고, save에 넣어둠
        // n, y: tmp에 넣어두고, save에 있으면 숫자를 뽑고 진행
        // n, n: 둘다 tmp에 넣어두고 tmp 마지막 숫자와 겹치는게 있는지 진행
        // tmp는 코인을 안쓰고 저장해두는 용도
        
        // 매 과정 끝마다 tmp 맨뒤 숫자와 확인하는 로직 추가
        // 카드를 버릴 때마다 life ++;
        
        // 카드를 넣을지 뺄지 우선순위 설정하는 게 없음
        
        // 1번
        for (int i = cards.length / 3; i < cards.length; i+= 2) {
            boolean is_saved = false;
            for (int j = 0; j < save.size(); j++) {
                if (save.get(j) == cards.length + 1 - cards[i] && coin > 0) {
                    save.remove(j);
                    life++;
                    coin--;
                    is_saved = true;
                    break;
                }
            }
            
            if (!is_saved) {
                tmp.add(cards[i]);
                for (int j = 0; j < tmp.size() - 1; j++) {
                    if (tmp.get(j) == cards.length + 1 - tmp.get(tmp.size() - 1)) {
                        tmp.remove(tmp.size() - 1);
                        tmp.remove(tmp.get(j));
                        moreCoin++;
                        break;
                    }
                }
            }
            
            // 2번
            is_saved = false;
            for (int j = 0; j < save.size(); j++) {
                if (save.get(j) == cards.length + 1 - cards[i+1] && coin > 0) {
                    save.remove(j);
                    life++;
                    coin--;
                    is_saved = true;
                    break;
                }
            }
            
            if (!is_saved) {
                tmp.add(cards[i+1]);
                for (int j = 0; j < tmp.size() - 1; j++) {
                    if (tmp.get(j) == cards.length + 1 - tmp.get(tmp.size() - 1)) {
                        tmp.remove(tmp.size() - 1);
                        tmp.remove(tmp.get(j));
                        moreCoin++;
                        break;
                    }
                }
            }
            
            if (life == 0) {
                if (coin >= 2 && moreCoin > 0) {
                    coin -= 2;
                    moreCoin --;
                    answer++;
                } else {
                    break;
                }
            } else {
                life --;
                answer++;
            }
        }
        
        return answer + 1;
    }
}