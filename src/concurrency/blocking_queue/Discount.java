package concurrency.blocking_queue;

public class Discount {
    public enum Code{
        NONE(0), SUPER(10), HIPER(30), MEGA(50);

        private final int percentage;

        Code(int percentage){
            this.percentage = percentage;
        }

        public int getPercentage(){
            return percentage;
        }
    }
}
