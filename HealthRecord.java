public class HealthRecord {
    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;
// TODO: 1 Think about the initial value for maximum and minimum height
    private static int tallestHeight = 50 ;
    private static int shortestHeight = 175 ;
    private static int objectCounter = 0;
    private static double averageHeight = 0;

    public HealthRecord(int height) { 
        objectCounter++;
        setHeight(height);
    }
    public void setHeight(int height) {
        if (height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT) {
            this.height = height;
        } else {
            this.height = DEFAULT_HEIGHT;
        }

        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }

        averageHeight = (averageHeight * (objectCounter - 1) + this.height) / objectCounter;
    }
    public int getHeight() {
        return this.height;
    }
    public static int getTallestHeight() {
        return HealthRecord.tallestHeight ; 
        // -OR- return tallestHeight;
    }
    public static int getShortestHeight(){
        return HealthRecord.shortestHeight ;
    }
    public static double getAverageHeight() {
        return averageHeight;
    }
    public void displayDetails() { 
        System.out.println("Height (cm): " + getHeight());
    }
    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println(String.format("The average height (cm): %.2f", getAverageHeight()));
    }
    public static void main(String[] args) {
        HealthRecord student1 = new HealthRecord(120);
        HealthRecord student2 = new HealthRecord(55);
        HealthRecord student3 = new HealthRecord(180);
        student1.displayDetails(); // 120
        student2.displayDetails(); // 55
        student3.displayDetails(); // 180 is not permitted, so it is replaced by default value
        HealthRecord.displayClassDetails(); // tallest = 120, shortest = 55
    }
}