#include <stdio.h>
#include <pthread.h>

void* contar(void* arg) {
    long id = (long)arg;

    for(long i = 0; i < 1000000000; i++) {
        // Contar até 1 milhão
        long i;
        long id = *(long*)arg;

        for(long i = 0; i < 1000000000; i++) {

        }
        
        printf("thread %ld terminou\n", id);
        return(NULL);
    }
}

int main() {
    pthread_t t1, t2, t3;
    long id1 = 1, id2 = 2, id3 = 3;
    pthread_create(&t1, NULL, contar, (void*)id1);
    pthread_create(&t2, NULL, contar, (void*)id2);
    pthread_create(&t3, NULL, contar, (void*)id3);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    pthread_join(t3, NULL);

    return 0;
}