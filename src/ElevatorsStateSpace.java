import java.io.*;
import java.util.*;
//passenger action class
class PassengerRequest {
    private int startPosition;//start floor
    private int destination;//destination floor
    //constructor function
    public PassengerRequest(int startPosition, int destination) {
        this.startPosition = startPosition;
        this.destination = destination;
    }
    // get function
    public int getStartPosition() {
        return startPosition;
    }
    public int getDestination() {
        return destination;
    }
}
//elevator state class
class Elevator {
    private int elevatorsCurrentFloor;
    private String direction;
    //constructor function
    public Elevator(int initialPosition) {
        this.elevatorsCurrentFloor = initialPosition;
        this.direction = "0";
    }
    public int getElevatorsCurrentFloor() {
        return elevatorsCurrentFloor;
    }
    //move action
    public void move(String direction) {
        if (direction.equals("up")) {
            elevatorsCurrentFloor++;
        } else if (direction.equals("down")) {
            elevatorsCurrentFloor--;
        }
    }
}
class ElevatorsStateSpace {
    private List<Elevator> elevators;
    private List<PassengerRequest> passengerRequests;
    private int totalFloors;
    private int totalPassengers;
    private int totalElevators;
    
    public ElevatorsStateSpace(int totalPassengers, int totalElevators, int totalFloors) {
        this.totalPassengers = totalPassengers;
        this.totalElevators = totalElevators;
        this.totalFloors = totalFloors;
        this.elevators = new ArrayList<>();
        this.passengerRequests = new ArrayList<>();
    }
    //read elevator-problem.txt file
    public void buildFromCmdline(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] numberOfPassengersAndElevators = reader.readLine().split(" ");
        String[] passengersInitialFloor = reader.readLine().split(" ");
        String[] elevatorsInitialFloor = reader.readLine().split(" ");
        String[] passengerDestinationFloor = reader.readLine().split(" ");
        totalPassengers = Integer.parseInt(numberOfPassengersAndElevators[0]);
        totalElevators = Integer.parseInt(numberOfPassengersAndElevators[1]);
        totalFloors = Integer.parseInt(numberOfPassengersAndElevators[2]);
        for (int i = 0; i < totalPassengers; i++) {
            int sourceFloor = Integer.parseInt(passengersInitialFloor[i]);
            int destinationFloor = Integer.parseInt(passengerDestinationFloor[i]);
            passengerRequests.add(new PassengerRequest(sourceFloor, destinationFloor));
        }
        elevators.clear();
        for (int i = 0; i < totalElevators; i++) {
            int startFloor = Integer.parseInt(elevatorsInitialFloor[i]);
            elevators.add(new Elevator(startFloor));
        }
        //end of read
        reader.close();
    }
    //transitions to the destination.
    public void processPassengerRequests() {
        for (Elevator elevator : elevators) {
            if (!passengerRequests.isEmpty()) {
                PassengerRequest PassengerRequest = passengerRequests.get(0);
                passengerRequests.remove(0);
                while (elevator.getElevatorsCurrentFloor() != PassengerRequest.getStartPosition()) {
                    String direction = elevator.getElevatorsCurrentFloor() < PassengerRequest.getStartPosition() ? "up" : "down";
                    elevator.move(direction);
                    System.out.println("elevator at floor: " + elevator.getElevatorsCurrentFloor());
                }
                while (elevator.getElevatorsCurrentFloor() != PassengerRequest.getDestination()) {
                    String direction = elevator.getElevatorsCurrentFloor() < PassengerRequest.getDestination() ? "up" : "down";
                    elevator.move(direction);
                    System.out.println("elevator at floor: " + elevator.getElevatorsCurrentFloor());
                }
            }
        }
    }
    public void printState() {
        System.out.println("elevator current floors:");
        for (int i = 0; i < elevators.size(); i++) {
            System.out.println("elevator " + (i + 1) + " is at floor " + elevators.get(i).getElevatorsCurrentFloor());
        }

        System.out.println("passengerRequests:");
        for (PassengerRequest PassengerRequest : passengerRequests) {
            System.out.println(PassengerRequest.getStartPosition() + "---->" + PassengerRequest.getDestination());
        }
    }
}
class StateSpaceTest {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            //invalid input
            System.out.println("something went wrong");
            return;
        }
        String inputFile = args[1];
        String commands = args[0];
        if (commands.equals("elevators")) {
            ElevatorsStateSpace stateSpace = new ElevatorsStateSpace(0, 0, 0);
            stateSpace.buildFromCmdline(inputFile);
            stateSpace.printState();
            stateSpace.processPassengerRequests();
            stateSpace.printState();
        }
    }
}
