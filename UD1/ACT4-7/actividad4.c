#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sched.h>
#include <sys/wait.h>

int main()
{
    pid_t pid;

    //Bucle para crear los 3 hijos
    for(int i = 1; i <= 3; i++)
    {
        switch(pid = fork())
        {
            //Parte de los hijos
            case 0:
                printf("Soy el hijo %d, Mi padre es %d y mi PID es %d\n", i, getppid(), getpid());
                exit(0);
                break;
            //En caso de error
            case -1:
                printf("No se ha podido crear el proceso.");
                exit(-1);
                break;
            //Padre que espera a que terminen los hijos
            default:
                wait(NULL);
                break;
        }
    }

    //Proceso padre fuera del bucle para aparecer al final
    printf("Proceso padre %d", getpid());
    exit(0);
}