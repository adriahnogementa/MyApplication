package com.example.myapplication;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.databinding.FragmentStartBinding;
import com.google.android.material.snackbar.Snackbar;

public class StartFragment extends Fragment {

    private final String CHANNEL_ID = "main_001";
    private final int NOTIFICATION_ID = 12345;
    private FragmentStartBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentStartBinding.inflate(inflater);
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        NotificationManagerCompat manager = NotificationManagerCompat.from(getActivity());
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                                                              "Mobile Development " +
                                                                      "Notification",
                                                              NotificationManager.IMPORTANCE_DEFAULT);
        manager.createNotificationChannel(channel);


        binding.zurHerr.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(StartFragmentDirections.actionStartFragmentToAnredeFragment(binding.vorname.getText().toString(), binding.nachname.getText().toString(), true, false

            ));
        });

        binding.zurFrau.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(StartFragmentDirections.actionStartFragmentToAnredeFragment(binding.vorname.getText().toString(), binding.nachname.getText().toString(), false, true));

        });

        binding.zurEs.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(StartFragmentDirections.actionStartFragmentToAnredeFragment(binding.vorname.getText().toString(), binding.nachname.getText().toString(), false, false));

        });

        binding.zuPractice.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(StartFragmentDirections.actionStartFragmentToLayoutPractice());

        });

        binding.zurListe.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(StartFragmentDirections.actionStartFragmentToItemFragment());
        });

        binding.snackbar.setOnClickListener(v -> {

            Snackbar.make(v, "Hallo ich bin eine Snackbar", Snackbar.LENGTH_LONG).setAction(
                    "Close", s -> {

                        getActivity().requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 123456);
                        createNotification(view);
                    }).show();

        });


        registerForContextMenu(binding.kontext);

        return binding.getRoot();
    }

    private void createNotification(View view) {

        PendingIntent intent = PendingIntent.getActivity(getActivity(), 0,
                                                         new Intent(getActivity(),
                                                                    MainActivity.class).setAction(Intent.ACTION_VIEW).putExtra("extra", "Hallo ich bin auch noch hier"), PendingIntent.FLAG_UPDATE_CURRENT + PendingIntent.FLAG_IMMUTABLE);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(),
                                                                            CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentIntent(intent);
        builder.setContentTitle("Nachricht");
        builder.setContentText("Lorem ipsum allter manus chriptus inovicationus befonus....");
        NotificationManagerCompat manager = NotificationManagerCompat.from(getActivity());
        if (PackageManager.PERMISSION_GRANTED == getActivity().checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)) {

            manager.notify(NOTIFICATION_ID, builder.build());
        }
    }

}