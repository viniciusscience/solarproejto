package br.com.triersistemas.solar.domain;

import br.com.triersistemas.solar.helper.StringUtils;
import br.com.triersistemas.solar.model.FarmaceuticoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "farmaceutico")
@Getter
public class Farmaceutico extends PessoaFisica {

    @Column(name = "promocao_dia")
    private String promocaoDia;

    public Farmaceutico() {
        this.promocaoDia = StringUtils.getRandomMedicine();
    }

    public Farmaceutico(final String nome, final LocalDate aniver, final String cpf) {
        super(nome, aniver, cpf);
        this.promocaoDia = StringUtils.getRandomMedicine();
    }

    public String getPromocaoDia() {
        return promocaoDia;
    }

    public Farmaceutico(FarmaceuticoModel farmaceuticoModel){
        super(farmaceuticoModel.getNome(), farmaceuticoModel.getAniver(), farmaceuticoModel.getCpf());
        this.promocaoDia=farmaceuticoModel.getPromocaoDia();
    }
}
