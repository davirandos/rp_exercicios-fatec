notas_fatec = ['luccas', 8.0, 'vitoria', 3.0, 'arthur', 5.0]

# nomes = []
# notas = []

# for i in range(len(notas_fatec)):
    # if i % 2 == 0:
        # nomes.append(notas_fatec[i]) # se o índice for par, adiciona o nome à lista de nomes
    # else:
        # notas.append(notas_fatec[i]) # se o índice for ímpar, adiciona a nota à lista de notas

# print("Nomes:", nomes)
# print("Notas:", notas)

notas = []

for i in range(0, len(notas_fatec), 2):
    notas.append([notas_fatec[i], notas_fatec[i + 1]]) # adiciona o nome e a nota como uma sublista à lista de notas
print(notas[2])