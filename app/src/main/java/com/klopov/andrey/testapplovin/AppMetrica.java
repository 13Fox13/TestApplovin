package com.klopov.andrey.testapplovin;

import android.app.Application;

import com.yandex.metrica.YandexMetrica;

/**
 * Created by andrejklopov on 31.03.2018.
 */

public class AppMetrica extends android.app.Application {

    public static final String YANDEXMETRICA_ID = "280dbc21-175f-43fa-87df-b3d0a58cb352";

    @Override
    public void onCreate() {
        super.onCreate();
        // Инициализация AppMetrica SDK
        YandexMetrica.activate(getApplicationContext(), YANDEXMETRICA_ID);
        // Отслеживание активности пользователей
        YandexMetrica.enableActivityAutoTracking(this);
    }
// Так как приложение так и не заработало, то отслеживать нечего.
// Поэтому и тут было сложно разобраться. Dark magic.
}
