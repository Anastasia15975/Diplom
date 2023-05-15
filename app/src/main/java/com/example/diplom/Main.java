package com.example.diplom;

import com.example.diplom.scenes.MainMenuScene;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class Main extends CoreFW {

    public SceneFW getStartScene(){
        return new MainMenuScene(this);
    }
}