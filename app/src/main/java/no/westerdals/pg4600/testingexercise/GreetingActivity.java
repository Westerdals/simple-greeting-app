package no.westerdals.pg4600.testingexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        final EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        final Button greetingButton = (Button) findViewById(R.id.greetButton);
        final TextView greetingTextView = (TextView) findViewById(R.id.greetingTextView);

        // Make sure things were found.
        assert nameEditText != null;
        assert greetingButton != null;
        assert greetingTextView != null;

        greetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final String name = nameEditText.getText().toString();
                final String message = GreetingCreator.fromName(name);
                greetingTextView.setText(message);
            }
        });
    }
}
