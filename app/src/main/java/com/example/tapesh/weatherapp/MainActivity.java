package com.example.tapesh.weatherapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView city_field,updated_field,weather_icon,current_temperature_field,details_field;
    TextView humidity_field,pressure_field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city_field=(TextView)findViewById(R.id.city_field);
        updated_field=(TextView)findViewById(R.id.updated_field);
        weather_icon=(TextView)findViewById(R.id.weather_icon);
        current_temperature_field=(TextView)findViewById(R.id.current_temperature_field);
        details_field=(TextView)findViewById(R.id.details_field);
        humidity_field=(TextView)findViewById(R.id.humidity_field );
        pressure_field=(TextView)findViewById(R.id.pressure_field);

        Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                city_field.setText(weather_city);
                updated_field.setText(weather_updatedOn);
                details_field.setText(weather_description);
                current_temperature_field.setText(weather_temperature);
                humidity_field.setText("Humidity: "+weather_humidity);
                pressure_field.setText("Pressure: "+weather_pressure);
                weather_icon.setText(Html.fromHtml(weather_iconText));

            }
        });
        asyncTask.execute("25.180000", "89.530000"); //  asyncTask.execute("Latitude", "Longitude")





    }
}
