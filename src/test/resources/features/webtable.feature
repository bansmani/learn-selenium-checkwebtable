Feature:  sample

  Scenario:
    Given launch application
  Scenario Outline: Breaker guesses a word
    Then  webtable at row <rowid> and column "Make" should have value "<Make>"
    Then  webtable at row <rowid> and column "Model" should have value "<Model>"
    Then  webtable at row <rowid> and column "Year" should have value "<Year>"


    Examples:
      | rowid | Make    | Model   | Year |
      | 1     | Honda   | Accord  | 2009 |
      | 2     | Toyota  | Camry   | 2020 |
      | 3     | Hyundai | Elantra | 2010 |
