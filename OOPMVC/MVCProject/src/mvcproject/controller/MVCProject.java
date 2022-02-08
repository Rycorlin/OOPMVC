package mvcproject.controller;

import mvcproject.model.NavModel;
import mvcproject.view.NavView;

public class MVCProject
{
    public static void main(String[] args)
    {
        NavModel model = new NavModel();
        NavView view = new NavView();
        NavController controller = new NavController(model, view);
    }
}
