package com.example;

public abstract class ProcessStep {
    private boolean result;

    public void execute(MixingTank tank) {
        if (this.basicExecute(tank)) {
            this.setSucces();
        } else {
            this.setFailure();
        }
    }

    protected abstract boolean basicExecute(MixingTank tank);

    public boolean isDone() {
        return result;
    }

    private void setSucces() {
        this.result = true;
    }

    private void setFailure() {
        this.result = false;
    }
}
