package com.route.islamic36.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.route.islamic36.R

class TasbehFragment : Fragment() {
    lateinit var counter: Button
    lateinit var Azkar: Button
    var count = 0
    var generalcounter = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_tasbeh,
            container, false
        );
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        counter = requireView().findViewById(R.id.counter_btn)
        Azkar = requireView().findViewById(R.id.azkar_btn)
        counter.setOnClickListener {
            count++
            generalcounter++
            if (generalcounter == 3) {
                Azkar.setText("الحمد لله")
                count = 0
            } else if (generalcounter == 6) {
                Azkar.setText("لَا إِاله إِلَّا اللهَّ")
                count = 0
            } else if (generalcounter == 9) {
                Azkar.setText("الله اكبر ")
            }
            counter.setText(count.toString())


        }
    }
}
