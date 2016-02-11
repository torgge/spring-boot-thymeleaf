package com.algaworks.cobranca.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Entity
public class Titulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NotEmpty(message = "Descrição é obrigatória.")
    @Size(max = 60, message = "A descrição não pode conter mais que 60 caracteres")
    private String descricao;

    @NotNull(message = "Data é obrigatória.")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @NotNull(message = "Valor é obrigatório.")
    @DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0.01.")
    @DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusTitulo status;

    public Titulo() {
        this.codigo = Long.valueOf(0);
        this.descricao = "";
        this.dataVencimento = Date.from(Instant.EPOCH);
        this.valor = BigDecimal.valueOf(0);
        this.status = StatusTitulo.PENDENTE;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() { return valor; }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusTitulo getStatus() {
        return status;
    }

    public void setStatus(StatusTitulo status) {
        this.status = status;
    }

    public boolean isPendente() {
        return StatusTitulo.PENDENTE.equals(this.status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Titulo titulo = (Titulo) o;

        return codigo.equals(titulo.codigo);

    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
