#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sched.h>
#include <sys/wait.h>

int main()
{
    pid_t pid;

    for(int i = 1; i <= 3; i++)
    {
        switch(pid = fork())
        {
            case 0:
                printf("Soy el hijo %d, Mi padre es %d y mi PID es %d\n", i, getppid(), getpid());
                exit(0);
                break;
            case -1:
                printf("No se ha podido crear el proceso.");
                exit(-1);
                break;
            default:
                wait(NULL);
                break;
        }
    }

    printf("Proceso padre %d", getpid());
    exit(0);
}