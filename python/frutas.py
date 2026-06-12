# importando a biblioteca random
from random import choices

frutas = ["maçã", "banana", "uva", "pêra", 
          "manga", "coco", "melancia", "mamão",
          "laranja", "abacaxi", "kiwi", "ameixa"]

# escolhendo 3 frutas aleatórias
frutas_aleatorias = choices(frutas, k=3)

print("Frutas escolhidas:", frutas_aleatorias)