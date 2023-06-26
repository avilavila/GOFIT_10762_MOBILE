package com.example.gofit_10762.ManajerOperasional

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_10762.R
import com.example.gofit_10762.User.RClientUser
import com.example.gofit_10762.User.ResponseCreateMO
import com.example.gofit_10762.databinding.FragmentProfilMOBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilMOFragment : Fragment() {
    private var _binding: FragmentProfilMOBinding? = null
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
        _binding = FragmentProfilMOBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()
        val call: Call<ResponseCreateMO?>? = RClientUser.apiService.getMO(idUser)
        call?.enqueue(object : Callback<ResponseCreateMO?> {
            override fun onResponse(call: Call<ResponseCreateMO?>, response: Response<ResponseCreateMO?>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        binding.txtNama.setText(it.data.nama_pegawai)
                        binding.txtId.setText(it.data.id_pegawai)
                        binding.txtAlamat.setText(it.data.ALAMAT_PEGAWAI)
                        binding.txtNoTelp.setText(it.data.telepon_pegawai)
                        binding.txtEmail.setText(it.data.email_pegawai)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCreateMO?>, t: Throwable) {
            }
        })

        return binding.root
    }
}