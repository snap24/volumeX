package com.zygisk_enc.volumeX;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(64, 80, 64, 64);
        root.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView logoLabel = new TextView(this);
        logoLabel.setText("VX");
        logoLabel.setTextSize(24);
        logoLabel.setTextColor(getResources().getColor(android.R.color.white));
        logoLabel.setGravity(Gravity.CENTER);
        logoLabel.setTypeface(null, android.graphics.Typeface.BOLD);
        
        MaterialCardView logoCard = new MaterialCardView(this);
        LinearLayout.LayoutParams logoParams = new LinearLayout.LayoutParams(120, 120);
        logoParams.setMargins(0, 0, 0, 48);
        logoCard.setLayoutParams(logoParams);
        logoCard.setCardBackgroundColor(getResources().getColor(android.R.color.black));
        logoCard.setRadius(30f);
        logoCard.setStrokeWidth(0);
        logoCard.addView(logoLabel);
        root.addView(logoCard);

        TextView title = new TextView(this);
        title.setText(R.string.how_to_use);
        title.setTextSize(24);
        title.setPadding(0, 0, 0, 48);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(android.graphics.Typeface.create("sans-serif-medium", android.graphics.Typeface.NORMAL));
        root.addView(title);

        MaterialCardView instructionCard = new MaterialCardView(this);
        instructionCard.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        instructionCard.setRadius(32f);
        instructionCard.setCardElevation(0f);
        instructionCard.setStrokeWidth(2);
        instructionCard.setStrokeColor(getResources().getColor(android.R.color.darker_gray));

        LinearLayout cardContent = new LinearLayout(this);
        cardContent.setOrientation(LinearLayout.VERTICAL);
        cardContent.setPadding(40, 40, 40, 40);
        cardContent.addView(createStep(getString(R.string.step_1)));
        cardContent.addView(createStep(getString(R.string.step_2)));
        cardContent.addView(createStep(getString(R.string.step_3)));
        instructionCard.addView(cardContent);
        root.addView(instructionCard);

        TextView privacyTitle = new TextView(this);
        privacyTitle.setText(R.string.privacy_title);
        privacyTitle.setTextSize(18);
        privacyTitle.setPadding(0, 64, 0, 16);
        privacyTitle.setTypeface(null, android.graphics.Typeface.BOLD);
        root.addView(privacyTitle);

        TextView privacyDesc = new TextView(this);
        privacyDesc.setText(R.string.privacy_desc);
        privacyDesc.setPadding(0, 0, 0, 64);
        privacyDesc.setLineSpacing(0, 1.4f);
        privacyDesc.setGravity(Gravity.CENTER);
        root.addView(privacyDesc);

        MaterialButton githubBtn = new MaterialButton(this);
        githubBtn.setText("View Source");
        githubBtn.setAllCaps(false);
        githubBtn.setCornerRadius(32);
        githubBtn.setBackgroundColor(getResources().getColor(android.R.color.black));
        githubBtn.setTextColor(getResources().getColor(android.R.color.white));
        githubBtn.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.github_url))));
        });
        root.addView(githubBtn, new LinearLayout.LayoutParams(-1, -2));

        setContentView(root);
    }

    private TextView createStep(String text) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setPadding(0, 16, 0, 16);
        tv.setTextSize(15);
        return tv;
    }
}
