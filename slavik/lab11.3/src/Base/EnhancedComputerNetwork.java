package Base;

public class EnhancedComputerNetwork extends ComputerNetwork {
    private double averageDataTransmissionSpeed;

    public EnhancedComputerNetwork(String organizationName, int numberOfWorkstations, double averageDistanceBetweenStations, double averageDataTransmissionSpeed) {
        super(organizationName, numberOfWorkstations, averageDistanceBetweenStations);
        this.averageDataTransmissionSpeed = averageDataTransmissionSpeed;
    }

    public double calculateQp() {
        return calculateQ() * averageDataTransmissionSpeed;
    }
}
