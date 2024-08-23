import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        // 처음 set과 추가하려고 하는 addset
        Set<Integer> originalSet = new HashSet();
        Set<Integer> addSet = new HashSet();
        int result = 0;
        int goal = cards.length + 1;
        int cardsCnt = cards.length / 3;
        
        for(int i = 0; i < cardsCnt; i++) {
            originalSet.add(cards[i]);
        }
        
        while(true) {
            result++;
            
            if(cardsCnt >= cards.length) break;
            
            addSet.add(cards[cardsCnt]);
            addSet.add(cards[cardsCnt + 1]);
            cardsCnt += 2;
            
            // 있는 카드로 해결 가능할 때
            boolean flag = false;
            for(int i : originalSet) {
                if(originalSet.contains(goal - i)) {
                    originalSet.remove(goal - i);
                    addSet.remove(i);
                    flag = true;
                    break;
                }
            }
            
            // 카드 한 장 뽑아서 해결 가능할 때
            if(!flag) {
                if(coin > 0) {
                    for(int i : originalSet) {
                        if(addSet.contains(goal - i)) {
                            addSet.remove(goal - i);
                            originalSet.remove(i);
                            coin--;
                            flag = true;
                            break;
                        }           
                    }
                }
            }
            
            // 카드 두 장 뽑아서 해결 가능할 때
            if(!flag) {
                if(coin > 1) {
                    for(int i : addSet) {
                        if(addSet.contains(goal - i)) {
                            addSet.remove(i);
                            addSet.remove(goal - i);
                            coin -= 2;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            // 해결 가능하지 않을 때
            if(!flag) break;
            
        }
        
        return result;
        
    }
}