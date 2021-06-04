package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusMaioresQueMilDevemSerZero() {
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("Higo Nunes", LocalDate.now(), new BigDecimal(25000))));
    }

    @Test
    void bonusMenoresOuIgualMilDevemSerDezPorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Higo Nunes", LocalDate.now(), new BigDecimal(2500)));
        assertEquals(bonus, new BigDecimal("250.00"));

        BonusService bonusService2 = new BonusService();
        BigDecimal bonus2 = bonusService.calcularBonus(new Funcionario("Higo Nunes", LocalDate.now(), new BigDecimal(10000)));
        assertEquals(bonus2, new BigDecimal("1000.00"));
    }

}