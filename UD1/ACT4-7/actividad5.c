#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

/*
Funcion recursiva para crear n hijos
cantProcesos indica la cantidad de hijos a crear
numHijo indica qué hijo es, ejemplo Hijo 1, Hijo 2, etc
*/
void crearHijo(int cantProcesos, int numHijo) {
    if (numHijo > cantProcesos) {
        exit(0);
    }

    pid_t pid = fork();

    if (pid == 0) {
        printf("Hijo %d, PID: %d, PPID: %d\n", numHijo, getpid(), getppid());
        crearHijo(cantProcesos, numHijo + 1);
    } else {
        wait(NULL);
    }
}

int main()
{
    //Numero de hijos a crear
    int n = 5;

    printf("Padre, PID: %d\n", getpid());

    //Llamada a la función para crear los hijos
    crearHijo(n, 1);

    exit(0);
}