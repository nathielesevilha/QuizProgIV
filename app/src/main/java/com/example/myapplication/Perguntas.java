package com.example.myapplication;

public class Perguntas {
    private int respostaResId;
    private boolean respostaVerdade;

    public Perguntas(int respostaResId, boolean respostaVerdade) {
        this.respostaResId = respostaResId;
        this.respostaVerdade = respostaVerdade;
    }

    public int getRespostaResId() {
        return respostaResId;
    }

    public void setRespostaResId(int respostaResId) {
        this.respostaResId = respostaResId;
    }

    public boolean isRespostaVerdade() {
        return respostaVerdade;
    }

    public void setRespostaVerdade(boolean respostaVerdade) {
        this.respostaVerdade = respostaVerdade;
    }
}


