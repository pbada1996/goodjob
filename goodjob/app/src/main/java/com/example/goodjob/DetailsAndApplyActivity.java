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

import com.example.goodjob.classes.Activity;
import com.example.goodjob.classes.ValidSession;


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
    private TextView reward;

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
        reward = findViewById(R.id.tvReward);

        Activity selected = getIntent().getExtras().getParcelable("selectedActivity");
        loadData(selected);

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateStartedSession())
                {
                    if (validateAvailableActivities())
                    {
                        moreInfo.setText(R.string.already_in);
                        moreInfo.setEnabled(false);
                        // TODO: realizar proceso de inclusión a la actividad como participante
                        ValidSession.usuarioLogueado.setAvailableActivities(
                                ValidSession.usuarioLogueado.getAvailableActivities() - 1);
                        return;
                    }
                    dialogMessage("", "No cuentas con más participaciones disponibles " +
                                    "para aplicar a esta actividad", "Comprar más participaciones"
                                    , SuscriptionActivity.class);
                    return;
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
        author.setText(activity.getAuthor().substring(0, 20));
        creationDate.setText(formatDate(activity.getCreationDate()));
        endDate.setText(formatDate(activity.getEndDate()));
        currentParticipants.setText("De momento hay " + activity.getCurrentParticipants() + " postulantes");
        requiredParticipants.setText("Se necesitan " + activity.getRequiredParticipants() + " personas");
        photo.setImageResource(R.drawable.placeholder);
        reward.setText(activity.getRewardType() + " : " + activity.getReward());
    }

    private boolean validateStartedSession()
    {
        return ValidSession.usuarioLogueado != null;
    }

    private boolean validateAvailableActivities()
    {
        return ValidSession.usuarioLogueado.getAvailableActivities() > 0;
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

    private String formatDate(String date)
    {
        String [] fechaEnPartes = date.split("-");
        return fechaEnPartes[2] + "/" + fechaEnPartes[1] + "/" + fechaEnPartes[0];
    }
}
