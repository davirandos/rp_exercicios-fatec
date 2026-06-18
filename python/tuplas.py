from random import randint

estudantes = ["Joao", "Maria", "Pedro", "Ana", "Lucas"]

def gera_cod():
    return str(randint(0, 999))

codigo_estudante = []

for i in range(len(estudantes)):
    codigo_estudante.append((estudantes[i], estudantes[i][0] + gera_cod())) # cria uma tupla com o nome do estudante e um código gerado aleatoriamente

print(codigo_estudante)