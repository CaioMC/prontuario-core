package com.titan.prontuario.sys.core.atendimento.adpter.out.db;

import com.titan.prontuario.sys.core.atendimento.domain.Atendimento;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface AtendimentoRepositoryJpa extends AtendimentoDomainRepository, Repository<Atendimento, UUID> {
}
