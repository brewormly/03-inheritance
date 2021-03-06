package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DeathState extends State {
    protected DeathState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        return this;
    }
}
