package com.jatinsinghroha.volleyapicalls;

public class StateItem {

    private int state_id;
    private String state_name;

    public StateItem(int state_id, String state_name) {
        this.state_id = state_id;
        this.state_name = state_name;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }
}
