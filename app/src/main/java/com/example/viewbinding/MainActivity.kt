package com.example.viewbinding

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.viewbinding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var dialog: Dialog

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to exit")
            builder1.setIcon(R.drawable.baseline_arrow_back_24)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->

            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val order = arrayOf("KGF","Animal","Dunki","Ankit")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Choice any one options")
            builder2.setSingleChoiceItems(order,0,DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"You check on ${order[which]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Accept",DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val mulitChoice = arrayOf("Chicken","Mutan","Egg")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Choice Mulitple choice")
            builder3.setMultiChoiceItems(mulitChoice,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"you have choiced ${mulitChoice[which]}",Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->

            })
            builder3.setNegativeButton("Decline",DialogInterface.OnClickListener { dialog, which ->

            })
            builder3.show()
        }
        dialog = Dialog(this)
        dialog.setContentView(R.layout.aleartnotification)

        binding.btn4.setOnClickListener {
            dialog.show()
        }

        var btnComplete = dialog.findViewById<Button>(R.id.btncomplete)
        var btnFeedback = dialog.findViewById<Button>(R.id.btncontinue)

        btnComplete.setOnClickListener {
//            do function whatever you want to do.
            dialog.dismiss()
        }

        btnFeedback.setOnClickListener {
//            Do function whatever you want to perform
        }
    }
}