#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sched.h>
#include <sys/wait.h>

int main()
{
    pid_t pid;
    int valor = 6;

    printf("Valor inicial de la variable: %d\n", valor);

    pid = fork();

    if(pid == 0)
    {
        valor -= 5;
        printf("Variable en Proceso Hijo: %d\n", valor);
        exit(0);
    } else {
        valor += 5;
        wait(NULL);
        printf("Variable en Proceso Padre: %d\n", valor);
    }
    exit(0);
}