package com.example.szachownica;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import static java.lang.Math.min;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {
    Panel P;
    Paint tlo_pola = new Paint();
    Paint tlo_pola2 = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(P = new Panel(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tworca) {
            Context context = getApplicationContext();
            CharSequence text = "Twórca: Michał Małyszko";
            int czas = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, czas);
            toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 0);
            toast.show();
            return true;
        } else if (item.getItemId() == R.id.wyjscie) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.kolor1) {
            tlo_pola.setColor(Color.BLACK);
            tlo_pola2.setColor(Color.WHITE);
            P.postInvalidate();
            return true;
        } else if (item.getItemId() == R.id.kolor2) {
            tlo_pola.setColor(Color.RED);
            tlo_pola2.setColor(Color.YELLOW);
            P.postInvalidate();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


class Panel extends View {
    public Panel(Context context) {
        super(context);
        tlo_pola.setColor(Color.WHITE);
        tlo_pola2.setColor(Color.BLACK);

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        float bok = min(getWidth(), getHeight());
        float lewy = (getWidth() - bok) / 2;
        float gora = (getHeight() - bok) / 2;
        float pole = bok / 8;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                float lewoPola = lewy + i * pole;
                float goraPola = gora + j * pole;
                if ((i + j) % 2 == 0) {
                    canvas.drawRect(lewoPola, goraPola, lewoPola + pole, goraPola + pole, tlo_pola);
                } else {
                    canvas.drawRect(lewoPola, goraPola, lewoPola + pole, goraPola + pole, tlo_pola2);
                }
            }
        }
    }
}
}