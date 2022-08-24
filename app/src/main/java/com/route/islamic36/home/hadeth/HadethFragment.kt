package com.route.islamic36.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.Constants
import com.route.islamic36.R
import com.route.islamic36.home.hadeth.adapter.HadethNameAdapter
import com.route.islamic36.home.hadeth.hadethDetails.HadethDetailsActivity

class HadethFragment : Fragment() {
    val hadethnames = listOf(
        "الحديث الأول",
        "الحديث الثاني",
        "الحديث الثالث",
        "الحديث الـرابع",
        " الحديث الخامس",
        "الحديث السادس",
        "الحديث السابع",
        "الحديث الثامن",
        "الحديث التاسع",
        "الحديث العاشر",
        "الحديث الحادي عشر",
        "الحد يث الثاني عشر",
        "الحد يث الثالث عشر",
        "الحد يث الرابع عشر",
        "الحد يث الخامس عشر",
        "الحديث السادس عشر",
        "الحديث السابع عشر",
        "الحديث الثامن عشر",
        "الحديث التاسع عشر",
        "الحد يث العشرون",
        "الحديث الحادي والعشرون",
        "الحديث الثاني والعشرون",
        "الحديث الثالث والعشرون",
        "الـحديث الرابع والعشرون",
        "الحديث الخامس والعشرون",
        "الحد يث السادس والعشرون",
        "الحد يث السابع والعشرون",
        "الحد يث الثامن والعشرون",
        "الحد يث التاسع والعشرون",
        "الحديث الثلا ثــون",
        "الـحديث الحادي والثلاثون",
        "الحديث الثاني والثلاثون",
        " الحد يث الثالث والثلاثون",
        "الحد يث الرابع والثلاثون",
        "الحد يث الخامس والثلاثون",
        "الحد يث السادس والثلاثون",
        "الحديث السابع والثلاثون",
        "الـحديث الثامن والثلاثون",
        "الحديث التاسع والثلاثون",
        "الحد يث الأربعون",
        "الحد يث الحادي والأربعون",
        "الحد يث الثاني والأربعـون",
        "الحد يث الثالث والأربعون",
        "الحديث الرابع والأربعون",
        "الـحديث الخامس والأربعون",
        "الحديث السادس والأربعون ",
        "الحديث السابع والأربعون",
        "الـحديث الثامن والأربعون",
        "الحديث التاسع والأربعون",
        "الحديث الخمسون",
        "  ",
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadethNameAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.ahadeth_recycleview)
        adapter = HadethNameAdapter(hadethnames)
        adapter.OnItemClicklistener = object : HadethNameAdapter.onItemClicklistener {
            override fun onItemClick(position: Int, name: String) {
                Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
                showHadethDetails(position, name)
            }
        }
        recyclerView.adapter = adapter
    }

    fun showHadethDetails(pos: Int, name: String) {
        val intent = Intent(requireActivity(), HadethDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRS_HADETHNAME, name)
        intent.putExtra(Constants.EXTRS_HADETHPOSTION, pos)
        startActivity(intent)

    }
}