package com.citas.ganaderias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private EditText nombre,email_1,pass,repass;
    private CheckBox ovino,caprino,porcino,vacuno;

    private FirebaseAuth auth;
    private FirebaseFirestore baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.et_nombreregistro);
        email_1 = findViewById(R.id.et_emailregistro);
        pass = findViewById(R.id.et_passregistro);
        repass = findViewById(R.id.et_repassregistro);

        ovino = findViewById(R.id.cb_ovino);
        caprino = findViewById(R.id.cb_caprino);
        porcino = findViewById(R.id.cb_porcino);
        vacuno = findViewById(R.id.cd_vacuno);

        auth = FirebaseAuth.getInstance();
        baseDatos = FirebaseFirestore.getInstance();



    }

    public void onCreate (View view){

        String email = email_1.getText().toString();
        String password = pass.getText().toString();
        String username = nombre.getText().toString();
        String ganado = "";
        if (ovino.isChecked()==true){
            ganado = "Ovino";
        }
        if (caprino.isChecked()==true){
            ganado = "Caprino";
        }
        if (porcino.isChecked()==true){
            ganado = "Porcino";
        }
        if (vacuno.isChecked()==true){
            ganado = "Vacuno";
        }
        String finalGanado = ganado;
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Registro.this, "Registro correcto", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = auth.getCurrentUser();
                            String userID = user.getUid();
                            DocumentReference documentReference = baseDatos.collection("Users").document(userID);
                            Map<String, Object> datauser  = new HashMap<>();
                            datauser.put("NombreUsuario", username);
                            datauser.put("TipoGanado", finalGanado);
                            documentReference.set(datauser).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(Registro.this, "Registro correcto de datos", Toast.LENGTH_SHORT).show();
                                    Intent registro = new Intent(Registro.this, Home_main.class);
                                    startActivity(registro);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Registro.this, "No se ha registrado", Toast.LENGTH_SHORT).show();
                                }
                            });




                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Registro.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });


  }


  // Acción botón borrar datos en pantalla

    public void Borrar (View view){
        nombre.setText("");
        email_1.setText("");
        pass.setText("");
        repass.setText("");
    // Los checkbox
        ovino.setChecked(false);
        caprino.setChecked(false);
        porcino .setChecked(false);
        vacuno.setChecked(false);

    }

    // Acción botón volver

    public void Volver (View view){
        finish();
    }

}