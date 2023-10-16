package utils;

import model.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static boolean goalCheck(State currentState) {
        return currentState.toString().equals("0033-true");
    }

    public static boolean badState(State currentState) {
        return List.of("1320", "2310", "1221", "2013", "1023", "2112").contains(currentState.toString().substring(0, 4));
    }

    public static void printAnswer(State finalState) {
        ArrayList<String> states = new ArrayList<>();
        State stateTemp = finalState;
        while (stateTemp != null) {
            states.add(stateTemp.toString());
            stateTemp = stateTemp.parentState();
        }
        Collections.reverse(states);
        states.forEach(System.out::println);
    }
}
