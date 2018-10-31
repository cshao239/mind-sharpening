package elevator;


import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem implements TransportSystem {

    private List<Elevator> elevators;

    public ElevatorSystem(int n) {
        elevators = new ArrayList<>(n);
        for(int i =0;i<n;i++) {
            elevators.add(new Elevator());
        }
    }


    @Override
    public Transporter request(int level, DirectionEnum direction) {
        return null;
    }

    @Override
    public void stop() {
        for(Elevator elevator: elevators) {
            elevator.stop();
        }

    }
}
