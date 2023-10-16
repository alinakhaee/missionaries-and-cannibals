package model;

public record State(int missionariesOnLeftSide, int cannibalsOnLeftSide, int missionariesOnRightSide,
                    int cannibalsOnRightSide, boolean boatIsOnRightSide, int cost, int heuristicCost, State parentState){

    public State(int missionariesOnLeftSide, int cannibalsOnLeftSide, int missionariesOnRightSide, int cannibalsOnRightSide, boolean boatIsOnRightSide, int cost, State parentState) {
        this(missionariesOnLeftSide, cannibalsOnLeftSide, missionariesOnRightSide, cannibalsOnRightSide, boatIsOnRightSide, cost, (missionariesOnLeftSide + cannibalsOnLeftSide) / 2, parentState);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return missionariesOnLeftSide == state.missionariesOnLeftSide && missionariesOnRightSide == state.missionariesOnRightSide && cannibalsOnLeftSide == state.cannibalsOnLeftSide && cannibalsOnRightSide == state.cannibalsOnRightSide;
    }

    @Override
    public String toString() {
        return "" + missionariesOnLeftSide + cannibalsOnLeftSide + missionariesOnRightSide + cannibalsOnRightSide + "-" + boatIsOnRightSide;
    }
}
