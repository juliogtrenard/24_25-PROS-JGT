#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sched.h>
#include <sys/wait.h>

int main()
{
    int pid, pid1, pid2;
  
    //Se crea el hijo 1
    pid = fork();

    if(pid == 0)
    {
        //Hijo 1, saca su mensaje y muere
        printf("Yo soy el hijo 1, mi padre es PID = %d, yo soy PID = %d\n", getppid(), getpid());
        exit(0);
    } else {
        //Se crea el hijo 2
        pid1 = fork();

        if(pid1 == 0)
        {
            //Se crea el hijo 3
            pid2 = fork();

            if(pid2 == 0) {
                //Hijo 3, saca su mensaje y muere
                printf("Yo soy el hijo 3, mi padre es PID = %d, yo soy PID = %d\n", getppid(), getpid());
                exit(0);
            } else {
                //Hijo 2, espera que Hijo 3 muera, luego saca su mensaje y finaliza
                wait(NULL);
                printf("Yo soy el hijo 2, mi padre es PID = %d, yo soy PID = %d\n", getppid(), getpid());
                exit(0);
            }
        } else {
            //El padre no hace nada, espera a que finalicen los hijos
            wait(NULL);
        }
    }
    //Finaliza el padre
    exit(0);
}