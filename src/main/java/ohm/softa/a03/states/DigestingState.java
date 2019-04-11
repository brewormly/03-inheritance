package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DigestingState extends State {
//    public DigestingState(int duration) {
//        super(duration);
//    }
//
//    @Override
//    public State successor(Cat cat) {
//        if(time == duration) {
//            logger.info("Getting in a playful mood!");
//            return new PlayfulState(cat.getAwake());
//        }
//        return this;
//
//    }
    private final int remainingWakeTime;

    DigestingState(int duration, int remainingWakeTime) {
        super(duration);
        this.remainingWakeTime = remainingWakeTime;
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(remainingWakeTime - cat.getDigest());
    }
}
