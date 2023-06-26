package com.example.gofit_10762.ManajerOperasional

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_10762.Member.BerandaMemberActivity
import com.example.gofit_10762.R
import com.example.gofit_10762.databinding.FragmentBerandaMOBinding
import com.example.gofit_10762.databinding.FragmentBerandaMemberBinding


class BerandaMOFragment : Fragment() {
    private var _binding : FragmentBerandaMOBinding? = null
    private val binding get() = _binding!!
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ft = parentFragmentManager.beginTransaction()
        ft.detach(this).attach(this).commit()

        val activity: BerandaMOActivity? = activity as BerandaMOActivity?
        _binding = FragmentBerandaMOBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()

        binding.namaMO.setText(nama)

        return binding.root
    }
}