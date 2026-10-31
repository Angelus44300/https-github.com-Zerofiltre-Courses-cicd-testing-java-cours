package tech.zerofiltre.testing.calcul.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionFormatterTest {

  private SolutionFormatter solutionFormatter;

  @BeforeEach
  void initFormatter() {
    solutionFormatter = new SolutionFormatterImpl();
  }

  @Test
  @DisplayName("Devrait formater un grand nombre en respectant le séparateur du système")
  void format_shouldFormatAnyBigNumber() {
    // GIVEN
    final int number = 1_234_567_890;

    // On génère la valeur attendue dynamiquement selon la Locale exécutée par la JVM (Jenkins ou dev)
    DecimalFormat expectedFormatter = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.FRENCH));
    String expected = expectedFormatter.format(number);

    // WHEN
    final String result = solutionFormatter.format(number);

    // THEN
    assertThat(result).isEqualTo(expected);
  }
}