package elevator;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Uninterruptibles;
import com.typesafe.config.ConfigFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static elevator.DirectionEnum.DOWN;
import static elevator.DirectionEnum.UP;

@Data
@AllArgsConstructor
public class Elevator implements Transporter {
    private static int capacity= ConfigFactory.load().getInt("capacity");
    private int currentCapacity;
    private StatusEnum status;
    private int currentLevel;
    private int numberOfWaitedMinutesInCurrentTrip;
    //key: target Level, value: how many people to this level
    private Map<Integer, Integer> currentTask;

    public Elevator(){
        currentCapacity=0;
        status=StatusEnum.STANDBY;
        currentLevel=0;
        numberOfWaitedMinutesInCurrentTrip=0;
        currentTask = new HashMap<>();
    }


    /**
     * emergency stop at next level
     */
    public void stop(){
        if (status==StatusEnum.STANDBY) {
            return;
        }

        if(status==StatusEnum.ACENDING) {
            currentLevel++;

        } else {
            currentCapacity--;
        }
        status=StatusEnum.STANDBY;
        numberOfWaitedMinutesInCurrentTrip=0;
        currentCapacity=0;
        return;
    }


    @Override
    public void enter(int capacity, int level) {
        Preconditions.checkArgument(level!=currentLevel);
        int diff = Math.abs(currentLevel-level);
        currentCapacity+=capacity;
        currentTask.put(level, currentTask.containsKey(level) ? currentTask.get(level)+capacity : capacity);
        start(level>currentLevel ? UP : DOWN);
        for(int i=0;i<diff;i++){

        }
    }




    private void start(DirectionEnum directionEnum) {
        status= directionEnum==UP? StatusEnum.ACENDING : StatusEnum.DECENDING;
    }
}
