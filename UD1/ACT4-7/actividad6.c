#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sched.h>
#include <sys/wait.h>

int main()
{
    int pid, pid1, pid2;
  
    pid = fork();
  
    if(pid == 0)
    {
        printf("Yo soy el hijo 1, mi padre es PID = %d, yo soy PID = %d\n", getppid(), getpid());
        exit(0);
    } else {
        pid1 = fork();

        if(pid1 == 0)
        {
            pid2 = fork();

            if(pid2 == 0) {
                printf("Yo soy el hijo 3, mi padre es PID = %d, yo soy PID = %d\n", getppid(), getpid());
                exit(0);
            } else {
                wait(NULL);
                printf("Yo soy el hijo 2, mi padre es PID = %d, yo soy PID = %d\n", getppid(), getpid());
                exit(0);
            }
        } else {
            wait(NULL);
        }
    }
    exit(0);
}