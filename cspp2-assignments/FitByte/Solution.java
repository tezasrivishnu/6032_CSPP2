import java.util.Scanner;
/**
 * Class for food log.
 */
class FoodLog {
    private String foodname;
    private int foodquantity;
    private String fooddate;
    private String foodtime;
    /**
     * Constructs the object.
     *
     * @param      name      The name
     * @param      quantity  The quantity
     * @param      date      The date
     * @param      time      The time
     */
    FoodLog(final String name, final int quantity, final String date, final String time) {
        this.foodname = name;
        this.foodquantity = quantity;
        this.fooddate = date;
        this.foodtime = time;
    }
    /**
     * Gets the food name.
     *
     * @return     The food name.
     */
    public String getFoodName() {
        return this.foodname;
    }
    /**
     * Gets the food quantity.
     *
     * @return     The food quantity.
     */
    public int getFoodQuantity() {
        return this.foodquantity;
    }
    /**
     * Gets the food date.
     *
     * @return     The food date.
     */
    public String getFoodDate() {
        return this.fooddate;
    }
    /**
     * Gets the food time.
     *
     * @return     The food time.
     */
    public String getFoodTime() {
        return this.foodtime;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "Food\n";
        s += "Date:" + fooddate + "\n";
        s += "Time:" + foodtime + "\n";
        s += "Name:" + foodname + "\n";
        s += "Quantity:" + foodquantity;
        return s;
    }
}
/**
 * Class for water log.
 */
class WaterLog {
    private int waterquantity;
    private String waterdate;
    /**
     * Constructs the object.
     *
     * @param      quantity  The quantity
     * @param      date      The date
     */
    WaterLog(final int quantity, final String date) {
        this.waterquantity = quantity;
        this.waterdate = date;
    }
    /**
     * Gets the water quantity.
     *
     * @return     The water quantity.
     */
    public int getWaterQuantity() {
        return this.waterquantity;
    }
    /**
     * @return    water date.
     */
    public String getwaterDate() {
        return this.waterdate;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "Water\n";
        s += "Date:" + waterdate + "\n";
        s += "Quantity:" + waterquantity + "ml";
        return s;
    }
}
/**
 * Class for physical.
 */
class Physical {
    private String activityname;
    private String activitynote;
    private String activitydate;
    private String activitystime;
    private String activityetime;
    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      note   The note
     * @param      date   The date
     * @param      start  The start
     * @param      end    The end
     */
    Physical(final String name, final String note, final String date, final String start, final String end) {
        this.activityname = name;
        this.activitynote = note;
        this.activitydate = date;
        this.activitystime = start;
        this.activityetime = end;
    }
    public String activityName() {
        return this.activityname;
    }
    public String activityNote() {
        return this.activitynote;
    }
    public String activityDate() {
        return this.activitydate;
    }
    public String activityStime() {
        return this.activitystime;
    }
    public String activityEtime() {
        return this.activityetime;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "PhysicalActivity\n";
        s += "Name:" + activityname + "\n";
        s += "Notes:" + activitynote + "\n";
        s += "Date:" + activitydate + "\n";
        s += "Starttime:" + activitystime + "\n";
        s += "Endtime:" + activityetime;
        return s;
    }
}
/**
 * Class for sleep log.
 */
class SleepLog {
    private String sleepdate;
    private String sleepstime;
    private String sleepetime;
    /**
     * Constructs the object.
     *
     * @param      date   The date
     * @param      stime  The stime
     * @param      etime  The etime
     */
    SleepLog(final String date, final String stime, final String etime) {
        this.sleepdate = date;
        this.sleepstime = stime;
        this.sleepetime = etime;
    }
    /**
     * Gets the sleepdate.
     *
     * @return     The sleepdate.
     */
    public String getSleepdate() {
        return this.sleepdate;
    }
    /**
     * Gets the sleepstime.
     *
     * @return     The sleepstime.
     */
    public String getSleepstime() {
        return this.sleepstime;
    }
    /**
     * Gets the sleepetime.
     *
     * @return     The sleepetime.
     */
    public String getSleepetime() {
        return this.sleepetime;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "Sleep\n";
        s += "Date:" + sleepdate + "\n";
        s += "Starttime:" + sleepstime + "\n";
        s += "Endtime:" + sleepetime;
        return s;
    }

}
/**
 * Class for weight log.
 */
class WeightLog {
    private String weightdate;
    private String weighttime;
    private String weightweight;
    private String weightfat;
    /**
     * Constructs the object.
     *
     * @param      date    The date
     * @param      time    The time
     * @param      weight  The weight
     * @param      fat     The fat
     */
    WeightLog(final String date, final String time, final String weight, final String fat) {
        this.weightdate = date;
        this.weighttime = time;
        this.weightweight = weight;
        this.weightfat = fat;
    }
    /**
     * Gets the weightdate.
     *
     * @return     The weightdate.
     */
    public String getWeightdate() {
        return this.weightdate;
    }
    /**
     * Gets the weighttime.
     *
     * @return     The weighttime.
     */
    public String getWeighttime() {
        return this.weighttime;
    }
    /**
     * Gets the weightweight.
     *
     * @return     The weightweight.
     */
    public String getWeightweight() {
        return this.weightweight;
    }
    /**
     * Gets the weightfat.
     *
     * @return     The weightfat.
     */
    public String getWeightfat() {
        return this.weightfat;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "Weight\n";
        s += "Date:" + weightdate + "\n";
        s += "Time:" + weighttime + "\n";
        s += "Weight:" + weightweight + "\n";
        s += "Fat:" + weightfat;
        return s;
    }
}
/**
 * Class for fit byte.
 */
class FitByte {
    private List<FoodLog> foodarr;
    private List<WaterLog> waterarr;
    private List<Physical> activityarr;
    private List<SleepLog> sleeparr;
    private List<WeightLog> weightarr;
    // private String personname;
    // private String persondob;
    // private int personwt;
    // private int personht;
    // private int wtgoal;
    // private int fdgoal;
    // private int actgoal;
    // private int slpgoal;
    FitByte() {
        foodarr = new List<FoodLog>();
        waterarr = new List<WaterLog>();
        activityarr = new List<Physical>();
        sleeparr = new List<SleepLog>();
        weightarr = new List<WeightLog>();
    }
    // FitByte(String name, String dob, int wt, int ht, int wg, int fg, int ag, int sg) {
    //  this.personname = name;
    //  this.persondob = dob;
    //  this.personwt = wt;
    //  this.personht = ht;
    //  this.wtgoal = wg;
    //  this.fdgoal = fg;
    //  this.actgoal = ag;
    //  this.slpgoal = sg;
    // }
    
    /**
     * Adds a food log.
     *
     * @param      food  The food
     */
    public void addFoodLog(final FoodLog food) {
        foodarr.add(food);
    }
    /**
     * Adds a water log.
     *
     * @param      water  The water
     */
    public void addWaterLog(final WaterLog water) {
        waterarr.add(water);
    }
    /**
     * Adds an activity log.
     *
     * @param      activity  The activity
     */
    public void addActivityLog(final Physical activity) {
        activityarr.add(activity);
    }
    /**
     * Adds a sleep log.
     *
     * @param      sleep  The sleep
     */
    public void addSleepLog(final SleepLog sleep) {
        sleeparr.add(sleep);
    }
    /**
     * Adds a weight log.
     *
     * @param      weight  The weight
     */
    public void addWeightLog(final WeightLog weight) {
        weightarr.add(weight);
    }
    /**
     * Gets the food log.
     *
     * @return     The food log.
     */
    public List<FoodLog> getFoodLog() {
        return foodarr;
    }
    /**
     * Gets the water log.
     *
     * @return     The water log.
     */
    public List<WaterLog> getWaterLog() {
        return waterarr;
    }
    /**
     * Gets the physical.
     *
     * @return     The physical.
     */
    public List<Physical> getPhysical() {
        return activityarr;
    }
    public List<SleepLog> getSleepLog() {
        return sleeparr;
    }
    /**
     * Gets the weight log.
     *
     * @return     The weight log.
     */
    public List<WeightLog> getWeightLog() {
        return weightarr;
    }
    /**
     * Gets the summary.
     *
     * @param      summary  The summary
     */
    public void getSummary(final String summary) {
        for(int i = 0; i<foodarr.size(); i++) {
            if(summary.equals(foodarr.get(i).getFoodDate())) {
                System.out.println(foodarr.get(i).toString());
            }
        }
        for(int i = 0; i<waterarr.size(); i++) {
            if(summary.equals(waterarr.get(i).getwaterDate())) {
                System.out.println(waterarr.get(i).toString());
            }
        }
        for(int i = 0; i<activityarr.size(); i++) {
            if(summary.equals(activityarr.get(i).activityDate())) {
                System.out.println(activityarr.get(i).toString());
            }
        }
        for(int i = 0; i<sleeparr.size(); i++) {
            if(summary.equals(sleeparr.get(i).getSleepdate())) {
                System.out.println(sleeparr.get(i).toString());
            }
        }for(int i = 0; i<weightarr.size(); i++) {
            if(summary.equals(weightarr.get(i).getWeightdate())) {
                System.out.println(weightarr.get(i).toString());
            }
        }
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * main program.
     * @param      args  is the parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        FitByte fit = new FitByte();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] tokens = str.split(" ");
            switch (tokens[0]) {
            case "Food":
                String[] foodar = tokens[1].split(",");
                FoodLog food = new FoodLog(foodar[0], Integer.parseInt(foodar[1]), foodar[2], foodar[3]);
                fit.addFoodLog(food);
                break;
            case "Water":
                String[] waterar = tokens[1].split(",");
                WaterLog water = new WaterLog(Integer.parseInt(waterar[0]), waterar[1]);
                fit.addWaterLog(water);
                break;
            case "PhysicalActivity":
                String[] activityar = tokens[1].split(",");
                Physical activity = new Physical(activityar[0], activityar[1], activityar[2], activityar[3], activityar[4]);
                fit.addActivityLog(activity);
                break;
            case "Weight":
                String[] weightar = tokens[1].split(",");
                WeightLog weight = new WeightLog(weightar[0], weightar[1], weightar[2], weightar[3]);
                fit.addWeightLog(weight);
                break;
            case "Sleep":
                String[] sleepar = tokens[1].split(",");
                SleepLog sleep = new SleepLog(sleepar[0], sleepar[1], sleepar[2]);
                fit.addSleepLog(sleep);
                break;
            case "Foodlog":
                System.out.println(fit.getFoodLog());
                System.out.println();
                break;
            case "Waterlog":
                System.out.println(fit.getWaterLog());
                System.out.println();
                break;
            case "PhysicalActivitylog":
                List<Physical> s = fit.getPhysical();
                if (s != null) {
                    System.out.println("PhysicalActivity\nnone");
                } else {
                    System.out.println(s);
                }
                System.out.println();
                break;
            case "Sleeplog":
                System.out.println(fit.getSleepLog());
                System.out.println();
                break;
            case "Weightlog":
                System.out.println(fit.getWeightLog());
                System.out.println();
                break;
            case "Summary":
                if (tokens.length == 1) {
                    System.out.println(fit.getFoodLog());
                    System.out.println(fit.getWaterLog());
                    s = fit.getPhysical();
                    if (s != null) {
                        System.out.println("PhysicalActivity\nnone");
                    } else {
                        System.out.println(s);
                    }
                    System.out.println(fit.getSleepLog());
                    System.out.println(fit.getWeightLog());
                } else {
                    fit.getSummary(tokens[1]);
                }
                break;
            }
        }
    }
}
