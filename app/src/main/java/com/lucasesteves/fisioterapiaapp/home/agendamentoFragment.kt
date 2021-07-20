package com.lucasesteves.fisioterapiaapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.lucasesteves.fisioterapiaapp.R
import com.lucasesteves.fisioterapiaapp.databinding.FragmentAgendamentoBinding
import com.lucasesteves.fisioterapiaapp.databinding.FragmentCadastrarBinding
import com.lucasesteves.fisioterapiaapp.model.servicos


class agendamentoFragment : Fragment() {
    private var binding: FragmentAgendamentoBinding? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgendamentoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var servico1 = arguments?.getString(KEY_SERVICO1)
        var servico2 = arguments?.getString(KEY_SERVICO2)
        val items = listOf(servico1, servico2)

        val adapter = ArrayAdapter(this.requireContext(), R.layout.list_item, items)
        (binding?.layoutAutocomplete?.editText as AutoCompleteTextView).setAdapter(adapter)





    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val KEY_LIST = "list"
        const val KEY_SERVICO1 = "01"
        const val KEY_SERVICO2 = "02"
    }

}