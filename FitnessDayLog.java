class Workout {
    //fields
    private String name;
    private int minutes;
    private String category;
    // Default constructor
    public Workout() {
        this("Unnamed", 0, "mobility");
    }
    // Parameterized constructor 
    public Workout(String name, int minutes, String category) {
        this.name = name;
        this.minutes = minutes;
        this.category = category;
    }
    // Getters
    public String getName() {
        return name;
    }
    public int getMinutes() {
        return minutes;
    }
    public String getCategory() {
        return category;
    }
    // toString
    public String toString() {
        return name + " - " + minutes + " mins - " + category;
    }
}
class DayLog {
    //fields
    private String dateLabel;
    private Workout[] entries;//max 6
    private int count;//number of elements in entries
    //constructor
    public DayLog(String dateLabel) {
        this.dateLabel = dateLabel;
        this.entries = new Workout[6];//onstructor to set max
        this.count = 0;//number of elements in entries
    }
    //method to add workout
    public boolean add(Workout w) {
        //only if length is matched or less
        //in class variables keep values
        if (count < entries.length) {
            entries[count] = w;
            count++;
            return true;
        }
        return false;
    }
    //connect to workout for minutes getter
    public int totalMinutes() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            //for all values entries
            total += entries[i].getMinutes();
        }
        return total;
    }
/*rule: cardio: minutes*2, strength: minutes*3,
mobility: minutes*1 → sum all. */
    public int intensityScore() {
        int score = 0;
        int mobilityMinutes = 0;
        //category check and additon
        for (int i = 0; i < count; i++) {
            Workout w = entries[i];
            switch (w.getCategory()) {
                case "cardio":
                    score += w.getMinutes() * 2;
                    break;
                case "strength":
                    score += w.getMinutes() * 3;
                    break;
                case "mobility":
                    score += w.getMinutes(); // x1
                    mobilityMinutes += w.getMinutes();
                    break;
            }
        }

        // Apply SEED rule
        /*If first letter of SEED is in A–M → add +10 bonus to intensityScore() only if
totalMinutes ≥ 60.
• Else (N–Z) → subtract 5 from intensityScore() if mobility minutes < 15. */
        String seed = "Seedpracticle05"; 
        char firstChar = seed.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'M') {
            if (totalMinutes() >= 60) {
                score += 10;
            }
        } else if (firstChar >= 'N' && firstChar <= 'Z') {
            if (mobilityMinutes < 15) {
                score -= 5;
            }
        }
return score;
    }

    // Getters
    public Workout[] getEntries() {
        return entries;
    }
//for returning entries 
    public int getCount() {
        return count;
    }
//return number of entries
}

public class FitnessDayLog {

    public static void main(String[] args) {
        // create object
        DayLog log = new DayLog("Day-1");
        // Add 5 workouts to entries using daylog
        log.add(new Workout("Running", 30, "cardio"));
        log.add(new Workout("Pushups", 15, "strength"));
        log.add(new Workout("Yoga", 10, "mobility"));
        log.add(new Workout("Cycling", 20, "cardio"));
        log.add(new Workout("Plank", 5, "strength"));

        // To simplify we will give headings
        System.out.println("Workout\t\tMinutes\tCategory");
        // Print each workout
        //traverse through entries
        Workout[] entries = log.getEntries();
        for (int i = 0; i < log.getCount(); i++) {
            Workout w = entries[i];
            System.out.println(w.getName() + "\t\t" + w.getMinutes() + "\t" + w.getCategory());
        }
        // Print total intensity
        int intensity = log.intensityScore();
        System.out.println("\nFinal Intensity Score: " + intensity);
        // Compute goal
        int seeddigitsum=5;
        int goal = 50 + seeddigitsum;
        System.out.println("Goal: " + goal);
        System.out.println("Goal Met? " + (intensity >= goal ? "YES" : "NO"));
    }
}

