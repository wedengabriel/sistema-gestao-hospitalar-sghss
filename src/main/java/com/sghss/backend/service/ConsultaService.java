package com.sghss.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sghss.backend.dto.ConsultaCreateDTO;
import com.sghss.backend.dto.ConsultaDTO;
import com.sghss.backend.entity.Consulta;
import com.sghss.backend.entity.Medico;
import com.sghss.backend.entity.Paciente;
import com.sghss.backend.repository.ConsultaRepository;
import com.sghss.backend.repository.MedicoRepository;
import com.sghss.backend.repository.PacienteRepository;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaService(
            ConsultaRepository consultaRepository,
            PacienteRepository pacienteRepository,
            MedicoRepository medicoRepository
    ) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public ConsultaDTO criarConsulta(ConsultaCreateDTO dto) {

        Paciente paciente = pacienteRepository.findById(dto.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dto.getIdMedico())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        Consulta consulta = new Consulta();

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setHoraConsulta(dto.getHoraConsulta());
        consulta.setTipoConsulta(dto.getTipoConsulta());
        consulta.setStatus(dto.getStatus());

        Consulta consultaSalva = consultaRepository.save(consulta);

        return converterParaDTO(consultaSalva);
    }

    public List<ConsultaDTO> listarConsultas() {
        return consultaRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public ConsultaDTO buscarPorId(Integer id) {

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        return converterParaDTO(consulta);
    }

    public void deletarConsulta(Integer id) {

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consultaRepository.delete(consulta);
    }

    private ConsultaDTO converterParaDTO(Consulta consulta) {

        ConsultaDTO dto = new ConsultaDTO();

        dto.setIdConsulta(consulta.getIdConsulta());
        dto.setDataConsulta(consulta.getDataConsulta());
        dto.setHoraConsulta(consulta.getHoraConsulta());
        dto.setTipoConsulta(consulta.getTipoConsulta());
        dto.setStatus(consulta.getStatus());

        return dto;
    }
}