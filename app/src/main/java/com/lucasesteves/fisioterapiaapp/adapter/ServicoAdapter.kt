package com.lucasesteves.fisioterapiaapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasesteves.fisioterapiaapp.databinding.ServicosBinding
import com.lucasesteves.fisioterapiaapp.model.servicos

class ServicoAdapter(
    private val servicosList: List<servicos>,
    private val onClickListener: (servico: servicos) -> Unit
) : RecyclerView.Adapter<ServicoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ServicosBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(servicosList[position], onClickListener)
    }

    override fun getItemCount() = servicosList.size

    class ViewHolder(
        val binding: ServicosBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            servico: servicos,
            onClickListener: (servico: servicos) -> Unit
        ) {
            binding.servicoName.text = servico.name
            binding.dispo.text = servico.disponibilidade
            binding.fotoPerfil.setImageResource(servico.avatar)
            binding.servicosContainer.setOnClickListener{
                onClickListener(servico)
            }

        }
    }
}


