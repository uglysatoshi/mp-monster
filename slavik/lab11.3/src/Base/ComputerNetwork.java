package Base;

public class ComputerNetwork {
    String organizationName;
    int numberOfWorkstations;
    double averageDistanceBetweenStations;

    public ComputerNetwork(String organizationName, int numberOfWorkstations, double averageDistanceBetweenStations) {
        this.organizationName = organizationName;
        this.numberOfWorkstations = numberOfWorkstations;
        this.averageDistanceBetweenStations = averageDistanceBetweenStations;
    }

    public double calculateQ() {
        return numberOfWorkstations * averageDistanceBetweenStations;
    }
}
