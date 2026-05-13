        import java.util.*;
    
    public class KokoEatingBananasLinearSearch {

    // Java program to find the minimum number of bananas 
    // Koko must eat per hour to finish all the bananas 
    // within k hours using Linear Search

 
        static int koKoEat(int[] pilesOfBananas, int totalHoursToEat) {
            int maxPileSize = Arrays.stream(pilesOfBananas).max().getAsInt();
            for (int speed = 1; speed <= maxPileSize; speed++) {
                
                int time = 0;
                for (int bananas : pilesOfBananas) {
                    
                    // Time required to eat this pile 
                    // of bananas at current speed
                    time += bananas / speed;
    
                    // 1 extra hour to eat the remainder 
                    // number of bananas in this pile
                    if (bananas % speed != 0) {
                        time++;
                    }
                }
                
                // If total eating time at current speed
                  // is smaller than given time
                if (time <= totalHoursToEat) {
                    return speed;
                }
            }
    
            return maxPileSize;
        }
    
        public static void main(String[] args) {
            int[] arrayOfBananas = {3, 6, 7, 11};
            int totalHoursToEat = 8;
            System.out.println(koKoEat(arrayOfBananas, totalHoursToEat));
        }
    }