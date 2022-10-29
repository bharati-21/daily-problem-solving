class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        if(plantTime == null || plantTime.length == 0 || growTime == null || growTime.length == 0) {
            return 0;
        }
        
        int n = plantTime.length;
        int[][] plants = new int[n][2];
        
        for(int i = 0; i<n; i++) {
            plants[i] = new int[] {
                plantTime[i], growTime[i]
            };
        }
        
        Arrays.sort(plants, new CustomComparator());
        
        int pTime = 0, gTime = 0;
        for(int i = 0; i<n; i++) {
            pTime = pTime + plants[i][0];
            gTime = Math.max(gTime, pTime + plants[i][1]);
        }
        
        return gTime;
    }
}

class CustomComparator implements Comparator<int[]> {
    public int compare(int[] plant1, int[] plant2) {
        return plant2[1] - plant1[1];
    }
}


// You don't have to plan on non-consecutive days
// Plan seeds first that have a longer growth time

// 0 -> 1
// 1 -> 3
// 1 -> 3
// 3 -> 4
// 3 -> 6
// 6 -> 8
// 6 -> 8

// [1,4]
// [2,3]
// 0 -> 0 (plant done)
// 1 -> 3 (blooms)
// 1 -> 4
// 5 -> 8

// 0 -> 3
// 4 -> 7
// 4 -> 4
// 5 -> 7

// [1,3,2,2]
// [2,2,1,1]
// 0 -> 0
// 1 -> 3 (blooms)
// 1 -> 3
// 4 -> 6 (blooms)
// 4 -> 5
// 6 -> 7
// 6 -> 7
// 8 -> 9

// [1,1]
// [1,2]
// 0 -> 0
// 1 -> 2
// 1 -> 1
// 2 -> 4

// 0 -> 0
// 1 -> 3
// 1 -> 1
// 2 -> 3

// 0 + 28 = 28
// 28 + 28 = 56 => blooms
// 28 + 13 = 41
// 41 + 27 = 68 => blooms
// 41 + 10 = 51
// 51 + 27 = 78 => blooms
// 51 + 27 = 78
// 78 + 26 = 104 => blooms
// 78 + 16 = 94
// 94 + 24 = 118 => blooms
// 94 + 23 = 117
// 117 + 23 = 140 => blooms
// 117 + 4 = 121
// 121 + 23 = 144 => blooms
// 121 + 17 = 138
// 138 + 17 = 155 => blooms
// 138 + 9 = 147
// 147 + 15 = 162 => blooms
// 147 + 26 = 173
// 173 + 15 = 188 => blooms
// 173 + 24 = 197
// 197 + 14 = 211 => blooms 
// 197 + 4 = 201
// 201 + 14 = 215 => blooms
// 201 + 17 = 218
// 218 + 14  = 232 => blooms
// 218 + 21 = 239
// 239 + 13 = 252 => blooms
// 239 + 28 = 267
// 267 + 12 = 279 => blooms
// 267 + 2 = 269
// 269 + 12 = 281 => blooms
// 269 + 6 = 275
// 275 + 11 = 286 => blooms
// 275 + 5 = 280
// 280 + 9 => 289 => blooms
// 280 + 27 = 307
// 307 + 6 = 313 => blooms
// 307 + 26 = 333
// 333 + 6 = 339 => blooms
// 333 + 10 = 343 
// 343 + 5 = 348 => blooms
// 343 + 3 = 346
// 346 + 1 = 347 => blooms
