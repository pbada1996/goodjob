package com.example.goodjob;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.goodjob.classes.Activity;


public class DetailsAndApplyActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private TextView author;
    private TextView creationDate;
    private TextView endDate;
    private TextView currentParticipants;
    private TextView requiredParticipants;
    private ImageView photo;
    private Button moreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_and_apply);

        title = findViewById(R.id.tvTitle);
        description = findViewById(R.id.tvDescription);
        author = findViewById(R.id.tvAuthorName);
        creationDate = findViewById(R.id.tvCreationDateValue);
        endDate = findViewById(R.id.tvendDateValue);
        currentParticipants = findViewById(R.id.tvCurrent);
        requiredParticipants = findViewById(R.id.tvRequired);
        photo = findViewById(R.id.imgPhoto);
        moreInfo = findViewById(R.id.btnMoreInfo);

        Activity selected = getIntent().getExtras().getParcelable("selectedActivity");
        loadData(selected);

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* primero validar si la sesión está iniciada, de no estarlo indicar
                 *  que debe iniciar sesión para realizar esta operación
                 */
                if (validateStartedSession())
                {
                    /* validar si tiene 'espacio' en actividades disponibles */
                    if (validateAvailableActivities())
                    {

                    }
                    // TODO: cambiar por el de suscripción cuando esté
                    dialogMessage("", "No cuentas con más participaciones disponibles " +
                                    "para aplicar a esta actividad", "Comprar más participaciones"
                                    , null);
                }
                dialogMessage("Inicio de sesión", "Debes iniciar sesión para " +
                        "realizar esta operación", "Iniciar sesión!", LoginActivity.class);
            }
        });
    }

    private void loadData(Activity activity)
    {
        title.setText(activity.getTitle());
        description.setText(activity.getDescription());
        author.setText(activity.getAuthor());
        creationDate.setText(activity.getCreationDate());
        endDate.setText(activity.getEndDate());
        currentParticipants.setText("De momento hay " + activity.getCurrentParticipants() + " postulantes");
        requiredParticipants.setText("Se necesitan " + activity.getRequiredParticipants() + " personas");
        photo.setImageResource(activity.getPhoto());
    }

    private boolean validateStartedSession()
    {
        return false;
    }

    private boolean validateAvailableActivities()
    {
        return false;
    }

    private void dialogMessage(String title, String message, String positivo, final Class<?> next)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailsAndApplyActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                startActivity(new Intent(DetailsAndApplyActivity.this, next));
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
