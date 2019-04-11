package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class HungryState extends State {
    public HungryState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        if(time == duration) {
            logger.info("I've starved for a too long time...good bye...");
            return new DeathState(999);
        }
        return new DigestingState(cat.getDigest(), duration - time);
    }

    public State feed(Cat cat){
        return new DigestingState(cat.getDigest(), duration-time);
    }
}
