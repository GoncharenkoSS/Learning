package For_example.TasksOOP;

import java.util.Comparator;

class Train {
    private String destination;
    private int number;
    private String departure_time;

    public Train(String destination_, int number_, String departure_time_) {
        destination = destination_;
        number = number_;
        departure_time = departure_time_;
    }
    public static class ByNumberComparator implements Comparator < Train > {
        @Override
        public int compare(Train a, Train b) {
            return a.number - b.number;
        }
    }
    public static class ByDestinationAndTimeComparator implements Comparator < Train > {
        @Override
        public int compare(Train left, Train right) {
            if (left.destination == right.destination)
                return left.departure_time.compareTo(right.departure_time);
            return left.destination.compareTo(right.destination);
        }
    }
    public void print() {
        System.out.println(number + " -> " + destination + " : " + departure_time);
    }
}