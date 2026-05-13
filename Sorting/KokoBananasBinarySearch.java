public class KokoBananasBinarySearch {

    public int minEatingSpeed(int[] pilesOfBananas, int totalHoursToEat) {
        int lowSpeed = 1;
        int highSpeed = getMaxPile(pilesOfBananas);

        // Do Binary Search to find  no of hours at required speed
        while (lowSpeed < highSpeed) {

            // calculate  how many hours Koko needs to eat all the bananas 
            // if she eats at speed mid bananas per hour, 
            // where mid is the middle value of the binary search range
            int midSpeed = lowSpeed + (highSpeed - lowSpeed) / 2; // ✅ Corrected midpoint calculation

            // Search for  total hours to eat each pile of bananas & finish all bananas - at mid speed
            int hours = getHours(pilesOfBananas, midSpeed);

            // If calculated hours is greater than total hours given, 
            //      set the speedRange as (mid+1  to High)  & continue
            // Else
            //      set the speedRange as (1 upto Mid) & continue
            if (hours > totalHoursToEat) {
                lowSpeed = midSpeed + 1;
            } else {
                highSpeed = midSpeed;
            }
        }

        return lowSpeed; // or return high; they are the same when loop exits
    }

    // Helper to find the largest pile (upper bound for speed)
    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    // Helper to calculate total hours needed at given speed
    private int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // same as ceil(pile / speed)
        }
        return hours;
    }

    public static void main(String[] args) {
        KokoBananasBinarySearch  koko = new KokoBananasBinarySearch();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Minimum speed Koko needs: " + koko.minEatingSpeed(piles, h));
    }
}
