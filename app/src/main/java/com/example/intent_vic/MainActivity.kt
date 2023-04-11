package com.example.intent_vic

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnsms:Button
    lateinit var btnemail:Button
    lateinit var btncamera:Button
    lateinit var btnshare:Button
    lateinit var btnmpesa:Button
    lateinit var btncall:Button
    lateinit var btnsubsititue:Button
    lateinit var btnmap:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsms = findViewById(R.id.btn_sms)
        btnemail = findViewById(R.id.btn_email)
        btncamera = findViewById(R.id.btn_camera)
        btnshare = findViewById(R.id.btn_share)
        btnmpesa = findViewById(R.id.btn_mpesa)
        btncall = findViewById(R.id.btn_call)
        btnsubsititue = findViewById(R.id.btn_substitute)
        btnmap = findViewById(R.id.btn_map)

        btnsms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0723151633")
              val intent= Intent(Intent.ACTION_SENDTO, uri)
              intent.putExtra("sms_body", "vipi wazito")
              startActivity(intent)

        }

        btnemail.setOnClickListener {
            val emailintent= Intent(Intent.ACTION_SENDTO, Uri.fromParts("malito", "vhexit@yahoo.com", null))
            emailintent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailintent.putExtra(Intent.EXTRA_TEXT, "Dear sir, please enter your email")
            startActivity(Intent.createChooser(emailintent, "send email"))
        }

        btncamera.setOnClickListener {
            val takepctureintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takepctureintent, 1)
        }

        btnmpesa.setOnClickListener {
            val simToolKitintent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitintent?.let { startActivity(it) }
        }
    }
}