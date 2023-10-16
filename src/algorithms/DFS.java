package algorithms;

import model.State;
import utils.Utils;

import java.util.*;

public class DFS {

    public static void runDFS(State initialState)
    {
        int numberOfExpandedNodes = 0;
        HashSet<String> visitedStates = new HashSet<>();

        Stack<State> stack = new Stack<>();
        stack.add(initialState);

        while (!stack.isEmpty()) {
            State currentState = stack.pop();
            numberOfExpandedNodes++;

            if(visitedStates.contains(currentState.toString())){
                continue;
            }
            visitedStates.add(currentState.toString());
            if(Utils.badState(currentState)){
                continue;
            }
            if(Utils.goalCheck(currentState)){
                Utils.printAnswer(currentState);
                System.out.println("Solution cost: " + currentState.cost());
                System.out.println("Goal reached after " + numberOfExpandedNodes + " iterations");
                return;
            }

            List<State> childStates = successor(currentState);
            stack.addAll(childStates);
        }
    }

    private static List<State> successor(State state) {
        ArrayList<State> possibleStates = new ArrayList<>();
        if(!state.boatIsOnRightSide()){
            if(state.cannibalsOnLeftSide() >= 2){
                possibleStates.add(new State(state.missionariesOnLeftSide(), state.cannibalsOnLeftSide() - 2,
                        state.missionariesOnRightSide(), state.cannibalsOnRightSide() + 2, true, state.cost() + 1, state));
            }
            if(state.missionariesOnLeftSide() >= 2){
                possibleStates.add(new State(state.missionariesOnLeftSide() - 2, state.cannibalsOnLeftSide(),
                        state.missionariesOnRightSide() + 2, state.cannibalsOnRightSide(), true, state.cost() + 1, state));
            }
            if(state.cannibalsOnLeftSide() >= 1){
                possibleStates.add(new State(state.missionariesOnLeftSide(), state.cannibalsOnLeftSide() - 1,
                        state.missionariesOnRightSide(), state.cannibalsOnRightSide() + 1, true, state.cost() + 1, state));
            }
            if(state.missionariesOnLeftSide() >= 1){
                possibleStates.add(new State(state.missionariesOnLeftSide() - 1, state.cannibalsOnLeftSide(),
                        state.missionariesOnRightSide() + 1, state.cannibalsOnRightSide(), true, state.cost() + 1, state));
            }
            if(state.missionariesOnLeftSide() >= 1 && state.cannibalsOnLeftSide() >= 1){
                possibleStates.add(new State(state.missionariesOnLeftSide() - 1, state.cannibalsOnLeftSide() - 1,
                        state.missionariesOnRightSide() + 1, state.cannibalsOnRightSide() + 1, true, state.cost() + 1, state));
            }
        }

        if(state.boatIsOnRightSide()){
            if(state.cannibalsOnRightSide() >= 2){
                possibleStates.add(new State(state.missionariesOnLeftSide(), state.cannibalsOnLeftSide() + 2,
                        state.missionariesOnRightSide(), state.cannibalsOnRightSide() - 2, false, state.cost() + 1, 0, state));
            }
            if(state.missionariesOnRightSide() >= 2){
                possibleStates.add(new State(state.missionariesOnLeftSide() + 2, state.cannibalsOnLeftSide(),
                        state.missionariesOnRightSide() - 2, state.cannibalsOnRightSide(), false, state.cost() + 1, 0, state));
            }
            if(state.cannibalsOnRightSide() >= 1){
                possibleStates.add(new State(state.missionariesOnLeftSide(), state.cannibalsOnLeftSide() + 1,
                        state.missionariesOnRightSide(), state.cannibalsOnRightSide() - 1, false, state.cost() + 1, 0, state));
            }
            if(state.missionariesOnRightSide() >= 1){
                possibleStates.add(new State(state.missionariesOnLeftSide() + 1, state.cannibalsOnLeftSide(),
                        state.missionariesOnRightSide() - 1, state.cannibalsOnRightSide(), false, state.cost() + 1, 0, state));
            }
            if(state.missionariesOnRightSide() >= 1 && state.cannibalsOnRightSide() >= 1){
                possibleStates.add(new State(state.missionariesOnLeftSide() + 1, state.cannibalsOnLeftSide() + 1,
                        state.missionariesOnRightSide() - 1, state.cannibalsOnRightSide() - 1, false, state.cost() + 1,0, state));
            }
        }

        if(state.parentState() != null){
            possibleStates.removeIf(stateInStream -> stateInStream.toString().equals(state.parentState().toString()));
        }

        return possibleStates;
    }
}
