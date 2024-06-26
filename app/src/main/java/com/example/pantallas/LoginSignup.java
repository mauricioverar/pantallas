package com.example.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent i = getIntent();
        String msg = i.getStringExtra("Mensaje"); // recibir del intent

        TextView myMsg = (TextView) findViewById(R.id.txv_Msg);
        myMsg.setText(msg);

        Button btn_signup =  findViewById(R.id.button5); // err...faltaba el 5

        // el btn_signup con Intent para cambiar pantalla ******
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSignup.this, Signup.class); // intencion explicita de lanzar una nueva activity
                startActivity(intent); // explicito indica hacia donde específicamente, implicito no se sabe hacia donde
            }
        });

        // getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //finish(); // destruir activity
                return true;
        }
        return super.onOptionsItemSelected(item);
    } */

    // metodo Go:login para ser usado como evento para cambiar pantalla
    public void Go_login (View view) {
        Intent ilogin = new Intent(this, Login.class);
        startActivity(ilogin);
    }

    // metodo boton anterior
    public void Anterior (View view) {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }





}