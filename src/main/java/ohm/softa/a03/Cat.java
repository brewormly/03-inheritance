package ohm.softa.a03;

//import static ohm.softa.a03.Cat.State.*;

import ohm.softa.a03.states.*;

public class Cat {

    // initially, animals are sleeping
    private State currentState;

    // state durations (set via constructor), ie. the number of ticks in each state
    private final int sleep;
    private final int awake;
    private final int digest;

    private final String name;

    private int time = 0;
    private int timeDigesting = 0;

    public Cat(String name, int sleep, int awake, int digest) {
        this.name = name;
        this.sleep = sleep;
        this.awake = awake;
        this.digest = digest;
        currentState = new SleepingState(sleep);
    }

    public void tick() {
        currentState = currentState.tick(this);
//
//		switch (state) {
//			case SLEEPING:
//				if (time == sleep) {
//					logger.info("Yoan... getting hungry!");
//					state = HUNGRY;
//					time = 0;
//				}
//				break;
//			case HUNGRY:
//				if(time == awake){
//					logger.info("I've starved for a too long time...good bye...");
//					state = DEAD;
//				}
//				break;
//			case DIGESTING:
//				timeDigesting = timeDigesting + 1;
//				if (timeDigesting == digest) {
//					logger.info("Getting in a playful mood!");
//					state = PLAYFUL;
//				}
//				break;
//			case PLAYFUL:
//				if (time >= awake) {
//					logger.info("Yoan... getting tired!");
//					state = SLEEPING;
//					time = 0;
//				}
//				break;
//
//			case DEAD:
//				break;
//			default:
//				throw new IllegalStateException("Unknown cat state " + state.name());
//		}
//
//		logger.info(state.name());

    }


    public void feed() {
        timeDigesting = timeDigesting + 1;
        if (!isHungry())
            throw new IllegalStateException("Can't stuff a cat...");

        currentState = currentState.successor(this);
        timeDigesting = 0;
    }

    public boolean isAsleep() {
        return currentState instanceof SleepingState;
    }

    public boolean isPlayful() {
        return currentState instanceof PlayfulState;
    }

    public boolean isHungry() {
        return currentState instanceof HungryState;
    }

    public boolean isDigesting() {
        return currentState instanceof DigestingState;
    }

    public boolean isDead() {
        return currentState instanceof DeathState;
    }

    @Override
    public String toString() {
        return getName();
    }

    public int getSleep() {
        return sleep;
    }

    public int getAwake() {
        return awake;
    }

    public int getDigest() {
        return digest;
    }

    public String getName() {
        return name;
    }
}
