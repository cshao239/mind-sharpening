package elevator;

public interface TransportSystem {

    /**
     * request a ride from level with direction
     * @param level
     * @param direction
     * @return
     */
    public Transporter request(int level, DirectionEnum direction);

    /**
     * emergency stop
     * @return
     */
    public void stop();

}
