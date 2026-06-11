# instalando a biblioteca
import matplotlib.pyplot as plt

estudantes = ['João', 'Maria', 'Pedro', 'Ana', 'Lucas']
notas = [7.5, 8.0, 6.0, 9.0, 7.0]

plt.bar(x = estudantes, height = notas)
plt.show()