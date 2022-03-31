package uz.context.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import uz.context.jobscheduler.databinding.ActivityMain2Binding;
import uz.context.jobscheduler.services.ExampleJobService;
import uz.context.jobscheduler.services.ExampleService;

public class MainActivity extends AppCompatActivity {

    Button btnScheduleJob, btnCancelJob;
    private static final String TAG = "MainActivity";
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();

    }

    private void initViews() {
        binding.btnStartService.setOnClickListener(view -> {
            String input = binding.edtInput.getText().toString().trim();

            Intent serviceIntent = new Intent(this, ExampleService.class);
            serviceIntent.putExtra("inputExtra", input);

            startService(serviceIntent);
        });
        binding.btnStopService.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(this, ExampleService.class);
            stopService(serviceIntent);
        });
    }
}
    /*
    public void scheduleJob(View v) {
        ComponentName componentName = new ComponentName(this, ExampleJobService.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = scheduler.schedule(info);
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job scheduled");
        } else {
            Log.d(TAG, "Job scheduling failed");
        }
    }

    public void cancelJob(View v) {
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.cancel(123);
        Log.d(TAG, "Job cancelled");
    }

     */
