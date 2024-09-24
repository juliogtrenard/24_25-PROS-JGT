#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

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
    int n = 5;

    printf("Padre, PID: %d\n", getpid());

    crearHijo(n, 1);

    exit(0);
}