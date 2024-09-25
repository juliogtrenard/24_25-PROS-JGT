#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sched.h>
#include <sys/wait.h>

/*
Proceso que suma o resta 5 dependiendo de si es hijo o padre
Hijo resta 5
Padre suma 5
*/

int main()
{
    pid_t pid;

    //Valor con el que inicia la variable
    int valor = 6;

    printf("Valor inicial de la variable: %d\n", valor);

    //Se crea el hijo
    pid = fork();

    //Estamos en el hijo
    if(pid == 0)
    {
        //Se resta 5 a la variable, saca el mensaje y finaliza
        valor -= 5;
        printf("Variable en Proceso Hijo: %d\n", valor);
        exit(0);
    } else { //Estamos en el padre
        //Se suma 5, espera a que finalice el hijo y saca el mensaje
        valor += 5;
        wait(NULL);
        printf("Variable en Proceso Padre: %d\n", valor);
    }
    //Finaliza el padre
    exit(0);
}