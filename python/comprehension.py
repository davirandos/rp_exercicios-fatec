notas = [[9.0, 10.0, 7.0], [8.0, 6.0, 9.0], [7.0, 8.0, 10.0], [6.0, 9.0, 8.0], [10.0, 7.0, 9.0]]

def media(lista: list=[0]) -> float:
    calculo = sum(lista) / len(lista)
    return calculo

medias = [media(nota) for nota in notas] # cria uma nova lista de médias usando list comprehension, onde cada média é calculada a partir da sublista de notas correspondente

for m in medias:
    print("%.1f" % m)