package com.dge1992.spring.ioc.part8;

public class Pig {

    private Ear ear;
    private Eye eyeName;
    private Mouse mouse;

    public Pig() {
    }

    public Pig(Mouse mouse) {
        this.mouse = mouse;
    }

    public Ear getEar() {
        return ear;
    }

    public void setEar(Ear ear) {
        this.ear = ear;
    }

    public Eye getEyeName() {
        return eyeName;
    }

    public void setEyeName(Eye eyeName) {
        this.eyeName = eyeName;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "ear=" + ear +
                ", eyeName=" + eyeName +
                ", mouse=" + mouse +
                '}';
    }
}
