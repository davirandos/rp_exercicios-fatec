# importando a biblioteca random
from random import randrange

nome = input('Digite seu nome: ')

# escolhendo um número aleatório
numero_aleatorio = randrange(1000, 9998, 2)

print(f'Olá {nome}, seu número aleatório é: {numero_aleatorio}')