package com.example.proyecto_spring_html_th;


public class EoiCalendar {
    private String actionText;
    private String actionHora;
    private String actionDia;
    public String getActionHora() {
        return actionHora;
    }

    public void setActionHora(String actionHora) {
        this.actionHora = actionHora;
    }

    public String getActionDia() {
        return actionDia;
    }

    public void setActionDia(String actionDia) {
        this.actionDia = actionDia;
    }


    // CONSTRUCTOR
    public EoiCalendar(String action) {
        this.actionText = action;
    }
    // GETTER & SETTER
    public String getActionText() {
        return actionText;
    }
    public void setActionText(String action) {
        this.actionText = action;
    }
}


